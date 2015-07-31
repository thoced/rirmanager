package guiRecherche;

import guiListRIR.CtrlListRir;

public class CtrlRechercheContact extends CtrlBaseRecherche {

	
	
	public CtrlRechercheContact()
	{
		super();
		
			this.dia = new diaRechercheContact(null,"Recherche sur base d'un numéro de Contact",true);
			
			this.init();
			
			dia.setVisible(true);
	}

	@Override
	protected void doRechercher() 
	{
		String contact = ((diaRechercheContact)dia).gettContact().getText();
		
		if(contact != null && contact.length() > 0 )
		{
			this.dia.setVisible(false);
			CtrlListRir ctrl = new CtrlListRir();
			ctrl.RechercheFromContact(contact);
		}

	}

}
