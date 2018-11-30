package solutions;

public class CalculateTip {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float amount = 0.0F;
        float tip10 = 0.0F;
        float tip15 = 0.0F;
        float tip20 = 0.0F;

        System.out
                .print("Please enter the amount of the check/bill: ");
        amount = scanner.nextFloat();

        tip10 = amount * 0.1F;
        tip15 = amount * 0.15F;
        tip20 = amount * 0.2F;

        System.out.println("A 10% tip would be: " + tip10);
        System.out.println("A 15% tip would be: " + tip15);
        System.out.println("A 20% tip would be: " + tip20);

        scanner.close();
    }
}
