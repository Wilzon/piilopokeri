package piilopokeri;

import java.util.ArrayList;
import java.util.Collections;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttijoukko;
import piilopokeri.domain.Korttipakka;


public class Piilopokeri {
    private final Korttipakka pakka = new Korttipakka(); 
    
   
    public Kasi getUudetKortit(int maara) {
        Kasi kasi = new Kasi();
        
        if(maara <= pakka.getKortit().size()) {
            for(int i = 0; i < maara; i++) {
                kasi.lisaaKortti(pakka.getPaallimmainen());
            }
            kasi.jarjestaKortit();
        }
        return kasi;
    }
    
    public ArrayList<Kortti> getPakka() {
        return pakka.getKortit();
    }
    
    public void poistaJokeritPakasta() {
        pakka.poistaJokerit();
    }
    
    public void sekoitaPakka() {
        pakka.sekoitaKortit();
    }
    
    public void jarjestaPakka() {
        pakka.jarjestaKortit();
    }
    
    public void tulostaPelikentta(ArrayList<Kasi> kadet) {
        int mones = 0;
        String reunat = "************************************************************";
        System.out.println(reunat);
        for(int i = 0; i < 11; i++) {
            String rivi = "";
            if(i == 2 || i == 8 ) {
                int pituus = kadet.get(mones).toString().length();
                int tyhja = (reunat.length() - pituus) / 2;
                
                
                rivi = lisaaTyhjaaAlkuun(tyhja, rivi);
                rivi += kadet.get(mones).toString();
                rivi = lisaaTyhjaaLoppuun(pituus, tyhja, rivi);
                    
                mones++;
            }
            else if(i == 5) {
                Kortti paallimmainen = pakka.getPaallimmainen();
                int pituus = paallimmainen.toString().length() + 5;
                int tyhja = (reunat.length() - pituus) / 2;
                
                rivi = lisaaTyhjaaAlkuun(tyhja, rivi);
                rivi += paallimmainen + "  [X]";
                
                rivi = lisaaTyhjaaLoppuun(pituus, tyhja, rivi);
            }else{
                rivi += "*                                                          *";    
            }
            System.out.println(rivi);
        }
        System.out.println(reunat);
        
        // tarvitsee paljon muokkaamista
    }
    
    public String lisaaTyhjaaLoppuun(int pituus, int tyhja, String rivi) {
        for(int j = 0; j < tyhja - 2; j++) {
            rivi += " ";
        }
        if(pituus % 2 != 0) {
            rivi += " ";
        }
        rivi += "*";
        
        return rivi;
    }
    public String lisaaTyhjaaAlkuun(int tyhja, String rivi) {
        rivi += ("*");
        
        for(int k = 0; k < tyhja; k++) {
            rivi += " ";
        }
        return rivi;
    }
    
    public String kortitMerkkijonona(Korttijoukko korttijoukko) {
        return korttijoukko.toString();
    }
    
    public void kaannaKortti(Kortti kortti) {
        kortti.kaannaKortti();
    }
    
    public int kadenArvo(Kasi kasi) {
        int pituus = kasi.getKortit().size();
        ArrayList<Integer> montaSamaaLista = new ArrayList();
        
        for(int i = 0; i < pituus - 1; i++) {
            int montaSamaa = 0;
            
            for(int j = 1; j < pituus; j++) {
                if(kasi.getArvot().get(i) == 
                        kasi.getArvot().get(j)) {
                    montaSamaa += 1;
                }
            }
            montaSamaaLista.add(montaSamaa);
        }
        
        return Collections.max(montaSamaaLista);
        
    }
}
