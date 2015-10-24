package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Quartier 
{
	private String nom;
	
	public Quartier()
	{
		
	}
	public Quartier(ResultSet result)
	{
		try 
		{
			nom = result.getString("quartier");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
