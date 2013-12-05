
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.IhmisPelaajienAsetusIkkuna;

public class JokerienAsetusKuuntelija extends Kuuntelija{
    private Piilopokeri pokeri;
    private JFrame frame;
    private JComboBox kumpiLaatikko;

    public JokerienAsetusKuuntelija(Piilopokeri pokeri, JFrame frame, JComboBox kumpiLaatikko) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.kumpiLaatikko = kumpiLaatikko;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String kumpi = (String) kumpiLaatikko.getSelectedItem();
        
        poistaJokeritTarvittaessa(kumpi);
        
        frame.dispose();
        
        SwingUtilities.invokeLater(new IhmisPelaajienAsetusIkkuna(pokeri));
    }
    
    public void poistaJokeritTarvittaessa(String kumpi) {
        if(kumpi.equals("kyllä")) {
            pokeri.poistaJokeritPakasta();
        }
    }
    
}
