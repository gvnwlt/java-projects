package amht.planner;

import armadillo.behavior.DrivingBehave;
import armadillo.behavior.EnterZoneBehave;
import armadillo.behavior.IntersectionBehave;
import armadillo.behavior.SendMessageBehave;
import armadillo.behavior.SendUDPMessageBehave;
import armadillo.behavior.TurnSignalBehave;
import armadillo.behavior.UTurnBehave;
import armadillo.behavior.WatchBehave;
import armadillo.interfaces.NodePredicate;
import armadillo.simulation.TrackPlotter;
import jaus.ExtendedWaypoint;
import jaus.JausComponent;
//import jaus.MissionPlan;
import jaus.MissionSegment;
import java.awt.Color;
import java.io.BufferedWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import openjaus.libjaus.message.experimental.LaneChangeMessage;
import openjaus.libjaus.message.experimental.SafetyZoneMessage;
import rndf.Checkpoint;
import rndf.Exit;
import rndf.Intersection;
import rndf.Lane;
import rndf.MDF;
import rndf.Perimeter;
import rndf.PointID;
import rndf.RNDF;
import rndf.Segment;
import rndf.Spot;
import rndf.Waypoint;
import rndf.Zone;
import util.AStarSearch;
import util.Constants;
import util.CyberMath;
import util.LLAPosition;
import util.SearchNode;
import java.util.Properties; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileWriter;


        





public class MissionPlanner
{

  final double ANGLE_THRESHOLD_FOR_ENFORCING_STRAIGHT_EGRESS = 40.0; // degrees
  static final Logger log = Logger.getLogger(MissionPlanner.class.getName());
  MDF m_mission;
  private static double MINIMUM_TURNING_RADIUS_METERS = 15;

  public MissionPlanner(MDF mission)
  {
    m_mission = mission;
    m_nodes = new HashMap<PointID, WaypointSearchNode>();
    populateMapFromMission();
  }
  Map<PointID, WaypointSearchNode> m_nodes;

  void populateNeighborsFromZone(Zone zone)
  {
    // Entry points for each spot connect to their checkpoint.
        /*
     for (Iterator<Spot> i = zone.getSpots().iterator(); i.hasNext(); )
     {
     Spot s = i.next();
     Waypoint entry = s.getWaypoints().get(0);
     WaypointSearchNode ewsn = m_nodes.get(entry.getID());
     if (ewsn == null) {
     ewsn = new WaypointSearchNode(entry.getID());
     m_nodes.put(entry.getID(), ewsn);
     }
     Waypoint cp = s.getWaypoints().get(1);
     ewsn.addNeighbor(cp.getID());
     }
     */
    // Perimeter points connect to the interior points and to every exit.
    Perimeter p = zone.getPerimeter();
    for (Iterator<Waypoint> j = p.getWaypoints().iterator(); j.hasNext();)
    {
      Waypoint pp = j.next();
      WaypointSearchNode ppn = m_nodes.get(pp.getID());
      if (ppn == null)
      {
        ppn = new WaypointSearchNode(pp.getID());
        m_nodes.put(pp.getID(), ppn);
      }

      // Perimeter points that are exits do not connect to the interior of the zone at all.
      if (m_mission.getRNDF().isExit(pp.getID()))
      {
        continue;
      }

      for (Iterator<Spot> k = zone.getSpots().iterator(); k.hasNext();)
      {
        Spot s = k.next();
        Waypoint entry = s.getWaypoints().get(0);
        // Attach perimeter to entry point of spot
        ppn.addNeighbor(entry.getID());
        WaypointSearchNode ewsn = m_nodes.get(entry.getID());
        if (ewsn == null)
        {
          ewsn = new WaypointSearchNode(entry.getID());
          m_nodes.put(entry.getID(), ewsn);
        }
        // Attach entry point of spot to perimeter
        ewsn.addNeighbor(pp.getID());

        Waypoint exit = s.getWaypoints().get(1);
        WaypointSearchNode xwsn = m_nodes.get(exit.getID());
        if (xwsn == null)
        {
          xwsn = new WaypointSearchNode(exit.getID());
          m_nodes.put(exit.getID(), xwsn);
        }
        // Attach entry point of spot to its CP.
        ewsn.addNeighbor(xwsn.getWaypoint());

        // Attach CP of spot to the perimeter
        xwsn.addNeighbor(ppn.getWaypoint());
      }

      // Attach all exits as neighbors of pp
      for (Iterator<Waypoint> i = p.getWaypoints().iterator(); i.hasNext();)
      {
        Waypoint otherPP = i.next();
        if (otherPP != pp)
        {
          if (m_mission.getRNDF().isExit(otherPP.getID()))
          {
            ppn.addNeighbor(otherPP.getID());
          }
        }
      }
    }
  }

