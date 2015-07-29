package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NumeroContact 
{
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public NumeroContact()
	{
		
	}
	public NumeroContact(ResultSet result)
	{
		try 
		{
			numero = result.getString("contact");
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numero;
	}
	
	
}
