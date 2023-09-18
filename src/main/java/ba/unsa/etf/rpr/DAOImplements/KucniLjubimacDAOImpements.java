package ba.unsa.etf.rpr.DAOImplements;

import ba.unsa.etf.rpr.Dao.KucniLjubimacDAO;
import ba.unsa.etf.rpr.KucniLjubimac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KucniLjubimacDAOImpements implements KucniLjubimacDAO {
    private List<KucniLjubimac> kucniLjubimci = new ArrayList<>();

    private static final String URL = "jdbc:mysql://localhost:3306/pet_daycare";
    private static final String USER = "root";
    private static final String PASSWORD = "projekatizrpr-a";

    @Override

    public KucniLjubimac getById(int id) {

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM kucni_ljubimac WHERE id = ?")){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                KucniLjubimac ljubimac = new KucniLjubimac();
                ljubimac.setId(resultSet.getInt("id"));
                ljubimac.setIme(resultSet.getString("ime"));
                return ljubimac;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        /* for (KucniLjubimac ljubimac : kucniLjubimci) {
            if (ljubimac.getId() == id) {
                return ljubimac;
            }
        } */
        return null; //Ako nije pronađen ljubimac sa datim ID-om
    }

    @Override

    public List<KucniLjubimac> getAll() {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM kucni_ljubimac")){

            while(resultSet.next()){
                KucniLjubimac ljubimac = new KucniLjubimac();
                ljubimac.setId(resultSet.getInt("id"));
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
        PreparedStatement statement = connection.prepareStatement("INSERT INTO kucni_ljubimci(ime, vrsta,...) VALUES (?,?,...)")) {
            statement.setString(1,ljubimac.getIme());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
      /*  int newId = generateNewId();
        ljubimac.setId(newId);
        kucniLjubimci.add(ljubimac); */

        return ljubimac;
    }

    @Override

    public void update(KucniLjubimac ljubimac) {

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("UPDATE kucni_ljubimci SET ime = ?, vrsta = ?, ... WHERE id = ?")) {
            statement.setString(1,ljubimac.getIme());
            statement.setInt(7,ljubimac.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

       /* for (int i = 0; i < kucniLjubimci.size(); i++) {
            if (kucniLjubimci.get(i).getId() == ljubimac.getId()) {
                kucniLjubimci.set(i, ljubimac);
                return; //Ako je ljubimac ažuriran prekidamo petlju.
            }
        } */
    }

    public void delete(int id) {

        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM kucni_ljubimci WHERE id = ?")){
        statement.setInt(1,id);
        statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        /*
        for (int i = 0; i < kucniLjubimci.size(); i++) {
            KucniLjubimac ljubimac = kucniLjubimci.get(i);
            if (ljubimac.getId() == id) {
                kucniLjubimci.remove(i);
                break; //prekida petlju nakon brisanja
            }
        }
    }

    /**
     * Pomoćna metoda za generisanje novog ID-a (simulacija auto-increment polja).
     *
     * @return maxId+1
     */
   /* private int generateNewId() {
        int maxId = 0;
        for (KucniLjubimac ljubimac : kucniLjubimci) {
            if (ljubimac.getId() > maxId) {
                maxId = ljubimac.getId();
            }
        }
        return maxId + 1;
        */
    }
}
