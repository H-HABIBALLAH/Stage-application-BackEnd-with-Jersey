package dao.fichier;

import entities.Fichier;

import java.sql.SQLException;
import java.util.List;

public interface FichierDao {
    public String getAll() throws SQLException;

    public String getById(Long id) throws SQLException;

    public void save(Fichier fichier) throws SQLException;
}
