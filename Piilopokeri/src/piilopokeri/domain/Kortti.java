package piilopokeri.domain;

/** @author Wilzon */

public class Kortti {
    /**
     * Kortin arvo
     */
    private final int arvo;
    
    /**
     * Kortin maa
     */
    private final int maa;
    
    /**
     * Onko kortti käännetty
     */
    private boolean kaannetty;
    
    /**
     * Maan JOKERI/HERTTA/RUUTU/RISTI/PATA arvo
     */
    public static final int PATA = 0;
    public static final int RISTI = 1;
    public static final int RUUTU = 2;
    public static final int HERTTA = 3;
    public static final int JOKERI = 4;
    
    /**
     * Merkkijonoja sisältävä lista mahdollisista maista
     */
    public static final String[] MAAT = {"♠", "♣", "♦", "♥", ""};
    
    /**
     * Merkkijonoja sisältävä lista mahdollisista arvoista
     */
    public static final String[] ARVOT = {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "JOKERI"};
    
    public Kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
        kaannetty = false;
    }

    public Kortti(int arvo, int maa, boolean kaannetty) {
        this(arvo, maa);
        this.kaannetty = kaannetty;
    }
    
    public int getMaa() {
        return maa;
    }
    
    /**
     * Metodi palauttaa maan merkkijonona
     * 
     * @return maa
     */
    public String getMaaMerkkijonona() {
        return MAAT[maa];
    }

    public int getArvo() {
        return arvo;

    }
    
    /**
     * Metodi kääntää kortin oikeinpäin
     */
    public void kaannaKortti() {
        kaannetty = true;
    }
    
    /**
     * Metodi kertoo onko kortti käännetty
     * 
     * @return true, jos kortti on käännetty, muuten false
     */
    public boolean onkoKaannetty() {
        return kaannetty;
    }

    @Override
    public String toString() {
        if(onkoKaannetty()) {
            return ARVOT[arvo] + " " + MAAT[maa] ;
            
        }
        return "[X]";
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }
        if (getClass() != olio.getClass()) {
            return false;
        }
        final Kortti verrattava = (Kortti) olio;
        if (this.arvo != verrattava.arvo) {
            return false;
        }
        return this.maa == verrattava.maa;
    }
    
    /**
     * Metodi kopioi kortin
     * 
     * @return kopioitu kortti
     */
    public Kortti kopioiKortti() {
        return new Kortti(arvo, maa);
    }
    
    
}
