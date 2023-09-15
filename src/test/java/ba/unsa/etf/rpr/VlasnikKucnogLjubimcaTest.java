package ba.unsa.etf.rpr;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class VlasnikKucnogLjubimcaTest {

    /**
     * Testira dodavanje kućnog ljubimca vlasniku.
     */
    @Test

    public void testDodajLjubimca(){
        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca("Hana","Hanić");
        KucniLjubimac ljubimac = new KucniLjubimac("Fren","Mačka");

        vlasnik.dodajLjubimca(ljubimac);

        List<KucniLjubimac> ljubimci = vlasnik.getLjubimci();
        assertTrue(ljubimci.contains(ljubimac));
    }

    /**
     * Testira getter za ime vlasnika kućnih ljubimaca.
     */
    @Test

    public void testGetIme(){
        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca("Hana","Hanić");
        assertEquals("Hana",vlasnik.getIme());
    }

}
