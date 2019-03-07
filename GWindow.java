/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Point;

/**
 * Okno gry, klasa dziedzicząca po JFrame
 * @author Kinga Tańska
 */
class GWindow extends JFrame {
    
    /**
     * Konstruktor klasy odpwiada za stworzenie okna i jego widoczność
     * @param gameWidth wysokość okna
     * @param gameHeight szerokość okna
     * @param xPosition położenie na osi x
     * @param yPosition  położenie na osi y
     */
    
    public GWindow(int gameWidth, int gameHeight, int xPosition, int yPosition) {
        
        super();
        setSize(gameWidth, gameHeight);
        setLocation(xPosition, yPosition);
        setResizable(false);
        setUndecorated(true);
        initGUI(gameWidth, gameHeight);
        setVisible(true);
        
    }

    /** 
     * Utworzenie interfejsu graficznego użytkownika
     * @param gameWidth szerokość pola
     * @param gameHeight wysokość pola
     */
    private void initGUI(int gameWidth, int gameHeight) {
        
        setLayout(new GridLayout(1,1));
        GPars.loadInitialImages();
        Toolkit tk=Toolkit.getDefaultToolkit();
        Cursor tCursor;
        tCursor = tk.createCustomCursor(GPars.cursorImage, new Point(30,30) , "Target Cursor");
        setCursor(tCursor);
        add(new GamePanel(gameWidth,gameHeight));

    }

}
