package gestionBiere;

import java.util.UUID;

public class Breuvage {
    private final String identifiant;

    private String nom;
    double tauxAlcool;
    int anneeOrigine;
    Brasserie brasserie;
    String couleur;
    String fermentation;
    String provenance;
    LieuOrigine lieuOrigine;

    public Breuvage() {
        identifiant = UUID.randomUUID().toString();
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
}
