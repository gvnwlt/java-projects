/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoouseraccess;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Scanner;
/**
 *
 * @author gvnwa
 */
public class ZooUserAuthenticate {
    
    //Set up so methods can be conducted with text files.
   
    //Store the hashed password.
    private String hashedPassword = "";
    boolean userVerified = false;
    

    //Method for password hash 
    public void hashMe (String password) throws Exception {
        String original = password;  //Replace "password" with the actual password inputted by the user
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
        }
        hashedPassword = sb.toString();
//        System.out.println("original:" + original);
//		System.out.println("digested:" + sb.toString()); //sb.toString() is what you'll need to compare password strings
        return;
    }
    
    
    //Method to return the hashed password for comparing in another function.
    //Made private so that users cannot access the hash.
    //Use to pass to method for comparison and for testing purposes. 
//    //private String getToCompare () {
//        return hashedPassword;
//    }
    
    
    public boolean credentialsVerified (String fileLine) {
        if (fileLine.indexOf(hashedPassword) > -1) {
            userVerified = true;
        }
        return userVerified;
    }
    

}
