package model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelMVC 
{
	private static List<ICallBackMVC> listMVC;
	
	private static Rir currentRir;
	
	public ModelMVC()
	{
		init();
	}
	
	private static void init()
	{
		listMVC = new ArrayList<ICallBackMVC>();
	}
	
	public static void attachMVC(ICallBackMVC mvc)
	{
		if(listMVC == null)
			init();
		
		if(!listMVC.contains(mvc))
			listMVC.add(mvc);
	}
	
	public static void dettachMVC(ICallBackMVC mvc)
	{
		if(listMVC != null)
		{
			listMVC.remove(mvc);
		}
	}
	
	public static void updateMVC()
	{
		if(currentRir != null)
		{
			for(ICallBackMVC mvc : listMVC)
				mvc.update(currentRir);
		}
	}
	
	public static void newRir()
	{
		currentRir = new Rir();
	}
	
	public static void removeQuartier(int ind)
	{
		if(currentRir != null && ind != -1)
			currentRir.getListQuartier().remove(ind);
		
		updateMVC();
	}
	
	public static void removeMethode(int ind)
	{
		if(currentRir != null  && ind != -1)
			currentRir.getListMethode().remove(ind);
		
		updateMVC();
	}
	public static void removeDrogue(int ind)
	{
		if(currentRir != null  && ind != -1)
			currentRir.getListDrogue().remove(ind);
		
		updateMVC();
	}
	
	public static void removeContact(int ind)
	{
		if(currentRir != null  && ind != -1)
			currentRir.getListNumeroContact().remove(ind);
		
		updateMVC();
	}
	
	public static void removeMtp(int ind)
	{
		if(currentRir != null  && ind != -1)
			currentRir.getListMtp().remove(ind);
		
		updateMVC();
	}
	
	public static void removePersonne(int ind)
	{
		if(currentRir != null  && ind != -1)
			currentRir.getListPersonne().remove(ind);
		
		updateMVC();
	}

	public static void insertMethode(Methode methode)
	{
		if(currentRir != null)
		currentRir.getListMethode().add(methode);
		// update MVC
		updateMVC();
	}
	
	public static void insertQuartier(Quartier quartier)
	{
		if(currentRir != null)
		currentRir.getListQuartier().add(quartier);
		// update MVC
		updateMVC();
	}
	
	public static void insertDrogue(Drogue drogue)
	{
		if(currentRir != null)
		currentRir.getListDrogue().add(drogue);
		// updateMVC
		updateMVC();
	}
	
	public static void insertPersonne(Personne personne)
	{
		if(currentRir != null)
		currentRir.getListPersonne().add(personne);
		// updateMVC
		updateMVC();
	}
	
	public static void insertMtp(Mtp mtp)
	{
		if(currentRir != null)
		currentRir.getListMtp().add(mtp);
		// updateMVC
		updateMVC();
	}
	
	public static void insertNumeroContact(NumeroContact numero)
	{
		if(currentRir != null)
		currentRir.getListNumeroContact().add(numero);
		// update MVC
		updateMVC();
	}
	
	public static void insertDateRir(java.sql.Date dateRir)
	{
		if(currentRir != null)
		currentRir.setDateRir(dateRir);
	}
	
	public static void insertSource(String source)
	{
		if(currentRir != null)
		currentRir.setSource(source);
	}
	
	public static void insertNumero(String numero)
	{
		if(currentRir != null)
		currentRir.setNumero(numero);
	}
	
	public static void insertNature(String nature)
	{
		if(currentRir != null)
		currentRir.setNature(nature);
	}
	
	
	public static void insertFile(File fichier)
	{
		if(currentRir != null)
		currentRir.setPathFile(fichier.getAbsolutePath());
	}
	
	public static void saveRir()
	{
		if(currentRir != null)
		{
			SqlLiteInterface.insertRir(currentRir);
		}
	}
	
	public static List<Quartier> getAllQuartier()
	{
		ArrayList<Quartier> list = new ArrayList<Quartier>();
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllQuartier();
			
			while(result.next())
			{
				Quartier quartier  = new Quartier();
				quartier.setNom(result.getString("quartier"));
				list.add(quartier);
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public static List<Drogue> getAllDrogue()
	{
		ArrayList<Drogue> list = new ArrayList<Drogue>();
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllDrogue();
			
			while(result.next())
			{
				Drogue drogue  = new Drogue();
				drogue.setType(result.getString("drogue"));
				list.add(drogue);
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public static List<Methode> getAllMethode()
	{
		ArrayList<Methode> list = new ArrayList<Methode>();
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllMethode();
			
			while(result.next())
			{
				Methode methode  = new Methode();
				methode.setMethode(result.getString("methode"));
				list.add(methode);
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public static List<Couleur> getAllCouleur()
	{
		ArrayList<Couleur> list = new ArrayList<Couleur>();
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllCouleur();
			
			while(result.next())
			{
				Couleur couleur  = new Couleur(result);
				//uleur.setCouleur(result.getString("couleur"));
				list.add(couleur);
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
	public static List<Source> getAllSource()
	{
		ArrayList<Source> list = new ArrayList<Source>();
		try
		{
			ResultSet result = SqlLiteInterface.SelectAllSource();
			
			while(result.next())
			{
				Source source  = new Source(result);
				list.add(source);
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
	
}
