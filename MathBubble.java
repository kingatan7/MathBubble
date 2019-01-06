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
 *
 * @author DELL
 */
public class MathBubble {
    public static String[] wynik = {"","","","","","","","","","","",""};
    public static int czy_poprawne;
    public static boolean hit; //czy trafiono bąbelek
    public static int czy_w[];
    
    public static int a;
    public static int b;
    public static int suma;
    public static int roznica;
    public static int iloczyn;
    public static int iloraz;

    public static int ilosc_poprawnych=0;
    public static int ilosc_niepoprawnych=0;

    public static int suma_pkt;
    
    public static int x1=GamePanel.wspol1;
    public static int y2=GamePanel.wspol2;
 
    public static int ilosc_zyc=3;
    
    public MathBubble(){
        hit=false;

    }


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
                suma_pkt++;
                czy_w[i]=0;
                }
                else {
                suma=a+b+rand.nextInt(20)+10;
                ilosc_niepoprawnych++;
                czy_w[i]=1;
                }
            }
            else if(GameStatus.level==2){
            a=rand.nextInt(50);
            b=rand.nextInt(50);
                if(czy_poprawne==1){
                    if(a>=b)roznica=a-b;
                    else roznica=b-a;
                ilosc_poprawnych++;
                suma_pkt++;
                czy_w[i]=0;
                }
                else {
                if(a>=b)roznica=a-b-rand.nextInt(5)+5;
                else roznica=b-a-rand.nextInt(5)+5;
                ilosc_niepoprawnych++;
                czy_w[i]=1;
                }
            }
            else if(GameStatus.level==3){
            a=rand.nextInt(20)+1;
            b=rand.nextInt(10)+1;
                if(czy_poprawne==1){
                    iloczyn=a*b;
                    ilosc_poprawnych++;
                    suma_pkt++;
                    czy_w[i]=0;
                }
                else{
                    iloczyn=(a*b)+rand.nextInt(5)+2;
                    ilosc_niepoprawnych++;
                    czy_w[i]=1;
                }      
            }
            else if(GameStatus.level==4){
            a=rand.nextInt(200)+1;
            b=rand.nextInt(100)+1;
            if(czy_poprawne==1){
                suma=a+b;
                ilosc_poprawnych++;
                suma_pkt++;
                czy_w[i]=0;
            }
            else{
                suma=(a+b)+rand.nextInt(5)+2;
                ilosc_niepoprawnych++;
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
        
        System.out.println("ilosc poprawnych: "+ilosc_poprawnych);
        System.out.println("suma: "+suma_pkt);
        
} 
/*
   public static boolean containsPoint(int x, int y) {
       for(int i=0;i<12;i++){
      for(y2=30;y2<900;y2=(y2+GamePanel.odleglosc)){
        for(x1=100;x1<900;x1=(x1+GamePanel.odleglosc)){
        if(x>=x1 && x<(x1+150)){
            if(y>=y2 && y<(y2+150)){
                if(czy_w[i]==1){
                 czy_w[i]=2;
          playSound(new File("sounds/tap-crisp.aif"));
          ilosc_niepoprawnych--;
                return true;
                }
                else{
                    czy_w[i]=3;
                    return false;
                }
            }
        } 
     }
   }
       }
return false;
       
    }
   */
   public static boolean czy_wynik(int x, int y){
       int i = (y/200)*4 + (x/250);
       if (i < 0) i=0;
       if(i > 11) i =11;
        if(czy_w[i]==1){
          czy_w[i]=2;
          playSound(new File("sounds/tap-crisp.aif"));
          ilosc_niepoprawnych--;
          return true;
          }
          else{
              czy_w[i]=3;
              ilosc_zyc--;
              playSound(new File("sounds/slide-magic.aif"));
          }
       
     /*  for(int i=0;i<12;i++){
           for(x=0;x<1000;x+=250){
               for(y=0;y<600;y+=200){
                   if(czy_w[i]==1)
          czy_w[0]=2;
          playSound(new File("sounds/tap-crisp.aif"));
          ilosc_niepoprawnych--;
          return true;
               }
           }
       }
       
       
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
          */     
      return false;
   }


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
    

       
       
    
