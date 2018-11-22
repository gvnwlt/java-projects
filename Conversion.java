//*****************************************************************
// This program will prompt the user for a measurement that is 
// in feet and convert it to inches and then into centimeters
//*****************************************************************

import java.util.*; 

public class Conversion
{
   static Scanner console = new Scanner(System.in); 
   
   static final double CENTIMETERS_PER_INCH = 2.54; 
   static final int INCHES_PER_FEET = 12; 
   
   public static void main(String[] args) 
   {
         //declare variables
      int feet;
      int inches; 
      int totalInches;
      
      double centimeters; 
      
      System.out.print("Enter feet: ");
      feet = console.nextInt(); 
      System.out.println(); 
      System.out.print("Enter inches: "); 
      inches = console.nextInt(); 
      System.out.println(); 
      System.out.println("The numbers you entered are "
      + feet + " for feet and " + inches + " for inches."); 
      
      totalInches = INCHES_PER_FEET * feet + inches; 
      
      System.out.println(); 
      System.out.println("The total number of inches = " 
      + totalInches); 
      
      centimeters = totalInches * CENTIMETERS_PER_INCH; 
      
      System.out.println("The number of centimeters = "
      + centimeters); 
   }
} 
      