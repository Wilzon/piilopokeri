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
import piilopokeri.domain.KadenArvostelija;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.KasienVertailija;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.kuuntelijat.LopetusKuuntelija;
import piilopokeri.gui.kuuntelijat.UudelleenAloitusKuuntelija;

public class LopetusIkkuna extends Ikkuna{
    private final Piilopokeri pokeri;
    private final JFrame peliFrame;

    public LopetusIkkuna(Piilopokeri pokeri, JFrame peliFrame) {
        this.pokeri = pokeri;
        this.peliFrame = peliFrame;
        
        frame.setTitle("Tulokset");
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setLocation(50, 200);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(lisaaPaneli());
        
        frame.setVisible(true);
        
        frame.pack();
    }

    @Override
    public JPanel lisaaPaneli() {
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(0, 1));
        
        JLabel loppuTeksti = new JLabel("Peli päättyi!");
        
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
        ArrayList<Pelaaja> voittajatLista = new ArrayList();
        
        for(Pelaaja pelaaja : pelaajat) {
            if(KasienVertailija.parempiKasi(voittajaKasi, pelaaja.getKasi()) == 0) {
                voittajatLista.add(pelaaja);
                
            }
        }
        
        if(voittajatLista.size() > 1) {
            JLabel tasapeliTeksti = new JLabel("Tasapeli!");
            JLabel tasapeliVoittajat = new JLabel();
            
            setVoittajaLabelTeksti(tasapeliVoittajat, voittajatLista);
            
            voittajat.add(tasapeliTeksti);
            voittajat.add(tasapeliVoittajat);
            
        }else{
            JLabel voittaja = new JLabel(voittajatLista.get(0).getNimi() + " voitti!");
            
            voittajat.add(voittaja);
        }
        
