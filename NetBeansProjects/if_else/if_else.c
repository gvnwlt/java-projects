/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdio.h>

int main() {
    int a, b, max; 
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter second number: ");
    scanf("%d", &b); 
    if (a > b) {
        max = a;
    }
    else {
        max = b; 
    }
    printf("Maximum is %d\n", max); 
    
    return 0; 
}