
package piilopokeri.gui;

import javax.swing.JButton;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;

public class NappiHallinto {
    
    /**
     * Metodi piilottaa kaikkien muiden paitsi vuorossa olevan pelaajan napit
     * 
     * @param pokeri
     * @param vuoro 
     */
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
    
    /**
     * Metodi piilottaa turhat napit, joita ei haluta painettavan
     * 
     * @param vuoro 
     */
    public static void piilotaTurhatNapit(Vuoro vuoro) {
        for(JButton nappi : vuoro.getPelaaja().getKorttiNapit()) {
            nappi.setEnabled(false);
        }
    }
}
