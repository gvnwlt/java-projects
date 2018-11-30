/*
 *************************************************************************
 *
 *  File: RoundNumber.java
 *  Date: 04/20/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */

/* Purpose:
*  1) prompt user to input a decimal number
*  2) ouput the number rounded to the nearest integer
*/ 

// import java.util classes for use of Scanner method
// and java.lang classes for Math method
import java.util.*;
import java.lang.*;

// name of class and program file and 
// then define the main method
public class RoundNumber
{
   // declare constant Scanner to receive inputs from user
   static Scanner console = new Scanner(System.in); 
   
   public static void main(String[] args)
   {
      // variables for storing user input 
      // and rounding to nearest integer
      double decNum; 
      double roundNumCalc; 
      
      int roundNum; // convert number result from calc to integer
      
      // Introductory message and prompt for user
      // decimal number to be rounded
      System.out.print("Hello! This program is designed to\n"
      + "recieve a decimal number input from you, the user,\n"
      + "and return a rounded integer. Enjoy!"); 
      System.out.println();
      System.out.print("\nPlease enter a decimal number: "); 
      decNum = console.nextDouble(); 
      
      // round the number to nearest integer
      roundNumCalc = Math.round(decNum);
      roundNum = (int)roundNumCalc;
      
      // display the number input 
      // and then the rouding result
      System.out.println();
      System.out.print("Your decimal number input was: "
      + decNum); 
      System.out.println();
      System.out.printf("Your rounded result is: "
      + roundNum); 
      
      // closing message the end the program
      System.out.println();
      System.out.print("\nThank you for participating! Good bye!"); 
   }
}
      
      
