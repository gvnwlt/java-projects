package com.gavinwalters; 

public class Main {
    
    public static void main(String[] args) {
        
//        int value = 2; 
//        
//        if (value == 1) {
//            System.out.println("Value was 1"); 
//        } 
//        else if (value == 2) {
//            System.out.println("Value was 2");
//        }
//        else {
//            System.out.println("Was not 1 or 2");
//        }
        
//        int switchValue = 6;
//        
//        switch(switchValue) {
//            case 1: 
//                System.out.println("Value was 1");
//                break; 
//                
//            case 2:
//                System.out.println("Value was 2");
//                break;
//                
//            case 3:case 4: case 5:
//                System.out.println("was a 3, or a 4, or a 5"); 
//                System.out.println("Actually it was a " + switchValue);
//                break; 
//                
//            default: 
//                System.out.println("Was not 1, 2, 3, 4 or 5");
//                break; 
//        }

//        char switchValue = 'D'; 
//        
//        switch(switchValue) {
//            case 'A': case 'B': case 'C': case 'D': case 'E':
//                System.out.println("Character " + switchValue + " was found");
//                break;
//                
//            default:
//                System.out.println("Character not found");
//                break;
//        }

//        String month = "May";
//        switch(month.toLowerCase()) {
//            case "january": 
//                System.out.println("Jan");
//                break;
//                
//            case "june":
//                System.out.println("Jun");
//                break;
//                
//            case "may":
//                System.out.println("May");
//                break;
//                
//            default: 
//                System.out.println("Not sure"); 
//                break;
//        }

        printDayOfTheWeek(6); 
        
    }
    
    private static void printDayOfTheWeek(int day) {
        switch(day) {
            case 0: 
                System.out.println("Sunday");
                break;
                
            case 1:
                System.out.println("Monday");
                break;
                
            case 2:
                System.out.println("Tuesday"); 
                break;
                
            case 3:
                System.out.println("Wednesday"); 
                break;
                
            case 4: 
                System.out.println("Thursday");
                break;
                
            case 5: 
                System.out.println("Friday"); 
                break;
                
            case 6:
                System.out.println("Saturday");
                break; 
                
            default:
                System.out.println("Invalid day"); 
                break;
        }
    }
    
}