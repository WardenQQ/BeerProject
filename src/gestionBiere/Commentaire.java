package gestionBiere;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commentaire implements Serializable {
	private static int compteur = 1;
    private final int identifiant;
	private String nom;
	private String date;
	private String texte;
	
	public Commentaire() {
		identifiant = compteur;
		compteur++;
	}
	public Commentaire(String nom1, String texte1) {
		this();
		setNom(nom1);
		setTexte(texte1);
	}
	public void setDate() {
		Date date1 = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.date = simpleFormat.format(date1);
	}
	public String getDate() {
		return this.date;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setNom(String nom1) {
		this.nom = nom1;
	}
	public String getNom() {
		return this.nom;
	}
	public void setTexte(String texte1) {
		this.texte = texte1;
	}
	public String getTexte() {
		return this.texte;
	}
}
