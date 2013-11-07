package piilopokeri.domain;

import java.util.ArrayList;


public class Korttipakka extends Korttijoukko{
    private final ArrayList<Kortti> kortit;
    
    public Korttipakka() {
        kortit = super.getKortit();
        
        for(int i = 2; i < 15; i++) {
            kortit.add(new Kortti(i, Kortti.PATA));
            kortit.add(new Kortti(i, Kortti.RISTI));
            kortit.add(new Kortti(i, Kortti.RUUTU));
            kortit.add(new Kortti(i, Kortti.HERTTA));
        }
        kortit.add(new Kortti(15, Kortti.JOKERI));
        kortit.add(new Kortti(15, Kortti.JOKERI));
    }
    
    public Kortti getPaallimmainen() {
        return kortit.remove(0);
    }
    
    public void poistaJokerit() {
        if(kortit.size() == 54) {
            kortit.remove(53);
            kortit.remove(52);
        }
    }
    

}
