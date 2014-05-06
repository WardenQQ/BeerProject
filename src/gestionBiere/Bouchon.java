package gestionBiere;
import java.util.UUID;

public class Bouchon {
	
	final private String id_bouchon;
	private String nom = "";
	
	public Bouchon()
	{
		this.id_bouchon = UUID.randomUUID().toString();
	}
	
	public Bouchon(String nom)
	{
		this();
		setNomBouchon(nom);
	}
	
	public void setNomBouchon(String nomBouchon)
	{
		this.nom = nomBouchon;
	}
	
	public String getNomBouchon()
	{
		return this.nom;
	}
	
	public String getIdBouchon()
	{
		return this.id_bouchon;
	}
		
	public String toString()
	{
		return "Le type de ce bouchon est : " + nom;
	}
	
}
