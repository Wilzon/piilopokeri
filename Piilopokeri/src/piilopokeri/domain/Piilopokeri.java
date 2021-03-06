package piilopokeri.domain;

import java.util.ArrayList;

/** @author Wilzon */

public class Piilopokeri {
    /**
     * Pokerin pakka
     */
    private Korttipakka pakka;
    
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
    private final ArrayList<Pelaaja> pelaajat;
    
    /**
     * Lista pelaajien käsistä
     */
    private final ArrayList<Kasi> kadet;
    
    private boolean poistettiinkoJokerit;
    
    public Piilopokeri() {
        pakka = new Korttipakka();
        pelaajat = new ArrayList();
        kadet = new ArrayList();
        
        poistettiinkoJokerit = false;
        
        pakka.sekoitaKortit();
        
        avoPakanKortti = pakka.getPaallimmainen();
        pakanPaallimmainen = pakka.getPaallimmainen();
        
        avoPakanKortti.kaannaKortti();
        pakanPaallimmainen.kaannaKortti();
        
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
        
        poistettiinkoJokerit = true;
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
    
    public ArrayList<Pelaaja> getTietytPelaajat(boolean onkoKone) {
        ArrayList<Pelaaja> tietytPelaajat = new ArrayList();
        
        for(Pelaaja pelaaja : pelaajat) {
            if((!pelaaja.onkoKone() && !onkoKone) || (pelaaja.onkoKone() && onkoKone)) {
                tietytPelaajat.add(pelaaja);
                
            }
        }
        return tietytPelaajat;
    }
    
    public ArrayList<Pelaaja> getIhmisPelaajat() {
        return getTietytPelaajat(false);
    }
    
    public ArrayList<Pelaaja> getKonePelaajat() {
        return getTietytPelaajat(true);
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
        avoPakanKortti.kaannaKortti();
        
        return avoPakanKortti;
    }

    public Kortti getPakanPaallimmainen() {
        pakanPaallimmainen = pakka.getPaallimmainen();
        
        pakanPaallimmainen.kaannaKortti();
        
        return pakanPaallimmainen;
    }
    
    public Kortti vaihdaKorttiAutomaattisesti(Kasi kasi, Kortti kortti) {
        ArrayList<Kortti> kortit = kasi.getKortit();
        
        for(int i = 0; i < kortit.size(); i++) {
            if(!kortit.get(i).onkoKaannetty()) {
                Kortti vanhaKortti = kortti.kopioiKortti();
                
                avoPakanKortti = kortit.get(i);
                
                kortit.remove(i);
                kortit.add(i, kortti);
                
                kortti.kaannaKortti();
                vanhaKortti.kaannaKortti();
                
                return vanhaKortti;
            }
        }
        return null;
    }
    
    public Kortti vaihdaAvopakanKanssaAutomaattisesti(Kasi kasi) {
        return vaihdaKorttiAutomaattisesti(kasi, avoPakanKortti);
    }
    
    public Kortti vaihdaSuljetunPakanKanssaAutomaattisesti(Kasi kasi) {
        Kortti vanhaKortti = vaihdaKorttiAutomaattisesti(kasi, pakanPaallimmainen);
        
        getPakanPaallimmainen();
        
        return vanhaKortti;
    }
    
    public boolean koneVaihtaaAvopakanKanssaJosKannattavaa(Kasi kasi) {
        int avoPakanArvo = avoPakanKortti.getArvo();
        
        if(avoPakanArvo > 9 || kasi.getArvot().contains(avoPakanArvo)) {
            vaihdaAvopakanKanssaAutomaattisesti(kasi);
            return true;
            
        }
        return false;
    }
    
    public void koneVaihtaaPakanKanssaTaiKaantaaKortin(Kasi kasi) {
        int pakanPaallimmaisenArvo = pakanPaallimmainen.getArvo();
        
        if(pakanPaallimmaisenArvo > 9 || kasi.getArvot().contains(pakanPaallimmaisenArvo)) {
            vaihdaSuljetunPakanKanssaAutomaattisesti(kasi);
            
        }else{
            koneKaantaaKortin(kasi);
        }
    }
    
    public Kortti koneKaantaaKortin(Kasi kasi) {
        for(Kortti kortti : kasi.getKortit()) {
            if(!kortti.onkoKaannetty()) {
                kortti.kaannaKortti();
                
                avoPakanKortti = pakanPaallimmainen;
                getPakanPaallimmainen();
                
                return kortti;
            }
        }
        return null;
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
                kone.arvoUusiNimi();
                
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
    
    public void poistaPelaajat() {
        pelaajat.clear();
    }

    public void luoUusiPakka() {
        pakka = new Korttipakka();
        
        if(poistettiinkoJokerit) {
            pakka.poistaJokerit();
        }
        
        sekoitaPakka();
    }
    
    public void poistaKonePelaajat() {
        pelaajat.removeAll(getKonePelaajat());
    }
    
    public void poistaIhmisPelaajat() {
        pelaajat.removeAll(getIhmisPelaajat());
    }
    
    public void poistaKadet() {
        for(Pelaaja pelaaja : pelaajat) {
            pelaaja.poistaKasi();

        }
        kadet.clear();
    }
    
    public void tallennaPeliTiedot() {
        
    }
}
