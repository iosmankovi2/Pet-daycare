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

    public List<Vrtic> getAll(){
        //Vraća sve vrtiće iz liste

        return vrtici;
    }

    @Override
    public void insert(Vrtic vrtic){
        //Generiše novi ID za vrtić

        int newId = generateNewId();
        vrtic.setId(newId);
        vrtici.add(vrtic);
    }

    @Override

    public void update(Vrtic vrtic){
        //Pronalazi postojeći vrtić prema ID-u i zamenjuje ga novim podacima

        for(int i = 0; i < vrtici.size(); i++){
            if(vrtici.get(i).getId() == vrtic.getId()){
                vrtici.set(i,vrtic);
                return; //Ako je vrtić ažuriran, prekidamo petlju
            }
        }
    }

    @Override


}
