package solutions;

public class FahrToCels {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float fahrenheit = 0.0F;

        System.out
                .print("Please enter a temperature in degrees Fahrenheit: ");
        fahrenheit = scanner.nextFloat();

        System.out.print(fahrenheit
                + " degrees Fahrenheit is equivelant to ");
        System.out.println(((fahrenheit - 32) / 1.8F)
                + " degrees Celsius.");

        scanner.close();
    }
}
