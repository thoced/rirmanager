package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Source 
{
	private String source;

	public Source(ResultSet result)
	{
		try 
		{
			source = result.getString("source");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
