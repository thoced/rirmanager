package guiRecherche;

import guiListRIR.CtrlListRir;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import model.SqlLiteInterface;

public class CtrlRechercheQuartier extends CtrlBaseRecherche 
{

	
	
	public CtrlRechercheQuartier()
	{
		super();
		
		dia = new diaRechercheWithList(null,"Recherche sur base d'un quartier",true);
		
		this.init();
		
		// selection de tous les quartiers
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllQuartier();
			
			// création du model pour la liste
			DefaultListModel model = new DefaultListModel();
			
			while(result.next())
			{
				model.addElement(result.getString("quartier"));
			}
			((diaRechercheWithList)dia).getList().setModel(model);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dia.setVisible(true);
	}

	@Override
	protected void doRechercher() 
	{
		String rech = (String)((diaRechercheWithList)dia).getList().getSelectedValue();
		dia.setVisible(false);
		CtrlListRir cl = new CtrlListRir();
		cl.RechercheFromQuartier(rech);

	}

}
