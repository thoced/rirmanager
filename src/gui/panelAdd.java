package gui;

import java.awt.Panel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

import model.Drogue;
import model.ICallBackMVC;
import model.Methode;
import model.ModelMVC;
import model.Mtp;
import model.NumeroContact;
import model.Personne;
import model.Quartier;
import model.Rir;
import model.SqlLiteInterface;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.awt.Font;


public class panelAdd extends Panel implements ActionListener, ICallBackMVC{
	private JComboBox cQuartier;
	private JList listQuartier;
	private JTextField textField;
	public panelAdd() 
	{
		setLayout(null);
		
		this.setSize(800, 800);
		
		
	
		// attachMVC
		ModelMVC.attachMVC(this);
		
		JLabel label = new JLabel("Quartier:");
		label.setBounds(10, 60, 85, 14);
		add(label);
		
		cQuartier = new JComboBox();
		
		cQuartier.setBounds(105, 57, 158, 20);
		add(cQuartier);
		
		JButton bAddQuartier = new JButton("Add");
		bAddQuartier.setActionCommand("ADDQUARTIER");
		bAddQuartier.addActionListener(this);
		bAddQuartier.setBounds(310, 56, 89, 23);
		add(bAddQuartier);
		
		listQuartier = new JList();
		JScrollPane scrollPane = new JScrollPane(listQuartier);
		scrollPane.setBounds(456, 60, 238, 57);
		add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(119, 154, 86, 20);
		add(textField);
		textField.setColumns(10);
		
	
		
		ModelMVC.newRir();
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(arg0.getActionCommand())
		{
			case "ADDQUARTIER" :  	/*Quartier quartier = new Quartier();
									quartier.setNom(cQuartier.getSelectedItem().toString());
									ModelMVC.insertQuartier(quartier);
									cQuartier.setSelectedIndex(0);*/
									diaAdd dd = new diaAdd(null,"bonjour",true);
									dd.setVisible(true);
				/*					break;
									
			case "ADDDROGUE" :     	Drogue drogue = new Drogue();
									drogue.setType(cDrogue.getSelectedItem().toString());
									ModelMVC.insertDrogue(drogue);
									cDrogue.setSelectedIndex(0);
									break;
									
			case "ADDPERSONNE":		Personne personne = new Personne();
									personne.setNom(tNomPersonne.getText());
									personne.setPrenom(tPrenomPersonne.getText());
									personne.setDateNaissance(tDateNaissance.getText().trim());
									personne.setSurnom(tSurnom.getText().trim());
									ModelMVC.insertPersonne(personne);
									tNomPersonne.setText("");
									tPrenomPersonne.setText("");
									tDateNaissance.setText("");
									tSurnom.setText("");
									break;
									
			case "ADDMETHODE":		Methode methode = new Methode();
									methode.setMethode(cMethode.getSelectedItem().toString().trim());
									ModelMVC.insertMethode(methode);
									cMethode.setSelectedIndex(0);
									break;
									
			case "ADDMTP" :			Mtp mtp = new Mtp();
									mtp.setMarque(tMarque.getText());
									mtp.setImmatriculation(tImmatriculation.getText());
									mtp.setCouleur(cCouleur.getSelectedItem().toString());
									ModelMVC.insertMtp(mtp);
									tMarque.setText("");
									tImmatriculation.setText("");
									cCouleur.setSelectedIndex(0);
									break;
									
			case "ADDFICHIER" :		JFileChooser file = new JFileChooser();
									file.setDefaultLocale(this.getLocale());
									int ret = file.showOpenDialog(this);
									if(ret == JFileChooser.APPROVE_OPTION)
									{
										File fichier = file.getSelectedFile();
										ModelMVC.insertFile(fichier);
										// modif du label
										if(fichier != null)
											labelPDF.setText(fichier.getName());
									}
									
									break;
									
			case "ADDNUMEROCONTACT": 	NumeroContact numero = new NumeroContact();
										numero.setNumero(tNumeroContact.getText().trim());
										ModelMVC.insertNumeroContact(numero);
										tNumeroContact.setText("");
										break;
									
									
			case "SAVERIR" :		// transformation de la daterir
									String[] stringDate = tDateRir.getText().trim().split("/");
									if(stringDate != null)
									{
										int year = Integer.valueOf(stringDate[2].trim());
										int month = Integer.valueOf(stringDate[1].trim());
										int day = Integer.valueOf(stringDate[0].trim());
										// creation du calendar
										Calendar calendar = Calendar.getInstance();
										calendar.set(year, month - 1, day);
										// réception du java.sql.date
										java.sql.Date dateRir = new java.sql.Date(calendar.getTimeInMillis());
										ModelMVC.insertDateRir(dateRir);
										ModelMVC.insertNumero(tNumero.getText().trim());
										ModelMVC.insertNature(eNature.getText());
										ModelMVC.saveRir();
									}
									
									break;
									*/
		}
		
	}
	@Override
	public void update(Rir rir)
	{
		/// on update la liste des quartiers
		// on créer un default list model
		DefaultListModel model = new DefaultListModel();
		for(Quartier q : rir.getListQuartier())
		{
			model.addElement(q);
		}
		// on ajoute dans la listQuartiers
		listQuartier.setModel(model);
	
		/*
		// update des drogues
		DefaultListModel modelDrogue = new DefaultListModel();
		for(Drogue d : rir.getListDrogue())
		{
			modelDrogue.addElement(d);
		}
		// on ajoute dans la listQuartiers
		listDrogues.setModel(modelDrogue);
		
		// update des personnes
		DefaultListModel modelPersonne = new DefaultListModel();
		for(Personne p : rir.getListPersonne())
		{
			modelPersonne.addElement(p);
		}
		// on ajoute dans la listQuartiers
		listPersonnes.setModel(modelPersonne);
		
		// update des Mtp
		DefaultListModel modelMtp = new DefaultListModel();
		for(Mtp p : rir.getListMtp())
		{
			modelMtp.addElement(p);
		}
		// on ajoute dans la listQuartiers
		listMtp.setModel(modelMtp);		
		
		// update des methodes
		DefaultListModel modelMethode = new DefaultListModel();
		for(Methode m : rir.getListMethode())
		{
			modelMethode.addElement(m);
		}
		// on ajoute dans la listQuartiers
		listMethode.setModel(modelMethode);		
		
		// update des numero contact
		DefaultListModel modelContact = new DefaultListModel();
		for(NumeroContact m : rir.getListNumeroContact())
		{
			modelContact.addElement(m);
		}
		// on ajoute dans la listQuartiers
		listContact.setModel(modelContact);		*/
	}
	
	
	public void init()
	{
		// initi
		List<Quartier> listQuartier = ModelMVC.getAllQuartier();
		if(listQuartier != null)
		{
			DefaultComboBoxModel modelQuartier = new DefaultComboBoxModel();
			for(Quartier q : listQuartier)
			{
				modelQuartier.addElement(q);
			}
					
			cQuartier.setModel(modelQuartier);
		}
		/*
		// init drogue
		List<Drogue> listDrogue = ModelMVC.getAllDrogue();
		if(listDrogue != null)
		{
			DefaultComboBoxModel modelDrogue = new DefaultComboBoxModel();
			for(Drogue d : listDrogue)
			{
				modelDrogue.addElement(d);
			}
					
			cDrogue.setModel(modelDrogue);
		}
		
		// init methode
		List<Methode> listMethode = ModelMVC.getAllMethode();
		if(listMethode != null)
		{
			DefaultComboBoxModel modelMethode = new DefaultComboBoxModel();
			for(Methode m : listMethode)
			{
				modelMethode.addElement(m);
			}
					
			cMethode.setModel(modelMethode);
		}*/
	}
}
