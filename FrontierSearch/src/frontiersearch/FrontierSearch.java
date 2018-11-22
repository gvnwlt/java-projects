package frontiersearch;

import java.util.ArrayList;

/*
This class will perform the FrontierSearch algorithm.
*/

public class FrontierSearch {
    
   
    public static void main(String[] args) {
       //Create & connect nodes a, b, c, d 
       Node a = new Node("a"); 
       Node b = new Node("b"); 
       Node c = new Node("c"); 
       Node d = new Node("d"); 
       a.children.add(b);
       a.children.add(c); 
       b.children.add(d); 
    }
    
}
