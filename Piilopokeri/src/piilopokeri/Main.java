package piilopokeri;

import java.util.ArrayList;
import javax.swing.JFrame;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.gui.ikkunat.GraafinenKL;
import piilopokeri.gui.ikkunat.LopetusIkkuna;

/** @author Wilzon */

public class Main {
    
    public static void main(String[] args) {
        
//        
        Kasi kasiX = new Kasi();
        Kasi hyvaVariKasi = new Kasi();
        
        Kortti pata5 = new Kortti(5, Kortti.PATA, true);
        Kortti pata6 = new Kortti(6, Kortti.PATA, true);
        Kortti pata7 = new Kortti(7, Kortti.PATA, true);
        Kortti pata8 = new Kortti(8, Kortti.PATA, true);
        Kortti pata9 = new Kortti(9, Kortti.PATA, true);
        
        Kortti pata3 = new Kortti(3, Kortti.PATA, true);
        Kortti ruutu8 = new Kortti(8, Kortti.RUUTU, true);
        
        Kortti herttaK = new Kortti(13, Kortti.HERTTA, true);
        Kortti pataK = new Kortti(13, Kortti.PATA, true);
        Kortti ruutuK = new Kortti(13, Kortti.RUUTU, true);
        Kortti ristiK = new Kortti(13, Kortti.RISTI, true);
        
        Kortti pata10 = new Kortti(10, Kortti.PATA, true);
        Kortti pataJ = new Kortti(11, Kortti.PATA, true);
        Kortti pataQ = new Kortti(12, Kortti.PATA, true);
        
        Kortti risti9 = new Kortti(9, Kortti.RISTI, true);
        Kortti ruutu9 = new Kortti(9, Kortti.RUUTU, true);
        Kortti hertta9 = new Kortti(9, Kortti.HERTTA, true);
        
        Kortti jokeri = new Kortti(15, Kortti.JOKERI, true);
        
        kasiX.lisaaKortti(pataK);
        kasiX.lisaaKortti(herttaK);
        kasiX.lisaaKortti(pata7);
        kasiX.lisaaKortti(pata6);
        kasiX.lisaaKortti(pata3);
        
        hyvaVariKasi.lisaaKortti(pata9);
        hyvaVariKasi.lisaaKortti(pata8);
        hyvaVariKasi.lisaaKortti(pata7);
        hyvaVariKasi.lisaaKortti(pata3);
        hyvaVariKasi.lisaaKortti(pataK);
        
        Kortti kortti = new Kortti(4, Kortti.HERTTA, true);
        Kortti kortti2 = new Kortti(3, Kortti.PATA, true);
        Kortti kortti3 = new Kortti(14, Kortti.HERTTA, true);
        Kortti kortti4 = new Kortti(2, Kortti.RUUTU, true);
        Kortti kortti5 = new Kortti(5, Kortti.RUUTU, true);
        
//        Kasi x = new Kasi();
//        
//        x.lisaaKortti(kortti);
//        x.lisaaKortti(kortti2);
//        x.lisaaKortti(kortti3);
//        x.lisaaKortti(kortti4);
//        x.lisaaKortti(kortti5);
//        System.out.println("---");
////        System.out.println(hyvaVariKasi.onkoVari());
////        System.out.println(kasiX.onkoVari());
////        System.out.println(KasienVertailija.parempiKasi(hyvaVariKasi, kasiX));
//        System.out.println("---");
//        
//        
//        System.out.println(x);
//        x.jarjestaKortit();
//        System.out.println("jarjestetty");
//        System.out.println(x);
//        x.kaannaJarjestys();
//        System.out.println("kaanetty");
//        System.out.println(x);
//        System.out.println("--------");
//        System.out.println("--------");
//        System.out.println("--------");
        
        
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
    
//    Kortti pata5;
//    Kortti pata6;
//    Kortti pata7;
//    Kortti pata8;
//    Kortti pata9;
//    
//    Kortti pata3;
//    Kortti ruutu8;
//    Kortti herttaKuningas;
//    
//    Kortti ruutu9;
//    Kortti risti9;
//    Kortti hertta9;
//    
//    Kortti jokeri;
    
    Kortti hertta2;
    Kortti hertta3;
    Kortti hertta4;
    Kortti hertta5;
    Kortti hertta6;
    Kortti hertta10;
    
    Kortti pataAssa;
    
//    Kortti pata5;
    Kortti risti5;
    Kortti ruutu5;
    
    Kortti pata4;
    Kortti ruutu4;
    Kortti risti4;
    
//    Kortti jokeri;
    
    Kortti ruutu6 = new Kortti(6, Kortti.RUUTU, true);
    Kortti risti6 = new Kortti(6, Kortti.RISTI, true);
    
    pataAssa = new Kortti(14, Kortti.PATA, true);
        hertta2 = new Kortti(2, Kortti.HERTTA, true);
        hertta3 = new Kortti(3, Kortti.HERTTA, true);
        hertta4 = new Kortti(4, Kortti.HERTTA, true);
        hertta5 = new Kortti(5, Kortti.HERTTA, true);
        hertta6 = new Kortti(6, Kortti.HERTTA, true);
        hertta10 = new Kortti(10, Kortti.HERTTA, true);
        
//        pata5 = new Kortti(5, Kortti.PATA, true);
        risti5 = new Kortti(5, Kortti.RISTI, true);
        ruutu5 = new Kortti(5, Kortti.RUUTU, true);
        
        pata4 = new Kortti(4, Kortti.PATA, true);
        ruutu4 = new Kortti(4, Kortti.RUUTU, true);
        risti4 = new Kortti(4, Kortti.RISTI, true);
        
        
//        jokeri = new Kortti(15, Kortti.JOKERI, true);
        
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
//        herttaKuningas = new Kortti(13, Kortti.HERTTA, true);
        
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
//        hyvaEiMitaanKasi.lisaaKortti(herttaKuningas);
        
        Kasi vitosJaKolmeSamaaKasi = new Kasi();
        
        vitosJaKolmeSamaaKasi.lisaaKortti(hertta4);
        vitosJaKolmeSamaaKasi.lisaaKortti(ruutu4);
        vitosJaKolmeSamaaKasi.lisaaKortti(risti4);
        vitosJaKolmeSamaaKasi.lisaaKortti(pata4);
        vitosJaKolmeSamaaKasi.lisaaKortti(risti5);
        vitosJaKolmeSamaaKasi.lisaaKortti(ruutu5);
        vitosJaKolmeSamaaKasi.lisaaKortti(pata5);
        vitosJaKolmeSamaaKasi.lisaaKortti(jokeri);
        
        
        System.out.println("-----test-----");
        
//        System.out.println(vitosJaKolmeSamaaKasi);
        
//        System.out.println(vitosJaKolmeSamaaKasi.onkoVitosetJaKolmeSamaa());
        
        
        
        GraafinenKL g = new GraafinenKL();
        
        g.run();
        
        Kasi kaksiViisiSamaaKasi = new Kasi();
        
        kaksiViisiSamaaKasi.lisaaKortti(hertta4);
        kaksiViisiSamaaKasi.lisaaKortti(ruutu4);
        kaksiViisiSamaaKasi.lisaaKortti(risti4);
//        kaksiViisiSamaaKasi.lisaaKortti(pata4);
        
        kaksiViisiSamaaKasi.lisaaKortti(risti5);
        kaksiViisiSamaaKasi.lisaaKortti(ruutu5);
        kaksiViisiSamaaKasi.lisaaKortti(pata5);
        
        kaksiViisiSamaaKasi.lisaaKortti(pata3);
        kaksiViisiSamaaKasi.lisaaKortti(hertta3);
//        kaksiViisiSamaaKasi.lisaaKortti(jokeri);
//        kaksiViisiSamaaKasi.lisaaKortti(jokeri);
        
        System.out.println("------");
        
        ArrayList<Integer> samat = new ArrayList();
        
        samat.add(3);
        samat.add(3);
        
        samat.add(2);
        
//        System.out.println(kaksiViisiSamaaKasi.onkoKahdetKolmosetJaPari());
        
        
        Piilopokeri poker = new Piilopokeri();
        
//        Kasi crazy = poker.getUudetKortit(13);
        
        Kortti pata2 = new Kortti(2, Kortti.PATA);
        Kortti pataA = new Kortti(14, Kortti.PATA);
        Kortti herttaA = new Kortti(14, Kortti.HERTTA);
        
        Kasi crazy = new Kasi();
        
        crazy.lisaaKortti(pata2);
        crazy.lisaaKortti(pata3);
        crazy.lisaaKortti(pata5);
        crazy.lisaaKortti(hertta5);
        
        crazy.lisaaKortti(pata7);
        crazy.lisaaKortti(pata8);
        crazy.lisaaKortti(pata9);
        crazy.lisaaKortti(pata10);
        crazy.lisaaKortti(hertta10);
        crazy.lisaaKortti(herttaK);
        crazy.lisaaKortti(pataA);
        crazy.lisaaKortti(herttaA);
        
        crazy.lisaaKortti(jokeri);
        
//        crazy.lisaaKortti(pata4);
//        crazy.lisaaKortti(risti4);
//        crazy.lisaaKortti(pata4);
//        crazy.lisaaKortti(ruutu4);
//        crazy.lisaaKortti(jokeri);
//        crazy.lisaaKortti(jokeri);
//        
//        crazy.lisaaKortti(hertta5);
//        crazy.lisaaKortti(pata5);
//        
//        crazy.lisaaKortti(hertta6);
//        crazy.lisaaKortti(ruutu6);
//        crazy.lisaaKortti(risti6);
//        crazy.lisaaKortti(pata6);
        
        crazy.kaannaKaikkiKortit();
        crazy.jarjestaKortit();
        
//        System.out.println(crazy);
        
//        System.out.println(crazy.kadenArvoSuurellaKadella());
        
        LopetusIkkuna l = new LopetusIkkuna(pokeri, new JFrame());
        
//        System.out.println(crazy.onkoKolmosetJaKaksiParia());
        
//        pokeri.lisaaIhmispelaaja(new Pelaaja());
        
//        pokeri.getPelaajat().get(0).lisaaKasi(crazy);

//        System.out.print("arvo:");
        
//        JLabel label = l.kasienArvot().get(0);
        
//        System.out.println(label.getText());
        
        System.out.println("------");
        
        Kortti ruutu3 = new Kortti(3, Kortti.RUUTU, true);
        Kortti ruutu2 = new Kortti(2, Kortti.RUUTU, true);
        Kortti risti2 = new Kortti(2, Kortti.RISTI, true);
        Kortti risti3 = new Kortti(3, Kortti.RISTI, true);
        
        
//        Kasi x = new Kasi();
//        
//        
//        x.lisaaKortti(hertta3);
//        x.lisaaKortti(ruutu3);
//        x.lisaaKortti(risti3);
//        x.lisaaKortti(pata3);
//        x.lisaaKortti(jokeri);
////        x.lisaaKortti(jokeri);
//        
//        x.lisaaKortti(hertta2);
//        x.lisaaKortti(ruutu2);
//        x.lisaaKortti(risti2);
//        x.lisaaKortti(pata2);
//        
//        x.lisaaKortti(hertta4);
//        x.lisaaKortti(ruutu4);
//        x.lisaaKortti(risti4);
//        x.lisaaKortti(pata4);
//        
//        x.jarjestaKortit();
//        
//        pokeri.lisaaIhmispelaaja(new Pelaaja());
//        
//        pokeri.getPelaajat().get(0).lisaaKasi(x);
//        
//        JLabel labelX = l.kasienArvot().get(0);
//        
//        System.out.println(labelX.getText());
//        
//        System.out.println(x);
//        
//        Kasi huonoNelosKasi = new Kasi();
//        Kasi huonoTayskasiKasi = new Kasi();
//        
//        huonoNelosKasi.lisaaKortti(hertta9);
//        huonoNelosKasi.lisaaKortti(risti9);
//        huonoNelosKasi.lisaaKortti(ruutu9);
//        huonoNelosKasi.lisaaKortti(pata9);
//        huonoNelosKasi.lisaaKortti(pata5);
//        
//        huonoTayskasiKasi.lisaaKortti(hertta9);
//        huonoTayskasiKasi.lisaaKortti(pata9);
//        huonoTayskasiKasi.lisaaKortti(ruutu9);
//        huonoTayskasiKasi.lisaaKortti(ruutu8);
//        huonoTayskasiKasi.lisaaKortti(pata8);
//        
//        System.out.println(huonoNelosKasi.kadenArvo());
//        System.out.println(huonoTayskasiKasi.kadenArvo());
//        System.out.println(KasienVertailija.parempiKasi(huonoNelosKasi, huonoTayskasiKasi));
        
//        Kasi varisuora = new Kasi();
//        Kasi neloset = new Kasi();
//        
//        varisuora.lisaaKortti(pataK);
//        varisuora.lisaaKortti(pataJ);
//        varisuora.lisaaKortti(pata10);
//        varisuora.lisaaKortti(pataQ);
//        varisuora.lisaaKortti(pata9);
//        
//        neloset.lisaaKortti(pataK);
//        neloset.lisaaKortti(ristiK);
//        neloset.lisaaKortti(pataJ);
//        neloset.lisaaKortti(herttaK);
//        neloset.lisaaKortti(ruutuK);
//        
//        System.out.println(varisuora.kadenArvo());
//        System.out.println(neloset.kadenArvo());
//        System.out.println(varisuora);
//        System.out.println(neloset);
//        
//        System.out.println(KasienVertailija.parempiKasi(varisuora, neloset));
        ArrayList<String> uusi = new ArrayList();
        
        uusi.add("hello");
        uusi.add("hello");
        uusi.add("hello");
        uusi.add("hello");
        uusi.add("hello");
        uusi.add("hello");
        uusi.add("you");
        
        System.out.println(setVoittajaLabelTeksti(uusi));
        
        
    }
    public static String setVoittajaLabelTeksti(ArrayList<String> voittajatLista) {
        String voittajatString = "Pelaajilla ";
        
        for(int i = 0; i < voittajatLista.size(); i++) {
            voittajatString += voittajatLista.get(i);
            
            if(i < voittajatLista.size() - 2) {
                voittajatString += ", ";
            }
            else{
                if(i == voittajatLista.size() - 2) {
                    voittajatString += " ja ";
                }
            }
        }
        voittajatString += " on yhtä hyvät kädet!";
        
            
        return voittajatString;
    }
}