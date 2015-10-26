package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Personne 
{
	private String nom;
	private String prenom;
	private String  dateNaissance;
	private String surnom;
	private int nb;
	
	public Personne()
	{
		
	}
	
	public Personne(ResultSet result)
	{
		try
		{
		nom = result.getString("nom");
		prenom  = result.getString("prenom");
		surnom = result.getString("surnom");
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(result.getDate("datenaissance").getTime());
		String sf = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(sf);
		dateNaissance = format.format(cal.getTime());
		
		
		
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException npe)
		{
			
		}
	}
	
	
	
	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom.trim().toUpperCase();
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		if(surnom != null)
			return nom + " " + prenom + " (" + surnom + ") " + dateNaissance;
		else
			return nom + " " + prenom + " " + dateNaissance;
	}
	
	
}
