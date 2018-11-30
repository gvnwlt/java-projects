package solutions;

public class GiveChangeCoins {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float invoice = 0.0F;
        float tendered = 0.0F;
        float change = 0.0F;

        System.out.print("Enter the amount of the bill or invoice: ");
        invoice = scanner.nextFloat();

        System.out.print("Enter the amount tendered from the customer: ");
        tendered = scanner.nextFloat();

        change = tendered - invoice;
        System.out.println("The change to give back to the customer is: "
                        + change);

        // Truncate the fraction from change by converting to an integer
        // To do this we need an explicit cast, like this:
        int bills = (int) change;

        // Find the fractional part of the change
        float coins = change - bills;

        // Convert coins to an integer for easy calculation
        // To do this we need an explicit cast:
        // This trick rounds to the nearest penny (try $14.06 from a twenty):
        int cents = (int) ((coins + .005) * 100);

        System.out.println("Bills:    " + bills);

        // Quarters first (ignore half-dollars...)
        System.out.print("Quarters: " + cents / 25);
        System.out.println("\t(." + (cents / 25) * 25 + ")");
        cents = cents % 25; // Get the remainder

        System.out.print("Dimes:    " + cents / 10);
        System.out.println("\t(." + (cents / 10) * 10 + ")");
        cents = cents % 10; // Get the remainder

        System.out.print("Nickels:  " + cents / 5);
        System.out.println("\t(." + (cents / 5) * 5 + ")");
        cents = cents % 5; // Get the remainder

        System.out.print("Pennies:  " + cents);
        System.out.println("\t(." + cents + ")");
        
        scanner.close();
    }
}
