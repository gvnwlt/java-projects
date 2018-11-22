package examples;

public class Average4 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float n1 = 0.0F, n2 = 0.0F, n3 = 0.0F, n4 = 0.0F;
        float average = 0.0F;

        System.out.println("Enter any four numbers: ");
        System.out.print("       #1: ");
        n1 = scanner.nextFloat();
        System.out.print("       #2: ");
        n2 = scanner.nextFloat();
        System.out.print("       #3: ");
        n3 = scanner.nextFloat();
        System.out.print("       #4: ");
        n4 = scanner.nextFloat();

        // Calculate the result and store it in the variable average:
        average = (n1 + n2 + n3 + n4) / 4;

        System.out.print("The average of (" + n1 + ", " + n2 + ", ");
        System.out.print(n3 + ", " + n4 + ") is: ");
        System.out.println(average);

        scanner.close();
    }
}
