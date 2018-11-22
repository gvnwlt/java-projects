//This program reads data from a file consisting of students's 
//names and their test scores. The program outputs each 
//student's name followed by the test score and the grade. The 
//program also outputs the average test score for all students. 

import java.io.*; 
import java.util.*; 

public class ClassAverage 
{ 
   public static void main(String[] args) 
                                    throws FileNotFoundException
   {
      String firstName; 
      String lastName; 
      double testScore; 
      char grade = ' '; 
      double classAverage; 
      
      double sum = 0; 
      int count = 0; 
      
      Scanner inFile = 
            new Scanner(new FileReader("atData.txt")); 
            
      PrintWriter outFile = 
               new PrintWriter("atData.out");  
               
      while (inFile.hasNext()) 
      {
         firstName = inFile.next();//read the first name
         lastName= inFile.next(); //read the last name 
         testScore = 
            inFile.nextDouble(); //read the test score 
            
         sum = sum + testScore; //update sum 
         count++;               //update count 
         
            //determine the grade 
         switch ((int) testScore / 10)
         {
         case 0: 
         case 1: 
         case 2: 
         case 3: 
         case 4: 
         case 5: 
            grade = 'F'; 
            break; 
         
         case 6: 
            grade = 'D'; 
            break; 
         
         case 7: 
            grade = 'C'; 
            break; 
         
         case 8: 
            grade = 'B'; 
            break; 
            
         case 9: 
         case 10: 
            grade = 'A'; 
            break; 
            
         default: 
            System.out.println("Invalid score."); 
         }//end switch 
         
         outFile.printf("%-12s %-12s %4.2f %c %n", 
                        firstName, lastName,
                        testScore, grade); 
      }//end while 
      
      outFile.println(); 
      
      if(count != 0)
         outFile.printf("Class Average: %.2f %n", 
                        sum / count); 
      else
         outFile.println("No data."); 
         
         outFile.close(); 
     }
}  
            
                  
     
       