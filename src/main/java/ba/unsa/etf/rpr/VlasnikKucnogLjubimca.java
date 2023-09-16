package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predstavlja vlasnika kućnih ljubimaca.
 *
 * @author Ilhana
 * @version 1.0
 */

public class VlasnikKucnogLjubimca implements Serializable {

    private String ime;
    private String prezime;
    private List<KucniLjubimac> ljubimci;

    private Integer id;

    /**
     * Prazan konstruktor zbog JavaBeans-a
     */

    public VlasnikKucnogLjubimca(){
    }

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

    /**
     * Getter i setter za listu ljubimaca zbog JavaBeansa-a
     */
    public List<KucniLjubimac> getLjubimci() {
        return ljubimci;
    }

    public void setLjubimci(List<KucniLjubimac> ljubimci){
        this.ljubimci = ljubimci;

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
}
