package entities;


import java.io.Serializable;

public class Offre implements Serializable {
    private Long Id;
    private String titre;
    private Boolean confirme;
    private String contenu;
    private String competences;
    private Entreprise entreprise;
    private Administrateur admin;

    public Offre(Long id, String titre, Boolean confirme, String contenu, String competences, Entreprise entreprise, Administrateur admin) {
        Id = id;
        this.titre = titre;
        this.confirme = confirme;
        this.contenu = contenu;
        this.competences = competences;
        this.entreprise = entreprise;
        this.admin = admin;
    }

    public Long getId() {
        return Id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Boolean getConfirme() {
        return confirme;
    }

    public void setConfirme(Boolean confirme) {
        this.confirme = confirme;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Administrateur getAdmin() {
        return admin;
    }

    public void setAdmin(Administrateur admin) {
        this.admin = admin;
    }
}
