package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Vrtic;

import java.util.List;

public interface VrticDAO {
    Vrtic getByNazuv(String naziv);
    List<Vrtic> getAll();


}
