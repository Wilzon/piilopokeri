
package piilopokeri.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class Kasi3Test {
    Kortti hertta2;
    Kortti ruutu2;
    Kortti risti2;
    Kortti pata2;
    
    Kortti hertta3;
    Kortti ruutu3;
    Kortti risti3;
    Kortti pata3;
    
    Kortti hertta4;
    Kortti ruutu4;
    Kortti risti4;
    Kortti pata4;
    
    Kortti hertta5;
    Kortti ruutu5;
    Kortti risti5;
    Kortti pata5;
    
    Kortti hertta6;
    Kortti ruutu6;
    Kortti risti6;
    Kortti pata6;
    
    Kortti hertta7;
    Kortti ruutu7;
    Kortti risti7;
    Kortti pata7;
    
    Kortti jokeri;

    @Before
    public void setUp() {
        hertta2 = new Kortti(2, Kortti.HERTTA);
        ruutu2 = new Kortti(2, Kortti.RUUTU);
        risti2 = new Kortti(2, Kortti.RISTI);
        pata2 = new Kortti(2, Kortti.PATA);
        
        hertta3 = new Kortti(3, Kortti.HERTTA);
        ruutu3 = new Kortti(3, Kortti.RUUTU);
        risti3 = new Kortti(3, Kortti.RISTI);
        pata3 = new Kortti(3, Kortti.PATA);
        
        hertta4 = new Kortti(4, Kortti.HERTTA);
        ruutu4 = new Kortti(4, Kortti.RUUTU);
        risti4 = new Kortti(4, Kortti.RISTI);
        pata4 = new Kortti(4, Kortti.PATA);
        
        hertta5 = new Kortti(5, Kortti.HERTTA);
        ruutu5 = new Kortti(5, Kortti.RUUTU);
        risti5 = new Kortti(5, Kortti.RISTI);
        pata5 = new Kortti(5, Kortti.PATA);
        
        hertta6 = new Kortti(6, Kortti.HERTTA);
        ruutu6 = new Kortti(6, Kortti.RUUTU);
        risti6 = new Kortti(6, Kortti.RISTI);
        pata6 = new Kortti(6, Kortti.PATA);
        
        hertta7 = new Kortti(7, Kortti.HERTTA);
        ruutu7 = new Kortti(7, Kortti.RUUTU);
        risti7 = new Kortti(7, Kortti.RISTI);
        pata7 = new Kortti(7, Kortti.PATA);
        
        jokeri = new Kortti(15, Kortti.JOKERI);
    }
    
    @Test
    public void kadessaOnKolmeParia() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        assertTrue(kasi.onkoKolmeParia());
    }
    
    @Test
    public void kadessaOnNeljaParia() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        
        assertTrue(kasi.onkoNeljaParia());
    }
    
    @Test
    public void kadessaOnViisiParia() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
       
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        
        kasi.lisaaKortti(hertta6);
        kasi.lisaaKortti(ruutu6);
        
        assertTrue(kasi.onkoViisiParia());
    }
    
    @Test
    public void kadessaOnKuusiParia() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        
        kasi.lisaaKortti(hertta6);
        kasi.lisaaKortti(ruutu6);
        
        kasi.lisaaKortti(hertta7);
        kasi.lisaaKortti(ruutu7);
        
        assertTrue(kasi.onkoKuusiParia());
    }
    
    @Test
    public void kadessaOnKahdetKolmoset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        
        assertTrue(kasi.onkoKahdetKolmoset());
    }
    
    @Test
    public void kadessaOnKolmetKolmoset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        
        assertTrue(kasi.onkoKolmetKolmoset());
    }
    
    @Test
    public void kadessaOnNeljatKolmoset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        kasi.lisaaKortti(risti5);
        
        assertTrue(kasi.onkoNeljatKolmoset());
    }
    
    @Test
    public void kadessaOnKahdetNeloset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        kasi.lisaaKortti(pata2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        
        assertTrue(kasi.onkoKahdetNeloset());
    }
    
    @Test
    public void kadessaOnKutosetJaNelosetJaKolmoset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        kasi.lisaaKortti(pata2);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        
        assertTrue(kasi.onkoKutosetJaNelosetJaKolmoset());
    }
    
    @Test
    public void kadessaOnKutosetJaKahdetKolmoset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        
        assertTrue(kasi.onkoKutosetJaKahdetKolmoset());
    }
    
    @Test
    public void kadessaOnKutosetJaKolmosetJaKaksiParia() {
        Kasi kasi = new Kasi(); 
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        
        assertTrue(kasi.onkoKutosetJaKolmosetJaKaksiParia());
    }
    
    @Test
    public void kadessaOnKutosetJaKolmeParia() {
        Kasi kasi = new Kasi(); 
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(ruutu5);
        
        assertTrue(kasi.onkoKutosetJaKolmeParia());
    }
    
    @Test
    public void kadessaOnKutosetJaKaksiParia() {
        Kasi kasi = new Kasi(); 
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        
        
        assertTrue(kasi.onkoKutosetJaKaksiParia());
    }
    
    @Test
    public void kadessaOnKutosetJaPari() {
        Kasi kasi = new Kasi(); 
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        kasi.lisaaKortti(jokeri);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        
        assertTrue(kasi.onkoKutosetJaPari());
    }
    
    @Test
    public void kadessaOnVitosetJaKahdetNeloset() {
        Kasi kasi = new Kasi(); 
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        kasi.lisaaKortti(pata4);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        kasi.lisaaKortti(pata2);
        
        
        assertTrue(kasi.onkoVitosetJaKahdetNeloset());
    }
    
    @Test
    public void kadessaOnKolmetNeloset() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        kasi.lisaaKortti(pata4);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        kasi.lisaaKortti(pata3);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        kasi.lisaaKortti(pata2);
        
        
        assertTrue(kasi.onkoKolmetNeloset());
    }
    
    @Test
    public void kadessaOnNelosetJaKahdetKolmosetJaPari() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        kasi.lisaaKortti(pata4);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);

        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(pata5);
        
        assertTrue(kasi.onkoNelosetJaKahdetKolmosetJaPari());
    }
    
    @Test
    public void kadessaOnVitosetJaKolmosetJaKaksiParia() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta4);
        kasi.lisaaKortti(ruutu4);
        kasi.lisaaKortti(risti4);
        kasi.lisaaKortti(pata4);
        kasi.lisaaKortti(jokeri);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        kasi.lisaaKortti(risti3);
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);

        kasi.lisaaKortti(hertta5);
        kasi.lisaaKortti(pata5); 
            
        assertTrue(kasi.onkoVitosetJaKolmosetJaKaksiParia());
    }
    
    
    @Test
    public void kadessaOnNelosetJaPari() {
        Kasi kasi = new Kasi();
        
        kasi.lisaaKortti(hertta2);
        kasi.lisaaKortti(ruutu2);
        kasi.lisaaKortti(risti2);
        kasi.lisaaKortti(pata2);
        
        kasi.lisaaKortti(hertta3);
        kasi.lisaaKortti(ruutu3);
        
        assertTrue(kasi.onkoNelosetJaPari());
        
    }
}
