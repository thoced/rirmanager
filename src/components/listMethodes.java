package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Methode;
import model.SqlLiteInterface;

public class listMethodes extends JList 
{
	private listMethodesModel model;

	public listMethodes() 
	{
		super();
		// TODO Auto-generated constructor stub
		model = new listMethodesModel();
	}
	
	public class listMethodesModel extends DefaultListModel
	{

		public listMethodesModel()
		{
			super();
			
			ResultSet result;
			try {
					result = SqlLiteInterface.SelectAllMethode();
				
				DefaultComboBoxModel cm = new DefaultComboBoxModel();
				while(result.next())
				{
					Methode methode = new Methode(result);
					cm.addElement(methode);
				}
				
				listMethodes.this.setModel(cm);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
