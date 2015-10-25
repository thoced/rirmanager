package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ICallBackMVC;
import model.Rir;
import model.SqlLiteInterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import gui.diaAdd;
import gui.diaAddRirView;
import gui.panelAdd;
import gui.panelList;

import javax.swing.JToolBar;
import javax.swing.JButton;

import gui.ToolBarRir;
import guiAbout.diaAbout;
import guiListRIR.CtrlListRir;
import guiRecherche.CtrlRechercheContact;
import guiRecherche.CtrlRechercheDrogue;
import guiRecherche.CtrlRechercheInfo;
import guiRecherche.CtrlRechercheMtp;
import guiRecherche.CtrlRecherchePersonne;
import guiRecherche.CtrlRechercheQuartier;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.CardLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Insets;

import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.TitledBorder;


import guiSearchEffect.modelContact;
import guiSearchEffect.panelAnalyse;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.WindowFocusListener;
import java.awt.Font;
import java.awt.Frame;

public class mainProgram implements ICallBackMVC, ActionListener{

	private JFrame frame;
	
	private SqlLiteInterface sqlLite;
	private JMenuItem mListRir;
	private JMenu menuRecherche;
	private JMenuItem mRechercheDrogue;
	private JMenuItem mRechercheQuartier;
	private JMenuItem mRecherchePersonne;
	private JMenuItem mRechercheMtp;
	private JMenuItem mQuitter;
	private JMenuItem mRechercheContact;
	private JMenuItem mRechercheInfo;
	private panelLogo panelLogo;
	private JMenu menuAide;
	private JMenuItem mAbout;
	private panelAnalyse m_panelAnalyse;
	private JScrollPane scrollPane;
	private JTable m_tableAnalyseContact;
	private JLabel m_lDev;
	private JPanel panelDev;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainProgram window = new mainProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		
		// icon
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/Textures/logoico.png")).getImage());
		
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) 
			{
				m_panelAnalyse.updateAnalyse();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) 
			{
				try {
					SqlLiteInterface.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.setSize(1152, 864);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);
		
		mQuitter = new JMenuItem("Quitter");
		mQuitter.addActionListener(this);
		mQuitter.setActionCommand("QUITTER");
		menuFichier.add(mQuitter);
		
		JMenu menuEdition = new JMenu("Edition");
		menuBar.add(menuEdition);
		
		JMenuItem mAddRir = new JMenuItem("Ajouter un RIR");
		mAddRir.setActionCommand("ADDRIR");
		mAddRir.addActionListener(this);
		menuEdition.add(mAddRir);
		
		mListRir = new JMenuItem("Lister l'ensemble des RIR");
		mListRir.setActionCommand("LISTRIR");
		mListRir.addActionListener(this);
		menuEdition.add(mListRir);
		
		menuRecherche = new JMenu("Recherche");
		menuBar.add(menuRecherche);
		
		mRechercheDrogue = new JMenuItem("Recherche (Drogue)");
		mRechercheDrogue.addActionListener(this);
		mRechercheDrogue.setActionCommand("RECHERCHE_DROGUE");
		menuRecherche.add(mRechercheDrogue);
		
		mRechercheQuartier = new JMenuItem("Recherche (Quartier)");
		mRechercheQuartier.addActionListener(this);
		mRechercheQuartier.setActionCommand("RECHERCHE_QUARTIER");
		menuRecherche.add(mRechercheQuartier);
		
		mRecherchePersonne = new JMenuItem("Recherche d'une Personne");
		mRecherchePersonne.addActionListener(this);
		mRecherchePersonne.setActionCommand("RECHERCHE_PERSONNE");
		menuRecherche.add(mRecherchePersonne);
		
		mRechercheMtp = new JMenuItem("Recherche d'un Moyen de Transport");
		mRechercheMtp.addActionListener(this);
		mRechercheMtp.setActionCommand("RECHERCHE_MTP");
		menuRecherche.add(mRechercheMtp);
		
		mRechercheContact = new JMenuItem("Recherche d'un num\u00E9ro de Contact");
		mRechercheContact.addActionListener(this);
		mRechercheContact.setActionCommand("RECHERCHE_CONTACT");
		menuRecherche.add(mRechercheContact);
		
		mRechercheInfo = new JMenuItem("Recherche dans le contenu de l'information (RIR)");
		mRechercheInfo.addActionListener(this);
		mRechercheInfo.setActionCommand("RECHERCHE_INFO");
		menuRecherche.add(mRechercheInfo);
		
		menuAide = new JMenu("Aide");
		menuBar.add(menuAide);
		
		mAbout = new JMenuItem("Au sujet de RirManager");
		mAbout.setActionCommand("ABOUT");
		mAbout.addActionListener(this);
		menuAide.add(mAbout);
		frame.getContentPane().setLayout(new BorderLayout(0, 64));
		
		panelLogo = new panelLogo();
		frame.getContentPane().add(panelLogo, BorderLayout.CENTER);
		
		m_panelAnalyse = new panelAnalyse();
		
		frame.getContentPane().add(m_panelAnalyse, BorderLayout.SOUTH);
		
		panelDev = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDev.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panelDev, BorderLayout.NORTH);
		
		m_lDev = new JLabel("Developp\u00E9 par THONON C\u00E9dric");
		m_lDev.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panelDev.add(m_lDev);
		
		
		
		
		// instance du sqlinterface
		sqlLite = new SqlLiteInterface();
		try
		{
		//	sqlLite.prepareSchemaSQLLITE();
			sqlLite.prepareSchemaMYSQL();
			
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur de chargement de la class : " + e.getMessage());
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Exception dans la requete de préparation du schema : " + e.getMessage());
		}
	}

	
	
	public JMenuItem getmListRir() {
		return mListRir;
	}

	@Override
	public void update(Rir rir)
	{
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case "ADDRIR" : 	//diaNewRir dia = new diaNewRir(null,"Ajout de RIR",true);
								diaAddRirView dia;
								try {
										dia = new diaAddRirView(null,"Ajout de RIR",true);
										dia.setVisible(true);
									} 
								catch (ParseException e1) 
								{
											// TODO Auto-generated catch block
											e1.printStackTrace();
									}
			
								
								
								break;
			
			case "LISTRIR":		CtrlListRir ctrlListRir = new CtrlListRir();
								ctrlListRir.RechercheAll();
								break;
						
			case "RECHERCHE_DROGUE": CtrlRechercheDrogue ctrlRechercheDrogue = new CtrlRechercheDrogue();
									break;
								
			case "RECHERCHE_QUARTIER": CtrlRechercheQuartier ctrlRechercheQuartier = new CtrlRechercheQuartier();
									break;
									
			case "RECHERCHE_PERSONNE": CtrlRecherchePersonne ctrlRecherchePersonne = new CtrlRecherchePersonne();
									break;
									
			case "RECHERCHE_MTP": CtrlRechercheMtp ctrlRechercheMtp = new CtrlRechercheMtp();
									break;
									
			case "RECHERCHE_CONTACT": CtrlRechercheContact ctrlRechercheContact = new CtrlRechercheContact();
									break;
									
			case "RECHERCHE_INFO": CtrlRechercheInfo ctrlRechercheInfo = new CtrlRechercheInfo();
									break;
									
			case "ABOUT":		    diaAbout about  = new diaAbout(null,"Au sujet de RirManager",true);
									about.setVisible(true);
									break;
									
			case "QUITTER": frame.setVisible(false);frame.dispose();System.exit(0);break;
		
			
								
		}
		
	}
}
