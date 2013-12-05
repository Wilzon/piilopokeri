
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.ikkunat.VaihdaPakanKanssaIkkuna;

public class PakkaNapinKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public PakkaNapinKuuntelija(Piilopokeri pokeri, Vuoro vuoro, JButton avoPakkaNappi, HashMap<String, ArrayList<JButton>> korttiNapit) {
        this.pokeri = pokeri;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.korttiNapit = korttiNapit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //JPopupMenu?
        
        VaihdaPakanKanssaIkkuna vaihtoIkkuna = new VaihdaPakanKanssaIkkuna(pokeri, vuoro, avoPakkaNappi, korttiNapit);
        
        SwingUtilities.invokeLater(vaihtoIkkuna);
    }
    
}
