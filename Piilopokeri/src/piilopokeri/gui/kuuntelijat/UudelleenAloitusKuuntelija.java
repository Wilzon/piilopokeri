
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.ValikkoIkkuna;

public class UudelleenAloitusKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private JFrame frame2;

    public UudelleenAloitusKuuntelija(Piilopokeri pokeri, JFrame frame, JFrame frame2) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.frame2 = frame2;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
        frame2.dispose();
        
        SwingUtilities.invokeLater(new ValikkoIkkuna(pokeri));
    }
    
    
}
