package gestionBiere;

import java.io.Serializable;

public class LieuOrigine implements Serializable {
    private static final long serialVersionUID = 0L;

    private static int compteur = 1;

    private final int identifiant;

    private StringBuffer nom = new StringBuffer();
    private StringBuffer paysAppartenance = new StringBuffer();

    public LieuOrigine() {
        this.identifiant = compteur;
        compteur++;
    }

    public LieuOrigine(StringBuffer nom, StringBuffer paysAppartenance) {
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

    public StringBuffer getNom() { return nom; }
    public void setNom(StringBuffer nom) {
        if (nom == null) {
            nom = new StringBuffer();
        }
        this.nom = nom;
    }

    public StringBuffer getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(StringBuffer paysAppartenance) {
        if (paysAppartenance == null) {
            paysAppartenance = new StringBuffer();
        }
        this.paysAppartenance = paysAppartenance;
    }
}
