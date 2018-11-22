import java.util.*; 

public class OnTrack {
    
     Scanner sc = new Scanner(System.in);     
     String answer;
     String user = "Me: "; 
  
     void theQuestion() {
       System.out.print("Computer: So what's up? "); 
     }
     
     void theAnswer() {
       answer = sc.next();         
       System.out.println(user + answer); 
       answer = ""; 
     }
     
   ublic static void main(String[] args) { 

     OnTrack ot = new OnTrack();  
 
     ot.theQuestion(); 
     ot.theAnswer(); 
    
   }

}
