package gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

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

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.awt.Component;

import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;

public class diaAdd extends JDialog implements ICallBackMVC,ActionListener,WindowListener
{
	private JFormattedTextField tNumeroRir;
	private JFormattedTextField tDateRir;
	private JComboBox cQuartier;
	private JButton bAddQuartier;
	private JScrollPane scrollPane;
	private JList listQuartier;
	private JLabel lblNewLabel_2;
	private JPanel panelDrogue;
	private JLabel lblNewLabel_3;
	private JComboBox cDrogue;
	private JButton bAddDrogue;
	private JScrollPane scrollPane_1;
	private JList listDrogue;
	private JPanel panelMethode;
	private JLabel lblNewLabel_4;
	private JComboBox cMethode;
	private JButton bAddMethode;
	private JScrollPane scrollPane_2;
	private JList listMethode;
	private JPanel panelPersonne;
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
	private JPanel panelMtp;
	private JLabel lblMarque;
	private JLabel lblImmatriculation;
	private JLabel lblCouleur;
	private JTextField tMarque;
	private JTextField tImmatriculation;
	private JScrollPane scrollPane_4;
	private JButton bAddMtp;
	private JComboBox cCouleur;
	private JList listMtp;
	private JPanel panelContact;
	private JLabel lblNumeroDeContact;
	private JButton bAddContact;
	private JScrollPane scrollPane_5;
	private JTextField tContact;
	private JList listContact;
	public diaAdd(Frame frame,String title,boolean modal)
	{
		super(frame,title,modal);
		this.addWindowListener(this);
		getContentPane().setLayout(null);
		
		this.setSize(800, 800);
		this.setLocationRelativeTo(this);
		
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.LIGHT_GRAY);
		panelInfo.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(0, 42, 774, 75);
		getContentPane().add(panelInfo);
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
			tNumeroRir.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0)
				{
					tNumeroRir.setText("");
				}
			});
			tNumeroRir.setText(" 012345 / 2015 ");
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
			tDateRir.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) 
				{
					tDateRir.setText("");
				}
			});
			tDateRir.setText(" 01 / 01 / 2015 ");
			tDateRir.setFont(new Font("Tahoma", Font.BOLD, 12));
			tDateRir.setBounds(140, 47, 128, 17);
			panelInfo.add(tDateRir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel panelQuartier = new JPanel();
		panelQuartier.setBackground(SystemColor.control);
		panelQuartier.setBorder(new TitledBorder(null, "Quartier", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelQuartier.setBounds(0, 128, 774, 75);
		getContentPane().add(panelQuartier);
		panelQuartier.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Quartier:");
		lblNewLabel_2.setBounds(10, 27, 46, 14);
		panelQuartier.add(lblNewLabel_2);
		
		cQuartier = new JComboBox();
		cQuartier.setBounds(140, 24, 158, 20);
		panelQuartier.add(cQuartier);
		
		bAddQuartier = new JButton("Add");
		bAddQuartier.setForeground(Color.WHITE);
		bAddQuartier.setBackground(Color.BLACK);
		bAddQuartier.addActionListener(this);
		bAddQuartier.setBounds(332, 23, 89, 23);
		panelQuartier.add(bAddQuartier);
		bAddQuartier.setActionCommand("ADDQUARTIER");
		
		listQuartier = new JList();
		scrollPane = new JScrollPane(listQuartier);
		scrollPane.setBounds(482, 11, 238, 57);
		panelQuartier.add(scrollPane);
		
		panelDrogue = new JPanel();
		panelDrogue.setBorder(new TitledBorder(null, "Drogue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDrogue.setBounds(0, 214, 774, 75);
		getContentPane().add(panelDrogue);
		panelDrogue.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Drogue:");
		lblNewLabel_3.setBounds(10, 32, 117, 14);
		panelDrogue.add(lblNewLabel_3);
		
		cDrogue = new JComboBox();
		cDrogue.setBounds(140, 29, 158, 20);
		panelDrogue.add(cDrogue);
		
		bAddDrogue = new JButton("Add");
		bAddDrogue.setActionCommand("ADDDROGUE");
		bAddDrogue.setBounds(332, 23, 89, 23);
		bAddDrogue.addActionListener(this);
		panelDrogue.add(bAddDrogue);
		
		listDrogue = new JList();
		scrollPane_1 = new JScrollPane(listDrogue);
		scrollPane_1.setBounds(483, 11, 238, 57);
		panelDrogue.add(scrollPane_1);
		
		panelMethode = new JPanel();
		panelMethode.setBorder(new TitledBorder(null, "Methode", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMethode.setBounds(0, 300, 774, 75);
		getContentPane().add(panelMethode);
		panelMethode.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Methode:");
		lblNewLabel_4.setBounds(10, 31, 46, 14);
		panelMethode.add(lblNewLabel_4);
		
		cMethode = new JComboBox();
		cMethode.setBounds(140, 29, 158, 20);
		panelMethode.add(cMethode);
		
		bAddMethode = new JButton("Add");
		bAddMethode.setActionCommand("ADDMETHODE");
		bAddMethode.addActionListener(this);
		bAddMethode.setBounds(332, 23, 89, 23);
		panelMethode.add(bAddMethode);
		
		listMethode = new JList();
		scrollPane_2 = new JScrollPane(listMethode);
		scrollPane_2.setBounds(483, 11, 238, 57);
		panelMethode.add(scrollPane_2);
		
		panelPersonne = new JPanel();
		panelPersonne.setBorder(new TitledBorder(null, "Personne", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersonne.setBounds(0, 386, 774, 101);
		getContentPane().add(panelPersonne);
		panelPersonne.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Nom:");
		lblNewLabel_5.setBounds(10, 21, 46, 14);
		panelPersonne.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Prenom:");
		lblNewLabel_6.setBounds(10, 46, 46, 14);
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
		
		tDateNaissance = new JFormattedTextField();
		tDateNaissance.setBounds(140, 68, 128, 20);
		panelPersonne.add(tDateNaissance);
		
		lblNewLabel_8 = new JLabel("Surnom:");
		lblNewLabel_8.setBounds(278, 21, 48, 14);
		panelPersonne.add(lblNewLabel_8);
		
		tSurnom = new JTextField();
		tSurnom.setBounds(328, 18, 128, 20);
		panelPersonne.add(tSurnom);
		tSurnom.setColumns(10);
		
		listPersonne = new JList();
		scrollPane_3 = new JScrollPane(listPersonne);
		scrollPane_3.setBounds(484, 21, 238, 57);
		panelPersonne.add(scrollPane_3);
		
		bAddPersonne = new JButton("Add");
		bAddPersonne.setActionCommand("ADDPERSONNE");
		bAddPersonne.addActionListener(this);
		bAddPersonne.setBounds(328, 67, 89, 23);
		panelPersonne.add(bAddPersonne);
		
		panelMtp = new JPanel();
		panelMtp.setLayout(null);
		panelMtp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moyen de transport", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMtp.setBounds(0, 498, 774, 101);
		getContentPane().add(panelMtp);
		
		lblMarque = new JLabel("Marque:");
		lblMarque.setBounds(10, 21, 46, 14);
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
		scrollPane_4 = new JScrollPane(listMtp);
		scrollPane_4.setBounds(484, 21, 238, 57);
		panelMtp.add(scrollPane_4);
		
		bAddMtp = new JButton("Add");
		bAddMtp.setActionCommand("ADDMTP");
		bAddMtp.addActionListener(this);
		bAddMtp.setBounds(328, 42, 89, 23);
		panelMtp.add(bAddMtp);
		
		cCouleur = new JComboBox();
		cCouleur.setBounds(140, 68, 128, 20);
		panelMtp.add(cCouleur);
		
		panelContact = new JPanel();
		panelContact.setLayout(null);
		panelContact.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelContact.setBounds(0, 600, 774, 75);
		getContentPane().add(panelContact);
		
		lblNumeroDeContact = new JLabel("Numero de contact:");
		lblNumeroDeContact.setBounds(10, 31, 120, 14);
		panelContact.add(lblNumeroDeContact);
		
		bAddContact = new JButton("Add");
		bAddContact.setActionCommand("ADDCONTACT");
		bAddContact.addActionListener(this);
		bAddContact.setBounds(328, 23, 89, 23);
		panelContact.add(bAddContact);
		
		listContact = new JList();
		scrollPane_5 = new JScrollPane(listContact);
		scrollPane_5.setBounds(483, 11, 238, 57);
		panelContact.add(scrollPane_5);
		
		tContact = new JTextField();
		tContact.setBounds(140, 28, 133, 20);
		panelContact.add(tContact);
		tContact.setColumns(10);
		
		ToolBarRir toolBarRir = new ToolBarRir();
		toolBarRir.setBounds(0, 0, 87, 23);
		getContentPane().add(toolBarRir);
		
	
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
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
									/*
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
	
	private void init()
	{
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) 
	{
		ModelMVC.dettachMVC(this);
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
	}
}
