package components;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import gui.diaAddRirView;
import model.Quartier;
import model.SqlLiteInterface;

public class comboQuartiers extends JComboBox
{
	private comboQuartiersModel model;
	
		
	public comboQuartiers() {
		super();
		// TODO Auto-generated constructor stub
		try
		{
			model = new comboQuartiersModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	public class comboQuartiersModel
	{

		public comboQuartiersModel() throws ClassNotFoundException, SQLException 
		{
			super();
			
				// chargement du model
			ResultSet result = SqlLiteInterface.SelectAllQuartier();
			DefaultComboBoxModel modelQuartier = new DefaultComboBoxModel();
			while(result.next())
			{
				Quartier quartier = new Quartier(result);
				modelQuartier.addElement(quartier);
								
				}
			// setmodel
			comboQuartiers.this.setModel(modelQuartier);
			
		}
		
	}
	
}
