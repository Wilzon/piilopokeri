package piilopokeri.domain;

import piilopokeri.apu.MaatJaArvot;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import piilopokeri.domain.Kortti;
import piilopokeri.domain.Korttipakka;

/** @author Wilzon */

public class KorttipakkaTest {
    private Korttipakka pakka;
    
    @Before
    public void setUp() {
        pakka = new Korttipakka();
        
        pakka.kaannaKaikkiKortit();
    }
    
    @Test
    public void korttipakkaSisaltaaVainOikeitaMaita() {
        assertTrue(MaatJaArvot.vaaratMaatViesti(pakka), MaatJaArvot.onkoOikeatMaat(pakka));
    }

    @Test
    public void korttipakkaSisaltaaVainOikeitaArvoja() {
        assertTrue(MaatJaArvot.vaaratArvotViesti(pakka), MaatJaArvot.onkoOikeatArvot(pakka));
    }

    @Test
    public void korttipakassaOnOikeaKorttimaara() {
        int pakanKoko = pakka.getKortit().size();
        String viesti = "expected <54> but was <" + pakanKoko + ">";
        
        assertTrue(viesti, pakanKoko == 54);
    }
    
    @Test
    public void korttipakkaaVoiSekoittaa() {
        Korttipakka testiPakka = new Korttipakka();
        Korttipakka sekoittamatonPakka = new Korttipakka();
        testiPakka.sekoitaKortit();
        ArrayList<Kortti> kortit = testiPakka.getKortit();
        String viesti = "expected to be a shuffled order but was <" + kortit + ">";
        
        assertFalse(viesti, kortit.toString().equals(sekoittamatonPakka.toString()));
    }
    
    @Test
    public void pakastaVoiPoistaaJokerit() {
        Korttipakka testipakka = new Korttipakka();
        testipakka.poistaJokerit();
        
        assertEquals(52, testipakka.getKortit().size());
    }
}
