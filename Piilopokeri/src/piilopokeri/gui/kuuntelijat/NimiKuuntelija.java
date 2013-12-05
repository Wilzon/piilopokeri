
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.KonePelaajienAsetusIkkuna;

public class NimiKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private ArrayList<JTextField> nimet;
    private JFrame frame;

    public NimiKuuntelija(Piilopokeri pokeri, JFrame frame, ArrayList<JTextField> nimet) {
        this.pokeri = pokeri;
        this.nimet = nimet;
        this.frame = frame;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<Pelaaja> pelaajat = pokeri.getIhmisPelaajat();
        
        for(int i = 0; i < pelaajat.size(); i++) {
            JTextField nimi = nimet.get(i);
            
            pelaajat.get(i).setNimi(nimi.getText());
        }
        frame.dispose();
        
        KonePelaajienAsetusIkkuna koneIkkuna = new KonePelaajienAsetusIkkuna(pokeri);
        koneIkkuna.run();
    }
    
}
