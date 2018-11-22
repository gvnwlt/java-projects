package examples; 
/*
	This is an example comment block using the forward slash and asterisk
	for commenting large sections rather than "//" for one line. 
*/

public class CommentSquare
{
	public static void main (String[] args) // MAIN METHOD
	{
		// Use a Scanner to read from standard in 
		java.util.Scanner scanner = new java.util.Scanner(System.in); 
		// VARIABLES
		int num = 0; 
		int result = 0; 
		int count = 0; 

		for (count = 0; count < 5; count = count + 1)
		{
			System.out.print("Please enter a number: "); 
			num = scanner.nextInt();
		
			if (num < 46341) 
			{
				result = num * num; 
				System.out.print("The result of squaring " + num); 
				System.out.println(" is: \n" + result); 
			}
			else
			{
				System.err.println("Input # " + num + " is too large."); 
			}
		}

		scanner.close(); 

	}
}
