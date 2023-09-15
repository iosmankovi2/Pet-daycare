package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

/**
 *Primjer upotrebe klasa
 *
 * @author Ilhana
 * @version 1.0
 */
public class Main
{
    public static void main( String[] args )
    {
        VlasnikKucnogLjubimca vlasnik1 = new VlasnikKucnogLjubimca("Hana", "Hanić");
        KucniLjubimac ljubimac1 = new KucniLjubimac("Fren","Mačka");
        vlasnik1.dodajLjubimca(ljubimac1);

        Vrtic vrtic = new Vrtic("Pet daycare");
        Date datumRezervacije = new Date();
        Rezervacija rezervacija = new Rezervacija(vlasnik1,ljubimac1,datumRezervacije);
        vrtic.dodajRezervaciju(rezervacija);

        //Prikaz rezervacije u vrtiću

        List<Rezervacija> rezervacije = vrtic.getRezervacije();
        for(Rezervacija r: rezervacije) {
            System.out.println("Rezervacija za: "+r.getVlasnik().getIme() + " "+r.getVlasnik().getPrezime());
            System.out.println("Ljubimac: "+r.getLjubimac().getIme());
            System.out.println("Datum rezervacije: "+r.getDatum());
        }
        System.out.println( "Hello World!" );
    }
}
