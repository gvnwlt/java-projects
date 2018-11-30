package solutions;

public class Circle1 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float radius = 0.0F;
        float circum = 0.0F;

        System.out.print("Enter the radius of the circle: ");
        radius = scanner.nextFloat();

        circum = 2.0F * 3.14159265F * radius;

        System.out.print("A circle of radius " + radius);
        System.out.println(" has a circumference of " + circum);

        scanner.close();
    }
}
