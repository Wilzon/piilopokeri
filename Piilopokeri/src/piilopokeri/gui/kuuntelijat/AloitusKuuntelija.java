
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.AsetusIkkuna;

public class AloitusKuuntelija implements ActionListener {
    private Piilopokeri pokeri;
    JFrame frame;
    
    public AloitusKuuntelija(Piilopokeri pokeri, JFrame frame) {
        this.pokeri = pokeri;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AsetusIkkuna ai = new AsetusIkkuna(pokeri);
        ai.run();
        
        frame.dispose();
        
        
    }
    
}
