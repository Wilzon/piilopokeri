
package piilopokeri.gui.ikkunat;

import piilopokeri.gui.kuuntelijat.NimiKuuntelija;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import piilopokeri.domain.Piilopokeri;

public class NimenAsetusIkkuna extends Ikkuna{
    private Piilopokeri pokeri;

    public NimenAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        frame.setTitle("Nimien asetus");
    }
    

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        int koko = pokeri.getIhmisPelaajat().size();
        
        ArrayList<JTextField> nimet = new ArrayList();
        
        p.setLayout(new GridLayout(koko + 1, 2));
        
        for(int i = 0; i < koko; i++) {
            p.add(new JLabel("Pelaajan " + (i + 1) + " nimi:"));
            JTextField nimi = new JTextField();
            p.add(nimi);
            
            nimet.add(nimi);
            
        }
        
        JButton ok = new JButton("OK");
        
        ok.addActionListener(new NimiKuuntelija(pokeri, frame, nimet));
        
        p.add(new JLabel());
        p.add(ok);

        
        return p;
    }
    
}
