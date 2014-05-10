package gestionBiere;

import java.io.Serializable;

public class LieuOrigine implements Serializable {
    private static final long serialVersionUID = 0L;

    private static int compteur = 1;

    private final int identifiant;

    private String nom = "";
    private String paysAppartenance = "";

    public LieuOrigine() {
        this.identifiant = compteur;
        compteur++;
    }

    public LieuOrigine(String nom, String paysAppartenance) {
        this();
        setNom(nom);
        setPaysAppartenance(paysAppartenance);
    }

    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj instanceof LieuOrigine) {
            LieuOrigine lieuOrigine = (LieuOrigine)obj;
            isEqual = this.nom == lieuOrigine.nom &&
                      this.paysAppartenance == lieuOrigine.paysAppartenance;
        }

        return isEqual;
    }

    public int getIdentifiant() { return identifiant; }

    public String getNom() { return nom; }
    public void setNom(String nom) {
        if (nom == null) {
            nom = new String();
        }
        this.nom = nom;
    }

    public String getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(String paysAppartenance) {
        if (paysAppartenance == null) {
            paysAppartenance = new String();
        }
        this.paysAppartenance = paysAppartenance;
    }
}
