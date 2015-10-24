package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Couleur
{
	private String couleur;
	
	public Couleur(ResultSet result) throws SQLException
	{
		couleur = result.getString("couleur");
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
