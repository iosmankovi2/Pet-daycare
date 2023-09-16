package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Rezervacija;
import ba.unsa.etf.rpr.Vrtic;

import java.util.List;

public interface VrticDAO {
    Vrtic getById(int id);
    List<Vrtic> getAll();
    void insert(Vrtic vrtic);
    void update(Vrtic vrtic);
    void delete(int id);

}
