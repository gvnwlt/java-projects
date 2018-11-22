/*
 *************************************************************************
 *
 *  File: TestScores.java
 *  Date: 05/28/2016
 *
 * Author: Gavin J. Walters
 *
 *************************************************************************
  */




/*Design a GUI program to find the weighted average of four test scores. The four test scores and their respective weights are given in the following format:

testscore1 weight1
...

For example, the sample data is as follows:

75 0.20
95 0.35
85 0.15
65 0.30

The user is supposed to enter the data and press a Calculate button. The program must display the weighted average.*/

import javax.swing.*; 
import java.awt.*; 

public class TestScores extends JFrame
{
   private static final int WIDTH = 300;
   private static final int HEIGHT = 500; 
   
   private JLabel score1, score2, score3, score4; 
   private JTextField score1TF, score2TF, score3TF, score4TF; 
   
   private JButton calculateButton, exitButton; 
   private CalculateButtonHandler cbHandler; 
   private ExitButtonHandler ebHandler; 


   
   public TestScores()
   {
      setTitle("Weighted Test Scores"); 
      
      score1 = 
         new JLabel("Enter score 1: ", SwingConstants.RIGHT); 
      score2 = 
         new JLabel("Enter score 2: ", SwingConstants.RIGHT); 
      score3 = 
         new JLabel("Enter score 3: ", SwingConstants.RIGHT); 
      score4 = 
         new JLabel("Enter score 4: ", SwingConstants.RIGHT);          
     
     score1TF = new JTextField(10);
     score2TF = new JTextField(10); 
     score3TF = new JTextField(10); 
     score4TF = new JTextField(10);  
     
     Container pane = getContentPane(); 
     pane.setLayout(new GridLayout(4, 2)); 
     
     pane.add(score1);
     pane.add(score1TF);
     pane.add(score2);
     pane.add(score2TF);
     pane.add(score3);
     pane.add(score3TF);
     pane.add(score4);
     pane.add(score4TF);
     
     setSize(WIDTH, HEIGHT); 
     setVisible(true); 
     setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
   
   public static void main(String[] args)
   {
      TestScores testobject = new TestScores(); 
   }
}
   