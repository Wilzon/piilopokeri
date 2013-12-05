
package piilopokeri.domain;

import java.util.Random;

/** @author Wilzon */

public class Kone extends Pelaaja{
    Random random;
    
    public Kone() {
        random = new Random();
        
        arvoNimi();
    }
    
    @Override
    public boolean onkoKone() {
        return true;
    }

    @Override
    public int haluttuJarjestys() {
        return 2;
    }
    
    public void setUusiNimi() {
        arvoNimi();
    }
    
    public void arvoNimi() {
        int luku = random.nextInt(20);
        
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
        if(luku == 10) {
            super.nimi = "HeikkiBOT";
            
        }
        if(luku == 11) {
            super.nimi = "HarriBOT";
            
        }
        if(luku == 12) {
            super.nimi = "EskoBOT";
            
        }
        if(luku == 13) {
            super.nimi = "OskariBOT";
            
        }
        if(luku == 14) {
            super.nimi = "SakariBOT";
            
        }
        if(luku == 15) {
            super.nimi = "VenlaBOT";
            
        }
        if(luku == 16) {
            super.nimi = "EllaBOT";
            
        }
        if(luku == 17) {
            super.nimi = "SofiaBOT";
            
        }
        if(luku == 18) {
            super.nimi = "AnniBOT";
            
        }
        if(luku == 19) {
            super.nimi = "HelmiBOT";
            
        }
        
    }
    
    
    
}
