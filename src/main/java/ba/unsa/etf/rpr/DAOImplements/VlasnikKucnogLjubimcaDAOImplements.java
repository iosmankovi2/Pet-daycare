package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.VlasnikKucnogLjubimcaDAO;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;

import java.util.ArrayList;
import java.util.List;

public class VlasnikKucnogLjubimcaDAOImplements implements VlasnikKucnogLjubimcaDAO {

private List<VlasnikKucnogLjubimca> vlasnici = new ArrayList<>();

@Override

    public VlasnikKucnogLjubimca getById(int id){
    //  Pronalazak vlasnika po Id-u iz liste

    for(VlasnikKucnogLjubimca vlasnik: vlasnici){
        if(vlasnik.getId() == id){
            return vlasnik;
        }
    }
    return null; //Ako nije pronađen vlasnik sa datim ID-om
}

    @Override



}
