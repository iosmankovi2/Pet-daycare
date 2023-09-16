package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Rezervacija;

import java.util.List;

public interface RezervacijaDAO {

    Rezervacija getById(int id);
    List<Rezervacija> getAll();
    void insert(Rezervacija rezervacija);
    void update(Rezervacija rezervacija);

}
