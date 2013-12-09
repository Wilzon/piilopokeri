
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.UusiValikkoIkkuna;

public class UudelleenAloitusKuuntelija extends Kuuntelija {
    private final Piilopokeri pokeri;
    private final JFrame frame;
    private final JFrame peliFrame;

    public UudelleenAloitusKuuntelija(Piilopokeri pokeri, JFrame frame, JFrame peliFrame) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.peliFrame = peliFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
        peliFrame.dispose();
        
        pokeri.poistaKadet();
        pokeri.poistaKonePelaajat();
        pokeri.luoUusiPakka();
        
        SwingUtilities.invokeLater(new UusiValikkoIkkuna(pokeri));
    }
    
    
}
