
package piilopokeri.gui;

import java.awt.Color;
import javax.swing.JComponent;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;

public class KorttienMaalaaja {
    
    /**
     * Metodi tekee komponentin tekstistä kortin värisen
     * 
     * @param pokeri 
     * @param kortti Kortti, jonka värinen komponentti halutaan
     * @param komponentti JComponent, joka halutaan värittää
     */
    public static void maalaaNappi(Piilopokeri pokeri, Kortti kortti, JComponent komponentti) {
        int maa = kortti.getMaa();
        
        if(maa == Kortti.HERTTA || maa == Kortti.RUUTU) {
            komponentti.setForeground(Color.red);
            
        }
        else if(maa == Kortti.JOKERI) {
            komponentti.setForeground(Color.green);
            komponentti.setBackground(Color.black);
            
        }else{
            komponentti.setForeground(Color.black);
            
        }
        
    }
}
