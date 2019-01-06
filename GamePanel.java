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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import static kingatan.GPars.cursorImage;

public class GamePanel extends JPanel implements ActionListener {
        
        public int pWidth;
        public int pHeight;
        public int BubbleinLine; //ilosc bąbelków w linii
        public static int odleglosc; //odleglosc miedzy obiektami w linii
        
        public static int wspol1=100;
        public static int wspol2=30;
        
        public int MenuSize; //wysokosc paska menu
        public GameStatus gStatus;
        public Font menuFont;
        public Font alertFont;
        public static Font eqFont;
        
        public static int wys=400;
        public static int szer=600;
        private final JButton firstB;
        private final JButton secondB;
        private final JButton thirdB;
        
        public static int wspolx, wspoly;
        public static int wsp1,wsp2;
        public MathBubble bubbles;
        public int tablicaniepoprawnychx[];
        public int tablicaniepoprawnychy[];
        public BufferedImage bg;
        static int i=0;
        public int j=0;
        
             
        
        
	public GamePanel(int gameWidth, int gameHeight) {
            File directory = new File("./");
            System.out.println(directory.getAbsolutePath());
            try {
                bg = ImageIO.read(new File("./images/bubble.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            bubbles=new MathBubble ();
		// TODO Auto-generated constructor stub
        gStatus=new GameStatus();
        gStatus.reset();
        
        this.pWidth=gameWidth;
        this.pHeight=gameHeight;
        MenuSize=50;
        
        menuFont=new Font("Dialog", Font.BOLD, 30);
        alertFont=new Font("Dialog", Font.BOLD, 92);
        eqFont=new Font("Dialog",Font.BOLD,18);
        BubbleinLine=4;
        odleglosc=gameHeight/(GPars.nobj/BubbleinLine);
        
        
        firstB=new JButton("START");
        secondB=new JButton("HELP");
        thirdB=new JButton("END GAME");
        
        firstB.addActionListener(this);
        secondB.addActionListener(this);
        thirdB.addActionListener(this);

        
        setLayout(new FlowLayout(FlowLayout.RIGHT,70,665));
        setPreferredSize(new Dimension(szer, wys));
        add(firstB);
        add(secondB);
        add(thirdB);
        GamePanel janusz = this;
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
             
            wsp1=e.getX();
            wsp2=e.getY();
            if(MathBubble.czy_w != null && MathBubble.czy_wynik(wsp1, wsp2) ){ 
                if(MathBubble.ilosc_niepoprawnych>0){
                gStatus.points++;
                System.out.println("w funkcji klikania: x "+wsp1+ " y "+wsp2);
                i = 0;
                
                }
                else {
                    gStatus.points++;
                    gStatus.nastLevel();
                    i = 0;
                }
                
            }
            i=0;
            janusz.repaint();
            }
            
        }
        );
        }
             
    private void restartGame() {
        gStatus.ResetPoints();
        GPars.startTime=System.currentTimeMillis();
        MathBubble.losuj();
        i = 0;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        @Override
         protected void paintComponent(Graphics gs){
             Graphics2D g;
             g = (Graphics2D)gs;
             
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             
             g.setColor(new Color(50,30,0));
             g.clearRect(0, 0, pWidth, pHeight);
             
             g.fillRect(0,pHeight-MenuSize, pWidth, MenuSize);
             g.drawImage(bg,0,0,null);
             g.setColor(Color.white);
             g.setFont(menuFont);
             g.drawString("POZIOM: "+GameStatus.level,10 , 690);
             g.drawString("PUNKTY: "+GameStatus.points, 330, 690);
             g.drawImage(GPars.lImage, 170, 650, this);
             g.drawImage(GPars.lImage, 220, 650, this);
             g.drawImage(GPars.lImage, 270, 650, this);
         
             if(MathBubble.ilosc_zyc<=2) g.drawImage(GPars.nlImage, 170, 650, this);
             if(MathBubble.ilosc_zyc<=1) g.drawImage(GPars.nlImage, 220, 650, this);
             if(MathBubble.ilosc_zyc<=0) g.drawImage(GPars.nlImage, 270, 650, this);
             
             if(MathBubble.wynik == null)
                 return;
                 for(wspol2=30;wspol2<900;wspol2=wspol2+odleglosc){
                     for(wspol1=100;wspol1<900;wspol1=wspol1+odleglosc){
                         
                         if(i<12){
//                           System.out.println(MathBubble.czy_w[i]);
                             
                           g.drawImage(GPars.bubbleIm,wspol1,wspol2,this);
                          g.setColor(Color.black);

                           g.setFont(eqFont);
                           g.drawString(MathBubble.wynik[i]+" ", wspol1+20, wspol2+80);
                           
                    i++;
                   
             }
                 }
             }
                 
                  
                 }

    /**
     *
     * @param e
     */
        @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source=e.getSource();
        
        if(source==firstB){
        
           GPars.end=false;
            gStatus.reset();
           restartGame();
            repaint();
            i=0;
            
        }
        else if(source==secondB){
            HelpWindow HP = new HelpWindow(pWidth,pHeight);
            }
           
        
        else if(source==thirdB){
            
                System.exit(1);
                setVisible(false);
            
        }
    }
}

        

    

  


            
       
        
        
    

    
    
  

    



