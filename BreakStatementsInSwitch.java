//Effect of break statements in a switch structure 

import java.util.*; 

public class BreakStatementsInSwitch
{
   static Scanner console = new Scanner(System.in); 
   
   public static void main(String[] args)
   {
      int num; 
      
      System.out.print("Enter an integer between " 
                     + "0 and 10: "); 
      num = console.nextInt(); 
      System.out.println(); 
      
      System.out.println("The number you entered " 
                       + "is " + num); 
      
      switch (num)
      {
         case 0: 
         case 1: 
            System.out.print("Hello "); 
         case 2: 
            System.out.print("there. "); 
         case 3: 
            System.out.print("I am "); 
         case 4: 
            System.out.print("Gavin. "); 
            break; 
            
         case 5: 
            System.out.print("How "); 
         case 6: 
         case 7: 
         case 8: 
            System.out.println("are you?"); 
            break;
            
         case 9: 
            break; 
         
         case 10: 
            System.out.println("Have a nice day."); 
            break;
         default: 
            System.out.println("Sorry the number is " 
                              + "out of scope."); 
         }
         
         System.out.println("Out of switch " 
                           + "structure."); 
    }
}                                                  