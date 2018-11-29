package kingatan;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
    static Image cursorImage;

	//public static Image cursorImage;

	public static void loadInitialImages() {
		// TODO Auto-generated method stub
		cursorImage=loadImage("images/kursor2.png");
	}

    private static Image loadImage(String fileName) {
        
        return new ImageIcon(fileName).getImage();
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
