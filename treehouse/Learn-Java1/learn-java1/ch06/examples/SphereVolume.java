package examples;

public class SphereVolume {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float volume = 0.0F, radius = 0.0F;

        System.out.print("Enter the radius of the sphere: ");
        radius = scanner.nextFloat();

        volume = 4.0F / 3.0F * 3.14159265F * radius * radius * radius;
        System.out.print("A sphere of radius " + radius);
        System.out.println(" has a volume of " + volume);
        
        scanner.close();
    }
}
