package kingatan;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
    public static Image cursorImage;
    public static boolean end;
    public static Image bgImage;
    public static Image lImage;
    public static Image nlImage;
    public static int NO_LEVELS;
    public static int gameWidth=1024;
    public static int gameHeight=768;
    public static int nobj=12;
    public static Image bubbleIm;
    

    public static long startTime;
    public static double levelTime;
    

   public static void loadInitialImages() {
                cursorImage=loadImage("images/kursor1.png");
                bubbleIm=loadImage("images/bąbelek.png");
                lImage = loadImage("images/serce.png");
                nlImage = loadImage("images/iks.jpg");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
static Image loadImage(String fileName) {
               return new ImageIcon(fileName).getImage();
    }

}