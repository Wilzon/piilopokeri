
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

public class KortinKaantoKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private JButton pakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public KortinKaantoKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi,
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
    ArrayList<Kortti> kortit = vuoro.getKortit();
    String korttiString;

        for(JButton nappi : pelaajanNapit) {
            if(nappi.getName() == null) {
                avoPakkaNappi.setText(pokeri.pakanPaallimmainen.toString());
                
                korttiString = pokeri.kaannaKoneenKortti(vuoro.getKasi());
                
                nappi.setText(korttiString);
                
                nappi.setName("painettu");
                nappi.doClick();
                
                break;
            }
        }
        vuoro.seuraava();
        
        NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
        
        luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, korttiNapit);
        
        lopetaPeliLopussa(pokeri, frame);
        
        if(!frame.getTitle().equals("Piilopokeri")) {
            frame.dispose();
        }
//        for(int i = 0; i < kortit.size(); i++) {
//            Kortti kortti = kortit.get(i);
//            if(kortti.toString().equals(korttiString)) {
//            }
//        }
        
    }   
}
