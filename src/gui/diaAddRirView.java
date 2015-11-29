package gui;

import java.awt.Frame;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import model.ContactSearch;
import model.Drogue;
import model.Methode;
import model.Mtp;
import model.NumeroContact;
import model.Personne;
import model.Quartier;
import model.Rir;
import model.Source;
import model.SqlLiteInterface;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.CardLayout;
import components.comboQuartiers;
import components.comboSources;
import javax.swing.ImageIcon;
import components.comboDrogues;
import components.comboMethodes;
import javax.swing.JScrollBar;
import components.comboCouleur;
import javax.swing.border.EtchedBorder;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import components.comboTypeMtp;

public class diaAddRirView extends JDialog 
{
	private JPanel m_panelRirInfo;
	private JPanel m_panelMetaData;
	private JTabbedPane m_tabbed;
	private JFormattedTextField m_tNumero;
	private JFormattedTextField m_tDateRir;
	
	// 
	private diaAddRirModel model;
	private diaAddRirControl controller;
	private JList m_listQuartier;
	private JButton m_bAddQuartier;
	private comboQuartiers m_comboQuartiers;
	private JPanel m_pDrogue;
	private comboDrogues m_comboDrogues;
	private JButton m_bAddDrogue;
	private JList m_listDrogue;
	private JPanel m_pMethode;
	private JButton m_bAddMethode;
	private JScrollPane scrollPane_2;
	private JList m_listMethode;
	private comboMethodes m_comboMethodes;
	private JPanel m_pPersonne;
	private JTextField m_tNom;
	private JTextField m_tPrenom;
	private JTextField m_tSurnom;
	private JFormattedTextField m_tDateNaissance;
	private JButton m_bAddPersonne;
	private JList m_listPersonne;
	private JPanel m_panelRirInfo02;
	private JPanel m_pMtp;
	private JLabel m_lMarque;
	private JLabel m_lImmatriculation;
	private JLabel m_lCouleur;
	private JTextField m_tMarque;
	private JTextField m_tImmatriculation;
	private JButton m_bAddMtp;
	private JScrollPane scrollPane_4;
	private JList m_listMtp;
	private comboCouleur m_cCouleurs;
	private JTextField m_tContact;
	private JButton m_bAddContact;
	private JList m_listContact;
	private JPanel m_pButton;
	private JButton m_bWriteRir;
	private JButton m_bAnnuler;
	private JPanel m_pMeta;
	private JScrollPane scrollPane_6;
	private JEditorPane m_editorMeta;
	private JPanel m_pPdf;
	private JButton m_bLoadPdf;
	private JLabel m_lPdf;
	private comboSources m_cSource;
	private File m_pdfFile;
	private comboTypeMtp m_cTypeMtp;

