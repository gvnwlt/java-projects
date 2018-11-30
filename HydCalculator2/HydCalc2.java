import java.util.Scanner;

public class HydCalc2
{
        public static void main (String[] args)
        {
                Scanner scanner = new Scanner(System.in);

                String input = ""; 

                
                //HP VARIABLES
                int vPsi = 0;
                int gpm = 0;
		int hp = 0;	
                int C_HP = 1714;
                

                //CALCULATIONS FOR HORSEPOWER
                int horsePowerCalc = 0;     // (psi * gpm) / C_HP
                int gpmCalc = 0;        // psi / (hp * C_HP)
                int psiCalc = 0; 	// (horsepower * C_HP) / gpm


                //GET WHAT TYPE OF CALCULATION WE WANT FROM USER

                System.out.print("Choice values: \n\n\n"+
                                 "[horsepower]\t[flowrate]\t[psi]\n\n"+
                                 "What calcuation would" +
                                 " you like to perform?\t\u0007");
                input = scanner.next();               


            


                //PERFORM CALCULATION BASED ON INPUT 
                

                if (input.equals("horsepower"))
                {
                        System.out.printf("Enter a psi value: \t\u0007");
                        vPsi = scanner.nextInt();
                        System.out.printf("Enter a gpm value: \t\u0007");
                        gpm = scanner.nextInt();
                        horsePowerCalc = (vPsi * gpm) / C_HP;
                        System.out.printf("The horsepower rating is: %s\n\u0007", horsePowerCalc);
			return;
                }

                if (input.equals("flowrate"))
                {
                        System.out.printf("Enter a hp value: \n\u0007");
                        hp = scanner.nextInt();
                        System.out.printf("Enter a psi value: \n\u0007");
			vPsi = scanner.nextInt();
                        gpmCalc = vPsi / (hp * C_HP);
                        System.out.printf("The gpm flow is: %s\n\u0007", gpmCalc); 
			return;
                }
		if (input.equals("psi"))
		{
			System.out.printf("Enter horsepower value: \n\u0007"); 
			hp = scanner.nextInt(); 
			System.out.printf("Enter a gpm value: \n\u0007");
			gpm = scanner.nextInt(); 
			psiCalc = (hp * C_HP) / gpm; 
			System.out.printf("The psi value is: %s\n\u0007", psiCalc); 
                }
         }          
}



                
                        
