package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Rezervacija;

import java.util.Date;
import java.util.List;

public interface RezervacijaDAO {

    Rezervacija getById(int id);
    List<Rezervacija> getAll();
    void insert(Rezervacija rezervacija);
    void update(Rezervacija rezervacija);
    void delete(int id);
    List<Rezervacija> getByDatumRezervacije(Date datum);

}
