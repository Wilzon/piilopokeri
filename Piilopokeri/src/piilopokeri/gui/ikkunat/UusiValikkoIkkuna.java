
package piilopokeri.gui.ikkunat;

import javax.swing.JButton;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.LopetusKuuntelija;
import piilopokeri.gui.kuuntelijat.UusiAloitusKuuntelija;

public class UusiValikkoIkkuna extends ValikkoIkkuna{

    public UusiValikkoIkkuna(Piilopokeri pokeri) {
        super(pokeri);
    }

    @Override
    public void lisaaKuuntelijat(JButton lopeta, JButton uusiPeli) {
        lopeta.addActionListener(new LopetusKuuntelija());
        uusiPeli.addActionListener(new UusiAloitusKuuntelija(pokeri, frame));
    }
    
}
