package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Quartier 
{
	private String nom;
	
	public Quartier()
	{
		
	}
	public Quartier(ResultSet result) throws SQLException
	{
		try 
		{
			nom = result.getString("ref_quartier");
			
		} catch (SQLException e) 
		{
		
		nom = result.getString("quartier");
			
		}
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return nom;
	}
}
