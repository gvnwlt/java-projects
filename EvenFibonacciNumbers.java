/* This program is to give the sum of all the even fibonacci
   numbers whose values do not exceed four million */ 

public class EvenFibonacciNumbers {
  
  public static void main (String[] args) { 
    
    int previousNum = 1; 
    int currentNum = 2;    
    int lastPrevNum = 0; 
    int sumOfEvens = 0; 
   
    while  (currentNum <= 4000000) {
      if (currentNum % 2 == 0) { 
        sumOfEvens += currentNum; 
      }
      lastPrevNum = previousNum; 
      previousNum = currentNum; 
      currentNum = lastPrevNum + currentNum;       
    }   

    System.out.println("Sum of evens is: " + sumOfEvens); 

  } 
}
