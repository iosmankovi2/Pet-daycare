package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Rezervacija;

import java.util.ArrayList;
import java.util.List;

public class RezervacijaDAOImplements implements RezervacijaDAO {
    private List<Rezervacija> rezervacije = new ArrayList<>();

    @Override

    public Rezervacija getById(int id){
        //Pronalazi rezervaciju po ID-u iz liste
        for(Rezervacija rezervacija: rezervacije){
            if(rezervacija.getId() == id){
                return rezervacija;
            }
        }
        return null; //Ako nije pronađena rezervacija sa datim ID-om
    }


}
