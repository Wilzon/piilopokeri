
package piilopokeri.domain;

import java.util.Random;

/** @author Wilzon */

public class Kone extends Pelaaja{
    Random random;
    
    public Kone() {
        random = new Random();
        
        int luku = random.nextInt(10);
        
        if(luku == 0) {
            super.nimi = "PeteBOT";
        }
        if(luku == 1) {
            super.nimi = "TapaniBOT";
        }
        if(luku == 2) {
            super.nimi = "SeppoBOT";
        }
        if(luku == 3) {
            super.nimi = "MattiBOT";
        }
        if(luku == 4) {
            super.nimi = "AhtiBOT";
        }
        if(luku == 5) {
            super.nimi = "LauraBOT";
        }
        if(luku == 6) {
            super.nimi = "SaraBOT";
        }
        if(luku == 7) {
            super.nimi = "EmmaBOT";
        }
        if(luku == 8) {
            super.nimi = "IdaBOT";
        }
        if(luku == 9) {
            super.nimi = "MariaBOT";
        }
    }
    
    @Override
    public boolean onkoKone() {
        return true;
    }

    @Override
    public int haluttuJarjestys() {
        return 2;
    }
    
    
    
}
