
package com.gavinwalters;


public class SecondsAndMinutesChallenge {

    public static void main(String[] args) {
        System.out.println(getDurationString(600)); 
        System.out.println(getDurationString(65, 45)); 
    }
    
    public static String getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || ((seconds < 0) || (seconds > 59))) {
            return "Invalid value";
        }
        int hours = minutes / 60;  
        minutes = minutes - (hours * 60); 
        return hours + "h " + minutes + "m " + seconds + "s "; 
    }
    
    public static String getDurationString(int seconds) { 
        if (seconds < 0) {
            return "Invalid value"; 
        }
        int minutes = seconds / 60; 
        seconds = (seconds - (minutes * 60)); 
        return getDurationString(minutes, seconds); 
    }
    
}
