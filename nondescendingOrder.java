/*
 *************************************************************************
 *
 *  File: nondescendingOrder.java
 *  Date: 05/03/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */

//Write a program that prompts the user to input three numbers. This program should then output the numbers in nondescending order.

//Submit your compiled Java code for this assignment, compress the .java file into a single .zip file.  

//For additional details, refer to the Programming Problems Rubric in the Assignment Guidelines and Rubrics folder.

//1)Prompt user for 1st, 2nd, and 3rd number.
//2)Output the selected numbers in nondescending order. 

//import library to use nice user interface for 
//ux/ui
import javax.swing.JOptionPane;

//name program
public class nondescendingOrder
{
   //declare main method to start program
   public static void main(String[] args) 
   {
      //declare variables to store user inputs 
      //and display user outputs after 
      //processing      
      String input; 
      String output = "";
      String intro = "This program "
                     + "will ask you for three "
                     + "numbers that will subsequently "
                     + "be ordered in nondescending order.";
      
      //declare variable that will be used to store 
      //user inputs 
      int firstNum, secondNum, thirdNum; 
      //used to hold number for a kind of bubble sort
      //holds the number if the first if conditonal statement
      //is true. Used to move number where it needs to be in 
      //the order. 
      int hold;
      
           
      //introduce user to progam and request 
      //inputs
      JOptionPane.showMessageDialog(null,intro, "Welcome!", JOptionPane.INFORMATION_MESSAGE); 
      input = JOptionPane.showInputDialog
              ("Enter the first number: "); 
      //process inputs into integers
      firstNum = Integer.parseInt(input); 
      
      input = JOptionPane.showInputDialog
            ("Enter the second number: "); 
      secondNum = Integer.parseInt(input); 
      
      input = JOptionPane.showInputDialog
            ("Enter the final number: "); 
      thirdNum = Integer.parseInt(input);        
      
            
      //Use relational operators to assess 
      //user inputs and rearrange them 
      //accordingly
      
      if (thirdNum < firstNum)
      {
         hold = thirdNum; 
         if (secondNum < hold)
            output = String.format("%d, %d, %d",secondNum, hold, firstNum); //format strings to input into JOptionPane
         else 
            output = String.format("%d, %d, %d", hold, secondNum, firstNum);//if thirdNum is less than one but seconNum is not less
                                                                            //than hold of thirdNum, then thirdNum stays to replace 
                                                                            //the first num. All following statements follow similar
                                                                            //pattern
      }
      else if (secondNum < firstNum)
      {
         hold = secondNum; 
         if (thirdNum < hold)
            output = String.format("%d, %d, %d",thirdNum, hold, firstNum); 
         else 
            output = String.format("%d, %d, %d",hold, firstNum, thirdNum); 
      }
      else if (thirdNum < secondNum)
      {
         hold = thirdNum; 
         if (firstNum < hold)
            output = String.format("%d, %d, %d",firstNum, hold, secondNum); 
         else 
            output = String.format("%d, %d, %d",firstNum, hold, secondNum); 
     }
     else if (secondNum < thirdNum)
     {
         hold = secondNum; 
         if (firstNum < hold)
            output = String.format("%d, %d, %d",firstNum, hold, thirdNum); 
         else 
            output = String.format("%d, %d, %d",firstNum, hold, thirdNum); 
     }
     else if (firstNum < thirdNum)
     {
         hold = firstNum; 
         if (secondNum < hold)
            output = String.format("%d, %d, %d",secondNum, hold, thirdNum); 
         else 
            output = String.format("%d, %d, %d",hold, secondNum, thirdNum); 
     }
     else if (firstNum < secondNum) 
     {
         hold = firstNum; 
         if (thirdNum < hold)
            output =  String.format("%d, %d, %d",thirdNum, hold, secondNum); 
         else 
            output = String.format("%d, %d, %d",firstNum, secondNum, thirdNum); 
     }
     
       //show dialog window with nondescending order results store in output  
       JOptionPane.showMessageDialog(null, output, 
                                 "Nondescending Order", 
                                 JOptionPane.INFORMATION_MESSAGE); 
  }
}           
 
             