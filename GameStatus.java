/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

/**
 *
 * @author DELL
 */
public class GameStatus{
    
    public static int points;
    public static int level=1;
    public double time;
    
    public void reset() {
    
    points=0;
    level=1;
    time=0.0;

    MathBubble.ilosc_poprawnych=0;
    MathBubble.ilosc_niepoprawnych=0;
    
    
 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    public void ResetPoints(){
        points=0;
    }
    public void nastLevel(){
        level++;
        MathBubble.ilosc_poprawnych=0;
        MathBubble.ilosc_niepoprawnych=0;
        MathBubble.losuj();
        
    }
    
}
