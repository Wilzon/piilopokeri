
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

public class AvoPakkaNapinKuuntelija extends Kuuntelija{
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private JButton pakkaNappi;

    public AvoPakkaNapinKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, 
            JButton avoPakkaNappi, JButton pakkaNappi) {
        
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
                Kortti avoPakanKortti = pokeri.getAvopakanPaallimmainen();
                
                nappi.setText(avoPakanKortti.toString());
                
                KorttienMaalaaja.maalaaNappi(pokeri, avoPakanKortti, nappi);
                
                pokeri.vaihdaAvopakanKanssaAutomaattisesti(vuoro.getKasi());
                
                nappi.setName("painettu");
                nappi.doClick();
                
                break;
            }
        }
        vuoro.seuraava();
        
        NappiHallinto.piilotaMuidenPelaajienNapit(pokeri, vuoro);

        lopetaPeliLopussa(pokeri, frame, avoPakkaNappi, pakkaNappi);
        
        KoneToiminta.luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi);
        
        avoPakkaNappi.setText(pokeri.getAvopakanPaallimmainen().toString());
    
        KorttienMaalaaja.maalaaNappi(pokeri, pokeri.getAvopakanPaallimmainen(), avoPakkaNappi);
        
    }
}
