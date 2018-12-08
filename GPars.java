package kingatan;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
    public static Image cursorImage;
    public static int MoveMODE=1;
    public static boolean pause=false;
    public static boolean end;
    public static boolean levelPause=false;
    public static Image bgImage;
    public static int NO_LEVELS;
    public static int gameWidth=1024;
    public static int gameHeight=768;
    public static int nobj=12;
    public static Image bubbleIm;
    
	//public static Image cursorImage;

    public static long startTime;
    public static double levelTime;
    

   public static void loadInitialImages() {
                cursorImage=loadImage("images/kursor1.png");
                bgImage=loadImage("images/tlo2.jpg");
                bubbleIm=loadImage("images/bąbelek.png");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
static Image loadImage(String fileName) {
               return new ImageIcon(fileName).getImage();
    }
}