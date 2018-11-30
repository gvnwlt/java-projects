package solutions;

public class Divide {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int dividend = 0;
        int divisor = 0;
        int result = 0;

        System.out.print("Please enter an integer number: ");
        dividend = scanner.nextInt();

        System.out.print("Please enter another: ");
        divisor = scanner.nextInt();

        result = dividend / divisor;
        System.out.println(dividend + "/" + divisor + " equals "
                + result);

        scanner.close();
    }
}
