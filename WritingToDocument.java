import java.io.PrintWriter; 
import java.util.Scanner; 

//Add additional import statements as needed


public class WritingToDocument
{
      //Declare appropriate variables
   public static void main(String[] args)
                           throws FileNotFoundException
   {
                           //Create and associate the stream objects
         Scanner inFile = 
               new Scanner(new FileReader("prog.dat")); 
               
         PrintWriter outFile = new PrintWriter("prog.out"); 
         
               //Code for data manipulation
               
                     //Close file
         inFile.close();
         outFile.close(); 
    }
}
                
               
                                                       