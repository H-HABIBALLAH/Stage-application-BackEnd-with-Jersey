package entities;


import java.io.Serializable;
import java.util.List;

public class Entreprise implements Serializable {
    Long id;
    private String responsableName;
    private String nom;
    private List<Offre> offresDeposes;

    public Entreprise(String nom, String respoName){
        this.nom = nom;
        this.responsableName=respoName;
    }

    public Long getId() {
        return id;
    }

    public String getResponsableName() {
        return responsableName;
    }

    public void setResponsableName(String responsableName) {
        this.responsableName = responsableName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Offre> getOffresDeposes() {
        return offresDeposes;
    }

    public void setOffresDeposes(List<Offre> offresDeposes) {
        this.offresDeposes = offresDeposes;
    }
}
