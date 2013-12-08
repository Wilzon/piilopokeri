
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class OhjeIkkunanOkKuuntelija extends Kuuntelija{
    JFrame frame;

    public OhjeIkkunanOkKuuntelija(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
    }
}
