
package piilopokeri.gui;

import javax.swing.JButton;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.kuuntelijat.PakkaNapinKuuntelija;

public class PakkaNappi extends JButton{
    private final Piilopokeri pokeri;
    
    public PakkaNappi(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        
        super.setText("[X]");
    }
    
    public void lisaaKuuntelija(Vuoro vuoro, JButton avoPakkaNappi) {
        super.addActionListener(new PakkaNapinKuuntelija(pokeri, vuoro, avoPakkaNappi, this));
    }
}
