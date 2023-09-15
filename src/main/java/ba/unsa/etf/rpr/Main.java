package ba.unsa.etf.rpr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite datum rezervacije (dd-MM-yyyy): ");
        String datum = ulaz.nextLine();

        /*Parsiranje iz string formata (dd-MM-yyyy) u objekat tipa Date.
          Ako korisnik unese ispravan format datuma, datumRezervacije će sadržavati datum kao Date object.
          U suprotnom, baca se izuzetak, šalje poruka i zatvara prgram.

         */

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date datumRezervacije = null;

        try {
            datumRezervacije = dateFormat.parse(datum);
        }catch(ParseException e){
            System.out.println("Neispravan format datuma. Upotrijebite format dd-MM-yyyy.");
            ulaz.close();
            System.exit(1);
        }

        VlasnikKucnogLjubimca vlasnik1 = new VlasnikKucnogLjubimca("Hana", "Hanić");
        KucniLjubimac ljubimac1 = new KucniLjubimac("Fren","Mačka");
        vlasnik1.dodajLjubimca(ljubimac1);

        Vrtic vrtic = new Vrtic("Pet daycare");
        Date datumIzvrsenjaRezervacije = new Date();
        Rezervacija rezervacija = new Rezervacija(vlasnik1,ljubimac1,datumRezervacije,datumIzvrsenjaRezervacije);
        vrtic.dodajRezervaciju(rezervacija);

        //Prikaz rezervacije u vrtiću

        List<Rezervacija> rezervacije = vrtic.getRezervacije();
        for(Rezervacija r: rezervacije) {
            System.out.println("Rezervacija za: "+r.getVlasnik().getIme() + " "+r.getVlasnik().getPrezime());
            System.out.println("Ljubimac: "+r.getLjubimac().getIme());
            System.out.println("Datum rezervacije: "+r.getDatumRezervacije());
            System.out.println("Datum izvršenja rezervacije: "+r.getDatumIzvrsenjaRezervacije());
        }
        ulaz.close();
    }
}
