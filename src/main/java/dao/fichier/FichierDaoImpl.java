package dao.fichier;

import com.google.gson.Gson;
import dao.DBConnection;
import dao.etudiant.EtudiantDao;
import dao.etudiant.EtudiantDaoImpl;
import entities.Etudiant;
import entities.Fichier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FichierDaoImpl implements FichierDao{

    Connection conn = DBConnection.createNewDBconnection();
    Gson gson = new Gson();

    @Override
    public String getAll() throws SQLException {
        List<Fichier> filesList = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM fichier");

        while(result.next()){
            String type = result.getString("type");
            String title = result.getString("title");
//            Long etudiantId = result.getLong("etudiant_id");

//            Etudiant etudiant = gson.fromJson(new EtudiantDaoImpl().getById(etudiantId),Etudiant.class);

//            Fichier file = new Fichier(type,title);

//            filesList.add(file);
        }

        return gson.toJson(filesList);
    }

    @Override
    public String getById(Long id) throws SQLException {
        Fichier fichier = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM fichier WHERE id = ?");
        preparedStatement.setLong(1,id);
        ResultSet result = preparedStatement.executeQuery();
        if(result.next()) {
            String title = result.getString("title");
            String type = result.getString("type");
            byte[] data = result.getBytes("data");
//            Long etudiantId = result.getLong("etudiant_id");

            EtudiantDao etudianDao = new EtudiantDaoImpl();
//            Etudiant etudiant = gson.fromJson(etudianDao.getById(etudiantId),Etudiant.class);

            fichier = new Fichier();
            fichier.setType(type);
            fichier.setTitle(title);
            fichier.setData(data);
        }

        return gson.toJson(fichier);
    }

    @Override
    public void save(Fichier fichier) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO fichier (title,type,data) VALUES (?,?,?)");

        preparedStatement.setString(1,fichier.getTitle());
        preparedStatement.setString(2,fichier.getType());
        preparedStatement.setBytes(3,fichier.getData());
//        preparedStatement.setLong(4,fichier.getEtudiant().getId());

        preparedStatement.executeUpdate();
    }
}
