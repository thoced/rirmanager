package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drogue 
{
	private String type;

	public Drogue()
	{
		
	}
	
	public Drogue(ResultSet result) throws SQLException
	{
		try
		{
			type = result.getString("ref_drogue");
			
		} catch (SQLException e)
		{
			type = result.getString("drogue");
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
