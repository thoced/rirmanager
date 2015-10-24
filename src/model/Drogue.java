package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drogue 
{
	private String type;

	public Drogue()
	{
		
	}
	
	public Drogue(ResultSet result)
	{
		try
		{
			type = result.getString("drogue");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type;
	}
	
	
}
