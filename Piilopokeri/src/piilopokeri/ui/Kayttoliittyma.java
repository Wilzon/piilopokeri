package piilopokeri.ui;

import java.util.ArrayList;
import java.util.Scanner;
import piilopokeri.domain.KadenArvostelija;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.KasienVertailija;
import piilopokeri.domain.Kone;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Pelaaja;

/** @author Wilzon */

public class Kayttoliittyma {
    private Scanner lukija;
    private Piilopokeri pokeri;
    private ArrayList<Kasi> kadet;
    private ArrayList<Pelaaja> pelaajat;
    private int monesPelaaja;
    private int korttiMaara;
    private boolean lopettaaKesken;
    private Kortti pakanPaallimmainen;
    private Pelaaja pelaajaVuorossa;

    public Kayttoliittyma() {
        
        String lue = "1\n"
                + "e\n"
                + "0\n"
                + "2\n"
                + "5\n";
        
        String luettava = "1\n"
                + "2\n"
                + "5\n"
                + "2\n"
                + "1\n"
                + "2\n"
                + "1\n"
                + "2\n"
                + "2\n"
                + "2\n"
                + "2\n"
                + "2\n"
                + "3\n"
                + "2\n"
                + "3\n"
                + "2\n"
                + "4\n"
                + "2\n"
                + "4\n"
                + "2\n"
                + "5\n"
                + "2\n"
                + "5\n";
        
        this.lukija = new Scanner(lue);
        pokeri = new Piilopokeri();
        monesPelaaja = 0;
        kadet = pokeri.getKadet();
        pelaajat = pokeri.getPelaajat();
    }
    
    /**
     * Metodissa on pelin valikkotoiminnallisuus
     */
    public void kaynnista() {
        System.out.println("\nPiilopokeri!");
        
        while(true) {
            
            tulostaValikkoKomennot();

            int komento = kysyNumero();
            
            if(komento == 2) {
                System.out.println("\nPeli lopetettu!");
                break;
                
            }else{
                hoidaValikkoKomento(komento);
                break;
            }
        }
    }
    
    /**
     * Metodissa on pelitoiminnallisuus
     */
    public void aloitaPeli() {
        while(true) {
            jarjestaKortit();
            
            pelaajaVuorossa = pelaajat.get(monesPelaaja);
            
            pokeri.tulostaPelikentta();
            
            if(peliLoppu()) {
                pelinLoppuTulostus();
                break;
                
            }
            System.out.println("\nPelaajan " + pelaajaVuorossa.getNimi() + " vuoro!");

            if(!pelaajaVuorossa.onkoKone()) {
            
                kysyJarjestys();

                tulostaPeliKomennot();

                int komento = kysyNumero();

                hoidaPeliKomento(komento);

            }else{
                pokeri.koneKayttaaVuoron(pelaajaVuorossa.getKasi());
                
                System.out.println(pelaajaVuorossa.getNimi() + " on tehnyt vuoronsa!");
                
            }
            pelaajaVuorossa.setVuoro();
            
            monesPelaaja++;
            
            if(monesPelaaja == pelaajat.size()) {
                monesPelaaja = 0;
                
            }
            if(lopettaaKesken) {
                break;
            }
        }
    }
    
    /**
     * Metodi järjestää kortit haluttuun järjestykseen
     */
    public void jarjestaKortit() {
        for(Pelaaja pelaaja : pelaajat) {
            Kasi pelaajanKasi = pelaaja.getKasi();

            if(pelaaja.getHaluttuJarjestys() == 1) {
                pelaajanKasi.kaannaJarjestys();
                
            }
            if(pelaaja.getHaluttuJarjestys() == 2) {
                pelaajanKasi.jarjestaKortit();
                
            }
        }
    }
    
    /**
     * Metodi kysyy halutun korttijärjestyksen
     */
    public void kysyJarjestys() {
        if(pelaajaVuorossa.onkoEnsimmainenVuoro()) {
            System.out.println("\nMiten haluat pitää korttisi järjestyksessä?"
                    + "\n1. Suurimmasta pienimpään"
                    + "\n2. Pienimmästä suurimpaan"
                    + "\n3. Sekasorto");
            
            while(true) {
                int vastaus = kysyNumero();

                if(vastaus > 0 && vastaus < 4) {
                    break;
                    
                }else{
                    System.out.println("\nValitse 1-3!");
                }
                pelaajaVuorossa.setHaluttuJarjestys(vastaus);
            }   
        }
    }
    
    /**
     * Metodi tulostaa valikon komennot
     */
    public void tulostaValikkoKomennot() {
        System.out.println("\n1. Aloita uusi peli"
                +"\n2. Lopeta"); 
    }
    
