package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Quartier;
import model.SqlLiteInterface;

public class listQuartiers extends JList
{
	private listQuartiersModel model;
	
	public listQuartiers() 
	{
		super();
		
		model = new listQuartiersModel();
	}
	
	public class listQuartiersModel extends DefaultListModel
	{

		public listQuartiersModel() 
		{
			super();
			
			// chargement du model
			ResultSet result;
			try 
			{
			
				result = SqlLiteInterface.SelectAllQuartier();
			
			DefaultComboBoxModel modelQuartier = new DefaultComboBoxModel();
			while(result.next())
			{
				Quartier quartier = new Quartier(result);
				modelQuartier.addElement(quartier);
								
				}
			// setmodel
			listQuartiers.this.setModel(modelQuartier);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
