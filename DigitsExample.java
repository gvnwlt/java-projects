/*
 *************************************************************************
 *
 *  File: DigitsExample.java
 *  Date: 04/17/2016
 *
 * Author: John W. Graham
 *
 *************************************************************************
  */

/**
 * This class provides examples of digit formatting.  
 */
public class DigitsExample {

    /**
     * @param args Program Arguments
     */
    public static void main(String[] args) {
        DigitsExample example = new DigitsExample();
        example.testDigits();
    }
    
    private void testDigits() {
        double testValue = Math.PI;
        
        // test one: using printf.  The %.3f placeholder
        // tells printf to print three digits after the decimal.
        // the \n tells it to print a newline character
        System.out.printf("Pi to three digits after the decimal: %.3f\n", testValue);
        
        // test two: using DecimalFormat
        // #0.00 says display a number in the format x.xx
        // setMaximumFractionDigits ensures there will be only 2 digits in the fraction portion
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        System.out.println("Pi to two digits after the decimal: " + df.format(testValue));
        
        // test three: String.format
        // %.5f is the same as was used in printf except we say use 5 digits
        String s = String.format("%.5f", testValue);
        System.out.println("Pi to five digits after the decimal: " + s);
    }
}