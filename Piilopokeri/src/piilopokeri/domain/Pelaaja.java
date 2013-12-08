
package piilopokeri.domain;

import java.util.ArrayList;
import javax.swing.JButton;

public class Pelaaja {
    private String nimi;
    private boolean ensimmainenVuoro;
    private int jarjestys;
    private Kasi kasi;
    private ArrayList<JButton> korttiNapit;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        ensimmainenVuoro = true;
        jarjestys = 1;
        korttiNapit = new ArrayList();
    }
    
    public Pelaaja() {
        this("Nimetön");
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void lisaaKasi(Kasi kasi) {
        this.kasi = kasi;
    }
    
    public Kasi getKasi() {
        return kasi;
    }

    public void setHaluttuJarjestys(int jarjestys) {
        this.jarjestys = jarjestys;
    }
    
    public int getHaluttuJarjestys() {
        return jarjestys;
    }
    
    public void jarjestaOmatKortit() {
        if(getHaluttuJarjestys() == 1) {
            kasi.jarjestaKortit();
            
        }
        else if(getHaluttuJarjestys() == 2) {
            kasi.kaannaJarjestys();
            
        }else{
            kasi.sekoitaKortit();
        }
    }
    
    public void setVuoro() {
        ensimmainenVuoro = false;
    }
    
    public boolean onkoEnsimmainenVuoro() {
        return ensimmainenVuoro;
    }
    
    public void setKorttiNappi(JButton nappi) {
        korttiNapit.add(nappi);
    }
    
    public ArrayList<JButton> getKorttiNapit() {
        return korttiNapit;
    }
    
    public void setKaikkiUudetKorttiNapit(ArrayList<JButton> napit) {
        korttiNapit = napit;
    }
    
    public boolean onkoKone() {
        return false;
    }
}
