
package piilopokeri.gui;

import java.awt.Color;
import javax.swing.JComponent;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;

public class KorttienMaalaaja {
    
    public static void maalaaNappi(Piilopokeri pokeri, Kortti kortti, JComponent korttiNappi) {
        int maa = kortti.getMaa();
        
        if(maa == Kortti.HERTTA || maa == Kortti.RUUTU) {
            korttiNappi.setForeground(Color.red);
            
        }
        else if(maa == Kortti.JOKERI) {
            korttiNappi.setForeground(Color.green);
            korttiNappi.setBackground(Color.black);
            
        }else{
            korttiNappi.setForeground(Color.black);
            
        }
        
    }
}
