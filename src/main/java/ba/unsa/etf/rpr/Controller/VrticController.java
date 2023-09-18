package ba.unsa.etf.rpr.Controller;
import ba.unsa.etf.rpr.KucniLjubimac;
import ba.unsa.etf.rpr.Rezervacija;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;
import ba.unsa.etf.rpr.Vrtic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class VrticController {


    @FXML
    private TextField imeField;

    @FXML
    private TextField prezimeField;

    @FXML
    private TextField ljubimacImeField;

    @FXML
    private TextField ljubimacVrstaField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ListView<String> rezervacijeListView;

    @FXML
    private Button dodajButton;

    private Vrtic vrtic;

    // Inicijalizacija kontrolera
    public void initialize() {
        vrtic = new Vrtic("Pet daycare");
    }

    // Metoda za dodavanje rezervacije
    @FXML
    private void dodajRezervaciju(ActionEvent event) {
        String imeVlasnika = imeField.getText();
        String prezimeVlasnika = prezimeField.getText();
        String imeLjubimca = ljubimacImeField.getText();
        String vrstaLjubimca = ljubimacVrstaField.getText();
        Date datum = java.sql.Date.valueOf(datePicker.getValue());


    // Stvaranje vlasnika
    VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca(imeVlasnika, prezimeVlasnika);

    // Stvaranje kućnog ljubimca
    KucniLjubimac ljubimac = new KucniLjubimac(imeLjubimca, vrstaLjubimca);

    // Stvaranje rezervacije
    Rezervacija rezervacija = new Rezervacija(vlasnik, ljubimac, datum);

    // Dodavanje rezervacije u vrtić
        vrtic.dodajRezervaciju(rezervacija);

    // Ažurirajte ListView s novim podacima o rezervacijama
    azurirajListView();

    // Očistite polja nakon dodavanja rezervacije
    ocistiPolja();
}

    // Metoda za ažuriranje ListView
    private void azurirajListView() {
        List<Rezervacija> rezervacije = vrtic.getRezervacije();
        rezervacijeListView.getItems().clear();

        for (Rezervacija rezervacija : rezervacije) {
            rezervacijeListView.getItems().add(rezervacija.toString());
        }
    }

    // Metoda za brisanje unesenih podataka iz polja nakon dodavanja rezervacije
    private void ocistiPolja() {
        imeField.clear();
        prezimeField.clear();
        ljubimacImeField.clear();
        ljubimacVrstaField.clear();
        datePicker.setValue(null);
    }

}