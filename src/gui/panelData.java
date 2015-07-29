package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import model.Couleur;
import model.Drogue;
import model.ICallBackMVC;
import model.Methode;
import model.ModelMVC;
import model.Mtp;
import model.NumeroContact;
import model.Personne;
import model.Quartier;
import model.Rir;
import model.Source;

import javax.swing.ImageIcon;

public class panelData extends panelBase  implements ICallBackMVC,ActionListener,KeyListener
{
	private JFormattedTextField tNumeroRir;
	private JFormattedTextField tDateRir;
	private JComboBox cQuartier;
	private JButton bAddQuartier;
	private JScrollPane scrollPane;
	private JList listQuartier;
	private JLabel lblNewLabel_2;
	private panelBase panelDrogue;
	private JLabel lblNewLabel_3;
	private JComboBox cDrogue;
	private JButton bAddDrogue;
	private JScrollPane scrollPane_1;
	private JList listDrogue;
	private panelBase panelMethode;
	private JLabel lblNewLabel_4;
	private JComboBox cMethode;
	private JButton bAddMethode;
	private JScrollPane scrollPane_2;
	private JList listMethode;
	private panelBase panelPersonne;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField tNomPersonne;
	private JTextField tPrenomPersonne;
	private JFormattedTextField tDateNaissance;
	private JLabel lblNewLabel_8;
	private JTextField tSurnom;
	private JScrollPane scrollPane_3;
	private JList listPersonne;
	private JButton bAddPersonne;
	private panelBase panelMtp;
	private JLabel lblMarque;
	private JLabel lblImmatriculation;
	private JLabel lblCouleur;
	private JTextField tMarque;
	private JTextField tImmatriculation;
	private JScrollPane scrollPane_4;
	private JButton bAddMtp;
	private JComboBox cCouleur;
	private JList listMtp;
	private panelBase panelContact;
	private JLabel lblNumeroDeContact;
	private JButton bAddContact;
	private JScrollPane scrollPane_5;
	private JTextField tContact;
	private JList listContact;
	private JComboBox cSource;
	
	
	
	public JFormattedTextField gettDateRir() {
		return tDateRir;
	}

