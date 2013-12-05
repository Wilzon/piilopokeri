
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.PeliIkkuna;

public class KorttienAsetusKuuntelija extends Kuuntelija{
    private Piilopokeri pokeri;
    private JFrame frame;
    private JComboBox korttiLaatikko;

    public KorttienAsetusKuuntelija(Piilopokeri pokeri, JFrame frame, JComboBox korttiLaatikko) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.korttiLaatikko = korttiLaatikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int maara = (int) korttiLaatikko.getSelectedItem();
        
        asetaKortit(maara);
        
        frame.dispose();
        
        PeliIkkuna pi = new PeliIkkuna(pokeri);
        pi.run();
    }
    
    public void asetaKortit(int maara) {
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            pelaaja.lisaaKasi(pokeri.getUudetKortit(maara));
            pokeri.lisaaPelaajanKasi(pelaaja);
        }
    }
}
