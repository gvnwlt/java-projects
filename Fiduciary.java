/* This program is to be a financial budgeting, analyasis, and billing app. 
   it will take many forms during the course of its versioning, but this will
   ultimately be an application for intelligent budgeting and personal finance 
   by use of AI techniques. The first implementation resolves solely on creating 
   the plain vanilla budgeting format.*/

import java.util.*; 
import javax.swing.*;
import java.awt.*;

public class Fiduciary {
  
  /* Classes to outsource */ 
  public class FileMenu {
		
  } 

  public class Expenses {}; 
  public class Income {};   
  public class AfterExpenses {}; 
  public class Calculator {}; 

  public class AILearner {}; 
  public class AIDoer {}; 

  /* Set up gui */ 
  public Fiduciary() {
    JFrame frame = new JFrame("Welcome to Fiduciary"); 

    JMenu fileMenu = new JMenu("File"); 
    JMenuItem newItem = new JMenuItem("New"); 
    JMenuItem saveItem = new JMenuItem("Save"); 
    JMenuItem closeItem = new JMenuItem("Close"); 
    JMenuItem exitItem = new JMenuItem("Exit"); 
    fileMenu.add(newItem); 
    fileMenu.add(saveItem); 

    JMenu editMenu = new JMenu("Edit");  
    JMenuItem cutItem = new JMenuItem("Cut"); 
    JMenuItem copyItem = new JMenuItem("Copy"); 
    JMenuItem pasteItem = new JMenuItem("Paste"); 
    editMenu.add(cutItem); 
    editMenu.add(copyItem); 
    editMenu.add(pasteItem); 

    JMenu helpMenu = new JMenu("Help");  
    JMenuItem aboutItem = new JMenuItem("About"); 
    helpMenu.add(aboutItem); 

    JMenuBar menuBar= new JMenuBar(); 
    menuBar.add(fileMenu); 
    menuBar.add(editMenu); 
    menuBar.add(helpMenu); 
    
    frame.setJMenuBar(menuBar); 
    frame.setSize(800, 800); 
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
  }
  
  /* What it has */ 
  //table representation 
  //rows and columns
  //time 
  //date 
  
  
  /* To do */ 
  //save 
  //open 
  //close 
  //exit 
  //export 
  //import(spreadsheets) 
  //enter items 
  //delete items 
  //calculate 
  //predict 
  //analyze 
  //

  public static void main(String[] args) {
    Fiduciary fd = new Fiduciary(); 

  }

}
