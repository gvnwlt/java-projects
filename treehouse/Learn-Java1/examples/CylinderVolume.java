package examples; 

public class CylinderVolume 
{
	public static void main (String[] args) 
	{
		java.util.Scanner scanner = new java.util.Scanner(System.in); 
		
		
		float volume = 0.0F, radius = 0.0F, height = 0.0F; 

		System.out.print("Enter the radius of the cyclinder: "); 
		radius = scanner.nextFloat();

		System.out.print("Enter the height of the cyclinder: "); 
		height = scanner.nextFloat(); 

		scanner.close();

		
		if (height < 0 || radius < 0) 
		{
			System.err.println("Neither height nor radius can be "
				+ "negative"); 
			return; 
		}


		volume = 3.14159265F * radius * radius * height; //pi times radius squared 			

		System.out.print("A cylinder of height " + height);
		System.out.print(" and a radius of " + radius);
		System.out.print(" has a volume of " + volume + "\n"); 
		

	}
}
