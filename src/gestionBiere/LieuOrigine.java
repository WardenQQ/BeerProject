package gestionBiere;

import java.util.UUID;

public class LieuOrigine {
    private final String identifiant;
    private String nom;
    private String paysAppartenance;

    public LieuOrigine() {
        identifiant = UUID.randomUUID().toString();
        nom = "";
        paysAppartenance = "";
    }

    public LieuOrigine(String nom, String paysAppartenance) {
        this();
        setNom(nom);
        setPaysAppartenance(paysAppartenance);
    }

    public String getIdentifiant() { return identifiant; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(String paysAppartenance) {
        this.paysAppartenance = paysAppartenance;
    }
}
