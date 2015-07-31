package guiSearchEffect;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Personne;

public class modelPersonne extends DefaultTableModel 
{
	private String[] columnName = {"Nom","Prenom","Surnom","Date de naissance"};
	
	private List<Personne> listPersonne;
	
	
	public modelPersonne() {
		super();
		listPersonne = new ArrayList<Personne>();
	}

	
	
	public List<Personne> getListPersonne() {
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
		case 0 : return listPersonne.get(row).getNom();
		
		case 1: return listPersonne.get(row).getPrenom();
		
		case 2: return listPersonne.get(row).getSurnom();
		
		case 3: return listPersonne.get(row).getDateNaissance();
		
		default : return "";
		}
		
	}
	
}
