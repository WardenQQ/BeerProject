package gestionBiere;

import java.io.Serializable;

public class Bouteille implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int compteur = 1;

    private final int identifiant;

    private int taille = 0;
    private StringBuffer type = new StringBuffer(); 
    private StringBuffer bouchon = new StringBuffer();
    private StringBuffer lienPhoto = new StringBuffer(); 
    private Breuvage breuvage = new Breuvage(); 

    public Bouteille() {
        this.identifiant = compteur;
        compteur++;
    }

    public Bouteille(int taille, StringBuffer type, StringBuffer bouchon, StringBuffer lienPhoto, Breuvage breuvage) {
        this();
        setBouchon(bouchon);
        setBreuvage(breuvage);
        setType(type);
        setTailleBouteille(taille);
        setLienPhoto(lienPhoto);
    }

    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj instanceof Bouteille) {
            Bouteille bouteille = (Bouteille)obj;
            isEqual = this.taille == bouteille.taille &&
                this.type.equals(bouteille.type) &&
                this.bouchon.equals(bouteille.bouchon) &&
                this.breuvage.equals(bouteille.breuvage);
        }

        return isEqual;
    }

    public void setTailleBouteille(int taille) {
        this.taille = taille;
    }

    public void setType(StringBuffer type) {
        if (type == null) {
            type = new StringBuffer();
        }
        this.type = type;
    }

    public void setBouchon(StringBuffer bouchon) {
        if (bouchon == null) {
            bouchon = new StringBuffer();
        }
        this.bouchon = bouchon;
    }

    public void setLienPhoto(StringBuffer lienPhoto) {
        if (lienPhoto == null) {
            lienPhoto = new StringBuffer();
        }
        this.lienPhoto = lienPhoto;
    }

    public void setBreuvage(Breuvage breuvage) {
        if (breuvage == null) {
            breuvage = new Breuvage();
        }
        this.breuvage = breuvage;
    }

    public String getBouchon() {
        return this.bouchon.toString();
    }

    public int getTaille() {
        return this.taille;
    }

    public String getType() {
        return this.type.toString();
    }

    public StringBuffer getLienPhoto() {
        return this.lienPhoto;
    }

    public Breuvage getBreuvage() {
        return this.breuvage;
    }

    public int getIdentifiant() {
        return this.identifiant;
    }
}
