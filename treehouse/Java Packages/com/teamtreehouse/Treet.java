package  com.teamtreehouse; 

import java.io.Serializable; 
import java.util.Date; 

public class Treet implements Comparable, Serializable {
  private static final long serialVersionUID = 7146681148113043748L;
  private boolean mBreakIt = true; 
  private String mAuthor; 
  private String mDescription; 
  private Date mCreationDate; 
  
  public Treet(String author, String description, Date creationDate) {
    mAuthor = author; 
    mDescription = description; 
    mCreationDate = creationDate; 
  }
  
  @Override
  public String toString() {
    return String.format("Treet:  \"%s\" by %s on %s", 
                         mDescription, mAuthor, mCreationDate);
  }
  
  @Override
  public int compareTo(Object obj) { //whenever this method is called upon--think sort method--its parameters are now changed to meet specific needs-that's what the override is about 
    Treet other = (Treet) obj; 
    if (equals(other)) { 
      return 0;  
    }
    int dateCmp = mCreationDate.compareTo(other.mCreationDate); 
    if (dateCmp == 0) {
      return mDescription.compareTo(other.mDescription);   //by return these values in compareTo, the sort method knows how to sort these properly by their value...
    }
    return dateCmp; 
  }
  
  public String getAuthor() {
    return mAuthor;  
  }
  
  public String getDescription() {
    return mDescription;  
  }
  
  public Date getCreationDate() {
    return mCreationDate;  
  }
  
  public String[] getWords() {
   return  mDescription.toLowerCase().split("[^\\w#@']+"); //array method
  }
  
}