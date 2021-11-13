package entities;


import java.io.Serializable;
import java.util.List;

public class Administrateur implements Serializable {

    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;

    private List<Offre> confirmedOffers;

    public Administrateur(){
        this.id = null;
        this.nom = null;
        this.prenom = null;
        this.mail = null;
        this.password = null;
    }

    public Administrateur(String nom, String prenom, String mail, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Offre> getConfirmedOffers() {
        return confirmedOffers;
    }

    public void setConfirmedOffers(List<Offre> confirmedOffers) {
        this.confirmedOffers = confirmedOffers;
    }
}
