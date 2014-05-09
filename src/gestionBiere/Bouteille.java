package gestionBiere;

import java.io.Serializable;

public class Bouteille implements Serializable {
	private static int compteur = 1;
	private final int idBouteille;
	private int taille = 0;
	private String type = ""; 
	private String bouchon;
	private String lienPhoto = ""; 
	private Breuvage breuvage; 
	
	public Bouteille()
	{
		this.idBouteille = compteur;
		compteur++;
		this.breuvage = new Breuvage();
	}
	
	public Bouteille(int taille,String type,String bouchon,String lienPhoto,Breuvage breuvage)
	{
		this();
		setBouchon(bouchon);
		setBreuvage(breuvage);
		setType(type);
		setTailleBouteille(taille);
		setLienPhoto(lienPhoto);
	}

        public boolean equals(Object obj) {
            if (obj instanceof Bouteille) {
                Bouteille bouteille = (Bouteille)obj;
                return this.taille == bouteille.taille &&
                       this.type.equals(bouteille.type) &&
                       this.bouchon.equals(bouteille.bouchon) &&
                       this.breuvage.equals(bouteille.breuvage);
            }

            return false;
        }
	
	public void setBouchon(String bouchon)
	{
		this.bouchon = bouchon;
	}
	
	public void setBreuvage(Breuvage breuvage)
	{
		this.breuvage = breuvage;
	}
	
	public void setType(String type)
	{
		this.type = type;
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
	
	public String getType()
	{
		return this.type;
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
