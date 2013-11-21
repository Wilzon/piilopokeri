
package piilopokeri.domain;

public class Pelaaja {
    String nimi;
    boolean ensimmainenVuoro;
    int jarjestys;
    Kasi kasi;
    
    public Pelaaja(String nimi) {
        this();
        this.nimi = nimi;
    }
    
    public Pelaaja() {
        this.nimi = "Pelaaja";
        ensimmainenVuoro = true;
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
    
    public int haluttuJarjestys() {
        return jarjestys;
    }
    
    public void setVuoro() {
        ensimmainenVuoro = false;
    }
    
    public boolean onkoEnsimmainenVuoro() {
        return ensimmainenVuoro;
    }
    
    public boolean onkoKone() {
        return false;
    }
}
