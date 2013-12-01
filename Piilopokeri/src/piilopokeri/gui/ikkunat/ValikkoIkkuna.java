
package piilopokeri.gui.ikkunat;

import piilopokeri.gui.kuuntelijat.AloitusKuuntelija;
import piilopokeri.gui.kuuntelijat.LopetusKuuntelija;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;

public class ValikkoIkkuna extends Ikkuna{
    private Piilopokeri pokeri;
    
    public ValikkoIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        frame.setTitle("Valikko");
    }
    

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 2));
        
        JButton uusiPeli = new JButton("Uusi peli");
        JButton lopeta = new JButton("Lopeta");
        
        lopeta.addActionListener(new LopetusKuuntelija());
        uusiPeli.addActionListener(new AloitusKuuntelija(pokeri, frame));
        
        p.add(lopeta);
        p.add(uusiPeli);
        
        return p;
    }
    
}
