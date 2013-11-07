package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;


public class KasiTest {
    private Kasi testikasi;
    private Kasi testikasi2;

    @Before
    public void setUp() {
        testikasi = new Kasi();
        testikasi2 = new Kasi();

        testikasi.lisaaKortti(new Kortti(8, Kortti.HERTTA));
        testikasi.lisaaKortti(new Kortti(12, Kortti.RISTI));
        testikasi.lisaaKortti(new Kortti(3, Kortti.RUUTU));
        testikasi.lisaaKortti(new Kortti(2, Kortti.RISTI));
        testikasi.lisaaKortti(new Kortti(4, Kortti.PATA));

        testikasi2.lisaaKortti(new Kortti(7, Kortti.PATA));
        testikasi2.lisaaKortti(new Kortti(4, Kortti.PATA));
        testikasi2.lisaaKortti(new Kortti(4, Kortti.HERTTA));
        testikasi2.lisaaKortti(new Kortti(12, Kortti.RUUTU));
        testikasi2.lisaaKortti(new Kortti(10, Kortti.RUUTU));
        
        for(int i = 0; i < 5; i++) {
            testikasi.getKortit().get(i).kaannaKortti();
            testikasi2.getKortit().get(i).kaannaKortti();
        }
    }
    
    @Test
    public void kasiJarjestyyOikeinTestikasi1() {
        testikasi.jarjestaKortit();
        
        assertEquals("Risti 2, Ruutu 3, Pata 4, Hertta 8, Risti Q", testikasi.toString());
    }

    @Test
    public void kasiJarjestyyOikeinTestikasi2() {
        testikasi2.jarjestaKortit();
        
        assertEquals("Pata 4, Hertta 4, Pata 7, Ruutu 10, Ruutu Q", testikasi2.toString());
    }

    @Test
    public void kadenJarjestysKaantyyOikeinTestikasi1() {
        testikasi.kaannaJarjestys();
        
        assertEquals("Risti Q, Hertta 8, Pata 4, Ruutu 3, Risti 2", testikasi.toString());
    }

    @Test
    public void kadenJarjestysKaantyyOikeinTestikasi2() {
        testikasi2.kaannaJarjestys();
        
        assertEquals("Ruutu Q, Ruutu 10, Pata 7, Hertta 4, Pata 4", testikasi2.toString());
    }
    
    @Test
    public void eiVoiLisataNegatiivistaKorttia() {
        Kasi kasi = new Kasi();
        kasi.lisaaKortti(new Kortti(-1, Kortti.HERTTA));
        assertEquals("", kasi.toString());
    }
}