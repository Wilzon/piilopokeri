
package piilopokeri.gui.ikkunat;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.IhmisPelaajienAsetusKuuntelija;

public class IhmisPelaajienAsetusIkkuna extends PikkuIkkuna{
    private final Piilopokeri pokeri;

    public IhmisPelaajienAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        frame.setTitle("Ihmispelaajien asetus");
    }

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        JComboBox ihmisLaatikko = new JComboBox(numeroLista(1, 10));
        
        JLabel ihmisPelaajat = new JLabel("Pelaajien määrä:");
        
        okNappi.addActionListener(new IhmisPelaajienAsetusKuuntelija(pokeri, frame, ihmisLaatikko));
        
        p.add(ihmisPelaajat);
        p.add(ihmisLaatikko);
        p.add(new JLabel());
        p.add(okNappi);
        
        return p;
    }
    
}
