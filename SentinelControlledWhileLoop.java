//Sentinel-controlled while loop 

import java.util.*; 

public class SentinelControlledWhileLoop
{ 

   static Scanner console = new Scanner(System.in); 
   
   static final int SENTINEL = -999; 
   
   public static void main(String[] args)
   { 
      int number;       //variable to store the number 
      int sum = 0;      //variable to store the sum 
      int count = 0;    //varialbe to store the total 
                        //numbers read 
                        
      System.out.println("Line 1: Enter positive integers " 
                       + "ending with " + SENTINEL); 
      
      number = console.nextInt(); 
      
      while(number != SENTINEL) 
      { 
         sum = sum + number; 
         count++; 
         number = console.nextInt(); 
      } 
      
      System.out.printf("Line 7: The sum of %d " + 
                        "numbers = %d%n", count, sum); 
                        
      if(count != 0) 
         System.out.printf("Line 9: The average = %d%n", 
                          (sum / count)); 
      else 
         System.out.println("Line 11: No input."); 
   }
}                                                                         