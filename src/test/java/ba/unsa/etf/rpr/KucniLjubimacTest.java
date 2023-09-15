package ba.unsa.etf.rpr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ilhana
 * @version 1.0
 */

public class KucniLjubimacTest {


    /**
     * Testira getter za ime kućnog ljubimca.
     */
    @Test

    public void testGetIme(){
        KucniLjubimac ljubimac = new KucniLjubimac("Fren","Mačka");
        assertEquals("Fren",ljubimac.getIme());
    }
}
