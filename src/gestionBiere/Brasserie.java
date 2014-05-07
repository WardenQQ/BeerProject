package gestionBiere;

import java.util.UUID;

public class Brasserie {
    private final String identifiant;
    private String nom;
    private LieuOrigine lieuOrigine;

    public Brasserie() {
        identifiant = UUID.randomUUID().toString();
        nom = "";
        lieuOrigine = new LieuOrigine();
    }

    public Brasserie(String nom, LieuOrigine lieuOrigine) {
        this();
        this.nom = nom;
        this.lieuOrigine = lieuOrigine;
    }

    public String getIdentifiant() { return identifiant;}

    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom;}

    public LieuOrigine getLieuOrigine() { return lieuOrigine;}
    public void setLieuOrigine(LieuOrigine lieuOrigine) { this.lieuOrigine = lieuOrigine; }
}
