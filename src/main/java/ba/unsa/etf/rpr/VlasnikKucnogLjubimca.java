package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predstavlja vlasnika kućnih ljubimaca.
 */

public class VlasnikKucnogLjubimca {

    private String ime;
    private String prezime;
    private List<KucniLjubimac> ljubimci;

    /**
     * Konstruktor za vlasnika kućnih ljubimaca.
     *
     * @param ime Ime vlasnika.
     * @param prezime Prezima vlasnika
     */

    public VlasnikKucnogLjubimca(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
        this.ljubimci = new ArrayList<>();
    }

    /**
     * Getteri za atribute ime i prezime
     */

    public String getIme(){
        return ime;
    }

    public String getPrezime(){
        return prezime;
    }

    /**
     * Setteri za atribute ime i prezime
     */

    public void setIme(String ime){
        this.ime = ime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    /**
     * Dodaje kućnog ljubimca vlasniku.
     *
     * @param ljubimac Kućni ljubimac koji se dodaje.
     */

    public void dodajLjubimca(KucniLjubimac ljubimac) {
        ljubimci.add(ljubimac);
    }

    public List<KucniLjubimac> getLjubimci() {
        return ljubimci;
    }
}
