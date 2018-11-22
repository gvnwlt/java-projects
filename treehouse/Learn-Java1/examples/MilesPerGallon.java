package examples; 

public class MilesPerGallon
{
	public static void main (String[] args)
	{
		java.util.Scanner scanner = new java.util.Scanner(System.in); 

		
		float milesTraveled = 0.0F; 
		float gallonsUsed = 0.0F; 
		float milesPerGallon = 0.0F; 

		System.out.print("Please enter the number of miles"
				+ " traveled: "); 
		milesTraveled = scanner.nextFloat(); 

		System.out.print("Please enter the number of gallons" 
				+ " used: "); 
		gallonsUsed = scanner.nextFloat();

		
		milesPerGallon = milesTraveled / gallonsUsed; 

		
		System.out.print("You traveled " + milesPerGallon); 
		System.out.println(" miles for every gallon of fuel"
				  + " used."); 
	
		scanner.close(); 

		

    	}
}
