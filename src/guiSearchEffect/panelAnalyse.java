package guiSearchEffect;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import guiListRIR.CtrlListRir;
import model.ContactSearch;
import model.Personne;
import model.PersonneSearch;
import model.Rir;
import model.SqlLiteInterface;

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

public class panelAnalyse extends JPanel 
{
	private JTable m_tableAnalyseContact;
	
	private panelAnalyseModel model;
	private panelAnalyseControl control;
	private JTable m_tableAnalysePersonne;

	public panelAnalyse() 
	{
		super();
		setBorder(new TitledBorder(null, "Analyse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		setBackground(Color.GRAY);
		setLayout(new MigLayout("", "[250.00,center][]", "[106.00,grow]"));
		
		m_tableAnalyseContact = new JTable();
		m_tableAnalyseContact.setBackground(Color.ORANGE);
		modelContact mc = new modelContact();
		m_tableAnalyseContact.setModel(mc);
		JScrollPane scrollPane = new JScrollPane(m_tableAnalyseContact);
		add(scrollPane, "cell 0 0,grow");
		
		m_tableAnalysePersonne = new JTable();
		m_tableAnalysePersonne.setBackground(Color.ORANGE);
		modelPersonne  mp =  new modelPersonne();
		m_tableAnalysePersonne.setModel(mp);
		JScrollPane scrollPane_1 = new JScrollPane(m_tableAnalysePersonne);
		add(scrollPane_1, "flowx,cell 1 0,grow");
		
	
		
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



	public class panelAnalyseControl implements MouseListener
	{

		public panelAnalyseControl() 
		{
			super();
			
			// listener
			panelAnalyse.this.getM_tableAnalyseContact().addMouseListener(this);
			panelAnalyse.this.getM_tableAnalysePersonne().addMouseListener(this);
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			// AnalyseContact
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalyseContact())
			{
				int row = panelAnalyse.this.getM_tableAnalyseContact().getSelectedRow();
				ContactSearch contact = (ContactSearch) ((modelContact)panelAnalyse.this.getM_tableAnalyseContact().getModel()).getListRir().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromContact(contact.getContact());
			}
			
			// AnalysePersonne
			if(arg0.getSource() == panelAnalyse.this.getM_tableAnalysePersonne())
			{
				int row = panelAnalyse.this.getM_tableAnalysePersonne().getSelectedRow();
				PersonneSearch personne = (PersonneSearch) ((modelPersonne)panelAnalyse.this.getM_tableAnalysePersonne().getModel()).getListPersonne().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromPersonne(personne.getNom(), personne.getPrenon(), personne.getSurnom());
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
						
		    // personne
						try 
						{
							
							modelPersonne mp = (modelPersonne)panelAnalyse.this.getM_tableAnalysePersonne().getModel();
							mp.getListPersonne().clear();
							ResultSet result = SqlLiteInterface.SelectManyPersonne();
							while(result.next())
							{
								PersonneSearch p = new PersonneSearch(result);
								mp.getListPersonne().add(p);
							}
							
							panelAnalyse.this.getM_tableAnalysePersonne().updateUI();
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						
		}
		
		
		
	}
	
}
