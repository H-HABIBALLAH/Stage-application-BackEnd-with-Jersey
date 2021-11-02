package dao.administrateur;

import entities.Administrateur;

public interface AdministrateurDao {
    public Administrateur getAdmin();
    public Administrateur getAdminById(Long id);
    public void saveAdmin(Administrateur admin);
}
