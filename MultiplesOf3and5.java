/* This program is to perform a calculatoin on all the numbers that are
   multiples of 3 and 5 all the way to 1000. For every number found to be 
   a multiple of 3 or 5 up to 1000, get the sum of those numbers and display 
   the answer. */

public class MultiplesOf3and5 { 

  public static void main(String[] args) { 
    
    int sum = 0;     

    for (int i = 0; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
   	sum += i; 
      } 
    }
    
    System.out.println("The sum is: " + sum);     

  }
}
