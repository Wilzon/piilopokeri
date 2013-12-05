
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.IhmisPelaajienAsetusIkkuna;
import piilopokeri.gui.ikkunat.JokerienAsetusIkkuna;

public class AloitusKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    
    public AloitusKuuntelija(Piilopokeri pokeri, JFrame frame) {
        this.pokeri = pokeri;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
        
        SwingUtilities.invokeLater(new JokerienAsetusIkkuna(pokeri));
        
    }
    
}
