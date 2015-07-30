package guiRecherche;

import guiListRIR.CtrlListRir;

import javax.swing.JTextField;

public class CtrlRecherchePersonne extends CtrlBaseRecherche {

	
	
	public CtrlRecherchePersonne() 
	{
		super();
		
		this.dia = new diaRecherchePersonne(null,"Recherche sur base d'une entité Personne",true);
		
		this.init();
		
		dia.setVisible(true);
	
	}

	@Override
	protected void doRechercher() 
	{
		String nom = ((diaRecherchePersonne)dia).gettNom().getText();
		String prenom =  ((diaRecherchePersonne)dia).gettPrenom().getText();
		String surnom =  ((diaRecherchePersonne)dia).gettSurnom().getText();
		
		// on enleve la fenetre
		this.dia.setVisible(false);
		// appel au controleur
		CtrlListRir ctrl = new CtrlListRir();
		ctrl.RechercheFromPersonne(nom, prenom, surnom);

	}

}
