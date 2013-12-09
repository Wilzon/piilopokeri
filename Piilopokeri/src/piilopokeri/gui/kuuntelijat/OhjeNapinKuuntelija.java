
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import piilopokeri.gui.ikkunat.OhjeIkkuna;

/** @author Wilzon */

public class OhjeNapinKuuntelija extends Kuuntelija{
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        SwingUtilities.invokeLater(new OhjeIkkuna());
    }
    
}
