package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.KucniLjubimac;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;

import java.util.List;

public interface VlasnikKucnogLjubimcaDAO {
    VlasnikKucnogLjubimca getById(int id);
    List<VlasnikKucnogLjubimca> getAll();
    VlasnikKucnogLjubimca insert(VlasnikKucnogLjubimca vlasnik);
    void update(VlasnikKucnogLjubimca vlasnik);
    void delete(int id);
    List<VlasnikKucnogLjubimca> getByIme(String ime);
    List<VlasnikKucnogLjubimca> getByPrezime(String prezime);
    List<VlasnikKucnogLjubimca> getByLjubimac(KucniLjubimac ljubimac);

}
