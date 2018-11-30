//Program to determine the area and circumference of a circle 

import javax.swing.JOptionPane; 

public class AreaAndCircumferenceProgram
{
   public static void main(String[] args)
   {
      double radius;
      double area; 
      double circumference; 
      
      String radiusString;
      String outputStr; 
      
      radiusString = 
         JOptionPane.showInputDialog
                     ("Enter the radius: "); 
      
      radius = Double.parseDouble(radiusString); 
      
      area = Math.PI * radius * radius; 
      circumference = 2 * Math.PI * radius; 
      
      outputStr = "Radius: " + radius + "\n" +
                  "Area: " + area + " square units\n" + 
                  "Circumference: " + circumference + 
                  " units"; 
                  
      JOptionPane.showMessageDialog(null, outputStr, 
                                    "Circle", 
                  JOptionPane.INFORMATION_MESSAGE); 
                  
      System.exit(0); 
   }
}                                           
                    