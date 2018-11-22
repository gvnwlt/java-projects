/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on June 3, 2018, 1:01 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int a, b, c, max; 
    printf("Enter 3 numbers: "); 
    scanf("%d %d %d", &a, &b, &c); 
    if (a > b && a > c) {
        max = a; 
    }
    else if (b > c) {
        max = b; 
    }
    else {
        max = c; 
    }
    printf("Maximum is %d\n", max); 

    return (EXIT_SUCCESS);
}

