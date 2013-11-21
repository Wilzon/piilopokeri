package piilopokeri.domain;

import java.util.ArrayList;
import java.util.Collections;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kone;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttipakka;
import piilopokeri.domain.Pelaaja;

/** @author Wilzon */

public class Piilopokeri {
    /**
     * Pokerin pakka
     */
    private final Korttipakka pakka;
    
    /**
     * Avopakan päällimmäinen kortti
     */
    private Kortti avoPakanKortti;
    
    /**
     * Pakan päällimmäinen kortti
     */
    private Kortti pakanPaallimmainen;
    
    /**
     * Lista pelaajista
     */
    ArrayList<Pelaaja> pelaajat;
    
    /**
     * Lista pelaajien käsistä
     */
    ArrayList<Kasi> kadet;
    
    /**
     * Metodi nostaa pakasta kortteja käteen
     * 
     * @param  maara Korttien lukumäärä
     * 
     * @return uusi kasi
     */
    
    public Piilopokeri() {
        pakka = new Korttipakka();
        pelaajat = new ArrayList();
        kadet = new ArrayList();
        
        pakka.sekoitaKortit();
        avoPakanKortti = pakka.getPaallimmainen();
        pakanPaallimmainen = pakka.getPaallimmainen();
        
    }
    
    /**
     * Metodi luo uuden käden ja nostaa halutun määrän kortteja käteen
     * 
     * @param maara Haluttu korttimäärä
     * 
     * @return luotu käsi
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
     * Metodi lisää pelaajan pelaajalistaan
     * 
     * @param pelaaja Pelaaja, joka halutaan lisätä
     */
    public void lisaaIhmispelaaja(Pelaaja pelaaja) {
        pelaajat.add(pelaaja);
    }
    
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    /**
     * Metodi lisää pelaajan käden kädet listaan
     * 
     * @param pelaaja Pelaaja, jonka käsi halutaan lisätä
     */
    public void lisaaPelaajanKasi(Pelaaja pelaaja) {
        kadet.add(pelaaja.getKasi());
    }
    
    public ArrayList<Kasi> getKadet() {
        return kadet;
    }
    
    /**
     * Metodi tulostaa pelikentän, jossa on pakka ja kädet
     */
    public void tulostaPelikentta() {
        //EI VALMIS
        
        int mones = 0;
        int montaRivia = kadet.size() * 3 + 2;
        int pituus = 72;
        String reunat = lisaaRivi(pituus, "*");
                
        System.out.println(reunat);
        
        for(int i = 0; i < montaRivia; i++) {
            String rivi = "";
            
            if(i % 3 == 0  && i != 0) {
                
                String pelaajaMerkkijono = pelaajat.get(mones).getNimi() + ": " + kadet.get(mones);

                int tyhjanPituus = reunat.length() - pelaajaMerkkijono.length() - 5;
                
                rivi += lisaaTyhjaaAlkuun(5);
                rivi += pelaajaMerkkijono;
                rivi += lisaaTyhjaaLoppuun(tyhjanPituus);

                mones++;
                
            }
            else if(i == 1) {
                int pakkaRivinPituus = avoPakanKortti.toString().length() + 5;
                int alunTyhja = (reunat.length() - pakkaRivinPituus) / 2;
                int lopunTyhja = reunat.length() - alunTyhja - pakkaRivinPituus;
                
                rivi += lisaaTyhjaaAlkuun(alunTyhja);
                String pakkaRivi = avoPakanKortti + "  [X]";
                rivi += avoPakanKortti + "  [X]";
                
                
                rivi += lisaaTyhjaaLoppuun(lopunTyhja);
                
            }else{
                rivi = lisaaRivi(pituus, " ");
                
            }
            System.out.println(rivi);
        }
        System.out.println(reunat);
        
    }
    
    /**
     * Metodi lisää tyhjää rivin loppuun
     * 
     * @param tyhja Rivin tyhjän määrä
     * 
     * @return muokattu rivi
     */
    public String lisaaTyhjaaAlkuun(int tyhja) {
        String rivi = ("*");
        
        for(int i = 0; i < tyhja; i++) {
            rivi += " ";
        }
        return rivi;
    }
    
    /**
     * Metodi lisää oikean määrän tyhjää rivin loppuun
     * 
     * @param tyhja Rivin tyhjän määrä
     * 
     * @return muokattu rivi
     */
    public String lisaaTyhjaaLoppuun(int tyhja) {
        String rivi = "";
        
        for(int i = 0;i < tyhja - 2; i++) {
            rivi += " ";
        }
        rivi += "*";
        
        return rivi;
    }
    
