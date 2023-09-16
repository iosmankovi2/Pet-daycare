package ba.unsa.etf.rpr;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ilhana
 * @version 1.0
 */

public class KucniLjubimacTest {


    /* Testira getter za ime kućnog ljubimca.

    @Test

    public void testGetIme(){

        //Kreiramo mock objekat za KucniLjubimac

        KucniLjubimac mockljubimac = mock(KucniLjubimac.class);

        //Postavljamo očekivanje da mockLjubimac.getIme() vrati "Buddy"

        when(mockljubimac.getIme()).thenReturn("Buddy");

        //Poziv metode koju testiramo

        String imeLjubimca = mockljubimac.getIme();

        //Provjera očekivanja

        assertEquals("Buddy",imeLjubimca);
    }*/

    /* Testira getter za vrstu kućnog ljubimca.*/

    @Test

    public void testGetVrsta(){
        KucniLjubimac ljubimac = new KucniLjubimac("Fren","Mačka");
        assertEquals("Mačka",ljubimac.getVrsta());
    }
}
