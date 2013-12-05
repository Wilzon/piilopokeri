
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.NappienPiilottaja;

public class KortinVaihtoKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public KortinVaihtoKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, 
            HashMap<String, ArrayList<JButton>> korttiNapit) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.korttiNapit = korttiNapit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<JButton> pelaajanNapit = korttiNapit.get(vuoro.getPelaajanNimi());
        String korttiString = "";

        for(JButton nappi : pelaajanNapit) {
            if(nappi.getName() == null) {
                Kortti pakanPaallimmainen = pokeri.pakanPaallimmainen;
                nappi.setText(pakanPaallimmainen.toString());
                
                korttiString = pokeri.koneVaihtaaSuljetunPakanKanssa(vuoro.getKasi());
                
                nappi.setName("painettu");
                nappi.doClick();
                
                break;
            }
        }
        vuoro.seuraava();
        
        avoPakkaNappi.setText(korttiString);
        
        NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
        
        luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, korttiNapit);
        
        lopetaPeliLopussa(pokeri, frame);
        
        if(!frame.getTitle().equals("Piilopokeri")) {
            frame.dispose();
        }
    }
    
}
