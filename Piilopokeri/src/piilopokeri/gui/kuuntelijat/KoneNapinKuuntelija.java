
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KoneToiminta;

public class KoneNapinKuuntelija extends Kuuntelija{
    private final Piilopokeri pokeri;
    private final JFrame frame;
    private final Vuoro vuoro;
    private final JButton avoPakkaNappi;
    private final JButton pakkaNappi;

    public KoneNapinKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, 
            JButton avoPakkaNappi, JButton pakkaNappi) {
        
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vuoro.getPelaaja().onkoKone()) {
            KoneToiminta.koneKayttaaVuoron(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi);
            
        }
    }
}
