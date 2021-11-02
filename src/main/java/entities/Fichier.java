package entities;

import java.io.Serializable;

public class Fichier implements Serializable {
    private Long id;
    private String type;
    private String title;
    private String link;
    private Etudiant etudiant;

    public Fichier(String type, String title, String link, Etudiant etudiant) {
        this.type = type;
        this.title = title;
        this.link = link;
        this.etudiant = etudiant;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
