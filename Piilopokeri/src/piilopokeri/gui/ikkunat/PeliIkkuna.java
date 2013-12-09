
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.AvoPakkaNappi;
import piilopokeri.gui.KoneToiminta;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.NappiHallinto;
import piilopokeri.gui.PakkaNappi;
import piilopokeri.gui.kuuntelijat.KorttiNapinKuuntelija;

public class PeliIkkuna extends Ikkuna{
    private final Piilopokeri pokeri;
    private final Vuoro vuoro;
    private final PakkaNappi pakkaNappi;
    private final AvoPakkaNappi avoPakkaNappi;
    private JPanel panel;

    public PeliIkkuna(Piilopokeri pokeri) {
        this.pokeri = pokeri;
        this.vuoro = new Vuoro(pokeri, 0);
        panel = new JPanel();
        
        pakkaNappi = new PakkaNappi(pokeri);
        avoPakkaNappi = new AvoPakkaNappi(pokeri);

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
        
        NappiHallinto.piilotaMuidenPelaajienNapit(pokeri, vuoro);
        
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
        
        KorttienMaalaaja.maalaaNappi(pokeri, pokeri.getAvopakanPaallimmainen(), avoPakkaNappi);

        avoPakkaNappi.lisaaKuuntelija(frame, vuoro, pakkaNappi);
        pakkaNappi.lisaaKuuntelija(vuoro, avoPakkaNappi);
        
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
        
            pelaaja.setKorttiNappi(korttiNappi);
            
            KorttiNapinKuuntelija nappiKuuntelija = new KorttiNapinKuuntelija(pokeri, frame, vuoro, kortti,
                    korttiNappi, avoPakkaNappi, pakkaNappi);
            
            korttiNappi.addActionListener(nappiKuuntelija);
            
            p.add(korttiNappi);
            
        }
        
        return p;
    }
    
    public void luoJaPainaKoneNappia() {
        KoneToiminta.luoJaPainaKoneNappia(pokeri, frame, vuoro, okNappi, okNappi);
    }
}
