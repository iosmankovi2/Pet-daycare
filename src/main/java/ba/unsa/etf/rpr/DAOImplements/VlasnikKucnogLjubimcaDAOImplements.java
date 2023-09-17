package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.VlasnikKucnogLjubimcaDAO;
import ba.unsa.etf.rpr.KucniLjubimac;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;
import com.mysql.cj.exceptions.DataReadException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VlasnikKucnogLjubimcaDAOImplements implements VlasnikKucnogLjubimcaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";

    private List<VlasnikKucnogLjubimca> vlasnici = new ArrayList<>();

    @Override

    public VlasnikKucnogLjubimca getById(int id){
    //  Pronalazak vlasnika po Id-u iz liste
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnici WHERE id = ? "))
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("id"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                return vlasnik;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    /*
    for(VlasnikKucnogLjubimca vlasnik: vlasnici){
        if(vlasnik.getId() == id){
            return vlasnik;
        }
    }
    return null; //Ako nije pronađen vlasnik sa datim ID-om */
}

    @Override

    public List<VlasnikKucnogLjubimca> getAll(){
    //Vraća sve vlasnike iz liste
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnici")){
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("id"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                vlasnici.add(vlasnik);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vlasnici;
    }

    @Override

    public void insert(VlasnikKucnogLjubimca vlasnik){
    //Generiše novi ID za vlasnika

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO vlasnici(ime,prezime) VALUES (?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,vlasnik.getIme());
            statement.setString(2,vlasnik.getPrezime());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                vlasnik.setId(generatedKeys.getInt(1));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        int newId = generateNewId();
        vlasnik.setId(newId);
        vlasnici.add(vlasnik);
        */
    }

    @Override

    public void update(VlasnikKucnogLjubimca vlasnik){
    //Pronalazi postojećeg vlasnika prema ID-u i zamenjuje ga novim podacima

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("UPDATE vlasnici SET ime = ?, prezime = ? WHERE id = ?")){
            statement.setString(1,vlasnik.getIme());
            statement.setString(2,vlasnik.getPrezime());
            statement.setInt(3,vlasnik.getId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        for(int i = 0; i < vlasnici.size(); i++){
            if(vlasnici.get(i).getId() == vlasnik.getId()){
                vlasnici.set(i, vlasnik);
                return; //Ako je vlasnik ažuriran, prekidamo petlju
            }
        } */
    }

    @Override

    public void delete(int id){
    //Uklanja vlasnika sa datim ID-om iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM vlasnici WHERE id = ?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        for(int i = 0; i < vlasnici.size(); i++){
            if(vlasnici.get(i).getId() == id){
                vlasnici.remove(i);
                return; // Ako je vlasnik uklonjen, prekidamo petlju
            }
        } */
    }

    @Override

    public List<VlasnikKucnogLjubimca> getByIme(String ime){
    //Filtrira vlasnika prema imenu

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnici WHERE ime = ?")) {
            statement.setString(1,ime);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("id"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                vlasnici.add(vlasnik);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        List<VlasnikKucnogLjubimca> vlasniciPoImenu = new ArrayList<>();
        for(VlasnikKucnogLjubimca vlasnik: vlasnici){
            if(vlasnik.getIme().equals(ime)){
                vlasniciPoImenu.add(vlasnik);
            }
        }

        return vlasniciPoImenu;
        */
        return vlasnici;
    }

    @Override

    public List<VlasnikKucnogLjubimca> getByPrezime(String prezime){
    // Filtrira vlasnike prema prezimenu

      List<VlasnikKucnogLjubimca> vlasniciPoPrezimenu = new ArrayList<>();
      for(VlasnikKucnogLjubimca vlasnik: vlasnici){
          if(vlasnik.getPrezime().equals(prezime)){
              vlasniciPoPrezimenu.add(vlasnik);
          }
      }
      return vlasniciPoPrezimenu;

    }

    @Override

    public List<VlasnikKucnogLjubimca> getByLjubimac(KucniLjubimac ljubimac){
    //Filtrira vlasnike prema kućnom ljubimcu

        List<VlasnikKucnogLjubimca> vlasniciPoLjubimcu = new ArrayList<>();

        for(VlasnikKucnogLjubimca vlasnik: vlasnici){
            if(vlasnik.getLjubimci().contains(ljubimac)){
                vlasniciPoLjubimcu.add(vlasnik);
            }
        }
        return vlasniciPoLjubimcu;
    }

    //Pomoćna metoda za generisanje novog ID-a

    private int generateNewId(){
    int maxId = 0;
    for(VlasnikKucnogLjubimca vlasnik: vlasnici){
        if(vlasnik.getId() > maxId){
            maxId = vlasnik.getId();
        }
    }
    return maxId + 1;

    }
}

