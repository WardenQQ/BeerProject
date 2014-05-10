package gestionBiere;

import java.io.Serializable;

public class Bouteille implements Serializable {
    private static final long serialVersionUID = 0L;

    private static int compteur = 1;

    private final int identifiant;

    private int taille = 0;
    private String type = ""; 
    private String bouchon = "";
    private String lienPhoto = ""; 
    private Breuvage breuvage = new Breuvage(); 

    public Bouteille() {
        this.identifiant = compteur;
        compteur++;
    }

    public Bouteille(int taille, String type, String bouchon, String lienPhoto, Breuvage breuvage) {
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

    public void setType(String type) {
        if (type == null) {
            type = new String();
        }
        this.type = type;
    }

    public void setBouchon(String bouchon) {
        if (bouchon == null) {
            bouchon = new String();
        }
        this.bouchon = bouchon;
    }

    public void setLienPhoto(String lienPhoto) {
        if (lienPhoto == null) {
            lienPhoto = new String();
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
        return this.bouchon;
    }

    public int getTaille() {
        return this.taille;
    }

    public String getType() {
        return this.type;
    }

    public String getLienPhoto() {
        return this.lienPhoto;
    }

    public Breuvage getBreuvage() {
        return this.breuvage;
    }

    public int getIdentifiant() {
        return this.identifiant;
    }
}
