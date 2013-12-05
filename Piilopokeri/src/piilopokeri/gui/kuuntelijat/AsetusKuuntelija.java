
package piilopokeri.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import piilopokeri.domain.Kone;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.NimienAsetusIkkuna;
import piilopokeri.gui.ikkunat.PeliIkkuna;

public class AsetusKuuntelija extends Kuuntelija {
    private Piilopokeri pokeri;
    private JComboBox jokerit;
    private JComboBox ihmisPelaajat;
    private JComboBox konePelaajat;
    private JComboBox kortit;
    private JFrame frame;
    private NimienAsetusIkkuna nimiIkkuna;

    public AsetusKuuntelija(Piilopokeri pokeri, JFrame frame, ArrayList<JComboBox> laatikot) {
        this.pokeri = pokeri;
        this.frame = frame;
        this.nimiIkkuna = new NimienAsetusIkkuna(pokeri);
        
        this.jokerit = laatikot.get(0);
        this.ihmisPelaajat = laatikot.get(1);
        this.konePelaajat = laatikot.get(2);
        this.kortit = laatikot.get(3);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String jokeritPakasta = (String) jokerit.getSelectedItem();
        int ihmisMaara = (int) ihmisPelaajat.getSelectedItem();
        int koneMaara = (int) konePelaajat.getSelectedItem();
        int korttiMaara = (int) kortit.getSelectedItem();
        
        poistaJokerit(jokeritPakasta);
        
        asetaIhmisPelaajat(ihmisMaara);
        
        asetaKonePelaajat(koneMaara);
        
        asetaKortit(korttiMaara);
        
        
        frame.dispose();
        
        if(!nimiIkkuna.getFrame().isVisible()) {
            PeliIkkuna pi = new PeliIkkuna(pokeri);
            pi.run();
        }
    }
    
    public void poistaJokerit(String kumpi) {
        if(kumpi.equals("kyllä")) {
            pokeri.poistaJokeritPakasta();
        }
    }
    
    public void asetaIhmisPelaajat(int maara) {
        if(maara > 0) {
            for(int i = 0; i < maara; i++) {
                pokeri.lisaaIhmispelaaja(new Pelaaja());
                
            }
            nimiIkkuna.run();
        }
    }
    
    public void asetaKonePelaajat(int maara) {
        for(int i = 0; i < maara; i++) {
            pokeri.lisaaKonepelaaja(new Kone());
        }
    }
    
    public void asetaKortit(int maara) {
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            pelaaja.lisaaKasi(pokeri.getUudetKortit(maara));
            pokeri.lisaaPelaajanKasi(pelaaja);
        }
    }
}
