/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on June 3, 2018, 1:06 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int mood; 
    printf("Please enter the number of neighbours around Pupeta: ");
    scanf("%d", &mood); 
    
    if (mood < 0 || mood > 8) {
        printf("There is no way Pupeta can have any neighbhors NOT between the"
                " numbers 0 and 8...you liar!");
    }
    else if (mood == 0) {
        printf("Sad and will force you to listen to his story, will make you late.");
    }
    else if (mood == 1) {
        printf("He will ask you to deliver half of the pizza to his only neighbor, you may be late.");
    }
    else if (mood >= 2 && mood <= 5) {
        printf("Will have a great mood and will be singing song. May crack joke as well. You will get"
                "good tips, definetely."); 
    }
    else if (mood == 7) { 
        printf("He will be making great drink for his neighbors and will invite you to taste. But will not give you tip.");
    }
    else if (mood == 6 || mood == 8) {
        printf("Too angry and furious, deliver the pizza and leave ASAP."); 
    }
    return (EXIT_SUCCESS);
}