  void populateMapFromMission()
  {
    RNDF rndf = m_mission.getRNDF();

    for (Iterator<Waypoint> i = m_mission.getRNDF().getWaypoints().iterator();
            i.hasNext();)
    {
      Waypoint wp = i.next();
      WaypointSearchNode node = m_nodes.get(wp.getID());
      if (node == null)
      {
        node = new WaypointSearchNode(wp.getID());
        m_nodes.put(wp.getID(), node);
      }

      // Populated node's neighbor list
      if (rndf.isExit(wp.getID()))
      {
        // Need to add all the entry nodes as neighbors
        for (Iterator<Exit> j = rndf.getExits().iterator(); j.hasNext();)
        {
          Exit x = j.next();
          if (x.getExitPoint().equals(wp.getID()))
          {
            node.addNeighbor(x.getEntryPoint());
          }
        }
      }

      // Need to get the node after this one as a neighbor
      Segment seg = rndf.getSegment(wp.getID().getSegment());
      if (seg != null)
      {
        PointID neighborID = new PointID(wp.getID());
        neighborID.setWaypoint(neighborID.getWaypoint() + 1);
        Waypoint p = rndf.getWaypoint(neighborID);
        if (p != null)
        {
          node.addNeighbor(p.getID());
        }

        // Also add as neighbors the nearest points in front of this guy in the other
        // lanes in the same direction as this lane.
        // But only if no solid line is crossed to get there.
        Lane myLane = seg.getLane(wp.getID());
        List<Lane> lanesToLeft = rndf.lanesToTheLeft(wp.getID(), true);
        List<Lane> lanesToRight = rndf.lanesToTheRight(wp.getID());

        double laneHeading = rndf.getHeadingForPoint(wp.getID());
        LLAPosition llawp = new LLAPosition(wp.getLatitude(), wp.getLongitude());
        for (Iterator<Lane> lanes = seg.getLanes().iterator(); lanes.hasNext();)
        {
          Lane lane = lanes.next();
          int laneDifference = Math.abs(lane.getID().getLane() - myLane.getID().getLane());
          if (laneDifference != 1)
          {
            continue; // Lane changes are for exactly 1 lane away.
          }                    // Also, don't allow crossing a solid line
          if (lanesToLeft.contains(lane))
          {
            // The lane we are considering is to the left.  Check left boundary.
            if (myLane.getLeftBoundary() != null && myLane.getLeftBoundary().isSolid())
            {
              // No crossie de solid line
              continue;
            }
          }
          else
          {
            if (lanesToRight.contains(lane))
            {
              // The lane we are considering is to the right.  Check right boundary.
              if (myLane.getRightBoundary() != null && myLane.getRightBoundary().isSolid())
              {
                // No crossie de solid line
                continue;
              }
            }
          }
          Waypoint nearestPointInOtherLane = null;
          double nearestPointDistance = Double.MAX_VALUE;
          for (Iterator<Waypoint> lanePts = lane.getWaypoints().iterator(); lanePts.hasNext();)
          {
            Waypoint lp = lanePts.next();
            LLAPosition llalp = new LLAPosition(lp.getLatitude(), lp.getLongitude());
            double headingToPoint = llawp.angleInRadians(llalp);
            double headingDiff = Math.abs(CyberMath.getAngleError(laneHeading, headingToPoint));

            double ptDistance = CyberMath.getDistanceMetersFromLatLon(wp.getLatitude(), wp.getLongitude(),
                    lp.getLatitude(), lp.getLongitude());
            // remember points that are not behind me but are the closest otherwise.
            if (headingDiff < Math.toRadians(70) && ptDistance < nearestPointDistance)
            {
              nearestPointInOtherLane = lp;
              nearestPointDistance = ptDistance;
            }
          }

          // nearestPointInOtherLane is the nearest point that we might change lanes to.
          // Make sure it is not null, and also that it is in roughly the same direction
          // as the current point.
          if (nearestPointInOtherLane != null)
          {
            double nearestHeading = rndf.getHeadingForPoint(nearestPointInOtherLane.getID());
            double headingDiff = Math.abs(CyberMath.getAngleError(nearestHeading, laneHeading));
            if (headingDiff <= Math.toRadians(60))
            {
              // We can change lanes to this point.  Add it as a neighbor.
              node.addNeighbor(nearestPointInOtherLane.getID());
            }
          }
        }
      }
      else
      {
        // Must be a Zone.  Ignore it for now.  Zones are handled differently.
      }
    } // Outer loop.

    for (Iterator<Zone> zones = rndf.getZones().iterator(); zones.hasNext();)
    {
      Zone z = zones.next();
      this.populateNeighborsFromZone(z);
    }
  }

  class WaypointSearchNode extends SearchNode
  {

    public final static double UTURN_COST = 100000;
    public final static double CHANGE_LANE_COST = 100;
    PointID m_wp;
    List<WaypointSearchNode> m_neighbors;

    WaypointSearchNode(PointID wp)
    {
      m_wp = wp;
      m_neighbors = new Vector<WaypointSearchNode>();
    }

    public String toString()
    {
      return "node " + m_wp.toString() + " " + super.toString();
    }

    public PointID getWaypoint()
    {
      return m_wp;
    }

