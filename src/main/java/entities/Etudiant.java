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
}
