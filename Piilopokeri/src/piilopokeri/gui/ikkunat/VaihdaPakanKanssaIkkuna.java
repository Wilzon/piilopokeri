
package piilopokeri.gui.ikkunat;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Vuoro;
import piilopokeri.gui.KorttienMaalaaja;
import piilopokeri.gui.kuuntelijat.KortinKaantoKuuntelija;
import piilopokeri.gui.kuuntelijat.KortinVaihtoKuuntelija;

public class VaihdaPakanKanssaIkkuna extends Ikkuna{
    private final Piilopokeri pokeri;
    private final Vuoro vuoro;
    private final JButton avoPakkaNappi;
    private final JButton pakkaNappi;

    public VaihdaPakanKanssaIkkuna(Piilopokeri pokeri, Vuoro vuoro, 
            JButton avoPakkaNappi, JButton pakkaNappi) {
        
        this.pokeri = pokeri;
        this.vuoro = vuoro;
        this.avoPakkaNappi = avoPakkaNappi;
        this.pakkaNappi = pakkaNappi;
        
        frame.setTitle("Vaihda kortti");
    }

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(200, 200));
        
        frame.setLocation(50, 100);
        
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
        
        vaihda.addActionListener(new KortinVaihtoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
        kaanna.addActionListener(new KortinKaantoKuuntelija(pokeri, frame, vuoro, avoPakkaNappi, pakkaNappi));
        
        p.add(vaihda);
        p.add(kaanna);
        
        return p;
    }
}