	public diaAddRirView(Frame arg0, String arg1, boolean arg2) throws ParseException {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
		
		this.setSize(800,640);
		this.setLocationRelativeTo(arg0);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		m_tabbed = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(m_tabbed, BorderLayout.CENTER);
		
		m_panelMetaData = new JPanel();
		m_panelMetaData.setBorder(new TitledBorder(null, "Meta Donn\u00E9es et Import Pdf", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel m_pInfo = new JPanel();
		
	
		
		m_panelRirInfo = new JPanel();
		m_panelRirInfo.setToolTipText("");
		m_tabbed.addTab("Informations (Partie 01)", null, m_panelRirInfo, null);
		m_panelRirInfo.setLayout(new BorderLayout(0, 0));
		m_panelRirInfo02 = new JPanel();
		m_tabbed.addTab("Informations (Partie 02)", null, m_panelRirInfo02, null);
		m_panelRirInfo02.setLayout(null);
		
		m_pMtp = new JPanel();
		m_pMtp.setLayout(null);
		m_pMtp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mtp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		m_pMtp.setBounds(10, 11, 759, 123);
		m_panelRirInfo02.add(m_pMtp);
		
		m_lMarque = new JLabel("Marque:");
		m_lMarque.setBounds(10, 17, 110, 14);
		m_pMtp.add(m_lMarque);
		
		m_lImmatriculation = new JLabel("Immatriculation:");
		m_lImmatriculation.setBounds(10, 42, 110, 14);
		m_pMtp.add(m_lImmatriculation);
		
		m_lCouleur = new JLabel("Couleur:");
		m_lCouleur.setBounds(10, 98, 110, 14);
		m_pMtp.add(m_lCouleur);
		
		m_tMarque = new JTextField();
		m_tMarque.setColumns(10);
		m_tMarque.setBounds(120, 14, 110, 20);
		m_pMtp.add(m_tMarque);
		
		m_tImmatriculation = new JTextField();
		m_tImmatriculation.setColumns(10);
		m_tImmatriculation.setBounds(120, 39, 110, 20);
		m_pMtp.add(m_tImmatriculation);
		
		m_bAddMtp = new JButton("");
		m_bAddMtp.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddMtp.setAlignmentX(0.5f);
		m_bAddMtp.setBounds(250, 31, 65, 50);
		m_pMtp.add(m_bAddMtp);
		
		m_listMtp = new JList();
		DefaultListModel mmtp = new DefaultListModel();
		m_listMtp.setModel(mmtp);
		scrollPane_4 = new JScrollPane(m_listMtp);
		scrollPane_4.setBounds(379, 28, 370, 50);
		m_pMtp.add(scrollPane_4);
		
		m_cCouleurs = new comboCouleur();
		m_cCouleurs.setBounds(120, 95, 110, 20);
		m_pMtp.add(m_cCouleurs);
		
		JLabel m_lType = new JLabel("Type:");
		m_lType.setBounds(10, 73, 80, 14);
		m_pMtp.add(m_lType);
		
		m_cTypeMtp = new comboTypeMtp();
		m_cTypeMtp.setBounds(120, 67, 110, 20);
		m_pMtp.add(m_cTypeMtp);
		
		JPanel m_pContact = new JPanel();
		m_pContact.setBorder(new TitledBorder(null, "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		m_pContact.setBounds(10, 145, 759, 85);
		m_panelRirInfo02.add(m_pContact);
		m_pContact.setLayout(null);
		
		m_tContact = new JTextField();
		m_tContact.setBounds(47, 35, 160, 20);
		m_pContact.add(m_tContact);
		m_tContact.setColumns(10);
		
		m_bAddContact = new JButton("");
		m_bAddContact.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddContact.setAlignmentX(0.5f);
		m_bAddContact.setBounds(250, 21, 65, 50);
		m_pContact.add(m_bAddContact);
		
		m_listContact = new JList();
		DefaultListModel mc = new DefaultListModel();
		m_listContact.setModel(mc);
		JScrollPane scrollPane_5 = new JScrollPane(m_listContact);
		scrollPane_5.setBounds(379, 21, 370, 50);
		m_pContact.add(scrollPane_5);
		
		
		m_tabbed.addTab("Données à ajouter", null, m_panelMetaData, null);
		m_panelMetaData.setLayout(new BorderLayout(0, 0));
		
		m_pMeta = new JPanel();
		m_panelMetaData.add(m_pMeta, BorderLayout.CENTER);
		m_pMeta.setLayout(new BorderLayout(0, 0));
		
		m_editorMeta = new JEditorPane();
		scrollPane_6 = new JScrollPane(m_editorMeta);
		m_pMeta.add(scrollPane_6, BorderLayout.CENTER);
		
		m_pPdf = new JPanel();
		m_pPdf.setBorder(new TitledBorder(null, "Doc Pdf", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		m_panelMetaData.add(m_pPdf, BorderLayout.SOUTH);
		GridBagLayout gbl_m_pPdf = new GridBagLayout();
		gbl_m_pPdf.columnWidths = new int[]{171, 0, 0};
		gbl_m_pPdf.rowHeights = new int[]{23, 0};
		gbl_m_pPdf.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_m_pPdf.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		m_pPdf.setLayout(gbl_m_pPdf);
		
		m_bLoadPdf = new JButton("Pdf");
		GridBagConstraints gbc_m_bLoadPdf = new GridBagConstraints();
		gbc_m_bLoadPdf.insets = new Insets(0, 0, 0, 5);
		gbc_m_bLoadPdf.fill = GridBagConstraints.BOTH;
		gbc_m_bLoadPdf.gridx = 0;
		gbc_m_bLoadPdf.gridy = 0;
		m_pPdf.add(m_bLoadPdf, gbc_m_bLoadPdf);
		
		m_lPdf = new JLabel("");
		GridBagConstraints gbc_m_lPdf = new GridBagConstraints();
		gbc_m_lPdf.gridx = 1;
		gbc_m_lPdf.gridy = 0;
		m_pPdf.add(m_lPdf, gbc_m_lPdf);
		
	
		
		m_pInfo.setBackground(Color.GRAY);
		m_pInfo.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		m_panelRirInfo.add(m_pInfo, BorderLayout.NORTH);
		GridBagLayout gbl_m_pInfo = new GridBagLayout();
		gbl_m_pInfo.columnWidths = new int[]{122, 151, 0, 0, 202, 0};
		gbl_m_pInfo.rowHeights = new int[]{0, 0, 0};
		gbl_m_pInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_m_pInfo.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		m_pInfo.setLayout(gbl_m_pInfo);
		
		JLabel m_lNumero = new JLabel("Num\u00E9ro:");
		GridBagConstraints gbc_m_lNumero = new GridBagConstraints();
		gbc_m_lNumero.anchor = GridBagConstraints.WEST;
		gbc_m_lNumero.insets = new Insets(0, 0, 5, 5);
		gbc_m_lNumero.gridx = 0;
		gbc_m_lNumero.gridy = 0;
		m_pInfo.add(m_lNumero, gbc_m_lNumero);
		
		
		m_tNumero = new JFormattedTextField(new MaskFormatter("  ######/####"));
		m_tNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_m_tNumero = new GridBagConstraints();
		gbc_m_tNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_tNumero.insets = new Insets(0, 0, 5, 5);
		gbc_m_tNumero.gridx = 1;
		gbc_m_tNumero.gridy = 0;
		m_pInfo.add(m_tNumero, gbc_m_tNumero);
		m_tNumero.setColumns(10);
		
		JLabel m_lSource = new JLabel("Source:");
		GridBagConstraints gbc_m_lSource = new GridBagConstraints();
		gbc_m_lSource.anchor = GridBagConstraints.WEST;
		gbc_m_lSource.insets = new Insets(0, 0, 5, 5);
		gbc_m_lSource.gridx = 2;
		gbc_m_lSource.gridy = 0;
		m_pInfo.add(m_lSource, gbc_m_lSource);
		
		m_cSource = new comboSources();
		GridBagConstraints gbc_m_cSource = new GridBagConstraints();
		gbc_m_cSource.insets = new Insets(0, 0, 5, 0);
		gbc_m_cSource.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_cSource.gridx = 4;
		gbc_m_cSource.gridy = 0;
		m_pInfo.add(m_cSource, gbc_m_cSource);
		
		JLabel m_lDate = new JLabel("Date:");
		GridBagConstraints gbc_m_lDate = new GridBagConstraints();
		gbc_m_lDate.anchor = GridBagConstraints.WEST;
		gbc_m_lDate.insets = new Insets(0, 0, 0, 5);
		gbc_m_lDate.gridx = 0;
		gbc_m_lDate.gridy = 1;
		m_pInfo.add(m_lDate, gbc_m_lDate);
		
		m_tDateRir = new JFormattedTextField(new MaskFormatter("  ##/##/####"));
		m_tDateRir.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_m_tDateRir = new GridBagConstraints();
		gbc_m_tDateRir.insets = new Insets(0, 0, 0, 5);
		gbc_m_tDateRir.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_tDateRir.gridx = 1;
		gbc_m_tDateRir.gridy = 1;
		m_pInfo.add(m_tDateRir, gbc_m_tDateRir);
		m_tDateRir.setColumns(10);
		
		JPanel m_pData = new JPanel();
		m_panelRirInfo.add(m_pData, BorderLayout.CENTER);
		m_pData.setLayout(null);
		
		JPanel m_pQuartier = new JPanel();
		m_pQuartier.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quartier", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		m_pQuartier.setBounds(10, 11, 759, 72);
		m_pData.add(m_pQuartier);
		m_pQuartier.setLayout(null);
		
		m_bAddQuartier = new JButton("");
		m_bAddQuartier.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddQuartier.setBounds(250, 11, 65, 50);
		m_bAddQuartier.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_pQuartier.add(m_bAddQuartier);
		
		m_listQuartier = new JList();
		DefaultListModel ml = new DefaultListModel();
		m_listQuartier.setModel(ml);
		JScrollPane scrollPane = new JScrollPane(m_listQuartier);
		scrollPane.setBounds(379, 11, 370, 50);
		m_pQuartier.add(scrollPane);
		
		m_comboQuartiers = new comboQuartiers();
		m_comboQuartiers.setBounds(10, 24, 183, 20);
		m_pQuartier.add(m_comboQuartiers);
		
		m_pDrogue = new JPanel();
		m_pDrogue.setBorder(new TitledBorder(null, "Drogue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		m_pDrogue.setBounds(10, 97, 759, 72);
		m_pData.add(m_pDrogue);
		m_pDrogue.setLayout(null);
		
		m_comboDrogues = new comboDrogues();
		m_comboDrogues.setBounds(10, 26, 183, 20);
		m_pDrogue.add(m_comboDrogues);
		
		m_bAddDrogue = new JButton("");
		m_bAddDrogue.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddDrogue.setAlignmentX(0.5f);
		m_bAddDrogue.setBounds(250, 11, 65, 50);
		m_pDrogue.add(m_bAddDrogue);
		
		m_listDrogue = new JList();
		DefaultListModel dl = new DefaultListModel();
		m_listDrogue.setModel(dl);
		JScrollPane scrollPane_1 = new JScrollPane(m_listDrogue);
		scrollPane_1.setBounds(379, 11, 370, 50);
		m_pDrogue.add(scrollPane_1);
		
		m_pMethode = new JPanel();
		m_pMethode.setLayout(null);
		m_pMethode.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Methode", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		m_pMethode.setBounds(10, 180, 759, 72);
		m_pData.add(m_pMethode);
		
		m_bAddMethode = new JButton("");
		m_bAddMethode.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddMethode.setSelectedIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddMethode.setAlignmentX(0.5f);
		m_bAddMethode.setBounds(250, 11, 65, 50);
		m_pMethode.add(m_bAddMethode);
		
		m_listMethode = new JList();
		DefaultListModel dlm = new DefaultListModel();
		m_listMethode.setModel(dlm);
		scrollPane_2 = new JScrollPane(m_listMethode);
		scrollPane_2.setBounds(379, 11, 370, 50);
		m_pMethode.add(scrollPane_2);
		
		
		m_comboMethodes = new comboMethodes();
		m_comboMethodes.setBounds(10, 27, 183, 20);
		m_pMethode.add(m_comboMethodes);
		
		m_pPersonne = new JPanel();
		m_pPersonne.setBorder(new TitledBorder(null, "Personne", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		m_pPersonne.setBounds(10, 263, 759, 123);
		m_pData.add(m_pPersonne);
		m_pPersonne.setLayout(null);
		
		JLabel m_lNom = new JLabel("Nom:");
		m_lNom.setBounds(10, 17, 110, 14);
		m_pPersonne.add(m_lNom);
		
		JLabel m_lPrenom = new JLabel("Prenom:");
		m_lPrenom.setBounds(10, 42, 110, 14);
		m_pPersonne.add(m_lPrenom);
		
		JLabel m_lSurnom = new JLabel("Surnom:");
		m_lSurnom.setBounds(10, 67, 110, 14);
		m_pPersonne.add(m_lSurnom);
		
		JLabel m_lDateNaissance = new JLabel("Date de naissance:");
		m_lDateNaissance.setBounds(10, 92, 110, 14);
		m_pPersonne.add(m_lDateNaissance);
		
		m_tNom = new JTextField();
		m_tNom.setBounds(130, 17, 110, 20);
		m_pPersonne.add(m_tNom);
		m_tNom.setColumns(10);
		
		m_tPrenom = new JTextField();
		m_tPrenom.setBounds(130, 42, 110, 20);
		m_pPersonne.add(m_tPrenom);
		m_tPrenom.setColumns(10);
		
		m_tSurnom = new JTextField();
		m_tSurnom.setBounds(130, 67, 110, 20);
		m_pPersonne.add(m_tSurnom);
		m_tSurnom.setColumns(10);
		
		m_tDateNaissance = new JFormattedTextField(new MaskFormatter(" ## / ## / ####"));
		m_tDateNaissance.setBounds(130, 95, 110, 20);
		m_pPersonne.add(m_tDateNaissance);
		m_tDateNaissance.setColumns(10);
		
		m_bAddPersonne = new JButton("");
		m_bAddPersonne.setIcon(new ImageIcon(diaAddRirView.class.getResource("/Textures/add.png")));
		m_bAddPersonne.setAlignmentX(0.5f);
		m_bAddPersonne.setBounds(250, 31, 65, 50);
		m_pPersonne.add(m_bAddPersonne);
		
		m_listPersonne = new JList();
		DefaultListModel dlp = new DefaultListModel();
		m_listPersonne.setModel(dlp);
		JScrollPane scrollPane_3 = new JScrollPane(m_listPersonne);
		scrollPane_3.setBounds(379, 28, 370, 50);
		m_pPersonne.add(scrollPane_3);
		
		m_pButton = new JPanel();
		getContentPane().add(m_pButton, BorderLayout.SOUTH);
		m_pButton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		m_bWriteRir = new JButton("Enregistrer");
		m_bWriteRir.setBackground(Color.GREEN);
		m_pButton.add(m_bWriteRir);
		
		m_bAnnuler = new JButton("Annuler");
		m_bAnnuler.setBackground(Color.CYAN);
		m_pButton.add(m_bAnnuler);
		
		
		// model
		try
		{
			model = new diaAddRirModel();
			controller = new diaAddRirControl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public comboTypeMtp getM_cTypeMtp() {
		return m_cTypeMtp;
	}

	public JTextField getM_tDateRir() {
		return m_tDateRir;
	}


	public comboSources getM_cSource() {
		return m_cSource;
	}


	public JButton getM_bWriteRir() {
		return m_bWriteRir;
	}




	public JButton getM_bAnnuler() {
		return m_bAnnuler;
	}




	public JEditorPane getM_editorMeta() {
		return m_editorMeta;
	}




	public JButton getM_bLoadPdf() {
		return m_bLoadPdf;
	}




	public JLabel getM_lPdf() {
		return m_lPdf;
	}




	public JTextField getM_tContact() {
		return m_tContact;
	}




	public JButton getM_bAddContact() {
		return m_bAddContact;
	}




	public JList getM_listContact() {
		return m_listContact;
	}




	public JList getM_listMtp() {
		return m_listMtp;
	}




	public comboCouleur getM_cCouleurs() {
		return m_cCouleurs;
	}




	public JTextField getM_tDateNaissance() {
		return m_tDateNaissance;
	}



	public JTextField getM_tNumero() {
		return m_tNumero;
	}



	public JTextField getM_tNom() {
		return m_tNom;
	}



	public JTextField getM_tPrenom() {
		return m_tPrenom;
	}



	public JTextField getM_tSurnom() {
		return m_tSurnom;
	}



	public JButton getM_bAddPersonne() {
		return m_bAddPersonne;
	}



	public JList getM_listMethode() {
		return m_listMethode;
	}



	public comboMethodes getM_comboMethodes() {
		return m_comboMethodes;
	}



	public JButton getM_bAddMethode() {
		return m_bAddMethode;
	}



	public JButton getM_bAddQuartier() {
		return m_bAddQuartier;
	}



	public JList getM_listQuartier() {
		return m_listQuartier;
	}



	public comboDrogues getM_comboDrogues() {
		return m_comboDrogues;
	}



	public comboQuartiers getM_comboQuartiers() {
		return m_comboQuartiers;
	}



	public JButton getM_bAddDrogue() {
		return m_bAddDrogue;
	}



	public JList getM_listDrogue() {
		return m_listDrogue;
	}



	public JList getM_listPersonne() {
		return m_listPersonne;
	}



	public JButton getM_bAddMtp() {
		return m_bAddMtp;
	}



	public JTextField getM_tMarque() {
		return m_tMarque;
	}




	public JTextField getM_tImmatriculation() {
		return m_tImmatriculation;
	}



	public class diaAddRirControl implements ActionListener,KeyListener,FocusListener
	{

		public diaAddRirControl() 
		{
			super();
			// action listener
			diaAddRirView.this.getM_bAddQuartier().addActionListener(this);
			diaAddRirView.this.getM_listQuartier().addKeyListener(this);
			diaAddRirView.this.getM_bAddDrogue().addActionListener(this);
			diaAddRirView.this.getM_listDrogue().addKeyListener(this);
			diaAddRirView.this.getM_bAddMethode().addActionListener(this);
			diaAddRirView.this.getM_listMethode().addKeyListener(this);
			diaAddRirView.this.getM_bAddPersonne().addActionListener(this);
			diaAddRirView.this.getM_listPersonne().addKeyListener(this);
			diaAddRirView.this.getM_bAddMtp().addActionListener(this);
			diaAddRirView.this.getM_listMtp().addKeyListener(this);
			diaAddRirView.this.getM_bAddContact().addActionListener(this);
			diaAddRirView.this.getM_listContact().addKeyListener(this);
			diaAddRirView.this.getM_bLoadPdf().addActionListener(this);
			diaAddRirView.this.getM_bWriteRir().addActionListener(this);
			diaAddRirView.this.getM_bAnnuler().addActionListener(this);
			// 
			diaAddRirView.this.getM_tDateRir().addFocusListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(arg0.getSource() == diaAddRirView.this.getM_bAddQuartier())
			{
				Quartier quartier = new Quartier();
				quartier.setNom(diaAddRirView.this.getM_comboQuartiers().getSelectedItem().toString());
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listQuartier().getModel();
				ml.addElement(quartier);
			}
			
			// drogues
			if(arg0.getSource() == diaAddRirView.this.getM_bAddDrogue())
			{
				Drogue drogue = new Drogue();
				drogue.setType(diaAddRirView.this.getM_comboDrogues().getSelectedItem().toString());
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listDrogue().getModel();
				ml.addElement(drogue);
			}
			// methodes
			if(arg0.getSource() == diaAddRirView.this.getM_bAddMethode())
			{
				Methode methode = new Methode();
				methode.setMethode(diaAddRirView.this.getM_comboMethodes().getSelectedItem().toString());
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listMethode().getModel();
				ml.addElement(methode);
			}
			
			// Personnes
			if(arg0.getSource() == diaAddRirView.this.getM_bAddPersonne())
			{
				
				Personne pers = new Personne();
				pers.setNom(diaAddRirView.this.getM_tNom().getText());
				pers.setPrenom(diaAddRirView.this.getM_tPrenom().getText());
				pers.setDateNaissance(diaAddRirView.this.getM_tDateNaissance().getText());
				pers.setSurnom(diaAddRirView.this.getM_tSurnom().getText());
				((DefaultListModel)diaAddRirView.this.getM_listPersonne().getModel()).addElement(pers);
				// clear des éléments
				diaAddRirView.this.getM_tNom().setText("");
				diaAddRirView.this.getM_tPrenom().setText("");
				diaAddRirView.this.getM_tSurnom().setText("");
				diaAddRirView.this.getM_tDateNaissance().setText("");
				
			}
			// Mtp
			if(arg0.getSource() == diaAddRirView.this.getM_bAddMtp())
			{
				Mtp mtp = new Mtp();
				mtp.setMarque(diaAddRirView.this.getM_tMarque().getText());
				mtp.setImmatriculation(diaAddRirView.this.getM_tImmatriculation().getText());
				mtp.setCouleur(diaAddRirView.this.getM_cCouleurs().getSelectedItem().toString());
				mtp.setType(diaAddRirView.this.getM_cTypeMtp().getSelectedItem().toString());
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listMtp().getModel();
				ml.addElement(mtp);
				//clear des éléments
				diaAddRirView.this.getM_tMarque().setText("");
				diaAddRirView.this.getM_tImmatriculation().setText("");
				diaAddRirView.this.getM_cCouleurs().setSelectedIndex(0);
				diaAddRirView.this.getM_cTypeMtp().setSelectedIndex(0);
				
			}
			// Contacts
			if(arg0.getSource() == diaAddRirView.this.getM_bAddContact())
			{
				NumeroContact contact = new NumeroContact();
				contact.setNumero(diaAddRirView.this.getM_tContact().getText());
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listContact().getModel();
				ml.addElement(contact);
				//clear des éléments
				diaAddRirView.this.getM_tContact().setText("");
				
				
			}
			
			// Load pdf
			if(arg0.getSource() == diaAddRirView.this.getM_bLoadPdf())
			{
				// filtre des fichiers pouvant être choisi
				FileFilter fileFilter = new FileNameExtensionFilter("Document Pdf du RIR","pdf");
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(fileFilter);
				int ret = fc.showOpenDialog(null);
				if(ret == JFileChooser.APPROVE_OPTION)
				{
					m_pdfFile = fc.getSelectedFile();
					if(m_pdfFile != null)
					{
						diaAddRirView.this.getM_lPdf().setText(m_pdfFile.getAbsolutePath());
					}
				}
				
				
			}
			// Annuler
			if(arg0.getSource() == diaAddRirView.this.getM_bAnnuler())
			{
				diaAddRirView.this.setVisible(false);
			}
			
			// Enregistrement RIR
			if(arg0.getSource() == diaAddRirView.this.getM_bWriteRir())
			{
				Rir rir = new Rir();
				rir.setNumero(diaAddRirView.this.getM_tNumero().getText());
				
				// date
				String stringDate = diaAddRirView.this.getM_tDateRir().getText();
				String[] splitDate = stringDate.trim().split("/");
				if(splitDate.length == 3)
				{
					Calendar cal = Calendar.getInstance();
					int year = Integer.parseInt(splitDate[2]);
					int month = Integer.parseInt(splitDate[1]) - 1;
					int day = Integer.parseInt(splitDate[0]);
					cal.set(year,month,day);
					java.sql.Date d = new java.sql.Date(cal.getTimeInMillis());
					rir.setDateRir(d);
					
				}
				
				// source
				rir.setSource(diaAddRirView.this.getM_cSource().getSelectedItem().toString()); 
				// Quartiers
				Object[] quartiers =  ((DefaultListModel)diaAddRirView.this.getM_listQuartier().getModel()).toArray();
				List lq = Arrays.asList(quartiers);
				rir.setListQuartier(lq);
				// Drogues
				Object[] drogues =  ((DefaultListModel)diaAddRirView.this.getM_listDrogue().getModel()).toArray();
				List ld = Arrays.asList(drogues);
				rir.setListDrogue(ld);
				// Methodes
				Object[] methodes =  ((DefaultListModel)diaAddRirView.this.getM_listMethode().getModel()).toArray();
				List lm = Arrays.asList(methodes);
				rir.setListMethode(lm);
				// Personnes
				Object[] personnes =  ((DefaultListModel)diaAddRirView.this.getM_listPersonne().getModel()).toArray();
				List lp = Arrays.asList(personnes);
				rir.setListPersonne(lp);
				// Mtp
				Object[] mtp =  ((DefaultListModel)diaAddRirView.this.getM_listMtp().getModel()).toArray();
				List lmtp = Arrays.asList(mtp);
				rir.setListMtp(lmtp);
				// Contact
				Object[] contact =  ((DefaultListModel)diaAddRirView.this.getM_listContact().getModel()).toArray();
				List lc = Arrays.asList(contact);
				rir.setListNumeroContact(lc);
				
				// meta data
				rir.setNature(diaAddRirView.this.getM_editorMeta().getText());
				if(m_pdfFile != null)
				{
					
				//FileInputStream fis = new FileInputStream(m_pdfFile);
				rir.setPathFile(m_pdfFile.getAbsolutePath());
					
				}
				
				// write Rir
				SqlLiteInterface.insertRir(rir);
				diaAddRirView.this.setVisible(false);
				
			}
			
		
			
			
		}

		

		private NumeroContact NumeroContact() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void keyPressed(KeyEvent arg0)
		{
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
				if(arg0.getSource() == diaAddRirView.this.getM_listQuartier())
				{
					int ind = diaAddRirView.this.getM_listQuartier().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listQuartier().getModel()).remove(ind);
					
				}
				
				// Drogues
				if(arg0.getSource() == diaAddRirView.this.getM_listDrogue())
				{
					int ind = diaAddRirView.this.getM_listDrogue().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listDrogue().getModel()).remove(ind);
					
				}
				
				//Methodes
				if(arg0.getSource() == diaAddRirView.this.getM_listMethode())
				{
					int ind = diaAddRirView.this.getM_listMethode().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listMethode().getModel()).remove(ind);
					
				}
				
				// Personnes
				if(arg0.getSource() == diaAddRirView.this.getM_listPersonne())
				{
					int ind = diaAddRirView.this.getM_listPersonne().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listPersonne().getModel()).remove(ind);
					
				}
				// Mtp
				if(arg0.getSource() == diaAddRirView.this.getM_listMtp())
				{
					int ind = diaAddRirView.this.getM_listMtp().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listMtp().getModel()).remove(ind);
					
				}
				// Contacts
				if(arg0.getSource() == diaAddRirView.this.getM_listContact())
				{
					int ind = diaAddRirView.this.getM_listContact().getSelectedIndex();
					if(ind != -1)
						((DefaultListModel)diaAddRirView.this.getM_listContact().getModel()).remove(ind);
					
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

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) 
		{
			if(e.getSource() == diaAddRirView.this.getM_tDateRir() && !diaAddRirView.this.getM_bAnnuler().isSelected())
			{
				// lost focus sur la date, vérification de l'intégrité de la date
				String stringDate = diaAddRirView.this.getM_tDateRir().getText();
				String[] splitDate = stringDate.trim().split("/");
				if(splitDate != null && splitDate.length == 3)
				{
					try
					{
						Calendar c = Calendar.getInstance();
						c.setLenient(false);
						int year = Integer.valueOf(splitDate[2]);
						int month = Integer.valueOf(splitDate[1]) - 1;
						int day = Integer.valueOf(splitDate[0]);
						c.set(year, month, day);
						c.getTime();
					}
					catch(IllegalArgumentException ee)
					{
						JOptionPane.showMessageDialog(null, "Date du rir incorrecte (1)");
						diaAddRirView.this.getM_tDateRir().setText("");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Date du rir incorrecte (2)");
					diaAddRirView.this.getM_tDateRir().setText("");
				}
			}
			
		}
		
	}


	public class diaAddRirModel
	{
	
		public diaAddRirModel() throws ClassNotFoundException, SQLException 
		{
			
			
		}
		
		public void test()
		{
			
		}
		
	}
}
