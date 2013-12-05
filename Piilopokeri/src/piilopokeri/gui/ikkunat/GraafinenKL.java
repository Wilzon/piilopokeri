
package piilopokeri.gui.ikkunat;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;

public class GraafinenKL {
    private Piilopokeri pokeri;
    private JFrame frame;
    
    public GraafinenKL() {
        pokeri = new Piilopokeri();
        
    }

    public void run() {
        ValikkoIkkuna valikko = new ValikkoIkkuna(pokeri);
        
        SwingUtilities.invokeLater(valikko);
    }
    
    public void asetaKomponentit(Container c) {
        c.setLayout(new GridLayout(2, 5));
        
        
    }
    
    public void luoNapit() {
        
    }
    
}
