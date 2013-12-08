
package piilopokeri.domain;

import java.util.Random;

/** @author Wilzon */

public class Kone extends Pelaaja{
    
    public Kone() {
        arvoNimi();
    }
    
    @Override
    public boolean onkoKone() {
        return true;
    }

    @Override
    public int getHaluttuJarjestys() {
        return 1;
    }
    
    public void arvoUusiNimi() {
        arvoNimi();
    }
    
    public final void arvoNimi() {
        Random random = new Random();
        
        int luku = random.nextInt(20);
        
        if(luku == 0) {
            setNimi("PeteBOT");
            
        }
        if(luku == 1) {
            setNimi("TapaniBOT");
            
        }
        if(luku == 2) {
            setNimi("SeppoBOT");
            
        }
        if(luku == 3) {
            setNimi("MattiBOT");
            
        }
        if(luku == 4) {
            setNimi("AhtiBOT");
            
        }
        if(luku == 5) {
            setNimi("LauraBOT");
            
        }
        if(luku == 6) {
            setNimi("SaraBOT");
            
        }
        if(luku == 7) {
            setNimi("EmmaBOT");
            
        }
        if(luku == 8) {
            setNimi("IdaBOT");
            
        }
        if(luku == 9) {
            setNimi("MariaBOT");
            
        }
        if(luku == 10) {
            setNimi("HeikkiBOT");
            
        }
        if(luku == 11) {
            setNimi("HarriBOT");
            
        }
        if(luku == 12) {
            setNimi("EskoBOT");
            
        }
        if(luku == 13) {
            setNimi("OskariBOT");
            
        }
        if(luku == 14) {
            setNimi("SakariBOT");
            
        }
        if(luku == 15) {
            setNimi("VenlaBOT");
            
        }
        if(luku == 16) {
            setNimi("EllaBOT");
            
        }
        if(luku == 17) {
            setNimi("SofiaBOT");
            
        }
        if(luku == 18) {
            setNimi("AnniBOT");
            
        }
        if(luku == 19) {
            setNimi("HelmiBOT");
            
        }
    }
}
