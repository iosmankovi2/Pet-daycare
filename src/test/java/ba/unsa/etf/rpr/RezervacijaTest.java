package ba.unsa.etf.rpr;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Date;

public class RezervacijaTest {

    /**
     * Testira getter za vlasnika rezervacije
     */
    @Test

    public void testGetVlasnik(){
        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca("Hana","Hanić");
        KucniLjubimac ljubimac = new KucniLjubimac("Fren","Mačka");
        Rezervacija rezervacija = new Rezervacija(vlasnik,ljubimac,new Date(),new Date());

        assertEquals(vlasnik,rezervacija.getVlasnik());
    }

}
