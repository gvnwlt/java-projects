package solutions;

public class ThreeVariables {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int deptNum = 0;
        float salary = 0.0F;
        int jobClass = 0;

        System.out.print(" Please enter the department number: ");
        deptNum = scanner.nextInt();

        System.out.print("           Please enter the salary : ");
        salary = scanner.nextFloat();

        System.out.print("        Please enter the job class : ");
        jobClass = scanner.nextInt();

        System.out.println("a: " + "Department Number: " + deptNum
                + " " + "Salary: " + salary + " " + "Job class: "
                + jobClass);

        System.out.println("b: " + "Department Number: " + deptNum
                + "\t" + "Salary: " + salary + "\t" + "Job class: "
                + jobClass);

        System.out.println("c:\n" + "Department Number: " + deptNum
                + "\n" + "Salary: " + salary + "\n" + "Job class: "
                + jobClass);
        
        scanner.close();
    }
}
