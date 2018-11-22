package amht.planner;
/* This is a copy of the MissionPlan source file that is compiled in the Mission Manager 
   jar file. Once changes made here are satisfactory, they need to be tranferred over to
   the orignal MissionPlan source file and recompiled into the MissionManager jar file. 
*/
import armadillo.behavior.DrivingBehave;
import rndf.MDF;
import rndf.RNDF;
import java.util.*;
import java.util.logging.*;
import jaus.MissionSegment; 
import jaus.ExtendedWaypoint;


public class MissionPlan
{

  static Logger log = Logger.getLogger(MissionPlan.class.getName());
  List<MissionSegment> m_segments;
  MDF m_mission;
  int m_segmentIndex;

  public MDF getMDF()
  {
    return m_mission;
  }

  public RNDF getRNDF()
  {
    return m_mission.getRNDF();
  }
  
  public MissionPlan(MDF mission)
  {
    m_mission = mission;
    m_segments = new Vector<MissionSegment>();
    m_segmentIndex = 0;
  }

  public void addMissionSegment(MissionSegment seg)
  { 
    m_segments.add(seg);
  }

  public void replaceMissionSegment(MissionSegment oldSeg, MissionSegment newSeg)
  {
    for (int i = 0; i < m_segments.size(); ++i)
    {
      MissionSegment seg = m_segments.get(i);
      if (seg == oldSeg)
      {
        m_segments.remove(i);
        m_segments.add(i, newSeg);
        break;
      }
    }
  }

  public void resetSegmentIndex()
  { 
    m_segmentIndex = 0;
  }

  public String dump() 
  { 
    String dump = "GPDrive "; 
    int counter = 0; 
    log.log(Level.INFO, "Here is the m_segments size--> " + m_segments.size() );
    resetSegmentIndex();
    for (MissionSegment seg = getCurrentSegment(); seg != null; seg = getNextSegment())
    { 
      seg.resetWaypointIndex();
      // For each segment in the plan...
      for (ExtendedWaypoint xwp = seg.getNextWaypoint(); xwp != null; xwp = seg.getNextWaypoint())
      {
        log.log(Level.INFO, "Next waypoint: " + xwp.getID());
        if (counter < 10)
        {
        dump += xwp.latitude + " " + xwp.longitude + " " + xwp.heading + " ";  
        } else {
            dump += "\nGPSDrive " + xwp.latitude + " " + xwp.longitude + " " + xwp.heading + " ";
            counter = 0; 
        }
        counter++;
        List<DrivingBehave> bh = seg.getAssociatedBehaviors(xwp);
        if (bh != null)
        {
          log.log(Level.INFO, "Associated behaviors: ");
          for (Iterator<DrivingBehave> bi = bh.iterator(); bi.hasNext();)
          {
            log.log(Level.INFO, " *** " + bi.next());
          }
        }
      }

      seg.resetWaypointIndex();
    }
      
    resetSegmentIndex();
    return dump; 
  }

  public List<ExtendedWaypoint> getWaypointList()
  {
    List<ExtendedWaypoint> rc = new Vector<ExtendedWaypoint>();
    for (Iterator<MissionSegment> i = m_segments.iterator(); i.hasNext();)
    {
      MissionSegment seg = i.next();
      rc.addAll(seg.getWaypointList());
    }
    return rc;
  }

  public List<ExtendedWaypoint> getRemainingWaypoints()
  {
    List<ExtendedWaypoint> rc = new Vector<ExtendedWaypoint>();
    for (Iterator<MissionSegment> i = m_segments.listIterator(m_segmentIndex); i.hasNext();)
    {
      MissionSegment seg = i.next();
      rc.addAll(seg.getRemainingWaypoints());
    }

    return rc;
  }

  public MissionSegment getCurrentSegment()
  {
    if (m_segmentIndex < m_segments.size())
    {
      return m_segments.get(m_segmentIndex);
    }

    return null;
  }

  public MissionSegment getNextSegment()
  {

    if ((m_segmentIndex + 1) < m_segments.size())
    {
      return m_segments.get(++m_segmentIndex);
    }
    else
    {
      m_segmentIndex = m_segments.size();
    }

    return null;
  }
}