    public String lisaaRivi(int pituus, String lisattava) {
        String rivi = "*";
        
        for(int i = 0; i < pituus - 2; i++) {
            rivi += lisattava;
            
        }
        if(pituus % 2 != 0) {
            rivi += lisattava;
            
        }
        rivi += "*";
        
        return rivi;
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
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(2);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(2);
        
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
                int kadenExtraArvo = kasi.getExtraKortinArvo();
                int kaden2ExtraArvo = kasi2.getExtraKortinArvo();
                
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
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(maara);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(maara);
        
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
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(3);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(3);
        
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
     * Metodi vaihtaa kädessä olevan kortin
     * 
     * @param kasi Tarkasteltava käsi
     * @param kortti Vaihdettava kortti
     * @param mones Vaihdettavan kortin indeksi
     */
    public void vaihdaKortti(Kasi kasi, Kortti kortti, int mones) {
        ArrayList<Kortti> kortit = kasi.getKortit();
        
        if(mones < kortit.size() && mones >= 0) {
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
    }
    
    /**
     * Metodi vaihtaa kädessä olevan kortin 
     * suljetun pakan päällimmäisen kortin kanssa
     * 
     * @param kasi Tarkasteltava käsi
     * @param mones Vaihdettavan kortin indeksi
     */
    public void vaihdaPakanKanssa(Kasi kasi, int mones) {
        vaihdaKortti(kasi, pakanPaallimmainen, mones);
        getPakanPaallimmainen();
    }
    
    public Kortti getAvopakanPaallimmainen() {
        return avoPakanKortti;
    }

    public Kortti getPakanPaallimmainen() {
        pakanPaallimmainen = pakka.getPaallimmainen();
        
        return pakanPaallimmainen;
    }
    
    /**
     * Metodi vertaa kasiä
     * 
     * @param kasi Verrattava kasi
     * @param kasi2 Toinen verrattava kasi
     * 
     * @return 1, jos ensimmainen käsi on parempi /
     *         -1, jos toinen käsi on parempi /
     *         0, jos kadet ovat yhtä hyviä
     */
    public int parempiKasi(Kasi kasi, Kasi kasi2) {
        int kadenArvo = kasi.kadenArvo();
        int kaden2Arvo = kasi2.kadenArvo();
        
        if(kadenArvo > kaden2Arvo) {
            return 1;
            
        }
        else if(kadenArvo < kaden2Arvo) {
            return -1;
                    
        }else{
            if(kadenArvo == 9) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 5);
                return arvo;
                
            }
            else if(kadenArvo == 8) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                return arvo;
                
            }
            else if(kadenArvo == 7) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 4);
                return arvo;
                
            }
            else if(kadenArvo == 6) {
                int arvo = parempiTayskasi(kasi, kasi2);
                return arvo;
                
            }
            else if(kadenArvo == 5) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                return arvo;
                
            }
            else if(kadenArvo == 4) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                return arvo;
                
            }
            else if(kadenArvo == 3) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 3);
                return arvo;
                
            }
            else if(kadenArvo == 2) {
                int arvo = parempiKaksiParia(kasi, kasi2);
                return arvo;
                
            }
            else if(kadenArvo == 1) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 2);
                return arvo;
                
            }else{
                int arvo = parempiSuuriKortti(kasi, kasi2);
                return arvo;
            }
        }
    }
    /**
     * Metodi kertoo, mikä käsistä on arvokkain
     * 
     * @param kadet Lista käsistä
     * 
     * @return paras käsi
     */
    public Kasi parasKasi(ArrayList<Kasi> kadet) {
        for(int i = 0; i < kadet.size() - 1; i += 2) {
            Kasi kasi = kadet.get(i);
            Kasi kasi2 = kadet.get(i + 1);
            
            int arvo = parempiKasi(kasi, kasi2);

            if(arvo == 1) {
                kadet.remove(kasi2);
                
            }
            if(arvo == -1) {
                kadet.remove(kasi);
                
            }
            parasKasi(kadet);
            
        }
        return kadet.get(0);
        
    }
    
    public void vaihdaKoneenKortti(Kasi kasi, Kortti kortti) {
        ArrayList<Kortti> kortit = kasi.getKortit();
        
        for(int i = 0; i < kortit.size(); i++) {
            if(!kortit.get(i).onkoKaannetty()) {
                
                avoPakanKortti = kortit.get(i);
                
                kortit.remove(i);
                kortit.add(i, kortti);
                
                kortti.kaannaKortti();
                
                break;
            }
        }
    }
    
    public void koneVaihtaaAvopakanKanssa(Kasi kasi) {
        vaihdaKoneenKortti(kasi, avoPakanKortti);
    }
    
    public void koneVaihtaaSuljetunPakanKanssa(Kasi kasi) {
        vaihdaKoneenKortti(kasi, pakanPaallimmainen);
        getPakanPaallimmainen();
    }
    
    public boolean koneVaihtaaAvopakanKanssaJosKannattavaa(Kasi kasi) {
        int avoPakanArvo = avoPakanKortti.getArvo();
        
        if(avoPakanArvo > 9 || kasi.getArvot().contains(avoPakanArvo)) {
            koneVaihtaaAvopakanKanssa(kasi);
            return true;
            
        }
        return false;
    }
    
    public void koneVaihtaaPakanKanssaTaiKaantaaKortin(Kasi kasi) {
        int pakanPaallimmaisenArvo = pakanPaallimmainen.getArvo();
        
        if(pakanPaallimmaisenArvo > 9 || kasi.getArvot().contains(pakanPaallimmaisenArvo)) {
            koneVaihtaaSuljetunPakanKanssa(kasi);
            
        }else{
            kaannaKoneenKortti(kasi);
        }
    }
    
    public void kaannaKoneenKortti(Kasi kasi) {
        for(Kortti kortti : kasi.getKortit()) {
            if(!kortti.onkoKaannetty()) {
                kortti.kaannaKortti();
                
                avoPakanKortti = pakanPaallimmainen;
                getPakanPaallimmainen();
                
                break;
            }
        }
    }
    
    public void koneKayttaaVuoron(Kasi kasi) {
        if(!koneVaihtaaAvopakanKanssaJosKannattavaa(kasi)) {
            
            koneVaihtaaPakanKanssaTaiKaantaaKortin(kasi);
        }
    }
    
    public void lisaaKonepelaaja(Kone kone) {
        Pelaaja konePelaaja = kone;
        pelaajat.add(konePelaaja);
    }
    
    public boolean kaannaKortti(Kasi kasi, int mones) {
        if(mones < kasi.getKortit().size() && mones >= 0) {
            Kortti kortti = kasi.getKortit().get(mones);

            if(!kortti.onkoKaannetty()) {
                kortti.kaannaKortti();
                
                avoPakanKortti = pakanPaallimmainen;
                getPakanPaallimmainen();
                
                return true;
                
            }
        }
        return false;
    }    
}
