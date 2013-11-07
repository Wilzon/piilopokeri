package piilopokeri.domain;

public class Kortti implements Comparable<Kortti>{
    private final int arvo;
    private final int maa;
    private boolean kaannetty;
    
    public static final int JOKERI = 4;
    public static final int HERTTA = 3;
    public static final int RUUTU = 2;
    public static final int RISTI = 1;
    public static final int PATA = 0;
    
    public static final String[] MAAT = {"Pata", "Risti", "Ruutu", "Hertta", ""};
    public static final String[] ARVOT = {"-", "-", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "Jokeri"};
   
    
    public Kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
        kaannetty = false;
    }

    public int getMaa() {
        return maa;
    }
    
    public String getMaaMerkkijonona() {
        return MAAT[maa];
    }

    public int getArvo() {
        return arvo;

    }
    
    public void kaannaKortti() {
        kaannetty = true;
    }
    
    public boolean onkoKaannetty() {
        return kaannetty;
    }

    @Override
    public String toString() {
        if(arvo == 15) {
            return ARVOT[arvo];
        }
        return MAAT[maa] + " " + ARVOT[arvo];
    }

    @Override
    public int compareTo(Kortti verrattava) {
        if (arvo == verrattava.getArvo()) {
            return maa - verrattava.getMaa();
        }
        return arvo - verrattava.getArvo();
    }
 }