        return voittajat;
    }
    
    public void setVoittajaLabelTeksti(JLabel voittajat, ArrayList<Pelaaja> voittajatLista) {
        String voittajatString = "Pelaajilla ";
        
        for(int i = 0; i < voittajatLista.size(); i++) {
            voittajatString += voittajatLista.get(i).getNimi();
            
            if(i < voittajatLista.size() - 2) {
                voittajatString += ", ";
                
            }
            else{
                if(i == voittajatLista.size() - 2) {
                    voittajatString += " ja ";
                    
                }
            }
        }
        voittajatString += " on yhtä hyvät kädet!";
        
        voittajat.setText(voittajatString);
    }
    
    public JLabel tulostaKadenArvo(Pelaaja pelaaja) {
        Kasi kasi = pelaaja.getKasi();
        String pelaajalla = "Pelaajalla " + pelaaja.getNimi() + " on ";
        JLabel pelaajaTeksti = new JLabel();
        
        int kadenArvo = KadenArvostelija.kadenArvo(kasi);
        
        if(kadenArvo == 70) {
            kadenArvo = 12;
            
        }
        if(kadenArvo == 69) {
            kadenArvo = 6;
            
        } 
        if(kadenArvo ==  68) {
            kadenArvo = 5;
            
        }
        
        
        if(kadenArvo == 67) {
            pelaajaTeksti.setText(pelaajalla + "kutoset, neloset ja kolmoset!");
        
        }
        else if(kadenArvo == 66) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja kahdet kolmoset!");
            
        }
        else if(kadenArvo == 65) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja kahdet neloset!");
            
        }
        else if(kadenArvo == 64) {
            pelaajaTeksti.setText(pelaajalla + "kutoset, neloset ja pari!");
            
        } 
        else if(kadenArvo == 63) {
            pelaajaTeksti.setText(pelaajalla + "kutoset, kolmoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 62) {
            pelaajaTeksti.setText(pelaajalla + "kutoset, kolmoset ja pari!");
                
        } 
        else if(kadenArvo == 61) {
            pelaajaTeksti.setText(pelaajalla + "vitoset, neloset ja kolmoset!");
            
        }
        else if(kadenArvo == 60) {
            pelaajaTeksti.setText(pelaajalla + "vitoset, neloset ja kaksi paria!");
            
        }
        else if(kadenArvo == 59) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja neloset!");
            
        } 
        else if(kadenArvo == 58) {
            pelaajaTeksti.setText(pelaajalla + "kolmet neloset!");
            
        }
        else if(kadenArvo == 57) {
            pelaajaTeksti.setText(pelaajalla + "vitoset, kahdet kolmoset ja pari!");
            
        }
        else if(kadenArvo == 56) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja neloset ja pari");
            
        } 
        else if(kadenArvo == 55) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja kahdet kolmoset!");
            
        } 
        else if(kadenArvo == 54) {
            pelaajaTeksti.setText(pelaajalla + "kahdet neloset, kolmoset ja pari!");
            
        }
        else if(kadenArvo == 53) {
            pelaajaTeksti.setText(pelaajalla + "vitoset, kolmoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 52) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja neloset!");
            
        }
        else if(kadenArvo == 51) {
            pelaajaTeksti.setText(pelaajalla + "vitoset, kolmoset ja pari");
            
        } 
        else if(kadenArvo == 50) {
            pelaajaTeksti.setText(pelaajalla + "kahdet neloset ja kolmoset");
            
        } 
        else if(kadenArvo == 49) {
            pelaajaTeksti.setText(pelaajalla + "kahdet neloset ja kaksi paria");
            
        } 
        else if(kadenArvo == 48) {
            pelaajaTeksti.setText(pelaajalla + "kahdet neloset ja pari!");
            
        } 
        else if(kadenArvo == 47) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja kolmoset!");
            
        }
        else if(kadenArvo == 46) {
            pelaajaTeksti.setText(pelaajalla + "kahdet neloset!");
            
        }
        else if(kadenArvo == 45) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja kolmet kolmoset!");
            
        }
        else if(kadenArvo == 44) {
            pelaajaTeksti.setText(pelaajalla + "neloset, kahdet kolmoset ja pari!");
            
        }
        else if(kadenArvo == 43) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja neljä paria!");
            
        }
        else if(kadenArvo == 42) {
            pelaajaTeksti.setText(pelaajalla + "neljät kolmoset!");
            
        }
        else if(kadenArvo == 41) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja kahdet kolmoset!");
            
        } 
        else if(kadenArvo == 40) {
            pelaajaTeksti.setText(pelaajalla + "kolmet kolmoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 39) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja kolme paria!");
            
        }
        else if(kadenArvo == 38) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja kolmoset!");
            
        }
        else if(kadenArvo == 37) {
            pelaajaTeksti.setText(pelaajalla + "neloset, kolmoset ja kolme paria!");
            
        }
        else if(kadenArvo == 36) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 35) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja kolme paria!");
            
        }
        else if(kadenArvo == 34) {
            pelaajaTeksti.setText(pelaajalla + "neloset, kolmoset ja kaksi paria!");
            
        } 
        else if(kadenArvo == 33) {
            pelaajaTeksti.setText(pelaajalla + "kolmet kolmoset!");
            
        }
        else if(kadenArvo == 32) {
            pelaajaTeksti.setText(pelaajalla + "kutoset ja pari!");
            
        }
        else if(kadenArvo == 31) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 30) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja neljä paria!");
            
        }
        else if(kadenArvo == 29) {
            pelaajaTeksti.setText(pelaajalla + "kutoset!");
            
        }
        else if(kadenArvo == 28) {
            pelaajaTeksti.setText(pelaajalla + "kahdet kolmoset ja kolme paria!");
            
        }
        else if(kadenArvo == 27) {
            pelaajaTeksti.setText(pelaajalla + "vitoset ja pari!");
            
        }
        else if(kadenArvo == 26) {
            pelaajaTeksti.setText(pelaajalla + "neloset, kolmoset ja pari!");
            
        } 
        else if(kadenArvo == 25) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja kolme paria!");
            
        }
        else if(kadenArvo == 24) {
            pelaajaTeksti.setText(pelaajalla + "kolmoset ja viisi paria!");
            
        }
        else if(kadenArvo == 23) {
            pelaajaTeksti.setText(pelaajalla + "kolmoset ja neljä paria!");
            
        }
        else if(kadenArvo == 22) {
            pelaajaTeksti.setText(pelaajalla + "kuusi paria!");
            
        }
        else if(kadenArvo == 21) {
            pelaajaTeksti.setText(pelaajalla + "kahdet kolmoset ja kaksi paria!");
            
        } 
        else if(kadenArvo == 20) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja kolmoset!");
            
        }
        else if(kadenArvo == 19) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja kaksi paria!");
            
        }
        else if(kadenArvo == 18) {
            pelaajaTeksti.setText(pelaajalla + "kolmoset ja kolme paria!");
            
        }
        else if(kadenArvo == 17) {
            pelaajaTeksti.setText(pelaajalla + "vitoset!");
            
        }
        else if(kadenArvo == 16) {
            pelaajaTeksti.setText(pelaajalla + "kahdet kolmoset ja pari!");
        }
        else if(kadenArvo == 15) {
            pelaajaTeksti.setText(pelaajalla + "viisi paria!");
            
        }
        else if(kadenArvo == 14) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja pari!");
            
        }
        else if(kadenArvo == 13) {
            pelaajaTeksti.setText(pelaajalla + "kahdet kolmoset!");
            
        }
        else if(kadenArvo == 12) {
            pelaajaTeksti.setText(pelaajalla + "varisuora!");
            
        }
        else if(kadenArvo == 11) {
            pelaajaTeksti.setText(pelaajalla + "kolmoset ja kaksi paria!");
            
        }
        else if(kadenArvo == 10) {
            pelaajaTeksti.setText(pelaajalla + "neljä paria!");
            
        }
        else if(kadenArvo == 9) {
            pelaajaTeksti.setText(pelaajalla + "neloset ja pari!");
                
        }
        else if(kadenArvo == 8) {
            pelaajaTeksti.setText(pelaajalla + "neloset!");

        }
        else if(kadenArvo == 7) {
            pelaajaTeksti.setText(pelaajalla + "täyskäsi!");

        }
        else if(kadenArvo == 6) {
            pelaajaTeksti.setText(pelaajalla + "väri!");

        }
        else if(kadenArvo == 5) {
            pelaajaTeksti.setText(pelaajalla + "suora!");

        }
        else if(kadenArvo == 4) {
            pelaajaTeksti.setText(pelaajalla + "kolme paria!");

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
            pelaajaTeksti.setText("Pelaajan " + pelaaja.getNimi() + " suurin kortti on " + pelaaja.getKasi().getSuurinKortti() + "!");
        
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
