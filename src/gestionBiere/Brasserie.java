package gestionBiere;

import java.io.Serializable;

public class Brasserie implements Serializable {
	private static int compteur = 1;
    private final int identifiant;
    private String nom;
    private LieuOrigine lieuOrigine;

    public Brasserie() {
        identifiant = compteur;
        compteur++;
        nom = "";
        lieuOrigine = new LieuOrigine();
    }

    public Brasserie(String nom, LieuOrigine lieuOrigine) {
        this();
        this.nom = nom;
        this.lieuOrigine = lieuOrigine;
    }

    public int getIdentifiant() { return identifiant;}

    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom;}

    public LieuOrigine getLieuOrigine() { return lieuOrigine;}
    public void setLieuOrigine(LieuOrigine lieuOrigine) { this.lieuOrigine = lieuOrigine; }
}
