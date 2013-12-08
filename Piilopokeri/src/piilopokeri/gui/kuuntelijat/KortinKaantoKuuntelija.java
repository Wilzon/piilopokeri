
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KoneToiminta;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.NappiHallinto;

public class KortinKaantoKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private JButton pakkaNappi;

    public KortinKaantoKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, JButton pakkaNappi) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(JButton nappi : vuoro.getPelaaja().getKorttiNapit()) {
            if(nappi.getName() == null) {
                avoPakkaNappi.setText(pokeri.pakanPaallimmainen.toString());
                
                Kortti kortti = pokeri.kaannaKoneenKortti(vuoro.getKasi());
                
                nappi.setText(kortti.toString());
                
                KorttienMaalaaja.maalaaNappi(pokeri, kortti, nappi);
                
                nappi.setName("painettu");
                nappi.doClick();
                
                break;
            }
        }
        vuoro.seuraava();
        
        NappiHallinto.piilotaMuidenPelaajienNapit(pokeri, vuoro);
        
        NappiHallinto.jarjestaKaikkiNapit(vuoro);
        
        lopetaPeliLopussa(pokeri, frame, avoPakkaNappi, pakkaNappi);
        
        KoneToiminta.luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi);
        
        if(!frame.getTitle().equals("Piilopokeri")) {
            frame.dispose();
        }
    }   
}
