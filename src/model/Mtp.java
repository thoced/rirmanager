package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mtp 
{
	private String marque;
	private String immatriculation;
	private String couleur;
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public Mtp()
	{
		
	}
	
	public Mtp(ResultSet result)
	{
		try
		{
			marque = result.getString("marque");
			immatriculation = result.getString("immatriculation");
			couleur = result.getString("couleur");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return marque + " " + immatriculation + " " + couleur; 
	}
	
	
	
	
}
