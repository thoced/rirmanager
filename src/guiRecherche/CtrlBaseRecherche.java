package guiRecherche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CtrlBaseRecherche implements ActionListener
{
	protected diaBaseRecherche dia;
	
	public CtrlBaseRecherche()
	{
		super();
	
	}
	
	public void init()
	{
		// ajout des boutons
		dia.getbAnnuler().addActionListener(this);
		dia.getbAnnuler().setActionCommand("ANNULER");
				
		dia.getbRecherche().addActionListener(this);
		dia.getbRecherche().setActionCommand("RECHERCHER");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
			case "ANNULER" : this.doAnnuler();break;
			
			case "RECHERCHER": this.doRechercher();break;
		}
		
	}
	
	protected void doAnnuler()
	{
		dia.setVisible(false);
	}
	
	protected abstract void doRechercher();
	
	
}
