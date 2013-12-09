
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import javax.swing.WindowConstants;

public abstract class PikkuIkkuna extends Ikkuna{

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setLocation(400, 400);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        frame.pack();
    }
}
