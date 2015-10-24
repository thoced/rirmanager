package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import model.Drogue;
import model.SqlLiteInterface;

public class comboDrogues extends JComboBox 
{
	private comboDroguesModel model;
	
	public comboDrogues() 
	{
		super();
		
		try 
		{
			model = new comboDroguesModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class comboDroguesModel
	{

		public comboDroguesModel() throws ClassNotFoundException, SQLException 
		{
			super();
			
			ResultSet result = SqlLiteInterface.SelectAllDrogue();
			DefaultComboBoxModel dm = new DefaultComboBoxModel();
			while(result.next())
			{
				Drogue drogue = new Drogue(result);
				dm.addElement(drogue);
			}
			
			comboDrogues.this.setModel( dm);
		}
		
	}

}
