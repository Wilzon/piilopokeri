
package piilopokeri.domain;

public class Pelaaja {
    private String nimi;
    private boolean ensimmainenVuoro;
    private int jarjestys;
    private Kasi kasi;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        ensimmainenVuoro = true;
    }
    
    public Pelaaja() {
        this("Pelaaja");
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
    
    public void jarjestaOmatKortit() {
        if(haluttuJarjestys() == 1) {
            kasi.jarjestaKortit();
            
        }
        else if(haluttuJarjestys() == 2) {
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
    
    public boolean onkoKone() {
        return false;
    }
}