    void addNeighbor(PointID wp)
    {
      // If this relationship is specifically blocked by the mission, then do nothing.
      if (m_mission.isBlocked(this.m_wp, wp))
      {
        log.log(Level.WARNING, "Not adding " + wp + " as a neighbor of " + m_wp + " because it is blocked.");
      }
      else
      {
        WaypointSearchNode node = m_nodes.get(wp);
        if (node == null)
        {
          node = new WaypointSearchNode(wp);
          m_nodes.put(wp, node);
        }

        if (!m_neighbors.contains(node))
        {
          log.log(Level.INFO, "Adding neighbor " + wp + " to " + m_wp);
          if (TrackPlotter.getInstance(false) != null)
          {
            Waypoint wp0 = m_mission.getRNDF().getWaypoint(wp);
            LLAPosition pos = new LLAPosition(wp0.getLatitude(), wp0.getLongitude(), 0.0);
            TrackPlotter.getInstance(false).addWaypoint(pos, Color.MAGENTA);
          }
          m_neighbors.add(node);
        }
        else
        {
          log.log(Level.WARNING, "Not adding duplicate neighbor " + wp + " to " + m_wp);
        }
      }
    }

    public List<SearchNode> getNeighbors()
    {
      return new Vector<SearchNode>(m_neighbors);
    }

    public double getCost(SearchNode node)
    {
      double cost = 0;

      // The cost is the time it would take to get to the new node from this one.
      WaypointSearchNode wpsn = (WaypointSearchNode) node;
      Waypoint wp1 = m_mission.getRNDF().getWaypoint(this.getWaypoint());
      Waypoint wp2 = m_mission.getRNDF().getWaypoint(wpsn.getWaypoint());
      double distance = Math.sqrt((wp2.getLatitude() - wp1.getLatitude())
              * (wp2.getLatitude() - wp1.getLatitude())
              + (wp2.getLongitude() - wp1.getLongitude())
              * (wp2.getLongitude() - wp1.getLongitude()));
      distance *= CyberMath.METERS_PER_DEGREELAT; // convert distance to meters

      int segID = wp1.getID().getSegment();
      double avgSpeedMPH = 0.001;

      if (wp2.getID().getSegment() == segID)
      {
        // Both waypoints are in the same segment.
        if (wp2.getID().getLane() != wp1.getID().getLane())
        {
          // If they are in different lanes, and wp1 is an exit, then this is a U-Turn,
          // which invokes a penalty distance.
          if (m_mission.getRNDF().isExit(wp1.getID()))
          {
            distance += UTURN_COST;
            avgSpeedMPH = 0.5;
          }
          else
          {
            // If they are in different lanes but wp1 is not an exit, then
            // this is a lane-change, which incurs a slight cost to keep the
            // van from changing lanes needlessly.
            distance += wp1.getID().getWaypoint() * CHANGE_LANE_COST;
          }
        }
      }

      // Use the average of the speed limits of the segment as the speed.
      Segment seg = m_mission.getRNDF().getSegment(segID);
      if (seg != null)
      {
        avgSpeedMPH = (seg.getMinSpeedMPH() + seg.getMaxSpeedMPH()) / 2.0;
      }
      else
      {
        // Must be a zone.  Can't cut through it.
        avgSpeedMPH = (m_mission.getRNDF().getZoneMinSpeedLimit()+ m_mission.getRNDF().getZoneMaxSpeedLimit()) / 2.0;
      }

      double avgSpeedMetersPerSecond = CyberMath.toMPS(avgSpeedMPH);
      cost += distance / avgSpeedMetersPerSecond;

      log.log(Level.INFO, "Node " + wpsn.m_wp + " distance = " + ((int) distance)
              + " avg speed = " + avgSpeedMPH + " cost = " + cost);

      return cost;
    }

    public boolean equals(Object o)
    {
      boolean rc = false;
      if (o.getClass() == this.getClass())
      {
        WaypointSearchNode other = (WaypointSearchNode) o;
        rc = (other.m_wp.equals(this.m_wp));
      }
      return rc;
    }

    public Iterator<SearchNode> neighborsIterator()
    {
      return new Vector<SearchNode>(m_neighbors).iterator();
    }

    public double getEstimatedCost(SearchNode node)
    {
      return 0;
    }
  }

  static class AtGoalPredicate implements NodePredicate
  {

    WaypointSearchNode m_goal;

    public AtGoalPredicate(WaypointSearchNode goal)
    {
      m_goal = goal;
    }

    public boolean test(SearchNode node)
    {
      boolean rc = false;

      if (node instanceof WaypointSearchNode)
      {
        rc = ((WaypointSearchNode) node).equals(m_goal);
      }

      return rc;
    }
  }

