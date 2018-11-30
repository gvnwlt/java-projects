package solutions;

public class RectArea {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int upLeftX = 0;
        int upLeftY = 0;
        int loRightX = 0;
        int loRightY = 0;
        int area = 0;

        System.out.print("Enter the X coordinate of the upper left corner: ");
        upLeftX = scanner.nextInt();

        System.out.print("Enter the Y coordinate of the upper left corner: ");
        upLeftY = scanner.nextInt();

        System.out.print("Enter the X coordinate of the lower left corner: ");
        loRightX = scanner.nextInt();

        System.out.print("Enter the Y coordinate of the lower left corner: ");
        loRightY = scanner.nextInt();

        area = (loRightX - upLeftX) * (loRightY - upLeftY);
        System.out.println("The area of the rectangle is: " + area);

        scanner.close();
    }
}
