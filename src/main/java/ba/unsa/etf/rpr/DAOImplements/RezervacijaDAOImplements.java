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

    @Override

    public List<Rezervacija> getAll(){
        //Vraća sve rezervacije iz liste
        return rezervacije;
    }

    @Override

    public void insert(Rezervacija rezervacija){
        //Generiše novi ID za rezervaciju

        int newId = generateNewId();
        rezervacija.setId(newId);
        rezervacija.add(rezervacija);
    }

    private int generateNewId() {
    }

    @Override

    public void update(Rezervacija rezervacija){
        //Pronalazi postojeću rezervaciju prema ID-u i zamjenjuje je novim podacima

        for(int i = 0; i < rezervacije.size(); i++){
            if(rezervacija.get(i).getId() == rezervacija.getId())
            {
                rezervacije.set(i,rezervacija);
                return;
            }
        }
    }



}
