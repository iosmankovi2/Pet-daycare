package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.VrticDAO;
import ba.unsa.etf.rpr.Rezervacija;
import ba.unsa.etf.rpr.Vrtic;
import jdk.dynalink.linker.LinkerServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VrticDAOImplements implements VrticDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";
    private List<Vrtic> vrtici = new ArrayList<>();

    @Override

    public Vrtic getById(int id){
        //Pronalazi vrtić po ID-u iz liste
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vrici WHERE id = ?")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Vrtic vrtic = new Vrtic();
                vrtic.setId(resultSet.getInt("id"));
                vrtic.setNaziv(resultSet.getString("naziv"));

                return vrtic;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

      /*  for(Vrtic vrtic: vrtici){
            if(vrtic.getId() == id){
                return vrtic;
            }
        } */

        return null; // Ako nije pronađen vrtić sa datim ID-om

    }

    @Override

    public List<Vrtic> getAll(){

        List<Vrtic> vrtici = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
           Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *FROM vrtici");
            while(resultSet.next()){
                Vrtic vrtic = new Vrtic();
                vrtic.setId(resultSet.getInt("id"));
                vrtic.setNaziv((resultSet.getString("naziv")));

                vrtici.add(vrtic);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        //Vraća sve vrtiće iz liste

        return vrtici;
    }

    @Override
    public void insert(Vrtic vrtic) {
        //Generiše novi ID za vrtić

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO vrtici (naziv) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, vrtic.getNaziv());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                vrtic.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      /*  int newId = generateNewId();
        vrtic.setId(newId);
        vrtici.add(vrtic);
    } */

    @Override

    public void update(Vrtic vrtic) {
        //Pronalazi postojeći vrtić prema ID-u i zamenjuje ga novim podacima

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE vrtici SET naziv = ? WHERE id = ?")) {
            statement.setString(1, vrtic.getNaziv());
            statement.setInt(2, vrtic.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        for(int i = 0; i < vrtici.size(); i++){
            if(vrtici.get(i).getId() == vrtic.getId()){
                vrtici.set(i,vrtic);
                return; //Ako je vrtić ažuriran, prekidamo petlju
            }
        }
    }
*/
    @Override

    public void delete(int id){
        //Uklanja vrtić sa datim ID-om iz liste

        for(int i = 0; i < vrtici.size(); i++){
            if(vrtici.get(i).getId() == id){
                vrtici.remove(i);
                return; //Ako je vrtić uklonjen, prekidamo petlju
            }
        }
    }

    //Pomoćna metoda za generisanje novog ID-a
    private int generateNewId(){

        int maxId = 0;
        for(Vrtic vrtic: vrtici){
            if(vrtic.getId() > maxId){
                maxId = vrtic.getId();
            }
        }
        return maxId + 1;
    }

}
