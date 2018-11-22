//**********************************************************************************************************
//Author D.S. Malik 
//
//Program: Movie ticket sale and donation to charity. 
//This program prompts the user to input the movie name, adult
//ticket price, child ticket price, number of adult tickets
//sold, number of child tickets sold, and the percentage of the 
//gross amount to be donated to the charity. 
//The program outputs the movie name, the number of tickets
//sold, the gross amount, the percentage of the gross amount
//donated to the charity, the amount donated to the charity,
//and the net amount. 
//**********************************************************************************************************

import javax.swing.JOptionPane; 

public class MovieTicketsSale
{
   public static void main(String[] args)
   {
                  //Step 1 
      String movieName; 
      String inputStr; 
      String outputStr; 
      
      double adultTicketPrices; 
      double childTicketPrices; 
      
      int noOfAdultTicketsSold; 
      int noOfChildTicketsSold;
      
      double percentDonation; 
      double grossAmount;
      double amountDonated; 
      double netSaleAmount; 
      
      movieName = JOptionPane.showInputDialog
                  ("Enter the movie name"); 
                  
      inputStr = JOptionPane.showInputDialog
                  ("Enter the price of an adult ticket"); 
      adultTicketPrices = Double.parseDouble(inputStr); 
      
      inputStr = JOptionPane.showInputDialog
                  ("Enter the price of a child ticket");
      childTicketPrices = Double.parseDouble(inputStr); 
      
      inputStr = JOptionPane.showInputDialog
                  ("Enter the number of adult tickets sold"); 
      noOfAdultTicketsSold = Integer.parseInt(inputStr);
      
      inputStr = JOptionPane.showInputDialog
                  ("Enter the number of child tickets sold"); 
      noOfChildTicketsSold = Integer.parseInt(inputStr); 
      
      inputStr = JOptionPane.showInputDialog
                  ("Enter the percentage of the donation");
      percentDonation = Double.parseDouble(inputStr); 
      
      grossAmount = adultTicketPrices * noOfAdultTicketsSold + 
                 childTicketPrices * noOfChildTicketsSold; 
                 
      amountDonated = grossAmount * percentDonation / 100; 
      netSaleAmount = grossAmount - amountDonated; 
      
         outputStr = "Movie Name: " + movieName + "\n"
                   + "Number of Tickets Sold: "
                   + (noOfAdultTicketsSold + 
                     noOfChildTicketsSold) + "\n"
                   + "Gross Amount: $"
                   + String.format("%.2f", grossAmount) + "\n"
                   + "Percentage of the Gross Amount Donated: "
                   + String.format("%.2f", percentDonation) + "\n"
                   + "Amount Donated: $"
                   + String.format("%.2f", amountDonated) + "\n"
                   + "Net Sale: $"
                 + String.format("%.2f", netSaleAmount);
         JOptionPane.showMessageDialog(null, outputStr,
                            "Theater Sales Data", 
                          JOptionPane.INFORMATION_MESSAGE);
         System.exit(0); 
       }
}
                                                         
   