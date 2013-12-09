
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import piilopokeri.gui.kuuntelijat.NimiKuuntelija;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import piilopokeri.domain.Piilopokeri;

public class NimienAsetusIkkuna extends PikkuIkkuna{
    private final Piilopokeri pokeri;

    public NimienAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        frame.setTitle("Nimien asetus");
    }

    @Override
    public void run() {
        int korkeus = pokeri.getIhmisPelaajat().size() * 200;
        frame.setPreferredSize(new Dimension(400, korkeus));
        
        int sijaintiY = 400;
        if(pokeri.getIhmisPelaajat().size() > 4) {
            sijaintiY = 0;
        }
        
        frame.setLocation(400, sijaintiY);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        frame.pack();
    }
    
    

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        int koko = pokeri.getIhmisPelaajat().size();
        
        ArrayList<JTextField> nimet = new ArrayList();
        
        p.setLayout(new GridLayout(koko + 1, 2));
        
        for(int i = 0; i < koko; i++) {
            p.add(new JLabel("Pelaajan " + (i + 1) + " nimi:"));
            
            JTextField nimi = new JTextField();
            
            p.add(nimi);
            
            nimet.add(nimi);
            
        }
        okNappi.addActionListener(new NimiKuuntelija(pokeri, frame, nimet));
        
        p.add(new JLabel());
        p.add(okNappi);

        
        return p;
    }
    
}
