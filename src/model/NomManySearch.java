package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NomManySearch
{
	private String nom;
	private int nb;
	
	public NomManySearch(ResultSet result)
	{
		try 
		{
			nom  = result.getString("nom");
			nb = result.getInt("nb");
		}
		catch(SQLException e)
		{
			
		}
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNb() {
		return String.valueOf(nb);
	}
	public void setNb(String nb) {
		this.nb = Integer.parseInt(nb);
	}
	
	
}
