package kingatan;

import java.awt.Toolkit;

public class MainGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
                int gameWidth=1024;
                int gameHeight=700;
                
                int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
                int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
                
                int xPosition=(screenWidth-gameWidth)/2;
                int yPosition=(screenHeight-gameHeight)/2;
                
                GWindow gw = new GWindow(gameWidth, gameHeight, xPosition, yPosition);
                
                
             
	}

}
