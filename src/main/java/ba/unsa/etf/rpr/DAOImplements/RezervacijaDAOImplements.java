package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.RezervacijaDAO;
import ba.unsa.etf.rpr.Rezervacija;

//import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
//import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

public class RezervacijaDAOImplements implements RezervacijaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";
    private final List<Rezervacija> rezervacije = new ArrayList<>();

    @Override

    public Rezervacija getById(int id){
        //Pronalazi rezervaciju po ID-u iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM rezervacija WHERE idrezervacija = ?")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setId(resultSet.getInt("idrezervacija"));
                rezervacija.setDatumRezervacije(resultSet.getDate("datumRezervacije"));
                return rezervacija;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null; //Ako nije pronađena rezervacija sa datim ID-om
    }

    @Override

    public List<Rezervacija> getAll(){
        //Vraća sve rezervacije iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *FROM rezervacija");

            while(resultSet.next()){
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setId(resultSet.getInt("idrezervacija"));
                rezervacija.setDatumRezervacije(resultSet.getDate("datumRezervacije"));
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rezervacija(datumRezervacije,...)VALUES (?,...)")) {
            statement.setDate(1,new java.sql.Date(rezervacija.getDatumRezervacije().getTime()));
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override

    public void update(Rezervacija rezervacija){
        //Pronalazi postojeću rezervaciju prema ID-u i zamjenjuje je novim podacima

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE rezervacija SET datumRezervacije = ?,...WHERE idrezervacija = ?")) {
            statement.setDate(1,new java.sql.Date(rezervacija.getDatumRezervacije().getTime()));
            statement.setInt(7,rezervacija.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override

    public void delete(int id){
        //Uklanja rezervaciju sa datim ID-om iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rezervacija WHERE idrezervacija = ?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override

    public List<Rezervacija> getByDatumRezervacije(Date datum){
        //Filtrira rezervacije prema datumu rezervacije

        List<Rezervacija> rezervacijeZaDatum = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM rezervacija WHERE datumRezervacije = ?")) {
            statement.setDate(1,new java.sql.Date(datum.getTime()));
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setId(resultSet.getInt("idrezervacije"));
                rezervacija.setDatumRezervacije(resultSet.getDate("datumRezervacije"));
                rezervacijeZaDatum.add(rezervacija);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return rezervacijeZaDatum;
    }




}
