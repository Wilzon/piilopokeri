package piilopokeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttipakka;

/** @author Wilzon */

public class Piilopokeri {
    /**
     * Pokerin pakka
     */
    private final Korttipakka pakka = new Korttipakka(); 
    
    /**
     * Avopakan päällimmäinen kortti
     */
    private Kortti avoPakanKortti = pakka.getPaallimmainen();
    
    /**
     * Metodi nostaa pakasta kortteja käteen
     * 
     * @param  maara Korttien lukumäärä
     * 
     * @return uusi kasi
     */
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
    
    /**
     * Metodi poistaa jokerit pakasta
     */
    public void poistaJokeritPakasta() {
        pakka.poistaJokerit();
    }
    
    /**
     * Metodi sekoittaa pakkaa
     */
    public void sekoitaPakka() {
        pakka.sekoitaKortit();
    }
    
    /**
     * Metodi järjestää pakan
     */
    public void jarjestaPakka() {
        pakka.jarjestaKortit();
    }
    
    /**
     * Metodi tulostaa pelikentän, jossa on pakka ja kadet
     * 
     * @param kadet 
     */
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
                int pituus = avoPakanKortti.toString().length() + 5;
                int tyhja = (reunat.length() - pituus) / 2;
                
                rivi = lisaaTyhjaaAlkuun(tyhja, rivi);
                rivi += avoPakanKortti + "  [X]";
                
