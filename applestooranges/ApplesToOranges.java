/*
    Author: Gavin Walters 
    IT-145 
    Pseudocode and Build 
    Module 2 
 */
package applestooranges;
import javax.swing.JOptionPane; 
import java.lang.Integer;

public class ApplesToOranges {
    public static void main(String[] args) {
        
        // Getting the apples and oranges quantities for on hand and what is supposed 
        // to be full stock. 
       String applesOnHand = JOptionPane.showInputDialog("How many apples are on hand?");
       String applesFullStock = JOptionPane.showInputDialog("How many apples are supposed to be on stock?" +
                                                            "\n**Do not input less than " + applesOnHand + " apples " +
                                                            "please! Or you will break this thing! It's only a prototype!**");
       String orangesOnHand = JOptionPane.showInputDialog("How many oranges are on hand?");
       String orangesFullStock = JOptionPane.showInputDialog("How many oranges are supposed to be on stock?" +
                                                            "\n**Do not input less than " + orangesOnHand + " oranges " +
                                                            "please! Or you will break this thing! It's only a prototype!**");
       // Store a message later on to show the user what they need to order.
       String orderThis = ""; 
       
       // Variablbes to store amout to order calculations
       int applesToOrder = 0; 
       int orangesToOrder = 0; 
       
       // Calculate the difference between full stock and what's on hand for apples and oranges
       // so that the user knows how much to order for each item. Also convert each variable 
       // so that the string can be computed as an integer. 
       applesToOrder = Integer.parseInt(applesFullStock) - Integer.parseInt(applesOnHand); 
       orangesToOrder = Integer.parseInt(orangesFullStock) - Integer.parseInt(orangesOnHand);
       
       // Now show the user what they need to order in a dialog box. 
       // Shift calculations to orderThis and then dialog box for show.
       orderThis =  "You need to order " + applesToOrder + " apples and " +
                     orangesToOrder + " oranges. Thank you for your input!"; 
       JOptionPane.showMessageDialog(null, orderThis); 
    }
    
}
