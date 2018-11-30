package solutions;

public class Squares {
    public static void main(String[] args) {
        // Use a Scanner to read from standard in
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int num = 0;
        int result = 0;
        int count = 0;

        for (count = 0; count < 5; count = count + 1) {
            System.out.print("Please enter a number: ");
            num = scanner.nextInt();

            if (num < 46341) {
                result = num * num;
                System.out.print("The result of squaring " + num);
                System.out.println(" is: " + result);
            } 
            else {
                System.err.println("Input # " + num + " is too large.");
            }
        }
        scanner.close();
    }
}
