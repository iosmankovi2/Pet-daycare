package ba.unsa.etf.rpr;

/**
 * Klasa predstavlja kućnog ljubimca.
 *
 * @author Ilhana
 * @version 1.0
 */

public class KucniLjubimac {

    private String ime;
    private String vrsta;

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

}
