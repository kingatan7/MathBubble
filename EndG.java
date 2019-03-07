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
 * Klasa odpowiedzialna za okno pokazujące się gry użytkownik wygra
 * pokazująca czas gry i ilosć punktów
 * dziedzicząca po JFrame
 * @author Kinga Tańska
 */
public class EndG extends JFrame{
    
    public Font inFont;
    public String i1,i2,i3,i4;
    
     /**
     * Konstruktor klasy
     * Posiada opis wyglądu okna
     */
    
    public EndG(){
    super("WYGRANA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(175,150,1024,300);
        
        inFont=new Font("Dialog",PLAIN, 18);
        setVisible(true);

        double gameTime=((GPars.endTime-GPars.startTime)/1000);
        
        add(new JPanel(){
            @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
             
                g = (Graphics2D)gs;
                g.setColor(Color.black);
                g.clearRect(0, 0, 0,0);
                i1="Gra ukończona.";
                i2="Wskazales  ";
                i3=" blednych dzialan w czasie: ";
                i4=" s. Gratulacje!";
                
                g.setFont(inFont);
                g.drawString(i1, 20,80);
                g.drawString(i2+MathBubble.suma_pkt+i3+gameTime+i4,20,100);
                
         }
         
        });
        repaint();
        
}
}
