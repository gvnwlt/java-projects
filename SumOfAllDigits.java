/*
 *************************************************************************
 *
 *  File: SumOfAllDigits.java
 *  Date: 05/08/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */


/*Using jGrasp and the Software Development Kit, write a program in response to the following prompt:

Write a program that prompts the user to input an integer and then outputs both the individual digits of the number and the sum of the digits. 

For example, the program should: ouput the individual digits of 3456 as 3 4 5 6 and the sum as 18, output the individual digits of 8030 as 8 0 3 0 and the sum as 11, 

output the individual digits of 2345526 as 2 3 4 5 5 2 6 and the sum as 27, output the individual digits of 4000 as 4 0 0 0 and the sum as 4, 

and output the individual digits of -2345 as 2 3 4 5 and the sum as 14.

Submit your compiled Java code for this assignment, compress the .java file into a single .zip file. */ 

//1)prompt user for integer
//2)output individual digits and sum of digits 

import java.util.Scanner; 

public class SumOfAllDigits
{
   //constant to recieve input from user for integer
   static Scanner console = new Scanner(System.in);  
   
   //declare main method
   public static void main(String[] args) 
   { 
   
         //declare variables to store user input for integers  
      int integer; 
      
         //reverse number order after each modulo pass
         //and store
      String backward = " "; 
      String forward = "";
      
          //variable to display each digit
      int digit; 
         //declare variable to sum up digits    
      int sum = 0; 
         //get the length of the integer 
      int length; 
         //variable to output message 
      String output; 
      
         //Start the program with a message and prompt to user
      System.out.print("Enter any integer: "); 
        //get input and store integer in variable
      integer = console.nextInt(); 
      System.out.println(); 
      
      
       //begin to process integer into a loop 
       
      do
      {
         sum = sum + integer % 10; //add each digit to sum
         digit = integer % 10; //take a digit to store in backward
         backward = backward + digit + " "; //store digit in backward and space between each number
         integer = integer / 10; //remove a integer for next pass
               }
      while(integer > 0); //loop controlled by integers left
      
      //store length of integer in variable 
      //to control the following loop 
      length = backward.length(); 
      
      /*take what is in backward and store it in reverse 
      order inside of forward by deincrementing
      from last character (length -1 to prevent going outside of index)
      until all characters are stored in reverse order*/ 
      for(int i = length -1  ; i > 0; i--)
      {
         forward = forward + backward.charAt(i); 
      }

      //output the desired results and original input
      output = "The digits you entered were:"
             + forward + "\nThe sum is: " 
             + sum; 
      System.out.println(output);
    
    /*  
      //debug//
       
      String debug = "";  
      System.out.println(); 
      System.out.println("[Debug Mode]"); 
      System.out.println("Backward: " + backward); 
      System.out.println("Length: " + length);
      debug = debug + backward.charAt(7);
      System.out.println("Backward(7): " + debug);
      
      length = length -1; //--> If lenght is 7 then what's at character 
      //[7] when then string starts at [0]? There is no [7]
      
      debug = debug + backward.charAt(6);  
      System.out.println("Backward(6): " + debug);
      System.out.println("Length -1: " + length);  
    */  
   }
}
              
      
      
         
      
      
           
      