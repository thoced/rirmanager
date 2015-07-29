package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Rir;

public class ControlListener implements ActionListener {

	
	private static ControlListener currentControl;
	
	private Rir currentRir;
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(arg0.getActionCommand())
		{
			case "NEWRIR": currentRir = new Rir();
			
		}

	}
	
	public ControlListener()
	{
		currentControl = new ControlListener();
	}
	
	public static ControlListener getControlListener()
	{
		return currentControl;
	}

}
