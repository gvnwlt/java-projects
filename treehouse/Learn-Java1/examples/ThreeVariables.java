package examples; 

public class ThreeVariables
{
	public static void main (String[] args)
	{
		int deptNum = 0; 
		float salary = 0; 
		int jobClass = 0; 

		java.util.Scanner scanner = new java.util.Scanner(System.in); 

		System.out.print("Enter your department number:  "); 
		deptNum = scanner.nextInt(); 

		System.out.print("Enter your salary amount:  "); 
		salary = scanner.nextFloat(); 

		System.out.print("Enter you job class number:  ");
		jobClass = scanner.nextInt(); 

		
		System.out.printf("<Department Number: " + deptNum + " > <Salary: " + 
				  salary + " > <Job Class "+
				  "Number: " + jobClass + " >\n"); 
		System.out.printf("<Department Number: " + deptNum + " > \t<Salary: " + 
				  salary + " >\t<Job Class "+
				  "Number: " + jobClass + " >\n"); 
		System.out.printf("<Department Number: " + deptNum + " > \n<Salary: " + 
				  salary + " >\n<Job Class "+
				  "Number: " + jobClass + " >\n"); 	
	}
}
