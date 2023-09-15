package ba.unsa.etf.rpr;

import java.util.Date;

/**
 *Klasa predstavlja rezervaciju u vrtiću za kućne ljubimce
 *
 * @author Ilhana
 * @version 1.0
 */

public class Rezervacija {
    private VlasnikKucnogLjubimca vlasnik;
    private KucniLjubimac ljubimac;
    private Date datum;

    /**
     * Konstruktor za rezervaciju
     *
     * @param vlasnik Vlasnik kućnog ljbimca koji je rezerviše.
     * @param ljubimac Kućni ljubimac koji se rezerviše.
     * @param datum Datum rezervacije.
     */

    public Rezervacija(VlasnikKucnogLjubimca vlasnik, KucniLjubimac ljubimac, Date datum){
        this.vlasnik = vlasnik;
        this.ljubimac = ljubimac;
        this.datum = datum;
    }

    public VlasnikKucnogLjubimca getVlasnik(){
        return vlasnik;
    }

    public KucniLjubimac getLjubimac(){
        return ljubimac;
    }

    public Date getDatum(){
        return datum;
    }
}

