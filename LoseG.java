/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasa odpowiedzialna za okno pokazujące się gry użytkownik przegra
 * dziedzicząca po JFrame
 * @author Kinga Tańska
 */
public class LoseG extends JFrame {
    
    public Font inFont;
    public String i1;
    
    /**
     * Konstruktor klasy
     * Posiada opis wyglądu okna
     */
    public LoseG(){
        
        super("KONIEC GRY");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400,400,350,150);
        
        inFont=new Font("Dialog",PLAIN, 18);
        setVisible(true);
        add(new JPanel(){
            @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
             
                g = (Graphics2D)gs;
                g.setColor(Color.black);
                g.clearRect(0, 0, 0,0);
                i1="Przegrałeś gre. Spróbuj ponownie";
                
                g.setFont(inFont);
                g.drawString(i1, 20,80);  
         }
        });
        repaint();
    }
}
