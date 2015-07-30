package guiRecherche;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import model.SqlLiteInterface;
import guiListRIR.CtrlListRir;

public class CtrlRechercheMtp extends CtrlBaseRecherche {

	
	
	public CtrlRechercheMtp() 
	{
		super();
		
		
		this.dia = new diaRechercheMtp(null,"Recherche sur base d'une entité Moyen de Transport", true);
		this.init();
		
		// recherche de toutes les couleur
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllCouleur();
			
			// création du model pour la liste
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			
			while(result.next())
			{
				model.addElement(result.getString("couleur"));
			}
			((diaRechercheMtp)dia).getcCouleur().setModel(model);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dia.setVisible(true);	
	}

	@Override
	protected void doRechercher() 
	{
		String marque = ((diaRechercheMtp)dia).gettMarque().getText();
		String immatriculation =  ((diaRechercheMtp)dia).gettImmatriculation().getText();
		String couleur =  ((diaRechercheMtp)dia).getcCouleur().getSelectedItem().toString();
		
		// on rend invisible la fenetre
		this.dia.setVisible(false);
		
		CtrlListRir ctrl = new CtrlListRir();
		ctrl.RechercheFromMtp(marque, immatriculation, couleur);

	}

}
