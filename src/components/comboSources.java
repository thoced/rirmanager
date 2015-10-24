package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Source;
import model.SqlLiteInterface;

public class comboSources extends JComboBox 
{
	private comboSourcesModel model;
	

	public comboSources() {
		super();
		// TODO Auto-generated constructor stub
		try
		{
			model = new comboSourcesModel();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public class comboSourcesModel
	{

		public comboSourcesModel() throws ClassNotFoundException, SQLException {
			super();
			
			ResultSet result = SqlLiteInterface.SelectAllSource();
			DefaultComboBoxModel mc = new DefaultComboBoxModel();
			while(result.next())
			{
				Source source = new Source(result);
				mc.addElement(source);
			}
			
			comboSources.this.setModel(mc);
		}
		
	}
}
