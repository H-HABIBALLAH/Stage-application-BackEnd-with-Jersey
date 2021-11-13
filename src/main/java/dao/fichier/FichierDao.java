package dao.fichier;

import java.sql.SQLException;

public interface FichierDao {
    public String getAll() throws SQLException;

    public String getById(Long id) throws SQLException;

    public void save(Fichier fichier) throws SQLException;
}
