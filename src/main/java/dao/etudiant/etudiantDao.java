package dao.etudiant;

import entities.Etudiant;

import java.util.List;

public interface etudiantDao {
    public List<Etudiant> getAll();

    public Etudiant getById(Long id);

    public List<Etudiant> getByCompetences(String Competences);

    public void save(Etudiant etudiant);
}
