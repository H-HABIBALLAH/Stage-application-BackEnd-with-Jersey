package dao.offre;

import entities.Offre;

import java.sql.SQLException;
import java.util.List;

public interface OffreDao {

    public String getAll() throws SQLException;

    public String getById(Long id) throws SQLException;

    public String getByCompetences(String Competences) throws SQLException;

    public void save(Offre offre) throws SQLException;

    public String edit_offre_confirm(Long id) throws SQLException;

    public String getOffresConfirmes() throws SQLException;
}
