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
        if(kortti.getArvo() > 1) {
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
                int arvo = arvot.get(i);
                int arvo2 = arvot.get(j);
                if(arvot.get(i) != 
                        arvot.get(j)) {
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
    
    public int kuinkaMontaSamaa() {
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
            if(samat.get(avain) == kuinkaMontaSamaa()) {
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
     * Metodi kertoo, onko kädessä pari
     * 
     * @return true, jos kädessä on pari, muuten false
     */
    public boolean onkoPari() {
        return onkoYhtasuuri(2);
    }
    
    /**
     * Metodi kertoo, onko kädessä kolme samaa
     * 
     * @return true, jos kädessä on kolme samaa, muuten false
     */
    public boolean onkoKolmoset() {
        return onkoYhtasuuri(3);
    }
    
    /**
     * Metodi kertoo, onko kädessä neljä samaa
     * 
     * @return true, jos kädessä on neljä samaa, muuten false
     */
    public boolean onkoNeloset() {
        return onkoYhtasuuri(4);
    }
    
    /**
     * Metodi kertoo, onko kädessä viisi samaa
     * 
     * @return true, jos kädessä on viisi samaa, muuten false
     */
    public boolean onkoVitoset() {
        return onkoYhtasuuri(5);
    }
    
    /**
     * Metodi kertoo, onko kädessä viisi samaa
     * 
     * @return true, jos kädessä on viisi samaa, muuten false
     */
    public boolean onkoKutoset() {
        return onkoYhtasuuri(6);
    }
    
    /**
     * Metodi kertoo, onko kädessä tietty määrä jotakin arvoa
     * 
     * @param monta Toistuvan arvon määrä
     * 
     * @return true, jos kädessä on tietty määrä arvoa, muuten false
     */
    public boolean onkoYhtasuuri(int monta) {
        return kuinkaMontaSamaa() == monta;
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
            
            int arvo = apuKasi.getArvot().get(i);
            int arvo2 = ykkosKasi.getArvot().get(i);
            
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
                    
//                }
//                else if(ykkosKasi.getArvot().contains(15)) {
//                    ykkosKasi.poistaJokeri();
//                    koko--;
//                    
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
    
    /**
     * Metodi kertoo, onko kädessä täyskäsi
     * 
     * @return true, jos kädessä on täyskäsi, muuten false
     */
    public boolean onkoTayskasi() {
        if(kortit.contains(new Kortti(15, Kortti.JOKERI))) {
            
            Kasi apuKasi = kadenKopio();
            apuKasi.poistaJokeri();

            return apuKasi.onkoKaksiParia();
            
        }
        if(onkoKolmoset()) {
            if(kuinkaMontaJokeriaKadessa() == 1) {
                kortit.remove(new Kortti(15, Kortti.JOKERI));
            }
            for(Integer arvo : kuinkaMontaSamaaHajautustaulu().values()) {
                if(arvo == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    
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
     * Metodi kertoo onko kädessä kaksi paria
     * 
     * @return true, jos kädessä on kaksi paria, muuten false
     */
    public boolean onkoKaksiParia() {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaHajautustaulu();
        int monta = 0;
        
        if(onkoPari()) {
            for(Integer arvo : samat.values()) {
                if(arvo == 2) {
                    monta++;
                }
            }
        }
        return monta == 2;
    }
    
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
//                    avain != 15) {
                
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
    
    /**
     * Metodi kertoo käden arvon
     * 
     * @return 9, jos kädessä on viisi samaa /
     *         8, jos kädessä on värisuora /
     *         7, jos kädessä on neloset /
     *         6, jos kädessä on täyskäsi /
     *         5, jos kädessä on väri /
     *         4, jos kädessä on suora /
     *         3, jos kädessä on kolmoset /
     *         2, jos kädessä on kaksi paria /
     *         1, jos kädessä on pari /
     *         0, jos kädessä ei ole mitään
     */
    public int kadenArvo() {
        if(onkoVitoset()) {
            return 9;
            
        }
        if(onkoVarisuora()) {
            return 8;
            
        }
        if(onkoNeloset()) {
            return 7;
            
        }
        if(onkoTayskasi()) {
            return 6;
            
        }
        if(onkoVari()) {
            return 5;
            
        }
        if(onkoSuora()) {
            return 4;
            
        }
        if(onkoKolmoset()) {
            return 3;
            
        }
        if(onkoKaksiParia()) {
            return 2;
            
        }
        if(onkoPari()) {
            return 1;
            
        }
        return 0;
    }
}
