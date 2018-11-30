//*********************************************************************
//Author: D.S. Malik 
//
//Porgram: nth Fibonacci number 
//Given the first two numbers of a Fibonacci sequence, this 
//determines and outputs the desired number of the Fibonacci
//sequence
//*********************************************************************

import javax.swing.JOptionPane; 

public class FibonacciNumber
{
   public static void main(String[] args) 
   {
         //Declare variables 
      
      String inputString; 
      String outputString; 
      
      int previous1; 
      int previous2; 
      int current = 0; 
      int counter; 
      int nthFibonacci; 
      
      inputString = 
         JOptionPane.showInputDialog("Enter the first " 
                                   + "Fibonacci number: "); 
      
      previous1 = Integer.parseInt(inputString); 
      
      inputString = 
        JOptionPane.showInputDialog("Enter the second " 
                                  + "Fibonacci number: "); 
      
      previous2 = Integer.parseInt(inputString);
      
      outputString = "The first two numbers of the " 
                   + "Fibonacci sequence are: "
                   + previous1 + " and " + previous2; 
                   
      inputString =
         JOptionPane.showInputDialog("Enter the position " 
                        + "of the desired number in " 
                        + "the Fibonacci sequence: "); 
      nthFibonacci = Integer.parseInt(inputString); 
      
      if (nthFibonacci == 1) 
         current = previous1; 
      else if (nthFibonacci == 2) 
         current = previous2; 
      else
      {
         counter = 3; 
         
         
         while(counter <= nthFibonacci)
         {
            current = previous2 + previous1; 
            previous1 = previous2; 
            previous2 = current; 
            counter++; 
         }
      }
      
      outputString = outputString + "\nThe " 
                     + nthFibonacci
                     + "th Fibonacci number of "
                     + "the sequence is: " 
                     + current; 
                     
      JOptionPane.showMessageDialog(null, outputString, 
                                    "Fibonacci Number", 
                         JOptionPane.INFORMATION_MESSAGE); 
      System.exit(0); 
      }
    }                                                                                               
     