package gestionBiere;

import java.io.Serializable;
import java.util.ArrayList;

public class Breuvage implements Serializable {
    private static int compteur = 1;
    private final int identifiant;
    private String nom;
    private double tauxAlcool;
    private int anneeOrigine;
    private Brasserie brasserie;
    private String couleur;
    private String fermentation;
    private String typeFermentation;
    private String provenance;
    private LieuOrigine lieuOrigine;
    private ArrayList<Commentaire> com_degustation;
    private ArrayList<Commentaire> com_libre;
    
    public Breuvage() {
        identifiant = compteur;
        compteur++;
        this.com_degustation = new ArrayList<Commentaire>();
        this.com_libre = new ArrayList<Commentaire>();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Breuvage) {
            Breuvage breuvage = (Breuvage)obj;
            return this.nom == breuvage.nom &&
                   this.tauxAlcool == breuvage.tauxAlcool &&
                   this.anneeOrigine == breuvage.anneeOrigine &&
                   this.couleur == breuvage.couleur &&
                   this.fermentation == breuvage.fermentation &&
                   this.typeFermentation == breuvage.typeFermentation &&
                   this.provenance == breuvage.provenance &&
                   this.brasserie.equals(breuvage.brasserie) &&
                   this.lieuOrigine.equals(breuvage.lieuOrigine);
        }
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; };

    public double getTauxAlcool() { return tauxAlcool; }
    public void setTauxAlcool(double tauxAlcool) { this.tauxAlcool = tauxAlcool; };

    public int getAnneeOrigine() { return anneeOrigine; }
    public void setAnneeOrigine(int anneeOrigine) { this.anneeOrigine = anneeOrigine; };

    public Brasserie getBrasserie() { return brasserie; }
    public void setBrasserie(Brasserie brasserie) { this.brasserie = brasserie; };

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; };

    public String getFermentation() { return fermentation; }
    public void setFermentation(String fermentation) { this.fermentation = fermentation; };

    public String getProvenance() { return provenance; }
    public void setProvenance(String provenance) { this.provenance = provenance; };

    public LieuOrigine getLieuOrigine() { return lieuOrigine; }
    public void setLieuOrigine(LieuOrigine lieuOrigine) { this.lieuOrigine = lieuOrigine; };
    
    public int getIdentifiant() 
    {
		return identifiant;
	}
    
    public void ajoutComDegustation(Commentaire com_degustation)
    {
    	this.com_degustation.add(com_degustation);
    }
    
    public void ajoutComLibre(Commentaire com_libre)
    {
    	this.com_libre.add(com_libre);
    }
}
