
package piilopokeri.gui;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;

public class NappienPiilottaja {
    
    
    public static void piilotaMuidenPelaajienNapit(Piilopokeri pokeri, Vuoro vuoro, HashMap<String, ArrayList<JButton>> korttiNapit) {
        String nimi = pokeri.getPelaajat().get(vuoro.getVuoro()).getNimi();
        
        for(String avain : korttiNapit.keySet()) {
            if(!avain.equals(nimi)) {
                for(JButton nappi : korttiNapit.get(avain)) {
                    nappi.setEnabled(false);
                }
            }else{
                for(JButton nappi : korttiNapit.get(avain)) {
                    nappi.setEnabled(true);
                }
            }
        }
    }
}