  PointID findPreviousPointByDistance(List<SearchNode> list, ListIterator<SearchNode> fromItr, double distanceInMeters)
  {
    WaypointSearchNode node = (WaypointSearchNode) fromItr.previous();
    fromItr.next();
    PointID fromID = node.getWaypoint();
    PointID rc = node.getWaypoint();
    RNDF rndf = m_mission.getRNDF();
    Waypoint from = rndf.getWaypoint(rc);
    log.log(Level.INFO, "Looking for point " + distanceInMeters + " in front of " + fromID);
    if (fromItr.hasPrevious())
    {
      log.log(Level.INFO, "fromItr.previousIndex = " + fromItr.previousIndex());
      for (ListIterator<SearchNode> i = list.listIterator(fromItr.previousIndex()); i.hasPrevious();)
      {
        node = (WaypointSearchNode) i.previous();
        Waypoint to = rndf.getWaypoint(node.getWaypoint());
        rc = to.getID();
        double d = CyberMath.METERS_PER_DEGREELAT * CyberMath.getDistanceLatLon(from.getLatitude(), from.getLongitude(),
                to.getLatitude(), to.getLongitude());
        log.log(Level.INFO, "node " + node.getWaypoint() + " is " + d + " meters from " + fromID);
        if (d > distanceInMeters)
        {
          // Stop looking back when we get to the appropriate distance
          break;
        }
      }
    }

    log.log(Level.INFO, "Point " + rc + " is just within " + distanceInMeters + " meters from " + fromID);
    return new PointID(rc);
  }

