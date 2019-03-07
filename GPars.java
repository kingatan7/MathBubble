package kingatan;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Klasa pomocniczna przechowjąca zmienne i obiekty graficzne
 * @author Kinga Tańska
 */

public class GPars {
    /* obiekt graficzny - kursor myszy */
    public static Image cursorImage;
    /* zmienna informująca czy koniec gry */
    public static boolean end;
    /* obiekt graficzny - ikona życia (serce) */
    public static Image lImage;
    /* obiekt graficzny - utrata życia (x) */
    public static Image nlImage;
    /* wymiar pola graficznego */
    public static int gameWidth=1024;
    /* wymiar pola graficznego */
    public static int gameHeight=768;
    /* ilość obiektów - bąbelków */
    public static int nobj=12;
    /* obiekt graficzny - bąbelek */
    public static Image bubbleIm;
    
    /* zmienna do której przypisywany jest czas rozpoczęcia gry */
    public static long startTime;
    /* zmienna do której przypisywany jest czas zakończenia gry */
    public static long endTime;
    
    /**
     * Metoda ładująca grafikę do gry
     */
    
   public static void loadInitialImages() {
                cursorImage=loadImage("images/kursor1.png");
                bubbleIm=loadImage("images/bąbelek.png");
                lImage = loadImage("images/serce.png");
                nlImage = loadImage("images/iks.jpg");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   /**
    * Metoda pobierania grafiki z pliku na podstawie nazwy
    * @param fileName nazwa pliku (String)
    * @return nowa grafika
    */
   
static Image loadImage(String fileName) {
               return new ImageIcon(fileName).getImage();
    }

}