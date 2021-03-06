/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa tworząca działania
 * na różnych poziomach trudności
 * @author DELL
 */
public class MathBubble {
    /* działania w formie napisu, przygotowane do wyświetlenia */
    public static String[] wynik = {"","","","","","","","","","","",""};
    /* zmienna określająca popraność działania */
    public static int czy_poprawne;
    /* status działania: 0-poprawne, 1-niepoprawne, 2-kliknięte i jest za nie punkt, 3-kliknięte bez punktu */
    public static int czy_w[];
    /* zmienna reprezentująca liczbę wchodzącą w działanie */
    public static int a;
    /* zmienna reprezentująca liczbę wchodzącą w działanie */
    public static int b;
    /* zmienna obliczona jako wynik działania */
    public static int suma;
    /* zmienna obliczona jako wynik działania */
    public static int roznica;
    /* zmienna obliczona jako wynik działania */
    public static int iloczyn;
    /* ilość poprawnych działań dla poziomu */
    public static int ilosc_poprawnych=0;
    /* ilość niepoprawnych działań dla poziomu */
    public static int ilosc_niepoprawnych=0;
    /* ilość punktów - ilość niepoprawnych działań w całej grze */
    public static int suma_pkt;
    /* współrzędna kliknięcia */
    public static int x1=GamePanel.wspol1;
    /* współrzędna kliknięcia */
    public static int y2=GamePanel.wspol2;
    /* ilość żyć w całej grze */
    public static int ilosc_zyc=3;
    
    
    /**
     * Metoda losująca działania w zależności od poziomu gry
     */

public static void losuj(){

         wynik = new String[12];
         czy_w = new int [12];
         
        for(int i=0;i<12;i++){
            Random rand=new Random();
            czy_poprawne=rand.nextInt(2);
            
            if(GameStatus.level==1){
                
            a=rand.nextInt(50)+1;
            b=rand.nextInt(50)+1;
            
                if(czy_poprawne==1){
                suma=a+b;
                ilosc_poprawnych++;
                czy_w[i]=0;
                }
                else {
                suma=a+b+rand.nextInt(20)+10;
                ilosc_niepoprawnych++;
                suma_pkt++;
                czy_w[i]=1;
                }
            }
            
            else if(GameStatus.level==2){
            a=rand.nextInt(50);
            b=rand.nextInt(50);
                if(czy_poprawne==1){
                    if(a>=b)roznica=a-b;
                    if (b>a) roznica=b-a;
                ilosc_poprawnych++;
                czy_w[i]=0;
                }
                else {
                if(a>=b)roznica=a-b-(rand.nextInt(5)+5);
                if (b>a) roznica=b-a-(rand.nextInt(5)+5);
                ilosc_niepoprawnych++;
                suma_pkt++;
                czy_w[i]=1;
                }
            }
            else if(GameStatus.level==3){
            a=rand.nextInt(20)+1;
            b=rand.nextInt(10)+1;
                if(czy_poprawne==1){
                    iloczyn=a*b;
                    ilosc_poprawnych++;
                    czy_w[i]=0;
                }
                else{
                    iloczyn=(a*b)+rand.nextInt(5)+2;
                    ilosc_niepoprawnych++;
                    suma_pkt++;
                    czy_w[i]=1;
                }      
            }
            else if(GameStatus.level==4){
            a=rand.nextInt(200)+1;
            b=rand.nextInt(100)+1;
            if(czy_poprawne==1){
                suma=a+b;
                ilosc_poprawnych++;
                czy_w[i]=0;
            }
            else{
                suma=(a+b)+rand.nextInt(5)+2;
                ilosc_niepoprawnych++;
                suma_pkt++;
                czy_w[i]=1;
            }
            }
                String str1=Integer.toString(a);
                String str2=Integer.toString(b);
                if(GameStatus.level==1){
                String str3=Integer.toString(suma);
                wynik[i]=str1+" + "+str2+ " = "+str3;
                }
                if(GameStatus.level==2){
                    if(a>=b){
                String str3=Integer.toString(roznica);
                wynik[i]=str1+" - "+str2+ " = "+str3;
                    }
                    else{
                        String str3=Integer.toString(roznica);
                        wynik[i]=str2+" - "+str1+ " = "+str3;
                    }
                }
                if(GameStatus.level==3){
                    String str3=Integer.toString(iloczyn);
                    wynik[i]=str1+" * "+str2+ " = "+str3;
                }
                if(GameStatus.level==4){
                    String str3=Integer.toString(suma);
                    wynik[i]=str1+" + "+str2+ " = "+str3;
                }
        }
} 
 /**
  * metoda sprawdzająca czy kliknięty jest wyłącznie obszar bąbelka
  * @param x współrzędna kliknięcia
  * @param y współrzędna kliknięcia
  * @return 1 gdy tak, 0 gdy nie
  */
  public static boolean containsPoint(int x, int y) {
       for(int i=0;i<12;i++){
      for(y2=30;y2<900;y2=(y2+GamePanel.odleglosc)){
        for(x1=100;x1<900;x1=(x1+GamePanel.odleglosc)){
        if(x>=x1 && x<(x1+150)){
            if(y>=y2 && y<(y2+150)){
                return true;
                        }
                    }
                } 
            }
        } 
    return false;
    }
   

/** 
 * metoda sprawdzająca czy kliknięto poprawne czy niepoprawne działanie
 * zmieniająca parametr czy_w, dodająca punkty w zależności od kliknięcia
 * odtwarzająca dźwięk w zależności czy punkt był przyznany czy nie
 * @param x współrzędna kliknięcia
 * @param y współrzędna kliknięcia
 * @return 1 gdy przyznany punkt, 0 gdy nie
 */
   public static boolean czy_wynik(int x, int y){

      if(x<250 && y<200) {
          if(czy_w[0]==1){
          czy_w[0]=2;
          playSound(new File("sounds/tap-crisp.aif"));
          ilosc_niepoprawnych--;
          return true;
          }
          else{
              czy_w[0]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x<250 && y>200 && y<400) {
          if(czy_w[4]==1){
          czy_w[4]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[4]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x<250 && y>400 && y<600) {
          if(czy_w[8]==1){
          czy_w[8]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[8]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>250 && x<500 && y<200) {
          if(czy_w[1]==1){
          czy_w[1]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[1]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>250 && x<500 && y>200 && y<400) {
          if(czy_w[5]==1){
          czy_w[5]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[5]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>250 && x<500 && y>400 && y<600) {
          if(czy_w[9]==1){
          czy_w[9]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[9]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>500 && x<750 && y<200) {
          if(czy_w[2]==1){
          czy_w[2]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[2]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>500 && x<750 && y>200 && y<400) {
          if(czy_w[6]==1){
          czy_w[6]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[6]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>500 && x<750 && y>400 && y<600) {
          if(czy_w[10]==1){
          czy_w[10]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[10]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>750 && x<1000 && y<200) {
          if(czy_w[3]==1){
          czy_w[3]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[3]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>750 && x<1000 && y>200 && y<400){
          if(czy_w[7]==1){
          czy_w[7]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[7]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
      else if (x>750 && x<1000 && y>400 && y<600) {
          if(czy_w[11]==1){
          czy_w[11]=2;
          ilosc_niepoprawnych--;
          playSound(new File("sounds/tap-crisp.aif"));
          return true;
          }
          else{
              czy_w[11]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
      }
             
      return false;
   }
   /**
    * Funkcja służąca do odtworzenia dźwięku z pliku
    * @param f plik dźwiękowy -  obiekt klasy File
    */

   public static synchronized void playSound(final File f){
       new Thread(new Runnable(){
           @Override
           public void run() {
               try{
                   Clip clip=AudioSystem.getClip();
                   AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                   clip.open(inputStream);
                   clip.start();
               }
               catch(Exception e){
                   System.err.println(e.getMessage());
               }
           }
       }).start();
   }
}