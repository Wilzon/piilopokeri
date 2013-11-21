
package piilopokeri.jarjestajat;

import java.util.Comparator;
import piilopokeri.domain.Kortti;

/** @author Wilzon */

public class KorttienKaannettyJarjestaja implements Comparator<Kortti>{

    @Override
    public int compare(Kortti k1, Kortti k2) {
        if(k1.onkoKaannetty() && k2.onkoKaannetty()) {
            if (k1.getArvo() == k2.getArvo()) {
                return k2.getMaa() - k1.getMaa();
            }
            return k2.getArvo() - k1.getArvo(); 
            
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
