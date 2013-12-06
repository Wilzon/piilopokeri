
package piilopokeri.gui.ikkunat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.kuuntelijat.KortinKaantoKuuntelija;
import piilopokeri.gui.kuuntelijat.KortinVaihtoKuuntelija;

public class VaihdaPakanKanssaIkkuna extends Ikkuna{
    private Piilopokeri pokeri;
    private Vuoro vuoro;
    private JButton avoPakkaNappi;
    private HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu;

    public VaihdaPakanKanssaIkkuna(Piilopokeri pokeri, Vuoro vuoro, JButton avoPakkaNappi, HashMap<String, ArrayList<JButton>> korttiNappiHajautustaulu) {
        this.pokeri = pokeri;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.korttiNappiHajautustaulu = korttiNappiHajautustaulu;
        
        frame.setTitle("Vaihda kortti");
    }

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(200, 200));
        
        frame.setLocation(100, 100);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setVisible(true);
        
        frame.pack();
        
    }
    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 2));
        
        JLabel pakkaTeksti = new JLabel("Pakan kortti:");
        JLabel pakanKortti = new JLabel(pokeri.pakanPaallimmainen.toString(), JLabel.CENTER);
        
        KorttienMaalaaja.maalaaNappi(pokeri, pokeri.pakanPaallimmainen, pakanKortti);
        
        p.add(pakkaTeksti);
        p.add(pakanKortti);
        
        JButton vaihda = new JButton("Vaihda");
        JButton kaanna = new JButton("Käännä");
        
        vaihda.addActionListener(new KortinVaihtoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        kaanna.addActionListener(new KortinKaantoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, korttiNappiHajautustaulu));
        
        p.add(vaihda);
        p.add(kaanna);
        
        return p;
    }
}
