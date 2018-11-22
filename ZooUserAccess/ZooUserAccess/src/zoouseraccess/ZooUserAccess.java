/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoouseraccess;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 *
 * @author gvnwa
 */
public class ZooUserAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //File inputs and outputs for access and authentication.
        //Pass text file for credentials to input stream.
        FileInputStream credentials = new FileInputStream("test/credentials.txt");
        //Pass file to Scanner object to be read through. 
        Scanner inCredentialstxt = new Scanner(credentials);
        //Reads lines of file. Used to "step" through lines of file.
        String userCredentialsFile = inCredentialstxt.nextLine(); 
        //Reads file to give to user if verified. 
        FileInputStream readOutFile = null;
        Scanner fileContents = null;
        //Reads out lines from fileContents.
        String readOut = "";
        //User information getters
        Scanner userInput = new Scanner(System.in);
        
        //User name and password storage variables
        String userName = "";
        String userPassword = "";
        String userRole = "";
        boolean userNamePass = false;
        boolean userPasswordPass = false;
        //Count user attempts. 
        int attempts = 3; 
        //Get user input for logout. 
        boolean userLogout = false; 
        String logoutConfirm = "";
        
        //Variables to pass out to methods. 
        //This object hashes the user's password.
        ZooUserAuthenticate passToHash = new ZooUserAuthenticate();
        
        
        //User Name.
        //Present program and prompt user for name.
        System.out.println("Welcome to the Zoo Access System!");
        //Starting loop for user access.
        while (!userLogout && (attempts > 0)) {
            System.out.println("Enter login name: ");
            //Get user name to be checked.
            userName = userInput.nextLine();
            //Run loop stepping through each line of file until name is found 
            //returning value greater than -1, or end of file is reached. 
            //This finds the line of the user name in the file and stays on that
            //line to verify other credentials.
            while ((userCredentialsFile.indexOf(userName) < 0) && (inCredentialstxt.hasNextLine())) {
                userCredentialsFile = inCredentialstxt.nextLine();
            }
    //        //Check to see if name matches
    //        if (userCredentialsFile.indexOf(userName) > -1) {
    //            System.out.println("User name good.\n\n");
    //        }
    //        //If name doesn't match tell the user.
    //        else {
    //            System.out.println("Wrong user name.");
    //        }

            //Password.
            //Now get user's password and hash it.
            System.out.println("\nEnter password: ");
            userPassword = userInput.nextLine(); 
            //Pass userPassword into hash function.
            passToHash.hashMe(userPassword);
            //DELETE
            //System.out.println(passToHash.getToCompare());
            //Check to see if hashes match. Method returns true or false.
            if (passToHash.credentialsVerified(userCredentialsFile)) {
                //System.out.println("Password verfied.\n\n");
                userNamePass = true;
                userPasswordPass = true; 
               //Do something here! Get the user's role.
            }
    //        else {
    //            System.out.println("Password is incorrect.");
    //        }


            //Know your role!
            //Now present role assigned to user and send out the file associated 
            //with that role.
            if (userNamePass && userPasswordPass){
                if ((userCredentialsFile.indexOf(userName) > -1) && (userCredentialsFile.indexOf("zookeeper") > -1)){
                    readOutFile = new FileInputStream("test/zookeeper.txt");
                    fileContents = new Scanner(readOutFile);
                    while(fileContents.hasNextLine()) {
                        readOut = fileContents.nextLine();
                        System.out.println(readOut); 
                    }  
                    readOutFile.close();
                }
                else if ((userCredentialsFile.indexOf(userName) > -1) && (userCredentialsFile.indexOf("admin") > -1)){
                    readOutFile = new FileInputStream("test/admin.txt");
                    fileContents = new Scanner(readOutFile);
                    while(fileContents.hasNextLine()) {
                        readOut = fileContents.nextLine();
                        System.out.println(readOut); 
                    }  
                    readOutFile.close();
                }
                 else if ((userCredentialsFile.indexOf(userName) > -1) && (userCredentialsFile.indexOf("veterinarian") > -1)){
                    readOutFile = new FileInputStream("test/veternarian.txt");
                    fileContents = new Scanner(readOutFile);
                    while(fileContents.hasNextLine()) {
                        readOut = fileContents.nextLine();
                        System.out.println(readOut); 
                    }  
                    readOutFile.close();
                }
                if (!userLogout) {
                    System.out.println("\nWould you like to logout now? 'y' for yes 'n' for no.");
                    logoutConfirm = userInput.next();
                    if (logoutConfirm.equals("y")) {
                        userLogout = true;
                        System.out.println("Logging out.");
                    }
                    else {
                        while (logoutConfirm.equals("n")) {
                           System.out.println("Would you like to logout now? 'y' for yes 'n' for no.");
                           logoutConfirm = userInput.next();
                        }
                        userLogout = true;
                    }
                }
            }
             else {
                     System.out.println("The user name and/or password were incorrect. Please try again.");
                     //Give attempts count.
                     attempts--;
                     System.out.println("You have " + attempts + " attempts left.\n");
                     //Reload.
                     credentials = new FileInputStream("test/credentials.txt");
                     inCredentialstxt = new Scanner(credentials);
                     userCredentialsFile = inCredentialstxt.nextLine();
                     if (attempts == 0) {
                         System.out.println("Exiting the program.");
                     }
                 }
        //End of while loop.
        }
        //Close files.
        credentials.close();
    }
}
    

