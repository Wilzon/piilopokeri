
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PikkuIkkuna extends Ikkuna{

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setLocation(400, 400);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        frame.pack();
    }
    
    
    @Override
    public JPanel lisaaPaneli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
