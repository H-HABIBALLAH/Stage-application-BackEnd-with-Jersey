package entities;


import java.io.Serializable;
import java.util.List;

public class Administrateur extends Utilisateur implements Serializable {
    private List<Offre> confirmedOffers;

    public Administrateur(){
        super();

    }
    public Administrateur(String nom, String prenom, String mail, String password) {
        super(nom, prenom, mail, password);
    }

    public List<Offre> getConfirmedOffers() {
        return confirmedOffers;
    }

    public void setConfirmedOffers(List<Offre> confirmedOffers) {
        this.confirmedOffers = confirmedOffers;
    }
}
