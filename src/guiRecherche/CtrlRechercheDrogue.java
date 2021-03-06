package guiRecherche;

import guiListRIR.CtrlListRir;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import model.SqlLiteInterface;

public class CtrlRechercheDrogue extends CtrlBaseRecherche
{
	
	public CtrlRechercheDrogue() 
	{
		super();

		dia = new diaRechercheWithList(null,"Recherche sur base des types de drogue",true);
		this.init();
		
		// récupération de la liste des drogues
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllDrogue();
			
			// création du model pour la liste
			DefaultListModel model = new DefaultListModel();
			
			while(result.next())
			{
				model.addElement(result.getString("drogue"));
			}
			((diaRechercheWithList)dia).getList().setModel(model);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dia.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		super.actionPerformed(arg0);
		
		
	}



	@Override
	protected void doRechercher() 
	{
		String rech = (String)((diaRechercheWithList)dia).getList().getSelectedValue();
		dia.setVisible(false);
		CtrlListRir cl = new CtrlListRir();
		cl.RechercheFromDrogue(rech);
		
	}
	
}
