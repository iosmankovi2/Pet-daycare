package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Rezervacija;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

public class RezervacijaDAOImplements implements RezervacijaDAO {
    private List<Rezervacija> rezervacije = new ArrayList<>();
    private final String URL;
    private final String USER;
    private final String PASSWORD;

    public RezervacijaDAOImplements(String url, String user, String password){
        URL = url;
        USER = user;
        PASSWORD = password;
    }
    @Override

    public Rezervacija getById(int id){
        //Pronalazi rezervaciju po ID-u iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM rezervacije WHERE id = ?")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setId(resultSet.getInt("id"));
                rezervacija.setDatumRezervacije(resultSet.getDate("datum_rezervacije"));
                return rezervacija;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        /* for(Rezervacija rezervacija: rezervacije){
            if(rezervacija.getId() == id){
                return rezervacija;
            }
        } */
        return null; //Ako nije pronađena rezervacija sa datim ID-om
    }

    @Override

    public List<Rezervacija> getAll(){
        //Vraća sve rezervacije iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *FROM rezervacije");

            while(resultSet.next()){
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setId(resultSet.getInt("id"));
                rezervacija.setDatumRezervacije(resultSet.getDate("datum_rezervacije"));
                rezervacije.add(rezervacija);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return rezervacije;
    }

    @Override

    public void insert(Rezervacija rezervacija){
        //Generiše novi ID za rezervaciju

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rezervacije(datum_rezervacije,...)VALUES (?,...)")) {
            statement.setDate(1,new java.sql.Date(rezervacija.getDatumRezervacije().getTime()));
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        /*
        int newId = generateNewId();
        rezervacija.setId(newId);
        rezervacije.add(rezervacija); */
    }

    @Override

    public void update(Rezervacija rezervacija){
        //Pronalazi postojeću rezervaciju prema ID-u i zamjenjuje je novim podacima

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE rezervacije SET datum_rezervacije = ?,...WHERE id = ?")) {
            statement.setDate(1,new java.sql.Date(rezervacija.getDatumRezervacije().getTime()));
            statement.setInt(7,rezervacija.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
     /*   for(int i = 0; i < rezervacije.size(); i++){
            if(rezervacije.get(i).getId() == rezervacija.getId())
            {
                rezervacije.set(i,rezervacija);
                return; //Ako je rezervacija ažurirana prekidamo petlju
            }
        } */
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
