package piilopokeri;

import java.util.ArrayList;
import java.util.Random;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Pelaaja;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.ui.Kayttoliittyma;

/** @author Wilzon */

public class Main {
    
    public static void main(String[] args) {
        
//        
//        Kortti kortti = new Kortti(2, Kortti.HERTTA, true);
//        Kortti kortti2 = new Kortti(2, Kortti.HERTTA, true);
//        Kortti kortti3 = new Kortti(4, Kortti.JOKERI, true);
//        Kortti kortti4 = new Kortti(5, Kortti.RUUTU, true);
//        Kortti kortti5 = new Kortti(7, Kortti.RUUTU, true);
////        
//        Kortti kortti6 = new Kortti(3, Kortti.HERTTA, true);
//        Kortti kortti7 = new Kortti(4, Kortti.RUUTU, true);
//        Kortti kortti8 = new Kortti(4, Kortti.PATA, true);
//        Kortti kortti9 = new Kortti(8, Kortti.PATA, true);
//        Kortti kortti10 = new Kortti(1, Kortti.PATA, true);
//        
//        System.out.println(kortti8.getArvo());
////
//        Kasi kasi = new Kasi();
//        Kasi kasi2 = new Kasi();
//        Kasi kasiX = new Kasi();
//        
//        Piilopokeri pokeri = new Piilopokeri();
////
//        kasi.lisaaKortti(kortti);
//        kasi.lisaaKortti(kortti2);
//        kasi.lisaaKortti(kortti3);
//        kasi.lisaaKortti(kortti4);
//        kasi.lisaaKortti(kortti5);
////        
//        kasi2.lisaaKortti(kortti6);
//        kasi2.lisaaKortti(kortti7);
//        kasi2.lisaaKortti(kortti8);
//        kasi2.lisaaKortti(kortti9);
//        kasi2.lisaaKortti(kortti10);
//        
//        kasiX.lisaaKortti(kortti6);
//        kasiX.lisaaKortti(kortti7);
//        kasiX.lisaaKortti(kortti8);
//        kasiX.lisaaKortti(kortti9);
//        
//        System.out.println(pokeri.parempiKasi(kasi, kasiX));
//
//        kasi2.getKortit().remove(new Kortti(15, Kortti.JOKERI));
        
//        System.out.println(kasi2);
//        System.out.println("---");
//        kasi.jarjestaKortit();
//        System.out.println(kasi);
//        System.out.println("---");
//        kasi.kaannaJarjestys();
//        System.out.println(kasi);
//        System.out.println("---");
//        
//        
//        System.out.println("kasi: " + kasi.onkoPari() + "\n" +
//                kasi);
//        System.out.println("kasi2: " + kasi2.onkoPari() + "\n" +
//                kasi2);
//        
//        System.out.println("here");
//        System.out.println(pokeri.parempiKasi(kasi, kasi2));
//        Kasi kasi3 = pokeri.getUudetKortit(5);
//        Kasi kasi4 = pokeri.getUudetKortit(5);
//
////        System.out.println(pokeri.onkoVari(kasi));
//
//        
//        
//        
//        System.out.println("***********\n");
//        
//        System.out.println(kasi);
//        
//        System.out.println("\n***********");
//        
//        int kadenArvo = pokeri.kadenArvo(kasi);
//       
//        int kaden2Arvo = pokeri.kadenArvo(kasi2);
//        
//         
//        ArrayList<Kasi> kadet = new ArrayList();
//        kadet.add(kasi3);
//        kadet.add(kasi4);

        
//        pokeri.tulostaPelikentta(kadet);
//        
//        System.out.println("Avopakka: " + pokeri.getAvopakanPaallimmainen());
//        
//        pokeri.vaihdaAvoPakanKanssa(kasi3, 0);
//
//        Kortti eka = pokeri.getKorttiPakasta();
//        System.out.println("Pakasta: " + eka);
//        pokeri.vaihdaPakanKanssa(kasi3, eka, 1);
//        
//        kasi3.jarjestaKortit();
//        
//        pokeri.tulostaPelikentta(kadet);
//        
//        
//        for(Kortti korttiZ : kasi3.getKortit()) {
//            korttiZ.kaannaKortti();
//        }
//        
//        pokeri.tulostaPelikentta(kadet);
//        
//        kasi3.jarjestaKortit();
        
//        pokeri.tulostaPelikentta(kadet);
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
//        Kasi kasi3 = pokeri.getUudetKortit(20);
//        
//        for(int i = 0; i < kasi3.getKortit().size(); i += 3) {
//            kasi3.getKortit().get(i).kaannaKortti();
//        }
//        Kayttoliittyma k = new Kayttoliittyma();
//        
//        k.kaynnista();
//        Pelaaja otto = new Pelaaja("Otto");
//        Pelaaja pekka = new Pelaaja("Pekka");
//        
//        pokeri.lisaaIhmispelaaja(otto);
//        pokeri.lisaaIhmispelaaja(pekka);
//        
//        otto.lisaaKasi(kasi3);
//        pekka.lisaaKasi(kasi2);
//        
//        pokeri.lisaaPelaajanKasi(otto);
//        pokeri.lisaaPelaajanKasi(pekka);
//        
//        kasi3.kaannaJarjestys();
        
//        System.out.println("käännetty:" + kasi3);
//        kasi3.jarjestaKortit();
//        
//        System.out.println("järjestetty:" + kasi3);
//        
//        Random random = new Random();
//        
//        Kasi kasi5 = pokeri.getUudetKortit(5);
//        Kasi kasi6 = pokeri.getUudetKortit(5);
//        Kasi kasi7 = pokeri.getUudetKortit(5);
//        Kasi kasi8 = pokeri.getUudetKortit(5);
//        
//        System.out.println("kasi1: " + kasi5);
//        System.out.println("kasi2: " + kasi6);
//        System.out.println("kasi3: " + kasi7);
//        System.out.println("kasi4: " + kasi8);
//        
//        ArrayList<Kasi> kadetLista = new ArrayList();
//        
//        kadetLista.add(kasi5);
//        kadetLista.add(kasi6);
//        kadetLista.add(kasi7);
//        kadetLista.add(kasi8);
//        
//        System.out.println("kasi1: " + kasi5.kadenArvo());
//        System.out.println("kasi2: " + kasi6.kadenArvo());
//        System.out.println("kasi3: " + kasi7.kadenArvo());
//        System.out.println("kasi4: " + kasi8.kadenArvo());
//        
//        System.out.println(pokeri.parasKasi(kadetLista));
        Piilopokeri pokeri;
    
    Kasi viitosKasi;
    Kasi nelosKasi;
    Kasi kolmosKasi;
    Kasi kaksiPariaKasi;
    Kasi pariKasi;
    Kasi suoraKasi;
    Kasi variKasi;
    Kasi varisuoraKasi;
    Kasi tayskasiKasi;
    Kasi huonoEiMitaanKasi;
    Kasi hyvaEiMitaanKasi;
    
    Kortti pata5;
    Kortti pata6;
    Kortti pata7;
    Kortti pata8;
    Kortti pata9;
    
    Kortti pata3;
    Kortti ruutu8;
    Kortti herttaKuningas;
    
    Kortti ruutu9;
    Kortti risti9;
    Kortti hertta9;
    
    Kortti jokeri;
        
        pokeri = new Piilopokeri();
        
        viitosKasi = new Kasi();
        nelosKasi = new Kasi();
        kolmosKasi = new Kasi();
        kaksiPariaKasi = new Kasi();
        pariKasi = new Kasi();
        suoraKasi = new Kasi();
        variKasi = new Kasi();
        varisuoraKasi = new Kasi();
        tayskasiKasi = new Kasi();
        huonoEiMitaanKasi = new Kasi();
        hyvaEiMitaanKasi = new Kasi();
        
        pata5 = new Kortti(5, Kortti.PATA, true);
        pata6 = new Kortti(6, Kortti.PATA, true);
        pata7 = new Kortti(7, Kortti.PATA, true);
        pata8 = new Kortti(8, Kortti.PATA, true);
        pata9 = new Kortti(9, Kortti.PATA, true);
        
        pata3 = new Kortti(3, Kortti.PATA, true);
        ruutu8 = new Kortti(8, Kortti.RUUTU, true);
        herttaKuningas = new Kortti(13, Kortti.HERTTA, true);
        
        risti9 = new Kortti(9, Kortti.RISTI, true);
        ruutu9 = new Kortti(9, Kortti.RUUTU, true);
        hertta9 = new Kortti(9, Kortti.HERTTA, true);
        
        jokeri = new Kortti(15, Kortti.JOKERI, true);
        
        viitosKasi.lisaaKortti(hertta9);
        viitosKasi.lisaaKortti(risti9);
        viitosKasi.lisaaKortti(ruutu9);
        viitosKasi.lisaaKortti(pata9);
        viitosKasi.lisaaKortti(jokeri);
        
        nelosKasi.lisaaKortti(hertta9);
        nelosKasi.lisaaKortti(risti9);
        nelosKasi.lisaaKortti(ruutu9);
        nelosKasi.lisaaKortti(pata9);
        nelosKasi.lisaaKortti(pata5);
        
        kolmosKasi.lisaaKortti(hertta9);
        kolmosKasi.lisaaKortti(risti9);
        kolmosKasi.lisaaKortti(ruutu9);
        kolmosKasi.lisaaKortti(pata5);
        kolmosKasi.lisaaKortti(pata6);
        
        kaksiPariaKasi.lisaaKortti(hertta9);
        kaksiPariaKasi.lisaaKortti(risti9);
        kaksiPariaKasi.lisaaKortti(pata8);
        kaksiPariaKasi.lisaaKortti(ruutu8);
        kaksiPariaKasi.lisaaKortti(pata5);
        
        pariKasi.lisaaKortti(hertta9);
        pariKasi.lisaaKortti(pata9);
        pariKasi.lisaaKortti(pata7);
        pariKasi.lisaaKortti(pata6);
        pariKasi.lisaaKortti(pata5);
        
        suoraKasi.lisaaKortti(pata5);
        suoraKasi.lisaaKortti(hertta9);
        suoraKasi.lisaaKortti(pata7);
        suoraKasi.lisaaKortti(pata8);
        suoraKasi.lisaaKortti(pata6);
        
        variKasi.lisaaKortti(pata9);
        variKasi.lisaaKortti(pata8);
        variKasi.lisaaKortti(pata7);
        variKasi.lisaaKortti(pata6);
        variKasi.lisaaKortti(pata3);
        
        varisuoraKasi.lisaaKortti(pata5);
        varisuoraKasi.lisaaKortti(pata6);
        varisuoraKasi.lisaaKortti(pata7);
        varisuoraKasi.lisaaKortti(pata8);
        varisuoraKasi.lisaaKortti(pata9);
        
        tayskasiKasi.lisaaKortti(hertta9);
        tayskasiKasi.lisaaKortti(pata9);
        tayskasiKasi.lisaaKortti(ruutu9);
        tayskasiKasi.lisaaKortti(ruutu8);
        tayskasiKasi.lisaaKortti(pata8);
        
        huonoEiMitaanKasi.lisaaKortti(pata5);
        huonoEiMitaanKasi.lisaaKortti(pata6);
        huonoEiMitaanKasi.lisaaKortti(pata7);
        huonoEiMitaanKasi.lisaaKortti(pata3);
        huonoEiMitaanKasi.lisaaKortti(hertta9);

        hyvaEiMitaanKasi.lisaaKortti(pata5);
        hyvaEiMitaanKasi.lisaaKortti(pata6);
        hyvaEiMitaanKasi.lisaaKortti(pata7);
        hyvaEiMitaanKasi.lisaaKortti(pata8);
        hyvaEiMitaanKasi.lisaaKortti(herttaKuningas);
        
        
        System.out.println(suoraKasi);
        System.out.println(kolmosKasi);
        
        System.out.println(suoraKasi.onkoSuora());
        System.out.println(kolmosKasi.onkoKolmoset());
        
        
        
    }
}