package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PersonneSearch 
{
	private String nom;
	private String prenom;
	private String surnom;
	private String datenaisance;
	private int nb;
	
	public PersonneSearch(ResultSet result)
	{
		try 
		{
			nom  = result.getString("nom");
			prenom = result.getString("prenom");
			surnom = result.getString("surnom");
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(result.getDate("datenaissance").getTime());
			String sf = "dd/MM/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(sf);
			datenaisance = format.format(cal.getTime());
			nb = result.getInt("nb");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			
		}
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenon() {
		return prenom;
	}
	public void setPrenon(String prenon) {
		this.prenom = prenon;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getDatenaisance() {
		return datenaisance;
	}
	public void setDatenaisance(String datenaisance) {
		this.datenaisance = datenaisance;
	}
	public String getNb() {
		return String.valueOf(nb);
	}
	public void setNb(String nb) {
		this.nb = Integer.parseInt(nb);
	}
	
	
}
