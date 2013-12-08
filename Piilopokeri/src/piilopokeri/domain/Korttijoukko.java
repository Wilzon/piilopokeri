package piilopokeri.domain;

import piilopokeri.jarjestajat.KorttienJarjestaja;
import java.util.ArrayList;
import java.util.Collections;

/** @author Wilzon */

public class Korttijoukko {
    /**
     * Lista korteista
     */
    private final ArrayList<Kortti> kortit;

    public Korttijoukko() {
        kortit = new ArrayList();
    }
    
    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
    
    /**
     * Metodi sekoittaa kortit joukossa
     */
    public void sekoitaKortit() {
        if(kortit.size() > 1) {
            Collections.shuffle(kortit);
        }
    }

    public void kaannaKaikkiKortit() {
        for(Kortti kortti : kortit) {
            kortti.kaannaKortti();
        }
    }
    
    /**
     * Metodi poistaa kortin korttijoukosta
     * 
     * @param korttiMerkkijonona Poistettavan kortin merkkijono
     * 
     * @return true/false
     */
    public boolean poistaKortti(String korttiMerkkijonona) {
        korttiMerkkijonona = korttiMerkkijonona.trim();
        
        for(int i = 0; i < kortit.size(); i++) {
            Kortti kortti = kortit.get(i);
            
            if(kortti.toString().equalsIgnoreCase(korttiMerkkijonona)) {
                kortit.remove(kortti);
                
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi poistaa jokerit korttijoukosta
     */
    public void poistaJokerit() {
        Kortti jokeri = new Kortti(15, Kortti.JOKERI);
        
        if(kortit.size() > 1) {
            kortit.remove(jokeri);
            kortit.remove(jokeri);
            
        }
    }
    
    /**
     * Metodi järjestää kortit joukossa
     */
    public void jarjestaKortit() {
        if(kortit.size() > 1) {
            Collections.sort(kortit, new KorttienJarjestaja());
        }
    }
    
    /**
     * Metodi palauttaa listan korttijoukon arvoista
     * 
     * @return Lista arvoista
     */
    public ArrayList<Integer> getArvot() {
        ArrayList<Integer> arvot = new ArrayList();
        
        for(Kortti kortti : kortit) {
            arvot.add(kortti.getArvo());
        }
        return arvot;
    }
    
    /**
     * Metodi palauttaa listan korttijoukon maista
     * 
     * @return Lista maista
     */
    public ArrayList<Integer> getMaat() {
        ArrayList<Integer> maat = new ArrayList();
        
        for(Kortti kortti : kortit) {
            maat.add(kortti.getMaa());
        
        }
        return maat;
    } 
    
    public ArrayList<String> getMaatMerkkijonona() {
        ArrayList<String> maat = new ArrayList();
        
        for(Kortti kortti : kortit) {
            maat.add(kortti.getMaaMerkkijonona());
        
        }
        return maat;
    } 
    
    @Override
    public String toString() {
        String merkkijono = "";
        
        for(int i = 0; i < kortit.size(); i++) {
            merkkijono += kortit.get(i);
            if(i < kortit.size() - 1) {
                merkkijono += ", ";
            }
        }
        
        return merkkijono;
    }
    
}
