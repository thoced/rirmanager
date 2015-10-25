package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Source 
{
	private String source;

	public Source(ResultSet result) throws SQLException
	{
		try 
		{
			source = result.getString("source");
			
		} catch (SQLException e) 
		{
			source = result.getString("ref_source");
		}
	}
	
	public Source() {
		// TODO Auto-generated constructor stub
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return source;
	}
	
	
}
