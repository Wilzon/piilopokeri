
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

public class KortinVaihtoKuuntelija extends Kuuntelija {
    private final Piilopokeri pokeri;
    private final JFrame frame;
    private final Vuoro vuoro;
    private final JButton avoPakkaNappi;
    private final JButton pakkaNappi;

    public KortinVaihtoKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, 
            JButton avoPakkaNappi, JButton pakkaNappi) {
        
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        pakkaNappi.setEnabled(true);
        avoPakkaNappi.setEnabled(true);
        
        for(JButton nappi : vuoro.getPelaaja().getKorttiNapit()) {
            if(nappi.getName() == null) {
                Kortti pakanPaallimmainen = pokeri.pakanPaallimmainen;
                
                nappi.setText(pakanPaallimmainen.toString());
                
                Kortti kortti = pokeri.vaihdaSuljetunPakanKanssaAutomaattisesti(vuoro.getKasi());
                
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
        
        avoPakkaNappi.setText(pokeri.getAvopakanPaallimmainen().toString());
        
        KorttienMaalaaja.maalaaNappi(pokeri, pokeri.getAvopakanPaallimmainen(), avoPakkaNappi);
        
        if(!frame.getTitle().equals("Piilopokeri")) {
            frame.dispose();
        }
    }
    
}
