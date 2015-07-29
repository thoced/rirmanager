package gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.ModelMVC;

public class panelMetaData extends panelBase implements ActionListener
{
	private JTextArea tNatureInfo;
	private JButton bAddPdf;
	private JLabel labelPdf;
	public panelMetaData()
	{
		this.setSize(800, 800);
		setLayout(null);
		
		panelBase panelPdf = new panelBase();
		panelPdf.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Document PDF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPdf.setBounds(0, 11, 800, 82);
		add(panelPdf);
		panelPdf.setLayout(null);
		
		bAddPdf = new JButton("Ajouter le document (Pdf)");
		bAddPdf.setActionCommand("ADDPDF");
		bAddPdf.addActionListener(this);
		bAddPdf.setBounds(10, 25, 200, 23);
		panelPdf.add(bAddPdf);
		
		labelPdf = new JLabel("");
		labelPdf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelPdf.setBounds(220, 29, 250, 14);
		panelPdf.add(labelPdf);
		
		panelBase panelMeta = new panelBase();
		panelMeta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contenu de l'information douce", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMeta.setBounds(0, 104, 800, 227);
		add(panelMeta);
		panelMeta.setLayout(null);
		
		tNatureInfo = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(tNatureInfo);
		scrollPane.setBounds(10, 26, 780, 190);
		panelMeta.add(scrollPane);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "ADDPDF": 		JFileChooser file = new JFileChooser();
							file.setDefaultLocale(this.getLocale());
							int ret = file.showOpenDialog(this);
							if(ret == JFileChooser.APPROVE_OPTION)
							{
								File fichier = file.getSelectedFile();
								ModelMVC.insertFile(fichier);
								// modif du label
								if(fichier != null)
									labelPdf.setText("Fichier à ajouter: " +  fichier.getName());
							}
		
							break;
							
		
			
		}
		
	}
	@Override
	public void saveModel() 
	{
		// insert dans le model de la nature de l'info
		ModelMVC.insertNature(tNatureInfo.getText());
		
	}
}
