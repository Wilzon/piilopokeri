package piilopokeri.domain;

import java.util.ArrayList;
import java.util.Collections;

/** @author Wilzon */

public class Kasi extends Korttijoukko{
    /**
     * Lista kädessä olevista korteista
     */
    private final ArrayList<Kortti> kortit;
    
    public Kasi() {
        kortit = super.getKortit();
    }
    
    /**
     * Metodi lisää kortin käteen
     * 
     * @param kortti Lisättävä kortti
     */
    public void lisaaKortti(Kortti kortti) {
        if(kortti.getArvo() > 1) {
            kortit.add(kortti);
        }    
    }
        
    /**
     * Metodi kääntää kädessä olevien korttien järjestyksen
     */
    public void kaannaJarjestys() {
        jarjestaKortit();
        Collections.reverse(kortit);
    }

    @Override
    public String toString() {
        String merkkijono = "";
        
        for(int i = 0; i < kortit.size(); i++) {
            Kortti kortti = kortit.get(i);
            
            if(kortti.onkoKaannetty()) {
               merkkijono += kortti; 
            }else{
                merkkijono += "[X]";
            }
            if(i < kortit.size() - 1) {
                merkkijono += ", ";
            }
        }
        return merkkijono;
    }
}
