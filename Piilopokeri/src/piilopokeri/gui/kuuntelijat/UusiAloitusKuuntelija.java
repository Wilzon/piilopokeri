
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.KonePelaajienAsetusIkkuna;

public class UusiAloitusKuuntelija extends Kuuntelija{
    private final Piilopokeri pokeri;
    private final JFrame frame;

    public UusiAloitusKuuntelija(Piilopokeri pokeri, JFrame frame) {
        this.pokeri = pokeri;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
        
        SwingUtilities.invokeLater(new KonePelaajienAsetusIkkuna(pokeri));
    }
    
    
}
