/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gwalters
 *
 * Created on June 3, 2018, 12:35 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    double income, tax;
    printf("Enter your income: ");
    scanf("%lf", &income); 
    if (income < 10000) {
        tax = 0.0; 
    }
    else if (income >= 10000 && income < 20000) {
        tax = income * .1; 
    }
    else if (income >= 20000 && income < 50000) {
        tax = income * .2; 
    }
    else {
        tax = income * .25; 
        tax = tax + tax * .1; 
    }
    printf("The payable tax is $%0.2lf\n", tax); 

    return (EXIT_SUCCESS);
}

