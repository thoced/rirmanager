package model;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rir 
{
	private java.sql.Date dateRir;
	
	private String numero;
	
	private String source;
	
	private List<Methode> listMethode;
	
	private List<Drogue> listDrogue;
	
	private List<Quartier> listQuartier;
	
	private List<Personne> listPersonne;
	
	private List<NumeroContact> listNumeroContact;
	
	private List<Mtp> listMtp;
	
	private String nature;
	
	private String pathFile;
	
	private InputStream data;
	
	private int id;
	
	//  ---------------------------
	
	
	public Rir()
	{
		listMethode = new ArrayList<Methode>();
		
		listQuartier = new ArrayList<Quartier>();
		
		listDrogue = new  ArrayList<Drogue>();
		
		listPersonne = new  ArrayList<Personne>();
		
		listMtp = new  ArrayList<Mtp>();
		
		listNumeroContact = new ArrayList<NumeroContact>();
		
	}
	
	
	public Rir(ResultSet result)
	{
		this(); // appel au constructeur de base
		
		try 
		{
			id = result.getInt("id");
			numero = result.getString("numero");
			dateRir = result.getDate("daterir");
			source = result.getString("source");
			nature = result.getString("nature");
				
			this.updateData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData() throws ClassNotFoundException, SQLException
	{
		// recherches des quartiers
		ResultSet resultQuartier = SqlLiteInterface.SelectQuartier(this.getId());
		while(resultQuartier.next())
		{
			Quartier quartier = new Quartier(resultQuartier);
			this.getListQuartier().add(quartier);
		}
		// recherches des drogues
		ResultSet resultDrogue = SqlLiteInterface.SelectDrogues(this.getId());
		while(resultDrogue.next())
		{
			Drogue drogue = new Drogue(resultDrogue);
			this.getListDrogue().add(drogue);
		}
		// recherches des methodes
		ResultSet resultMethode = SqlLiteInterface.SelectMethodes(this.getId());
		while(resultMethode.next())
		{
			Methode methode = new Methode(resultMethode);
			this.getListMethode().add(methode);
		}
		// recherches des personnes
		ResultSet resultPersonne = SqlLiteInterface.SelectPersonnes(this.getId());
		while(resultPersonne.next())
		{
			Personne personne = new Personne(resultPersonne);
			this.getListPersonne().add(personne);
		}
		// recherches des mtp
		ResultSet resultMtp = SqlLiteInterface.SelectMtp(this.getId());
		while(resultMtp.next())
		{
			Mtp mtp = new Mtp(resultMtp);
			this.getListMtp().add(mtp);
		}
		// recherches des mtp
		ResultSet resultContact = SqlLiteInterface.SelectContact(this.getId());
		while(resultContact.next())
		{
			NumeroContact contact = new NumeroContact(resultContact);
			this.getListNumeroContact().add(contact);
		}
	}

	

	public InputStream getData() 
	{
		// on charge le data
		if(data != null)
			return data;
		else
		{	
			try 
			{
				ResultSet result = SqlLiteInterface.SelectData(this.getId());
				result.next();
				this.data = result.getBinaryStream("data");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(NullPointerException npe)
			{
				
			}
		
		
		return data;
		}
	}


	public void setData(InputStream data) {
		this.data = data;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}






	public String getSource() {
		return source;
	}






	public void setSource(String source) {
		this.source = source;
	}






	public List<NumeroContact> getListNumeroContact() {
		return listNumeroContact;
	}



	public void setListNumeroContact(List<NumeroContact> listNumeroContact) {
		this.listNumeroContact = listNumeroContact;
	}



	public List<Methode> getListMethode() {
		return listMethode;
	}



	public void setListMethode(List<Methode> listMethode) {
		this.listMethode = listMethode;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public java.sql.Date getDateRir() {
		return dateRir;
	}



	public void setDateRir(java.sql.Date dateRir) {
		this.dateRir = dateRir;
	}



	public List<Drogue> getListDrogue() {
		return listDrogue;
	}

	public void setListDrogue(List<Drogue> listDrogue) {
		this.listDrogue = listDrogue;
	}

	public List<Quartier> getListQuartier() {
		return listQuartier;
	}

	public void setListQuartier(List<Quartier> listQuartier) {
		this.listQuartier = listQuartier;
	}

	public List<Personne> getListPersonne() {
		return listPersonne;
	}

	public void setListPersonne(List<Personne> listPersonne) {
		this.listPersonne = listPersonne;
	}

	public List<Mtp> getListMtp() {
		return listMtp;
	}

	public void setListMtp(List<Mtp> listMtp) {
		this.listMtp = listMtp;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	
	
}
