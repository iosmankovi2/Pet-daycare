package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Rezervacija;

import java.util.ArrayList;
import java.util.Date;
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
        rezervacije.add(rezervacija);
    }

    @Override

    public void update(Rezervacija rezervacija){
        //Pronalazi postojeću rezervaciju prema ID-u i zamjenjuje je novim podacima

        for(int i = 0; i < rezervacije.size(); i++){
            if(rezervacije.get(i).getId() == rezervacija.getId())
            {
                rezervacije.set(i,rezervacija);
                return; //Ako je rezervacija ažurirana prekidamo petlju
            }
        }
    }

    @Override

    public void delete(int id){
        //Uklanja rezervaciju sa datim ID-om iz liste
        for(int i = 0; i < rezervacije.size(); i++)
        {
            if(rezervacije.get(i).getId() == id){
                rezervacije.remove(i);
                return;
            }
        }
    }

    @Override

    public List<Rezervacija> getByDatumRezervacije(Date datum){
        //Filtrira rezervacije prema datumu rezervacije

        List<Rezervacija> rezervacijeZaDatum = new ArrayList<>();
        for(Rezervacija rezervacija: rezervacije){
            if(datum.equals(rezervacija.getDatumRezervacije()))
            {
                rezervacijeZaDatum.add(rezervacija);
            }
        }
        return rezervacijeZaDatum;
    }

    //Pomoćna metoda za generisanje novog ID-a
    private int generateNewId() {
        int maxId = 0;
        for(Rezervacija rezervacija: rezervacije){
            if(rezervacija.getId() > maxId){
                maxId = rezervacija.getId();
            }
        }
        return maxId+1;
    }


}
