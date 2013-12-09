
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

public class KorttiNapinKuuntelija extends Kuuntelija {
    private final Piilopokeri pokeri;
    private final JFrame frame;
    private final JButton korttiNappi;
    private final JButton avoPakkaNappi;
    private final JButton pakkaNappi;
    private final Kortti kortti;
    private final Vuoro vuoro;

    public KorttiNapinKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, Kortti kortti,
            JButton korttiNappi, JButton avoPakkaNappi, JButton pakkaNappi) {
        
        this.pokeri = pokeri;
        this.frame = frame;
        this.korttiNappi = korttiNappi;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
        this.kortti = kortti;
        this.vuoro = vuoro;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(korttiNappi.getName() == null) {
            kortti.kaannaKortti();

            korttiNappi.setText(kortti.toString());

            KorttienMaalaaja.maalaaNappi(pokeri, kortti, korttiNappi);
            
            korttiNappi.setName("painettu");
            
            vuoro.seuraava();
            
            NappiHallinto.piilotaMuidenPelaajienNapit(pokeri, vuoro);
            
            NappiHallinto.jarjestaKaikkiNapit(vuoro);
            
            lopetaPeliLopussa(pokeri, frame, avoPakkaNappi, pakkaNappi);
            
            KoneToiminta.luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi);
        }
        
        korttiNappi.removeActionListener(this);
    }
}
