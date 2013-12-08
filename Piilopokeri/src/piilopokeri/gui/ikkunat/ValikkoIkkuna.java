
package piilopokeri.gui.ikkunat;

import piilopokeri.gui.kuuntelijat.AloitusKuuntelija;
import piilopokeri.gui.kuuntelijat.LopetusKuuntelija;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.OhjeNapinKuuntelija;

public class ValikkoIkkuna extends PikkuIkkuna{
    protected Piilopokeri pokeri;
    
    public ValikkoIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        frame.setTitle("Piilopokeri");
    }
    

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 3));
        
        JButton uusiPeli = new JButton("Uusi peli");
        JButton lopeta = new JButton("Lopeta");
        JButton ohjeet = new JButton("Ohjeet");
        
        lisaaKuuntelijat(lopeta, uusiPeli);
        
        ohjeet.addActionListener(new OhjeNapinKuuntelija());
        
        p.add(lopeta);
        p.add(uusiPeli);
        p.add(ohjeet);
        
        return p;
    }
    
    public void lisaaKuuntelijat(JButton lopeta, JButton uusiPeli) {
        lopeta.addActionListener(new LopetusKuuntelija());
        uusiPeli.addActionListener(new AloitusKuuntelija(pokeri, frame));
    }
    
}
