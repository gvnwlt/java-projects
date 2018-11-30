/*
 * This program will create a shopping cart list and return the items at their
 * total price. 
 */
//package shoppingcartprinter;

import java.util.Scanner;

/**
 *
 * @author Gavin Walters
 */
public class ShoppingCartPrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The two objects for items
        ItemToPurchase item = new ItemToPurchase();
        ItemToPurchase item2 = new ItemToPurchase();
        //User input. 
        Scanner scnr = new Scanner(System.in);
        //Variables for total prices
        int total1 = 0; 
        int total2 = 0; 
        int totalTotal = 0; 
        
        //Item 1 name, price, and quantity.
        //Name.
        System.out.println("Item 1");
        System.out.println("Enter the item name: ");
        item.setName(scnr.nextLine());
        //System.out.println(item1.getName()); //Only for testing.
        //Price.
        System.out.println("Enter the item price: ");
        item.setPrice(scnr.nextInt());
        //System.out.println(item1.getPrice()); //Only for testing.
        //Quantity.
        System.out.println("Enter the item quantity: ");
        item.setQuantity(scnr.nextInt());
        //System.out.println(item1.getQuantity()); //Only for testing.
        System.out.print("\n");
        scnr.nextLine(); //Consume next line. 
        //Item 2 name, price, and quantity.
        //Name.
        System.out.println("Item 2");
        System.out.println("Enter the item name: ");
        item2.setName(scnr.nextLine());
       // System.out.println(item2.getName()); //Only for testing.
        //Price.
        System.out.println("Enter the item price: ");
        item2.setPrice(scnr.nextInt());
        //System.out.println(item2.getPrice()); //Only for testing.
        //Quantity.
        System.out.println("Enter the item quantity: ");
        item2.setQuantity(scnr.nextInt());
        //System.out.println(item2.getQuantity()); //Only for testing.
        
        //Now perform total cost calculation. 
        System.out.println();
        total1 = (item.getQuantity()) * (item.getPrice());
        total2 = (item2.getQuantity()) * (item2.getPrice());
        System.out.println("TOTAL COST");
        System.out.println(item.getName() + " "  + item.getQuantity() + " @ " + 
                "$" + item.getPrice() + " = $" + total1);
        System.out.println(item2.getName() + " "  + item2.getQuantity() + " @ " + 
                "$" + item2.getPrice() + " = $" + total2);
        totalTotal = total1 + total2; 
        System.out.print("\n");
        System.out.println("Total: $" + totalTotal);
        return;
    }
    
}
