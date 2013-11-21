
package piilopokeri.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import piilopokeri.domain.Piilopokeri;
import piilopokeri.domain.Kasi;
import piilopokeri.domain.Kortti;


public class Piilopokeri2Test {
    Piilopokeri pokeri;
    
    Kasi viitosKasi;
    Kasi nelosKasi;
    Kasi kolmosKasi;
    Kasi kaksiPariaKasi;
    Kasi pariKasi;
    Kasi suoraKasi;
    Kasi variKasi;
    Kasi varisuoraKasi;
    Kasi tayskasiKasi;
    Kasi huonoEiMitaanKasi;
    Kasi hyvaEiMitaanKasi;
    
    Kortti pata5;
    Kortti pata6;
    Kortti pata7;
    Kortti pata8;
    Kortti pata9;
    
    Kortti pata3;
    Kortti ruutu8;
    Kortti herttaKuningas;
    
    Kortti ruutu9;
    Kortti risti9;
    Kortti hertta9;
    
    Kortti jokeri;
    
    
    @Before
    public void setUp() {
        pokeri = new Piilopokeri();
        
        viitosKasi = new Kasi();
        nelosKasi = new Kasi();
        kolmosKasi = new Kasi();
        kaksiPariaKasi = new Kasi();
        pariKasi = new Kasi();
        suoraKasi = new Kasi();
        variKasi = new Kasi();
        varisuoraKasi = new Kasi();
        tayskasiKasi = new Kasi();
        huonoEiMitaanKasi = new Kasi();
        hyvaEiMitaanKasi = new Kasi();
        
        pata5 = new Kortti(5, Kortti.PATA, true);
        pata6 = new Kortti(6, Kortti.PATA, true);
        pata7 = new Kortti(7, Kortti.PATA, true);
        pata8 = new Kortti(8, Kortti.PATA, true);
        pata9 = new Kortti(9, Kortti.PATA, true);
        
        pata3 = new Kortti(3, Kortti.PATA, true);
        ruutu8 = new Kortti(8, Kortti.RUUTU, true);
        herttaKuningas = new Kortti(13, Kortti.HERTTA, true);
        
        risti9 = new Kortti(9, Kortti.RISTI, true);
        ruutu9 = new Kortti(9, Kortti.RUUTU, true);
        hertta9 = new Kortti(9, Kortti.HERTTA, true);
        
        jokeri = new Kortti(15, Kortti.JOKERI, true);
        
        viitosKasi.lisaaKortti(hertta9);
        viitosKasi.lisaaKortti(risti9);
        viitosKasi.lisaaKortti(ruutu9);
        viitosKasi.lisaaKortti(pata9);
        viitosKasi.lisaaKortti(jokeri);
        
        nelosKasi.lisaaKortti(hertta9);
        nelosKasi.lisaaKortti(risti9);
        nelosKasi.lisaaKortti(ruutu9);
        nelosKasi.lisaaKortti(pata9);
        nelosKasi.lisaaKortti(pata5);
        
        kolmosKasi.lisaaKortti(hertta9);
        kolmosKasi.lisaaKortti(risti9);
        kolmosKasi.lisaaKortti(ruutu9);
        kolmosKasi.lisaaKortti(pata5);
        kolmosKasi.lisaaKortti(pata6);
        
        kaksiPariaKasi.lisaaKortti(hertta9);
        kaksiPariaKasi.lisaaKortti(risti9);
        kaksiPariaKasi.lisaaKortti(pata8);
        kaksiPariaKasi.lisaaKortti(ruutu8);
        kaksiPariaKasi.lisaaKortti(pata5);
        
        pariKasi.lisaaKortti(hertta9);
        pariKasi.lisaaKortti(pata9);
        pariKasi.lisaaKortti(pata7);
        pariKasi.lisaaKortti(pata6);
        pariKasi.lisaaKortti(pata5);
        
        suoraKasi.lisaaKortti(pata5);
        suoraKasi.lisaaKortti(hertta9);
        suoraKasi.lisaaKortti(pata7);
        suoraKasi.lisaaKortti(pata8);
        suoraKasi.lisaaKortti(pata6);
        
        variKasi.lisaaKortti(pata9);
        variKasi.lisaaKortti(pata8);
        variKasi.lisaaKortti(pata7);
        variKasi.lisaaKortti(pata6);
        variKasi.lisaaKortti(pata3);
        
        varisuoraKasi.lisaaKortti(pata5);
        varisuoraKasi.lisaaKortti(pata6);
        varisuoraKasi.lisaaKortti(pata7);
        varisuoraKasi.lisaaKortti(pata8);
        varisuoraKasi.lisaaKortti(pata9);
        
        tayskasiKasi.lisaaKortti(hertta9);
        tayskasiKasi.lisaaKortti(pata9);
        tayskasiKasi.lisaaKortti(ruutu9);
        tayskasiKasi.lisaaKortti(ruutu8);
        tayskasiKasi.lisaaKortti(pata8);
        
        huonoEiMitaanKasi.lisaaKortti(pata5);
        huonoEiMitaanKasi.lisaaKortti(pata6);
        huonoEiMitaanKasi.lisaaKortti(pata7);
        huonoEiMitaanKasi.lisaaKortti(pata3);
        huonoEiMitaanKasi.lisaaKortti(hertta9);

        hyvaEiMitaanKasi.lisaaKortti(pata5);
        hyvaEiMitaanKasi.lisaaKortti(pata6);
        hyvaEiMitaanKasi.lisaaKortti(pata7);
        hyvaEiMitaanKasi.lisaaKortti(pata8);
        hyvaEiMitaanKasi.lisaaKortti(herttaKuningas);
        
    }
    
    @Test
    public void viitosetVoittaaVarisuoran() {
        assertEquals(1, pokeri.parempiKasi(viitosKasi, varisuoraKasi));
    }
    
    @Test
    public void varisuoraVoittaaNeloset() {
        assertEquals(1, pokeri.parempiKasi(varisuoraKasi, nelosKasi));
    }
    
    @Test
    public void nelosetVoittavatTayskaden() {
        assertEquals(1, pokeri.parempiKasi(nelosKasi, tayskasiKasi));
    }
    
    @Test
    public void tayskasiVoittaaVarin() {
        assertEquals(1, pokeri.parempiKasi(tayskasiKasi, variKasi));
    }
    
    @Test
    public void variVoittaaSuoran() {
        assertEquals(1, pokeri.parempiKasi(variKasi, suoraKasi));
    }
    
    @Test
    public void suoraVoittaaKolmoset() {
        assertEquals(1, pokeri.parempiKasi(suoraKasi, kolmosKasi));
    }
    
    @Test
    public void kolmosetVoittaaKaksiParia() {
        assertEquals(1, pokeri.parempiKasi(kolmosKasi, kaksiPariaKasi));
    }
    
    @Test
    public void kaksiPariaVoittaaParin() {
        assertEquals(1, pokeri.parempiKasi(kaksiPariaKasi, pariKasi));
    }
    
    @Test
    public void pariVoittaaEiMitaanKaden() {
        assertEquals(1, pokeri.parempiKasi(pariKasi, hyvaEiMitaanKasi));
    }
    
    @Test
    public void suurempiKorttiVoittaa() {
        assertEquals(1, pokeri.parempiKasi(hyvaEiMitaanKasi, huonoEiMitaanKasi));
    }
    
}
