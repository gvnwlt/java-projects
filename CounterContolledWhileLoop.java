//Counter-controlled while loop 

import java.util.*; 

public class CounterContolledWhileLoop 
{ 
   static Scanner console = new Scanner(System.in); 
   
   public static void main(String[] args) 
   { 
      int limit;  //store the number of items 
                  //in the list 
      int number; //variable to store the number 
      int sum;    //variable to store the sum 
      int counter;//loop control variable 
      
      System.out.print("Line 1: Enter the number of " 
                     + "intergers in the list: "); 
      
      limit = console.nextInt(); 
      System.out.println(); 
      
      sum = 0; 
      counter = 0; 
      System.out.println("Line 6: Enter " + limit
                       + " integers."); 
                       
      while(counter < limit)
      {
         number = console.nextInt(); 
         sum = sum + number;
         counter++; 
      } 
      
      System.out.printf("Line 11: The sum of the %d " + 
                        "numbers = %d%n", limit, sum); 
                        
      if(counter != 0)
         System.out.printf("Line 13: The average = %d%n",
                            (sum / counter)); 
      else 
         System.out.println("Line 15: No input."); 
         
   }
}                                                                               