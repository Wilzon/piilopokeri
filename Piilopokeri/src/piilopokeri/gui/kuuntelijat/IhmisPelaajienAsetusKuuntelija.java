
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.KonePelaajienAsetusIkkuna;
import piilopokeri.gui.ikkunat.NimienAsetusIkkuna;

public class IhmisPelaajienAsetusKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private JComboBox ihmisLaatikko;
    private NimienAsetusIkkuna nimiIkkuna;

    public IhmisPelaajienAsetusKuuntelija(Piilopokeri pokeri, JFrame frame, JComboBox ihmisLaatikko) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.ihmisLaatikko = ihmisLaatikko;
        nimiIkkuna = new NimienAsetusIkkuna(pokeri);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int maara = (int) ihmisLaatikko.getSelectedItem();
        
        asetaIhmisPelaajat(maara);
        
        frame.dispose();
        
        if(!nimiIkkuna.getFrame().isVisible()) {
            KonePelaajienAsetusIkkuna koneIkkuna = new KonePelaajienAsetusIkkuna(pokeri);
            koneIkkuna.run();
        }
    }
    
    public void asetaIhmisPelaajat(int maara) {
        if(maara > 0) {
            for(int i = 0; i < maara; i++) {
                pokeri.lisaaIhmispelaaja(new Pelaaja());
                
            }
            nimiIkkuna.run();
        }
    }
}
