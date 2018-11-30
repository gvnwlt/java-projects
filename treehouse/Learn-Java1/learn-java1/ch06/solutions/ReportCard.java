package solutions;

public class ReportCard {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float num1 = 0.0F, num2 = 0.0F, num3 = 0.0F;
        float num4 = 0.0F, num5 = 0.0F;
        float gpa = 0.0F;

        System.out
                .print(" Please enter the numeric grade for History: ");
        num1 = scanner.nextFloat();

        System.out
                .print(" Please enter the numeric grade for Geometry: ");
        num2 = scanner.nextFloat();

        System.out
                .print(" Please enter the numeric grade for Science: ");
        num3 = scanner.nextFloat();

        System.out
                .print(" Please enter the numeric grade for English: ");
        num4 = scanner.nextFloat();

        System.out.print(" Please enter the numeric grade for Math: ");
        num5 = scanner.nextFloat();

        // Calculate the GPA
        gpa = (num1 + num2 + num3 + num4 + num5) / 5;

        // Print the report card
        System.out.println("Report Card:");
        System.out.println("\t History .......... " + num1);
        System.out.println("\t Geometry ......... " + num2);
        System.out.println("\t Science .......... " + num3);
        System.out.println("\t English .......... " + num4);
        System.out.println("\t Math ............. " + num5);

        System.out.println("Grade point average >> " + gpa);

        scanner.close();
    }
}
