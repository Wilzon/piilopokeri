
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.ikkunat.VaihdaPakanKanssaIkkuna;

public class PakkaNapinKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private JButton pakkaNappi;

    public PakkaNapinKuuntelija(Piilopokeri pokeri, Vuoro vuoro, 
            JButton avoPakkaNappi, JButton pakkaNappi) {
        
        this.pokeri = pokeri;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        VaihdaPakanKanssaIkkuna vaihtoIkkuna = new VaihdaPakanKanssaIkkuna(pokeri, vuoro, avoPakkaNappi, pakkaNappi);
        
        SwingUtilities.invokeLater(vaihtoIkkuna);
    }
    
}
