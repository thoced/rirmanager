package gui;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowListener;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import model.ModelMVC;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class diaNewRir extends JDialog  implements ChangeListener, ActionListener,WindowListener
{
	private JTabbedPane tabbedPane;
	private panelMetaData panelMeta_;
	private panelData panelData_;
	private JButton bSaveRir;
	public diaNewRir(Frame frame,String title,boolean modal)
	{
		super(frame,title,modal);
		this.addWindowListener(this);
		
		this.setSize(800, 800);
		
				
		this.setLocationRelativeTo(this);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		 panelData_ = new panelData();
		tabbedPane.addTab("Information RIR", null, panelData_, null);
		
		 panelMeta_ = new panelMetaData();
		tabbedPane.addTab("Contenu de l'information", null, panelMeta_, null);
		
		ToolBarRir toolBarRir = new ToolBarRir();
		getContentPane().add(toolBarRir, BorderLayout.NORTH);
		
		JPanel panelBouton = new JPanel();
		getContentPane().add(panelBouton, BorderLayout.SOUTH);
		
		bSaveRir = new JButton("Enregistrer le RIR");
		bSaveRir.setActionCommand("SAVERIR");
		bSaveRir.addActionListener(this);
		bSaveRir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bSaveRir.setBackground(Color.PINK);
		panelBouton.add(bSaveRir);
	
		
	}
	
	

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		super.setEnabled(b);
		panelData_.setEnabled(b);
		panelMeta_.setEnabled(b);
		Component[] comps = this.getContentPane().getComponents();
		for(Component c : comps)
			c.setEnabled(b);
		
	}



	@Override
	public void stateChanged(ChangeEvent e)
	{
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "SAVERIR" : // on boucle sur les panel
							panelData_.saveModel();
							panelMeta_.saveModel();
							// enregistrement
							ModelMVC.saveRir();
							panelData_.setEnabled(false);
							panelMeta_.setEnabled(false);
							break;
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) 
	{
		panelData_.setEnabled(false);
		panelMeta_.setEnabled(false);
		
		
	}
}
