package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrenomManySearch
{
	private String prenom;
	private int nb;
	
	public PrenomManySearch(ResultSet result)
	{
		try 
		{
			prenom  = result.getString("prenom");
			nb = result.getInt("nb");
		}
		catch(SQLException e)
		{
			
		}
		
	}
	
	
	
	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNb() {
		return String.valueOf(nb);
	}
	public void setNb(String nb) {
		this.nb = Integer.parseInt(nb);
	}
	
	
}
