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

/**
 * Klasa ktora opisuje obszar graficzny gry
 * Dziedziczy po klasie JPanel i implementuje interfejs ActionListener
 * @author Kinga Tańska
 */

public class GamePanel extends JPanel implements ActionListener {
        /** szerokosc obszaru gry */
        public int pWidth;
        /** wysokosc obszaru gry */
        public int pHeight; 
        /** ilosc babelkow w linii */
        public int BubbleinLine;
        /** odleglosc miedzy obiektami w linii */
        public static int odleglosc; 
        /** polozenie poczatkowe x pierwszego babelka */
        public static int wspol1=100;
        /** polozenie poczatkowe y pierwszego babelka */
        public static int wspol2=30;
        /** wysokosc paska Menu */
        public int MenuSize; 
        /** obiekt reperezntujace status gry */
        public GameStatus gStatus;
        /** czciona stosowana w menu */
        public Font menuFont;
        /** czcionka stosowana do napisania dzialania */
        public static Font eqFont;
        /** zmienna pomocnicza do rozkladu elementow */
        public static int wys=400;
        /** zmienna pomocnicza do rozkladu elementow */
        public static int szer=600;
        /** zmienna prezentujaca przycisk w menu */
        private final JButton firstB;
        /** zmienna prezentujaca przycisk w menu */
        private final JButton secondB;
        /** zmienna prezentujaca przycisk w menu */
        private final JButton thirdB;
        /** wspolrzedne klikniecia */
        public static int wsp1,wsp2;
        /** zmienna reperezentujaca obiekt MathBubble */
        public MathBubble bubbles;
        /** grafika bedąca tłem gry */
        public BufferedImage bg;
        /** zmienne pomocnicze */
        static int i=0;
        /** zmienne pomocnicze */
        public int j=0;
        
        /** 
         * Konstruktor pola graficznego gry
         * Odpowiedzialny za ustawienia początkowe i ładowanie zasobów graficznych gry
         * Ponadto obsługa zdarzeń w menu i całym polu graficznym gry
         * @param gameWidth szerokosc pola graficznego gry
         * @param gameHeight wysokosc pola graficznego gry
         */     
        
        
	public GamePanel(int gameWidth, int gameHeight) {
            
            File directory = new File("./");
            System.out.println(directory.getAbsolutePath());
            try {
                bg = ImageIO.read(new File("./images/bubble.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        bubbles=new MathBubble ();
        gStatus=new GameStatus();
        gStatus.reset();
        
        this.pWidth=gameWidth;
        this.pHeight=gameHeight;
        MenuSize=50;
        
        menuFont=new Font("Dialog", Font.BOLD, 30);
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
        
        GamePanel obszar = this;
        /** Obsługa zdarzeń - wciśnięcie przycisku myszki w obszarze graficznym */
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
             
            wsp1=e.getX();
            wsp2=e.getY();
            // czy wybrano obszar z dzialaniem
            if(MathBubble.czy_w != null && MathBubble.czy_wynik(wsp1, wsp2) && MathBubble.containsPoint(wsp1,wsp2) ){ 
                if(MathBubble.ilosc_niepoprawnych>0){
                gStatus.points++;
                i = 0;
                }
                else {
                    gStatus.points++;
                    gStatus.nastLevel();
                    i = 0;
                    if(gStatus.level>4){
                        GPars.endTime=System.currentTimeMillis();;
                        EndG EG = new EndG();
                        repaint();
                    }
                }
            }
            i=0;
            obszar.repaint();
            }
        }
        );
        }
             /**
              * Metoda odpowiedzialna za restart gry
              */
    private void restartGame() {
        gStatus.ResetPoints();
        MathBubble.losuj();
        i = 0;
        MathBubble.ilosc_zyc=3;
    }
        /**
         * Metoda odpowiedzialna za stworzenie pola graficznego gry
         * @param gs 
         */
        @Override
         protected void paintComponent(Graphics gs){
             
             Graphics2D g;
             g = (Graphics2D)gs;
             
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             
             g.setColor(new Color(50,30,0));
             g.clearRect(0, 0, pWidth, pHeight);
             
             g.drawImage(bg,0,0,null);
             g.fillRect(0,pHeight-MenuSize, pWidth, MenuSize);
             g.setColor(Color.white);
             g.setFont(menuFont);
             g.drawString("POZIOM: "+GameStatus.level,10 , 690);
             g.drawString("PUNKTY: "+GameStatus.points, 330, 690);
             g.drawImage(GPars.lImage, 170, 650, this);
             g.drawImage(GPars.lImage, 220, 650, this);
             g.drawImage(GPars.lImage, 270, 650, this);
         
             if(MathBubble.ilosc_zyc<=2) g.drawImage(GPars.nlImage, 170, 650, this);
             if(MathBubble.ilosc_zyc<=1) g.drawImage(GPars.nlImage, 220, 650, this);
             if(MathBubble.ilosc_zyc<=0){ 
                g.drawImage(GPars.nlImage, 270, 650, this);
                LoseG LG = new LoseG();
                restartGame();
                repaint();
             }
             
             if(MathBubble.wynik == null)
                 return;
                 for(wspol2=30;wspol2<900;wspol2=wspol2+odleglosc){
                     for(wspol1=100;wspol1<900;wspol1=wspol1+odleglosc){
                         
                         if(i<12){

                           g.drawImage(GPars.bubbleIm,wspol1,wspol2,this);
                           g.setColor(Color.black);

                           g.setFont(eqFont);
                           g.drawString(MathBubble.wynik[i]+" ", wspol1+20, wspol2+80);
                           
                    i++;
                                }
                 }
             }
                 
                  if(gStatus.level>4){
                 g.clearRect(0,0,pWidth,pHeight);
                 g.drawImage(bg,0,0,null);
                                     }
                 }

    /**
     * Metoda obsługująca przyciski w pasku menu
     * @param e
     */
        @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source=e.getSource();
        
        if(source==firstB){
            GPars.startTime=System.currentTimeMillis();
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