package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.KucniLjubimac;

import java.util.List;

public interface KucniLjubimacDAO {

    KucniLjubimac getById(int id);
    List<KucniLjubimac> getAll();
    void insert(KucniLjubimac ljubimac);
    void update(KucniLjubimac ljubimac);
    void delete(int id);

}

