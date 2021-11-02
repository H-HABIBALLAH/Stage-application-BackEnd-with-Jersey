package dao.fichier;

import entities.Fichier;

import java.util.List;

public interface fichierDao {
    public List<Fichier> getAll();

    public Fichier getById(Long id);

    public void save(Fichier fichier);
}
