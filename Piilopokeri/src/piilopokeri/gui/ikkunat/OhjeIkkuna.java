
package piilopokeri.gui.ikkunat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import piilopokeri.gui.kuuntelijat.OhjeIkkunanOkKuuntelija;

/** @author Wilzon */

public class OhjeIkkuna extends Ikkuna{
    private JTextArea tekstiKentta;

    public OhjeIkkuna() {
        frame.setTitle("Piilopokeri ohjeet");
    }

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(400, 600));
        
        frame.setLocation(400, 400);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setVisible(true);
        
        frame.pack();
    }
    
    

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new BorderLayout());
        
        
        tekstiKentta = new JTextArea();
        
        okNappi.addActionListener(new OhjeIkkunanOkKuuntelija(frame));
        
        setTeksti();
        
        p.add(tekstiKentta);
        p.add(okNappi, BorderLayout.SOUTH);
        
        return p;
    }
    
    public void setTeksti() {
        String ohjeTeksti = "1. Aloita uusi peli nappia painamalla."
                + "\n2. Valitse haluatko pitää jokerit pelissä mukana."
                + "\n3. Valitse ihmispelaajien määrä."
                + "\n4. Anna pelaajille nimet."
                + "\n5. Valitse konepelaajien määrä."
                + "\n6. Valitse kuinka monta korttia haluat käteen."
                + "\n7. Pelaa peliä, kunnes se loppuu."
                + "\n8. Näe kuka voitti ja mitä käsiä kaikki saivat."
                + "\n9. Aloita uusi peli tai lopeta pelaaminen."
                + "\n\nPeliohjeet:"
                + "\nSinulla on kolme vaihtoehtoa joka vuoron alussa:"
                + "\n(1)Paina pakka nappia"
                + "\n(2)Paina avopakka nappia"
                + "\n(3)Käännä oma kortti sokkona toisinpäin."
                + "\n\n1. Painamalla pakka nappia näet pakan päällimmäisen kortin."
                + "\nSitten, joko vaihdat pakan kortin yhteen väärinpäin olevista "
                + "\nkorteistasi, jolloin väärinpäin ollut korttisi menee avopakkaan, "
                + "\ntai käännät yhden omista korteistasi ympäri, jolloin pakan "
                + "\npäällimmäinen kortti menee avopakkaan."
                + "\n\n2. Painamalla avopakka nappia vaihdat automaattisesti yhden "
                + "\nväärinpäin olevista korteistasi avopakan korttiin."
                + "\n\n3. Painamalla yhtä väärinpäin olevaa korttiasi voit kääntää "
                + "\nsen ympäri."
                + "\n\nVuorosi loppuu, kun kädessä olevista korteistasi yksi "
                + "\nkääntyy oikeinpäin. Peli loppuu, kun kaikkien kädessä"
                + "\nolevat kortit on käännetty ympäri. Voittaja on se, "
                + "\njolla on paras pokerikäsi."
                + "\n\nOnnea peliin!";
   
        tekstiKentta.setText(ohjeTeksti);
    }
    
}
