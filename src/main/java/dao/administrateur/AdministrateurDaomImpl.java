package dao.administrateur;

import dao.DBConnection;
import entities.Administrateur;

import java.sql.*;

public class AdministrateurDaomImpl implements AdministrateurDao {


    public Administrateur getAdmin() {
        Connection connection;
        Administrateur admin = null;
        Statement statement;
        ResultSet resultat;

        try {
            connection = DBConnection.createNewDBconnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery("SELECT * FROM administrateur");
        if(resultat.next()) {
        String nom = resultat.getString("nom");
        String prenom = resultat.getString("prenom");
        String mail = resultat.getString("mail");
        String password = resultat.getString("password");

        admin = new Administrateur(nom, prenom, mail, password);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Administrateur getAdminById(Long id) {
        Connection connection;
        Administrateur admin = null;
        Statement statement;
        ResultSet resultat;
        PreparedStatement preparedStatement;

        try {
            connection = DBConnection.createNewDBconnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM administrateur WHERE id = ?");
            preparedStatement.setLong(1,id);
            resultat = preparedStatement.executeQuery();
            if(resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String mail = resultat.getString("mail");
                String password = resultat.getString("password");

                admin = new Administrateur(nom, prenom, mail, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public void saveAdmin(Administrateur admin) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBConnection.createNewDBconnection();
            preparedStatement = connection.prepareStatement("INSERT INTO administrateur(nom,prenom,mail,password) VALUES (?,?,?,?)");

            preparedStatement.setString(1,admin.getNom());
            preparedStatement.setString(2,admin.getPrenom());
            preparedStatement.setString(3,admin.getMail());
            preparedStatement.setString(4,admin.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
