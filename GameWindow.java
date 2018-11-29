/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
class GameWindow extends JFrame {
    
    public GameWindow(int width, int height, int x, int y){
        super("Math-Bubble");
        setSize(width, height);
        setLocation(x,y);
        setResizable(false);
        setUndecorated(true);
        initGUI(width,height);
        setVisible(true);
        animationLoop();
        
    }

    private void initGUI(int width, int height) {
        setLayout(new GridLayout(1,1));
        GPars.loadInitialImages();
        Toolkit tk=Toolkit.getDefaultToolkit();
        Cursor tCursor = tk.createCustomCursor(GPars.cursorImage, new Point(10,10), "Target Cursor");
        setCursor(tCursor);
        add(new GamePanel(width,height));
    }

    private void animationLoop() {
        
    }
}
