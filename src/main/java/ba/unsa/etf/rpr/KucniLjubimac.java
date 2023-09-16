package ba.unsa.etf.rpr;

import java.io.Serializable;

/**
 * Klasa predstavlja kućnog ljubimca.
 *
 * @author Ilhana
 * @version 1.0
 */

public class KucniLjubimac implements Serializable {

    private String ime;
    private String vrsta;

    private Integer id;

    /**
     * Prazan konstruktor zbog JavaBeans-a
     */

    public KucniLjubimac(){
    }

    /**
     * Konstruktor za kućnog ljubimca.
     *
     * @param ime Ime kućnog ljubimca
     * @param vrsta Vrsta kućnog ljubimca
     */

    public KucniLjubimac(String ime, String vrsta){
        this.ime = ime;
        this.vrsta = vrsta;
    }

    /**
     * Getter za atribut ime
     * @return ime;
     */

    public String getIme(){
        return ime;
    }

    /**
     * Getter za atribut vrsta
     * @return vrsta
     */

    public String getVrsta(){
        return vrsta;
    }

    /*
     * Setteri za atribute ime i vrsta
     */

    public void setIme(String ime){
        this.ime = ime;
    }

    public void setVrsta(String vrsta){
        this.vrsta = vrsta;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
}
