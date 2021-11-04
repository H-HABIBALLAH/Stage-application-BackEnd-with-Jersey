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
    private byte[] cv;
    private byte[] lm;

    public Etudiant() {
        super(null, null, null, null);
        this.noEtudiant = null;
        this.inscrit = null;
        this.formation = null;
        this.linkedInLink = null;
        this.description = null;
        this.competences = null;
        this.cv = null;
        this.lm = null;
    }

    public Etudiant(String nom, String prenom, String mail, String password, String noEtudiant, Boolean inscrit, String formation, String linkedInLink, String description, String competences, byte[] cv, byte[] lm) {
        super(nom, prenom, mail, password);
        this.noEtudiant = noEtudiant;
        this.inscrit = inscrit;
        this.formation = formation;
        this.linkedInLink = linkedInLink;
        this.description = description;
        this.competences = competences;
        this.cv = cv;
        this.lm = lm;
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

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getLm() {
        return lm;
    }

    public void setLm(byte[] lm) {
        this.lm = lm;
    }
}
