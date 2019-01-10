/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.*; 
import javax.swing.JFrame; 

/**
 *
 * @author gwalters
 */
public class SimpleScreenManager {

    /**
     * @param args the command line arguments
     */
    
    private GraphicsDevice device; 
    
    public SimpleScreenManager() {
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        device = environment.getDefaultScreenDevice(); 
    }
    
    public void setFullScreen(DisplayMode displayMode, JFrame window) {
        window.setUndecorated(true); 
        window.setResizable(false); 
        
        device.setFullScreenWindow(window);
        if (displayMode != null && device.isDisplayChangeSupported()) {
            try {
                device.setDisplayMode(displayMode); 
            }
            catch (IllegalArgumentException ex) {
                
            }
        }
    }
    
    public Window getFullScreenWindow() {
        return device.getFullScreenWindow(); 
    }
    
    public void restoreScreen() {
        Window window = device.getFullScreenWindow(); 
        if (window != null) {
            window.dispose();
        }
        device.setFullScreenWindow(null); 
    }
    
}
