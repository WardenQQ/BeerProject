package gestionBiere;

import java.util.UUID;

public class Breuvage {
    private final String identifiant;
    private String nom;
    Brasserie brasserie;
    int tauxAlcool;
    String couleur;
    String provenance;
    String fermentation;
    LieuOrigine lieuOrigine;
    int anneeOrigine;

    public Breuvage() {
    }
}
