/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

/**
 * Klasa reprezntująca aktualny stan gry
 * @author Kinga Tańska
 */
public class GameStatus{
    /* aktualna ilość punktów */
    public static int points;
    /* aktualny level gry */
    public static int level=1;
    
    /** 
     * Zerowanie parametrów gry
     */
    public void reset() {
    
    points=0;
    level=1;

    MathBubble.ilosc_poprawnych=0;
    MathBubble.ilosc_niepoprawnych=0;
    MathBubble.suma_pkt=0;
    
    }
    /**
     * Zerowanie punktów przed staretem gry
     */
    public void ResetPoints(){
        points=0;
    }
    /**
     * Zmiana levelu, wywołanie metody losującej nowe działania
     */
    public void nastLevel(){
        level++;
        MathBubble.ilosc_poprawnych=0;
        MathBubble.ilosc_niepoprawnych=0;
        MathBubble.losuj();
        
    }
    
}
