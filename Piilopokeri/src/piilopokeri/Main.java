package piilopokeri;

import java.util.ArrayList;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttipakka;


public class Main {
    
    public static void main(String[] args) {
        
        ArrayList<Kasi> kadet = new ArrayList();
        Piilopokeri pokeri = new Piilopokeri();
        
        pokeri.sekoitaPakka();
        
        Kasi kasi = pokeri.getUudetKortit(5);
        Kasi kasi2 = pokeri.getUudetKortit(5);
        
        Korttipakka pakka = new Korttipakka();
        
        pakka.sekoitaKortit();
        
        kadet.add(kasi);
        kadet.add(kasi2);
        
        pokeri.tulostaPelikentta(kadet);
//        
//        System.out.println(pokeri.getPakka());
//        
        pokeri.kaannaKortti(kasi.getKortit().get(0));
        pokeri.kaannaKortti(kasi.getKortit().get(3));
//        
        pokeri.tulostaPelikentta(kadet);
//        
//        System.out.println("-----");
//        
//        System.out.println(kasi.toString());
//        
//        System.out.println(pakka.toString());
        
          Kasi kasi3 = new Kasi();
          
          kasi3.lisaaKortti(new Kortti(5, Kortti.HERTTA));
          kasi3.lisaaKortti(new Kortti(10, Kortti.PATA));
        
          for(Kortti kortti : kasi3.getKortit()) {
              kortti.kaannaKortti();
          }
        
//          System.out.println(kasi3.toString());
//
//          kasi3.poistaKortti(kasi3.getKortit().get(1).toString());
//          
//          System.out.println(kasi3.toString());
        
        
        
    }   
}