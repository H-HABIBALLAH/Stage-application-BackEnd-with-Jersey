package dao.etudiant;

import com.google.gson.Gson;
import dao.DBConnection;
import entities.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImpl implements EtudiantDao{

    Connection conn = DBConnection.createNewDBconnection();
    Gson gson = new Gson();

    public String getAll() throws SQLException {
        List<Etudiant> studentsList = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM ETUDIANT");

        while(result.next()){
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linkedInLink");
            String description = result.getString("description");
            String competences = result.getString("competences");
            Etudiant student = new Etudiant(nom,prenom,mail,null,null,null,formation,linkedInLink,description,competences,null);
            studentsList.add(student);
        }

        return gson.toJson(studentsList);
    }

    public String getById(Long id) throws SQLException {
        Etudiant student = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ETUDIANT WHERE id = ?");
        preparedStatement.setLong(1,id);
        ResultSet result = preparedStatement.executeQuery();

        if(result.next()){
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linkedInLink");
            String description = result.getString("description");
            String competences = result.getString("competences");
            student = new Etudiant(nom,prenom,mail,null,null,null,formation,linkedInLink,description,competences,null);
        }

        return gson.toJson(student);
    }

    public String getByCompetences(String competences) throws SQLException {
        Etudiant student = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ETUDIANT WHERE competences LIKE ?");
        preparedStatement.setString(1,"%"+competences+"%");
        ResultSet result = preparedStatement.executeQuery();
        List<Etudiant> studentList = new ArrayList<>();

        while(result.next()){
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linkedInLink");
            String description = result.getString("description");
            String studentCompetences = result.getString("competences");
            student = new Etudiant(nom,prenom,mail,null,null,null,formation,linkedInLink,description,studentCompetences,null);
            studentList.add(student);
        }

        return gson.toJson(student);
    }

    public void save(Etudiant etudiant) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etudiant (nom,prenom,mail,password,noEtudiant,inscrit,formation,linkedInLink,description,studentCompetences,fichier) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1,etudiant.getNom());
        preparedStatement.setString(2,etudiant.getPrenom());
        preparedStatement.setString(3,etudiant.getMail());
        preparedStatement.setString(4,etudiant.getPassword());
        preparedStatement.setString(5,etudiant.getNoEtudiant());
        preparedStatement.setBoolean(6,etudiant.getInscrit());
        preparedStatement.setString(7,etudiant.getFormation());
        preparedStatement.setString(8,etudiant.getLinkedInLink());
        preparedStatement.setString(9,etudiant.getDescription());
        preparedStatement.setString(10,etudiant.getCompetences());
        preparedStatement.setString(11,null);

        preparedStatement.executeUpdate();
    }
}
