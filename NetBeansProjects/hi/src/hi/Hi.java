/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hi;
import java.util.*; 

/**
 *
 * @author gwalters
 */
public class Hi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi!");
            try {
                Thread.sleep(1000); 
            }
            catch (Exception e) {
                
            }
        }
    }
    
}