	public panelData()
	{
		
		
		setLayout(null);
		
		this.setSize(800, 800);
	
		
		panelBase panelInfo = new panelBase();
		panelInfo.setBackground(Color.LIGHT_GRAY);
		panelInfo.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(0, 42, 774, 75);
		add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num\u00E9ro RIR:");
		lblNewLabel.setBounds(10, 22, 120, 14);
		panelInfo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(10, 50, 85, 14);
		panelInfo.add(lblNewLabel_1);
		
		
		try {
			MaskFormatter maskNumeroRir;
			maskNumeroRir = new MaskFormatter(" ###### / #### ");
			tNumeroRir = new JFormattedTextField(maskNumeroRir);
			tNumeroRir.setFont(new Font("Tahoma", Font.BOLD, 12));
			tNumeroRir.setBounds(140, 19, 128, 17);
			panelInfo.add(tNumeroRir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			MaskFormatter maskDateRir;
			maskDateRir = new MaskFormatter(" ## / ## / #### ");
			tDateRir = new JFormattedTextField(maskDateRir);
			tDateRir.setFont(new Font("Tahoma", Font.BOLD, 12));
			tDateRir.setBounds(140, 47, 128, 17);
			panelInfo.add(tDateRir);
			
			JLabel lblNewLabel_9 = new JLabel("R\u00E9dacteur:");
			lblNewLabel_9.setBounds(278, 22, 90, 14);
			panelInfo.add(lblNewLabel_9);
			
			cSource = new JComboBox();
			cSource.setBounds(378, 19, 158, 20);
			panelInfo.add(cSource);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		panelBase panelQuartier = new panelBase();
		panelQuartier.setBackground(SystemColor.control);
		panelQuartier.setBorder(new TitledBorder(null, "Quartier", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelQuartier.setBounds(0, 128, 774, 75);
		add(panelQuartier);
		panelQuartier.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Quartier:");
		lblNewLabel_2.setBounds(10, 27, 120, 14);
		panelQuartier.add(lblNewLabel_2);
		
		cQuartier = new JComboBox();
		cQuartier.setBounds(140, 24, 158, 20);
		panelQuartier.add(cQuartier);
		
		bAddQuartier = new JButton();
		bAddQuartier.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddQuartier.addActionListener(this);
		bAddQuartier.setBounds(368, 24, 32, 32);
		panelQuartier.add(bAddQuartier);
		bAddQuartier.setActionCommand("ADDQUARTIER");
		
		DefaultListModel mQuartier = new DefaultListModel();
		listQuartier = new JList(mQuartier);
		listQuartier.addKeyListener(this);
		scrollPane = new JScrollPane(listQuartier);
		scrollPane.setBounds(482, 11, 238, 57);
		panelQuartier.add(scrollPane);
		
		panelDrogue =  new panelBase();
		panelDrogue.setBorder(new TitledBorder(null, "Drogue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDrogue.setBounds(0, 214, 774, 75);
		add(panelDrogue);
		panelDrogue.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Drogue:");
		lblNewLabel_3.setBounds(10, 32, 117, 14);
		panelDrogue.add(lblNewLabel_3);
		
		cDrogue = new JComboBox();
		cDrogue.setBounds(140, 29, 158, 20);
		panelDrogue.add(cDrogue);
		
		bAddDrogue = new JButton("");
		bAddDrogue.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddDrogue.setActionCommand("ADDDROGUE");
		bAddDrogue.setBounds(368, 24, 32, 32);
		bAddDrogue.addActionListener(this);
		panelDrogue.add(bAddDrogue);
		
		listDrogue = new JList();
		listDrogue.addKeyListener(this);
		scrollPane_1 = new JScrollPane(listDrogue);
		scrollPane_1.setBounds(483, 11, 238, 57);
		panelDrogue.add(scrollPane_1);
		
		panelMethode =  new panelBase();
		panelMethode.setBorder(new TitledBorder(null, "Methode", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMethode.setBounds(0, 300, 774, 75);
		add(panelMethode);
		panelMethode.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Methode:");
		lblNewLabel_4.setBounds(10, 31, 120, 14);
		panelMethode.add(lblNewLabel_4);
		
		cMethode = new JComboBox();
		cMethode.setBounds(140, 29, 158, 20);
		panelMethode.add(cMethode);
		
		bAddMethode = new JButton("");
		bAddMethode.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddMethode.setActionCommand("ADDMETHODE");
		bAddMethode.addActionListener(this);
		bAddMethode.setBounds(368, 24, 32, 32);
		panelMethode.add(bAddMethode);
		
		
		listMethode = new JList();
		listMethode.addKeyListener(this);
		scrollPane_2 = new JScrollPane(listMethode);
		scrollPane_2.setBounds(483, 11, 238, 57);
		panelMethode.add(scrollPane_2);
		
		panelPersonne =  new panelBase();
		panelPersonne.setBorder(new TitledBorder(null, "Personne", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersonne.setBounds(0, 386, 774, 101);
		add(panelPersonne);
		panelPersonne.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Nom:");
		lblNewLabel_5.setBounds(10, 21, 120, 14);
		panelPersonne.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Prenom:");
		lblNewLabel_6.setBounds(10, 46, 120, 14);
		panelPersonne.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Date de naissance:");
		lblNewLabel_7.setBounds(10, 71, 127, 14);
		panelPersonne.add(lblNewLabel_7);
		
		tNomPersonne = new JTextField();
		tNomPersonne.setBounds(140, 18, 128, 20);
		panelPersonne.add(tNomPersonne);
		tNomPersonne.setColumns(10);
		
		tPrenomPersonne = new JTextField();
		tPrenomPersonne.setBounds(140, 43, 128, 20);
		panelPersonne.add(tPrenomPersonne);
		tPrenomPersonne.setColumns(10);
		
		try {
			MaskFormatter maskDateNaissance = new MaskFormatter(" ## / ## / #### ");
			tDateNaissance = new JFormattedTextField(maskDateNaissance);
			tDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tDateNaissance.setBounds(140, 68, 128, 20);
			panelPersonne.add(tDateNaissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		lblNewLabel_8 = new JLabel("Surnom:");
		lblNewLabel_8.setBounds(278, 21, 48, 14);
		panelPersonne.add(lblNewLabel_8);
		
		tSurnom = new JTextField();
		tSurnom.setBounds(328, 18, 128, 20);
		panelPersonne.add(tSurnom);
		tSurnom.setColumns(10);
		
		listPersonne = new JList();
		listPersonne.addKeyListener(this);
		scrollPane_3 = new JScrollPane(listPersonne);
		scrollPane_3.setBounds(484, 21, 238, 57);
		panelPersonne.add(scrollPane_3);
		
		bAddPersonne = new JButton("");
		bAddPersonne.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddPersonne.setActionCommand("ADDPERSONNE");
		bAddPersonne.addActionListener(this);
		bAddPersonne.setBounds(368, 53, 32, 32);
		panelPersonne.add(bAddPersonne);
		
		panelMtp =  new panelBase();
		panelMtp.setLayout(null);
		panelMtp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moyen de transport", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMtp.setBounds(0, 498, 774, 101);
		add(panelMtp);
		
		lblMarque = new JLabel("Marque:");
		lblMarque.setBounds(10, 21, 120, 14);
		panelMtp.add(lblMarque);
		
		lblImmatriculation = new JLabel("Immatriculation:");
		lblImmatriculation.setBounds(10, 46, 127, 14);
		panelMtp.add(lblImmatriculation);
		
		lblCouleur = new JLabel("Couleur:");
		lblCouleur.setBounds(10, 71, 127, 14);
		panelMtp.add(lblCouleur);
		
		tMarque = new JTextField();
		tMarque.setColumns(10);
		tMarque.setBounds(140, 18, 128, 20);
		panelMtp.add(tMarque);
		
		tImmatriculation = new JTextField();
		tImmatriculation.setColumns(10);
		tImmatriculation.setBounds(140, 43, 128, 20);
		panelMtp.add(tImmatriculation);
		
		
		listMtp = new JList();
		listMtp.addKeyListener(this);
		scrollPane_4 = new JScrollPane(listMtp);
		scrollPane_4.setBounds(484, 21, 238, 57);
		panelMtp.add(scrollPane_4);
		
		bAddMtp = new JButton("");
		bAddMtp.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddMtp.setActionCommand("ADDMTP");
		bAddMtp.addActionListener(this);
		bAddMtp.setBounds(368, 24, 32, 32);
		panelMtp.add(bAddMtp);
		
		cCouleur = new JComboBox();
		cCouleur.setBounds(140, 68, 128, 20);
		panelMtp.add(cCouleur);
		
		panelContact =  new panelBase();
		panelContact.setLayout(null);
		panelContact.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelContact.setBounds(0, 600, 774, 75);
		add(panelContact);
		
		lblNumeroDeContact = new JLabel("Numero de contact:");
		lblNumeroDeContact.setBounds(10, 31, 120, 14);
		panelContact.add(lblNumeroDeContact);
		
		bAddContact = new JButton("");
		bAddContact.setIcon(new ImageIcon(panelData.class.getResource("/Textures/add.png")));
		bAddContact.setActionCommand("ADDCONTACT");
		bAddContact.addActionListener(this);
		bAddContact.setBounds(368, 24, 32, 32);
		panelContact.add(bAddContact);
		
		
		listContact = new JList();
		listContact.addKeyListener(this);
		scrollPane_5 = new JScrollPane(listContact);
		scrollPane_5.setBounds(483, 11, 238, 57);
		panelContact.add(scrollPane_5);
		
		tContact = new JTextField();
		tContact.setBounds(140, 28, 133, 20);
		panelContact.add(tContact);
		tContact.setColumns(10);
	
		// initi
		this.init();
	
		ModelMVC.newRir();
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
			
				
				// update des drogues
				DefaultListModel modelDrogue = new DefaultListModel();
				for(Drogue d : rir.getListDrogue())
				{
					modelDrogue.addElement(d);
				}
				// on ajoute dans la listQuartiers
				listDrogue.setModel(modelDrogue);
				
				// update des methodes
				DefaultListModel modelMethode = new DefaultListModel();
				for(Methode m : rir.getListMethode())
				{
					modelMethode.addElement(m);
				}
				// on ajoute dans la listQuartiers
				listMethode.setModel(modelMethode);		
				
				
				// update des personnes
				DefaultListModel modelPersonne = new DefaultListModel();
				for(Personne p : rir.getListPersonne())
				{
					modelPersonne.addElement(p);
				}
				// on ajoute dans la listQuartiers
				listPersonne.setModel(modelPersonne);
				
				// update des Mtp
				DefaultListModel modelMtp = new DefaultListModel();
				for(Mtp p : rir.getListMtp())
				{
					modelMtp.addElement(p);
				}
				// on ajoute dans la listQuartiers
				listMtp.setModel(modelMtp);		
				
				// update des numero contact
				DefaultListModel modelContact = new DefaultListModel();
				for(NumeroContact m : rir.getListNumeroContact())
				{
					modelContact.addElement(m);
				}
				// on ajoute dans la listQuartiers
				listContact.setModel(modelContact);
				/*
				// update des methodes
				DefaultListModel modelMethode = new DefaultListModel();
				for(Methode m : rir.getListMethode())
				{
					modelMethode.addElement(m);
				}
				// on ajoute dans la listQuartiers
				listMethode.setModel(modelMethode);		
				
						*/
		
	}
	
	private void init()
	{
		// attachement MVC
				ModelMVC.attachMVC(this);
				
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
						}
						// init couleur
						List<Couleur> listCouleur = ModelMVC.getAllCouleur();
						if(listCouleur != null)
						{
							DefaultComboBoxModel modelCouleur = new DefaultComboBoxModel();
							for(Couleur m : listCouleur)
							{
								modelCouleur.addElement(m);
							}
									
							cCouleur.setModel(modelCouleur);
						}
					
						// init source
						List<Source> listSource = ModelMVC.getAllSource();
						if(listSource != null)
						{
							DefaultComboBoxModel modelSource = new DefaultComboBoxModel();
							for(Source m : listSource)
							{
								modelSource.addElement(m);
							}
									
							cSource.setModel(modelSource);
						}
						
	}




	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "ADDQUARTIER" :  	Quartier quartier = new Quartier();
									quartier.setNom(cQuartier.getSelectedItem().toString());
									ModelMVC.insertQuartier(quartier);
									cQuartier.setSelectedIndex(0);
									break;
								
							
			case "ADDDROGUE" :     	Drogue drogue = new Drogue();
									drogue.setType(cDrogue.getSelectedItem().toString());
									ModelMVC.insertDrogue(drogue);
									cDrogue.setSelectedIndex(0);
									break;
									
			case "ADDMETHODE":		Methode methode = new Methode();
									methode.setMethode(cMethode.getSelectedItem().toString().trim());
									ModelMVC.insertMethode(methode);
									cMethode.setSelectedIndex(0);
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
									
			
									
			case "ADDMTP" :			Mtp mtp = new Mtp();
									mtp.setMarque(tMarque.getText());
									mtp.setImmatriculation(tImmatriculation.getText());
									mtp.setCouleur(cCouleur.getSelectedItem().toString());
									ModelMVC.insertMtp(mtp);
									tMarque.setText("");
									tImmatriculation.setText("");
									cCouleur.setSelectedIndex(0);
									break;
									
			case "ADDCONTACT": 		NumeroContact numero = new NumeroContact();
									numero.setNumero(tContact.getText().trim());
									ModelMVC.insertNumeroContact(numero);
									tContact.setText("");
									break;
									
			
		}
		
	}


	@Override
	public void saveModel() 
	{
		ModelMVC.insertNumero(tNumeroRir.getText());
		ModelMVC.insertSource(cSource.getSelectedItem().toString());
		
		String[] stringDate = tDateRir.getText().trim().split("/");
		if(stringDate != null && stringDate.length == 3)
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
				
		}
		
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		if(!enabled)
		{
			tNumeroRir.setText("");
			tDateRir.setText("");
			
		
		}
		super.setEnabled(enabled);
		
	
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if(arg0.getSource() == listQuartier)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removeQuartier(listQuartier.getSelectedIndex());
			}
		}
		
		if(arg0.getSource() == listDrogue)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removeDrogue(listDrogue.getSelectedIndex());
			}
		}
		
		if(arg0.getSource() == listMethode)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removeMethode(listMethode.getSelectedIndex());
			}
		}
		
		if(arg0.getSource() == listMtp)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removeMtp(listMtp.getSelectedIndex());
			}
		}
		
		if(arg0.getSource() == listContact)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removeContact(listContact.getSelectedIndex());
			}
		}
		
		if(arg0.getSource() == listPersonne)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				ModelMVC.removePersonne(listPersonne.getSelectedIndex());
			}
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
