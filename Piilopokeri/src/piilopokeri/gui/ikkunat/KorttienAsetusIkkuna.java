
package piilopokeri.gui.ikkunat;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.KorttienAsetusKuuntelija;

public class KorttienAsetusIkkuna extends PikkuIkkuna{
    private Piilopokeri pokeri;
    private int pelaajienMaara;

    public KorttienAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        this.pelaajienMaara = pokeri.getPelaajat().size();
        
        frame.setTitle("Korttien asetus");
        
    }
    
    
    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        JLabel kortit = new JLabel("Korttien määrä kädessä:");
        
        JComboBox korttiLaatikko = new JComboBox(numeroLista(1, maxKorttiMaara()));
        
        asetaLaatikkoOikeaanKohtaan(korttiLaatikko);
        
        p.add(kortit);
        p.add(korttiLaatikko);
        p.add(new JLabel());
        p.add(okNappi);
        
        okNappi.addActionListener(new KorttienAsetusKuuntelija(pokeri, frame, korttiLaatikko));
        
        return p;
    }
    
    public int maxKorttiMaara() {
        int maara = 52 / (pelaajienMaara * 2);
        
        return maara;
    }
    
    public void asetaLaatikkoOikeaanKohtaan(JComboBox korttiLaatikko) {
        int mones = 4;
        
        if(maxKorttiMaara() < 5) {
            mones = maxKorttiMaara() - 1;
            
        }
        korttiLaatikko.setSelectedIndex(mones);
    }
    
}
