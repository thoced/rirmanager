package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SurnomManySearch
{
	private String surnom;
	private int nb;
	
	public SurnomManySearch(ResultSet result)
	{
		try 
		{
			surnom  = result.getString("surnom");
			nb = result.getInt("nb");
		}
		catch(SQLException e)
		{
			
		}
		
	}
	
	public String getSurnom() {
		return surnom;
	}


	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}

	public String getNb() {
		return String.valueOf(nb);
	}
	public void setNb(String nb) {
		this.nb = Integer.parseInt(nb);
	}
	
	
}
