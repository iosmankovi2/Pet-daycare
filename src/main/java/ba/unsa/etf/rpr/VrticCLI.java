package ba.unsa.etf.rpr;

/**
 * Terminalni korisnicki interfejs
 */

import ba.unsa.etf.rpr.DAOImplements.KucniLjubimacDAOImpements;
import ba.unsa.etf.rpr.DAOImplements.RezervacijaDAOImplements;
import ba.unsa.etf.rpr.DAOImplements.VlasnikKucnogLjubimcaDAOImplements;
import ba.unsa.etf.rpr.Dao.KucniLjubimacDAO;
import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Dao.VlasnikKucnogLjubimcaDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VrticCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicijalizacija repozitorija (DAO objekti)
        VlasnikKucnogLjubimcaDAO vlasnikDAO = new VlasnikKucnogLjubimcaDAOImplements();
        KucniLjubimacDAO kucniLjubimacDAO = new KucniLjubimacDAOImpements();
        RezervacijaDAO rezervacijaDAO = new RezervacijaDAOImplements();

        while (true) {
            System.out.println("\nDobrodošli u Pet daycare!");
            System.out.println("Odaberite opciju:");
            System.out.println("1. Dodaj rezervaciju");
            System.out.println("2. Prikaži sve rezervacije");
            System.out.println("3. Izlaz");

            int opcija = scanner.nextInt();
            scanner.nextLine();  // Čisti unos

            switch (opcija) {
                case 1:
                    System.out.println("Unesite ime vlasnika:");
                    String imeVlasnika = scanner.nextLine();

                    System.out.println("Unesite prezime vlasnika:");
                    String prezimeVlasnika = scanner.nextLine();

                    System.out.println("Unesite ime kućnog ljubimca:");
                    String imeLjubimca = scanner.nextLine();

                    System.out.println("Unesite vrstu kućnog ljubimca:");
                    String vrstaLjubimca = scanner.nextLine();

                  //  System.out.println("Unesite datum rezervacije (YYYY-MM-DD):");
                    //        String datumStr = scanner.nextLine();

                    Date datumRezervacije = null;
                    boolean validanDatum = false;
                    while (!validanDatum) {
                        System.out.println("Unesite datum rezervacije (YYYY-MM-DD):");
                        String datumStr = scanner.nextLine();

                        try {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            datumRezervacije = dateFormat.parse(datumStr);
                            validanDatum = true;
                        } catch (java.text.ParseException e) {
                            System.out.println("Neispravan format datuma. Molimo unesite datum u formatu YYYY-MM-DD.");
                        }
                    }
                        // Kreiraj objekte vlasnika, ljubimca i rezervacije
                        VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca(imeVlasnika, prezimeVlasnika);
                        KucniLjubimac ljubimac = new KucniLjubimac(imeLjubimca, vrstaLjubimca);
                        Rezervacija rezervacija = new Rezervacija(vlasnik, ljubimac, datumRezervacije);

                        // Dodaj rezervaciju u bazu
                        rezervacijaDAO.insert(rezervacija);
                        System.out.println("Rezervacija uspješno dodana!");
                 //   } catch (DateTimeParseException e) {
                   //     System.out.println("Neispravan format datuma. Molimo unesite datum u formatu YYYY-MM-DD.");
                   // }
                    break;
                case 2:
                    // Prikazi sve rezervacije
                    List<Rezervacija> rezervacije = rezervacijaDAO.getAll();
                    if (rezervacije.isEmpty()) {
                        System.out.println("Nema dostupnih rezervacija.");
                    } else {
                        System.out.println("Sve rezervacije:");
                        for (Rezervacija rez : rezervacije) {
                            System.out.println(rez);
                        }
                    }
                    break;
                case 3:
                    // Izlaz iz aplikacije
                    System.out.println("Hvala što ste koristili aplikaciju. Doviđenja!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nepodržana opcija. Molimo odaberite ispravnu opciju.");
                    break;
            }
        }
    }
}






