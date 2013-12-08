
package piilopokeri.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class Kasi2Test {
    Kortti hertta2;
    Kortti hertta3;
    Kortti hertta4;
    Kortti hertta5;
    Kortti hertta6;
    Kortti hertta10;
    
    Kortti pataAssa;
    
    Kortti pata5;
    Kortti risti5;
    Kortti ruutu5;
    
    Kortti pata4;
    Kortti ruutu4;
    Kortti risti4;
    
    Kortti jokeri;
    
    @Before
    public void setUp() {
        pataAssa = new Kortti(14, Kortti.PATA, true);
        hertta2 = new Kortti(2, Kortti.HERTTA, true);
        hertta3 = new Kortti(3, Kortti.HERTTA, true);
        hertta4 = new Kortti(4, Kortti.HERTTA, true);
        hertta5 = new Kortti(5, Kortti.HERTTA, true);
        hertta6 = new Kortti(6, Kortti.HERTTA, true);
        hertta10 = new Kortti(10, Kortti.HERTTA, true);
        
        pata5 = new Kortti(5, Kortti.PATA, true);
        risti5 = new Kortti(5, Kortti.RISTI, true);
        ruutu5 = new Kortti(5, Kortti.RUUTU, true);
        
        pata4 = new Kortti(4, Kortti.PATA, true);
        ruutu4 = new Kortti(4, Kortti.RUUTU, true);
        risti4 = new Kortti(4, Kortti.RISTI, true);
        
        
        jokeri = new Kortti(15, Kortti.JOKERI, true);
    }
    
    @Test
    public void assaVoiOllaYkkonenSuorassa() {
        Kasi pieninSuoraKasi = new Kasi();
        
        pieninSuoraKasi.lisaaKortti(pataAssa);
        pieninSuoraKasi.lisaaKortti(hertta5);
        pieninSuoraKasi.lisaaKortti(hertta3);
        pieninSuoraKasi.lisaaKortti(hertta4);
        pieninSuoraKasi.lisaaKortti(hertta2);
        
        assertTrue(pieninSuoraKasi.onkoSuora());
    }
    
    @Test
    public void kadessaOnVarisuora() {
        Kasi varisuoraKasi = new Kasi();
        
        varisuoraKasi.lisaaKortti(hertta2);
        varisuoraKasi.lisaaKortti(hertta3);
        varisuoraKasi.lisaaKortti(hertta4);
        varisuoraKasi.lisaaKortti(hertta5);
        varisuoraKasi.lisaaKortti(hertta6);
        
        assertTrue(varisuoraKasi.onkoVarisuora());
    }
    
    @Test
    public void kadessaOnVari() {
        Kasi variKasi = new Kasi();
        
        variKasi.lisaaKortti(hertta2);
        variKasi.lisaaKortti(hertta3);
        variKasi.lisaaKortti(hertta4);
        variKasi.lisaaKortti(hertta5);
        variKasi.lisaaKortti(hertta10);
        
        assertTrue(variKasi.onkoVari());
    }
    
    @Test
    public void kadessaOnPari() {
        Kasi pariKasi = new Kasi();
        
        pariKasi.lisaaKortti(hertta5);
        pariKasi.lisaaKortti(pata5);
        pariKasi.lisaaKortti(hertta3);
        pariKasi.lisaaKortti(hertta4);
        pariKasi.lisaaKortti(hertta6);
        
        assertTrue(pariKasi.onkoPari());
    }
    
    @Test
    public void kadessaOnKaksiParia() {
        Kasi kaksiPariaKasi = new Kasi();
        
        kaksiPariaKasi.lisaaKortti(hertta5);
        kaksiPariaKasi.lisaaKortti(risti5);
        kaksiPariaKasi.lisaaKortti(pata4);
        kaksiPariaKasi.lisaaKortti(hertta4);
        kaksiPariaKasi.lisaaKortti(hertta2);
        
        assertTrue(kaksiPariaKasi.onkoKaksiParia());
    }
    
    @Test
    public void kadessaOnKolmoset() {
        Kasi kolmeSamaaKasi = new Kasi();
        
        kolmeSamaaKasi.lisaaKortti(hertta5);
        kolmeSamaaKasi.lisaaKortti(risti5);
        kolmeSamaaKasi.lisaaKortti(pata5);
        kolmeSamaaKasi.lisaaKortti(hertta2);
        kolmeSamaaKasi.lisaaKortti(hertta3);
        
        assertTrue(kolmeSamaaKasi.onkoKolmoset());
    }
    
    @Test
    public void kadessaOnNeloset() {
        Kasi neljaSamaaKasi = new Kasi();
        
        neljaSamaaKasi.lisaaKortti(hertta5);
        neljaSamaaKasi.lisaaKortti(pata5);
        neljaSamaaKasi.lisaaKortti(risti5);
        neljaSamaaKasi.lisaaKortti(ruutu5);
        neljaSamaaKasi.lisaaKortti(hertta2);
        
        assertTrue(neljaSamaaKasi.onkoNeloset());
    }
    
    @Test
    public void kadessaOnVitoset() {
        Kasi viisiSamaaKasi = new Kasi();
        
        viisiSamaaKasi.lisaaKortti(hertta5);
        viisiSamaaKasi.lisaaKortti(pata5);
        viisiSamaaKasi.lisaaKortti(risti5);
        viisiSamaaKasi.lisaaKortti(ruutu5);
        viisiSamaaKasi.lisaaKortti(jokeri);
        
        assertTrue(viisiSamaaKasi.onkoVitoset());
    }
    
    @Test
    public void kadessaOnTayskasi() {
        Kasi tayskasiKasi = new Kasi();
        
        tayskasiKasi.lisaaKortti(hertta5);
        tayskasiKasi.lisaaKortti(pata5);
        tayskasiKasi.lisaaKortti(ruutu5);
        tayskasiKasi.lisaaKortti(hertta4);
        tayskasiKasi.lisaaKortti(pata4);
        
        assertTrue(tayskasiKasi.onkoTayskasi());
    }
    
    @Test
    public void kadessaOnNelosetJaPari() {
        Kasi nelosJaPariKasi = new Kasi();
        
        nelosJaPariKasi.lisaaKortti(hertta4);
        nelosJaPariKasi.lisaaKortti(ruutu4);
        nelosJaPariKasi.lisaaKortti(risti4);
        nelosJaPariKasi.lisaaKortti(pata4);
        nelosJaPariKasi.lisaaKortti(risti5);
        nelosJaPariKasi.lisaaKortti(ruutu5);
        
        assertTrue(nelosJaPariKasi.onkoNelosetJaPari());
    }
    
    @Test
    public void kadessaOnVitosetJaPari() {
        Kasi vitosJaPariKasi = new Kasi();
        
        vitosJaPariKasi.lisaaKortti(hertta4);
        vitosJaPariKasi.lisaaKortti(ruutu4);
        vitosJaPariKasi.lisaaKortti(risti4);
        vitosJaPariKasi.lisaaKortti(pata4);
        vitosJaPariKasi.lisaaKortti(risti5);
        vitosJaPariKasi.lisaaKortti(ruutu5);
        vitosJaPariKasi.lisaaKortti(jokeri);
        
        assertTrue(vitosJaPariKasi.onkoVitosetJaPari());
    }
    
    @Test
    public void kadessaOnKutosetJaPari() {
        Kasi kutosJaPariKasi = new Kasi();
        
        kutosJaPariKasi.lisaaKortti(hertta4);
        kutosJaPariKasi.lisaaKortti(ruutu4);
        kutosJaPariKasi.lisaaKortti(risti4);
        kutosJaPariKasi.lisaaKortti(pata4);
        kutosJaPariKasi.lisaaKortti(risti5);
        kutosJaPariKasi.lisaaKortti(ruutu5);
        kutosJaPariKasi.lisaaKortti(jokeri);
        kutosJaPariKasi.lisaaKortti(jokeri);
        
        assertTrue(kutosJaPariKasi.onkoKutosetJaPari());
    }
    
    @Test
    public void kadessaOnNelosetJaKolmeSamaa() {
        Kasi nelosJaKolmeSamaaKasi = new Kasi();
        
        nelosJaKolmeSamaaKasi.lisaaKortti(hertta4);
        nelosJaKolmeSamaaKasi.lisaaKortti(ruutu4);
        nelosJaKolmeSamaaKasi.lisaaKortti(risti4);
        nelosJaKolmeSamaaKasi.lisaaKortti(pata4);
        nelosJaKolmeSamaaKasi.lisaaKortti(risti5);
        nelosJaKolmeSamaaKasi.lisaaKortti(ruutu5);
        nelosJaKolmeSamaaKasi.lisaaKortti(pata5);
        
        assertTrue(nelosJaKolmeSamaaKasi.onkoNelosetJaKolmoset());
    }
    
    @Test
    public void kadessaOnVitosetJaKolmeSamaa() {
        Kasi vitosJaKolmeSamaaKasi = new Kasi();
        
        vitosJaKolmeSamaaKasi.lisaaKortti(hertta4);
        vitosJaKolmeSamaaKasi.lisaaKortti(ruutu4);
        vitosJaKolmeSamaaKasi.lisaaKortti(risti4);
        vitosJaKolmeSamaaKasi.lisaaKortti(pata4);
        vitosJaKolmeSamaaKasi.lisaaKortti(risti5);
        vitosJaKolmeSamaaKasi.lisaaKortti(ruutu5);
        vitosJaKolmeSamaaKasi.lisaaKortti(pata5);
        vitosJaKolmeSamaaKasi.lisaaKortti(jokeri);
        
        assertTrue(vitosJaKolmeSamaaKasi.onkoVitosetJaKolmoset());
    }
    
    @Test
    public void kadessaOnKutosetJaKolmeSamaa() {
        Kasi kutosJaKolmeSamaaKasi = new Kasi();
        
        kutosJaKolmeSamaaKasi.lisaaKortti(hertta4);
        kutosJaKolmeSamaaKasi.lisaaKortti(ruutu4);
        kutosJaKolmeSamaaKasi.lisaaKortti(risti4);
        kutosJaKolmeSamaaKasi.lisaaKortti(pata4);
        kutosJaKolmeSamaaKasi.lisaaKortti(risti5);
        kutosJaKolmeSamaaKasi.lisaaKortti(ruutu5);
        kutosJaKolmeSamaaKasi.lisaaKortti(hertta5);
        kutosJaKolmeSamaaKasi.lisaaKortti(jokeri);
        kutosJaKolmeSamaaKasi.lisaaKortti(jokeri);
        
        assertTrue(kutosJaKolmeSamaaKasi.onkoKutosetJaKolmoset());
    }
    
    @Test
    public void kadessaOnKaksiKolmeSamaa() {
        Kasi kaksiKolmeSamaaKasi = new Kasi();
        
        kaksiKolmeSamaaKasi.lisaaKortti(hertta4);
        kaksiKolmeSamaaKasi.lisaaKortti(ruutu4);
        kaksiKolmeSamaaKasi.lisaaKortti(risti4);
        kaksiKolmeSamaaKasi.lisaaKortti(hertta5);
        kaksiKolmeSamaaKasi.lisaaKortti(risti5);
        kaksiKolmeSamaaKasi.lisaaKortti(ruutu5);
        
        assertTrue(kaksiKolmeSamaaKasi.onkoKahdetKolmoset());
    }
    
    @Test
    public void kadessaOnKaksiNeljaSamaa() {
        Kasi kaksiNeljaSamaaKasi = new Kasi();
        
        kaksiNeljaSamaaKasi.lisaaKortti(hertta4);
        kaksiNeljaSamaaKasi.lisaaKortti(ruutu4);
        kaksiNeljaSamaaKasi.lisaaKortti(risti4);
        kaksiNeljaSamaaKasi.lisaaKortti(pata4);
        kaksiNeljaSamaaKasi.lisaaKortti(risti5);
        kaksiNeljaSamaaKasi.lisaaKortti(ruutu5);
        kaksiNeljaSamaaKasi.lisaaKortti(hertta5);
        kaksiNeljaSamaaKasi.lisaaKortti(pata5);
        
        assertTrue(kaksiNeljaSamaaKasi.onkoKahdetNeloset());
    }
    
    @Test
    public void kadessaOnPariJokerilla() {
        Kasi jokeriPariKasi = new Kasi();
        
        jokeriPariKasi.lisaaKortti(hertta2);
        jokeriPariKasi.lisaaKortti(jokeri);
        jokeriPariKasi.lisaaKortti(pata5);
        jokeriPariKasi.lisaaKortti(hertta4);
        jokeriPariKasi.lisaaKortti(hertta10);
        
        assertTrue(jokeriPariKasi.onkoPari());
    }
    
    @Test
    public void kadessaOnKolmeSamaaJokerilla() {
        Kasi jokeriKolmeSamaaKasi = new Kasi();
        
        jokeriKolmeSamaaKasi.lisaaKortti(hertta5);
        jokeriKolmeSamaaKasi.lisaaKortti(jokeri);
        jokeriKolmeSamaaKasi.lisaaKortti(pata4);
        jokeriKolmeSamaaKasi.lisaaKortti(hertta4);
        jokeriKolmeSamaaKasi.lisaaKortti(hertta10);
        
        assertTrue(jokeriKolmeSamaaKasi.onkoKolmoset());
    }
    
    @Test
    public void kadessaOnNeljaSamaaJokerilla() {
        Kasi jokeriNeljaSamaaKasi = new Kasi();
        
        jokeriNeljaSamaaKasi.lisaaKortti(hertta5);
        jokeriNeljaSamaaKasi.lisaaKortti(jokeri);
        jokeriNeljaSamaaKasi.lisaaKortti(pata5);
        jokeriNeljaSamaaKasi.lisaaKortti(risti5);
        jokeriNeljaSamaaKasi.lisaaKortti(hertta10);
        
        assertTrue(jokeriNeljaSamaaKasi.onkoNeloset());
    }
    
    @Test
    public void kadessaOnSuoraJokerilla() {
        Kasi jokeriSuoraKasi = new Kasi();
        
        jokeriSuoraKasi.lisaaKortti(pata5);
        jokeriSuoraKasi.lisaaKortti(jokeri);
        jokeriSuoraKasi.lisaaKortti(hertta4);
        jokeriSuoraKasi.lisaaKortti(hertta2);
        jokeriSuoraKasi.lisaaKortti(hertta6);
        
        assertTrue(jokeriSuoraKasi.onkoSuora());
    }
    
    @Test
    public void kadessaOnVariJokerilla() {
        Kasi jokeriVariKasi = new Kasi();
        
        jokeriVariKasi.lisaaKortti(hertta2);
        jokeriVariKasi.lisaaKortti(jokeri);
        jokeriVariKasi.lisaaKortti(hertta3);
        jokeriVariKasi.lisaaKortti(hertta4);
        jokeriVariKasi.lisaaKortti(hertta10);
        
        assertTrue(jokeriVariKasi.onkoVari());
    }
    
    @Test
    public void kadessaOnVarisuoraJokerilla() {
        Kasi jokeriVarisuoraKasi = new Kasi();
        
        jokeriVarisuoraKasi.lisaaKortti(hertta2);
        jokeriVarisuoraKasi.lisaaKortti(jokeri);
        jokeriVarisuoraKasi.lisaaKortti(hertta3);
        jokeriVarisuoraKasi.lisaaKortti(hertta4);
        jokeriVarisuoraKasi.lisaaKortti(hertta5);
        
        assertTrue(jokeriVarisuoraKasi.onkoVarisuora());
    }
    
    @Test
    public void kadessaOnSuoraKahdellaJokerilla() {
        Kasi kaksiJokeriaSuoraKasi = new Kasi();
        
        kaksiJokeriaSuoraKasi.lisaaKortti(hertta2);
        kaksiJokeriaSuoraKasi.lisaaKortti(ruutu4);
        kaksiJokeriaSuoraKasi.lisaaKortti(hertta3);
        kaksiJokeriaSuoraKasi.lisaaKortti(jokeri);
        kaksiJokeriaSuoraKasi.lisaaKortti(jokeri);
        
        assertTrue(kaksiJokeriaSuoraKasi.onkoSuora());
        
    }
    
    @Test
    public void kadessaOnVariKahdellaJokerilla() {
        Kasi kaksiJokeriaVariKasi = new Kasi();
        
        kaksiJokeriaVariKasi.lisaaKortti(hertta2);
        kaksiJokeriaVariKasi.lisaaKortti(hertta10);
        kaksiJokeriaVariKasi.lisaaKortti(hertta3);
        kaksiJokeriaVariKasi.lisaaKortti(jokeri);
        kaksiJokeriaVariKasi.lisaaKortti(jokeri);
        
        assertTrue(kaksiJokeriaVariKasi.onkoVari());
        
    }
    
    @Test
    public void kadessaOnVarisuoraKahdellaJokerilla() {
        Kasi kaksiJokeriaSuoraKasi = new Kasi();
        
        kaksiJokeriaSuoraKasi.lisaaKortti(hertta2);
        kaksiJokeriaSuoraKasi.lisaaKortti(hertta4);
        kaksiJokeriaSuoraKasi.lisaaKortti(hertta3);
        kaksiJokeriaSuoraKasi.lisaaKortti(jokeri);
        kaksiJokeriaSuoraKasi.lisaaKortti(jokeri);
        
        assertTrue(kaksiJokeriaSuoraKasi.onkoVarisuora());
        
    }
}