    /**
     * Metodi tulostaa pelikomennot
     */
    public void tulostaPeliKomennot() {
        System.out.println("\n1. Näytä pakan päällimmäinen"
                + "\n2. Vaihda kortti avopakan päällimmäiseen"
                + "\n3. Lopeta peli");
    }
    
    /**
     * Metodi hoitaa valikon komennot
     * 
     * @param komento Syötetty komento numero
     */
    public void hoidaValikkoKomento(int komento) {
        while(true) {
            if(komento == 1) {
                pelataankoIlmanJokereita();
                
                ihmisPelaajienAsetus();
                konePelaajienAsetus();
                
                korttienAsetus();
                
                aloitaPeli();
                

            }else{
                System.out.println("\nValitse 1 tai 2!");
                
            }
            break;
        }
    }
    
    /**
     * Metodi hoitaa pelikomennot
     * 
     * @param komento Syötetty komento numero
     */
    public void hoidaPeliKomento(int komento) {
        if(komento == 1) {
            naytaSuljetunPakanPaallimmainen();
            
        }
        else if(komento == 2) {
            vaihdaAvopakanKanssa();
            
        }
        else if(komento == 3) {
            lopetaKesken();
            
        }else{
            monesPelaaja--;
            System.out.println("\nValitse 1-3!");
        }
    }
    
    /**
     * Metodi varmistaa haluaako pelaaja lopettaa pelin kesken ja
     * lopettaa tai jatkaa peliä
     */
    public void lopetaKesken() {
        System.out.println("\nOletko varma, että haluat lopettaa pelin kesken? KYLLÄ/EI");
        
        String vastaus = kysyKyllaVaiEi();
        
        if(vastaus.equals("kyllä")) {
            lopettaaKesken = true;
        }
        if(vastaus.equals("ei")) {
            monesPelaaja--;
        }
    }
    
    /**
     * Metodi näyttää suljetun pakan päällimmäisen kortin ja
     * kysyy haluaako pelaaja vaihtaa siihen vai
     * kääntääkö pelaaja mielummin oman kortin ympäri
     */
    public void naytaSuljetunPakanPaallimmainen() {
        pakanPaallimmainen = pokeri.getPakanPaallimmainen();
        System.out.println("\nPakan päällimmäinen: " + pakanPaallimmainen);
        
        System.out.println("\n1. Vaihda"
                        + "\n2. Käännä oma kortti");
        
        while(true) {
                int korttiKomento = kysyNumero();
                
                if(korttiKomento == 1) {
                    vaihdaSuljetunPakanKanssa();
                    break;
                }
                if(korttiKomento == 2) {
                    kaannaKortti();
                    break;
                }
                System.out.println("\nValitse 1 tai 2!");
            }
    }
    
    /**
     * Metodi vaihtaa pelaajan kortin suljetun pakan kanssa
     */
    public void vaihdaSuljetunPakanKanssa() {
        vaihdaKortti(2);
    }
    
    /**
     * Metodi vaihtaa pelaajan kortin avopakan kanssa
     */
    public void vaihdaAvopakanKanssa() {
        vaihdaKortti(1);
    }
    
    /**
     * Metodi vaihtaa halutun kortin
     * 
     * @param kumpi Vaihdetaanko suljetusta pakasta vai avopakasta
     */
    public void vaihdaKortti(int kumpi) {
        System.out.println("Minkä kortin haluat vaihtaa? (1-" + korttiMaara + ")");
        
        while(true) {
            int mones = kysyNumero() - 1;
            Kasi kasi = kadet.get(monesPelaaja);
            
            if(mones < kasi.getKortit().size() && mones >= 0) {
                Kortti kortti = kadet.get(monesPelaaja).getKortit().get(mones);

                if(!kortti.onkoKaannetty()) {
                    if(kumpi == 1) {
                        pokeri.vaihdaAvoPakanKanssa(kasi, mones);
                        
                        break;

                    }
                    if(kumpi == 2) {
                        pokeri.vaihdaPakanKanssa(kasi, mones);
                        
                        break;
                        
                    }
                }
            }
            System.out.println("Et voi kääntää samaa korttia uudestaan!");
            System.out.println("Syötä arvo 1-" + korttiMaara);
        }
    }
    
    /**
     * Metodi kääntää halutun kortin oikeinpäin
     */
    public void kaannaKortti() {
        System.out.println("Minkä kortin haluat kääntää? (1-" + korttiMaara + ")");
        
        while(true) {
            int mones = kysyNumero() - 1;
            
            if(pokeri.kaannaKortti(kadet.get(monesPelaaja), mones)) {
                break;
                
            }
            System.out.println("Et voi kääntää samaa korttia uudestaan!");
            System.out.println("Syötä arvo 1-" + korttiMaara);
        }
    }
    
