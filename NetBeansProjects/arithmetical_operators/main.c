/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on May 28, 2018, 9:32 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) { 
   int a = 10, b = 2; 
    
    printf("%d + %d = %d\n", a, b, a+b); 
    printf("%d - %d = %d\n", a, b, a-b); 
    printf("%d * %d = %d\n", a, b, a*b);
    printf("%d / %d = %d\n", a, b, a/b); 
    printf("%d %% %d = %d", a, b, a%b); 

    return 0;
}

