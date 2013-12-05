package piilopokeri.gui.ikkunat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.KasienVertailija;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.LopetusKuuntelija;
import piilopokeri.gui.kuuntelijat.UudelleenAloitusKuuntelija;

public class LopetusIkkuna extends Ikkuna{
    private Piilopokeri pokeri;
    private JFrame peliFrame;

    public LopetusIkkuna(Piilopokeri pokeri, JFrame peliFrame) {
        this.pokeri = pokeri;
        this.peliFrame = peliFrame;
        
        frame.setTitle("Tulokset");
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(300, 200));
        
        frame.setLocation(100, 0);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setVisible(true);
        
        frame.pack();
    }

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 1));
        
        JLabel loppuTeksti = new JLabel("Peli päättyi");
        
        loppuTeksti.setForeground(Color.blue);
        
        p.add(loppuTeksti);
        
        for(JLabel teksti : kasienArvot()) {
            p.add(teksti);
            
        }
        for(JLabel teksti : voittajat()) {
            teksti.setForeground(Color.red);
            
            p.add(teksti);
            
        }
        okNappi.addActionListener(new UudelleenAloitusKuuntelija(pokeri, frame, peliFrame));
        
        
        p.add(okNappi);
        
        return p;
    }
    
    public JPanel lisaaNapit() {
        JPanel p = new JPanel();
        
        JButton uusiPeli = new JButton("Uusi peli");
        JButton lopeta = new JButton("Lopeta");
        
        uusiPeli.addActionListener(new UudelleenAloitusKuuntelija(pokeri, frame, peliFrame));
        lopeta.addActionListener(new LopetusKuuntelija());
        
        p.add(lopeta);
        p.add(uusiPeli);
        
        return p;
    }
    
    public ArrayList<JLabel> voittajat() {
        ArrayList<JLabel> voittajat = new ArrayList();
        ArrayList<Pelaaja> pelaajat = pokeri.getPelaajat();
        
        Kasi voittajaKasi = KasienVertailija.parasKasi(pokeri.getKadet());
        Pelaaja voittajaPelaaja = new Pelaaja();
        Pelaaja voittaja2Pelaaja = new Pelaaja();
        
        boolean tasapeli = false;
        
        for(int i = 0; i < pelaajat.size(); i++) {
            Pelaaja pelaaja = pelaajat.get(i);
            if(voittajaKasi.equals(pelaaja.getKasi())) {
                voittajaPelaaja = pelaaja;
                
                for(int j = i + 1; j < pelaajat.size(); j++) {
                    Pelaaja verrattavaPelaaja = pelaajat.get(j);
                    if(KasienVertailija.parempiKasi(voittajaKasi, verrattavaPelaaja.getKasi()) == 0) {
                        voittaja2Pelaaja = verrattavaPelaaja;
                        tasapeli = true;
                    }
                }
            }
        }
        
        if(tasapeli) {
            JLabel tasapeliTeksti = new JLabel("Tasapeli!");
            JLabel tasapeliVoittajat = new JLabel("Pelaajilla " + voittajaPelaaja.getNimi() + 
                    " ja " + voittaja2Pelaaja.getNimi() + " on yhtä hyvät kädet!");
            
            voittajat.add(tasapeliTeksti);
            voittajat.add(tasapeliVoittajat);
            
        }else{
            JLabel voittaja = new JLabel(voittajaPelaaja.getNimi() + " voitti!");
            
            voittajat.add(voittaja);
        }
        
        return voittajat;
    }
    
    public JLabel tulostaKadenArvo(Pelaaja pelaaja) {
        Kasi kasi = pelaaja.getKasi();
        String pelaajalla = "Pelaajalla " + pelaaja.getNimi() + " on ";
        JLabel pelaajaTeksti = new JLabel();
        
        int kadenArvo = kasi.kadenArvo();
        
        if(kadenArvo == 9) {
            pelaajaTeksti.setText(pelaajalla + "vitoset!");
                
        }
        else if(kadenArvo == 8) {
            pelaajaTeksti.setText(pelaajalla + "värisuora!");

        }
        else if(kadenArvo == 7) {
            pelaajaTeksti.setText(pelaajalla + "neloset!");

        }
        else if(kadenArvo == 6) {
            pelaajaTeksti.setText(pelaajalla + "täyskäsi!");

        }
        else if(kadenArvo == 5) {
            pelaajaTeksti.setText(pelaajalla + "väri!");

        }
        else if(kadenArvo == 4) {
            pelaajaTeksti.setText(pelaajalla + "suora!");

        }
        else if(kadenArvo == 3) {
            pelaajaTeksti.setText(pelaajalla + "kolmoset!");

        }
        else if(kadenArvo == 2) {
            pelaajaTeksti.setText(pelaajalla + "kaksi paria!");

        }
        else if(kadenArvo == 1) {
            pelaajaTeksti.setText(pelaajalla + "pari!");

        }else{
            pelaajaTeksti.setText("Pelaajalla " + pelaaja.getNimi() + " ei ole mitään!");
        }
        return pelaajaTeksti;
    }
    
    public ArrayList<JLabel> kasienArvot() {
        ArrayList<JLabel> arvoTekstit = new ArrayList();
        
        for(int i = 0; i < pokeri.getPelaajat().size(); i++) {
            arvoTekstit.add(tulostaKadenArvo(pokeri.getPelaajat().get(i)));
            
        }
        return arvoTekstit;
    }
    
}
