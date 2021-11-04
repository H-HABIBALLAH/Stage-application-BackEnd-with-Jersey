package dao.fileTest;

import com.google.gson.Gson;
import dao.DBConnection;
import entities.FileTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class fileTestDao {
    Connection conn = DBConnection.createNewDBconnection();
    Gson gson = new Gson();

    public void save(FileTest filetTest) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO fichier (title,type,data,etudiant_id) VALUES (?,?,?,?)");

        preparedStatement.setString(1,null);
        preparedStatement.setString(2,null);
        preparedStatement.setBytes(3,filetTest.getData());
        preparedStatement.setString(4,null);

        preparedStatement.executeUpdate();
    }
}
