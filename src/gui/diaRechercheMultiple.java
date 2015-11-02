package gui;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import components.comboQuartiers;
import javafx.collections.SetChangeListener;
import model.Drogue;
import model.Methode;
import model.Quartier;
import model.SqlLiteInterface;

import java.awt.GridBagConstraints;
import components.comboDrogues;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import components.comboMethodes;
import components.comboCouleur;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import components.listQuartiers;
import guiListRIR.CtrlListRir;
import components.listDrogues;
import components.listMethodes;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class diaRechercheMultiple extends JDialog
{
	private diaRechercheMultipleControl controller;
	private diaRechercheMultipleModel model;
	private JButton m_bRecherche;
	private JButton m_bAnnuler;
	private JPanel m_pButton;
	private JPanel m_pRecherche;
	private listQuartiers listQuartiers;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private listDrogues listDrogues;
	private listMethodes listMethodes;
	private JScrollPane scrollPane_3;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton m_bClear;
	private JEditorPane dtrpnCrerVotre;
	
	
	
	public diaRechercheMultiple(Frame arg0, String arg1, boolean arg2)
	{
		super(arg0, arg1, arg2);
	
		this.setSize(600, 400);
		this.setLocationRelativeTo(arg0);
		
		m_pRecherche = new JPanel();
		m_pRecherche.setBorder(new TitledBorder(null, "Recherche crois\u00E9e", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(m_pRecherche, BorderLayout.CENTER);
		GridBagLayout gbl_m_pRecherche = new GridBagLayout();
		gbl_m_pRecherche.columnWidths = new int[]{200, 345, 0, 0};
		gbl_m_pRecherche.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_m_pRecherche.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_m_pRecherche.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		m_pRecherche.setLayout(gbl_m_pRecherche);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Quartiers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		m_pRecherche.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		listQuartiers = new listQuartiers();
		scrollPane_1 = new JScrollPane(listQuartiers);
		panel.add(scrollPane_1);
		
		dtrpnCrerVotre = new JEditorPane();
		dtrpnCrerVotre.setBackground(new Color(240,240,240));
		dtrpnCrerVotre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnCrerVotre.setEditable(false);
		dtrpnCrerVotre.setText("* Cr\u00E9er votre requ\u00EAte personnalis\u00E9e\r\n* Maintenez la touche \"Ctrl\" pour s\u00E9lectionner plusieurs \r\n   \u00E9l\u00E9ments\r\n");
		GridBagConstraints gbc_dtrpnCrerVotre = new GridBagConstraints();
		gbc_dtrpnCrerVotre.insets = new Insets(0, 0, 5, 5);
		gbc_dtrpnCrerVotre.fill = GridBagConstraints.BOTH;
		gbc_dtrpnCrerVotre.gridx = 1;
		gbc_dtrpnCrerVotre.gridy = 0;
		m_pRecherche.add(dtrpnCrerVotre, gbc_dtrpnCrerVotre);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Drogues", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		m_pRecherche.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		listDrogues = new listDrogues();
		scrollPane_2 = new JScrollPane(listDrogues);
		panel_1.add(scrollPane_2, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Methodes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		m_pRecherche.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		listMethodes = new listMethodes();
		scrollPane_3 = new JScrollPane(listMethodes);
		panel_2.add(scrollPane_3, BorderLayout.CENTER);
		
		m_bClear = new JButton("Effacer la requ\u00EAte");
		GridBagConstraints gbc_m_bClear = new GridBagConstraints();
		gbc_m_bClear.insets = new Insets(0, 0, 5, 5);
		gbc_m_bClear.gridx = 0;
		gbc_m_bClear.gridy = 4;
		m_pRecherche.add(m_bClear, gbc_m_bClear);
		
		m_pButton = new JPanel();
		FlowLayout fl_m_pButton = (FlowLayout) m_pButton.getLayout();
		fl_m_pButton.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(m_pButton, BorderLayout.SOUTH);
		
		m_bRecherche = new JButton("Rechercher");
		m_pButton.add(m_bRecherche);
		
		m_bAnnuler = new JButton("Annuler");
		m_pButton.add(m_bAnnuler);
		
		controller = new diaRechercheMultipleControl();
		model = new diaRechercheMultipleModel();
	}
	
	

	public JButton getM_bClear() {
		return m_bClear;
	}



	public listQuartiers getListQuartiers() {
		return listQuartiers;
	}



	public listDrogues getListDrogues() {
		return listDrogues;
	}



	public listMethodes getListMethodes() {
		return listMethodes;
	}



	public JButton getM_bRecherche() {
		return m_bRecherche;
	}



	public JButton getM_bAnnuler() {
		return m_bAnnuler;
	}






	public class diaRechercheMultipleControl implements ActionListener
	{
		private List<Drogue> listDrogue;
		private List<Methode> listMethode;
		private List<Quartier> listQuartier;
		
		private String requete;
		private String req_base 	= "select * from t_rir where id IN ( * )";
		private String req_methode 	= " select distinct ref_rir from t_link_methode where ref_methode = 'REPLACE' ";
		private String req_drogue 	= " select distinct ref_rir from t_link_drogue where ref_drogue = 'REPLACE' ";
		private String req_quartier = " select distinct ref_rir from t_link_quartier where ref_quartier = 'REPLACE' ";
		private String link = " AND ref_rir IN ";
		
		private int cpt = 0;
		
		public diaRechercheMultipleControl()
		{
			super();
			
			
			// init requete
			requete = new String("");
			// Listener
			
			// button
			diaRechercheMultiple.this.getM_bRecherche().addActionListener(this);
			diaRechercheMultiple.this.getM_bAnnuler().addActionListener(this);
			diaRechercheMultiple.this.getM_bClear().addActionListener(this);
			

			
			
		}
		
		public void prepareData()
		{
			cpt = 0;
			listQuartier =  diaRechercheMultiple.this.getListQuartiers().getSelectedValuesList();
			listDrogue = diaRechercheMultiple.this.getListDrogues().getSelectedValuesList();
			listMethode = diaRechercheMultiple.this.getListMethodes().getSelectedValuesList();
			
			cpt = listQuartier.size() + listDrogue.size() + listMethode.size();
		}
 
		public void makeRequete()
		{
			String base = "select * from t_rir where id IN (REPLACE ";
			String r_quartier = " select distinct ref_rir from t_link_quartier where ref_quartier = REP_VALUE ";
			String r_drogue = " select distinct ref_rir from t_link_drogue where ref_drogue = REP_VALUE ";
			String r_methode = " select distinct ref_rir from t_link_methode where ref_methode = REP_VALUE ";
			String add = " AND ref_rir IN ( REPLACE  ";
			
			// ajout de la base
			requete = base; 
			
			int cptParenthese = cpt;
			
			// on parse les quartiers
			for(Quartier q : listQuartier)
			{
				requete = requete.replaceAll("REPLACE", r_quartier.replaceAll("REP_VALUE", "'" + q.getNom() +"'"));
				cpt--;
				// ajout du add
				if(cpt != 0)
					requete += add;
			}
			
			// on parse les drogues
			for(Drogue d : listDrogue)
			{
				requete = requete.replaceAll("REPLACE", r_drogue.replaceAll("REP_VALUE", "'" + d.getType() +"'"));
				cpt--;
				// ajout du add
				if(cpt != 0)
					requete += add;
			}
			
			// on parse les methodes
			for(Methode m : listMethode)
			{
				requete = requete.replaceAll("REPLACE", r_methode.replaceAll("REP_VALUE", "'" + m.getMethode() +"'"));
				cpt--;
				// ajout du add
				if(cpt != 0)
					requete += add;
			}
			
			// on cloture avec le nombre de parenthèse à fermer
			for(int i=0;i<cptParenthese;i++)
				requete += ")";
			
		
			
		}
		
		public ResultSet executeRequete()
		{
			System.out.println(requete);
			
			try 
			{
				Statement st = SqlLiteInterface.getConnection().createStatement();
				ResultSet result = st.executeQuery(requete);
				return result;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(arg0.getSource() == diaRechercheMultiple.this.getM_bRecherche())
			{
				
				// preparation des données
				prepareData();
				// création de la requete
				makeRequete();
				// exécution de la requete
				ResultSet result = executeRequete();
				// lancement du panl d'affichage
				if(result != null)
				{
					CtrlListRir cr = new CtrlListRir();
					cr.RechercheFromResult(result);
					
				}
				
				diaRechercheMultiple.this.setVisible(false);
				
				
			}
			
			if(arg0.getSource() == diaRechercheMultiple.this.getM_bAnnuler())
			{
				// Annuler
				diaRechercheMultiple.this.setVisible(false);
			}
			
			// Effacer la requête
			if(arg0.getSource() == diaRechercheMultiple.this.getM_bClear())
			{
				diaRechercheMultiple.this.getListQuartiers().clearSelection();
				diaRechercheMultiple.this.getListDrogues().clearSelection();
				diaRechercheMultiple.this.getListMethodes().clearSelection();
			}
			
		}

	}
	
	public class diaRechercheMultipleModel
	{

		public diaRechercheMultipleModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
}
