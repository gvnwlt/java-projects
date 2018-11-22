package frontiersearch;

import java.util.ArrayList; 

/*  
A Node has: 
-some contents. 
-a List of other connected nodes
It can: 
-search all of its descendent Nodes to find a solution
-search algorithm as a class method 
*/
public class Node {
    
    String contents; 
    ArrayList<Node> children; 
    
    /* Constructor */ 
    public Node(String c) { 
        this.contents = c;
        this.children = new ArrayList<Node>(); 
    }
    
       /*
    Main algorithm: 
    Input:
    -a goal query 
    <has the same data type as node contents> 
    -a Starting Node 
    Output:
    -a Path from start to Goal(a List of Nodes) 
    (multiple output types not acceptable in Java; 
    empty Path as output if no solution found) 
    Effect: 
    Frontier Search Algorithm: Returns a set of 
    nodes that lead from the input Node to a solution 
    node if found
    */
    public Path search(String query) {
        //-frontier:={new array Paths} 
        ArrayList<Path> frontier = new ArrayList<Path>(); 
        
        //-create a new Path and put the Start node in it
        Path p = new Path(); 
        p.contents.add(this); 
        
        //-put the new Path into the frontier 
        frontier.add(p); 
        while (!frontier.isEmpty()) {
            //-select and remove a Path <s0, s1, ....,sk> from frontier
            //-use helper function pickPath()) 
            Path pick = pickPath(frontier); 

            //-if node (sk) is a goal, return selected Path 
            if (hasGoal(query, pick)) {
                return pick; 
            }
            else {
                //-otherwise, for every connected node of end node sk: 
                //1. Make a copy of the selected Path 
                //2. Add connected node of sk onto path copy 
                //3. add copied Path <s0, s1, ...,sk, s> to frontier 
                int size = pick.contents.size(); 
                Node last = pick.contents.get(size -1); 
                
                for (Node n: last.children) {
                    Path toAdd = new Path(); 
                    toAdd.contents.addAll(pick.contents); 
                    toAdd.contents.add(n); 
                    
                    frontier.add(toAdd); 
                }
            }
        }
   
        //-indicate 'No Solution' if frontier empties
        //(empty path as 'No Solution' here) 
        return new Path(); 
    }
    
    /*
    Helper function #1: 
    Input: a list of Paths
    Output: a Single Path 
    Effect: based on positioning of choice:
    -select and remove path 
    -return that path 
    Note: can modify the position assignment to change 
    the Search Strategy
    */
    private Path pickPath(ArrayList<Path> f) { 
        int position = 0; 
        Path ret = f.get(position); 
        f.remove(position); 
        return ret; 
    }
    
    /* 
    Helper function #2: 
    Input: 
    -a path 
    -Node contents that have a solution
    <same data type as Nodes container> 
    Output: boolean 
    Effect: outputs True if path contains a Goal 
    */
    private boolean hasGoal(String s, Path p) {
        for (Node n: p.contents) {
            if(n.contents == s) {
                return true; 
            }
        }
        return false; 
    }
    
 

    
}