  public MissionPlan replan(double startingLat, double startingLon, double fromHeading, double headingTolerance, List<Checkpoint> remainingCheckpoints)
  {
    MissionPlan mp = new MissionPlan(m_mission);
    RNDF rndf = m_mission.getRNDF();

    List<Checkpoint> cps = remainingCheckpoints;
    log.warning("Checkpoints: " + cps);
    PointID last = null;
    ListIterator<Checkpoint> i = cps.listIterator();
    Waypoint startWaypoint = rndf.getNearestWaypoint(startingLat, startingLon, fromHeading, headingTolerance);
    if (startWaypoint == null)
    {
      log.log(Level.SEVERE, "There is no starting waypoint for lat=" + startingLat + " lon=" + startingLon + " and heading " + fromHeading);
      log.log(Level.SEVERE, "Aborting.");
      System.out.println("There is no starting waypoint for lat=" + startingLat + " lon=" + startingLon + " and heading " + fromHeading);
      System.out.println("Aborting.");
      //System.exit(8);
    }
    PointID start = startWaypoint.getID();
    while (i.hasNext())
    {
      PointID end = i.next().getWaypoint();

      log.log(Level.INFO, "**** Planning from " + start + " to " + end + "****");

      AStarSearch searcher = new AStarSearch();
      WaypointSearchNode startNode = m_nodes.get(start);
      WaypointSearchNode endNode = m_nodes.get(end);

      List<SearchNode> path = searcher.search(startNode, new AtGoalPredicate(endNode));

      if (path == null)
      {
        log.log(Level.SEVERE, "There is no path from " + start + " to " + end);
        if (m_mission.numberOfBlockages() > 0)
        {
          log.log(Level.SEVERE, "Clearing " + m_mission.numberOfBlockages() + " blockages and trying again.");
          m_mission.clearBlockages();
          // Add in the missing neighbors
          populateMapFromMission();
          i.previous();
        }
        else
        {
          log.log(Level.SEVERE, "There are no blockages to clear.");
          log.log(Level.SEVERE, "Skipping checkpoint and planning to next one instead.");
        }
        // Note that we leave the start point the same.
      }
      else
      {
        // Create a mission segment for this segment of the mission
        MissionSegment mseg = new MissionSegment();
        path.add(0, startNode); // DO NOT COMMENT THIS OUT WITHOUT A FINE REASON

        // Generate a list of all the naive extended waypoints.
        ExtendedWaypoint lastWP = null;
        ExtendedWaypoint previousLastWP = null;
        ExtendedWaypoint realLastWP = null;
        ExtendedWaypoint realPrevLastWP = null;
        double lastHeading = 0;
        PointID originID = ((WaypointSearchNode) startNode).getWaypoint();
        double heading = rndf.getHeadingForPoint(originID);
        if (rndf.isZonePoint(((WaypointSearchNode) startNode).getWaypoint()))
        {
          if (rndf.isExit(originID))
          {
            // Make heading pointing out of zone
            heading = CyberMath.normalizeAngleNegPItoPI(heading + Math.toRadians(heading));
          }
          else
          {
            // Make heading pointing into zone
            heading = CyberMath.normalizeAngleNegPItoPI(heading + Math.toRadians(heading));
          }
        }

        for (ListIterator<SearchNode> j = path.listIterator(); j.hasNext();)
        {
          WaypointSearchNode node = (WaypointSearchNode) j.next();
          log.log(Level.INFO, "" + node.m_wp);
          Waypoint wp = rndf.getWaypoint(node.m_wp);
          ExtendedWaypoint cur = new ExtendedWaypoint();
          cur.latitude = wp.getLatitude();
          cur.longitude = wp.getLongitude();
          cur.setID(node.m_wp);
          cur.heading = rndf.getHeadingForPoint(wp.getID());
          log.log(Level.INFO, "Initial Heading for " + cur.getID() + " set to " + cur.heading);
          Segment containingSegment = rndf.getSegment(node.m_wp.getSegment());
          if (containingSegment == null)
          {
            // This "segment" must be in a parking lot.  get The speed from the RNDF Zone Min and Max Speed Limit
            cur.speed = Math.min(Constants.getInstance().MAX_SPEED, CyberMath.toMPS(rndf.getZoneMaxSpeedLimit()));
          }
          else
          {
            // This is a normal segment with a speed limit.
            cur.speed = Math.min(Constants.getInstance().MAX_SPEED, CyberMath.toMPS(containingSegment.getMaxSpeedMPH()));

            if (rndf.isStop(node.m_wp))
            {
              cur.speed = 0;
            }
          }

          if (!j.hasNext() && !i.hasNext())
          {
            // Set the speed for the last point in the entire mission to 0.
            cur.speed = 0;
          }

          boolean curInZone = rndf.isZonePoint(cur.getID());
          boolean lastInZone = (realLastWP != null);
          if (lastInZone)
          {
            lastInZone = rndf.isZonePoint(realLastWP.getID());
          }

          boolean curAndLastAreZone = curInZone && lastInZone;
          boolean prevLastInZone = (realPrevLastWP != null);
          if (prevLastInZone)
          {
            prevLastInZone = rndf.isZonePoint(realPrevLastWP.getID());
          }

          if (!prevLastInZone && curAndLastAreZone)
          {
            // last is the entry to a zone.
            log.log(Level.INFO, "Adding enter zone behavior to " + realLastWP);
            LLAPosition border = new LLAPosition(realLastWP.latitude, realLastWP.longitude);
            double fakeHeading = CyberMath.normalizeAngleNegPItoPI(rndf.getHeadingForPoint(realLastWP.getID(), true) + Math.toRadians(90));
            realLastWP.heading = fakeHeading;
            LLAPosition in = border.projectPointByHeadingAndDistance(fakeHeading, Constants.getInstance().CAR_LENGTH / 2);
            PointID fakeID = new PointID(realLastWP.getID());
            // Get rid of the odd steering singularity at the entrance.
            fakeID.setWaypoint(100);
            ExtendedWaypoint fake = new ExtendedWaypoint();
            fake.latitude = in.latitude;
            fake.longitude = in.longitude;
            fake.heading = fakeHeading;
            fake.speed = 0;
            fake.setID(fakeID);
            realLastWP.speed = CyberMath.toMPS(5);
            realLastWP.heading = fakeHeading;
            mseg.addWaypoint(fake);
            DrivingBehave enterZone = new EnterZoneBehave(); //rndf.getZone(wp.getID().getSegment()));
            mseg.addAssociatedBehavior(fake, enterZone);
            lastWP = null;
          }

          mseg.addWaypoint(cur);
          log.log(Level.INFO, "Waypoint added to path: " + cur.getID());

          if (lastWP != null)
          {
            heading = CyberMath.getBearingLatLon(lastWP.latitude, lastWP.longitude, cur.latitude, cur.longitude);
            log.log(Level.INFO, "Heading for " + lastWP.getID() + " set to " + heading);

            lastWP.heading = heading;

            if (rndf.isExit(lastWP.getID()))
            {
              // The cur waypoint is the one right after an exit,
              // and this is therefore after an intersection.

              // It's only a safety zone if it exits to a different segment
              Collection<Exit> exits = rndf.getExits(lastWP.getID());
              boolean exitToDifferentSegment = false;
              int howManySegmentsDoesExitGoTo = 0;
              Set<Integer> diffSegs = new HashSet<Integer>();
              for (Iterator<Exit> ex = exits.iterator(); ex.hasNext();)
              {
                Exit exit = ex.next();
                if (exit.getEntryPoint().getSegment() != lastWP.getID().getSegment())
                {
                  exitToDifferentSegment = true;
                  diffSegs.add(exit.getEntryPoint().getSegment());
                }
              }
              howManySegmentsDoesExitGoTo = diffSegs.size();

              if (exitToDifferentSegment)
              {

                if (howManySegmentsDoesExitGoTo > 0)
                {
                  // Add a note to the XWPD to signal non-passing behavior.
                  log.log(Level.INFO, "Adding enter safety zone behavior for " + lastWP.getID());
                  SafetyZoneMessage enterMsg = new SafetyZoneMessage();
                  enterMsg.setSubCommand(SafetyZoneMessage.ENTERING);
                  DrivingBehave enter = new SendMessageBehave(JausComponent.EXTENDED_WAYPOINT_DRIVER, enterMsg);
                  // Find the point previous to this more than 35 meters away.
                  // This makes us look prior to the previous point
                  j.previous();
                  PointID assocPointID = findPreviousPointByDistance(path, j, 35);
                  // And this puts the iterator back where it belongs
                  j.next();
                  log.log(Level.INFO, "Tying enter safety zone behavior to point " + assocPointID);
                  ExtendedWaypoint assocPoint = mseg.getWaypointByID(assocPointID);
                  mseg.addAssociatedBehavior(assocPoint, new WatchBehave(lastWP, 35.0, enter));
                  enter = new SendUDPMessageBehave(SendUDPMessageBehave.USE_CHANGE_DETECTION);
                  mseg.addAssociatedBehavior(lastWP, enter);

                  SafetyZoneMessage exitMsg = new SafetyZoneMessage();
                  exitMsg.setSubCommand(SafetyZoneMessage.EXITING);
                  DrivingBehave exit = new SendMessageBehave(JausComponent.EXTENDED_WAYPOINT_DRIVER, exitMsg);
                  DrivingBehave trigger = new WatchBehave(cur, 30.0, exit, false);
                  log.log(Level.INFO, "Adding exit safety zone behavior for " + lastWP.getID());
                  mseg.addAssociatedBehavior(lastWP, new WatchBehave(cur, 10.0, trigger));

                  exit = new SendUDPMessageBehave(SendUDPMessageBehave.USE_ROAD_FOLLOWING);
                  mseg.addAssociatedBehavior(cur, exit);
                }
              }
              else
              {
                // Same segment, not a different one.
                if (lastWP.getID().getLane() != cur.getID().getLane())
                {
                  log.log(Level.INFO, "Changing lanes.");
                  // Different lane in the same segment.  If the last point is an exit, then this is a U-Turn.
                  log.log(Level.INFO, "Adding U-Turn for point " + cur.getID());
                  // If there is enough room to just turn, then just do it.
                  double separationInMeters = CyberMath.getDistanceMetersFromLatLon(
                          cur.latitude, cur.longitude,
                          lastWP.latitude, lastWP.longitude);
                  if (separationInMeters < MINIMUM_TURNING_RADIUS_METERS)
                  {
                    log.log(Level.INFO, "Adding U-Turn behavior for point " + cur.getID());
                    // Yep, this is a U-Turn.  Add the behavior
                    mseg.addAssociatedBehavior(cur, new UTurnBehave());
                    // And set the speed limit on the points to SLOW
                    cur.speed = CyberMath.toMPS(3);
                    lastWP.speed = CyberMath.toMPS(0);
                    //                                lastWP.heading = rndf.getHeadingForPoint(lastWP.getID());
                    //                                previousLastWP = null;
                  }
                  else
                  {
                    log.log(Level.INFO, "Just slowing down for U-Turn at " + cur.getID());
                    lastWP.speed = CyberMath.toMPS(0);
                    mseg.addAssociatedBehavior(lastWP, new TurnSignalBehave(TurnSignalBehave.LEFT_SIGNAL, true));
                    mseg.addAssociatedBehavior(cur, new TurnSignalBehave(TurnSignalBehave.LEFT_SIGNAL, false));
                  }
                }
              }

              /* Very special case logic for an exit that is simply the stitching together of
               * 2 segments. */
              boolean simpleSegmentTransition = false;
              if (rndf.getExits(lastWP.getID()).size() == 1)
              {
                Iterator<Exit> exiti = rndf.getExits(lastWP.getID()).iterator();
                Exit myExit = exiti.next();
                if (rndf.getExitsTo(myExit.getEntryPoint()).size() == 1)
                {
                  if ((rndf.getNextWaypointInPath(lastWP.getID()) == null)
                          && (rndf.getPreviousWaypointInPath(cur.getID()) == null))
                  {
                    simpleSegmentTransition = true;
                  }
                }
              }

              if (rndf.isStop(lastWP.getID()))
              {
                log.log(Level.INFO, "Adding intersection behavior for " + lastWP.getID());
                lastWP.speed = 0;
                Intersection it = new Intersection(rndf, lastWP.getID());
                mseg.addAssociatedBehavior(cur, new IntersectionBehave(it));
              }
              else
              {
                if (simpleSegmentTransition)
                {
                  // Segment that meshes into another one should not be an intersection
                  // Do nothing
                  log.log(Level.INFO, "Exit from " + lastWP.getID() + " to " + cur.getID() + " does not deserve an intersection.");
                }
                else
                {
                  if (rndf.isExit(lastWP.getID())
                          && (howManySegmentsDoesExitGoTo > 0)
                          && (lastWP.getID().getSegment() != cur.getID().getSegment()))
                  {
                    // This is an intersection, but we don't have a stop sign.
                    // Treat it like an intersection only if we are turning left and there are
                    // opposing traffic lanes to the left of us.
                    double angleErrorDegrees = Math.toDegrees(
                            CyberMath.getAngleError(rndf.getHeadingForPoint(lastWP.getID()),
                            rndf.getHeadingForPoint(cur.getID())));
                    log.log(Level.INFO, "Turning " + angleErrorDegrees + " at a non-stopping intersection.");
                    boolean opposingTraffic = (rndf.getOpposingLanes(lastWP.getID()).size() > 0);
                    if (opposingTraffic && angleErrorDegrees < -45)
                    {
                      log.log(Level.INFO, "Adding intersection behavior at left turn at non-stopping point " + lastWP.getID());
                      Intersection it = new Intersection(rndf, lastWP.getID());
                      mseg.addAssociatedBehavior(cur, new IntersectionBehave(it));
                      lastWP.speed = 0;
                    }
                  }
                }
              }

              if (true || (realPrevLastWP != null)
                      || (rndf.isZonePoint(lastWP.getID())))
              {
                // We have a path we can tell how sharply we need to steer
                double angleErrorDegrees = 0;
                if (rndf.isZonePoint(lastWP.getID()))
                {
                  log.log(Level.INFO, "Thinking about " + cur.getID() + " and zone exit " + lastWP.getID() + " for turn signal.");
                  angleErrorDegrees = Math.toDegrees(
                          CyberMath.getAngleError(lastWP.heading, rndf.getHeadingForPoint(cur.getID())));
                }
                else
                {
                  log.log(Level.INFO, "Thinking about " + cur.getID() + " and " + lastWP.getID() + " for turn signal.");
                  angleErrorDegrees = Math.toDegrees(
                          CyberMath.getAngleError(lastWP.heading, rndf.getHeadingForPoint(cur.getID())));
                }
                log.log(Level.INFO, "Angle difference for turn: " + angleErrorDegrees);
                if (Math.abs(angleErrorDegrees) > 20)
                {
                  // Find the point previous to this more than 30 meters away.
                  PointID assocPointID = findPreviousPointByDistance(path, j, 30);
                  log.log(Level.INFO, "Tying turn signal behavior to point " + assocPointID);
                  ExtendedWaypoint assocPoint = mseg.getWaypointByID(assocPointID);
                  // Large turns mean we need to turn on the turn signal.
                  if (angleErrorDegrees > 0)
                  {
                    // Right hand turn
                    TurnSignalBehave on = new TurnSignalBehave(TurnSignalBehave.RIGHT_SIGNAL, true);
                    TurnSignalBehave off = new TurnSignalBehave(TurnSignalBehave.RIGHT_SIGNAL, false);
                    mseg.addAssociatedBehavior(assocPoint, new WatchBehave(realLastWP, 30.0, on));
                    log.log(Level.INFO, "Turn on Right signal when within 30m of " + realLastWP.getID());

                    mseg.addAssociatedBehavior(cur, new WatchBehave(cur, 2.0, off));
                    log.log(Level.INFO, "Turn off Right signal when within 2m of " + cur.getID());
                  }
                  else
                  {
                    // Left hand turn
                    TurnSignalBehave on = new TurnSignalBehave(TurnSignalBehave.LEFT_SIGNAL, true);
                    TurnSignalBehave off = new TurnSignalBehave(TurnSignalBehave.LEFT_SIGNAL, false);
                    mseg.addAssociatedBehavior(assocPoint, new WatchBehave(realLastWP, 30.0, on));
                    log.log(Level.INFO, "Turn on Left signal when within 30m of " + realLastWP.getID());

                    mseg.addAssociatedBehavior(cur, new WatchBehave(cur, 2.0, off));
                    log.log(Level.INFO, "Turn off Left signal when within 2m of " + cur.getID());
                  }
                }
              }
              else
              {
                log.log(Level.INFO, "Can't put on a turn signal behvior.");
              }

              if (previousLastWP != null)
              {
                lastWP.heading = previousLastWP.heading;
              }

              lastWP = null;
            }
            else
            {
              // Not an exit.
              if ((lastWP.getID().getLane() != cur.getID().getLane())
                      && (!rndf.isZonePoint(lastWP.getID()))
                      && (lastWP.getID().getSegment() == cur.getID().getSegment()))
              {
                // Different lane, same segment.  This is a lane change.
                // Are we going left or right?
                log.log(Level.INFO, "Added behaviors for a lane change.");
                LLAPosition lastLLA = new LLAPosition(lastWP.latitude, lastWP.longitude);
                LLAPosition curLLA = new LLAPosition(cur.latitude, cur.longitude);
                double shiftDistance = rndf.getLaneOffset(lastWP.getID(), cur.getID());
                double headingToPt = lastWP.heading;
                double laneHeading = rndf.getHeadingForPoint(lastWP.getID());
                double angleErr = CyberMath.getAngleError(laneHeading, headingToPt);
                log.log(Level.INFO, "Heading at last point: " + (int) Math.toDegrees(laneHeading));
                log.log(Level.INFO, "Heading to cur point: " + (int) Math.toDegrees(headingToPt));
                log.log(Level.INFO, "Angle Error: " + (int) Math.toDegrees(angleErr));
                int direction = 0;
                if (angleErr < 0)
                {
                  // Left Turn
                  log.log(Level.INFO, "Entering lane to the left.");
                  direction = TurnSignalBehave.LEFT_SIGNAL;
                  shiftDistance = -shiftDistance;
                }
                else
                {
                  // Right Turn
                  log.log(Level.INFO, "Entering lane to the right.");
                  direction = TurnSignalBehave.RIGHT_SIGNAL;
                }
                log.log(Level.INFO, "Lane offset in meters: " + shiftDistance);
                TurnSignalBehave on = new TurnSignalBehave(direction, true);
                TurnSignalBehave off = new TurnSignalBehave(direction, false);
                mseg.addAssociatedBehavior(lastWP, on);
                mseg.addAssociatedBehavior(cur, new WatchBehave(cur, 2.0, off));
                LaneChangeMessage lcm = new LaneChangeMessage();
                lcm.setLaneOffset(shiftDistance);
                DrivingBehave changeLanes = new SendMessageBehave(JausComponent.EXTENDED_WAYPOINT_DRIVER, lcm);
                mseg.addAssociatedBehavior(lastWP, changeLanes);
              }
              // use special heading rules for large turns that are not exits
              if (previousLastWP != null)
              {
                // We have a path we can tell how sharply we need to steer
                double angleErrorDegrees = Math.toDegrees(
                        CyberMath.getAngleError(previousLastWP.heading, heading));
                if (Math.abs(angleErrorDegrees) > ANGLE_THRESHOLD_FOR_ENFORCING_STRAIGHT_EGRESS)
                {
                  log.log(Level.INFO, "exceded AT angle=" + angleErrorDegrees + " ptID=" + lastWP.getID());
                  double newheading = CyberMath.getBearingLatLon(previousLastWP.latitude, previousLastWP.longitude,
                          lastWP.latitude, lastWP.longitude);
                  lastWP.heading = newheading;
                  previousLastWP = null;
                  lastWP = null;
                }
                else
                {
                  lastWP.heading = heading;
                  // Smooth the heading of the lastWP by averaging lastHeading and heading.
                  lastWP.heading =
                          CyberMath.normalizeAngleNegPItoPI(lastHeading
                          + CyberMath.getAngleError(lastHeading, heading) / 2);
                }
              }
            }

            lastHeading = heading;
            previousLastWP = lastWP;
          }

          lastWP = cur;
          realPrevLastWP = realLastWP;
          realLastWP = cur;
        }

        lastWP.heading = heading;

        // Go off and process the mission segments and ascribe behaviors to the points
        // ...
        log.log(Level.INFO, "Adding segment + " + mseg + " to mission plan.");
        // Now add the completed mission segment to the mission plan.
        mp.addMissionSegment(mseg);

        // Plan from the end of this segment.
        start = end;
      }
    }

    return mp;
  }

