/*
 *************************************************************************
 *
 *  File: ArrayOfFiftyElements.java
 *  Date: 05/08/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */




/* Using jGrasp and the Software Development Kit, write a program in response to the following prompt:

Write a program that declares an array "alpha" of 50 elements of type "double". Initialize the array so that the first 25 elements are equal to the square of 

the index variable and the last 25 elements are equal to three times the index variable. Output the array so that 10 elements per line are printed.

Submit your compiled Java code for this assignment, compress the .java file into a single .zip file.

For additional details, refer to the Programming Problems Rubric in the Assignment Guidelines and Rubrics folder. 

1)declare array alpha

2)include 50 elements of double type in alpha

3)initilize the first 25 elements are equal to the square of the index variable 

4)initilize the last 25 elements are equal to three times the index variable. 

5)Output the array so that 10 elements per line are printed 

*/

//import classes needed for GUI 



//declare program 

public class ArrayOfFiftyElements
{

//declare main method 

   public static void main(String[] args)
   {
   
   //create the aplha array -->as a double data type 
   double[] alpha = new double[50];
      
  
   
   //store array into output message 
   String output = ""; 
   
   //use loop to create 50 elements with the array
   for(int i = 0; i < 10; i++){
      
      if(i < 25){ 
         alpha[i] = i * i;
         output = output + " [" + i + "]" + alpha[i];
       }else if(i > 24){
         alpha[i] = i * 3; 
         output = output + " [" + i + "]" + alpha[i];
        } 
   }
  
  //after every 10 elements create new line and continue process
  output = output + "\n\n";  
   
   for(int i = 10; i < 20; i++){
      
      if(i < 25){ 
         alpha[i] = i * i;
         output = output + " [" + i + "]" + alpha[i];
       }else if(i > 24){
         alpha[i] = i * 3; 
         output = output + " [" + i + "]" + alpha[i];
        } 
   }
  
   output = output + "\n\n";  

   
   for(int i = 20; i < 30; i++){
      
      if(i < 25){ 
         alpha[i] = i * i;
         output = output + " [" + i + "]" + alpha[i];
       }else if(i > 24){
         alpha[i] = i * 3; 
         output = output + " [" + i + "]" + alpha[i];
        } 
   }

  output = output + "\n\n";   


   for(int i = 30; i < 40; i++){
      
      if(i < 25){ 
         alpha[i] = i * i;
         output = output + " [" + i + "]" + alpha[i];
       }else if(i > 24){
         alpha[i] = i * 3; 
         output = output + " [" + i + "]" + alpha[i];
        } 
   }
 
   output = output + "\n\n";  
   
   for(int i = 40; i < 50; i++){
      
      if(i < 25){ 
         alpha[i] = i * i;
         output = output + " [" + i + "]" + alpha[i];
       }else if(i > 24){
         alpha[i] = i * 3; 
         output = output + " [" + i + "]" + alpha[i];
        } 
   }

   //print final output 
   System.out.print(output); 
   
 }
}
   