
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.ikkunat.LopetusIkkuna;

public abstract class Kuuntelija implements ActionListener {

    @Override
    public abstract void actionPerformed(ActionEvent ae);
    
    public void lopetaPeliLopussa(Piilopokeri pokeri, JFrame frame) {
        if(pokeri.onkoPeliLoppunut()) {
            SwingUtilities.invokeLater(new LopetusIkkuna(pokeri, frame));
        }
    }
    
     public void koneKayttaaVuoron(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, 
            HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu) {
         
        Kasi kasi = vuoro.getKasi();
         
        if(!koneVaihtaaAvopakanKanssaJosKannattavaa(pokeri, kasi, avoPakkaNappi)) {
            
            koneVaihtaaPakanKanssaTaiKaantaaKortin(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu, kasi);
            
        }
//        vuoro.seuraava();
//        if(vuoro.getPelaaja().onkoKone()) {
//            koneKayttaaVuoron(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu);
//        }
    }
    
    public boolean koneVaihtaaAvopakanKanssaJosKannattavaa(Piilopokeri pokeri, Kasi kasi, JButton avoPakkaNappi) {
        int avoPakanArvo = pokeri.getAvopakanPaallimmainen().getArvo();
        
        if(avoPakanArvo > 9 || kasi.getArvot().contains(avoPakanArvo)) {
            avoPakkaNappi.doClick();
            
            return true;
            
        }
        return false;
    }
    
    public void koneVaihtaaPakanKanssaTaiKaantaaKortin(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, 
            HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu, Kasi kasi) {
        
        JButton koneNappi = new JButton();
        
        int pakanPaallimmaisenArvo = pokeri.pakanPaallimmainen.getArvo();
        
        if(pakanPaallimmaisenArvo > 9 || kasi.getArvot().contains(pakanPaallimmaisenArvo)) {
            koneNappi.addActionListener(new KortinVaihtoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
            
        }else{
            koneNappi.addActionListener(new KortinKaantoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        }
        
        koneNappi.doClick();
    }
    
    public void luoJaPainaaKoneNappia(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, 
            HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu) {
        
        JButton koneNappi = new JButton();
        koneNappi.addActionListener(new KoneNapinKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        koneNappi.doClick();
    }
}
