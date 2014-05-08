package gestionBiere;

public class LieuOrigine {
    private String nom;
    private String paysAppartenance;

    public LieuOrigine() {
        nom = "";
        paysAppartenance = "";
    }

    public LieuOrigine(String nom, String paysAppartenance) {
        this();
        setNom(nom);
        setPaysAppartenance(paysAppartenance);
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPaysAppartenance() { return paysAppartenance; }
    public void setPaysAppartenance(String paysAppartenance) {
        this.paysAppartenance = paysAppartenance;
    }
}
