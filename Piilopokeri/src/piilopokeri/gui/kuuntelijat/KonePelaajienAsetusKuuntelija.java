
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Kone;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.KorttienAsetusIkkuna;

public class KonePelaajienAsetusKuuntelija extends Kuuntelija {
    Piilopokeri pokeri;
    JFrame frame;
    JComboBox koneLaatikko;

    public KonePelaajienAsetusKuuntelija(Piilopokeri pokeri, JFrame frame, JComboBox koneLaatikko) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.koneLaatikko = koneLaatikko;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int maara = (int) koneLaatikko.getSelectedItem();
        
        asetaKonePelaajat(maara);
        
        frame.dispose();
        
        SwingUtilities.invokeLater(new KorttienAsetusIkkuna(pokeri));
    }
    
    public void asetaKonePelaajat(int maara) {
        for(int i = 0; i < maara; i++) {
            pokeri.lisaaKonepelaaja(new Kone());
        }
        
    }
    
}

