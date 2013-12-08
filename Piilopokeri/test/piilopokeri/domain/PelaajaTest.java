

package piilopokeri.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Otto
 */
public class PelaajaTest {
    Piilopokeri pokeri;
    Pelaaja pelaaja;
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Heikki");
        pokeri = new Piilopokeri();
    }
    
    @Test
    public void pelaajalleVoiAsettaaNimen() {
        assertEquals("Heikki", pelaaja.getNimi());
    }
    
    @Test
    public void ihmisPelaajaEiOleKone() {
        assertFalse(pelaaja.onkoKone());
    }
    
    @Test
    public void pelaajalleVoiLisataKaden() {
        Kasi kasi = pokeri.getUudetKortit(5);
        
        pelaaja.lisaaKasi(kasi);
        
        assertEquals(kasi, pelaaja.getKasi());
    }
    
    @Test
    public void pelaajalleVoiAsettaaJarjestyksen() {
        pelaaja.setHaluttuJarjestys(1);
        
        assertEquals(1, pelaaja.getHaluttuJarjestys());
    }
}
