package ba.unsa.etf.rpr.PetdaycareUI;

import ba.unsa.etf.rpr.DAOImplements.KucniLjubimacDAOImplements;
import ba.unsa.etf.rpr.DAOImplements.RezervacijaDAOImplements;
import ba.unsa.etf.rpr.DAOImplements.VlasnikKucnogLjubimcaDAOImplements;
import ba.unsa.etf.rpr.Dao.KucniLjubimacDAO;
import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Dao.VlasnikKucnogLjubimcaDAO;
import ba.unsa.etf.rpr.KucniLjubimac;
import ba.unsa.etf.rpr.Rezervacija;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
//import javax.swing.text.html.ListView;
//import java.awt.*;
//import java.util.List;
import javafx.scene.control.ListView;

/**
 * UI sa minimalno pet JavaFX komponenti "Tekstualno polje, DatePicker, ListView i dugme"
 *
 * @author Ilhana
 * @version 1.0
 *
 */


public class VrticUI extends Application {

    private VlasnikKucnogLjubimcaDAO vlasnikDAO;
    private KucniLjubimacDAO kucniLjubimacDAO;
    private RezervacijaDAO rezervacijaDAO;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pet daycare");

        //Inicijalizacija repozitorija

        vlasnikDAO = new VlasnikKucnogLjubimcaDAOImplements();
        kucniLjubimacDAO = new KucniLjubimacDAOImplements();
        rezervacijaDAO = new RezervacijaDAOImplements();

        //Kreiranje korijenskog kontejnera - VBox

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        //Labela za unos imena vlasnika

        Label imeLabel = new Label("Ime vlasnika:");
        final TextField imeField = new TextField();

        //Labela za unos prezimena vlasnika

        Label prezimeLabel = new Label("Prezime vlasnika:");
        final TextField prezimeField = new TextField();

        //Labela za unos imena kućnog ljubimca

        Label ljubimacImeLabel = new Label("Ime kućnog ljubimca:");
        final TextField ljubimacImeField = new TextField();

        //Labela za unos vrste kućnog ljubimca

        Label ljubimacVrstaLabel = new Label("Vrsta kućnog ljubimca:");
        final TextField ljubimacVrstaField = new TextField();

        //DatePicker za odabir datuma rezervacije

        Label datumLabel = new Label("Datum rezervacije: ");
        final DatePicker datePicker = new DatePicker();

        //Button za dodavanje rezervacije

        Button dodajButton = new Button("Dodaj rezervaciju");

        //ListView za prikaz rezervacije

        ListView<String> rezervacijeListView = new ListView<>();

        //Dohvaćanje svih vlasnika i kućnih ljubimaca iz baze za prikaz

    //    List<VlasnikKucnogLjubimca> vlasnici = vlasnikDAO.getAll();
     //   List<KucniLjubimac> ljubimci = kucniLjubimacDAO.getAll();

        //Dodavanje komponenata u korijenski VBox

        root.getChildren().addAll(imeLabel, imeField, prezimeLabel,
                prezimeField, ljubimacImeLabel, ljubimacImeField,
                ljubimacVrstaLabel, ljubimacVrstaField, datumLabel,
                datePicker, dodajButton, rezervacijeListView);

        //Dodajemo akciju na dugme za dodavanje rezervacije u bazu podataka

        dodajButton.setOnAction(event -> {

            //Čitanje unesenih podataka

            String ime = imeField.getText();
            String prezime = prezimeField.getText();
            String ljubimacIme = ljubimacImeField.getText();
            String ljubimacVrsta = ljubimacVrstaField.getText();
            java.util.Date datum = java.sql.Date.valueOf(datePicker.getValue());

            //Dodavanje vlasnika u bazu podataka

            VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca(ime, prezime);
            vlasnik = vlasnikDAO.insert(vlasnik);

            //Dodavanje kućnog ljubimca u bazu podataka

            KucniLjubimac ljubimac = new KucniLjubimac(ljubimacIme, ljubimacVrsta);
            ljubimac = kucniLjubimacDAO.insert(ljubimac);

            //Dodavanje rezervacije u bazu podataka

            Rezervacija rezervacija = new Rezervacija(vlasnik, ljubimac, datum);
            rezervacijaDAO.insert(rezervacija);

            //Dodavanje informacija o rezervaciji u ListView

            String rezervacijaInfo = "Vlasnik: " + vlasnik.getIme() + " " + vlasnik.getPrezime() +
                    " " + "Ljubimac: " + ljubimac.getIme() + ", Datum rezervacije: " + datum;

            rezervacijeListView.getItems().add(rezervacijaInfo);

            //Očistimo polja nakon dodavanja rezervacije

            imeField.clear();
            prezimeField.clear();
            ljubimacImeField.clear();
            ljubimacVrstaField.clear();
            datePicker.setValue(null);

            //Kreiranje Scene i postavljanje na Stage

            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);

            //Prikazivanje Stage-a

            primaryStage.show();
        });

    }
    }
