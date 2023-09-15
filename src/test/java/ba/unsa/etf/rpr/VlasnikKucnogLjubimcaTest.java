package ba.unsa.etf.rpr;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

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

}
