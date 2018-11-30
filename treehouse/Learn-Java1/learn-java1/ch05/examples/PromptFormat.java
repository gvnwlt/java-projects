package examples;

public class PromptFormat {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Define some variables to contain student data
        int stu1Num = 0, stu2Num = 0, stu3Num = 0;
        float stu1Avg = 0.0F, stu2Avg = 0.0F, stu3Avg = 0.0F;
        String stu1Class = "", stu2Class = "", stu3Class = "";

        // Prompt for, and read, data for three students
        System.out.print("Please enter Student #1's student number"
                + " (9999): ");
        stu1Num = scanner.nextInt();
        System.out.print("Please enter Student #1's grade average"
                + " (99.99): ");
        stu1Avg =  scanner.nextFloat();
        System.out.print("      Please enter Student #1's class"
                + " (F/P/J/S): ");
        stu1Class = scanner.next();

        System.out.print("Please enter Student #2's student number"
                + " (9999): ");
        stu2Num = scanner.nextInt();
        System.out.print("Please enter Student #2's grade average"
                + " (99.99): ");
        stu2Avg = scanner.nextFloat();
        System.out.print("      Please enter Student #2's class"
                + " (F/P/J/S): ");
        stu2Class = scanner.next();

        System.out.print("Please enter Student #3's student number"
                + " (9999): ");
        stu3Num = scanner.nextInt();
        System.out.print("Please enter Student #3's grade average"
                + " (99.99): ");
        stu3Avg = scanner.nextFloat();
        System.out.print("      Please enter Student #3's class"
                + " (F/P/J/S): ");
        stu3Class = scanner.next();

        // Format the data and print the student report
        System.out.println("Student Student Student");
        System.out.println(" Number Average  Class");
        System.out.println("------- ------- -------");

        System.out.println("   " + stu1Num + "\t" + stu1Avg + "\t"
                + stu1Class);
        System.out.println("   " + stu2Num + "   " + stu2Avg + "     "
                + stu2Class);
        System.out.println("   " + stu3Num + "   " + stu3Avg + "     "
                + stu3Class);

        System.out.print("-----------------------");
        
        scanner.close();
    }
}