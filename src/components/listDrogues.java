package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Drogue;
import model.SqlLiteInterface;

public class listDrogues extends JList
{
	private listDroguesModel model;

	public listDrogues()
	{
		super();
		// TODO Auto-generated constructor stub
		model = new listDroguesModel();
	}
	
	public class listDroguesModel extends DefaultListModel
	{

		public listDroguesModel()
		{
			super();
			
			ResultSet result;
			try 
			{
					result = SqlLiteInterface.SelectAllDrogue();
				
				DefaultComboBoxModel dm = new DefaultComboBoxModel();
				while(result.next())
				{
					Drogue drogue = new Drogue(result);
					dm.addElement(drogue);
				}
				
				listDrogues.this.setModel( dm);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
