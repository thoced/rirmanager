package guiSearchEffect;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.NomManySearch;
import model.Personne;
import model.PrenomManySearch;


public class modelPrenom extends DefaultTableModel 
{
	private String[] columnName = {"Prenom","Nombre"};
	
	private List<PrenomManySearch> listPersonne;
	
	
	public modelPrenom() {
		super();
		listPersonne = new ArrayList<PrenomManySearch>();
	}

	
	
	public List<PrenomManySearch> getListPersonne() {
		return listPersonne;
	}



	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(listPersonne != null)
		return listPersonne.size();
		else
			return 0;
	}

	@Override
	public Object getValueAt(int row, int column) 
	{
		switch(column)
		{
		case 0 : return listPersonne.get(row).getPrenom();
		
		case 1: return listPersonne.get(row).getNb();
		
		default : return "";
		}
		
	}
	
}
