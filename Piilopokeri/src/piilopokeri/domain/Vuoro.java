
package piilopokeri.domain;

import java.util.ArrayList;

public class Vuoro {
    private int vuoro;
    private final Piilopokeri pokeri;
    private String pelaajanNimi;
    private Pelaaja pelaaja;

    public Vuoro(Piilopokeri pokeri, int vuoro) {
        this.vuoro = vuoro;
        this.pokeri = pokeri;
        
        setPelaaja();
        setPelaajanNimi();
    }

    public int getVuoro() {
        return vuoro;
    }
    
    public void seuraava() {
        vuoro++;
        
        if(vuoro == pokeri.getPelaajat().size()) {
            vuoro = 0;
            
        }
        setPelaaja();
        setPelaajanNimi();
    }
    
    private void setPelaaja() {
        pelaaja = pokeri.getPelaajat().get(vuoro);
    }
    
    private void setPelaajanNimi() {
        pelaajanNimi = pelaaja.getNimi();
    }

    public String getPelaajanNimi() {
        return pelaajanNimi;
    }


    public Pelaaja getPelaaja() {
        return pelaaja;
    }
    
    public Kasi getKasi() {
        return pelaaja.getKasi();
    }
    
    public ArrayList<Kortti> getKortit() {
        return getKasi().getKortit();
    }

}
