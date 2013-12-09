
package piilopokeri.gui;

import javax.swing.JButton;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;

public class NappiHallinto {
    
    
    public static void piilotaMuidenPelaajienNapit(Piilopokeri pokeri, Vuoro vuoro) {
        Pelaaja vuorossa = vuoro.getPelaaja();
        
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            if(vuorossa == pelaaja) {
                for(JButton korttiNappi : pelaaja.getKorttiNapit()) {
                    korttiNappi.setEnabled(true);
                    
                }
            }else{
                for(JButton korttiNappi : pelaaja.getKorttiNapit()) {
                    korttiNappi.setEnabled(false);
                    
                }
            }
        }
    }
    
    public static void piilotaTurhatNapit(Vuoro vuoro) {
        for(JButton nappi : vuoro.getPelaaja().getKorttiNapit()) {
            nappi.setEnabled(false);
        }
    }
    
    public static void jarjestaKaikkiNapit(Vuoro vuoro) {
//        Pelaaja pelaaja = vuoro.getPelaaja();
//        pelaaja.jarjestaOmatKortit();
//            
//        for(int i = 0; i < pelaaja.getKorttiNapit().size(); i++) {
//            pelaaja.getKorttiNapit().get(i).setText(pelaaja.getKasi().getKortit().get(i).toString());
//            
//        }
    }
}
