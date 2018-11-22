package examples;

public class Formatting {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int var1 = 0, var2 = 0;

        System.out.print("Please enter a number: ");
        var1 = scanner.nextInt();
        System.out.print("Please enter another number: ");
        var2 = scanner.nextInt();

        // No formatting at all:
        System.out.println("No format: " + var1 + var2 + 
                (var1 + var2) + "\n");

        // Some simple formatting:
        System.out.print("The sum of " + var1 + " and " + var2);
        System.out.println(" is " + (var1 + var2) + "\n");

        // A different way:
        System.out.println("\t" + var1 + "\n+\t" + var2);
        System.out.println("-----------\n\t" + (var1 + var2) + "\n");

        // Maybe a little too much formatting?
        System.out.println("The Amazing SUM Program !!!!!!!!!!!!\n");
        System.out.println("**************************************");
        System.out.println("**\tThe sum of the number\t" + var1);
        System.out.println("**\t  added to the number\t" + var2);
        System.out.println("**\t results in...");
        System.out.println("**************************************");
        System.out.println("**\t\t   Ta DA!\t" + (var1 + var2));
        System.out.println("**************************************");

        scanner.close();
    }
}
