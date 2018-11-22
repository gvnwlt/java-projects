package examples; 

public class FiveIntegers
{
	public static void main (String[] args)
	{
		

		int num1 = 0; 
		int num2 = 0; 
		int num3 = 0; 
		int num4 = 0; 
		int num5 = 0; 

		int count = 0; 

		java.util.Scanner scanner = new java.util.Scanner(System.in); 



		System.out.print("Please enter a number:  "); 
		num1 = scanner.nextInt(); 

		System.out.print("Please enter a number:  "); 
		num2 = scanner.nextInt(); 

		System.out.print("Please enter a number:  "); 
		num3 = scanner.nextInt(); 

		System.out.print("Please enter a number:  "); 
		num4 = scanner.nextInt(); 

		System.out.print("Please enter a number:  "); 
		num5 = scanner.nextInt(); 

		
		System.out.printf("\n" + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + 					  "\n"); 
		System.out.printf("\n" + num1 + "\t" + num2 + "\t" + num3 + "\t" + num4 + "\t" + 					  num5 + "\n");
		System.out.printf("\n" + num1 + "\n" + num2 + "\n" + num3 + "\n" + num4 + "\n" + 					  num5 + "\n\n");
	
	}
}
