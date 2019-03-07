package kingatan;

import java.awt.Toolkit;
/**
 * Prosta gra interaktywna
 * @author Kinga Tańska
 */
public class MainGame {

        /**
         * Główna metoda uruchamiająca grę.
         * Wczytywane są parametry ekranu,
         * ustawiany obszar gry
         * i jego położenie na środku ekranu
         * @param args
         */
	public static void main(String[] args) {
		
                int gameWidth=1024;
                int gameHeight=700;
                
                int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
                int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
                
                int xPosition=(screenWidth-gameWidth)/2;
                int yPosition=(screenHeight-gameHeight)/2;
                
                //utworzenie obiektu klasy GWindow
                GWindow gw = new GWindow(gameWidth, gameHeight, xPosition, yPosition);
                
                
             
	}

}
