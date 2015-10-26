package components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Couleur;
import model.SqlLiteInterface;
import model.TypeMtp;

public class comboTypeMtp extends JComboBox 
{
	private comboTypeMtpModel model;
	
	public comboTypeMtp() {
		super();
		
		try 
		{
			model = new comboTypeMtpModel();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class comboTypeMtpModel
	{

		public comboTypeMtpModel() throws ClassNotFoundException, SQLException 
		{
			super();
		
			// chargement
			ResultSet result = SqlLiteInterface.SelectAllTypeMtp();
			DefaultComboBoxModel cm = new DefaultComboBoxModel();
			while(result.next())
			{
				TypeMtp type = new TypeMtp(result);
				cm.addElement(type);
			}
			
			comboTypeMtp.this.setModel(cm);
		}
		
	}
}
