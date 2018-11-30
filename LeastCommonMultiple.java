package leastcommonmultiple;
import java.util.Scanner;
import java.lang.Math;

public class LeastCommonMultiple {

   // Method prompts user to enter postiive non-zero number
   public static int getPositiveNumber() {
      Scanner scnr = new Scanner(System.in);
      int userNum = 0;

      while (userNum <= 0) {
         System.out.println("Enter a positive number (>0): ");
         userNum = scnr.nextInt();

         if (userNum <= 0) {
            System.out.println("Invalid number.");
         }
      }

      return userNum;
   }

   // Method returns greatest common divisor of two inputs
   public static int findGCD(int aVal, int bVal) {
      int numA = aVal;
      int numB = bVal;

      while (numA != numB) { // Euclid's algorithm
         if (numB > numA) {
            numB = numB - numA;
         } else {
            numA = numA - numB;
         }
      }

      return numA;
   }

   // Method returns least common multiple of two inputs
   public static int findLCM(int aVal, int bVal) {
      int lcmVal = 0;

      lcmVal = Math.abs(aVal * bVal) / findGCD(aVal, bVal);

      return lcmVal;
   }

   public static void main(String[] args) {
      int usrNumA = 0;
      int usrNumB = 0;
      int lcmResult = 0;

      System.out.println("Enter value for first input");
      usrNumA = getPositiveNumber();

      System.out.println("\nEnter value for second input");
      usrNumB = getPositiveNumber();

      lcmResult = findLCM(usrNumA, usrNumB);

      System.out.println("\nLeast common multiple of " + usrNumA
              + " and " + usrNumB + " is " + lcmResult);

      return;
   }
}