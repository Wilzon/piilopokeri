
package piilopokeri.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.kuuntelijat.AvoPakkaNapinKuuntelija;

public class AvoPakkaNappi extends JButton{
    private final Piilopokeri pokeri;
    
    public AvoPakkaNappi(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        super.setText(pokeri.getAvopakanPaallimmainen().toString());
    }
    
    public void lisaaKuuntelija(JFrame frame, Vuoro vuoro, JButton pakkaNappi) {
        super.addActionListener(new AvoPakkaNapinKuuntelija(pokeri, frame, vuoro, this, pakkaNappi));
    }
}
