package model;

import java.sql.ResultSet;

public class PersonneSearch 
{
	private String nom;
	private String prenon;
	private String surnom;
	private String datenaisance;
	private String nb;
	
	public PersonneSearch(ResultSet result)
	{
		
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenon() {
		return prenon;
	}
	public void setPrenon(String prenon) {
		this.prenon = prenon;
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
		return nb;
	}
	public void setNb(String nb) {
		this.nb = nb;
	}
	
	
}
