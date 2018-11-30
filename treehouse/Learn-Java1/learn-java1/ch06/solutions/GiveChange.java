package solutions;

public class GiveChange {
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

        scanner.close();
    }
}
