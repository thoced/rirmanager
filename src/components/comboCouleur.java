package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Couleur;
import model.SqlLiteInterface;

public class comboCouleur extends JComboBox 
{
	private comboCouleurModel model;
	
	public comboCouleur() 
	{
		super();
		
		try
		{
			model = new comboCouleurModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public class comboCouleurModel
	{

		public comboCouleurModel() throws ClassNotFoundException, SQLException
		{
			super();
			
			ResultSet result = SqlLiteInterface.SelectAllCouleur();
			DefaultComboBoxModel cm = new DefaultComboBoxModel();
			while(result.next())
			{
				Couleur couleur = new Couleur(result);
				cm.addElement(couleur);
			}
			
			comboCouleur.this.setModel(cm);
		}
		
	}

}
