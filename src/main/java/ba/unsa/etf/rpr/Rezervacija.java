package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;
/**
 *Klasa predstavlja rezervaciju u vrtiću za kućne ljubimce.
 *
 * @author Ilhana
 * @version 1.0
 */

public class Rezervacija implements Serializable {

    private Integer id;
    private VlasnikKucnogLjubimca vlasnik;
    private KucniLjubimac ljubimac;
    private Date datumRezervacije;
    private Date datumIzvrsenjaRezervacije;

    /**
     * Prazan konstruktor zbog JavaBeans-a
     */

    private Rezervacija(){
    }

    //fleksibilno kreiranje objekata bez potrebe za
    // dugim konstruktorima sa mnogo parametara.

    public static class Builder {
        private Rezervacija novaRezervacija;

        public Builder() {
            novaRezervacija = new Rezervacija();
        }

        public Builder saVlasnikom(VlasnikKucnogLjubimca vlasnik) {
            novaRezervacija.vlasnik = vlasnik;
            return this;
        }

        public Builder saLjubimcem(KucniLjubimac ljubimac) {
            novaRezervacija.ljubimac = ljubimac;
            return this;
        }

        public Builder saDatumomRezervacije(Date datumRezervacije) {
            novaRezervacija.datumRezervacije = datumRezervacije;
            return this;
        }

        public Builder saDatumomIzvrsenjaRezervacije(Date datumIzvrsenjaRezervacije) {
            novaRezervacija.datumIzvrsenjaRezervacije = datumIzvrsenjaRezervacije;
            return this;
        }

        public Rezervacija build() {
            return novaRezervacija;
        }
    }




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

    public Rezervacija(VlasnikKucnogLjubimca vlasnik, KucniLjubimac ljubimac, Date datum) {
    }

    public VlasnikKucnogLjubimca getVlasnik(){
        return vlasnik;
    }

    public void setVlasnik(VlasnikKucnogLjubimca vlasnik){
        this.vlasnik = vlasnik;
    }

    public KucniLjubimac getLjubimac(){
        return ljubimac;
    }

    public void setLjubimac(KucniLjubimac ljubimac){
        this.ljubimac = ljubimac;
    }

    public Date getDatumRezervacije(){
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije){
        this.datumRezervacije = datumRezervacije;
    }

    public Date getDatumIzvrsenjaRezervacije(){
        return datumIzvrsenjaRezervacije;
    }

    public void setDatumIzvrsenjaRezervacije(Date datumIzvrsenjaRezervacije){
        this.datumIzvrsenjaRezervacije = datumIzvrsenjaRezervacije;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public static void main(String[] args) {
        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
        KucniLjubimac ljubimac = new KucniLjubimac();
        Date datumRezervacije = new Date();
        Date datumIzvrsenjaRezervacije = new Date();

        Rezervacija rezervacija = new Rezervacija.Builder()
                .saVlasnikom(vlasnik)
                .saLjubimcem(ljubimac)
                .saDatumomRezervacije(datumRezervacije)
                .saDatumomIzvrsenjaRezervacije(datumIzvrsenjaRezervacije)
                .build();
    }

}

