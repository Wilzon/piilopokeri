
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.LopetusIkkuna;

public abstract class Kuuntelija implements ActionListener {

    @Override
    public abstract void actionPerformed(ActionEvent ae);
    
    public void lopetaPeliLopussa(Piilopokeri pokeri, JFrame frame, JButton avoPakkaNappi, JButton pakkaNappi) {
        if(pokeri.onkoPeliLoppunut()) {
            avoPakkaNappi.setEnabled(false);
            pakkaNappi.setEnabled(false);
            
            SwingUtilities.invokeLater(new LopetusIkkuna(pokeri, frame));
        }
    }
}
