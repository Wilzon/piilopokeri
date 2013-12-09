
package piilopokeri.gui.ikkunat;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.KonePelaajienAsetusKuuntelija;

public class KonePelaajienAsetusIkkuna extends PikkuIkkuna{
    private final Piilopokeri pokeri;
    private final int ihmisPelaajienMaara;

    public KonePelaajienAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        this.ihmisPelaajienMaara = pokeri.getIhmisPelaajat().size();
        
        frame.setTitle("Konepelaajien asetus");
    }

    
    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        JComboBox koneLaatikko = new JComboBox(numeroLista(minMaaraKoneita(), maxMaaraKoneita()));
        
        JLabel konePelaajat = new JLabel("Koneiden määrä:");
        
        okNappi.addActionListener(new KonePelaajienAsetusKuuntelija(pokeri, frame, koneLaatikko));
        
        p.add(konePelaajat);
        p.add(koneLaatikko);
        p.add(new JLabel());
        p.add(okNappi);
        
        return p;
    }
    
    public int maxMaaraKoneita() {
        int maara = 10 - ihmisPelaajienMaara;
        
        return maara;
    }
    
    public int minMaaraKoneita() {
        int maara = 0;
        
        if(ihmisPelaajienMaara < 2) {
            maara = 1;
            
        }
        return maara;
    }
    
}
