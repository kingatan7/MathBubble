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
 *
 * @author DELL
 */
public class HelpWindow extends JFrame {
      
   public String instrukcja;
   public Font inFont;
    
    public HelpWindow(int gameWidth, int gameHeight) {

        super("HELP");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0,0,300,300);
        
        
        inFont=new Font("Dialog",PLAIN, 12);
        setVisible(true);
        add(new JPanel(){
            @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
             
                g = (Graphics2D)gs;
                g.setColor(Color.black);
                g.clearRect(0, 0, 0,0);
                instrukcja="Witaj w grze edukacyjnej MathBubble. \n"
                        + "Gra polega na wskazaniu wszystkich NIEpoprawnie rozwiązanych działań w jak najkrótszym czasie. \n"
                        + "Za każde poprawne wskazanie jest przyznawany 1 punkt, \n"
                        + "natomiast błąd oznacza utratę życia (są 3 życia na całą grę). \n"
                        + "Spróbuj przejść grę w jak najkrótszym czasie. \n"
                        + "POWODZENIA!";
                g.setFont(inFont);
                g.drawString(instrukcja, 20,80);
         }
         
        });
        repaint();
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public void paint(Graphics gs){
        super.paint(gs);
        
    }
}
