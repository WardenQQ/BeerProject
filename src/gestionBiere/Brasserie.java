package gestionBiere;

import java.io.Serializable;

public class Brasserie implements Serializable {
    private static final long serialVersionUID = 0L;

    private static int compteur = 1;

    private final int identifiant;

    private String nom = "";
    private LieuOrigine lieuOrigine = new LieuOrigine();

    public Brasserie() {
        identifiant = compteur;
        compteur++;
    }

    public Brasserie(String nom, LieuOrigine lieuOrigine) {
        this();
        this.nom = nom;
        this.lieuOrigine = lieuOrigine;
    }

    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj instanceof Brasserie) {
            Brasserie brasserie = (Brasserie)obj;
            isEqual = this.nom.equals(brasserie.nom) &&
                      this.lieuOrigine.equals(brasserie.lieuOrigine);
        }

        return isEqual;
    }

    public int getIdentifiant() { return identifiant;}

    public String getNom() { return nom;}
    public void setNom(String nom) {
        if (nom == null) {
            nom = new String();
        }
        this.nom = nom;
    }

    public LieuOrigine getLieuOrigine() { return lieuOrigine;}
    public void setLieuOrigine(LieuOrigine lieuOrigine) {
        if (lieuOrigine == null) {
            lieuOrigine = new LieuOrigine();
        }
        this.lieuOrigine = lieuOrigine;
    }
}
