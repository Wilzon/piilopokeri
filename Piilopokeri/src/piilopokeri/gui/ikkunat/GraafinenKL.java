
package piilopokeri.gui.ikkunat;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import piilopokeri.domain.Piilopokeri;

public class GraafinenKL {
    private Piilopokeri pokeri;
    private JFrame frame;
    private Timer ajastin;
    
    public GraafinenKL() {
        pokeri = new Piilopokeri();
        ajastin = new Timer(1, null);
        ajastin.start();
        
    }

    public void run() {
        SwingUtilities.invokeLater(new ValikkoIkkuna(pokeri));
    }
    
    public void asetaKomponentit(Container c) {
        c.setLayout(new GridLayout(2, 5));
        
        
    }
    
    public void luoNapit() {
        
    }
    
}
