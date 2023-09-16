package ba.unsa.etf.rpr;

/**
 * Klasa predstavlja vrtić za kućne ljubimce.
 *
 * @author Ilhana Osmanković
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Vrtic implements Serializable {

    private String naziv;
    private List<Rezervacija> rezervacije;

    /**
     * Prazan konstruktor zbog JavaBeans-a
     */

    public Vrtic(){
    }

    /**
     * Konstruktor za vrtić za kućne ljubimce.
     *
     * @param naziv Naziv vrtića.
     */

    public Vrtic(String naziv){
        this.naziv = naziv;
        this.rezervacije = new ArrayList<>();
    }

    /**
     * Getteri i setteri zbog JavaBeans-a
     * @return naziv
     */

    public String getNaziv(){
        return naziv;
    }

    public void setNaziv(String naziv){
        this.naziv = naziv;
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

    public void setRezervacije(List<Rezervacija> rezervacije){
        this.rezervacije = rezervacije;
    }
}

