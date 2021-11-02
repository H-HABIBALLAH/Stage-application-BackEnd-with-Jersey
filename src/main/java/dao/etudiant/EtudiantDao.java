package dao.etudiant;

import entities.Etudiant;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantDao {
    public String getAll() throws SQLException;

    public String getById(Long id) throws SQLException;

    public String getByCompetences(String competences) throws SQLException;

    public void save(Etudiant etudiant) throws SQLException;
}
