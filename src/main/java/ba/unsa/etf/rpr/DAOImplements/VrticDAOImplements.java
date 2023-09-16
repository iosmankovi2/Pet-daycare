package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.VrticDAO;
import ba.unsa.etf.rpr.Vrtic;
import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class VrticDAOImplements implements VrticDAO {
    private List<Vrtic> vrtici = new ArrayList<>();

    @Override

    public Vrtic getById(int id){
        //Pronalazi vrtić po ID-u iz liste

        for(Vrtic vrtic: vrtici){
            if(vrtic.getId() == id){
                return vrtic;
            }
        }

        return null; // Ako nije pronađen vrtić sa datim ID-om

    }

    @Override


}
