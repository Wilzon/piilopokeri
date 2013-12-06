
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.NappienPiilottaja;

public class KorttiNapinKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private JButton korttiNappi;
    private JButton avoPakkaNappi;
    private Kortti kortti;
    private Vuoro vuoro;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public KorttiNapinKuuntelija(Piilopokeri pokeri, JFrame frame, JButton korttiNappi, JButton avoPakkaNappi, Kortti kortti, Vuoro vuoro, 
            HashMap<String, ArrayList<JButton>> korttiNapit) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.korttiNappi = korttiNappi;
        this.avoPakkaNappi = avoPakkaNappi;
        this.kortti = kortti;
        this.vuoro = vuoro;
        this.korttiNapit = korttiNapit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(korttiNappi.getName() == null) {
            kortti.kaannaKortti();

            korttiNappi.setText(kortti.toString());

            KorttienMaalaaja.maalaaNappi(pokeri, kortti, korttiNappi);
            
            korttiNappi.setName("painettu");
            
//            if(!vuoro.getPelaaja().onkoKone()) {
//                vuoro.seuraava();
//            
//                NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
//                
//            }
            vuoro.seuraava();
            
            NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
            lopetaPeliLopussa(pokeri, frame);
            
            luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, korttiNapit);
        }
        
        korttiNappi.removeActionListener(this);

        
    }
}
