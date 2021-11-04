package entities;

import java.io.Serializable;

public class Fichier implements Serializable {
    private Long id;
    private String type;
    private String title;
    private byte[] data;
//    private Etudiant etudiant;

    public Fichier() {
    }

    public Fichier(String type, String title, Etudiant etudiant) {
        this.type = type;
        this.title = title;
//        this.etudiant = etudiant;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

//    public Etudiant getEtudiant() {
//        return etudiant;
//    }
//
//    public void setEtudiant(Etudiant etudiant) {
//        this.etudiant = etudiant;
//    }
}
