package guiRecherche;

import guiListRIR.CtrlListRir;

public class CtrlRechercheInfo extends CtrlBaseRecherche {

	
	
	public CtrlRechercheInfo() 
	{
		super();
		
		this.dia = new diaRechercheInfo(null,"Recherche sur base d'un élément contenu dans les informations du RIR",true);
		
		this.init();
		
		this.dia.setVisible(true);
	}

	@Override
	protected void doRechercher() 
	{
		String info = ((diaRechercheInfo)dia).gettInfo().getText();
		
		if(info != null && info.length() > 0)
		{
			CtrlListRir ctrl = new CtrlListRir();
			this.dia.setVisible(false);
			ctrl.RechercheFromInfo(info);
		}

	}

}
