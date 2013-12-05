
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.NappienPiilottaja;

public class KoneNapinKuuntelija extends Kuuntelija{
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public KoneNapinKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, 
            HashMap<String, ArrayList<JButton>> korttiNapit) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.korttiNapit = korttiNapit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vuoro.getPelaaja().onkoKone()) {
            koneKayttaaVuoron(pokeri, frame, vuoro, avoPakkaNappi, korttiNapit);
            
//            vuoro.seuraava();
            
            NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
        }
    }
}