    /**
     * Metodi kysyy numeroa
     * 
     * @return Syötetty numero, mutta väärällä syötteellä -1
     */
    public int kysyNumero() {
        try{
           int komento = Integer.parseInt(lukija.nextLine());
           return komento;
           
        }catch (NumberFormatException e) {
            return -1;
            
        }
    }
    
    /**
     * Metodi kysyy kyllä tai ei kysymyksen
     * 
     * @return Syötetty vastaus
     */
    public String kysyKyllaVaiEi() {
        String vastaus = "";
        
        while(true) {
            vastaus = lukija.nextLine().trim();
            
            if(vastaus.equalsIgnoreCase("kyllä") ||
                    vastaus.equalsIgnoreCase("k") ||
                    vastaus.equalsIgnoreCase("kylla")) {
                vastaus = "kyllä";
                
            }
            if(vastaus.equalsIgnoreCase("ei") ||
                    vastaus.equalsIgnoreCase("e")) {
                vastaus = "ei";
                
            }
            
            if(vastaus.equalsIgnoreCase("kyllä")) {
                break;
                
            }
            else if(vastaus.equalsIgnoreCase("ei")) {
                break;
                
            }else{
                System.out.println("Syötä KYLLÄ tai EI!");
                
            }
        }
        return vastaus;
    }
    
    /**
     * Metodi tulostaa pelin loppuessa voittajan ja
     * kaikkien käsien arvot
     */
    public void pelinLoppuTulostus() {
        Kasi voittajaKasi = KasienVertailija.parasKasi(kadet);
        Pelaaja voittaja = new Pelaaja();
        Pelaaja voittaja2 = new Pelaaja();
        
        
        boolean tasapeli = false;

        for(int i = 0; i < pelaajat.size(); i++) {
            Pelaaja pelaaja = pelaajat.get(i);
            if(voittajaKasi.equals(pelaaja.getKasi())) {
                voittaja = pelaaja;
                
                for(int j = i + 1; j < pelaajat.size(); j++) {
                    Pelaaja verrattavaPelaaja = pelaajat.get(j);
                    if(KasienVertailija.parempiKasi(voittajaKasi, verrattavaPelaaja.getKasi()) == 0) {
                        voittaja2 = verrattavaPelaaja;
                        tasapeli = true;
                    }
                }
            }
        }
        tulostaKasienArvot();
        
        if(tasapeli) {
            System.out.println("\nTasapeli!");
            System.out.println("Pelaajilla " + voittaja.getNimi() + 
                    " ja " + voittaja2.getNimi() + " on yhtä hyvät kädet!");
            
        }else{
            System.out.println("\n" + voittaja.getNimi() + " voitti!");
        }
    }
    
    /**
     * Metodi kysyy halutaanko pelata jokereilla vai ilman ja
     * poistaa jokerit pakasta, jos niin halutaan
     */
    public void pelataankoIlmanJokereita() {
        System.out.println("Haluatko pelata ilman jokereita? KYLLÄ/EI");
        
        String vastaus = kysyKyllaVaiEi();
        
        if(vastaus.equals("kyllä")) {
            pokeri.poistaJokeritPakasta();
        }
    }
    
    /**
     * Metodi kysyy haluttua pelaajamäärää ja
     * lisää pelaajat peliin
     */
    public void ihmisPelaajienAsetus() {
        String kysymys = "\nKuinka monta ihmispelaajaa? (0-25)";
        String varoitus = "\nSyötä luku 1-25!";
        
        int maara = asetaPelaajatTaiKortit(25, 0, kysymys, varoitus);
        
        lisaaIhmisPelaajat(maara);
    }
    
    /**
     * Metodi kysyy haluttua konepelaajamäärää ja
     * lisää konepelaajat peliin
     */
    public void konePelaajienAsetus() {
        int maxMaara = 25 - pelaajat.size();
        
        String kysymys = "\nKuinka monta konepelaajaa? (0-" + maxMaara + ")";
        String varoitus = "\nSyötä luku 0-" + maxMaara;
        
        int maara = asetaPelaajatTaiKortit(maxMaara, 0, kysymys, varoitus);
        
        lisaaKonePelaajat(maara);
    }
    
    /**
     * Metodi lisää halutun määrän ihmispelaajia
     * 
     * @param maara Haluttu määrä ihmispelaajia
     */
    public void lisaaIhmisPelaajat(int maara) {
        for(int i = 1; i <= maara; i++) {
            String nimi = kysyPelaajanNimea(i);
            pokeri.lisaaIhmispelaaja(new Pelaaja(nimi));
            
        }
    }
    
    /**
     * Metodi lisää halutun määrän konepelaajia
     * 
     * @param maara Haluttu määrä konepelaajia
     */
    public void lisaaKonePelaajat(int maara) {
        for(int i = 1; i <= maara; i++) {
            pokeri.lisaaKonepelaaja(new Kone());
            
        }
    }
    
