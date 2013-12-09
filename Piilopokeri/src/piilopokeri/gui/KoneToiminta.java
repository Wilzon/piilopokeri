
package piilopokeri.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.kuuntelijat.KoneNapinKuuntelija;
import piilopokeri.gui.kuuntelijat.KortinKaantoKuuntelija;
import piilopokeri.gui.kuuntelijat.KortinVaihtoKuuntelija;

public class KoneToiminta {

    public static void luoJaPainaKoneNappia(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, JButton pakkaNappi) {
        JButton koneNappi = new JButton();
        koneNappi.addActionListener(new KoneNapinKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
        
        koneNappi.doClick();
    }
    
    public static void koneKayttaaVuoron(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, JButton pakkaNappi) {
        Kasi kasi = vuoro.getKasi();
         
        if(!koneVaihtaaAvopakanKanssaJosKannattavaa(pokeri, kasi, avoPakkaNappi)) {
            
            koneVaihtaaPakanKanssaTaiKaantaaKortin(pokeri, frame, vuoro, kasi, avoPakkaNappi, pakkaNappi);
        }
    }
    
    public static boolean koneVaihtaaAvopakanKanssaJosKannattavaa(Piilopokeri pokeri, Kasi kasi, JButton avoPakkaNappi) {
        int avoPakanArvo = pokeri.getAvopakanPaallimmainen().getArvo();
        
        if(avoPakanArvo > 9 || kasi.getArvot().contains(avoPakanArvo)) {
            avoPakkaNappi.doClick();
            
            return true;
            
        }
        return false;
    }
    
    public static void koneVaihtaaPakanKanssaTaiKaantaaKortin(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, Kasi kasi, JButton avoPakkaNappi, JButton pakkaNappi) {
        JButton koneNappi = new JButton();
        
        int pakanPaallimmaisenArvo = pokeri.pakanPaallimmainen.getArvo();
        
        if(pakanPaallimmaisenArvo > 9 || kasi.getArvot().contains(pakanPaallimmaisenArvo)) {
            koneNappi.addActionListener(new KortinVaihtoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
            
        }else{
            koneNappi.addActionListener(new KortinKaantoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
            
        }
        
        koneNappi.doClick();
    }
    
    public static void luoJaPainaaKoneNappia(Piilopokeri pokeri, JFrame frame, Vuoro vuoro, JButton avoPakkaNappi, JButton pakkaNappi) {
        JButton koneNappi = new JButton();
        koneNappi.addActionListener(new KoneNapinKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
        
        koneNappi.doClick();
    }
}
