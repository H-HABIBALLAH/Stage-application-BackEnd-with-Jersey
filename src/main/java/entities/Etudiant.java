package entities;

import java.io.Serializable;
import java.util.List;

public class Etudiant extends Utilisateur implements Serializable { ;
    private String noEtudiant;
    private Boolean inscrit;
    private String formation;
    private String linkedInLink;
    private String description;
    private String competences;
    private List<Fichier> fichiers;

    public Etudiant(String nom, String prenom, String mail, String password, String noEtudiant, Boolean inscrit, String formation, String linkedInLink, String description, String competences, List<Fichier> fichiers) {
        super(nom, prenom, mail, password);
        this.noEtudiant = noEtudiant;
        this.inscrit = inscrit;
        this.formation = formation;
        this.linkedInLink = linkedInLink;
        this.description = description;
        this.competences = competences;
        this.fichiers = fichiers;
    }

    public String getNoEtudiant() {
        return noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public Boolean getInscrit() {
        return inscrit;
    }

    public void setInscrit(Boolean inscrit) {
        this.inscrit = inscrit;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    public void setFichiers(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }
}
