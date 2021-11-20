package dao.etudiant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DBConnection;
import entities.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImpl implements EtudiantDao{

    Connection conn = DBConnection.createNewDBconnection();

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    public String getAll() throws SQLException {
        List<Etudiant> studentsList = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM ETUDIANT");

        while(result.next()){
            Long id = result.getLong("id");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linked_in_Link");
            String description = result.getString("description");
            String competences = result.getString("competences");
            byte[] cv = result.getBytes("cv");
            byte[] lm = result.getBytes("lm");
            Etudiant student = new Etudiant(id,nom,prenom,mail,null,null,null,formation,linkedInLink,description,competences,cv,lm);
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
            String linkedInLink = result.getString("linked_In_Link");
            String description = result.getString("description");
            String competences = result.getString("competences");
            byte[] cv = result.getBytes("cv");
            byte[] lm = result.getBytes("lm");
            student = new Etudiant(id,nom,prenom,mail,null,null,null,formation,linkedInLink,description,competences,cv,lm);
        }
        System.out.println(gson.toJson(student));
        return gson.toJson(student);
    }

    public String getByCompetences(String competences) throws SQLException {
        Etudiant student = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ETUDIANT WHERE competences LIKE ?");
        preparedStatement.setString(1,"%"+competences+"%");
        ResultSet result = preparedStatement.executeQuery();
        List<Etudiant> studentList = new ArrayList<>();

        while(result.next()){
            Long id = result.getLong("id");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String password = result.getString("password");
            String noEtudiant = result.getString("no_etudiant");
            Boolean inscrit = result.getBoolean("inscrit");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linked_In_Link");
            String description = result.getString("description");
            String studentCompetences = result.getString("competences");
            byte[] cv = result.getBytes("cv");
            byte[] lm = result.getBytes("lm");
            student = new Etudiant(id,nom,prenom,mail,password,noEtudiant,inscrit,formation,linkedInLink,description,studentCompetences,cv,lm);
            studentList.add(student);
        }

        return gson.toJson(studentList);
    }

    public void save(Etudiant etudiant) throws SQLException {



        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etudiant (nom,prenom,mail,password,no_etudiant,inscrit,formation,linked_In_link,description,competences,cv,lm) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1,etudiant.getNom());
        preparedStatement.setString(2,etudiant.getPrenom());
        preparedStatement.setString(3,etudiant.getMail());
        preparedStatement.setString(4,etudiant.getPassword());
        preparedStatement.setString(5,etudiant.getNoEtudiant());
        preparedStatement.setBoolean(6,true);
        preparedStatement.setString(7,null);
        preparedStatement.setString(8,etudiant.getLinkedInLink());
        preparedStatement.setString(9,etudiant.getDescription());
        preparedStatement.setString(10,etudiant.getCompetences());
        preparedStatement.setBytes(11, etudiant.getCv());
        preparedStatement.setBytes(12, etudiant.getLm());

        preparedStatement.executeUpdate();
    }

    @Override
    public String getByEmail(String email) throws SQLException {
        Etudiant etudiant = null;

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ETUDIANT WHERE mail LIKE ?");
        preparedStatement.setString(1,email);
        ResultSet result = preparedStatement.executeQuery();

        if(result.next()){
            Long id = result.getLong("id");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("mail");
            String password = result.getString("password");
            String noEtudiant = result.getString("no_etudiant");
            Boolean inscrit = result.getBoolean("inscrit");
            String formation = result.getString("formation");
            String linkedInLink = result.getString("linked_In_Link");
            String description = result.getString("description");
            String studentCompetences = result.getString("competences");
            byte[] cv = result.getBytes("cv");
            byte[] lm = result.getBytes("lm");
            etudiant = new Etudiant(id,nom,prenom,mail,password,noEtudiant,inscrit,formation,linkedInLink,description,studentCompetences,cv,lm);
        }

        return gson.toJson(etudiant);
    }
}
