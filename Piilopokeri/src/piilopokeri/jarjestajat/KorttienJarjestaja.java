
package piilopokeri.jarjestajat;

import java.util.Comparator;
import piilopokeri.domain.Kortti;

/** @author Wilzon */

public class KorttienJarjestaja implements Comparator<Kortti>{

    @Override
    public int compare(Kortti k1, Kortti k2) {
        if(k1.onkoKaannetty() && k2.onkoKaannetty()) {
            if (k1.getArvo() == k2.getArvo()) {
                return k1.getMaa() - k2.getMaa();
            }
            return k1.getArvo() - k2.getArvo(); 
            
        }else{
            if(!k1.onkoKaannetty() && k2.onkoKaannetty()) {
                return 1;
                
            }
            else if(k1.onkoKaannetty() && !k2.onkoKaannetty()) {
                return -1;
                
            }else{
                return 0;
            }
        }
    }
}
