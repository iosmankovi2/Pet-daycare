package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.KucniLjubimacDAO;
import ba.unsa.etf.rpr.KucniLjubimac;

import java.util.ArrayList;
import java.util.List;

public class KucniLjubimacDAOImpements implements KucniLjubimacDAO {
    private List<KucniLjubimac> kucniLjubimci = new ArrayList<>();

    @Override

    public KucniLjubimac getById(int id){
        for(KucniLjubimac ljubimac: kucniLjubimci){
            if(ljubimac.getId() == id){
                return ljubimac;
            }
        }
        return null; //Ako nije pronađen ljubimac sa datim ID-om
    }

    @Override

    public List<KucniLjubimac> getAll(){
        return kucniLjubimci;
    }

    @Override


}
