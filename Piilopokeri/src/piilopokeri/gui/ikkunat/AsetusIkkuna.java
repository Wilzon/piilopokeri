
package piilopokeri.gui.ikkunat;

import piilopokeri.gui.kuuntelijat.AsetusKuuntelija;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Piilopokeri;

public class AsetusIkkuna extends Ikkuna {
    private Piilopokeri pokeri;
    
    public AsetusIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        frame.setTitle("Asetukset");
    }

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        String[] kumpi = {"kyllä", "ei"};
        ArrayList<JComboBox> laatikot = new ArrayList();
        
        JComboBox numeroBox1 = new JComboBox(numeroLista(0, 5));
        JComboBox numeroBox2 = new JComboBox(numeroLista(0, 5));
        JComboBox numeroBox3 = new JComboBox(numeroLista(1, 10));
        
        JComboBox kumpiBox = new JComboBox(kumpi);
        
        JLabel jokerit = new JLabel("Poista jokerit:");
        
        JLabel ihmisPelaajat = new JLabel("Pelaajien määrä:");
        
        JLabel konePelaajat = new JLabel("Koneiden määrä:");
        
        JLabel kortit = new JLabel("Korttien määrä:");
        
        JButton ok = new JButton("OK");
        
        laatikot.add(kumpiBox);
        laatikot.add(numeroBox1);
        laatikot.add(numeroBox2);
        laatikot.add(numeroBox3);
        
        ok.addActionListener(new AsetusKuuntelija(pokeri, frame, laatikot));
        
        p.add(jokerit);
        p.add(kumpiBox);
        p.add(ihmisPelaajat);
        p.add(numeroBox1);
        p.add(konePelaajat);
        p.add(numeroBox2);
        p.add(kortit);
        p.add(numeroBox3);
        p.add(new JLabel());
        p.add(ok);
        return p;
        
    }
    
    
    
}
