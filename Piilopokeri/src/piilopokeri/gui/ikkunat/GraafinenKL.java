
package piilopokeri.gui.ikkunat;

import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;

public class GraafinenKL {
    private final Piilopokeri pokeri;
    
    
    public GraafinenKL() {
        pokeri = new Piilopokeri();
    }

    public void run() {
        SwingUtilities.invokeLater(new ValikkoIkkuna(pokeri));
    }
}
