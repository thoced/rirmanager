package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Methode;
import model.SqlLiteInterface;

public class comboMethodes extends JComboBox
{
	private comboMethodesModel model;
	
	public comboMethodes() 
	{
		super();
		
		try {
			model = new comboMethodesModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class comboMethodesModel
	{

		public comboMethodesModel() throws ClassNotFoundException, SQLException 
		{
			super();
			
			ResultSet result = SqlLiteInterface.SelectAllMethode();
			DefaultComboBoxModel cm = new DefaultComboBoxModel();
			while(result.next())
			{
				Methode methode = new Methode(result);
				cm.addElement(methode);
			}
			
			comboMethodes.this.setModel(cm);
		}
		
	}
}
