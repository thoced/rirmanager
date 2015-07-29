package gui;

import java.awt.Component;

import javax.swing.JPanel;

public  class panelBase extends JPanel
{
	public  void saveModel()
	{
		
	}


	public void setEnabled(boolean enabled) 
	{
		// TODO Auto-generated method stub
		super.setEnabled(enabled);
		
		
		Component[] comps = this.getComponents();
		for(Component c : comps)
			c.setEnabled(enabled);
	}
	
	
}
