package gestionBiere;

import java.io.Serializable;

public class Breuvage implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int compteur = 1;

    private final int identifiant;

    private StringBuffer nom = new StringBuffer();
    private Brasserie brasserie = new Brasserie();
    private LieuOrigine lieuOrigine = new LieuOrigine();
    private double tauxAlcool = 0.0;
    private int anneeOrigine = 0;
    private StringBuffer couleur = new StringBuffer();
    private StringBuffer fermentation = new StringBuffer();
    private StringBuffer typeFermentation = new StringBuffer();
    private StringBuffer provenance = new StringBuffer();
    private StringBuffer commentaireDegustation = new StringBuffer();
    private StringBuffer commentaireLibre = new StringBuffer();
    
    public Breuvage() {
        identifiant = compteur;
        compteur++;
    }

    public Breuvage(StringBuffer nom,
            Brasserie brasserie,
            LieuOrigine lieuOrigine,
            double tauxAlcool,
            int anneeOrigine,
            StringBuffer couleur,
            StringBuffer fermentation,
            StringBuffer typeFermentation,
            StringBuffer provenance,
            StringBuffer commentaireDegustation,
            StringBuffer commentaireLibre) {
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

    public StringBuffer getNom() { return nom; }
    public void setNom(StringBuffer nom) {
        if (nom == null) {
            nom = new StringBuffer();
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

    public StringBuffer getCommentaireDegustation() {
        return commentaireDegustation;
    }

    public void setCommentaireDegustation(StringBuffer commentaireDegustation) {
        if (commentaireDegustation == null) {
            commentaireDegustation = new StringBuffer();
        }
        this.commentaireDegustation = commentaireDegustation;
    }
    
    public StringBuffer getCommentaireLibre() {
        return commentaireLibre;
    }

    public void setCommentaireLibre(StringBuffer commentaireLibre) {
        if (commentaireLibre == null) {
            commentaireLibre = new StringBuffer();
        }
        this.commentaireLibre = commentaireLibre;
    }
}
