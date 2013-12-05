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
    public Kortti pakanPaallimmainen;
    
    /**
     * Lista pelaajista
     */
    private ArrayList<Pelaaja> pelaajat;
    
    /**
     * Lista pelaajien käsistä
     */
    private ArrayList<Kasi> kadet;
    
    /**
     * Totuusarvo, onko peli loppunut
     */
    private boolean onkoLoppu;
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
        
        onkoLoppu = false;
        
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
    
    public ArrayList<Pelaaja> getIhmisPelaajat() {
        ArrayList<Pelaaja> ihmisPelaajat = new ArrayList();
        
        for(Pelaaja pelaaja : pelaajat) {
            if(!pelaaja.onkoKone()) {
                ihmisPelaajat.add(pelaaja);
            }
        }
        
        return ihmisPelaajat;
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
    
    public String vaihdaKoneenKortti(Kasi kasi, Kortti kortti) {
        ArrayList<Kortti> kortit = kasi.getKortit();
        String vanhaKorttiString = "";
        
        for(int i = 0; i < kortit.size(); i++) {
            if(!kortit.get(i).onkoKaannetty()) {
                vanhaKorttiString = kortit.get(i).toString();
                
                avoPakanKortti = kortit.get(i);
                
                kortit.remove(i);
                kortit.add(i, kortti);
                
                kortti.kaannaKortti();
                
                break;
            }
        }
        return vanhaKorttiString;
    }
    
    public void koneVaihtaaAvopakanKanssa(Kasi kasi) {
        vaihdaKoneenKortti(kasi, avoPakanKortti);
    }
    
    public String koneVaihtaaSuljetunPakanKanssa(Kasi kasi) {
        String vanhaKorttiString = vaihdaKoneenKortti(kasi, pakanPaallimmainen);
        getPakanPaallimmainen();
        
        return vanhaKorttiString;
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
    
    public String kaannaKoneenKortti(Kasi kasi) {
        String korttiString = "";
        for(Kortti kortti : kasi.getKortit()) {
            if(!kortti.onkoKaannetty()) {
                kortti.kaannaKortti();
                
                korttiString = kortti.toString();
                
                avoPakanKortti = pakanPaallimmainen;
                getPakanPaallimmainen();
                
                break;
            }
        }
        return korttiString;
    }
    
    public void koneKayttaaVuoron(Kasi kasi) {
        if(!koneVaihtaaAvopakanKanssaJosKannattavaa(kasi)) {
            
            koneVaihtaaPakanKanssaTaiKaantaaKortin(kasi);
        }
    }
    
    public void lisaaKonepelaaja(Kone kone) {
        Pelaaja konePelaaja = kone;
        
        arvoUusiNimiKoneelle(kone);
        
        pelaajat.add(konePelaaja);
    }
    
    public void arvoUusiNimiKoneelle(Kone kone) {
        for(Pelaaja pelaaja : pelaajat) {
            if(pelaaja.getNimi().equals(kone.getNimi()) && pelaaja != kone) {
                kone.setUusiNimi();
                
                arvoUusiNimiKoneelle(kone);
            }
        }
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
    
    public boolean onkoPeliLoppunut() {
        for(Kortti kortti : pelaajat.get(pelaajat.size() - 1).getKasi().getKortit()) {
            if(!kortti.onkoKaannetty()) {
                return false;
            }
        }
        return true;
    }
}
