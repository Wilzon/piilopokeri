
package piilopokeri.domain;

public class KadenArvostelija {
    
    /**
     * Metodi kertoo käden arvon
     * 
     * @param kasi Kasi, jota tarkastellaan
     * 
     * @return Palauttaa sitä suuremman luvun, mitä parempi käsi on
     *         ...
     *         17, jos kädessä on viisi samaa /
     *         12, jos kädessä on värisuora /
     *         8, jos kädessä on neloset /
     *         7, jos kädessä on täyskäsi /
     *         6, jos kädessä on väri /
     *         5, jos kädessä on suora /
     *         3, jos kädessä on kolmoset /
     *         2, jos kädessä on kaksi paria /
     *         1, jos kädessä on pari /
     *         0, jos kädessä ei ole mitään
     */
    public static int kadenArvo(Kasi kasi) {
        if(kasi.getKortit().size() == 1) {
            return 99;
        }
        
        if(kasi.onkoKutosetJaNelosetJaKolmoset()) {
            return 67;
            
        }
        if(kasi.onkoKutosetJaKahdetKolmoset()) {
            return 66;
            
        }
        if(kasi.onkoVitosetJaKahdetNeloset()) {
            return 65;
            
        }
        if(kasi.onkoKutosetJaNelosetJaPari()) {
            return 64;
            
        }
        if(kasi.onkoKutosetJaKolmosetJaKaksiParia()) {
            return 63;
            
        }
        if(kasi.onkoKutosetJaKolmosetJaPari()) {
            return 62;
            
        }
        if(kasi.onkoVitosetJaNelosetJaKolmoset()) {
            return 61;
            
        }
        if(kasi.onkoVitosetJaNelosetJaKaksiParia()) {
            return 60;
            
        }
        if(kasi.onkoKutosetJaNeloset()) {
            return 59;
            
        }
        if(kasi.onkoKolmetNeloset()) {
            return 58;
            
        }
        if(kasi.onkoVitosetJaKahdetKolmosetJaPari()) {
            return 57;
            
        }
        if(kasi.onkoVitosetJaNelosetJaPari()) {
            return 56;
            
        }
        if(kasi.onkoVitosetJaKahdetKolmoset()) {
            return 55;
            
        }
        if(kasi.onkoKahdetNelosetJaKolmosetJaPari()) {
            return 54;
            
        }
        if(kasi.onkoVitosetJaKolmosetJaKaksiParia()) {
            return 53;
            
        }
        if(kasi.onkoVitosetJaNeloset()) {
            return 52;
            
        }
        if(kasi.onkoVitosetJaKolmosetJaPari()) {
            return 51;
            
        }
        if(kasi.onkoKahdetNelosetJaKolmoset()) {
            return 50;
            
        }
        if(kasi.onkoKahdetNelosetJaKaksiParia()) {
            return 49;
            
        }
        if(kasi.onkoKahdetNelosetJaPari()) { 
            return 48;
            
        }
        if(kasi.onkoVitosetJaKolmoset()) {
            return 47;
            
        }
        if(kasi.onkoKahdetNeloset()) {
            return 46;
            
        }
        if(kasi.onkoNelosetJaKolmetKolmoset()) {
            return 45;
            
        }
        if(kasi.onkoNelosetJaKahdetKolmosetJaPari()) {
            return 44;
            
        }
        if(kasi.onkoVitosetJaNeljaParia()) {
            return 43;
            
        }
        if(kasi.onkoNeljatKolmoset()) {
            return 42;
            
        }
        if(kasi.onkoNelosetJaKahdetKolmoset()) {
            return 41;
            
        }
        if(kasi.onkoKolmetKolmosetJaKaksiParia()) {
            return 40;
            
        }
        if(kasi.onkoKutosetJaKolmeParia()) {
            return 39;
            
        }
        if(kasi.onkoKutosetJaKolmoset()) {
            return 38;
            
        }
        if(kasi.onkoNelosetJaKolmosetJaKolmeParia()) {
            return 37;
            
        }
        if(kasi.onkoKutosetJaKaksiParia()) {
            return 36;
            
        }
        if(kasi.onkoVitosetJaKolmeParia()) {
            return 35;
            
        }
        if(kasi.onkoNelosetJaKolmosetJaKaksiParia()) {
            return 34;
            
        }
        if(kasi.onkoKolmetKolmoset()) {
            return 33;
           
        }
        if(kasi.onkoKutosetJaPari()) {
            return 32;
            
        }
        if(kasi.onkoVitosetJaKaksiParia()) {
            return 31;
            
        }
        if(kasi.onkoNelosetJaNeljaParia()) {
            return 30;
            
        }
        if(kasi.onkoKutoset()) {
            return 29;
            
        }
        if(kasi.onkoKahdetKolmosetJaKolmeParia()) {
            return 28;
            
        }
        if(kasi.onkoVitosetJaPari()) {
            return 27;
                    
        }
        if(kasi.onkoNelosetJaKolmosetJaPari()) {
            return 26;
            
        }
        if(kasi.onkoNelosetJaKolmeParia()) {
            return 25;
            
        }
        if(kasi.onkoKolmosetJaViisiParia()) {
            return 24;
            
        }
        if(kasi.onkoKolmosetJaNeljaParia()) {
            return 23;
            
        }
        if(kasi.onkoKuusiParia()) {
            return 22;
            
        }
        if(kasi.onkoKahdetKolmosetJaKaksiParia()) {
            return 21;
            
        }
        if(kasi.onkoNelosetJaKolmoset()) {
            return 20;
            
        }
        if(kasi.onkoNelosetJaKaksiParia()) {
            return 19;
            
        }
        if(kasi.onkoKolmosetJaKolmeParia()) {
            return 18;
            
        }
        if(kasi.onkoVitoset()) {
            return 17;
            
        }
        if(kasi.onkoKahdetKolmosetJaPari()) {
            return 16;
            
        }
        if(kasi.onkoViisiParia()) {
            return 15;
            
        }
        if(kasi.onkoNelosetJaPari()) {
            return 14;
            
        }
        if(kasi.onkoKahdetKolmoset()) {
            return 13;
            
        }
        if(kasi.onkoVarisuora()) {
            return 12;
            
        }
        if(kasi.onkoKolmosetJaKaksiParia()) {
            return 11;
            
        }
        if(kasi.onkoNeljaParia()) {
            return 10;
            
        }
        if(kasi.onkoNelosetJaPari()) {
            return 9;
            
        }
        if(kasi.onkoNeloset()) {
            return 8;
            
        }
        if(kasi.onkoTayskasi()) {
            return 7;
            
        }
        if(kasi.onkoVari()) {
            return 6;
            
        }
        if(kasi.onkoSuora()) {
            return 5;
            
        }
        if(kasi.onkoKolmeParia()) {
            return 4;
            
        }
        if(kasi.onkoKolmoset()) {
            return 3;
            
        }
        if(kasi.onkoKaksiParia()) {
            return 2;
            
        }
        if(kasi.onkoPari()) {
            return 1;
            
        }
        return 0;
    }
    
    /**
     * Metodi huomioi, kuinka suuri käsi vaikuttaa
     * suoraan, väriin ja värisuoraan
     * 
     * @param kasi Kasi, jota tarkastellaan
     * 
     * @return Muokattu käden arvo
     */
    public static int kadenArvoSuurellaKadella(Kasi kasi) {
        int arvo = kadenArvo(kasi);
        
        if(arvo == 12) {
            arvo = 70;
            
        }
        if(arvo == 6) {
            arvo = 69;
            
        }
        if(arvo == 5) {
            arvo = 68;
            
        }
        return arvo;
    }
}