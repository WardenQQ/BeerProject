package gestionBiere;

import java.io.Serializable;

public class LieuOrigine implements Serializable {
    private String nom;
    private String paysAppartenance;

    public LieuOrigine() {
        nom = "";
        paysAppartenance = "";
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

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(String paysAppartenance) {
        this.paysAppartenance = paysAppartenance;
    }
}
