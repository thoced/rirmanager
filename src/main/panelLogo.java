package main;

import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JPanel;

public class panelLogo extends JPanel 
{

	public panelLogo() 
	{
		super();
		this.setSize(1086, 1288);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelLogo.class.getResource("/Textures/logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
		
		
	}

}
