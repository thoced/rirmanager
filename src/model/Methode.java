package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Methode 
{
	private String methode;

	public Methode()
	{
		
	}
	public Methode(ResultSet result)
	{
		try 
		{
			methode = result.getString("ref_methode");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return methode;
	}
	
	
}