  public MissionPlan replan(double vehicleLat, double vehicleLon)
  {
    return replan(vehicleLat, vehicleLon, 0.0, Math.toRadians(180.0), 0);
  }

  public MissionPlan replan(double vehicleLat, double vehicleLon, double vehicleHeading, double headingTolerance, int checkpointsPassed)
  {
    RNDF rndf = m_mission.getRNDF();

    List<Checkpoint> cps = new Vector<Checkpoint>();
    cps.addAll(m_mission.getCheckpoints());
    for (int i = 0; i < checkpointsPassed; ++i)
    {
      cps.remove(0);
    }
    PointID last = null;
    return replan(vehicleLat, vehicleLon, vehicleHeading, headingTolerance, cps);
  }

  public MissionPlan plan()
  {
    RNDF rndf = m_mission.getRNDF(); 
    List<Checkpoint> cps = m_mission.getCheckpoints();
    PointID last = null;
    PointID start = cps.get(0).getWaypoint();
    log.log(Level.INFO, "Planning from start point " + start);
// Why would we remove this?    
    cps.remove(0);
    Waypoint startWP = rndf.getWaypoint(start);
    double lat = startWP.getLatitude();
    double lon = startWP.getLongitude();
    log.log(Level.INFO, "Planning from " + lat + ", " + lon);
    return replan(lat, lon, 0, Math.toRadians(180.0), cps);
  }

