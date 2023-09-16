package ba.unsa.etf.rpr;

import org.junit.Test;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VrticTest {

    /**
     * Testira getter za naziv vrtića.
     */
    @Test

    public void testGetNaziv(){
        Vrtic vrtic = new Vrtic("Pet daycare");
        assertEquals("Pet daycare",vrtic.getNaziv());
    }


    /**
     * Kreiramo mock objekte za rezervaciju, vlansika i ljubimca.
     */

    @Test

    public void testDodajRezervaciju(){

        Rezervacija mockRezervacija = mock(Rezervacija.class);
        VlasnikKucnogLjubimca mockVlasnik = mock(VlasnikKucnogLjubimca.class);
        KucniLjubimac mockLjubimac = mock(KucniLjubimac.class);

        //Kreiramo vrtić

        Vrtic vrtic = new Vrtic("Pet daycare");

        //Postavljamo očekivanja za mockRezrervacija, mockVlasnik i mockLjubimac

        when(mockRezervacija.getVlasnik()).thenReturn(mockVlasnik);
        when(mockRezervacija.getLjubimac()).thenReturn(mockLjubimac);

        //Pozivamo metodu koju testiramo
        vrtic.dodajRezervaciju(mockRezervacija);

        //Provjeravamo da li je rezervacija dodana u vrtić

        assertTrue(vrtic.getRezervacije().contains(mockRezervacija));
    }

}
