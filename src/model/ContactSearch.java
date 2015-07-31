package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactSearch 
{
	private String contact;
	private int nb;
	
	public ContactSearch(ResultSet result)
	{
		try 
		{
			contact  = result.getString("contact");
			nb = result.getInt("nb");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	
	
}
