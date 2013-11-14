package piilopokeri;

import java.util.ArrayList;
import java.util.HashMap;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttipakka;

/** @author Wilzon */

public class Main {
    
    public static void main(String[] args) {
        
//        ArrayList<Kasi> kadet = new ArrayList();
//        Piilopokeri pokeri = new Piilopokeri();
//        
//        pokeri.sekoitaPakka();
//        
//        Kasi kasi = pokeri.getUudetKortit(5);
//        Kasi kasi2 = pokeri.getUudetKortit(5);
//        
//        Korttipakka pakka = new Korttipakka();
//        
//        pakka.sekoitaKortit();
//        
//        kadet.add(kasi);
//        kadet.add(kasi2);
//        
//        
//        System.out.println(pokeri.getPakka());
//        
//        pokeri.kaannaKortti(kasi.getKortit().get(0));
//        pokeri.kaannaKortti(kasi.getKortit().get(3));
//        
//        pokeri.tulostaPelikentta(kadet);
//        
//        System.out.println("-----");
//        
//        System.out.println(kasi.toString());
//        
//        System.out.println(pakka.toString());
        
//          Kasi kasi3 = new Kasi();
//          
//          kasi3.lisaaKortti(new Kortti(5, Kortti.HERTTA));
//          kasi3.lisaaKortti(new Kortti(10, Kortti.PATA));
//        
        
//          System.out.println(kasi3.toString());
//
//          kasi3.poistaKortti(kasi3.getKortit().get(1).toString());
//          
//          System.out.println(kasi3.toString());
        
        Kortti kortti = new Kortti(2, Kortti.HERTTA);
        Kortti kortti2 = new Kortti(4, Kortti.HERTTA);
        Kortti kortti3 = new Kortti(5, Kortti.PATA);
        Kortti kortti4 = new Kortti(6, Kortti.RUUTU);
        Kortti kortti5 = new Kortti(15, Kortti.RUUTU);
        
        Kortti kortti6 = new Kortti(7, Kortti.HERTTA);
        Kortti kortti7 = new Kortti(4, Kortti.RUUTU);
        Kortti kortti8 = new Kortti(5, Kortti.PATA);
        Kortti kortti9 = new Kortti(6, Kortti.PATA);
        Kortti kortti10 = new Kortti(2, Kortti.PATA);

        Kasi kasi = new Kasi();
        Kasi kasi2 = new Kasi();
        Piilopokeri pokeri = new Piilopokeri();

        kasi.lisaaKortti(kortti);
        kasi.lisaaKortti(kortti2);
        kasi.lisaaKortti(kortti3);
        kasi.lisaaKortti(kortti4);
        kasi.lisaaKortti(kortti5);
        
        kasi2.lisaaKortti(kortti6);
        kasi2.lisaaKortti(kortti7);
        kasi2.lisaaKortti(kortti8);
        kasi2.lisaaKortti(kortti9);
        kasi2.lisaaKortti(kortti10);
        
        Kasi kasi3 = pokeri.getUudetKortit(5);
        Kasi kasi4 = pokeri.getUudetKortit(5);


//        System.out.println(pokeri.onkoVari(kasi));

        
//         for(Kortti korttiX : kasi.getKortit()) {
//              korttiX.kaannaKortti();
//          }        
        
        
//        System.out.println(pokeri.kuinkaMontaSamaaMap(kasi));
//        
//        System.out.println("Expected: {2=1, 3=2 4=1, 6=1}");
//        
//        System.out.println(pokeri.kuinkaMontaSamaa(kasi));
//        
//        System.out.println(pokeri.montaSamaaKortinArvo(kasi));
        
//        System.out.println(pokeri.onkoSuora(kasi));
//        
//        System.out.println("oikein: " + kasi);
//        System.out.println("toisin: " + pokeri.muutaAssaYkkoseksi(kasi));
        
        int kadenArvo = pokeri.kadenArvo(kasi);
        int kaden2Arvo = pokeri.kadenArvo(kasi2);
         
        if(kadenArvo > kaden2Arvo) {
            System.out.println("Hand one won!");
        }
        else if(kadenArvo < kaden2Arvo) {
            System.out.println("Hand two won!");
        }else{
            
            if(pokeri.kadenArvo(kasi) == 9) {
                int arvo = pokeri.parempiMontaSamaa(kasi, kasi2, 5);
                printtaaTulos(arvo);
                System.out.println("Vitoset!");
            }
            else if(pokeri.kadenArvo(kasi) == 8) {
                int arvo = pokeri.parempiSuoraTaiVari(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Värisuora!");
            }
            else if(pokeri.kadenArvo(kasi) == 7) {
                int arvo = pokeri.parempiMontaSamaa(kasi, kasi2, 4);
                printtaaTulos(arvo);
                System.out.println("Neloset!");
            }
            else if(pokeri.kadenArvo(kasi) == 6) {
                int arvo = pokeri.parempiTayskasi(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Täyskäsi!");
            }
            else if(pokeri.kadenArvo(kasi) == 5) {
                int arvo = pokeri.parempiSuoraTaiVari(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Väri!");
            }
            else if(pokeri.kadenArvo(kasi) == 4) {
                int arvo = pokeri.parempiSuoraTaiVari(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Suora!");
            }
            else if(pokeri.kadenArvo(kasi) == 3) {
                int arvo = pokeri.parempiMontaSamaa(kasi, kasi2, 3);
                printtaaTulos(arvo);
                System.out.println("Kolmoset!");
            }
            else if(pokeri.kadenArvo(kasi) == 2) {
                int arvo = pokeri.parempiKaksiParia(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Kaksi paria!");
            }
            else if(pokeri.kadenArvo(kasi) == 1) {
                int arvo = pokeri.parempiMontaSamaa(kasi, kasi2, 2);
                printtaaTulos(arvo);
                System.out.println("Pari!");
            }else{
                int arvo = pokeri.parempiSuuriKortti(kasi, kasi2);
                printtaaTulos(arvo);
                System.out.println("Ei mitään!");
            }
        }
        ArrayList<Kasi> kadet = new ArrayList();
        kadet.add(kasi3);
        kadet.add(kasi4);

        
        pokeri.tulostaPelikentta(kadet);
        
        System.out.println("Avopakka: " + pokeri.getAvopakanPaallimmainen());
        
        pokeri.vaihdaAvoPakanKanssa(kasi3, 0);

        Kortti eka = pokeri.getKorttiPakasta();
        System.out.println("Pakasta: " + eka);
        pokeri.vaihdaPakanKanssa(kasi3, eka, 1);
        
        kasi3.jarjestaKortit();
        
        pokeri.tulostaPelikentta(kadet);
        
        
        for(Kortti korttiZ : kasi3.getKortit()) {
            korttiZ.kaannaKortti();
        }
        
        pokeri.tulostaPelikentta(kadet);
        
        kasi3.jarjestaKortit();
        
        pokeri.tulostaPelikentta(kadet);
//        System.out.println("------");
//        
//        System.out.println(pokeri.onkoSuora(kasi));
//        
//        System.out.println("XXXXXXX");
//        
//        System.out.println();
//        System.out.println();
//        
////        System.out.println(pokeri.parempiSuoraTaiVari(kasi, kasi2));
//        
////        System.out.println(pokeri.parempiSuuriKortti(kasi, kasi2));
//        
////        System.out.println(pokeri.parempiKaksiParia(kasi, kasi2));
//        
//        System.out.println(pokeri.parempiMontaSamaa(kasi, kasi2, 3));
        
        
    
    }
    public static void printtaaTulos(int arvo) {
        if(arvo == 1) {
                System.out.println("Hand one won!");
            }
            else if(arvo == -1) {
                System.out.println("Hand two won!");
            }else{
                System.out.println("TIE!");
            }
    }
}