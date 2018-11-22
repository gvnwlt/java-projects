import java.util.Scanner;

public class HydCalc
{

               /*

                //METHODS FOR GATHERING INPUT INFORMATION

                public int getArea()
                {
                System.out.print("Please enter area: ");
                area = scanner.nextInt();
                return area; 
                }

                public int getForce ()
                {
                System.out.print("Please enter force: ");
                force = scanner.nextInt();
                }

                public int getPressure ()
                {
                System.out.print("Please enter pressure: ");
                pressure = scanner.nextInt();
                }

                //PERFORM CALCULATION BASED ON INPUT 
                if (input == "area")
                {
                 getPressure();
                 getForce();
                 return areaCalc; 
                }

                */

        public static void main (String[] args)
        {
                Scanner scanner = new Scanner(System.in);

                String input = ""; 

                //FPA VARIABLES
                int area = 0;
                int force = 0;
                int pressure = 0;

                //HP VARIABLES
                int psi = 0;
                int gpm = 0;
                int C_HP = 1714;
                int hp = 0;

                
                //CALCULATIONS FOR FPA 
                int areaCalc = 0;     // pressure / force;
                int forceCalc = 0;    // pressure / area;
                int pressureCalc = 0; // force * area;

                //CALCULATIONS FOR HORSEPOWER
                int horsePower = 0;     // (psi * gpm) / C_HP
                int gpmCalc = 0;        // psi / (hp * C_HP)
                int psiCalc = 0; 


                //GET WHAT TYPE OF CALCULATION WE WANT FROM USER

                System.out.print("Choice values: \n\n[area][force][pressure]\n"+
                                 "[horsepower][flowrate][PSI]\n\n"+
                                 "What calcuation would" +
                                 " you like to perform?");
                input = scanner.next();               


             /*   //DISPLAY INPUTS 
                System.out.printf("Area Input = %d \n", area);
                System.out.printf("Force Input = %d \n", force);
                System.out.printf("Pressure Input =  %d\n", pressure);
             */


                //PERFORM CALCULATION BASED ON INPUT 
                if (input.equals("area"))
                {
                        System.out.printf("Enter pressure value: \n");
                        pressure = scanner.nextInt();
                        System.out.printf("Enter force value: \n");
                        force = scanner.nextInt();
                        areaCalc = pressure / force; 
                        System.out.printf("The area is: %s\n", areaCalc);  
                }
                else if (input.equals("pressure")) if (input.equals("pressure"))
                {
                
                        System.out.printf("Enter force value: \n");
                        force = scanner.nextInt();
                        System.out.printf("Enter area value: \n");
                        area = scanner.nextInt();
                        pressureCalc = force * area; 
                        System.out.printf("The pressure is: %s\n", pressureCalc);  
                }
                else if (input.equals("force"))
                {
                        System.out.printf("Enter pressure value: \n");
                        pressure = scanner.nextInt();
                        System.out.printf("Enter area value: \n");
                        area = scanner.nextInt();
                        forceCalc = pressure / area; 
                        System.out.printf("The area is: %s\n", forceCalc);  
                }
                else if (input.equals("horsepower"))
                {
                        System.out.printf("Enter a psi value: \n");
                        psi = scanner.nextInt();
                        System.out.printf("Enter a gpm value: \n");
                        gpm = scanner.nextInt();
                        horsePower = (psi * gpm) / C_HP;
                        System.out.printf("The horsepower rating is: %s", horsePower);
                }
                else if (input.equals("flowrate"))
                {
                        System.out.printf("Enter a hp value: \n");
                        hp = scanner.nextInt();
                        System.out.printf("Enter a psi value: \n");
                        gpmCalc = psi / (hp * C_HP);
                        System.out.printf("The gpm flow is: %s", gpmCalc); 
                }
                else
                {
                        System.out.printf("Choice does not match selection");
                }
         }          
}



                
                        
