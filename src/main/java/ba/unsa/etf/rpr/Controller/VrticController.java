package ba.unsa.etf.rpr.Controller;
import ba.unsa.etf.rpr.Vrtic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
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
        LocalDate datum = datePicker.getValue();



}
