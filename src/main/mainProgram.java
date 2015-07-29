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

import gui.diaAdd;
import gui.diaNewRir;
import gui.panelAdd;
import gui.panelList;

import javax.swing.JToolBar;
import javax.swing.JButton;

import gui.ToolBarRir;
import guiListRIR.CtrlListRir;
import guiRecherche.CtrlRechercheDrogue;

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

public class mainProgram implements ICallBackMVC, ActionListener{

	private JFrame frame;
	
	private SqlLiteInterface sqlLite;
	private JMenuItem mListRir;
	private JMenu menuRecherche;
	private JMenuItem mRechercheDrogue;

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
		
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(mainProgram.class.getResource("/Textures/logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
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
			case "ADDRIR" : 	diaNewRir dia = new diaNewRir(null,"Ajout de RIR",true);
								dia.setVisible(true);
								break;
			
			case "LISTRIR":		CtrlListRir ctrlListRir = new CtrlListRir();
								break;
						
			case "RECHERCHE_DROGUE": CtrlRechercheDrogue ctrlRechercheDrogue = new CtrlRechercheDrogue();
								break;
								
		}
		
	}
}
