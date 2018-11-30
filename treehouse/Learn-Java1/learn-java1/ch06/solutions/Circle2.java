package solutions;

public class Circle2 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float radius = 0.0F;
        float circum = 0.0F;
        float area   = 0.0F;

        System.out.print("Enter the radius of the circle: ");
        radius = scanner.nextFloat();

        circum = 2.0F * 3.14159265F * radius;
        area = 3.14159265F * radius * radius;

        System.out.print("A circle of radius " + radius);
        System.out.print(" has a circumference of " + circum);
        System.out.println(" and an area of " + area);

        scanner.close();
    }
}