/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnablethread;

/**
 *
 * @author gwalters
 */
public class RunnableThread implements Runnable {

    public RunnableThread() {
        Thread thread = new Thread(this);
        thread.start(); 
    }
    
    public void run() {
        System.out.println("Do something cool here.");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new RunnableThread(); 
        
        // anonymous inner class
        new Thread() {
            public void run() {
                System.out.println("Do something cool here also...");
            }
        }.start(); 
        
    }
    
}
