
package piilopokeri.gui.ikkunat;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;

public class GraafinenKL {
    private Piilopokeri pokeri;
    private JFrame frame;
    private ArrayList<JButton> napit;
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Kasi> kadet;
    
    public GraafinenKL() {
        pokeri = new Piilopokeri();
        napit = new ArrayList();
        pelaajat = new ArrayList();
        kadet = new ArrayList();
        
    }

    public void run() {
        ValikkoIkkuna valikko = new ValikkoIkkuna(pokeri);
        
        valikko.run();
    }
    
    public void asetaKomponentit(Container c) {
        c.setLayout(new GridLayout(2, 5));
        
        
    }
    
    public void luoNapit() {
        
    }
    
}
