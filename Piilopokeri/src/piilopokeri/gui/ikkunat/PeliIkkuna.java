
package piilopokeri.gui.ikkunat;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;

public class PeliIkkuna extends Ikkuna{
    private Piilopokeri pokeri;
    private HashMap<Pelaaja, ArrayList<JButton>> korttiNappiHajautustaulu;

    public PeliIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        korttiNappiHajautustaulu = new HashMap();

        frame.setTitle("Piilopokeri");
    }
    
    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(pokeri.getPelaajat().size() * 2, 1));
        
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            JLabel pelaajanNimi = new JLabel(pelaaja.getNimi());
            
            korttiNappiHajautustaulu.put(pelaaja, new ArrayList<JButton>());
            
            p.add(pelaajanNimi);
            
            p.add(lisaaKorttiPaneli(pelaaja));
            
        }
        return p;
    }
    
    public JPanel lisaaKorttiPaneli(Pelaaja pelaaja) {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(1, pelaaja.getKasi().getKortit().size()));
        
        for(Kortti kortti: pelaaja.getKasi().getKortit()) {
                JButton korttiNappi = new JButton(kortti.toString());
                
                korttiNappiHajautustaulu.get(pelaaja).add(korttiNappi);
                
                p.add(korttiNappi);
            }
        return p;
    }

    
    
    
}
