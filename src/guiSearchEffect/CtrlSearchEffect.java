package guiSearchEffect;

import guiListRIR.CtrlListRir;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ContactSearch;
import model.PersonneSearch;
import model.SqlLiteInterface;

public class CtrlSearchEffect implements MouseListener
{

	private panelSearchEffect pe;
	
	private modelContact modelContact;
	private modelPersonne modelPersonne;
	
	public CtrlSearchEffect() 
	{
		super();
		
	}
	
	public CtrlSearchEffect(panelSearchEffect pe) 
	{
		super();
		
		this.pe = pe;
		
		// on associe les modele
		modelContact = new modelContact();
		pe.getTableContact().setModel(modelContact);
		
		modelPersonne = new modelPersonne();
		pe.getTablePersonne().setModel(modelPersonne);
		
		// on associe les actionlistener
		pe.getTableContact().addMouseListener(this);
		pe.getTablePersonne().addMouseListener(this);
		
		// update
		this.UpdateSearch();
		
	}
	
	public void UpdateSearch()
	{
		
		// contact
		try 
		{
			modelContact.getListRir().clear();
			ResultSet result = SqlLiteInterface.SelectManyContact();
			while(result.next())
			{
				ContactSearch c = new ContactSearch(result);
				modelContact.getListRir().add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// personne
		
		// update graphics
		this.pe.getTableContact().updateUI();
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if(arg0.getClickCount() > 1)
		{
			if(arg0.getSource() == this.pe.getTableContact()) // contactSearch
			{
				int row = this.pe.getTableContact().getSelectedRow();
				ContactSearch cs = modelContact.getListRir().get(row);
				CtrlListRir ct = new CtrlListRir();
				ct.RechercheFromContact(cs.getContact());
			}
			
			
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
