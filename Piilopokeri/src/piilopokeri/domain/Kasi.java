package piilopokeri.domain;

import piilopokeri.jarjestajat.KorttienKaannettyJarjestaja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
        if(kortti.getArvo() > 0 && kortti.getArvo() < 16) {
            kortit.add(kortti);
        }    
    }
    
    /**
     * Metodi kääntää kädessä olevien korttien järjestyksen
     */
    public void kaannaJarjestys() {
        if(kortit.size() > 1) {
            Collections.sort(kortit, new KorttienKaannettyJarjestaja());
        }
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
    
    /**
     * Metodi tekee hajautustaulun, jossa on kaden korttien arvot avaimina
     * ja avaimiin tallennetaan, kuinka monta kertaa kortin arvo toistuu kädessa
     * 
     * @return hajautustaulu
     */
    public HashMap<Integer, Integer> kuinkaMontaSamaaHajautustaulu() {
        HashMap<Integer, Integer> montaSamaaMap = new HashMap();
        
        Kasi apuKasi = kadenKopio();
        apuKasi.kaannaKaikkiKortit();
        apuKasi.jarjestaKortit();
        
        ArrayList<Integer> arvot = apuKasi.getArvot();
        
        while(!arvot.isEmpty()) {
            ArrayList<Integer> poistettavat = new ArrayList();
            
            int montaSamaa = 0;
            int i = 0;
            int pituus = arvot.size();
            
            for(int j = 0; j < pituus; j++) {
                if(arvot.get(i) != arvot.get(j)) {
                    break;
                    
                }
                montaSamaa += 1;
                poistettavat.add(arvot.get(j));
                
            }
            montaSamaaMap.put(arvot.get(i), montaSamaa);
            
            poistettavat.add(arvot.get(i));
            
            arvot.removeAll(poistettavat);
        }
        return montaSamaaMap;
    }
    
    /**
     * Metodi kertoo kuinka monta jokeria kädessä on
     * 
     * @return jokerien määrä
     */
    public int kuinkaMontaJokeriaKadessa() {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaHajautustaulu();
        
        if(samat.containsKey(15)) {
            return samat.get(15);
            
        }
        return 0;
    }
    
    public int suurinMontaSamaa() {
        int suurin = 0;
        
        for(Integer arvo : kuinkaMontaSamaaHajautustaulu().values()) {
            if(suurin < arvo) {
                suurin = arvo;
            }
        }
        suurin += kuinkaMontaJokeriaKadessa();
        
        return suurin;
    }
    
    /**
     * Metodi kertoo, minkä arvoinen kortti on, jota on monta kädessä
     * 
     * @return kortin arvo
     */
    public int montaSamaaKortinArvo() {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaHajautustaulu();
        
        for(Integer avain : samat.keySet()) {
            if(samat.get(avain) == suurinMontaSamaa()) {
                return avain;
                
            }
        }
        return -1;
    }
    
    /**
     * Metodi kertoo kaden korkeimman kortin arvon
     * 
     * @return suurin arvo
     */
    public int korkeinArvo() {
        Kasi apuKasi = kadenKopio();
        apuKasi.kaannaJarjestys();
        
        return apuKasi.getArvot().get(0);
    }
    /**
     * Metodi poistaa kädestä jokerit ja suurimman arvoiset kortit, 
     * jotka toistuvat kädessä haluttuja kertoja
     * 
     * @param monta Haluttu toistumisen määrä
     * 
     * @return true, jos poistaminen onnistuu, muuten false
     */
    public boolean poistaHalututArvotJosVoi(int monta) {
        if(onkoYhtamontaSamaa(monta)) {
            ArrayList<Integer> lista = monenSamanArvotJokeritHuomioiden(monta);

            poistaKaikkiTarvittavatArvot(lista);
            poistaJokerit();
            
            return true;
            
        }
        return false;
    }
    
    /**
     * Metodi kertoo, onko kädessä pari
     * 
     * @return true, jos kädessä on pari, muuten false
     */
    public boolean onkoPari() {
        return onkoYhtamontaSamaa(2);
    }
    
    /**
     * Metodi kertoo, onko kädessä kaksi paria
     * 
     * @return true, jos kädessä on kaksi paria, muuten false
     */
    public boolean onkoKaksiParia() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(true, 2, 2, 0, 0);
//        return onkoKaksiMontaSamaa(2, 2);
    }
    
    /**
     * Metodi poistaa arvot ja jokerit, jos niitä on kolme kädessä
     * 
     * @return true, jos kädessä on kolme samaa, muuten false
     */
    public boolean onkoKolmoset() {
        return poistaHalututArvotJosVoi(3);
    }
    
    /**
     * Metodi poistaa arvot ja jokerit, jos niitä on neljä kädessä
     * 
     * @return true, jos kädessä on neljä samaa, muuten false
     */
    public boolean onkoNeloset() {
        return poistaHalututArvotJosVoi(4);
    }
    
    /**
     * Metodi poistaa arvot ja jokerit, jos niitä on viisi kädessä
     * 
     * @return true, jos kädessä on viisi samaa, muuten false
     */
    public boolean onkoVitoset() {
        return poistaHalututArvotJosVoi(5);
    }
    
    /**
     * Metodi poistaa arvot ja jokerit, jos niitä on kuusi kädessä
     * 
     * @return true, jos kädessä on kuusi samaa, muuten false
     */
    public boolean onkoKutoset() {
        return poistaHalututArvotJosVoi(6);
    }
    
    /**
     * Metodi kertoo, onko kädessä täyskäsi
     * 
     * @return true, jos kädessä on täyskäsi, muuten false
     */
    public boolean onkoTayskasi() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(true, 3, 1, 2, 1);
    }
    
    public boolean onkoKahdetKolmoset() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(true, 3, 2, 0, 0);
    }

    public boolean onkoKahdetNeloset() {
        return onkoTarvittavatKortit(true, 4, 2, 0, 0);
    }
    
    public boolean onkoKolmeParia() {
        ArrayList<Integer> lista = montaSamaaLista(2, 3);

        return onkoTarvittavatKortit(true, 2, 3, 0, 0);
    }
    
    public boolean onkoNeljaParia() {
        ArrayList<Integer> lista = montaSamaaLista(2, 4);

        return onkoTarvittavatKortit(true, 2, 4, 0, 0);
    }
    
    public boolean onkoViisiParia() {
        ArrayList<Integer> lista = montaSamaaLista(2, 5);

        return onkoTarvittavatKortit(true, 2, 5, 0, 0);
    }
        
    public boolean onkoKuusiParia() {
        ArrayList<Integer> lista = montaSamaaLista(2, 6);

        return onkoTarvittavatKortit(true, 2, 6, 0, 0);
    }
    
    public boolean onkoKolmetKolmoset() {
        ArrayList<Integer> lista = montaSamaaLista(3, 3);

        return onkoTarvittavatKortit(true, 3, 3, 0, 0);
    }
    
    public boolean onkoNeljatKolmoset() {
        ArrayList<Integer> lista = montaSamaaLista(3, 4);

        return onkoTarvittavatKortit(true, 3, 4, 0, 0);
    }
    
    public boolean onkoKolmetNeloset() {
        ArrayList<Integer> lista = montaSamaaLista(4, 3);
        
        return onkoTarvittavatKortit(true, 4, 3, 0, 0);

//        return onkoUseaMontaSamaa(lista);
    }
    
    public boolean onkoKahdetKolmosetJaPari() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKahdetKolmoset(), 2, 1, 0, 0);
    }
    
    public boolean onkoKolmetKolmosetJaPari() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmetKolmoset(), 2, 1, 0, 0);
    }
    
    public boolean onkoKutosetJaNelosetJaKolmoset() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 4, 1, 3, 1);
    }
    
    public boolean onkoKutosetJaKahdetKolmoset() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 3, 2, 0, 0);
    }
    
    public boolean onkoKutosetJaKolmosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 3, 1, 2, 2);
    }
    
    public boolean onkoKutosetJaKolmoset() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 3, 1, 0, 0);
    }
    
    public boolean onkoKutosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 2, 3, 0, 0);
    }
    
    public boolean onkoKutosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 2, 2, 0, 0);
    }
    
    public boolean onkoKutosetJaPari() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKutoset(), 2, 1, 0, 0);
    }
    
    public boolean onkoVitosetJaKahdetNeloset() {
        Kasi apuKasi = kadenKopio();
       
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 4, 2, 0, 0);
    }
    
    public boolean onkoVitosetJaNelosetJaKolmoset() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 4, 1, 3, 1);
    }
    
    public boolean onkoVitosetJaNelosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 4, 1, 2, 2);
    }
    
    public boolean onkoVitosetJaKahdetKolmosetJaPari() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 3, 2, 2, 1);
    }
    
    public boolean onkoVitosetJaKolmosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 3, 1, 2, 2);
    }
    
    public boolean onkoVitosetJaKolmoset() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 3, 1, 0, 0);
    }
    
    public boolean onkoVitosetJaNeljaParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 2, 4, 0, 0);
    }
    
    public boolean onkoVitosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 2, 3, 0, 0);
    }
    
    public boolean onkoVitosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 2, 2, 0, 0);
    }

    public boolean onkoVitosetJaPari() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoVitoset(), 2, 1, 0, 0);
    }
    
    public boolean onkoKahdetNelosetJaKolmosetJaPari() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKahdetNeloset(), 3, 1, 2, 1);
    }
    
    public boolean onkoKahdetNelosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKahdetNeloset(), 2, 2, 0, 0);
    }
    
    public boolean onkoNelosetJaKolmetKolmoset() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 3, 3, 0, 0);
    }
    
    public boolean onkoNelosetJaKahdetKolmosetJaPari() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 3, 2, 2, 1);
    }
    
    public boolean onkoNelosetJaKolmosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 3, 1, 2, 3);
    }
    
    public boolean onkoNelosetJaKolmoset() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 3, 1, 0, 0);
    }
    
    public boolean onkoNelosetJaNeljaParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 2, 4, 0, 0);
    }
    
    public boolean onkoNelosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 2, 3, 0, 0);
    }
    
    public boolean onkoNelosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 2, 2, 0, 0);
    }
    
    public boolean onkoNelosetJaPari() {
        Kasi apuKasi = kadenKopio();

        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoNeloset(), 2, 1, 0, 0);
    }
    
    public boolean onkoKolmetKolmosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmetKolmoset(), 2, 2, 0, 0);
    }
    
    public boolean onkoKahdetKolmosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKahdetKolmoset(), 2, 3, 0, 0);
    }
    
    public boolean onkoKahdetKolmosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKahdetKolmoset(), 2, 2, 0, 0);
    }
    
    public boolean onkoKolmosetJaViisiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmoset(), 2, 5, 0, 0);
    }
    
    public boolean onkoKolmosetJaNeljaParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmoset(), 2, 4, 0, 0);
    }
    
    public boolean onkoKolmosetJaKolmeParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmoset(), 2, 3, 0, 0);
    }
    
    public boolean onkoKolmosetJaKaksiParia() {
        Kasi apuKasi = kadenKopio();
        
        return apuKasi.onkoTarvittavatKortit(apuKasi.onkoKolmoset(), 2, 2, 0, 0);
    }
    
    public boolean onkoTarvittavatKortit(boolean onko, int montaSamaa, int maara, int montaSamaa2, int maara2) {
        if(onko) {
            ArrayList<Integer> lista = montaSamaaLista(montaSamaa, maara);
            
            if(montaSamaa2 != 0) {
                ArrayList<Integer> lista2 = montaSamaaLista(montaSamaa2 , maara2);
                
                return onkoUseaMontaSamaa(lista) && onkoUseaMontaSamaa(lista2);
                
            }
            return onkoUseaMontaSamaa(lista);
            
        }
        return false;
    }
            
    public ArrayList<Integer> montaSamaaLista(int luku, int monta) {
        ArrayList<Integer> lista = new ArrayList();
        
        for(int i = 0; i < monta; i++) {
            lista.add(luku);
            
        }
        return lista;
    }
    
    public void poistaKaikkiTarvittavatArvot(ArrayList<Integer> arvot) {
        for(Integer arvo : arvot) {
            kortit.remove(new Kortti(arvo, Kortti.HERTTA));
            kortit.remove(new Kortti(arvo, Kortti.RUUTU));
            kortit.remove(new Kortti(arvo, Kortti.RISTI));
            kortit.remove(new Kortti(arvo, Kortti.PATA));
        }
    }

    /**
     * Metodi kertoo, onko kädessä tietty määrä jotakin arvoa
     * 
     * @param monta Toistuvan arvon määrä
     * 
     * @return true, jos kädessä on tietty määrä arvoa, muuten false
     */
    public boolean onkoYhtamontaSamaa(int monta) {
        return suurinMontaSamaa() == monta;
    }
    
    
    /**
     * Metodi muuttaa kädessä olevan ässän ykköseksi
     * 
     * @return uusi käsi
     */
    public Kasi muutaAssaYkkoseksi() {
        Kasi apuKasi = kadenKopio();
        apuKasi.kaannaKaikkiKortit();
        apuKasi.kaannaJarjestys();
        
        ArrayList<Kortti> apuKadenKortit = apuKasi.getKortit();
        
        int maa = apuKadenKortit.get(0).getMaa();
        
        for(int i = 0; i < apuKadenKortit.size(); i++) {
            if(apuKadenKortit.get(i).getArvo() == 14) {
                apuKadenKortit.remove(i);
                
                apuKadenKortit.add(i, new Kortti(1, maa, true));
            }
        }
        apuKasi.jarjestaKortit();
        
        return apuKasi;
    }
    
    /**
     * Metodi kertoo, onko kädessä suora
     * 
     * @return true, jos kädessä on suora, muuten false
     */
    public boolean onkoSuora() {
        Kasi apuKasi = kadenKopio();
        Kasi ykkosKasi = muutaAssaYkkoseksi();
        apuKasi.kaannaKaikkiKortit();
        apuKasi.jarjestaKortit();
        
        ArrayList<Integer> arvot = apuKasi.getArvot();
        ArrayList<Integer> arvot2 = ykkosKasi.getArvot();
        
        int verrattavaArvo = apuKasi.getArvot().get(0);
        int verrattavaArvo2 = ykkosKasi.getArvot().get(0);
        
        int koko = apuKasi.kortit.size();
        
        for(int i = 1; i < koko; i++) {
            
            if(verrattavaArvo + 1 != apuKasi.getArvot().get(i) &&
                    verrattavaArvo2 + 1 != ykkosKasi.getArvot().get(i)) {
                
                if(apuKasi.getArvot().contains(15) || 
                        ykkosKasi.getArvot().contains(15)) {
                    
                    apuKasi.poistaJokeri();
                    ykkosKasi.poistaJokeri();

                    arvot.add(i, verrattavaArvo + 1);
                    arvot2.add(i, verrattavaArvo2 + 1);
                    
                    verrattavaArvo++;
                    verrattavaArvo2++;
                    
                    koko--;
                    
                }else{
                    return false;
                    
                }
            }
            verrattavaArvo += 1;
            verrattavaArvo2 += 1;
        }
        return true;
    }
    
    /**
     * Metodi kopioi käden
     * 
     * @return käden kopio
     */
    public Kasi kadenKopio() {
        Kasi kopioKasi = new Kasi();
        
        for(Kortti kortti : kortit) {
            kopioKasi.lisaaKortti(new Kortti(kortti.getArvo(), kortti.getMaa()));
        }
        return kopioKasi;
    }
    
    /**
     * Metodi kertoo, onko kädessä väri
     * 
     * @return true, jos kädessä on väri, muuten false
     */
    public boolean onkoVari() {
        Kasi apuKasi = kadenKopio();
        apuKasi.jarjestaKortit();
        ArrayList<Integer> maat = apuKasi.getMaat();
        
        int verrattavaMaa = maat.get(0);
        
        for(int i = 1; i < maat.size(); i++) {
            if(verrattavaMaa != maat.get(i) && maat.get(i) != Kortti.JOKERI) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodi kertoo, onko kädessä värisuora
     * 
     * @return true, jos kädessä on värisuora, muuten false 
     * 
     */
    public boolean onkoVarisuora() {
        return onkoVari() && onkoSuora();
    }
    
    public boolean onkoUseaMontaSamaa(ArrayList<Integer> montaSamaa) {
        Kasi apuKasi = kadenKopio();
        HashMap<Integer, Integer> hajautustaulu = apuKasi.kuinkaMontaSamaaHajautustaulu();
        
        int uusiEnsimmainenArvo = montaSamaa.get(0) - apuKasi.kuinkaMontaJokeriaKadessa();
        montaSamaa.set(0, uusiEnsimmainenArvo);
        
        for(int i = 0; i < montaSamaa.size(); i++) {
            int luku = montaSamaa.get(i);
            
            for(Integer avain : hajautustaulu.keySet()) {
                int arvo = hajautustaulu.get(avain);
                
                if(luku == arvo) {
                    montaSamaa.remove(i);
                    hajautustaulu.remove(avain);
                    i--;
                    
                    break;
                }
            }
        }
        return montaSamaa.isEmpty();
    }
    
//    public boolean onkoKaksiMontaSamaa(int montaSamaa, int montaSamaa2) {
//        Kasi apuKasi = kadenKopio();
//            
//        if(apuKasi.suurinMontaSamaa() == montaSamaa) {
//            if(apuKasi.kuinkaMontaJokeriaKadessa() > 0) {
//                    apuKasi.poistaMolemmatJokerit();
//                    
//            }
//            for(Integer avain : apuKasi.kuinkaMontaSamaaHajautustaulu().keySet()) {
//                int arvo = apuKasi.kuinkaMontaSamaaHajautustaulu().get(avain);
//                
//                if(arvo == montaSamaa2 && avain != apuKasi.montaSamaaKortinArvo()) {
//                    return true;
//                    
//                }
//            }
//        }
//        return false;
//    }
    
    /**
     * Metodi poistaa yhden jokerin kädestä
     */
    public void poistaJokeri() {
        Kortti jokeri = new Kortti(15, Kortti.JOKERI);
        
        if(kortit.contains(jokeri)) {
            kortit.remove(jokeri);
        }
    }
    
    /**
     * Metodi kertoo, onko kädessä parametrina annettu
     * summa pareja
     * 
     * @param monta Kuinka monta paria
     * 
     * @return true, jos pareja on parametrin luvun kanssa yhtä monta, muuten false
     */
//    public boolean onkoMontaParia(int monta) {
//        HashMap<Integer, Integer> samat = kuinkaMontaSamaaHajautustaulu();
//        int pareja = 0;
//        
//        if(onkoPari()) {
//            for(Integer arvo : samat.values()) {
//                if(arvo == 2) {
//                    pareja++;
//                }
//            }
//        }
//        return pareja == monta;
//    }
    
    /**
     * Metodi kertoo arvot, joita on monta kädessä
     * 
     * @param maara Toistuvan arvon määrä
     * 
     * @return toistuvien arvojen lista
     */
    public ArrayList<Integer> monenSamanArvot(int maara) {
        HashMap<Integer, Integer> kadenKartta = kuinkaMontaSamaaHajautustaulu();
        ArrayList<Integer> kadenArvot = new ArrayList();
        
        if(maara == 9) {
            maara = 5;
        }
        if(maara == 7) {
            maara = 4;
        }
        if(maara == 1) {
            maara = 2;
        }

        // Entry<Integer, Integer> entry : map.entrySet()
        for(Integer avain : kadenKartta.keySet()) {
            int avaimenArvo = kadenKartta.get(avain);
            
            if(avaimenArvo != maara &&
                    avaimenArvo != maara - kuinkaMontaJokeriaKadessa()) {
                
                if(avaimenArvo == maara - kuinkaMontaJokeriaKadessa()) {
                    for(Integer vertailuAvain : kadenKartta.keySet()) {
                        int vertailuArvo = kadenKartta.get(vertailuAvain);

                        if(vertailuArvo == maara - kuinkaMontaJokeriaKadessa()) {
                            
                            if(avain < vertailuAvain) {
                                kadenArvot.add(vertailuAvain);
                            }  
                        }
                    }
                }
            }else{
                kadenArvot.add(avain);
                
            }
        }
        return kadenArvot;
    }
    
    public ArrayList<Integer> monenSamanArvotJokeritHuomioiden(int maara) {
        ArrayList<Integer> kadenArvot = monenSamanArvot(maara);
        ArrayList<Integer> halututArvot = new ArrayList();
        
        if(kuinkaMontaJokeriaKadessa() > 0 && !kadenArvot.isEmpty()) {
            Collections.sort(kadenArvot);
            
            halututArvot.add(kadenArvot.get(kadenArvot.size() - 1));
            
            return halututArvot;
            
        }
        return kadenArvot;
    }
    
    /**
     * Metodi kertoo ylimääräisen kortin arvon
     * 
     * @return kortin arvo
     */
    public int getExtraKortinArvo() {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaHajautustaulu();
        int kortinArvo = 0;
        
        for(Integer avain : samat.keySet()) {
            if(samat.get(avain) == 1) {
                kortinArvo = avain;
            }
        }
        return kortinArvo;
    }
    
    public Kortti getSuurinKortti() {
        Kasi apuKasi = kadenKopio();
        apuKasi.kaannaKaikkiKortit();
        apuKasi.kaannaJarjestys();
        
        return apuKasi.getKortit().get(0);
    }
    
    /**
     * Metodi kertoo käden arvon
     * 
     * @return Palauttaa sitä suuremman luvun, mitä parempi käsi on
     *         ...
     *         17, jos kädessä on viisi samaa /
     *         12, jos kädessä on värisuora /
     *         8, jos kädessä on neloset /
     *         7, jos kädessä on täyskäsi /
     *         6, jos kädessä on väri /
     *         5, jos kädessä on suora /
     *         3, jos kädessä on kolmoset /
     *         2, jos kädessä on kaksi paria /
     *         1, jos kädessä on pari /
     *         0, jos kädessä ei ole mitään
     */
    public int kadenArvo() {
        Kasi apuKasi = kadenKopio();
        
        if(apuKasi.getKortit().size() == 1) {
            return 99;
        }
        
        if(apuKasi.onkoKutosetJaNelosetJaKolmoset()) {
            return 53;
            
        }
        if(apuKasi.onkoKutosetJaKahdetKolmoset()) {
            return 52;
            
        }
        if(apuKasi.onkoVitosetJaKahdetNeloset()) {
            return 51;
            
        }
        if(apuKasi.onkoKutosetJaKolmosetJaKaksiParia()) {
            return 50;
            
        }
        if(apuKasi.onkoVitosetJaNelosetJaKolmoset()) {
            return 49;
            
        }
        if(apuKasi.onkoVitosetJaNelosetJaKaksiParia()) {
            return 48;
            
        }
        if(apuKasi.onkoKolmetNeloset()) {
            return 47;
            
        }
        if(apuKasi.onkoVitosetJaKahdetKolmosetJaPari()) {
            return 46;
            
        }
        if(apuKasi.onkoKahdetNelosetJaKolmosetJaPari()) {
            return 45;
            
        }
        if(apuKasi.onkoVitosetJaKolmosetJaKaksiParia()) {
            return 44;
            
        }
        if(apuKasi.onkoVitosetJaKolmoset()) {
            return 43;
            
        }
        if(apuKasi.onkoKahdetNeloset()) {
            return 42;
            
        }
        if(apuKasi.onkoNelosetJaKolmetKolmoset()) {
            return 41;
            
        }
        if(apuKasi.onkoNelosetJaKahdetKolmosetJaPari()) {
            return 40;
            
        }
        if(apuKasi.onkoVitosetJaNeljaParia()) {
            return 39;
            
        }
        if(apuKasi.onkoNeljatKolmoset()) {
            return 38;
            
        }
        if(apuKasi.onkoKolmetKolmosetJaKaksiParia()) {
            return 37;
            
        }
        if(apuKasi.onkoKutosetJaKolmeParia()) {
            return 36;
            
        }
        if(apuKasi.onkoKutosetJaKolmoset()) {
            return 35;
            
        }
        if(apuKasi.onkoNelosetJaKolmosetJaKolmeParia()) {
            return 34;
            
        }
        if(apuKasi.onkoKutosetJaKaksiParia()) {
            return 33;
            
        }
        if(apuKasi.onkoVitosetJaKolmeParia()) {
            return 32;
            
        }
        if(apuKasi.onkoKolmetKolmoset()) {
            return 31;
           
        }
        if(apuKasi.onkoKutosetJaPari()) {
            return 30;
            
        }
        if(apuKasi.onkoVitosetJaKaksiParia()) {
            return 29;
            
        }
        if(apuKasi.onkoNelosetJaNeljaParia()) {
            return 28;
            
        }
        if(apuKasi.onkoKutoset()) {
            return 27;
            
        }
        if(apuKasi.onkoKahdetKolmosetJaKolmeParia()) {
            return 26;
            
        }
        if(apuKasi.onkoVitosetJaPari()) {
            return 25;
                    
        }
        if(apuKasi.onkoNelosetJaKolmeParia()) {
            return 24;
            
        }
        if(apuKasi.onkoKolmosetJaViisiParia()) {
            return 23;
            
        }
        if(apuKasi.onkoKolmosetJaNeljaParia()) {
            return 22;
            
        }
        if(apuKasi.onkoKuusiParia()) {
            return 21;
            
        }
        if(apuKasi.onkoNelosetJaKolmoset()) {
            return 20;
            
        }
        if(apuKasi.onkoNelosetJaKaksiParia()) {
            return 19;
            
        }
        if(apuKasi.onkoKolmosetJaKolmeParia()) {
            return 18;
            
        }
        if(apuKasi.onkoVitoset()) {
            return 17;
            
        }
        if(apuKasi.onkoKahdetKolmosetJaPari()) {
            return 16;
            
        }
        if(apuKasi.onkoViisiParia()) {
            return 15;
            
        }
        if(apuKasi.onkoNelosetJaPari()) {
            return 14;
            
        }
        if(apuKasi.onkoKahdetKolmoset()) {
            return 13;
            
        }
        if(apuKasi.onkoVarisuora()) {
            return 12;
            
        }
        if(apuKasi.onkoKolmosetJaKaksiParia()) {
            return 11;
            
        }
        if(apuKasi.onkoNeljaParia()) {
            return 10;
            
        }
        if(apuKasi.onkoNelosetJaPari()) {
            return 9;
            
        }
        if(apuKasi.onkoNeloset()) {
            return 8;
            
        }
        if(apuKasi.onkoTayskasi()) {
            return 7;
            
        }
        if(apuKasi.onkoVari()) {
            return 6;
            
        }
        if(apuKasi.onkoSuora()) {
            return 5;
            
        }
        if(apuKasi.onkoKolmeParia()) {
            return 4;
            
        }
        if(apuKasi.onkoKolmoset()) {
            return 3;
            
        }
        if(apuKasi.onkoKaksiParia()) {
            return 2;
            
        }
        if(apuKasi.onkoPari()) {
            return 1;
            
        }
        return 0;
    }
    
    /**
     * Metodi huomioi, kuinka suuri käsi vaikuttaa
     * suoraan, väriin ja värisuoraan
     * 
     * @return Muokattu käden arvo
     */
    public int kadenArvoSuurellaKadella() {
        int arvo = kadenArvo();
        
        if(arvo == 12) {
            arvo = 56;
            
        }
        if(arvo == 6) {
            arvo = 55;
            
        }
        if(arvo == 5) {
            arvo = 54;
            
        }
        return arvo;
    }
}
