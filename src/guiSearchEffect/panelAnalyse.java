package guiSearchEffect;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import guiListRIR.CtrlListRir;
import model.ContactSearch;
import model.NomManySearch;
import model.Personne;
import model.PrenomManySearch;
import model.Rir;
import model.SqlLiteInterface;
import model.SurnomManySearch;

import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class panelAnalyse extends JPanel 
{
	private JTable m_tableAnalyseContact;
	
	private panelAnalyseModel model;
	private panelAnalyseControl control;
	private JTable m_tableAnalysePersonne;
	private JScrollPane scrollPane_2;
	private JTable m_tableAnalysePrenom;
	private JScrollPane scrollPane_3;
	private JTable m_tableAnalyseSurnom;

	public panelAnalyse() 
	{
		super();
		setBorder(new TitledBorder(null, "Analyse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		setBackground(Color.GRAY);
		setLayout(new MigLayout("", "[250.00,center][250][250][250][grow][grow]", "[140.00,grow]"));
		
		m_tableAnalyseContact = new JTable();
		m_tableAnalyseContact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m_tableAnalyseContact.setBackground(new Color(0,200,0));
		modelContact mc = new modelContact();
		m_tableAnalyseContact.setModel(mc);
		JScrollPane scrollPane = new JScrollPane(m_tableAnalyseContact);
		scrollPane.setViewportBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleGradient"), 2, true));
		add(scrollPane, "cell 0 0,grow");
		
		m_tableAnalysePersonne = new JTable();
		m_tableAnalysePersonne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m_tableAnalysePersonne.setBackground(Color.ORANGE);
		modelNom  mp =  new modelNom();
		m_tableAnalysePersonne.setModel(mp);
		JScrollPane scrollPane_1 = new JScrollPane(m_tableAnalysePersonne);
		scrollPane_1.setViewportBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleGradient"), 2, true));
		add(scrollPane_1, "flowx,cell 1 0,grow");
		
		m_tableAnalysePrenom = new JTable();
		m_tableAnalysePrenom.setBackground(Color.ORANGE);
		m_tableAnalysePrenom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelPrenom mpr = new modelPrenom();
		m_tableAnalysePrenom.setModel(mpr);
		scrollPane_2 = new JScrollPane(m_tableAnalysePrenom);
		scrollPane_2.setViewportBorder(new LineBorder(UIManager.getColor("InternalFrame.activeTitleGradient"), 2, true));
		add(scrollPane_2, "cell 2 0,grow");
		modelSurnom ms = new modelSurnom();
		
		m_tableAnalyseSurnom = new JTable();
		m_tableAnalyseSurnom.setBackground(Color.ORANGE);
		m_tableAnalyseSurnom.setModel(ms);
		scrollPane_3 = new JScrollPane(m_tableAnalyseSurnom);
		add(scrollPane_3, "cell 3 0,grow");
		
	
		model = new panelAnalyseModel();
		control = new panelAnalyseControl();
		
	}
	
	public void updateAnalyse()
	{
		model.updateData();
	}

	
	
	public panelAnalyseModel getModel() {
		return model;
	}



	public panelAnalyseControl getControl() {
		return control;
	}



	public JTable getM_tableAnalyseContact() {
		return m_tableAnalyseContact;
	}

	

	public JTable getM_tableAnalysePersonne() {
		return m_tableAnalysePersonne;
	}



	


	public JTable getM_tableAnalysePrenom() {
		return m_tableAnalysePrenom;
	}






	public JTable getM_tableAnalyseSurnom() {
		return m_tableAnalyseSurnom;
	}






	public class panelAnalyseControl implements MouseListener
	{

		public panelAnalyseControl() 
		{
			super();
			
			// listener
			panelAnalyse.this.getM_tableAnalyseContact().addMouseListener(this);
			panelAnalyse.this.getM_tableAnalysePersonne().addMouseListener(this);
			panelAnalyse.this.getM_tableAnalysePrenom().addMouseListener(this);
			panelAnalyse.this.getM_tableAnalyseSurnom().addMouseListener(this);
			
			// empèche la surbrillance lors d'une sélection
			/*panelAnalyse.this.getM_tableAnalyseContact().setCellSelectionEnabled(false);
			panelAnalyse.this.getM_tableAnalysePersonne().setCellSelectionEnabled(false);
			panelAnalyse.this.getM_tableAnalysePrenom().setCellSelectionEnabled(false);
			panelAnalyse.this.getM_tableAnalyseSurnom().setCellSelectionEnabled(false);*/
			
			panelAnalyse.this.getM_tableAnalyseContact().setRowSelectionAllowed(false);
			panelAnalyse.this.getM_tableAnalysePersonne().setRowSelectionAllowed(false);
			panelAnalyse.this.getM_tableAnalysePrenom().setRowSelectionAllowed(false);
			panelAnalyse.this.getM_tableAnalyseSurnom().setRowSelectionAllowed(false);
			
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			
			// si click sur bouton centrale et bouton droit, on quitte
			if(arg0.getButton() == MouseEvent.BUTTON3 || arg0.getButton() == MouseEvent.BUTTON2)
				return;
			
			// AnalyseContact
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalyseContact())
			{
				int row = panelAnalyse.this.getM_tableAnalyseContact().getSelectedRow();
				ContactSearch contact = (ContactSearch) ((modelContact)panelAnalyse.this.getM_tableAnalyseContact().getModel()).getListRir().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromContact(contact.getContact());
			}
			
			// AnalyseNom
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalysePersonne())
			{
				int row = panelAnalyse.this.getM_tableAnalysePersonne().getSelectedRow();
				NomManySearch personne = (NomManySearch) ((modelNom)panelAnalyse.this.getM_tableAnalysePersonne().getModel()).getListPersonne().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromNom(personne.getNom());
			}
			
			// AnalysePrenom
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalysePrenom())
			{
				int row = panelAnalyse.this.getM_tableAnalysePrenom().getSelectedRow();
				PrenomManySearch personne = (PrenomManySearch) ((modelPrenom)panelAnalyse.this.getM_tableAnalysePrenom().getModel()).getListPersonne().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromPrenom(personne.getPrenom());
			}
			// AnalyseSurnom
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalyseSurnom())
			{
				int row = panelAnalyse.this.getM_tableAnalyseSurnom().getSelectedRow();
				SurnomManySearch personne = (SurnomManySearch) ((modelSurnom)panelAnalyse.this.getM_tableAnalyseSurnom().getModel()).getListSurnom().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromSurnom(personne.getSurnom());
			}			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		
	}

	public class panelAnalyseModel
	{

		public panelAnalyseModel()
		{
			this.updateData();
			
		}
		
		public void updateData()
		{
			
			
			// contact
						try 
						{
							
							modelContact mc = (modelContact)panelAnalyse.this.getM_tableAnalyseContact().getModel();
							mc.getListRir().clear();
							ResultSet result = SqlLiteInterface.SelectManyContact();
							while(result.next())
							{
								ContactSearch c = new ContactSearch(result);
								 mc = (modelContact)panelAnalyse.this.getM_tableAnalyseContact().getModel();
								mc.getListRir().add(c);
							}
							
							panelAnalyse.this.getM_tableAnalyseContact().updateUI();
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
		    // nomnne
						try 
						{
							
							modelNom mp = (modelNom)panelAnalyse.this.getM_tableAnalysePersonne().getModel();
							mp.getListPersonne().clear();
							ResultSet result = SqlLiteInterface.SelectManyPersonne();
							while(result.next())
							{
								NomManySearch p = new NomManySearch(result);
								mp.getListPersonne().add(p);
							}
							
							panelAnalyse.this.getM_tableAnalysePersonne().updateUI();
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
						
			// prenom
						try 
						{
							
							modelPrenom mp = (modelPrenom)panelAnalyse.this.getM_tableAnalysePrenom().getModel();
							mp.getListPersonne().clear();
							ResultSet result = SqlLiteInterface.SelectManyPrenom();
							while(result.next())
							{
								PrenomManySearch p = new PrenomManySearch(result);
								mp.getListPersonne().add(p);
							}
							
							panelAnalyse.this.getM_tableAnalysePrenom().updateUI();
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
			// surnom
						try 
						{
							
							modelSurnom ms = (modelSurnom)panelAnalyse.this.getM_tableAnalyseSurnom().getModel();
							ms.getListSurnom().clear();
							ResultSet result = SqlLiteInterface.SelectManySurnom();
							while(result.next())
							{
								SurnomManySearch p = new SurnomManySearch(result);
								ms.getListSurnom().add(p);
							}
							
							panelAnalyse.this.getM_tableAnalyseSurnom().updateUI();
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
						
		}
		
		
		
	}
	
}
