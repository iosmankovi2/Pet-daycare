package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;

import java.util.List;

public interface VlasnikKucnogLjubimcaDAO {
    VlasnikKucnogLjubimca getById(int id);
    List<VlasnikKucnogLjubimca> getAll();
    void insert(VlasnikKucnogLjubimca vlasnik);

    void update(VlasnikKucnogLjubimca vlasnik);

    void delete(int id);


}
