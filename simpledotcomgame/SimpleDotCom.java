/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledotcomgame;

/**
 *
 * @author hermes
 */
public class SimpleDotCom {
    
    int[] locationCells; 
    int numOfHits = 0; 
    
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }//Close method.
    
    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit"; 
                numOfHits++; 
                break; 
            }
        } //Out of the for-in loop. 
        
        if (numOfHits == locationCells.length) {
            result = "kill"; 
        }
        System.out.println(result);
        return result; 
    }//Close method. 
    
}//Close class. 
