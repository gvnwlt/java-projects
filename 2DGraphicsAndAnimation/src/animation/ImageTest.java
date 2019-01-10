/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.*; 
import javax.swing.ImageIcon; 
import javax.swing.JFrame; 

/**
 *
 * @author gwalters
 */
public class ImageTest extends JFrame {
    
    public static void main(String[] args) {
        
        DisplayMode displayMode; 
        
        if (args.length == 3) {
            displayMode = new DisplayMode(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                DisplayMode.REFRESH_RATE_UNKNOWN); 
        }
        else {
            displayMode = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN); 
        }
        
        ImageTest test = new ImageTest(); 
        test.run(displayMode); 
    }
    
    private static final int FONT_SIZE = 24; 
    private static final long DEMO_TIME = 10000; 
    
    private SimpleScreenManager screen;
    private Image bgImage; 
    private Image opaqueImage; 
    private Image transparentImage; 
    private Image translucentImage; 
    private Image antiAliasedImage; 
    private boolean imagesLoaded; 
    
    public void run(DisplayMode displayMode) {
        setBackground(Color.blue); 
        setForeground(Color.white); 
        setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE)); 
        imagesLoaded = false; 
        
        screen = new SimpleScreenManager(); 
        try {
            screen.setFullScreen(displayMode, this);
            loadImages();
            try {
                Thread.sleep(DEMO_TIME);
            }
            catch (InterruptedException ex) {
                
            }
        }
        finally {
            screen.restoreScreen();
        }
    }
    
    private void loadImages() {
        bgImage = loadImage("Resources/bg_img.jpg");
        opaqueImage = loadImage("Resouces/opaque.png");
        transparentImage = loadImage("Resources/transparent.png");
        translucentImage = loadImage("Resources/translucent.png"); 
        antiAliasedImage = loadImage("Resources/antialiased.png"); 
        imagesLoaded = true; 
        repaint(); 
    }
    
    private Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage(); 
    }
    
    public void paint(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D)g; 
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        }
        
        if (imagesLoaded) {
            g.drawImage(bgImage, 0, 0, null); 
            drawImage(g, opaqueImage, 200, 500, "Opaque"); 
            drawImage(g, transparentImage, 1000, 0, "Transparent");
            drawImage(g, translucentImage, 320, 300, "Translucent");
            drawImage(g, antiAliasedImage, 800, 300, "Translucent (Anti-Aliased)"); 
        }
        else {
            g.drawString("Loading Images...", 5, FONT_SIZE);
        }
    }
    
    public void drawImage(Graphics g, Image image, int x, int y, String caption) {
        g.drawImage(image, x, y, null);
        g.drawString(caption, x + 5, y + FONT_SIZE + image.getHeight(null));
    }
}
