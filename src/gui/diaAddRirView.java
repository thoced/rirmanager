package gui;

import java.awt.Frame;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Personne;
import model.Quartier;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class diaAddRirView extends JDialog 
{
	private JPanel m_panelRirInfo;
	private JPanel m_panelData;
	private JTabbedPane m_tabbed;
	private JTextField m_tNumero;
	private JTextField textField;
	
	// 
	private diaAddRirModel model;
	private diaAddRirControl controller;
	private JList m_listQuartier;
	private JButton m_bAddQuartier;
	private JButton m_bAjoutRir;
	private JButton m_bCancel;
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
	private JTextField m_tDateNaissance;
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

	public diaAddRirView(Frame arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
		
		this.setSize(800,640);
		this.setLocationRelativeTo(arg0);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		m_tabbed = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(m_tabbed, BorderLayout.CENTER);
		
		m_panelData = new JPanel();
		
		JPanel m_pInfo = new JPanel();
		
	
		
		m_panelRirInfo = new JPanel();
		m_panelRirInfo.setToolTipText("");
		m_tabbed.addTab("Informations (Parte 01)", null, m_panelRirInfo, null);
		m_panelRirInfo.setLayout(new BorderLayout(0, 0));
		m_panelRirInfo02 = new JPanel();
		m_tabbed.addTab("Informations (Parte 02)", null, m_panelRirInfo02, null);
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
		m_lCouleur.setBounds(10, 67, 110, 14);
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
		
		scrollPane_4 = new JScrollPane((Component) null);
		scrollPane_4.setBounds(379, 28, 370, 50);
		m_pMtp.add(scrollPane_4);
		
		comboCouleur comboCouleur_ = new comboCouleur();
		comboCouleur_.setBounds(120, 67, 110, 20);
		m_pMtp.add(comboCouleur_);
		
		
		m_tabbed.addTab("Données à ajouter", null, m_panelData, null);
		
	
		
		
		
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
		
		m_tNumero = new JTextField();
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
		
		comboSources comboSources_ = new comboSources();
		GridBagConstraints gbc_comboSources_ = new GridBagConstraints();
		gbc_comboSources_.insets = new Insets(0, 0, 5, 0);
		gbc_comboSources_.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSources_.gridx = 4;
		gbc_comboSources_.gridy = 0;
		m_pInfo.add(comboSources_, gbc_comboSources_);
		
		JLabel m_lDate = new JLabel("Date:");
		GridBagConstraints gbc_m_lDate = new GridBagConstraints();
		gbc_m_lDate.anchor = GridBagConstraints.WEST;
		gbc_m_lDate.insets = new Insets(0, 0, 0, 5);
		gbc_m_lDate.gridx = 0;
		gbc_m_lDate.gridy = 1;
		m_pInfo.add(m_lDate, gbc_m_lDate);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		m_pInfo.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel m_pButton = new JPanel();
		m_pButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		m_panelRirInfo.add(m_pButton, BorderLayout.SOUTH);
		m_pButton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		m_bCancel = new JButton("Annuler");
		m_bCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		m_pButton.add(m_bCancel);
		
		m_bAjoutRir = new JButton("Ajouter le Rir");
		m_pButton.add(m_bAjoutRir);
		
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
		m_tNom.setBounds(120, 14, 110, 20);
		m_pPersonne.add(m_tNom);
		m_tNom.setColumns(10);
		
		m_tPrenom = new JTextField();
		m_tPrenom.setBounds(120, 39, 110, 20);
		m_pPersonne.add(m_tPrenom);
		m_tPrenom.setColumns(10);
		
		m_tSurnom = new JTextField();
		m_tSurnom.setBounds(120, 64, 110, 20);
		m_pPersonne.add(m_tSurnom);
		m_tSurnom.setColumns(10);
		
		m_tDateNaissance = new JTextField();
		m_tDateNaissance.setBounds(120, 92, 110, 20);
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



	public class diaAddRirControl implements ActionListener,KeyListener
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
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(arg0.getSource() == diaAddRirView.this.getM_bAddQuartier())
			{
				Object obj = diaAddRirView.this.getM_comboQuartiers().getSelectedItem();
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listQuartier().getModel();
				ml.addElement(obj);
			}
			
			// drogues
			if(arg0.getSource() == diaAddRirView.this.getM_bAddDrogue())
			{
				Object obj = diaAddRirView.this.getM_comboDrogues().getSelectedItem();
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listDrogue().getModel();
				ml.addElement(obj);
			}
			// methodes
			if(arg0.getSource() == diaAddRirView.this.getM_bAddMethode())
			{
				Object obj = diaAddRirView.this.getM_comboMethodes().getSelectedItem();
				DefaultListModel ml =  (DefaultListModel) diaAddRirView.this.getM_listMethode().getModel();
				ml.addElement(obj);
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
