package dao.administrateur;

import entities.Administrateur;

public interface AdministrateurDao {
    public String getAdmin();
    public String getAdminById(Long id);
    public String saveAdmin(Administrateur admin);
}
