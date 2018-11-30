/*
 Author: Gavin Walters 
    IT-145 
    Text Message Expander
    Module 3
 */
package textmsgexpander;
import java.util.Scanner; 
 

public class TextMsgExpander {
    public static void main(String[] args) {
        // Create scanner object to recieve user input
        Scanner scanner = new Scanner(System.in);
        // String variable to store user input
        String userInput = "";
   
       
        // Prompt user to give an input
        System.out.println("Enter text: ");
        userInput = scanner.nextLine(); 
        
        // Variables to manipulate data for "replace"
        // Replace creates a whole new variable so this has to be done
        String replacement1 = "";
        String replacement2 = "";
        String replacement3 = "";
        String replacement4 = "";
        String finalReplacement = ""; 
        // Let user know what they typed in
        System.out.println("You entered: " + userInput + "\n");
       
        // Beginning experimental stages of code -- refactored
            // Single variations
           /* if(userInput.indexOf("BFF") != -1 && userInput.indexOf("IDK") == -1 && userInput.indexOf("JK") == -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") == -1) { 
               System.out.println("Replaced \"BFF\" with \"best friend forever\".");
                finalReplacement = userInput.replace("BFF", "best friend forever"); 
            }
            else if(userInput.indexOf("BFF") == -1 && userInput.indexOf("IDK") != -1 && userInput.indexOf("JK") == -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") == -1) { 
               System.out.println("Replaced \"IDK\" with \"I don't know\".");
                finalReplacement = userInput.replace("IDK", "I don't know"); 
            }
             else if(userInput.indexOf("BFF") == -1 && userInput.indexOf("IDK") == -1 && userInput.indexOf("JK") != -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") == -1) { 
               System.out.println("Replaced \"JK\" with \"just kidding\".");
                finalReplacement = userInput.replace("JK", "just kidding"); 
            }
              else if(userInput.indexOf("BFF") == -1 && userInput.indexOf("IDK") == -1 && userInput.indexOf("JK") == -1 && userInput.indexOf("TMI") != -1 && userInput.indexOf("TTYL") == -1) { 
               System.out.println("Replaced \"TMI\" with \"too much information\".");
                finalReplacement = userInput.replace("TMI", "too much information"); 
            }
               else if(userInput.indexOf("BFF") == -1 && userInput.indexOf("IDK") == -1 && userInput.indexOf("JK") == -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") != -1) { 
               System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
                finalReplacement = userInput.replace("TTYL", "talk to you later"); 
            }
            // Combination section
            // BFF and IDK
            else if(userInput.indexOf("BFF") != -1 && userInput.indexOf("IDK") != -1 && userInput.indexOf("JK") == -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") == -1) {
                System.out.println("Replaced \"BFF\" with \"best friend forever\"."); 
                System.out.println("Replaced \"IDK\" with \"I don't know\".");
                replacement1 = userInput.replace("BFF", "best friend"); 
                finalReplacement = replacement1.replace("IDK", "I don't know"); 
            }
            // BFF, IDK, and JK
            else if(userInput.indexOf("BFF") != -1 && userInput.indexOf("IDK") != -1 || userInput.indexOf("JK") != -1 && userInput.indexOf("TMI") == -1 && userInput.indexOf("TTYL") == -1) {
                System.out.println("Replaced \"BFF\" with \"best friend forever\".");
                System.out.println("Replaced \"IDK\" with \"I don't know\".");
                System.out.println("Replaced \"JK\" with \"just kidding\".");
                replacement1 = userInput.replace("BFF", "best friend"); 
                replacement2 = replacement1.replace("IDK", "I don't know"); 
                finalReplacement = replacement2.replace("JK", "just kidding");  
            }
            // BFF, IDK, JK, and TMI
            else if(userInput.indexOf("BFF") != -1 && userInput.indexOf("IDK") != -1 && userInput.indexOf("JK") != -1 || userInput.indexOf("TMI") != -1 && userInput.indexOf("TTYL") == -1) {
                System.out.println("Replaced \"BFF\" with \"best friend forever\".");
                System.out.println("Replaced \"IDK\" with \"I don't know\".");
                System.out.println("Replaced \"JK\" with \"just kidding\".");
                System.out.println("Replaced \"TMI\" with \"too much information\".");
                replacement1 = userInput.replace("BFF", "best friend forever"); 
                replacement2 = replacement1.replace("IDK", "I don't know"); 
                replacement3 = replacement2.replace("JK", "just kidding");  
                finalReplacement = replacement3.replace("TMI", "too much information");
            }*/
             // BFF, IDK, JK, and TMI situations
             // Check input to see if any of the text strings shows up 
             // If it does, check to see what ones before printing that they have been modified
            if(userInput.indexOf("BFF") != -1 || userInput.indexOf("IDK") != -1 || userInput.indexOf("JK") != -1 || userInput.indexOf("TMI") != -1 || userInput.indexOf("TTYL") != -1) {
               if(userInput.indexOf("BFF") != -1) {
                    System.out.println("Replaced \"BFF\" with \"best friend forever\".");
               }
               if(userInput.indexOf("IDK") != -1) {
                    System.out.println("Replaced \"IDK\" with \"I don't know\".");
               }
               if(userInput.indexOf("JK") != -1) {
                    System.out.println("Replaced \"JK\" with \"just kidding\".");
               }
               if(userInput.indexOf("TMI") != -1) {
                    System.out.println("Replaced \"TMI\" with \"too much information\".");
               }
               if(userInput.indexOf("TTYL") != -1) {
                    System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
               }
               // Run through replacement sequence to replace any of the "key words" 
               replacement1 = userInput.replace("BFF", "best friend forever"); 
               replacement2 = replacement1.replace("IDK", "I don't know"); 
               replacement3 = replacement2.replace("JK", "just kidding");  
               replacement4 = replacement3.replace("TMI", "too much information");
               finalReplacement = replacement4.replace("TTYL", "talk to you later");
            }
        
        // Give the user the "Expanded" version output
        
        System.out.println("\nExpanded: " + finalReplacement );
       
                   
    }
        
}
    

