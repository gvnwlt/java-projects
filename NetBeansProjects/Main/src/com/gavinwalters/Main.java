package com.gavinwalters;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore(500);
        System.out.println("New score is " + newScore);
        calculateScore(1); 
        calculateScore(); 
        
        calcFeetAndInchesToCentimeters(157); 
    }
    
    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points"); 
        return score * 1000; 
    }
    
    public static int calculateScore(int score) {
        System.out.println("Unkown player scored " + score + " points");
        return score * 1000; 
    }
    
    public static int calculateScore() {
        System.out.println("No player name, no player score.");
        return 0; 
    }
    
    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if ((feet < 0) || ((inches < 0) || (inches > 12))) {
            System.out.println("Invalid range"); 
            return -1;     
        }
        double calc = (((feet * 12) + inches) * 2.54);
        System.out.println(feet + " ft " + inches + " inches = " + calc + " cm"); 
        return calc; 
    }
    
     public static double calcFeetAndInchesToCentimeters(int inches) {
        int feet; 
        if (inches >= 0) {
            if (inches >= 12) {
                feet = inches / 12; 
                inches = inches - ((inches / 12) * 12);     
                return calcFeetAndInchesToCentimeters(feet, inches); 
            }
            return (inches * 2.54);
        }  
        System.out.println("Invalid range");
        return -1;      
    }
   
}
