/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum3and5challenge;

/**
 *
 * @author gvnwa
 */
public class Sum3and5Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sum = 0; 
        int count = 0; 
        
        for (int i = 1; i <= 1000 && count != 5; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sum += i; 
                count++; 
            }
        }
        
        System.out.println("sum is : " + sum); 
    }
    
}
