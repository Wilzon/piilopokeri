package piilopokeri.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class KasiTest {
    private Kasi testikasi;
    private Kasi testikasi2;
    private Kasi testikasi3;

    @Before
    public void setUp() {
        testikasi = new Kasi();
        testikasi2 = new Kasi();
        testikasi3 = new Kasi();

        testikasi.lisaaKortti(new Kortti(8, Kortti.HERTTA, true));
        testikasi.lisaaKortti(new Kortti(12, Kortti.RISTI, true));
        testikasi.lisaaKortti(new Kortti(3, Kortti.RUUTU, true));
        testikasi.lisaaKortti(new Kortti(2, Kortti.RISTI, true));
        testikasi.lisaaKortti(new Kortti(4, Kortti.PATA, true));

        testikasi2.lisaaKortti(new Kortti(7, Kortti.PATA, true));
        testikasi2.lisaaKortti(new Kortti(4, Kortti.PATA, true));
        testikasi2.lisaaKortti(new Kortti(4, Kortti.HERTTA, true));
        testikasi2.lisaaKortti(new Kortti(12, Kortti.RUUTU, true));
        testikasi2.lisaaKortti(new Kortti(10, Kortti.RUUTU, true));
        
        testikasi3.lisaaKortti(new Kortti(6, Kortti.PATA));
        testikasi3.lisaaKortti(new Kortti(4, Kortti.PATA, true));
        testikasi3.lisaaKortti(new Kortti(7, Kortti.PATA, true));
        testikasi3.lisaaKortti(new Kortti(3, Kortti.PATA, true));
        testikasi3.lisaaKortti(new Kortti(2, Kortti.PATA));
        
        
    }
    
    @Test
    public void kasiJarjestyyOikeinTestikasi1() {
        testikasi.jarjestaKortit();
        
        assertEquals("2 ♣, 3 ♦, 4 ♠, 8 ♥, Q ♣", testikasi.toString());
    }

    @Test
    public void kasiJarjestyyOikeinTestikasi2() {
        testikasi2.jarjestaKortit();
        
        assertEquals("4 ♠, 4 ♥, 7 ♠, 10 ♦, Q ♦", testikasi2.toString());
    }

    @Test
    public void kadenJarjestysKaantyyOikeinTestikasi1() {
        testikasi.kaannaJarjestys();
        
        assertEquals("Q ♣, 8 ♥, 4 ♠, 3 ♦, 2 ♣", testikasi.toString());
    }

    @Test
    public void kadenJarjestysKaantyyOikeinTestikasi2() {
        testikasi2.kaannaJarjestys();
        
        assertEquals("Q ♦, 10 ♦, 7 ♠, 4 ♥, 4 ♠", testikasi2.toString());
    }
    
    @Test
    public void kadenJarjestysKaantyyOikeinMyosJosKorttejaOnVaarinpain() {
        testikasi3.kaannaJarjestys();
        
        assertEquals("7 ♠, 4 ♠, 3 ♠, [X], [X]", testikasi3.toString());
    }
    
    @Test
    public void kasiJarjestyyOikeinMyosJosKorttejaOnVaarinpain() {
        testikasi3.jarjestaKortit();
        
        assertEquals("3 ♠, 4 ♠, 7 ♠, [X], [X]", testikasi3.toString());
    }
    
    @Test
    public void eiVoiLisataNegatiivistaKorttia() {
        Kasi kasi = new Kasi();
        kasi.lisaaKortti(new Kortti(-1, Kortti.HERTTA));
        assertEquals("", kasi.toString());
    }
}