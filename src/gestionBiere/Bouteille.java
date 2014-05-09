package gestionBiere;

public class Bouteille {
	private static int compteur = 1;
	private final int id_Bouteille;
	private int taille = 0;
	private String type_bouteille = ""; 
	private String bouchon;
	private String lien_photo = ""; 
	private Breuvage breuvage; 
	
	public Bouteille()
	{
		this.id_Bouteille = compteur;
		compteur++;
		this.breuvage = new Breuvage();
	}
	
	public Bouteille(int taille,String type_bouteille,String bouchon,String lien_photo,Breuvage breuvage)
	{
		this();
		setBouchon(bouchon);
		setBreuvage(breuvage);
		setTypeBouteille(type_bouteille);
		setTailleBouteille(taille);
		setLienPhoto(lien_photo);
	}
	
	public void setBouchon(String bouchon)
	{
		this.bouchon = bouchon;
	}
	
	public void setBreuvage(Breuvage breuvage)
	{
		this.breuvage = breuvage;
	}
	
	public void setTypeBouteille(String type_bouteille)
	{
		this.type_bouteille = type_bouteille;
	}
	
	public void setTailleBouteille(int taille)
	{
		this.taille = taille;
	}
	
	public void setLienPhoto(String lien_photo)
	{
		this.lien_photo = lien_photo;
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
		return this.type_bouteille;
	}
	
	public String getLienPhoto()
	{
		return this.lien_photo;
	}
	
	public Breuvage getBreuvage()
	{
		return this.breuvage;
	}
	
	public int getIdBouteille()
	{
		return this.id_Bouteille;
	}
}
