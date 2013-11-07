package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import piilopokeri.domain.Kasi;
import piilopokeri.Piilopokeri;


public class PiilopokeriTest {
    private Piilopokeri pokeri;
    private Kasi arvottuKasi;
    private Kasi arvottuKasi2;
    private Kasi arvottuKasi3;
    private Kasi arvottuKasi4;
    private Kasi arvottuKasi5;
    private Kasi negatiivinenKasi;
    

    @Before
    public void setuUp() {
        pokeri = new Piilopokeri();

        arvottuKasi = pokeri.getUudetKortit(5);
        arvottuKasi2 = pokeri.getUudetKortit(5);
        arvottuKasi3 = pokeri.getUudetKortit(5);
        arvottuKasi4 = pokeri.getUudetKortit(5);
        arvottuKasi5 = pokeri.getUudetKortit(5);

        negatiivinenKasi = pokeri.getUudetKortit(-1);
    }

    @Test
    public void kateenEiVoiLisataLiikaaKortteja() {
        Piilopokeri testiPokeri = new Piilopokeri();
        Kasi monenKortinKasi = testiPokeri.getUudetKortit(55);

        assertEquals(0, monenKortinKasi.getKortit().size());
    }

    @Test
    public void kadessaEiVoiOllaNegatiivinenMaaraKortteja() {
        assertEquals("", negatiivinenKasi.toString());
    }

    @Test
    public void arpooVainOikeitaArvojaTestikasi1() { 
        assertTrue(MaatJaArvot.vaaratArvotViesti(arvottuKasi), MaatJaArvot.onkoOikeatArvot(arvottuKasi));
    }

    @Test
    public void arpooVainOikeitaArvojaTestikasi2() {
        assertTrue(MaatJaArvot.vaaratArvotViesti(arvottuKasi2), MaatJaArvot.onkoOikeatArvot(arvottuKasi2));
    }

    @Test
    public void arpooVainOikeitaArvojaTestikasi3() {
        assertTrue(MaatJaArvot.vaaratArvotViesti(arvottuKasi3), MaatJaArvot.onkoOikeatArvot(arvottuKasi3));
    }

    @Test
    public void arpooVainOikeitaArvojaTestikasi4() {
        assertTrue(MaatJaArvot.vaaratArvotViesti(arvottuKasi4), MaatJaArvot.onkoOikeatArvot(arvottuKasi4));
    }

    @Test
    public void arpooVainOikeitaArvojaTestikasi5() {
        assertTrue(MaatJaArvot.vaaratArvotViesti(arvottuKasi5), MaatJaArvot.onkoOikeatArvot(arvottuKasi5));
    }

    @Test
    public void arpooVainOikeitaMaitaTestikasi1() { 
        assertTrue(MaatJaArvot.vaaratMaatViesti(arvottuKasi), MaatJaArvot.onkoOikeatMaat(arvottuKasi));
    }

    @Test
    public void arpooVainOikeitaMaitaTestikasi2() {
        assertTrue(MaatJaArvot.vaaratMaatViesti(arvottuKasi2), MaatJaArvot.onkoOikeatMaat(arvottuKasi2));
    }

    @Test
    public void arpooVainOikeitaMaitaTestikasi3() {
        assertTrue(MaatJaArvot.vaaratMaatViesti(arvottuKasi3), MaatJaArvot.onkoOikeatMaat(arvottuKasi3));
    }

    @Test
    public void arpooVainOikeitaMaitaTestikasi4() {
        assertTrue(MaatJaArvot.vaaratMaatViesti(arvottuKasi4), MaatJaArvot.onkoOikeatMaat(arvottuKasi4));
    }

    @Test
    public void arpooVainOikeitaMaitaTestikasi5() {
        assertTrue(MaatJaArvot.vaaratMaatViesti(arvottuKasi5), MaatJaArvot.onkoOikeatMaat(arvottuKasi5));
    }
    


}
