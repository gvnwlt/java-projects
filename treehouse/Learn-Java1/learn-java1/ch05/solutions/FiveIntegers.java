package solutions;

public class FiveIntegers {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;

        System.out.print("Please enter the first number: ");
        num1 = scanner.nextInt();

        System.out.print("Please enter the second number: ");
        num2 = scanner.nextInt();

        System.out.print("Please enter the third number: ");
        num3 = scanner.nextInt();

        System.out.print("Please enter the fourth number: ");
        num4 = scanner.nextInt();

        System.out.print("Please enter the fifth number: ");
        num5 = scanner.nextInt();

        System.out.println("a: " + num1 + " " + num2 + " " + num3
                + " " + num4 + " " + num5);

        System.out.println("b: " + num1 + "\t" + num2 + "\t" + num3
                + "\t" + num4 + "\t" + num5);

        System.out.println("c:\n" + num1 + "\n" + num2 + "\n" + num3
                + "\n" + num4 + "\n" + num5);

        scanner.close();
    }
}
