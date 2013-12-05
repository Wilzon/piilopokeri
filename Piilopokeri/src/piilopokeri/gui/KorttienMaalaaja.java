
package piilopokeri.gui;

import java.awt.Color;
import javax.swing.JComponent;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;

public class KorttienMaalaaja {
    
    public static JComponent setVari(Piilopokeri pokeri, Kortti kortti, JComponent korttiNappi) {
        int maa = kortti.getMaa();
        
        if(maa == Kortti.HERTTA || maa == Kortti.RUUTU) {
            korttiNappi.setForeground(Color.red);
            
        }
        else if(maa == Kortti.JOKERI) {
            korttiNappi.setForeground(Color.green);
            
        }else{
            korttiNappi.setForeground(Color.black);
            
        }
        
        return korttiNappi;
    }
}
