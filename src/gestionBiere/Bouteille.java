package gestionBiere;
import java.util.UUID;

public class Bouteille {
	
	final private String id_Bouteille;
	private int taille;
	private String type_bouteille; // a modifier en objet bouteille
	private Bouchon bouchon;
	private String lien_photo; // a verifier
	private String breuvage; // a modifier en objet breuvage
	
	public Bouteille()
	{
		this.id_Bouteille = UUID.randomUUID().toString();
	}
	
	public Bouteille(int taille,String type_bouteille,Bouchon bouchon,String lien_photo,String breuvage)
	{
		this();
		setBouchon(bouchon);
		setBreuvage(breuvage);
		setTypeBouteille(type_bouteille);
		setTailleBouteille(taille);
		setLienPhoto(lien_photo);
	}
	
	public void setBouchon(Bouchon bouchon)
	{
		this.bouchon = bouchon;
	}
	
	public void setBreuvage(String breuvage)
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
	
	public Bouchon getBouchon()
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
	
	public String getBreuvage()
	{
		return this.breuvage;
	}
	
	public String getIdBouteille()
	{
		return this.id_Bouteille;
	}
}
