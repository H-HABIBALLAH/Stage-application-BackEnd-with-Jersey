package dao.offre;

import entities.Offre;

import java.util.List;

public interface offreDao {

    public List<Offre> getAll();

    public Offre getById(Long id);

    public List<Offre> getByCompetences(String Competences);

    public void save(Offre offre);

}