    /**
     * Metodi asettaa pelaajat
     * 
     * @param maxMaara Suurin mahdollinen määrä
     * @param minMaara Pienin mahdollinen määrä
     * @param kysymys Kysymysmerkkijono
     * @param varoitus Varoitusmerkkijono syötteen ollessa väärä
     * 
     * @return Haluttu määrä
     */
    public int asetaPelaajatTaiKortit(int maxMaara, int minMaara, String kysymys, String varoitus) {
        int maara;
        
        System.out.println(kysymys);

        while(true) {
            maara = kysyNumero();
            
            if(maara <= maxMaara && maara >= minMaara) {
                break;
                
            }else{
                System.out.println(varoitus);
            }
        }
        return maara;
    }
    /**
     * Metodi kysyy haluttua korttimäärää ja
     * lisää ne kaikkii käsiin
     */
    public void korttienAsetus() {
        int maxMaara = pokeri.getPakka().size() / pelaajat.size() / 2;
        
        String kysymys = "\nKuinka monta korttia yhdessä kädessä? (1-" + maxMaara + ")";
        String varoitus = "\nSyötä luku 1-" + maxMaara + "!";
        
        int maara = asetaPelaajatTaiKortit(maxMaara, 1, kysymys, varoitus);
        
        lisaaKortit(maara);
    }
    
    /**
     * Metodi lisää halutun määrän kortteja kaikkiin käsiin
     * 
     * @param maara Haluttu korttimäärä
     */
    public void lisaaKortit(int maara) {
        korttiMaara = maara;

        for(int i = 0; i < pelaajat.size(); i++) {
            Pelaaja pelaaja = pelaajat.get(i);

            pelaaja.lisaaKasi(pokeri.getUudetKortit(maara));
            pokeri.lisaaPelaajanKasi(pelaaja);

        }
    }
    
    /**
     * Metodi kysyy pelaajan nimeä
     * @param mones Mones pelaaja on kyseessä
     * @return syötetty nimi
     */
    public String kysyPelaajanNimea(int mones) {
        System.out.println("\nSyötä pelaajan " + mones + " nimi! (1-10 merkkiä)");
        
        String nimi = kysyNimi();
        
        return nimi;
    }
    
    public String kysyNimi() {
        String nimi = "";
        
        while(true) {
            nimi = lukija.nextLine();
            
            if(nimi.length() > 0 && nimi.length() < 11) {
                break;
                
            }
            System.out.println("\nSyötä 1-10 merkkiä pitkä nimi!");
        }
        return nimi;
    }
    
    /**
     * Metodi kertoo onko peli loppu
     * @return true, jos peli on loppu, muuten false
     */
    public boolean peliLoppu() {
        ArrayList<Kortti> viimeisenPelaajanKortit = kadet.get(kadet.size() - 1).getKortit();
        
        for(Kortti kortti : viimeisenPelaajanKortit) {
            if(!kortti.onkoKaannetty()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodi tulostaa pelaajan käden arvon
     * 
     * @param pelaaja Pelaaja, jonka käden arvo halutaan selville
     */
    public void tulostaKadenArvo(Pelaaja pelaaja) {
        Kasi kasi = pelaaja.getKasi();
        String pelaajalla = "Pelaajalla " + pelaaja.getNimi() + " on ";
        int kadenArvo = KadenArvostelija.kadenArvo(kasi);
        
        if(kadenArvo == 9) {
            System.out.println(pelaajalla + "vitoset!");
                
        }
        else if(kadenArvo == 8) {
            System.out.println(pelaajalla + "värisuora!");

        }
        else if(kadenArvo == 7) {
            System.out.println(pelaajalla + "neloset!");

        }
        else if(kadenArvo == 6) {
            System.out.println(pelaajalla + "täyskäsi!");

        }
        else if(kadenArvo == 5) {
            System.out.println(pelaajalla + "väri!");

        }
        else if(kadenArvo == 4) {
            System.out.println(pelaajalla + "suora!");

        }
        else if(kadenArvo == 3) {
            System.out.println(pelaajalla + "kolmoset!");

        }
        else if(kadenArvo == 2) {
            System.out.println(pelaajalla + "kaksi paria!");

        }
        else if(kadenArvo == 1) {
            System.out.println(pelaajalla + "pari!");

        }else{
            System.out.println("Pelaajalla " + pelaaja.getNimi() + " ei ole mitään!");
        }
    }
    
    /**
     * Metodi tulostaa kaikkien käsien arvot
     */
    public void tulostaKasienArvot() {
        for(int i = 0; i < pelaajat.size(); i++) {
            System.out.println();
            tulostaKadenArvo(pelaajat.get(i));
        }
    }
    
    
}