  public void doIntersectionStuff(PointID myStop)
  {
    RNDF rndf = m_mission.getRNDF();

    // Is this stop-point part of a multi-way stop?

    // Multi-way
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    // Getting the file name to be parsed from this hardcoded file path or from the argument at the command line. 
    String fileName = "/home/amht/CSC506/Software/AMHT/ConfigData/Missions/roadPlanning/around.xml";

    if (args.length > 0)
    {
      fileName = args[0];  

    }

    try
    {
      //New section to parse xml 
      Properties prop = new Properties(); 
      prop.loadFromXML(new FileInputStream(fileName)); 
      String propertyToBeGotten = prop.getProperty("armadillo.mdf.file");
      // Feeds this parsed xml back into fileName. The parsed out thing is 
      // an MDF which is then stripped by the rest of this program to generate 
      // an RNDF. 
      fileName = propertyToBeGotten; 
      
      log.log(Level.INFO, "Reading mission from " + fileName);
      MDF mission = MDF.readFromFile(fileName);
      RNDF.setGlobalRNDF(mission.getRNDF());
      // log.log(Level.INFO, "Adding a blockage");
      // mission.addBlockage(new PointID("1.1.9"), new PointID("1.1.10"));
      log.log(Level.INFO, "Making a planner");// DOES NOT EXECUTE
      System.out.println("Making a planner"); // DELETE
      MissionPlanner p = new MissionPlanner(mission);
      log.log(Level.INFO, "Planning...");
      MissionPlan plan = p.plan(); 
      
      BufferedWriter out = new BufferedWriter(new FileWriter("/home/amht/amht/ConfigData/Missions/MissionPlanner.txt")); 
      out.write(plan.dump()); 
      out.close();
    }
    catch (Exception x)
    {
      log.log(Level.SEVERE, "Error: " + x, x);
    }

  }
}
