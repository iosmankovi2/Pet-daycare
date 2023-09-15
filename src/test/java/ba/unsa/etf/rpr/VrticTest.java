package ba.unsa.etf.rpr;

import org.junit.Test;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class VrticTest {

    /**
     * Testira dodavanje rezervacije u vrtić.
     */
    @Test

    public void testDodajRezervaciju() {
        Vrtic vrtic = new Vrtic("Pet daycare");
        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca("Hana","Hanić");
        KucniLjubimac ljubimac = new KucniLjubimac("Fren","Mačka");
        Rezervacija rezervacija = new Rezervacija(vlasnik,ljubimac,new Date(),new Date());

        vrtic.dodajRezervaciju(rezervacija);

        List<Rezervacija> rezervacije = vrtic.getRezervacije();
        assertTrue(rezervacije.contains(rezervacija));
    }

}
