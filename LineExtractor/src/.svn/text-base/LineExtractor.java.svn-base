/******************************************************************

Copyright (C) 2013 Cybernet Systems Corporation

Government Use Rights

This software was developed under contract W15QKN-10-C-0121.

The United States Government has the non-exclusive right to use
and distribute this source code and derivative works for any
purpose whatsoever.

******************************************************************/
//package com.cybernet.amht.util;

import java.util.*;

public class LineExtractor  {
    private static final Double DEFAULT_ANGLESTEP_DEGREES = 0.25;
    private double minDivergenceAngleRadians = 0.1415;

    protected List<Point> pointBag;
    protected double epsilon;
    protected double alpha;
    protected Point origin;

    protected List<Line> getInitialLines()
    {
      List<Line> lines = new ArrayList<Line>();

      Line line = new Line();

      ListIterator<Point> it = pointBag.listIterator();
      //for(list<Point>::iterator it = pointBag.begin(); it != pointBag.end(); ++it)
      while(it.hasNext())
      {
        Point temp = it.next();
        // If the point is invalid, we're done with the current line.
        if (temp.r() < 10 || temp.r() >= 30000) {
          // If the current line is valid, then keep it in the return list.
          if (line.pointCount() > 1) {
            lines.add(line);
          }

          // Re-use the line structure
          line.removeAllPoints();
        }
        else {
          // Valid point.  Add it to the current line.
          line.addPointSorted(temp);
        }
      }

      // If the final line is valid, add it too.
      if (line.pointCount() > 1)  {
        lines.add(line);
      }

      return lines;
    }

    protected List<Line> discardRadials(List<Line> lines, double minDivergenceAngleRadians)
    {
        List<Line> newLines = new ArrayList<Line>();
        ListIterator<Line> it = lines.listIterator();
        while(it.hasNext())
        {
            Line temp = it.next();
            if (temp.points.size() < 2) continue;
            Point P1 = temp.getRawStartPoint();
            Point P2 = temp.getRawEndPoint();
            Point Pm = new Point(true, (P1.x()+P2.x())/2, (P1.y()+P2.y())/2);

            double dot = (P2.x()-P1.x())*(Pm.x()-origin.x()) + (P2.y()-P1.y())*(Pm.y() - origin.y());
            double lineLength = P1.distance(P2);
            double xLen = Pm.x()-origin.x();
            double yLen = Pm.y()-origin.y();
            double radialLength = Math.sqrt(xLen*xLen + yLen*yLen);

            double normDot = dot/(lineLength*radialLength);

            double paralellness = Math.cos(minDivergenceAngleRadians);

            if (Math.abs(normDot) <= paralellness)
            {
               if (temp.pointCount() > 1)
               {
                 newLines.add(temp);
               }
            }
            else if ((lineLength / temp.pointCount()) < 30000*Math.toRadians(DEFAULT_ANGLESTEP_DEGREES))
            {
              newLines.add(temp);
            }
        }
        return newLines;
    }

    public LineExtractor(List<Point> points, double epsilon,
            double scanIncrementRadians, Point origin)
    {
        pointBag = points;
        this.epsilon = epsilon;
        alpha = scanIncrementRadians;
        this.origin = origin;
    }

