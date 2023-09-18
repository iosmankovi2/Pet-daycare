package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.KucniLjubimacDAO;
import ba.unsa.etf.rpr.KucniLjubimac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KucniLjubimacDAOImpements implements KucniLjubimacDAO {
    private final List<KucniLjubimac> kucniLjubimci = new ArrayList<>();

    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";

    @Override

    public KucniLjubimac getById(int id) {

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM kucniljubimac WHERE idKucniLjubimac = ?")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                KucniLjubimac ljubimac = new KucniLjubimac();
                ljubimac.setId(resultSet.getInt("idKucniLjubimac"));
                ljubimac.setIme(resultSet.getString("ime"));
                return ljubimac;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return null; //Ako nije pronađen ljubimac sa datim ID-om
    }

    @Override

    public List<KucniLjubimac> getAll() {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM kucniljubimac")){

            while(resultSet.next()){
                KucniLjubimac ljubimac = new KucniLjubimac();
                ljubimac.setId(resultSet.getInt("idKucniLjubimac"));
                ljubimac.setIme(resultSet.getString("ime"));
                kucniLjubimci.add(ljubimac);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return kucniLjubimci;
    }

    @Override

    public KucniLjubimac insert(KucniLjubimac ljubimac) {
        //Generišemo novi ID

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO kucniljubimci(ime, vrsta,...) VALUES (?,?,...)")) {
            statement.setString(1,ljubimac.getIme());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return ljubimac;
    }

    @Override

    public void update(KucniLjubimac ljubimac) {

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("UPDATE kucniljubimci SET ime = ?, vrsta = ?, ... WHERE idKucniLjubimac = ?")) {
            statement.setString(1,ljubimac.getIme());
            statement.setInt(7,ljubimac.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    public void delete(int id) {

        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM kucniljubimci WHERE idKucniLjubimac = ?")){
        statement.setInt(1,id);
        statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
