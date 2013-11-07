package piilopokeri.domain;

import java.util.ArrayList;
import java.util.Collections;
import piilopokeri.domain.Kortti;


public class Korttijoukko {
    private final ArrayList<Kortti> kortit;

    public Korttijoukko() {
        kortit = new ArrayList();
    }
    
    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
    
    public void sekoitaKortit() {
        if(kortit.size() > 1) {
            Collections.shuffle(kortit);
        }
    }
    
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
    
    public void jarjestaKortit() {
        if(kortit.size() > 1) {
            Collections.sort(kortit);
        }
    }
    
    public ArrayList<Integer> getArvot() {
        ArrayList<Integer> arvot = new ArrayList();
        
        for(Kortti kortti : kortit) {
            arvot.add(kortti.getArvo());
        }
        return arvot;
    }
    
    public ArrayList<String> getMaat() {
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
