
package piilopokeri.domain;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class KasienVertailijaTest {
    Piilopokeri pokeri;
    ArrayList<Kasi> kadet;
    
    Kasi huonoViitosKasi;
    Kasi hyvaViitosKasi;
    
    Kasi huonoNelosKasi;
    Kasi hyvaNelosKasi;
    
    Kasi huonoKolmosKasi;
    Kasi hyvaKolmosKasi;
    
    Kasi huonoKaksiPariaKasi;
    Kasi hyvaKaksiPariaKasi;
    
    Kasi huonoPariKasi;
    Kasi hyvaPariKasi;
    
    Kasi huonoSuoraKasi;
    Kasi hyvaSuoraKasi;
    
    Kasi huonoVariKasi;
    Kasi hyvaVariKasi;
    
    Kasi huonoVarisuoraKasi;
    Kasi hyvaVarisuoraKasi;
    
    Kasi huonoTayskasiKasi;
    Kasi hyvaTayskasiKasi;
    
    Kasi huonoEiMitaanKasi;
    Kasi hyvaEiMitaanKasi;
    
    @Before
    public void setUp() {
        pokeri = new Piilopokeri();
        kadet = new ArrayList();
        
        huonoViitosKasi = new Kasi();
        hyvaViitosKasi = new Kasi();
        
        huonoNelosKasi = new Kasi();
        hyvaNelosKasi = new Kasi();
        
        huonoKolmosKasi = new Kasi();
        hyvaKolmosKasi = new Kasi();
        
        huonoKaksiPariaKasi = new Kasi();
        hyvaKaksiPariaKasi = new Kasi();
        
        huonoPariKasi = new Kasi();
        hyvaPariKasi = new Kasi();
        
        
        huonoSuoraKasi = new Kasi();
        hyvaSuoraKasi = new Kasi();
        
        huonoVariKasi = new Kasi();
        hyvaVariKasi = new Kasi();
        
        huonoVarisuoraKasi = new Kasi();
        hyvaVarisuoraKasi = new Kasi();
        
        huonoTayskasiKasi = new Kasi();
        hyvaTayskasiKasi = new Kasi();
        
        huonoEiMitaanKasi = new Kasi();
        hyvaEiMitaanKasi = new Kasi();
        
        kadet.add(huonoViitosKasi);
        kadet.add(hyvaViitosKasi);
        kadet.add(huonoNelosKasi);
        kadet.add(hyvaNelosKasi);
        kadet.add(huonoKolmosKasi);
        kadet.add(hyvaKolmosKasi);
        kadet.add(huonoKaksiPariaKasi);
        kadet.add(hyvaKaksiPariaKasi);
        kadet.add(huonoPariKasi);
        kadet.add(hyvaPariKasi);
        kadet.add(huonoSuoraKasi);
        kadet.add(hyvaSuoraKasi);
        kadet.add(huonoVariKasi);
        kadet.add(hyvaVariKasi);
        kadet.add(huonoVarisuoraKasi);
        kadet.add(hyvaVarisuoraKasi);
        kadet.add(huonoTayskasiKasi);
        kadet.add(hyvaTayskasiKasi);
        kadet.add(huonoEiMitaanKasi);
        kadet.add(hyvaEiMitaanKasi);
        
        Kortti pata5 = new Kortti(5, Kortti.PATA, true);
        Kortti pata6 = new Kortti(6, Kortti.PATA, true);
        Kortti pata7 = new Kortti(7, Kortti.PATA, true);
        Kortti pata8 = new Kortti(8, Kortti.PATA, true);
        Kortti pata9 = new Kortti(9, Kortti.PATA, true);
        
        Kortti pata3 = new Kortti(3, Kortti.PATA, true);
        Kortti ruutu8 = new Kortti(8, Kortti.RUUTU, true);
        
        Kortti herttaK = new Kortti(13, Kortti.HERTTA, true);
        Kortti pataK = new Kortti(13, Kortti.PATA, true);
        Kortti ruutuK = new Kortti(13, Kortti.RUUTU, true);
        Kortti ristiK = new Kortti(13, Kortti.RISTI, true);
        
        Kortti pata10 = new Kortti(10, Kortti.PATA, true);
        Kortti pataJ = new Kortti(10, Kortti.PATA, true);
        Kortti pataQ = new Kortti(10, Kortti.PATA, true);
        
        Kortti risti9 = new Kortti(9, Kortti.RISTI, true);
        Kortti ruutu9 = new Kortti(9, Kortti.RUUTU, true);
        Kortti hertta9 = new Kortti(9, Kortti.HERTTA, true);
        
        Kortti jokeri = new Kortti(15, Kortti.JOKERI, true);
        
        huonoViitosKasi.lisaaKortti(hertta9);
        huonoViitosKasi.lisaaKortti(risti9);
        huonoViitosKasi.lisaaKortti(ruutu9);
        huonoViitosKasi.lisaaKortti(pata9);
        huonoViitosKasi.lisaaKortti(jokeri);
        
        hyvaViitosKasi.lisaaKortti(herttaK);
        hyvaViitosKasi.lisaaKortti(pataK);
        hyvaViitosKasi.lisaaKortti(jokeri);
        hyvaViitosKasi.lisaaKortti(ristiK);
        hyvaViitosKasi.lisaaKortti(ruutuK);
        
        huonoNelosKasi.lisaaKortti(hertta9);
        huonoNelosKasi.lisaaKortti(risti9);
        huonoNelosKasi.lisaaKortti(ruutu9);
        huonoNelosKasi.lisaaKortti(pata9);
        huonoNelosKasi.lisaaKortti(pata5);
        
        hyvaNelosKasi.lisaaKortti(pataK);
        hyvaNelosKasi.lisaaKortti(ristiK);
        hyvaNelosKasi.lisaaKortti(pataJ);
        hyvaNelosKasi.lisaaKortti(herttaK);
        hyvaNelosKasi.lisaaKortti(ruutuK);
        
        huonoKolmosKasi.lisaaKortti(hertta9);
        huonoKolmosKasi.lisaaKortti(risti9);
        huonoKolmosKasi.lisaaKortti(ruutu9);
        huonoKolmosKasi.lisaaKortti(pata5);
        huonoKolmosKasi.lisaaKortti(pata6);
        
        hyvaKolmosKasi.lisaaKortti(pata8);
        hyvaKolmosKasi.lisaaKortti(hertta9);
        hyvaKolmosKasi.lisaaKortti(pataK);
        hyvaKolmosKasi.lisaaKortti(herttaK);
        hyvaKolmosKasi.lisaaKortti(ruutuK);
        
        huonoKaksiPariaKasi.lisaaKortti(hertta9);
        huonoKaksiPariaKasi.lisaaKortti(risti9);
        huonoKaksiPariaKasi.lisaaKortti(pata8);
        huonoKaksiPariaKasi.lisaaKortti(ruutu8);
        huonoKaksiPariaKasi.lisaaKortti(pata5);
        
        hyvaKaksiPariaKasi.lisaaKortti(pataK);
        hyvaKaksiPariaKasi.lisaaKortti(herttaK);
        hyvaKaksiPariaKasi.lisaaKortti(pata5);
        hyvaKaksiPariaKasi.lisaaKortti(ruutu9);
        hyvaKaksiPariaKasi.lisaaKortti(pata9);
        
        huonoPariKasi.lisaaKortti(hertta9);
        huonoPariKasi.lisaaKortti(pata9);
        huonoPariKasi.lisaaKortti(pata7);
        huonoPariKasi.lisaaKortti(pata6);
        huonoPariKasi.lisaaKortti(pata5);
        
        hyvaPariKasi.lisaaKortti(pataK);
        hyvaPariKasi.lisaaKortti(pata3);
        hyvaPariKasi.lisaaKortti(pata7);
        hyvaPariKasi.lisaaKortti(herttaK);
        hyvaPariKasi.lisaaKortti(hertta9);

        huonoSuoraKasi.lisaaKortti(pata5);
        huonoSuoraKasi.lisaaKortti(hertta9);
        huonoSuoraKasi.lisaaKortti(pata7);
        huonoSuoraKasi.lisaaKortti(pata8);
        huonoSuoraKasi.lisaaKortti(pata6);
        
        hyvaSuoraKasi.lisaaKortti(pataK);
        hyvaSuoraKasi.lisaaKortti(pataQ);
        hyvaSuoraKasi.lisaaKortti(hertta9);
        hyvaSuoraKasi.lisaaKortti(pata10);
        hyvaSuoraKasi.lisaaKortti(pataJ);
        
        huonoVariKasi.lisaaKortti(pata9);
        huonoVariKasi.lisaaKortti(pata8);
        huonoVariKasi.lisaaKortti(pata7);
        huonoVariKasi.lisaaKortti(pata6);
        huonoVariKasi.lisaaKortti(pata3);
        
        hyvaVariKasi.lisaaKortti(pata9);
        hyvaVariKasi.lisaaKortti(pata8);
        hyvaVariKasi.lisaaKortti(pata7);
        hyvaVariKasi.lisaaKortti(pata3);
        hyvaVariKasi.lisaaKortti(pataK);
        
        huonoVarisuoraKasi.lisaaKortti(pata5);
        huonoVarisuoraKasi.lisaaKortti(pata6);
        huonoVarisuoraKasi.lisaaKortti(pata7);
        huonoVarisuoraKasi.lisaaKortti(pata8);
        huonoVarisuoraKasi.lisaaKortti(pata9);
        
        hyvaVarisuoraKasi.lisaaKortti(pataK);
        hyvaVarisuoraKasi.lisaaKortti(pataJ);
        hyvaVarisuoraKasi.lisaaKortti(pata10);
        hyvaVarisuoraKasi.lisaaKortti(pataQ);
        hyvaVarisuoraKasi.lisaaKortti(pata9);
        
        huonoTayskasiKasi.lisaaKortti(hertta9);
        huonoTayskasiKasi.lisaaKortti(pata9);
        huonoTayskasiKasi.lisaaKortti(ruutu9);
        huonoTayskasiKasi.lisaaKortti(ruutu8);
        huonoTayskasiKasi.lisaaKortti(pata8);
        
        hyvaTayskasiKasi.lisaaKortti(pataK);
        hyvaTayskasiKasi.lisaaKortti(herttaK);
        hyvaTayskasiKasi.lisaaKortti(ruutuK);
        hyvaTayskasiKasi.lisaaKortti(risti9);
        hyvaTayskasiKasi.lisaaKortti(pata9);
        
        huonoEiMitaanKasi.lisaaKortti(pata5);
        huonoEiMitaanKasi.lisaaKortti(pata6);
        huonoEiMitaanKasi.lisaaKortti(pata7);
        huonoEiMitaanKasi.lisaaKortti(pata3);
        huonoEiMitaanKasi.lisaaKortti(hertta9);

        hyvaEiMitaanKasi.lisaaKortti(pata5);
        hyvaEiMitaanKasi.lisaaKortti(pata6);
        hyvaEiMitaanKasi.lisaaKortti(pata7);
        hyvaEiMitaanKasi.lisaaKortti(pata8);
        hyvaEiMitaanKasi.lisaaKortti(herttaK);
        
    }

    @Test
    public void viitosetVoittaaVarisuoran() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoViitosKasi, huonoVarisuoraKasi));
    }
    
    @Test
    public void varisuoraVoittaaNeloset() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoVarisuoraKasi, huonoNelosKasi));
    }
    
    @Test
    public void nelosetVoittavatTayskaden() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoNelosKasi, huonoTayskasiKasi));
    }
    
    @Test
    public void tayskasiVoittaaVarin() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoTayskasiKasi, huonoVariKasi));
    }
    
    @Test
    public void variVoittaaSuoran() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoVariKasi, huonoSuoraKasi));
    }
    
    @Test
    public void suoraVoittaaKolmoset() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoSuoraKasi, huonoKolmosKasi));
    }
    
    @Test
    public void kolmosetVoittaaKaksiParia() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoKolmosKasi, huonoKaksiPariaKasi));
    }
    
    @Test
    public void kaksiPariaVoittaaParin() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoKaksiPariaKasi, huonoPariKasi));
    }
    
    @Test
    public void pariVoittaaEiMitaanKaden() {
        assertEquals(1, KasienVertailija.parempiKasi(huonoPariKasi, hyvaEiMitaanKasi));
    }
    
    @Test
    public void suurempiKorttiVoittaa() {
        assertEquals(1, KasienVertailija.parempiKasi(hyvaEiMitaanKasi, huonoEiMitaanKasi));
    }
    
    @Test
    public void pienempiKorttiHaviaa() {
        assertEquals(-1, KasienVertailija.parempiKasi(huonoEiMitaanKasi, hyvaEiMitaanKasi));
    }
    
    @Test
    public void parempiPariVoittaaHuonommanParin() {
        assertEquals(1, KasienVertailija.parempiKasi(hyvaPariKasi, huonoPariKasi));
    }
    
    @Test
    public void paremmatKolmosetVoittaaHuonommatKolmoset() {
        assertEquals(1, KasienVertailija.parempiMontaSamaa(hyvaKolmosKasi, huonoKolmosKasi, 3));
    }
    
    @Test
    public void paremmatNelosetVoittaaHuonommatNeloset() {
        assertEquals(1, KasienVertailija.parempiMontaSamaa(hyvaNelosKasi, huonoNelosKasi, 4));
    }
    
    @Test
    public void paremmatVitosetVoittaaHuonommatVitoset() {
        assertEquals(1, KasienVertailija.parempiMontaSamaa(hyvaViitosKasi, huonoViitosKasi, 5));
    }
    
    @Test
    public void parempiSuoraVoittaaHuonommanSuoran() {
        assertEquals(1, KasienVertailija.parempiSuoraTaiVari(hyvaSuoraKasi, huonoSuoraKasi));
    }
    
    @Test
    public void parempiVariVoittaaHuonommanVarin() {
        assertEquals(1, KasienVertailija.parempiSuoraTaiVari(hyvaVariKasi, huonoVariKasi));
    }
    
    @Test
    public void parempiTayskasiVoittaaHuonommanTayskaden() {
        assertEquals(1, KasienVertailija.parempiTayskasi(hyvaTayskasiKasi, huonoTayskasiKasi));
    }
    
    @Test
    public void parempiVarisuoraVoittaaHuonommanVarisuoran() {
        assertEquals(1, KasienVertailija.parempiSuoraTaiVari(hyvaVarisuoraKasi, huonoVarisuoraKasi));
    }
    
    @Test
    public void parasKasiVoittaa() {
        assertEquals(hyvaViitosKasi, KasienVertailija.parasKasi(kadet));
    }
}
