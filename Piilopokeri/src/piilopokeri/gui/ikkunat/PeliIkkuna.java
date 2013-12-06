
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.NappienPiilottaja;
import piilopokeri.gui.kuuntelijat.AvoPakkaNapinKuuntelija;
import piilopokeri.gui.kuuntelijat.KoneNapinKuuntelija;
import piilopokeri.gui.kuuntelijat.KorttiNapinKuuntelija;
import piilopokeri.gui.kuuntelijat.PakkaNapinKuuntelija;

public class PeliIkkuna extends Ikkuna{
    private Piilopokeri pokeri;
    private HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu;
    private Vuoro vuoro;
    private JButton pakkaNappi;
    private JButton avoPakkaNappi;
    private JButton koneNappi;
    private JPanel panel;

    public PeliIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        this.vuoro = new Vuoro(pokeri, 0);
        panel = new JPanel();
        korttiNappiHajautustaulu = new HashMap();

        frame.setTitle("Piilopokeri");
    }
    
    @Override
    public void run() {
        int korkeus = pokeri.getPelaajat().size() * 200;
        
        frame.setPreferredSize(new Dimension(1000, korkeus));
        
        frame.setLocation(200, 0);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        frame.pack();
        
        luoJaPainaKoneNappia();
    }
    
    @Override
    public JPanel lisaaPaneli() {
        JPanel nappiPaneli = lisaaNappiPaneli();
        
        panel.setLayout(new GridLayout(0, 1));
        
        panel = lisaaPelaajienNapit(panel);
        
        NappienPiilottaja.piilotaMuidenPelaajienNapit(pokeri, vuoro, korttiNappiHajautustaulu);
        
        panel.add(new JLabel());

        panel.add(nappiPaneli);
        
        return panel;
    }
    
    public void poistaPaneli(JPanel p) {
        frame.remove(p);
    }
    
    public JPanel lisaaPelaajienNapit(JPanel p) {
        for(Pelaaja pelaaja : pokeri.getPelaajat()) {
            String nimi = pelaaja.getNimi();
            JLabel pelaajanNimi = new JLabel(nimi);
            
            korttiNappiHajautustaulu.put(nimi, new ArrayList<JButton>());
         
            p.add(pelaajanNimi);
            
            p.add(lisaaKorttiPaneli(pelaaja));
            
        }
        return p;
    }
    
    public JPanel lisaaNappiPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        JLabel pakkaTeksti = new JLabel("Pakka:", JLabel.CENTER);
        JLabel avoPakkaTeksti = new JLabel("Avopakka:", JLabel.CENTER);
        
        pakkaNappi = new JButton("[X]");
        avoPakkaNappi = new JButton(pokeri.getAvopakanPaallimmainen().toString());
        
        pakkaNappi.setSize(100, 50);
        avoPakkaNappi.setSize(100, 50);
        
        KorttienMaalaaja.maalaaNappi(pokeri, pokeri.getAvopakanPaallimmainen(), avoPakkaNappi);

        avoPakkaNappi.addActionListener(new AvoPakkaNapinKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        pakkaNappi.addActionListener(new PakkaNapinKuuntelija(pokeri, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        
        p.add(pakkaTeksti);
        p.add(pakkaNappi);
        p.add(avoPakkaTeksti);
        p.add(avoPakkaNappi);
        
        return p;
    }
    
    public JPanel lisaaKorttiPaneli(Pelaaja pelaaja) {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(1, 0));
        
        pelaaja.jarjestaOmatKortit();
        
        for(Kortti kortti: pelaaja.getKasi().getKortit()) {
            JButton korttiNappi = new JButton(kortti.toString());
        
            korttiNappiHajautustaulu.get(pelaaja.getNimi()).add(korttiNappi);

            KorttiNapinKuuntelija nappiKuuntelija = new KorttiNapinKuuntelija(pokeri, frame, korttiNappi, avoPakkaNappi, kortti, vuoro, korttiNappiHajautustaulu);
            
            korttiNappi.addActionListener(nappiKuuntelija);
            
            p.add(korttiNappi);
            
        }
        
        return p;
    }
    
    public void luoJaPainaKoneNappia() {
        koneNappi = new JButton();
        koneNappi.addActionListener(new KoneNapinKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        koneNappi.doClick();
    }
    
}
