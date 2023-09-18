package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.VlasnikKucnogLjubimcaDAO;
import ba.unsa.etf.rpr.KucniLjubimac;
import ba.unsa.etf.rpr.VlasnikKucnogLjubimca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VlasnikKucnogLjubimcaDAOImplements implements VlasnikKucnogLjubimcaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";

    private final List<VlasnikKucnogLjubimca> vlasnici = new ArrayList<>();

    @Override

    public VlasnikKucnogLjubimca getById(int id){
    //  Pronalazak vlasnika po Id-u iz liste
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnik_ljubimca WHERE idvlasnik_ljubimca = ? "))
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("idvlasnik_ljubimca"));
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
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnik_ljubimca")){
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("idvlasnik_ljubimca"));
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

    public VlasnikKucnogLjubimca insert(VlasnikKucnogLjubimca vlasnik){
    //Generiše novi ID za vlasnika

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO vlasnik_ljubimca(ime,prezime) VALUES (?,?)",
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

        return vlasnik;
    }

    @Override

    public void update(VlasnikKucnogLjubimca vlasnik){
    //Pronalazi postojećeg vlasnika prema ID-u i zamenjuje ga novim podacima

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("UPDATE vlasnik_ljubimca SET ime = ?, prezime = ? WHERE idvlasnik_ljubimca = ?")){
            statement.setString(1,vlasnik.getIme());
            statement.setString(2,vlasnik.getPrezime());
            statement.setInt(3,vlasnik.getId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override

    public void delete(int id){
    //Uklanja vlasnika sa datim ID-om iz liste

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM vlasnik_ljubimca WHERE idvlasnik_ljubimca = ?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override

    public List<VlasnikKucnogLjubimca> getByIme(String ime){
    //Filtrira vlasnika prema imenu

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnik_ljubimca WHERE ime = ?")) {
            statement.setString(1,ime);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("idvlasnik_ljubimca"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                vlasnici.add(vlasnik);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return vlasnici;
    }

    @Override

    public List<VlasnikKucnogLjubimca> getByPrezime(String prezime){
    // Filtrira vlasnike prema prezimenu

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM vlasnik_ljubimca WHERE prezime = ?")) {
            statement.setString(1,prezime);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("idvlasnik_ljubimca"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                vlasnici.add(vlasnik);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return vlasnici;
    }

    @Override

    public List<VlasnikKucnogLjubimca> getByLjubimac(KucniLjubimac ljubimac) {
        //Filtrira vlasnike prema kućnom ljubimcu

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT v. *FROM vlasnik_ljubimca v" + "INNER JOIN vlasnici_ljubimci vl ON v.id = vl.idvlasnik_ljubimca" + "WHERE vl.idKucniLjubimac =?")) {

            statement.setInt(1,ljubimac.getId());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                VlasnikKucnogLjubimca vlasnik = new VlasnikKucnogLjubimca();
                vlasnik.setId(resultSet.getInt("idvlasnik_ljubimca"));
                vlasnik.setIme(resultSet.getString("ime"));
                vlasnik.setPrezime(resultSet.getString("prezime"));
                vlasnici.add(vlasnik);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return vlasnici;
    }
}

