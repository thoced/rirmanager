package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMtp
{
	private String type;
	
	public TypeMtp(ResultSet result) throws SQLException
	{
		try 
		{
			type = result.getString("type");
		} catch (SQLException e) 
		{
			type = result.getString("type");
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
