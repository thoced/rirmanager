package guiRecherche;

import java.awt.event.ActionEvent;

public class CtrlRechercheDrogue extends CtrlBaseRecherche
{
	
	public CtrlRechercheDrogue() 
	{
		super();

		dia = new diaRechercheDrogue(null,"Recherche sur base des types de drogue",true);
		this.init();
		
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
		if(((diaRechercheDrogue)dia).getGroup().getSelection() != null)
		{
			switch(((diaRechercheDrogue)dia).getGroup().getSelection().getActionCommand())
			{
			case "COCAINE" : dia.setVisible(false); break;
			}
		}
	
	}
	
}
