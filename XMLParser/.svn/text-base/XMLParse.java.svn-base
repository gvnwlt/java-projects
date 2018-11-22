
import java.util.Properties; 
import java.io.FileInputStream; 

public class XMLParse  {


   
   static {
     

     try {

       Properties prop = new Properties(); 

       prop.loadFromXML(new FileInputStream("/home/amht/CSC506/Software/Walters/XMLParser/xmls/cybernetLongDistance.xml")); //Push XML into input.  
       //prop.list(System.out); // Spit out list of properties.  
       String propertyToBeGotten = prop.getProperty("armadillo.mdf.file"); 
       System.out.println(propertyToBeGotten); 

     } catch (Exception e) {

         e.printStackTrace(); 

    }

  }


}
