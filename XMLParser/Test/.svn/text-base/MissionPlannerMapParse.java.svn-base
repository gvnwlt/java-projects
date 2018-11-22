import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder; 
import org.w3c.dom.Document; 
import org.w3c.dom.NodeList; 
import org.w3c.dom.Node; 
import org.w3c.dom.Element; 
import java.io.File; 

public class MissionPlannerMapParse {


  public static void main(String[] args) {
 

    try {

      File fXmlFile = new File(""); // What kind of input and from where?
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  // Allows to obtain parser.  
      Document doc = dBuilder.parse(fXmlFile); 
      

      doc.getDocumentElement().normalize(); 

      NodeList nList = doc.getElementsByTagName("Global") ; 

      
      for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);  
 
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          
          Element eElement = (Element) nNode;          

          System.out.println(eElement.getElementsByTagName("MarkerSize").item(0).getTextContent());  
        }

      }   


    } catch (Exception e) {

        e.printStackTrace(); 

      }

  }

}
