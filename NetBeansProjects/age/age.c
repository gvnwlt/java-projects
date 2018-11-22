/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdio.h>

int main(int argc, char** argv) {
    int age; 
    printf("Enter your age: "); 
    scanf("%d", &age); 
    
    if (age >= 13 && age <= 19) {
        printf("Yup! You are a teenager!");
    }
    else {
        printf("No, you are not a teenager!");
    }
    
    return 0; 
}
