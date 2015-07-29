package gui;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.ModelMVC;
import control.ControlListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class ToolBarRir extends JToolBar implements ActionListener {
	public ToolBarRir() {
		setFloatable(false);
		
		JButton bNew = new JButton("Nouveau Rir");
		bNew.setActionCommand("NEWRIR");
		bNew.addActionListener(this);
		bNew.setBackground(Color.CYAN);
		add(bNew);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case "NEWRIR" : ModelMVC.newRir(); this.getTopLevelAncestor().setEnabled(true);
							ModelMVC.updateMVC();
							break;
		}
		
	}

}
