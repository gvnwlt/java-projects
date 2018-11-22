/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on May 28, 2018, 8:10 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int var = 45;
    printf("var = %d\n", var); 
    printf("var = %o\n", var); 
    printf("var = %x\n\n", var); 
    
    int var1 = 056; 
    printf("var = %d\n", var1); 
    printf("var = %o\n", var1); 
    printf("var = %x\n\n", var1); 
    
    int var2 = 0xa; 
    printf("var = %d\n", var2); 
    printf("var = %o\n", var2); 
    printf("var = %x\n", var2); 

    return 0;
}

