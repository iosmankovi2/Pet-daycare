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

    public List<VlasnikKucnogLjubimca> getAll(){
    //Vraća sve vlasnike iz liste
        return vlasnici;
    }

    @Override

    public void insert(VlasnikKucnogLjubimca vlasnik){
    //Generiše novi ID za vlasnika

        int newId = generateNewId();
        vlasnik.setId(newId);
        vlasnici.add(vlasnik);
    }

    @Override

    public void update(VlasnikKucnogLjubimca vlasnik){
    //Pronalazi postojećeg vlasnika prema ID-u i zamenjuje ga novim podacima

        for(int i = 0; i < vlasnici.size(); i++){
            if(vlasnici.get(i).getId() == vlasnik.getId()){
                vlasnici.set(i, vlasnik);
                return; //Ako je vlasnik ažuriran, prekidamo petlju
            }
        }
    }

    @Override

    public void delete(int id){
    //Uklanja vlasnika sa datim ID-om iz liste

        for(int i = 0; i < vlasnici.size(); i++){
            if(vlasnici.get(i).getId() == id){
                vlasnici.remove(i);
                return; // Ako je vlasnik uklonjen, prekidamo petlju
            }
        }
    }

    @Override

    public List<VlasnikKucnogLjubimca> getByIme(String ime){
    //Filtrira vlasnika prema imenu

        List<VlasnikKucnogLjubimca> vlasniciPoImenu = new ArrayList<>();
        for(VlasnikKucnogLjubimca vlasnik: vlasnici){
            if(vlasnik.getIme().equals(ime)){
                vlasniciPoImenu.add(vlasnik);
            }
        }

        return vlasniciPoImenu;
    }

    @Override







}
