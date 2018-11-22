import java.util.Scanner; 

class DoesItSuck
{

	static String answer; 
	static Scanner scanner = new Scanner(System.in); 
		

	public static void main (String[] args)
	{
		System.out.print("Hello...tell me...does it suck that your neighbors trample up"+
				 " and down they stairs like wild monkeys?");
		
		answer = scanner.next(); 
		
		System.out.println("You said " + answer + ". Is that correct?"); 
		
		answer = scanner.next(); 

		System.out.println("You are correct..."); 


	}
}
