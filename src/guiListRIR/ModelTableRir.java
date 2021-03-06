package guiListRIR;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import model.NoDeleteException;
import model.Quartier;
import model.Rir;
import model.SqlLiteInterface;

public class ModelTableRir extends DefaultTableModel 
{

	private List<Rir> listRir = new ArrayList<Rir>();;
	
	public ModelTableRir()
	{
		
		this.updateModel();

		
	}
	
	
	
	public List<Rir> getListRir() {
		return listRir;
	}

	public void updateModel()
	{
		listRir.clear();
		ResultSet result;
		try
		{
			result = SqlLiteInterface.SelectAllRir();
			update(result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setResult(ResultSet result)
	{
		
		listRir.clear();
		try {
			while(result.next())
			{
				Rir rir = new Rir(result);
				listRir.add(rir);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void update(ResultSet result)
	{
		try {
			while(result.next())
			{
				Rir rir = new Rir(result);
				listRir.add(rir);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteRir(int idRir) throws NoDeleteException
	{
		Rir rir = listRir.get(idRir);
		SqlLiteInterface.DeleteRir(rir.getId());
	
	}
	
	public void SelectWidthDate(Date b,Date h)
	{
		try 
		{
			listRir.clear();
			ResultSet result = SqlLiteInterface.SelectRirWidthDate(b,h);
			update(result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void SelectFromInfo(String info)
	{
		listRir.clear();
		try 
		{
			ResultSet result = SqlLiteInterface.SelectRirFromInfo(info);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public Rir SelectRir(int row) // retourne le Rir selectionn�
	{
		if(listRir != null)
		{
			return listRir.get(row);
		}
		else
			return null;
	}
	
	public void SelectFromDrogue(String drogue)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromDrogue(drogue);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromQuartier(String quartier)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromQuartier(quartier);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromPersonne(String nom,String prenom,String surnom)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromPersonne(nom, prenom, surnom);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromNom(String nom)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromNom(nom);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromPrenom(String prenom)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromPrenom(prenom);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromSurnom(String surnom)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromSurnom(surnom);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromMtp(String marque,String immatriculation,String couleur)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromMtp(marque, immatriculation, couleur);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectFromContact(String contact)
	{
		listRir.clear();
		
		ResultSet result;
		try {
			result = SqlLiteInterface.SelectRirFromContact(contact);
			update(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addColumn(Object arg0, Object[] arg1) {
		// TODO Auto-generated method stub
		super.addColumn(arg0, arg1);
	}

	@Override
	public void addColumn(Object arg0, Vector arg1) {
		// TODO Auto-generated method stub
		super.addColumn(arg0, arg1);
	}

	@Override
	public void addColumn(Object arg0) {
		// TODO Auto-generated method stub
		super.addColumn(arg0);
	}

	@Override
	public void addRow(Object[] arg0) {
		// TODO Auto-generated method stub
		super.addRow(arg0);
	}

	@Override
	public void addRow(Vector arg0) {
		// TODO Auto-generated method stub
		super.addRow(arg0);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		switch(arg0)
		{
		case 0: return "n�";
		
		case 1 : return "num�ro";
		
		case 2 : return "date";
		
		case 3: return "source";
		
		default : return "num�ro";
		}
	}

	@Override
	public Vector getDataVector() {
		// TODO Auto-generated method stub
		return super.getDataVector();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(listRir != null)
		return listRir.size();
		else
			return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
		// cr�ation d'une date format�
		SimpleDateFormat format;
		Calendar cal = Calendar.getInstance();
		try
		{
			
			cal.setTimeInMillis(((Rir)listRir.get(arg0)).getDateRir().getTime());
			String formatString = "dd/MM/yyyy";
			format = new SimpleDateFormat(formatString);
		}
		catch(NullPointerException npe)
		{
			
			cal.setTimeInMillis(0);
			String formatString = "dd/MM/yyyy";
			format = new SimpleDateFormat(formatString);
		}
		switch(arg1)
		{
		case 0: return arg0 + 1;
	
		case 1 : return ((Rir)listRir.get(arg0)).getNumero();
		
		case 2:  return format.format(cal.getTime()); //  date format�e
		
		case 3: return ((Rir)listRir.get(arg0)).getSource();
		
		default : return null;
		}
		
	
		
		
	}

	@Override
	public void insertRow(int arg0, Object[] arg1) {
		// TODO Auto-generated method stub
		super.insertRow(arg0, arg1);
	}

	@Override
	public void insertRow(int arg0, Vector arg1) {
		// TODO Auto-generated method stub
		super.insertRow(arg0, arg1);
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveRow(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		super.moveRow(arg0, arg1, arg2);
	}

	@Override
	public void newDataAvailable(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		super.newDataAvailable(arg0);
	}

	@Override
	public void newRowsAdded(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		super.newRowsAdded(arg0);
	}

	@Override
	public void removeRow(int arg0) {
		// TODO Auto-generated method stub
		super.removeRow(arg0);
	}

	@Override
	public void rowsRemoved(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		super.rowsRemoved(arg0);
	}

	@Override
	public void setColumnCount(int arg0) {
		// TODO Auto-generated method stub
		super.setColumnCount(arg0);
	}

	@Override
	public void setColumnIdentifiers(Object[] arg0) {
		// TODO Auto-generated method stub
		super.setColumnIdentifiers(arg0);
	}

	@Override
	public void setColumnIdentifiers(Vector arg0) {
		// TODO Auto-generated method stub
		super.setColumnIdentifiers(arg0);
	}

	@Override
	public void setDataVector(Object[][] arg0, Object[] arg1) {
		// TODO Auto-generated method stub
		super.setDataVector(arg0, arg1);
	}

	@Override
	public void setDataVector(Vector arg0, Vector arg1) {
		// TODO Auto-generated method stub
		super.setDataVector(arg0, arg1);
	}

	@Override
	public void setNumRows(int arg0) {
		// TODO Auto-generated method stub
		super.setNumRows(arg0);
	}

	@Override
	public void setRowCount(int arg0) {
		// TODO Auto-generated method stub
		super.setRowCount(arg0);
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		super.setValueAt(arg0, arg1, arg2);
	}
	
}
