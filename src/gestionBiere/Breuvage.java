package gestionBiere;

import java.io.Serializable;
import java.util.ArrayList;

public class Breuvage implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int compteur = 1;

    private final int identifiant;

    private String nom = "";
    private Brasserie brasserie = new Brasserie();
    private LieuOrigine lieuOrigine = new LieuOrigine();
    private double tauxAlcool = 0.0;
    private int anneeOrigine = 0;
    private StringBuffer couleur = new StringBuffer();
    private StringBuffer fermentation = new StringBuffer();
    private StringBuffer typeFermentation = new StringBuffer();
    private StringBuffer provenance = new StringBuffer();
    private Commentaire commentaireDegustation = new Commentaire();
    private Commentaire commentaireLibre = new Commentaire();
    
    public Breuvage() {
        identifiant = compteur;
        compteur++;
    }

    public Breuvage(String nom,
            Brasserie brasserie,
            LieuOrigine lieuOrigine,
            double tauxAlcool,
            int anneeOrigine,
            StringBuffer couleur,
            StringBuffer fermentation,
            StringBuffer typeFermentation,
            StringBuffer provenance,
            Commentaire commentaireDegustation,
            Commentaire commentaireLibre) {
        this();
        setNom(nom);
        setBrasserie(brasserie);
        setLieuOrigine(lieuOrigine);
        setTauxAlcool(tauxAlcool);
        setCouleur(couleur);
        setFermentation(fermentation);
        setTypeFermentation(typeFermentation);
        setProvenance(provenance);
        setCommentaireDegustation(commentaireDegustation);
        setCommentaireLibre(commentaireLibre);
    }

    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj instanceof Breuvage) {
            Breuvage breuvage = (Breuvage)obj;
            isEqual = this.nom == breuvage.nom &&
                      this.tauxAlcool == breuvage.tauxAlcool &&
                      this.anneeOrigine == breuvage.anneeOrigine &&
                      this.couleur == breuvage.couleur &&
                      this.fermentation == breuvage.fermentation &&
                      this.typeFermentation == breuvage.typeFermentation &&
                      this.provenance == breuvage.provenance &&
                      this.brasserie.equals(breuvage.brasserie) &&
                      this.lieuOrigine.equals(breuvage.lieuOrigine);
        }

        return isEqual;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) {
        if (nom == null) {
            nom = new String();
        }
        this.nom = nom;
    }

    public double getTauxAlcool() {
        return tauxAlcool;
    }

    public void setTauxAlcool(double tauxAlcool) {
        this.tauxAlcool = tauxAlcool;
    }

    public int getAnneeOrigine() {
        return anneeOrigine;
    }

    public void setAnneeOrigine(int anneeOrigine) {
        this.anneeOrigine = anneeOrigine;
    }

    public Brasserie getBrasserie() {
        return brasserie;
    }

    public void setBrasserie(Brasserie brasserie) {
        if (brasserie == null) {
            brasserie = new Brasserie();
        }
        this.brasserie = brasserie;
    }

    public String getCouleur() {
        return couleur.toString();
    }

    public void setCouleur(StringBuffer couleur) {
        if (couleur == null) {
            couleur = new StringBuffer();
        }
        this.couleur = couleur;
    }

    public String getFermentation() {
        return fermentation.toString();
    }

    public void setFermentation(StringBuffer fermentation) {
        if (fermentation == null) {
            fermentation = new StringBuffer();
        }
        this.fermentation = fermentation;
    }

    public String getTypeFermentation() {
        return typeFermentation.toString();
    }

    public void setTypeFermentation(StringBuffer typeFermentation) {
        if (typeFermentation == null) {
            typeFermentation = new StringBuffer();
        }
        this.typeFermentation = typeFermentation;
    }

    public String getProvenance() {
        return provenance.toString();
    }

    public void setProvenance(StringBuffer provenance) {
        if (provenance == null) {
            provenance = new StringBuffer();
        }
        this.provenance = provenance;
    }

    public LieuOrigine getLieuOrigine() {
        return lieuOrigine;
    }

    public void setLieuOrigine(LieuOrigine lieuOrigine) {
        if (lieuOrigine == null) {
            lieuOrigine = new LieuOrigine();
        }
        this.lieuOrigine = lieuOrigine;
    }
    
    public int getIdentifiant() {
        return identifiant;
    }

    public Commentaire getCommentaireDegustation() {
        return commentaireDegustation;
    }

    public void setCommentaireDegustation(Commentaire commentaireDegustation) {
        if (commentaireDegustation == null) {
            commentaireDegustation = new Commentaire();
        }
        this.commentaireDegustation = commentaireDegustation;
    }
    
    public Commentaire getCommentaireLibre() {
        return commentaireLibre;
    }

    public void setCommentaireLibre(Commentaire commentaireLibre) {
        if (commentaireLibre == null) {
            commentaireLibre = new Commentaire();
        }
        this.commentaireLibre = commentaireLibre;
    }
}
