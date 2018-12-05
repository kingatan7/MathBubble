package kingatan;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
    static Image cursorImage;
    static int MoveMODE;
    static boolean pause=false;
    static boolean end;
    static boolean levelPause=false;
    static Image bgImage;
    static int NO_LEVELS;
    public static int gameWidth=1024;
    public static int gameHeight=768;

	//public static Image cursorImage;

    public static long startTime;
    public static double levelTime;
    

   public static void loadInitialImages() {
                cursorImage=loadImage("images/kursor1.png");
                bgImage=loadImage("images/tlo1.png");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
static Image loadImage(String fileName) {
               return new ImageIcon(fileName).getImage();
    }
}