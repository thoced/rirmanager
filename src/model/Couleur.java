package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Couleur
{
	private String couleur;
	
	public Couleur(ResultSet result) throws SQLException
	{
		try 
		{
			couleur = result.getString("couleur");
		} catch (SQLException e) 
		{
			couleur = result.getString("ref_couleur");
		}
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return couleur;
	}
	
	
}
