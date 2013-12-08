
package piilopokeri.domain;

import java.util.ArrayList;
import java.util.Collections;

public class KasienVertailija {

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
    public static int parempiKasi(Kasi kasi, Kasi kasi2) {
        int kadenArvo = kasi.kadenArvo();
        int kaden2Arvo = kasi2.kadenArvo();
        
        
        if(kasi.getKortit().size() == 1) {
            kadenArvo = 99;
            kaden2Arvo = 99;
            
        }
        if(kasi.getKortit().size() > 6 && kadenArvo != kaden2Arvo) {
            kadenArvo = kasi.kadenArvoSuurellaKadella();
            kaden2Arvo = kasi2.kadenArvoSuurellaKadella();
            
        }
        if(kadenArvo > kaden2Arvo) {
            return 1;
            
        }
        else if(kadenArvo < kaden2Arvo) {
            return -1;
            
        }else{
            if(kadenArvo == 16) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 5);
                
                return arvo;
                
            } 
            else if(kadenArvo == 13) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 3);
                
                return arvo;
                
            }
            else if(kadenArvo == 12) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                
                return arvo;
                
            } 
            else if(kadenArvo == 11) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 3);
                
                return arvo;
                
            }
            else if(kadenArvo == 10) {
                int arvo = parempiKaksiParia(kasi, kasi2);
                
                return arvo;
                
            }
            else if(kadenArvo == 9) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 4);

                return arvo;
                
            }
            else if (kadenArvo == 8) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 4);
                
                return arvo;
                
            } 
            else if (kadenArvo == 7) {
                int arvo = parempiTayskasi(kasi, kasi2);
                
                return arvo;
                
            } 
            else if (kadenArvo == 6) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                
                return arvo;
                
            } 
            else if (kadenArvo == 5) {
                int arvo = parempiSuoraTaiVari(kasi, kasi2);
                
                return arvo;
                
            } 
            else if(kadenArvo == 4) {
                int arvo = parempiKaksiParia(kasi, kasi2);
                
                return arvo;
                
            }
            else if (kadenArvo == 3) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 3);
                
                return arvo;
                
            } 
            else if (kadenArvo == 2) {
                int arvo = parempiKaksiParia(kasi, kasi2);
                
                return arvo;
                
            } 
            else if (kadenArvo == 1) {
                int arvo = parempiMontaSamaa(kasi, kasi2, 2);
                
                return arvo;
                
            } 
            else {
                int arvo = parempiSuuriKortti(kasi, kasi2);
                
                return arvo;
                
            }
        }
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
    public static int parempiKaksiParia(Kasi kasi, Kasi kasi2) {
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(2);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(2);
        
        int ensimmaisenSuurinArvo = Collections.max(ensimmaisenKadenArvot);
        int toisenSuurinArvo = Collections.max(toisenKadenArvot);
        int ensimmaisenPieninArvo = Collections.min(ensimmaisenKadenArvot);
        int toisenPieninArvo = Collections.min(toisenKadenArvot);
        
        if (ensimmaisenSuurinArvo > toisenSuurinArvo) {
            return 1;
            
        } else if (ensimmaisenSuurinArvo < toisenSuurinArvo) {
            return -1;
            
        } else {
            if (ensimmaisenPieninArvo > toisenPieninArvo) {
                return 1;
                
            } else if (ensimmaisenPieninArvo < toisenPieninArvo) {
                return -1;
                
            } else {
                int kadenExtraArvo = kasi.getExtraKortinArvo();
                int kaden2ExtraArvo = kasi2.getExtraKortinArvo();
                
                if (kadenExtraArvo > kaden2ExtraArvo) {
                    return 1;
                    
                }
                if (kadenExtraArvo < kaden2ExtraArvo) {
                    return -1;
                    
                }
                return 0;
            }
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
    public static int parempiTayskasi(Kasi kasi, Kasi kasi2) {
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(3);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(3);
        
        int ensimmaisenArvo = ensimmaisenKadenArvot.get(0);
        int toisenArvo = toisenKadenArvot.get(0);
        
        if (ensimmaisenArvo > toisenArvo) {
            return 1;
            
        } else if (ensimmaisenArvo < toisenArvo) {
            return -1;
            
        } else {
            return parempiKaksiParia(kasi, kasi2);
            
        }
    }

    /**
     * Metodi kertoo, mikä käsistä on arvokkain
     *
     * @param kadet Lista käsistä
     *
     * @return paras käsi
     */
    public static Kasi parasKasi(ArrayList<Kasi> kadet) {
        for (int i = 0; i < kadet.size() - 1; i += 2) {
            Kasi kasi = kadet.get(i);
            Kasi kasi2 = kadet.get(i + 1);
            
            int arvo = parempiKasi(kasi, kasi2);
            
            if (arvo == 1) {
                kadet.remove(kasi2);
                
            }
            if (arvo == -1) {
                kadet.remove(kasi);
                
            }
            parasKasi(kadet);
        }
        return kadet.get(0);
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
    public static int parempiSuuriKortti(Kasi kasi, Kasi kasi2) {
        kasi.kaannaJarjestys();
        kasi2.kaannaJarjestys();
        
        ArrayList<Kortti> kortit = kasi.getKortit();
        ArrayList<Kortti> kortit2 = kasi2.getKortit();
        
        for (int i = 0; i < kortit.size(); i++) {
            if (kortit.get(i).getArvo() > kortit2.get(i).getArvo()) {
                return 1;
                
            } else if (kortit.get(i).getArvo() < kortit2.get(i).getArvo()) {
                return -1;
                
            }
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
    public static int parempiSuoraTaiVari(Kasi kasi, Kasi kasi2) {
        kasi.jarjestaKortit();
        kasi2.jarjestaKortit();
        
        ArrayList<Kortti> kortit = kasi.getKortit();
        ArrayList<Kortti> kortit2 = kasi2.getKortit();
        
        if (kortit.get(0).getArvo() > kortit2.get(0).getArvo()) {
            return 1;
            
        } else if (kortit.get(0).getArvo() < kortit2.get(0).getArvo()) {
            return -1;
            
        } else {
            return parempiSuuriKortti(kasi, kasi2);
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
    public static int parempiMontaSamaa(Kasi kasi, Kasi kasi2, int maara) {
        ArrayList<Integer> ensimmaisenKadenArvot = kasi.monenSamanArvot(maara);
        ArrayList<Integer> toisenKadenArvot = kasi2.monenSamanArvot(maara);
        
        if (ensimmaisenKadenArvot.get(0) > toisenKadenArvot.get(0)) {
            return 1;
            
        }
        if (toisenKadenArvot.get(0) > ensimmaisenKadenArvot.get(0)) {
            return -1;
            
        }
        return 0;
    }
    
}
