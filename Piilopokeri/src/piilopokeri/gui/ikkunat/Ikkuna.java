
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class Ikkuna implements Runnable{
    protected JFrame frame = new JFrame();
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(500, 500));
        
        frame.setLocation(200, 200);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        frame.setVisible(true);

        frame.pack();
    }
    public abstract JPanel lisaaPaneli();
    
    public JFrame getFrame() {
        return frame;
    }
}
