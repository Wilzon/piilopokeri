package piilopokeri.apu;

import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttijoukko;


public class MaatJaArvot {
    
    public static boolean onkoOikeatMaat(Korttijoukko testiJoukko) {
        for(Kortti testiKortti : testiJoukko.getKortit()) {

            String merkkijono = testiKortti.toString();
            
            if (!merkkijono.contains("♠") && !merkkijono.contains("♣") && 
                    !merkkijono.contains("♦") && !merkkijono.contains("♥") &&
                    !merkkijono.contains("Jokeri")) {
                
                return false;
            }
        }
        return true;
    }
    
    public static String vaaratMaatViesti(Korttijoukko testiJoukko) {
        return "expected only values \"♥/♦/♣/♠/Jokeri\" but found <" + testiJoukko.getMaatMerkkijonona() + ">";
    }
    
    public static boolean onkoOikeatArvot(Korttijoukko testiJoukko) {
        for(Kortti testiKortti : testiJoukko.getKortit()) {
            if(testiKortti.getArvo() > 15 || testiKortti.getArvo() < 2) {
                
                return false;
            }
        }
        return true;
    }
    
    public static String vaaratArvotViesti(Korttijoukko testiJoukko) {
        return "expected values between 2-15 but found <" + testiJoukko.getArvot() +">";
    }
}
