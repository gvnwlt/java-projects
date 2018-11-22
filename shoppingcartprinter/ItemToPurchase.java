/*
 * This class will store the object items to be purchased. 
 */
//package shoppingcartprinter;

/**
 *
 * @author Gavin Walters
 */
public class ItemToPurchase {
    //Private fields. 
    private String itemName; 
    private int itemPrice; 
    private int itemQuantity; 
    
    //Default constructor
    public ItemToPurchase () {
    this.itemName = "none";
    this.itemPrice = 0; 
    this.itemQuantity = 0;
    }
    
    
    //Mutators(setters)
    public void setName(String name){
      this.itemName = name; 
      return;        
    }
    public void setPrice(int price) {
      this.itemPrice = price;
      return;
    }
    public void setQuantity(int quantity) {
      this.itemQuantity = quantity;
      return;
    }
    //Accessors(getters)
    public String getName() {
      return this.itemName;
    }
    public int getPrice() {
      return this.itemPrice;
    }
    public int getQuantity() {
      return this.itemQuantity;
    }
}
