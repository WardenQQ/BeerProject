package gestionBiere;

import java.io.Serializable;

public class Bouteille implements Serializable {
	private static int compteur = 1;
	private final int idBouteille;
	private int taille = 0;
	private String typeBouteille = ""; 
	private String bouchon;
	private String lienPhoto = ""; 
	private Breuvage breuvage; 
	
	public Bouteille()
	{
		this.idBouteille = compteur;
		compteur++;
		this.breuvage = new Breuvage();
	}
	
	public Bouteille(int taille,String typeBouteille,String bouchon,String lienPhoto,Breuvage breuvage)
	{
		this();
		setBouchon(bouchon);
		setBreuvage(breuvage);
		setTypeBouteille(typeBouteille);
		setTailleBouteille(taille);
		setLienPhoto(lienPhoto);
	}
	
	public void setBouchon(String bouchon)
	{
		this.bouchon = bouchon;
	}
	
	public void setBreuvage(Breuvage breuvage)
	{
		this.breuvage = breuvage;
	}
	
	public void setTypeBouteille(String typeBouteille)
	{
		this.typeBouteille = typeBouteille;
	}
	
	public void setTailleBouteille(int taille)
	{
		this.taille = taille;
	}
	
	public void setLienPhoto(String lienPhoto)
	{
		this.lienPhoto = lienPhoto;
	}
	
	public String getBouchon()
	{
		return this.bouchon;
	}
	
	public int getTaille()
	{
		return this.taille;
	}
	
	public String getTypeBouteille()
	{
		return this.typeBouteille;
	}
	
	public String getLienPhoto()
	{
		return this.lienPhoto;
	}
	
	public Breuvage getBreuvage()
	{
		return this.breuvage;
	}
	
	public int getIdBouteille()
	{
		return this.idBouteille;
	}
}
