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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, MouseListener {
        
        public int pWidth;
        public int pHeight;
        public int BubbleinLine; //ilosc bąbelków w linii
        public int odleglosc=25; //odleglosc miedzy obiektami w linii
        
        public static int wspol1=100;
        public static int wspol2=100;
        
        public int MenuSize; //wysokosc paska menu
        public GameStatus gStatus;
        public Font menuFont;
        public Font alertFont;
        public Font eqFont;
        
        public static int wys=400;
        public static int szer=600;
       private final JButton firstB;
       private final JButton secondB;
        private final JButton thirdB;
        
        private int wspolx, wspoly;
        
        
       // private final MathBubble [] mbubble;
        
        public MathBubble bubbles;
	public GamePanel(int gameWidth, int gameHeight) {
            bubbles = new MathBubble();
		// TODO Auto-generated constructor stub
        gStatus=new GameStatus();
        gStatus.reset();
        
        this.pWidth=gameWidth;
        this.pHeight=gameHeight;
        MenuSize=50;
        
        menuFont=new Font("Dialog", Font.BOLD, 50);
        alertFont=new Font("Dialog", Font.BOLD, 92);
        eqFont=new Font("Dialog",Font.BOLD,20);
        //miejsce na info o bąbelkach
        BubbleinLine=4;
        odleglosc=gameHeight/(GPars.nobj/BubbleinLine);
        //mbubble= new MathBubble[GPars.nobj]; 
       
        restartGame();
        
        firstB=new JButton("START");
        secondB=new JButton("PAUSE");
        thirdB=new JButton("END GAME");
        
        firstB.addActionListener(this);
        secondB.addActionListener(this);
        thirdB.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT,70,665));
        setPreferredSize(new Dimension(szer, wys));
        add(firstB);
        add(secondB);
        add(thirdB);
     
         
            
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
            int i=0;
             for(wspol1=100;wspol1<900;wspol1=wspol1+odleglosc){
                 for(wspol2=30;wspol2<900;wspol2=wspol2+odleglosc){
                     g.drawImage(GPars.bubbleIm,wspol1,wspol2,this);
                    
                    // g.setColor(new Color(48,213,200));
                    // g.fillOval(wspol1, wspol2, 125, 125);
                    
                     g.setColor(Color.black);
                 }
             }
             for(wspol1=100;wspol1<900;wspol1=wspol1+odleglosc){
                 for(wspol2=30;wspol2<900;wspol2=wspol2+odleglosc){
             if(i<12){
                        g.setFont(eqFont);
                        g.drawString(bubbles.wynik[i], wspol2+90, wspol1+5);
                        i++;
                      }
                 }
             }
              
            g.setColor(new Color(50,30,0));
            g.fillRect(0,pHeight-MenuSize, pWidth, MenuSize);
            g.setColor(Color.white);
            g.setFont(menuFont);
         }

    /**
     *
     * @param e
     */
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
            
                System.exit(1);
                setVisible(false);
            
        }
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wspolx=e.getX();
        wspoly=e.getY();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
        
        
	}

    



