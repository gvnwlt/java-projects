package solutions;

public class NextLargestMultiple {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int i = 0;
        int j = 0;

        System.out.print("Enter a number: ");
        i = scanner.nextInt();

        System.out.print("Enter the multiple value: ");
        j = scanner.nextInt();

        System.out.println("The next even largest multiple of " + i);
        System.out.println(" divided by " + j + " is "
                + (i + j - i % j));

        scanner.close();
    }
}
