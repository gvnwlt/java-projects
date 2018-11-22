/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on May 28, 2018, 12:38 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int aVar, x; 
    
    printf("Enter an integer: "); 
    scanf("%d", &aVar); 
    x = aVar + 1; 
    printf("The value is: %d and %d\n", aVar, x);
  
    return 0;
}

