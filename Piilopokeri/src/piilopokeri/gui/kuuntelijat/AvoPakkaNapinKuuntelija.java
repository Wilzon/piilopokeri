
package piilopokeri.gui.kuuntelijat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.NappienPiilottaja;

public class AvoPakkaNapinKuuntelija extends Kuuntelija{
    private Piilopokeri pokeri;
    private JFrame frame;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNapit;

    public AvoPakkaNapinKuuntelija(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, HashMap<String, ArrayList<JButton>> korttiNapit) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.korttiNapit = korttiNapit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<JButton> pelaajanNapit = korttiNapit.get(vuoro.getPelaajanNimi());

        for(JButton nappi : pelaajanNapit) {
            if(nappi.getName() == null) {
                nappi.setText(pokeri.getAvopakanPaallimmainen().toString());
                pokeri.koneVaihtaaAvopakanKanssa(vuoro.getKasi());
                
                nappi.setName("painettu");
                nappi.doClick();
                
                break;
            }
        }
        vuoro.seuraava();
        
        avoPakkaNappi.setText(pokeri.getAvopakanPaallimmainen().toString());
        
        avoPakkaNappi = (JButton) KorttienMaalaaja.setVari(pokeri, pokeri.getAvopakanPaallimmainen(), avoPakkaNappi);
        
        NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNapit);
        
        luoJaPainaaKoneNappia(pokeri, frame, vuoro, avoPakkaNappi, korttiNapit);
        
        lopetaPeliLopussa(pokeri, frame);
    }
    
    public JButton setVari(JButton korttiNappi) {
        int maa = pokeri.pakanPaallimmainen.getMaa();
        
        if(maa == Kortti.HERTTA || maa == Kortti.RUUTU) {
            korttiNappi.setForeground(Color.red);
            
        }
        else if(maa == Kortti.JOKERI) {
            korttiNappi.setForeground(Color.green);
            
        }else{
            korttiNappi.setForeground(Color.black);
            
        }
        
        return korttiNappi;
    }
    
}
