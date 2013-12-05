
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;

public class LopetusKuuntelija extends Kuuntelija {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
}
