package com.teamtreehouse;

import java.io.Serializable;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Date;
import java.util.List; 

public class Treet implements Comparable<Treet>, Serializable {
  
  private static final long serialVersionUID = 7146681148113043748L;
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
                         mDescription, mAuthor, mCreationDate); //If I'm using Treet class this method is included--modified string version and it will do this when I string something with the treet class
  }
  
  @Override
  public int compareTo(Treet other) {
    if (equals(other)) {
      return 0;
    }
    int dateCmp = mCreationDate.compareTo(other.mCreationDate);
    if (dateCmp == 0) {
      return mDescription.compareTo(other.mDescription);
    }
    return dateCmp;
  }                                                             //Same concept as override toString-- this will do what is stated as a modified function call in the context of "Treet" class. 
  
  public String getAuthor() {
    return mAuthor;
  }
  
  public String getDescription() {
    return mDescription;
  }
  
  public Date getCreationDate() {
    return mCreationDate;
  }
  
  public List<String> getWords() {                                  //Creates a getWords method of the "array" type. 
   String[] words = mDescription.toLowerCase().split("[^\\w#@']+"); 
   return Arrays.asList(words); 
    
  }
  
   public List<String> getHashTags() {
    return getWordsPrefixedWith("#"); 
  }
  
  public List<String> getMentions() {
    return getWordsPrefixedWith("@"); 
  }
  
  private List<String> getWordsPrefixedWith(String prefix) {
    List<String> results = new ArrayList<String>(); 
    for (String word: getWords()) {
      if (word.startsWith(prefix)) {
        results.add(word);
      }
  }
    return results; 
  }
  
 
}