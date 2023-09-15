package ba.unsa.etf.rpr;

import java.util.Date;

/**
 *Klasa predstavlja rezervaciju u vrtiću za kućne ljubimce.
 *
 * @author Ilhana
 * @version 1.0
 */

public class Rezervacija {
    private VlasnikKucnogLjubimca vlasnik;
    private KucniLjubimac ljubimac;
    private Date datumRezervacije;
    private Date datumIzvrsenjaRezervacije;

    /**
     * Konstruktor za rezervaciju
     *
     * @param vlasnik Vlasnik kućnog ljbimca koji je rezerviše.
     * @param ljubimac Kućni ljubimac koji se rezerviše.
     * @param datumRezervacije Datum rezervacije.
     * @param datumIzvrsenjaRezervacije Datum kada je rezervacija izvršena.
     */

    public Rezervacija(VlasnikKucnogLjubimca vlasnik, KucniLjubimac ljubimac, Date datumRezervacije, Date datumIzvrsenjaRezervacije){
        this.vlasnik = vlasnik;
        this.ljubimac = ljubimac;
        this.datumRezervacije = datumRezervacije;
        this.datumIzvrsenjaRezervacije = datumIzvrsenjaRezervacije;
    }

    public VlasnikKucnogLjubimca getVlasnik(){
        return vlasnik;
    }

    public KucniLjubimac getLjubimac(){
        return ljubimac;
    }

    public Date getDatumRezervacije(){
        return datumRezervacije;
    }

    public Date getDatumIzvrsenjaRezervacije(){
        return datumIzvrsenjaRezervacije;
    }
}