                rivi = lisaaTyhjaaLoppuun(pituus, tyhja, rivi);
            }else{
                rivi += "*                                                          *";    
            }
            System.out.println(rivi);
        }
        System.out.println(reunat);
        
        // katso myöhemmin
    }
    
    /**
     * Metodi lisää oikean määrän tyhjää rivin loppuun
     * 
     * @param pituus Rivin tekstiosan pituus
     * @param tyhja Rivin tyhjän määrä
     * @param rivi Rivin teksti
     * 
     * @return muokattu rivi
     */
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
    
    /**
     * Metodi lisää tyhjää rivin loppuun
     * 
     * @param tyhja Rivin tyhjän määrä
     * @param rivi Rivin teksti
     * 
     * @return muokattu rivi
     */
    public String lisaaTyhjaaAlkuun(int tyhja, String rivi) {
        rivi += ("*");
        
        for(int k = 0; k < tyhja; k++) {
            rivi += " ";
        }
        return rivi;
    }
    
    /**
     * Metodi kääntää kortin oikeinpäin
     * 
     * @param kortti Kaannettava kortti
     */
    public void kaannaKortti(Kortti kortti) {
        kortti.kaannaKortti();
    }
    
    /**
     * Metodi tekee hajautustaulun, jossa on kaden korttien arvot avaimina
     * ja niihin tallennetaan kuinka monta kertaa kortin arvo toistuu kädessa
     * 
     * @param kasi Käsi, josta hajautustaulu halutaan muodostaa
     * 
     * @return hajautustaulu
     */
    public HashMap<Integer, Integer> kuinkaMontaSamaaMap(Kasi kasi) {
        HashMap<Integer, Integer> montaSamaaMap = new HashMap();
        
        Kasi apuKasi = kadenKopio(kasi);
        apuKasi.kaannaJarjestys();
        
        ArrayList<Integer> arvot = apuKasi.getArvot();
        
        while(!arvot.isEmpty()) {
            ArrayList<Integer> poistettavat = new ArrayList();
            int montaSamaa = 0;
            int i = 0;
            int pituus = arvot.size();
            
            for(int j = 0; j < pituus; j++) {
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
     * Metodi laskee kuinka monta kertaa arvo, jota on eniten kädessä,
     * toistuu, jokerit mukaan laskien
     * 
     * @param kasi Käsi, josta halutaan tietää kuinka monta kertaa tietty arvo toistuu
     * 
     * @return arvon toistumismäärä
     */
    public int kuinkaMontaSamaa(Kasi kasi) {
        int suurin = 0;
        for(Integer arvo : kuinkaMontaSamaaMap(kasi).values()) {
            if(suurin < arvo) {
                suurin = arvo;
            }
        }
        suurin += kuinkaMontaJokeriaKadessa(kasi);
        
        return suurin;
    }
    
    /**
     * Metodi kertoo kuinka monta jokeria kädessä on
     * 
     * @param kasi Käsi, josta jokerien määrä halutaan tietää
     * 
     * @return jokerien määrä
     */
    public int kuinkaMontaJokeriaKadessa(Kasi kasi) {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaMap(kasi);
        
        if(samat.containsKey(15)) {
            return samat.get(15);
        }
        return 0;
    }
    
    /**
     * Metodi kertoo minkä arvoinen kortti on, jota on monta kädessä
     * 
     * @param kasi Käsi, josta arvo halutaan
     * 
     * @return kortin arvo
     */
    public int montaSamaaKortinArvo(Kasi kasi) {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaMap(kasi);
        for(Integer avain : samat.keySet()) {
            if(samat.get(avain) == kuinkaMontaSamaa(kasi)) {
                return avain;
            }
        }
        return -1;
    }
    
    /**
     * Metodi kertoo kaden korkeimman kortin arvon
     * 
     * @param kasi Käsi, josta arvo halutaan
     * 
     * @return suurin arvo
     */
    public int korkeinArvo(Kasi kasi) {
        Kasi apuKasi = kadenKopio(kasi);
        
        apuKasi.jarjestaKortit();
        return apuKasi.getArvot().get(kasi.getArvot().size() - 1);
        
    }
    
    /**
     * Metodi kertoo, onko kädessä pari
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on pari, muuten false
     */
    public boolean onkoPari(Kasi kasi) {
        return onkoYhtasuuri(kasi, 2);
    }
    
    /**
     * Metodi kertoo, onko kädessä kolme samaa
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on kolme samaa, muuten false
     */
    public boolean onkoKolmoset(Kasi kasi) {
        return onkoYhtasuuri(kasi, 3);
    }
    
    /**
     * Metodi kertoo, onko kädessä neljä samaa
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on neljä samaa, muuten false
     */
    public boolean onkoNeloset(Kasi kasi) {
        return onkoYhtasuuri(kasi, 4);
    }
    
    /**
     * Metodi kertoo, onko kädessä viisi samaa
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on viisi samaa, muuten false
     */
    public boolean onkoVitoset(Kasi kasi) {
        return onkoYhtasuuri(kasi, 5);
    }
    
    /**
     * Metodi kertoo, onko kädessä tietty määrä jotakin arvoa
     * 
     * @param kasi Verrattava käsi
     * @param monta Toistuvan arvon määrä
     * 
     * @return true, jos kädessä on tietty määrä arvoa, muuten false
     */
    public boolean onkoYhtasuuri(Kasi kasi, int monta) {
        return kuinkaMontaSamaa(kasi) == monta;
    }
    
    /**
     * Metodi kertoo, onko kädessä suora
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on suora, muuten false
     */
    public boolean onkoSuora(Kasi kasi) {
        Kasi apuKasi = kadenKopio(kasi);
        Kasi ykkosKasi = muutaAssaYkkoseksi(kasi);
        apuKasi.jarjestaKortit();
        
        ArrayList<Integer> arvot = apuKasi.getArvot();
        ArrayList<Integer> arvot2 = ykkosKasi.getArvot();
        
        int verrattavaArvo = arvot.get(0);
        int verrattavaArvo2 = arvot2.get(0);
        
        for(int i = 1; i < arvot.size(); i++) {
            if(verrattavaArvo + 1 != arvot.get(i) &&
                    verrattavaArvo2 + 1 != arvot2.get(i)) {
                if(arvot2.contains(15)) {
                    arvot.remove(arvot.size() - 1);
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
     * @param kasi Kopioitava käsi
     * 
     * @return käden kopio
     */
    public Kasi kadenKopio(Kasi kasi) {
        Kasi kopioKasi = new Kasi();
        
        for(Kortti kortti : kasi.getKortit()) {
            kopioKasi.lisaaKortti(kortti);
        }
        return kopioKasi;
    }
    
    /**
     * Metodi muuttaa kädessä olevan ässän ykköseksi
     * 
     * @param kasi Muutettava käsi
     * 
     * @return uusi käsi
     */
    public Kasi muutaAssaYkkoseksi(Kasi kasi) {
        Kasi apuKasi = kadenKopio(kasi);
        apuKasi.kaannaJarjestys();
        ArrayList<Kortti> kortit = apuKasi.getKortit();
        
        int maa = kortit.get(0).getMaa();
        if(kortit.get(0).getArvo() == 14) {
            kortit.remove(0);
            kortit.add(new Kortti(1, maa));
        
        }
        apuKasi.jarjestaKortit();
        
        return apuKasi;
    }
    
    /**
     * Metodi kertoo, onko kädessä väri
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on väri, muuten false
     */
    public boolean onkoVari(Kasi kasi) {
        Kasi apuKasi = kadenKopio(kasi);
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
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on värisuora, muuten false
     */
    public boolean onkoVarisuora(Kasi kasi) {
        return onkoVari(kasi) && onkoSuora(kasi);
    }
    
    /**
     * Metodi kertoo, onko kädessä täyskäsi
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return true, jos kädessä on täyskäsi, muuten false
     */
    public boolean onkoTayskasi(Kasi kasi) {
        if(onkoKolmoset(kasi)) {
            for(Integer arvo : kuinkaMontaSamaaMap(kasi).values()) {
                if(arvo == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko kädessä kaksi paria
     * 
     * @param kasi Tarkasteltava käsi
     * @return true, jos kädessä on kaksi paria, muuten false
     */
    public boolean onkoKaksiParia(Kasi kasi) {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaMap(kasi);
        
        if(onkoPari(kasi)) {
            samat.remove(2);
            for(Integer arvo : samat.values()) {
                if(arvo == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo käden arvon
     * 
     * @param kasi Tarkasteltava käsi
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
    public int kadenArvo(Kasi kasi) {
        if(onkoVitoset(kasi)) {
            return 9;
        }
        if(onkoVarisuora(kasi)) {
            return 8;
        }
        if(onkoNeloset(kasi)) {
            return 7;
        }
        if(onkoTayskasi(kasi)) {
            return 6;
        }
        if(onkoVari(kasi)) {
            return 5;
        }
        if(onkoSuora(kasi)) {
            return 4;
        }
        if(onkoKolmoset(kasi)) {
            return 3;
        }
        if(onkoKaksiParia(kasi)) {
            return 2;
        }
        if(onkoPari(kasi)) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Metodi kertoo arvot, joita on monta kädessä
     * 
     * @param kasi Tarkasteltava käsi
     * @param maara Toistuvan arvon määrä
     * 
     * @return toistuvien arvojen lista
     */
    public ArrayList<Integer> monenSamanArvot(Kasi kasi, int maara) {
        HashMap<Integer, Integer> kadenKartta = kuinkaMontaSamaaMap(kasi);
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

        for(Integer avain : kadenKartta.keySet()) {
            int avaimenArvo = kadenKartta.get(avain);
            
            if(avaimenArvo != maara &&
                    avaimenArvo == maara - kuinkaMontaJokeriaKadessa(kasi)) {
                for(Integer vertailuAvain : kadenKartta.keySet()) {
                    int vertailuArvo = kadenKartta.get(vertailuAvain);

                    if(vertailuArvo == maara - kuinkaMontaJokeriaKadessa(kasi)) {
                        if(avain < vertailuAvain) {
                            kadenArvot.add(vertailuAvain);

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
     * Metodi kertoo, kummassa kädessä on parempi suuri kortti
     * 
     * @param kasi Tarkasteltava käsi
     * @param kasi2 Tarkasteltava käsi
     * 
     * @return 1, jos ensimmäisessä kädessä on suurempi kortti /
     *         -1, jos toisessa kädessä on suurempi kortti /
     *         0, jos käsissä on yhtäsuuret kortit
     */
    public int parempiSuuriKortti(Kasi kasi, Kasi kasi2) {
        kasi.kaannaJarjestys();
        kasi2.kaannaJarjestys();
        
        ArrayList<Kortti> kortit = kasi.getKortit();
        ArrayList<Kortti> kortit2 = kasi2.getKortit();
        
        for(int i = 0; i < kortit.size(); i++) {
        
            if(kortit.get(i).getArvo() > kortit2.get(i).getArvo()) {
                return 1;
                
            }
            else if(kortit.get(i).getArvo() < kortit2.get(i).getArvo()) {
                return -1;
                
            }
        }
        return 0;
    }
    
    /**
     * Metodi kertoo kummassa kädessä on paremmat kaksi paria
     * 
     * @param kasi Tarkasteltava käsi
     * @param kasi2 Tarkasteltava käsi
     * 
     * @return 1, jos ensimmäisessä kädessä on paremmat kaksi paria /
     *         -1, jos toisessa kädessä on paremmat kaksi paria /
     *         0, jos käsissä on yhtä hyvät kaksi paria
     */
    public int parempiKaksiParia(Kasi kasi, Kasi kasi2) {
        ArrayList<Integer> ensimmaisenKadenArvot = monenSamanArvot(kasi, 2);
        ArrayList<Integer> toisenKadenArvot = monenSamanArvot(kasi2, 2);
        
        int ensimmaisenSuurinArvo = Collections.max(ensimmaisenKadenArvot);
        int toisenSuurinArvo = Collections.max(toisenKadenArvot);
        
        int ensimmaisenPieninArvo = Collections.min(ensimmaisenKadenArvot);
        int toisenPieninArvo = Collections.min(toisenKadenArvot);
        
        
        if(ensimmaisenSuurinArvo > toisenSuurinArvo) {
            return 1;
            
        }
        else if(ensimmaisenSuurinArvo < toisenSuurinArvo) {
            return -1;
            
        }else{
            if(ensimmaisenPieninArvo > toisenPieninArvo) {
                return 1;
            
            }
            else if(ensimmaisenPieninArvo < toisenPieninArvo) {
                return -1;
                
            }else{
                int kadenExtraArvo = getExtraKortinArvo(kasi);
                int kaden2ExtraArvo = getExtraKortinArvo(kasi2);
                
                if(kadenExtraArvo > kaden2ExtraArvo) {
                    return 1;
                    
                }
                if(kadenExtraArvo < kaden2ExtraArvo) {
                    return -1;
                    
                }
                return 0;
            }
        }
    }
    
    /**
     * Metodi kertoo ylimääräisen kortin arvon
     * 
     * @param kasi Tarkasteltava käsi
     * 
     * @return kortin arvo
     */
    public int getExtraKortinArvo(Kasi kasi) {
        HashMap<Integer, Integer> samat = kuinkaMontaSamaaMap(kasi);
        int kortinArvo = 0;
        
        for(Integer avain : samat.keySet()) {
            if(samat.get(avain) == 1) {
                kortinArvo = avain;
            }
        }
        return kortinArvo;
    }
    
    /**
     * Metodi kertoo, kummassa kädessä on paremmat monta samaa
     * 
     * @param kasi Tarkasteltava käsi
     * @param kasi2 Tarkasteltava käsi
     * @param maara Kuinka monta samaa
     * 
     * @return 1, jos ensimmäisessä kädessä on paremmat monta samaa /
     *         -1, jos toisessa kädessä on paremmat monta samaa /
     *         0, jos käsissä on yhtä hyvät monta samaa
     */
    public int parempiMontaSamaa(Kasi kasi, Kasi kasi2, int maara) {
        ArrayList<Integer> ensimmaisenKadenArvot = monenSamanArvot(kasi, maara);
        ArrayList<Integer> toisenKadenArvot = monenSamanArvot(kasi2, maara);
        
        if(ensimmaisenKadenArvot.get(0) > toisenKadenArvot.get(0)) {
            return 1;
        }
        if(toisenKadenArvot.get(0) > ensimmaisenKadenArvot.get(0)) {
            return -1;
        }
        
        return 0;
    }
    
    /**
     * Metodi kertoo, kummassa kädessä on parempi suora tai väri
     * 
     * @param kasi Tarkasteltava käsi
     * @param kasi2 Tarkasteltava käsi
     * 
     * @return 1, jos ensimmäisessä kädessä on parempi suora tai väri /
     *         -1, jos toisessa kädessä on parempi suora tai väri /
     *         0, jos käsissä on yhtä hyvät suorat tai värit
     */
    public int parempiSuoraTaiVari(Kasi kasi, Kasi kasi2) {
        kasi.jarjestaKortit();
        kasi2.jarjestaKortit();
        
        ArrayList<Kortti> kortit = kasi.getKortit();
        ArrayList<Kortti> kortit2 = kasi2.getKortit();
        
        ArrayList<Integer> maat = kasi.getMaat();
        ArrayList<Integer> maat2 = kasi2.getMaat();
        
        if(kortit.get(0).getArvo() > kortit2.get(0).getArvo()) {
            return 1;
            
        }
        else if(kortit.get(0).getArvo() < kortit2.get(0).getArvo()) {
            return -1;
            
        }else{
            if(maat.contains(Kortti.JOKERI) &&  
                    !maat2.contains(Kortti.JOKERI)) {
                return -1;
            } 
            if(!maat.contains(Kortti.JOKERI) &&  
                    maat2.contains(Kortti.JOKERI)) {
                return 1;
            }
//            if(kortit.get(0).getMaa() > kortit2.get(0).getMaa()) {
//                return 1;
//                
//            }else{
//                return -1;
//                
//            }
            return 0;
        }
    }
    
    /**
     * Metodi kummassa kädessä on parempi täyskäsi
     * 
     * @param kasi Tarkasteltava käsi
     * @param kasi2 Tarkasteltava käsi
     * 
     * @return 1, jos ensimmäisessä kädessä on parempi täyskäsi /
     *         -1, jos toisessa kädessä on parempi täyskäsi /
     *         0, jos käsissä on yhtä hyvät tayskädet
     */
    public int parempiTayskasi(Kasi kasi, Kasi kasi2) {
        ArrayList<Integer> ensimmaisenKadenArvot = monenSamanArvot(kasi, 3);
        ArrayList<Integer> toisenKadenArvot = monenSamanArvot(kasi2, 3);
        
        int ensimmaisenArvo = ensimmaisenKadenArvot.get(0);
        int toisenArvo = toisenKadenArvot.get(0);
        
        
        if(ensimmaisenArvo > toisenArvo) {
            return 1;
            
        }
        else if(ensimmaisenArvo < toisenArvo) {
            return -1;
            
        }else{
            return parempiKaksiParia(kasi, kasi2);
            
        }
        
    }
    
    /**
     * Metodi hakee pakan päällimmäisen kortin
     * 
     * @return pakan päällimmäinen kortti
     */
    public Kortti getKorttiPakasta() {
        return pakka.getPaallimmainen();
    }
    
    /**
     * Metodi vaihtaa kädessä olevan kortin
     * 
     * @param kasi Tarkasteltava käsi
     * @param kortti Vaihdettava kortti
     * @param mones Vaihdettavan kortin indeksi
     */
    public void vaihdaKortti(Kasi kasi, Kortti kortti, int mones) {
        ArrayList<Kortti> kortit = kasi.getKortit();
        
        if(mones < kortit.size() && mones > -1) {
            
            avoPakanKortti = kortit.get(mones);
            
            kortit.remove(mones);
            kortit.add(mones, kortti);
            
            kortti.kaannaKortti();
        }
    }
    
    /**
     * Metodi vaihtaa kädessä olevan kortin avopakan kortin kanssa
     * 
     * @param kasi Tarkasteltava käsi
     * @param mones Vaihdettavan kortin indeksi
     */
    public void vaihdaAvoPakanKanssa(Kasi kasi, int mones) {
        vaihdaKortti(kasi, avoPakanKortti, mones);
//        ArrayList<Kortti> kortit = kasi.getKortit();
//        
//        if(mones < kortit.size()) {
//            Kortti apuKortti = kopioiKortti(avoPakanKortti);
//            
//            avoPakanKortti = kortit.get(mones);
//            kortit.add(mones, apuKortti); 
//            
//            apuKortti.kaannaKortti();
//        }
    }
    
    /**
     * Metodi vaihtaa kädessä olevan kortin 
     * suljetun pakan päällimmäisen kortin kanssa
     * 
     * @param kasi Tarkasteltava käsi
     * @param kortti Vaihdettava kortti
     * @param mones Vaihdettavan kortin indeksi
     */
    public void vaihdaPakanKanssa(Kasi kasi, Kortti kortti, int mones) {
        vaihdaKortti(kasi, kortti, mones);
//        ArrayList<Kortti> kortit = kasi.getKortit();
//        
//        if(mones < kortit.size()) {
//            Kortti apuKortti = kopioiKortti(kortti);
//            
//            avoPakanKortti = apuKortti;
//            kortit.add(mones, apuKortti);
//            
//            apuKortti.kaannaKortti();
//            
//        }
    }
    
    /**
     * Metodi hakee avopakan päällimmäisen kortin
     * 
     * @return päällimmäinen kortti
     */
    public Kortti getAvopakanPaallimmainen() {
        return avoPakanKortti;
    }
    
    /**
     * Metodi kopioi kortin
     * 
     * @param kortti Kopioitava kortti
     * 
     * @return kopioitu kortti
     */
    public Kortti kopioiKortti(Kortti kortti) {
        return new Kortti(kortti.getArvo(), kortti.getMaa());
    }
    
}
