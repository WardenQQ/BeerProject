package gestionBiere;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commentaire implements Serializable {
    private static final long serialVersionUID = 0L;

    private static int compteur = 1;

    private final int identifiant;

    private String nom;
    private String date;
    private String texte;

    public Commentaire() {
        identifiant = compteur;
        compteur++;
    }

    public Commentaire(String nom, String texte) {
        this();
        setNom(nom);
        setTexte(texte);
    }

    private void setDate() {
        Date date = new Date();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.date = simpleFormat.format(date);
    }

    public String getDate() {
        return this.date;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setNom(String nom) {
        if (nom == null) {
            nom = new String();
        }
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setTexte(String texte) {
        if (texte == null) {
            texte = new String();
        }
        this.texte = texte;
        setDate();
    }

    public String getTexte() {
        return this.texte;
    }
}
