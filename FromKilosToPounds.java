/*
 *************************************************************************
 *
 *  File: FromKilosToPounds.java
 *  Date: 04/24/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */


//1)Enter mass in kg
//2)Output weight in pounds
//3)Output both the mass and the
//  weight rounded to two decimal places
//       **note: 1kg = 2.2pounds** 
//4)Use dialogue boxes

//Import library specific for input/output dialog
//boxes.
import javax.swing.JOptionPane;

//Name class and file name
public class FromKilosToPounds
{

//Mandatory method 'main' to run program   
   public static void main(String[] args) 
   {
      //variables declared to recieve input
      //and to display output
      String input; 
      String output;
      
      //variables declared for storing mass
      //in kg and weight in lbs 
      double massInKg; 
      double weightInLbs; 
      
      //input dialog box to prompt user for 
      //their mass in kg 
      input = JOptionPane.showInputDialog
                 ("Please enter your mass in kilograms: "); 
      
      //breakdown user input into 
      //a double data type
      massInKg = Double.parseDouble(input); 
      
      //calculates the mass in kg
      //to the weight in lbs
      weightInLbs = massInKg * 2.2; 
      
      //output the data gathered in mass and 
      //calcuated for weight and display in a 
      //dialog box with a nice message
      output = "Mass: " +
               String.format("%.2f kg", massInKg) + "\n"
             + "Weight: " +
               String.format("%.2f lbs", weightInLbs) + "\n"
             + "Thank you for you using Kilos to Pounds!";
             
     JOptionPane.showMessageDialog(null, output, 
                                 "Kilos to Pounds", 
                                 JOptionPane.INFORMATION_MESSAGE); 
     System.exit(0); 
   }
}
             