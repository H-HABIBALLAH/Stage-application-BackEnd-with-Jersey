package dao.offre;

import com.google.gson.Gson;
import dao.DBConnection;
import entities.Etudiant;
import entities.Offre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreDaoImpl implements OffreDao{
    Connection conn = DBConnection.createNewDBconnection();
    Gson gson = new Gson();

    public String getAll() throws SQLException {
        List<Offre> offresList = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM offre");

        while(result.next()){
            String titre = result.getString("titre");
            Boolean confirme = result.getBoolean("confirme");
            String contenu = result.getString("contenu");
            String competences = result.getString("competences");
            String entrepriseName = result.getString("entrepriseName");
            String ville = result.getString("ville");
            String duree = result.getString("duree");
            Offre offre = new Offre(titre,confirme,contenu,competences,entrepriseName,ville,duree);
            offresList.add(offre);
        }

        return gson.toJson(offresList);
    }

    public String getById(Long id) throws SQLException {
        Offre offre = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM offre WHERE id = ?");
        preparedStatement.setLong(1,id);
        ResultSet result = preparedStatement.executeQuery();

        if(result.next()){
            String titre = result.getString("titre");
            Boolean confirme = result.getBoolean("confirme");
            String contenu = result.getString("contenu");
            String competences = result.getString("competences");
            String entrepriseName = result.getString("entrepriseName");
            String ville = result.getString("ville");
            String duree = result.getString("duree");
            offre = new Offre(titre,confirme,contenu,competences,entrepriseName,ville,duree);
        }

        return gson.toJson(offre);
    }

    public String getByCompetences(String competences) throws SQLException {
        List<Offre> offresList = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM offre");

        while(result.next()){
            String titre = result.getString("titre");
            Boolean confirme = result.getBoolean("confirme");
            String contenu = result.getString("contenu");
            String competencesInOffre = result.getString("competences");
            String entrepriseName = result.getString("entrepriseName");
            String ville = result.getString("ville");
            String duree = result.getString("duree");
            Offre offre = new Offre(titre,confirme,contenu,competencesInOffre,entrepriseName,ville,duree);
            offresList.add(offre);
        }

        return gson.toJson(offresList);
    }

    public void save(Offre offre){
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO offre (competences,confirme,contenu,titre,entrepriseName) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, offre.getCompetences());
            if(offre.getConfirme() == null) offre.setConfirme(false);
            preparedStatement.setBoolean(2, offre.getConfirme());
            preparedStatement.setString(3, offre.getContenu());
            preparedStatement.setString(4, offre.getTitre());
            preparedStatement.setString(5, offre.getEntrepriseName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String edit_offre_confirm(Long id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE offre SET confirme = 1 WHERE id = ? ");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
        return this.getById(id);
    }

    public String getOffresConfirmes() throws SQLException {
        List<Offre> offresList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM offre WHERE confirme = ?");
        preparedStatement.setBoolean(1,true);
        ResultSet result = preparedStatement.executeQuery();

        while(result.next()) {
            String titre = result.getString("titre");
            Boolean confirme = result.getBoolean("confirme");
            String contenu = result.getString("contenu");
            String competences = result.getString("competences");
            String entrepriseName = result.getString("entrepriseName");
            String ville = result.getString("ville");
            String duree = result.getString("duree");
            Offre offre = new Offre(titre,confirme,contenu,competences,entrepriseName,ville,duree);
            offresList.add(offre);
        }

        return gson.toJson(offresList);
    }
}
