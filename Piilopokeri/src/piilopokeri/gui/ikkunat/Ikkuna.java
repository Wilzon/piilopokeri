
package piilopokeri.gui.ikkunat;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class Ikkuna implements Runnable{
    protected JFrame frame = new JFrame();
    protected JButton okNappi = okNappi();
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(1000, 1000));
        
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
//        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        
        frame.setLocation(200, 0);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        frame.pack();
    }
    public abstract JPanel lisaaPaneli();
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Object[] numeroLista(int pienin, int suurin) {
        ArrayList<Integer> numerot = new ArrayList();
        
        for(int i = pienin; i <= suurin; i++) {
            numerot.add(i);
        }
        return numerot.toArray();
    }
    
    public JButton okNappi() {
        JButton ok = new JButton("OK");
        
        ok.setForeground(Color.red);

        return ok;
    }
}
