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
            Offre offre = new Offre(titre,confirme,contenu,competences,entrepriseName);
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
            offre = new Offre(titre,confirme,contenu,competences,entrepriseName);
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
            Offre offre = new Offre(titre,confirme,contenu,competencesInOffre,entrepriseName);
            offresList.add(offre);
        }

        return gson.toJson(offresList);
    }

    public void save(Offre offre) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO offre (competences,confirme,contenu,titre,entrepriseName) VALUES (?,?,?,?,?)");

        preparedStatement.setString(1,offre.getCompetences());
        preparedStatement.setBoolean(2,offre.getConfirme());
        preparedStatement.setString(3,offre.getContenu());
        preparedStatement.setString(4,offre.getTitre());
        preparedStatement.setString(5,offre.getEntrepriseName());

        preparedStatement.executeUpdate();
    }
}
