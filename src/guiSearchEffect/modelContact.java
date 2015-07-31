package guiSearchEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import model.ContactSearch;
import model.NumeroContact;
import model.Rir;

public class modelContact extends DefaultTableModel 
{
	private String[] columnName = {"Numero de contact","Nombre"};
	
	private List<ContactSearch> listRir;

	
	
	public List<ContactSearch> getListRir() {
		return listRir;
	}

	public modelContact() {
		super();
		// TODO Auto-generated constructor stub
		listRir = new ArrayList<ContactSearch>();
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
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public String getColumnName(int arg0) 
	{
		// TODO Auto-generated method stub
		return columnName[arg0];
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
	public Object getValueAt(int arg0, int arg1) 
	{
		// TODO Auto-generated method stub
		if(arg1 == 0)
			return listRir.get(arg0).getContact();
		if(arg1 == 1)
			return listRir.get(arg0).getNb();
		
		return "";
		
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