    public List<Line> extractLines(List<Point> cartesianPoints, double epsilonMM)
    {
        Line.resetNextLineId(1); //Extended Line to fix this issue

        List<Line> lines = getInitialLines();

          double myEpsilon = 0;
          if(epsilon <= 0)
          {
              myEpsilon = epsilon;
          }
          else
          {
              myEpsilon = epsilonMM;
          }

          boolean splitSomething = false;

          int loopCount = 0;
          int maxIterations = pointBag.size();

          do
          {
            List<Line> newLines = new ArrayList<Line>();

            splitSomething = false;
            System.out.println("Looking thru " + Double.toString(lines.size()) + " lines to find split places.");
            //for(vector<Line>::iterator it = lines.begin(); it != lines.end(); ++it)
            ListIterator<Line> it = lines.listIterator();
            while(it.hasNext())
            {
              //list<Point>::iterator farthestPoint = it->getFarthestPointRaw(outSqDistance);
              Line temp = it.next();
              if (temp.points.size() < 2) {
                continue;
              }
              System.out.println("Line " + temp);
              Point farthestPoint = temp.getFarthestPointRaw();
              double outSqDistance = temp.perpendicularSqDistanceToRaw(farthestPoint);

              if (temp.isStartPoint(farthestPoint) && temp.pointCount() > 2)
              {
                //AMHT_TRACE("Removing start point of line with %d points", it->pointCount());
                temp.removeStartPoint();
                //AMHT_TRACE("After removing start point, line has %d points", it->pointCount());
                splitSomething = true;
              }
              else if (temp.isEndPoint(farthestPoint) && temp.pointCount() > 2)
              {
                //AMHT_TRACE("Removing end point of line with %d points", it->pointCount());
                temp.removeEndPoint();
                //AMHT_TRACE("After removing end point, line has %d points", it->pointCount());
                splitSomething = true;
              }
              else if (outSqDistance > myEpsilon && temp.pointCount() > 2)//max(myEpsilon, farthestPoint->r()*alpha))
              {
                //AMHT_TRACE("Splitting line with %d points", it->pointCount());
                Line newLine = temp.splitAtPoint(farthestPoint);
                //AMHT_TRACE("After split, old line had %d points, new line has %d points", it->pointCount(), newLine.pointCount());
                newLines.add(newLine);
                splitSomething = true;
              }
            }

            //lines.insert(lines.end(), newLines.begin(), newLines.end());
            lines.addAll(newLines);
            System.out.println("Done with this pass. newLines has " + newLines.size() + " lines in it. splitSomething = " + splitSomething);
          }
          while(splitSomething && ++loopCount < maxIterations);

          //AMHT_ASSERT(loopCount < maxIterations, "didn't loop too much");
          if(loopCount < maxIterations)
          {
              System.out.println("didn't loop too much");
          }

          lines = discardRadials(lines, minDivergenceAngleRadians);

          return lines;
    }

//    public static void main(String[] args)
//    {
//        List<Point> points = new ArrayList<Point>();
//        points.add(new Point(true, 2, 5));
//        points.add(new Point(true, 3, 7));
//        points.add(new Point(true, 3.2, 7.1));
//        points.add(new Point(true, 400, 500));
//        points.add(new Point(true, 401, 501));
//        points.add(new Point(true, 213, 347));
//        Point origin = new Point(true, 0, 0);
//        LineExtractor extractor = new LineExtractor(points, Math.PI, Math.PI/8, origin);
//
////        List<Line> initial = extractor.getInitialLines();
////        for(int a = 0; a < initial.size(); a++)
////        {
////            Line tempLine = initial.get(a);
////            List<Double> coord = tempLine.getDirectionVector();
////            System.out.println("Initial line " + Integer.toString(a) + " vector, x: " + Double.toString(coord.get(0)) + " y: " + Double.toString(coord.get(1)));
////        }
////        System.out.println();
//
//        List<Line> extraction = extractor.extractLines(points, 2);
//        for(int a = 0; a < extraction.size(); a++)
//        {
//            Line tempLine = extraction.get(a);
//            List<Double> coord = tempLine.getDirectionVector();
//            System.out.println("Extracted line " + Integer.toString(a) + " vector, x: " + Double.toString(coord.get(0)) + " y: " + Double.toString(coord.get(1)));
//        }
//        System.out.println();
//
////        List<Line> discard = extractor.discardRadials(extraction, Math.PI/6);
////        for(int a = 0; a < discard.size(); a++)
////        {
////            Line tempLine = discard.get(a);
////            List<Double> coord = tempLine.getDirectionVector();
////            System.out.println("After discard, line " + Integer.toString(a) + " vector, x: " + Double.toString(coord.get(0)) + " y: " + Double.toString(coord.get(1)));
////        }
//    }
}
