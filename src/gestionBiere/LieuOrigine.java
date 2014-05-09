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
        if (obj instanceof LieuOrigine) {
            LieuOrigine lieuOrigine = (LieuOrigine)obj;
            return this.nom.equals(lieuOrigine.nom) &&
                   this.paysAppartenance.equals(lieuOrigine.paysAppartenance);
        }

        return false;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(String paysAppartenance) {
        this.paysAppartenance = paysAppartenance;
    }
}
