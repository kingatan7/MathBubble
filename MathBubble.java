/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingatan;

import java.util.Random;


/**
 *
 * @author DELL
 */
public class MathBubble {
    public String[] wynik;
    public int czy_poprawne;
    public boolean hit; //czy trafiono bąbelek
    public int a;
    public int b;
    public int suma;
    public int roznica;
   
    public MathBubble(){
        wynik = new String[12];
        for(int i=0;i<12;i++){
            Random rand=new Random();
            czy_poprawne=rand.nextInt(2);
            
            a=rand.nextInt(50);
            b=rand.nextInt(50);
            
                if(czy_poprawne==1){
                suma=a+b;
                }
                else {suma=a+b+rand.nextInt(20);
                }
                String str1=Integer.toString(a);
                String str2=Integer.toString(b);
                String str3=Integer.toString(suma);
                wynik[i]=str1+" + "+str2+ " = "+str3;
            }
            
                
            }
          //  wynik[i] = "a"+Integer.toString(i);
           
        }
       
       
    
