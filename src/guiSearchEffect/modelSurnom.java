package guiSearchEffect;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.NomManySearch;
import model.Personne;
import model.PrenomManySearch;
import model.SurnomManySearch;


public class modelSurnom extends DefaultTableModel 
{
	private String[] columnName = {"Surnom","Nombre"};
	
	private List<SurnomManySearch> listSurnom;
	
	
	public modelSurnom() {
		super();
		listSurnom = new ArrayList<SurnomManySearch>();
	}

	public List<SurnomManySearch> getListSurnom() {
		return listSurnom;
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
		if(listSurnom != null)
		return listSurnom.size();
		else
			return 0;
	}

	@Override
	public Object getValueAt(int row, int column) 
	{
		switch(column)
		{
		case 0 : return listSurnom.get(row).getSurnom();
		
		case 1: return listSurnom.get(row).getNb();
		
		default : return "";
		}
		
	}
	
}
