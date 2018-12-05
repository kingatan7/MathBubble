package kingatan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
        
        public int pWidth;
        public int pHeight;
        public int BubbleinLine; //ilosc bąbelków w linii
        public int odleglosc; //odleglosc miedzy obiektami w linii
        
        public int MenuSize; //wysokosc paska menu
        public GameStatus gStatus;
        public Font menuFont;
        public Font alertFont;
        
        public static int wys=400;
        public static int szer=600;
        private JButton firstB;
        private JButton secondB;
        private JButton thirdB;
        
        
        private MathBubble [] mbubble;
        
	public GamePanel(int gameWidth, int gameHeight) {
		// TODO Auto-generated constructor stub
        gStatus=new GameStatus();
        gStatus.reset();
        
        this.pWidth=gameWidth;
        this.pHeight=gameHeight;
        MenuSize=50;
        
        menuFont=new Font("Dialog", Font.BOLD, 36);
        alertFont=new Font("Dialog", Font.BOLD, 92);
        
        //miejsce na info o bąbelkach
        
        //restartGame();
        
        firstB=new JButton("START");
        secondB=new JButton("NEXT LEVEL");
        thirdB=new JButton("END GAME");
        
        firstB.addActionListener(this);
        secondB.addActionListener(this);
        thirdB.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setPreferredSize(new Dimension(szer, wys));
        add(firstB);
        add(secondB);
        add(thirdB);
     
          
            //dalej algorytm gry
            
            
        }
        


    private void restartGame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
                g = (Graphics2D)gs;
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             g.drawImage(GPars.bgImage,0,0,null);
             
             //balony
             
            g.setColor(new Color(50,30,0));
            g.fillRect(0,0, pWidth, MenuSize);
            g.setColor(Color.white);
            g.setFont(menuFont);
         }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source=e.getSource();
        
        if(source==firstB){
            GPars.MoveMODE=1;
            GPars.end=false;
            gStatus.reset();
            GPars.levelPause=false;
            GPars.bgImage=GPars.loadImage("images/tlo1.png");
            restartGame();
            repaint();
        }
        else if(source==secondB){
            if(GPars.levelPause){
                if(GPars.MoveMODE<GPars.NO_LEVELS){
                    GPars.MoveMODE++;
                    gStatus.time+=GPars.levelTime;
                    GPars.levelPause=false;
                    GPars.bgImage=GPars.loadImage("images/tlo2.jpg");
                    gStatus.nastLevel();
                    restartGame();
                }
                else{
                    GPars.end=true;
                    gStatus.time+=GPars.levelTime;
                    GPars.pause=true;
                }
                repaint();
            }
           
        }
        else if(source==thirdB){
            if(GPars.pause){
                System.exit(1);
            }
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
	}

    

