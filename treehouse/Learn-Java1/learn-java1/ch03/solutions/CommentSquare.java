package solutions;

/**********************************************************
 * Calculate the squares of five numbers less than 46341  *
 **********************************************************/

public class CommentSquare {
    // the program starts here
    public static void main(String[] args) {
        // Use a Scanner to read from standard in
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Declare some variables
        int num = 0;
        int result = 0;
        int count = 0;

        // Do the calculation five times
        for (count = 0; count < 5; count = count + 1) {
            // Ask for the number to square and get it from the keyboard
            System.out.print("Please enter a number: ");
            num = scanner.nextInt();

            // Make sure the number isn't too big
            if (num < 46341) {
                // Calculate the square and print it on the screen
                result = num * num;
                System.out.print("The result of squaring " + num);
                System.out.println(" is: " + result);
            } 
            // Otherwise print an error message
            else {
                System.err.println("Input # " + num + " is too large.");
            }
        }
        scanner.close();
    }
}
