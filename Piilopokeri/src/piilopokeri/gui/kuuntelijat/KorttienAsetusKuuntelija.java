
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.PeliIkkuna;

public class KorttienAsetusKuuntelija extends Kuuntelija{
    private final Piilopokeri pokeri;
    private final JFrame frame;
    private final JComboBox korttiLaatikko;

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
        
        SwingUtilities.invokeLater(new PeliIkkuna(pokeri));
    }
    
    public void asetaKortit(int maara) {
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            pelaaja.lisaaKasi(pokeri.getUudetKortit(maara));
            
            pokeri.lisaaPelaajanKasi(pelaaja);
        }
    }
}
