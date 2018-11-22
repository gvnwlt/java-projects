//Flag-controlled while loop 
//Guessing the number game. 

import java.util.*; 

public class FlagControlledLoop 
{ 
   static Scanner console = new Scanner(System.in); 
   
   public static void main(String[] args) 
   { 
          //declare the variables
      int num; //variable to store the random number 
      int guess; // variable to store the number 
                 //guessed by the user 
                 
      boolean done;  //boolean by the user 
      
      num = (int) (Math.random() * 100); 
      
      done = false; 
      
      while(!done)
      { 
         System.out.print("Enter an integer greater" 
                        + " than or equal to 0 and " 
                        + "less than 100; "); 
         guess = console.nextInt(); 
         System.out.println(); 
         
         if (guess == num) 
         {
            System.out.println("You guessed the " 
                             + "correct number."); 
            
            done = true;
         }                     
         else if (guess < num) 
            System.out.println("Your guess is " 
                             + "lower than " 
                             + "the number.\n" 
                             + "Guess again!");    
         else 
            System.out.println("Your guess is " 
                             + "higher than " 
                             + "the number.\n"
                             + "Guess again!"); 
        }//end while 
    }
}                                                              
          
     