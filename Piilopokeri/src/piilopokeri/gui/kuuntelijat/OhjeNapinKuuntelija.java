
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.OhjeIkkuna;

/** @author Wilzon */

public class OhjeNapinKuuntelija extends Kuuntelija{
    Piilopokeri pokeri;
    JFrame frame;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        SwingUtilities.invokeLater(new OhjeIkkuna());
    }
    
}
