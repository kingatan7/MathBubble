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
 * Okno pomocy, klasa dziedzicząca po JFrame
 * @author DELL
 */
public class HelpWindow extends JFrame {
      
   public String i1,i2,i3,i4,i5,i6;
   public Font inFont;
    
   /**
    * Konstruktor klasy, odpowiedzialny za wygląd okna pomocy
    * @param gameWidth szerokość pola graficznego całej gry
    * @param gameHeight wysokość pola graficznego całej gry
    */
   
    public HelpWindow(int gameWidth, int gameHeight) {

        super("HELP");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(175,gameHeight/4,1024,300);
        inFont=new Font("Dialog",PLAIN, 18);
        setVisible(true);
        add(new JPanel(){
            @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
             
                g = (Graphics2D)gs;
                g.setColor(Color.black);
                g.clearRect(0, 0, 0,0);
                i1="Witaj w grze edukacyjnej MathBubble. \n";
                i2= "Gra polega na wskazaniu wszystkich NIEpoprawnie rozwiązanych działań w jak najkrótszym czasie. \n";;
                i3= "Za każde poprawne wskazanie jest przyznawany 1 punkt, \n";
                i4= "natomiast błąd oznacza utratę życia (są 3 życia na całą grę). \n";
                i5= "Spróbuj przejść grę w jak najkrótszym czasie. \n";
                i6= "POWODZENIA!";
                g.setFont(inFont);
                g.drawString(i1, 20,80);
                g.drawString(i2, 20,110);
                g.drawString(i3, 20,130);
                g.drawString(i4, 20,150);
                g.drawString(i5, 20,170);
                g.drawString(i6, 20,210);
         }
         
        });
        repaint();

    }

   
}
