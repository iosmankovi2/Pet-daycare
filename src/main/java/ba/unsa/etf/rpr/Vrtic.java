package ba.unsa.etf.rpr;

/**
 * Klasa predstavlja vrtić za kućne ljubimce.
 */

import java.util.ArrayList;/

public class Vrtic {

    private String naziv;
    private List<Rezervacija> rezervacije;

    /**
     * Konstruktor za vrtić za kućne ljubimce.
     *
     * @param naziv Naziv vrtića.
     */

    public Vrtic(String naziv){
        this.naziv = naziv;
        this.rezervacije = new ArrayList<>();
    }

    public String getNaziv(){
        return naziv;
    }

}
