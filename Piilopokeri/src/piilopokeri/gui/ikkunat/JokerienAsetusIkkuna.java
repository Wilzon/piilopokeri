
package piilopokeri.gui.ikkunat;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.JokerienAsetusKuuntelija;

public class JokerienAsetusIkkuna extends PikkuIkkuna{
    private Piilopokeri pokeri;

    public JokerienAsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        frame.setTitle("Jokerien asetus");
    }

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        String[] kumpi = {"kyllä", "ei"};
        
        JComboBox kumpiLaatikko = new JComboBox(kumpi);
        
        JLabel jokerit = new JLabel("Poista jokerit:");
        
        
        okNappi.addActionListener(new JokerienAsetusKuuntelija(pokeri, frame, kumpiLaatikko));
        
        p.add(jokerit);
        p.add(kumpiLaatikko);
        p.add(new JLabel());
        p.add(okNappi);
        
        return p;
    }
    
    
}
