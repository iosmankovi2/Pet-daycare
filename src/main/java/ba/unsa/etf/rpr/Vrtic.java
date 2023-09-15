package ba.unsa.etf.rpr;

/**
 * Klasa predstavlja vrtić za kućne ljubimce.
 *
 * @author Ilhana Osmanković
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;/

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

    /**
     * Dodaje rezervaciju u vrtić.
     *
     * @param rezervacija Rezervacija koja se dodaje.
     */

    public void dodajRezervaciju(Rezervacija rezervacija){
        rezervacije.add(rezervacija);
    }

    public List<Rezervacija> getRezervacije(){
        return rezervacije;
    }
}

