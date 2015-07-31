package model;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class SqlLiteInterface
{
	private static Connection connection;
	private static Driver driver;
	
	private static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		
	
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/db_rir","test","bombe123");
		//driver = DriverManager.getDriver("jdbc:sqlite:test.db");
		
		/*Class.forName("org.sqlite.JDBC");
		
		
		connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		driver = DriverManager.getDriver("jdbc:sqlite:test.db");*/
		
		return connection;
	}
	
	public static void close() throws SQLException
	{
		if(connection != null && !connection.isClosed())
		{
			connection.close();
			//DriverManager.deregisterDriver(driver);
			
		}

	}
	
	public void finalize() throws SQLException
	{
		close();	
	}
	
	public void prepareSchemaSQLLITE() throws ClassNotFoundException, SQLException
	{
		String sql = "create table IF NOT EXISTS t_rir (id INTEGER PRIMARY KEY AUTO_INCREMENT , "
				+ "daterir DATE,"
				+ "numero VARCHAR(64),"
				+ "nature TEXT,"
				+ "data BLOB,"
				+ "source VARCHAR(64))";
		
		String sql_quartier = "create table IF NOT EXISTS t_quartier (quartier VARCHAR(64) UNIQUE)";
		
		String sql_drogue = "create table IF NOT EXISTS t_drogue (drogue VARCHAR(64) UNIQUE)";
		
		String sql_personne = "create table IF NOT EXISTS t_personne (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "nom VARCHAR(64),"
				+ "prenom VARCHAR(64),"
				+ "datenaissance DATE,"
				+ "surnom VARCHAR(64),"
				+ "ref_rir INTEGER,"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		String sql_mtp = "create table IF NOT EXISTS t_mtp (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "marque VARCHAR(64),"
				+ "immatriculation VARCHAR(64),"
				+ "couleur VARCHAR(64),"
				+ "ref_rir INTEGER,"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		String sql_couleur = "create table IF NOT EXISTS t_couleur (couleur VARCHAR(64) UNIQUE)";
		
		String sql_methode = "create table IF NOT EXISTS t_methode (methode VARCHAR(64) UNIQUE)";
		
		String sql_source = "create table IF NOT EXISTS t_source (source VARCHAR(64) UNIQUE)";
		
		
				
		// creation des tables de link
		
		String sql_link_quartier = "create table IF NOT EXISTS t_link_quartier (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_quartier VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_quartier) REFERENCES t_quartier(quartier))";
		
		String sql_link_drogue = "create table IF NOT EXISTS t_link_drogue (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_drogue VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_drogue) REFERENCES t_drogue(drogue))";
		
				
		String sql_link_methode = "create table IF NOT EXISTS t_link_methode (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_methode VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_methode) REFERENCES t_methode(methode))";
		
		String sql_contact = "create table IF NOT EXISTS t_contact (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "contact VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		Statement st =  this.getConnection().createStatement();
	
		
		st.executeUpdate(sql);
		// creation de la table quartier
		st.executeUpdate(sql_quartier);
		// creation de la table drogue
		st.executeUpdate(sql_drogue);
		// creation de la table personne
		st.executeUpdate(sql_personne);
		// creation de la table mtp
		st.executeUpdate(sql_mtp);
		// creation de la table couleur
		st.executeUpdate(sql_couleur);
		// creation de la table methode
		st.executeUpdate(sql_methode);
		// creation de la table source
		st.executeUpdate(sql_source);
		// creation de la table link quartier
		st.executeUpdate(sql_link_quartier);
		// creation de la table link drogue
		st.executeUpdate(sql_link_drogue);
		// creation de la table link_methode
		st.executeUpdate(sql_link_methode);
		// creation de la table contact
		st.executeUpdate(sql_contact);
		
		// update des tables quartier et drogue
		
		try
		{
			st.executeUpdate("insert into t_quartier (quartier) values('Pairay')");
			st.executeUpdate("insert into t_quartier (quartier) values('Ougrée')");
			st.executeUpdate("insert into t_quartier (quartier) values('Jemeppe')");
			st.executeUpdate("insert into t_quartier (quartier) values('Neupré')");
			st.executeUpdate("insert into t_quartier (quartier) values('Indéterminé')");
			st.executeUpdate("insert into t_quartier (quartier) values('Liège')");
			
			st.executeUpdate("insert into t_drogue (drogue) values('Cannabis')");
			st.executeUpdate("insert into t_drogue (drogue) values('Cocaïne')");
			st.executeUpdate("insert into t_drogue (drogue) values('Heroïne')");
			st.executeUpdate("insert into t_drogue (drogue) values('Drogue de Synthèse')");
			st.executeUpdate("insert into t_drogue (drogue) values('Indéterminé')");
			
			st.executeUpdate("insert into t_methode (methode) values('Vente')");
			st.executeUpdate("insert into t_methode (methode) values('Détention')");
			st.executeUpdate("insert into t_methode (methode) values('Fabrication')");
			st.executeUpdate("insert into t_methode (methode) values('Culture')");
			st.executeUpdate("insert into t_methode (methode) values('Indéterminé')");
			
			st.executeUpdate("insert into t_couleur (couleur) values('Blanc')");
			st.executeUpdate("insert into t_couleur (couleur) values('Noir')");
			st.executeUpdate("insert into t_couleur (couleur) values('Gris')");
			st.executeUpdate("insert into t_couleur (couleur) values('Rouge')");
			st.executeUpdate("insert into t_couleur (couleur) values('Vin')");
			st.executeUpdate("insert into t_couleur (couleur) values('Jaune')");
			st.executeUpdate("insert into t_couleur (couleur) values('Vert')");
			st.executeUpdate("insert into t_couleur (couleur) values('Bleu')");
			
			st.executeUpdate("insert into t_source (source) values('ZP Seraing-Neupré')");
			st.executeUpdate("insert into t_source (source) values('ZP Liège')");
			st.executeUpdate("insert into t_source (source) values('ZP Secova')");
			st.executeUpdate("insert into t_source (source) values('ZP Grace-Hollogne / Awans')");
			st.executeUpdate("insert into t_source (source) values('ZP Flémalle')");
			st.executeUpdate("insert into t_source (source) values('ZP Fléron')");
			st.executeUpdate("insert into t_source (source) values('PJF Liège')");
			st.executeUpdate("insert into t_source (source) values('PJF (Autres)')");
			st.executeUpdate("insert into t_source (source) values('DGJ')");
			
		
			
			
		}
		catch(SQLException sqle)
		{
			
		}
		
		
	}
	
	public void prepareSchemaMYSQL() throws ClassNotFoundException, SQLException
	{
		String sql = "create table IF NOT EXISTS t_rir (id INTEGER PRIMARY KEY AUTO_INCREMENT , "
				+ "daterir DATE,"
				+ "numero VARCHAR(64),"
				+ "nature TEXT,"
				+ "data LONGBLOB,"
				+ "source VARCHAR(64))";
		
		String sql_quartier = "create table IF NOT EXISTS t_quartier (quartier VARCHAR(64) UNIQUE)";
		
		String sql_drogue = "create table IF NOT EXISTS t_drogue (drogue VARCHAR(64) UNIQUE)";
		
		String sql_personne = "create table IF NOT EXISTS t_personne (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "nom VARCHAR(64),"
				+ "prenom VARCHAR(64),"
				+ "datenaissance DATE,"
				+ "surnom VARCHAR(64),"
				+ "ref_rir INTEGER,"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		String sql_mtp = "create table IF NOT EXISTS t_mtp (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "marque VARCHAR(64),"
				+ "immatriculation VARCHAR(64),"
				+ "couleur VARCHAR(64),"
				+ "ref_rir INTEGER,"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		String sql_couleur = "create table IF NOT EXISTS t_couleur (couleur VARCHAR(64) UNIQUE)";
		
		String sql_methode = "create table IF NOT EXISTS t_methode (methode VARCHAR(64) UNIQUE)";
		
		String sql_source = "create table IF NOT EXISTS t_source (source VARCHAR(64) UNIQUE)";
		
		
				
		// creation des tables de link
		
		String sql_link_quartier = "create table IF NOT EXISTS t_link_quartier (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_quartier VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_quartier) REFERENCES t_quartier(quartier))";
		
		String sql_link_drogue = "create table IF NOT EXISTS t_link_drogue (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_drogue VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_drogue) REFERENCES t_drogue(drogue))";
		
				
		String sql_link_methode = "create table IF NOT EXISTS t_link_methode (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "ref_methode VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id),"
				+ "FOREIGN KEY(ref_methode) REFERENCES t_methode(methode))";
		
		String sql_contact = "create table IF NOT EXISTS t_contact (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "ref_rir INTEGER,"
				+ "contact VARCHAR(64),"
				+ "FOREIGN KEY(ref_rir) REFERENCES t_rir(id))";
		
		Statement st =  this.getConnection().createStatement();
	
		
		st.executeUpdate(sql);
		// creation de la table quartier
		st.executeUpdate(sql_quartier);
		// creation de la table drogue
		st.executeUpdate(sql_drogue);
		// creation de la table personne
		st.executeUpdate(sql_personne);
		// creation de la table mtp
		st.executeUpdate(sql_mtp);
		// creation de la table couleur
		st.executeUpdate(sql_couleur);
		// creation de la table methode
		st.executeUpdate(sql_methode);
		// creation de la table source
		st.executeUpdate(sql_source);
		// creation de la table link quartier
		st.executeUpdate(sql_link_quartier);
		// creation de la table link drogue
		st.executeUpdate(sql_link_drogue);
		// creation de la table link_methode
		st.executeUpdate(sql_link_methode);
		// creation de la table contact
		st.executeUpdate(sql_contact);
		
		// update des tables quartier et drogue
		
		try
		{
			st.executeUpdate("insert into t_quartier (quartier) values('Pairay')");
			st.executeUpdate("insert into t_quartier (quartier) values('Ougrée')");
			st.executeUpdate("insert into t_quartier (quartier) values('Jemeppe')");
			st.executeUpdate("insert into t_quartier (quartier) values('Neupré')");
			st.executeUpdate("insert into t_quartier (quartier) values('Indéterminé')");
			st.executeUpdate("insert into t_quartier (quartier) values('Liège')");
			
			st.executeUpdate("insert into t_drogue (drogue) values('Cannabis')");
			st.executeUpdate("insert into t_drogue (drogue) values('Cocaïne')");
			st.executeUpdate("insert into t_drogue (drogue) values('Heroïne')");
			st.executeUpdate("insert into t_drogue (drogue) values('Drogue de Synthèse')");
			st.executeUpdate("insert into t_drogue (drogue) values('Indéterminé')");
			
			st.executeUpdate("insert into t_methode (methode) values('Vente')");
			st.executeUpdate("insert into t_methode (methode) values('Détention')");
			st.executeUpdate("insert into t_methode (methode) values('Fabrication')");
			st.executeUpdate("insert into t_methode (methode) values('Culture')");
			st.executeUpdate("insert into t_methode (methode) values('Indéterminé')");
			
			st.executeUpdate("insert into t_couleur (couleur) values('Blanc')");
			st.executeUpdate("insert into t_couleur (couleur) values('Noir')");
			st.executeUpdate("insert into t_couleur (couleur) values('Gris')");
			st.executeUpdate("insert into t_couleur (couleur) values('Rouge')");
			st.executeUpdate("insert into t_couleur (couleur) values('Vin')");
			st.executeUpdate("insert into t_couleur (couleur) values('Jaune')");
			st.executeUpdate("insert into t_couleur (couleur) values('Vert')");
			st.executeUpdate("insert into t_couleur (couleur) values('Bleu')");
			
			st.executeUpdate("insert into t_source (source) values('ZP Seraing-Neupré')");
			st.executeUpdate("insert into t_source (source) values('ZP Liège')");
			st.executeUpdate("insert into t_source (source) values('ZP Secova')");
			st.executeUpdate("insert into t_source (source) values('ZP Grace-Hollogne / Awans')");
			st.executeUpdate("insert into t_source (source) values('ZP Flémalle')");
			st.executeUpdate("insert into t_source (source) values('ZP Fléron')");
			st.executeUpdate("insert into t_source (source) values('PJF Liège')");
			st.executeUpdate("insert into t_source (source) values('PJF (Autres)')");
			st.executeUpdate("insert into t_source (source) values('DGJ')");
			
		
			
			
		}
		catch(SQLException sqle)
		{
			
		}
		
		
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if(connection == null || connection.isClosed())
			return doConnection();
		else
			return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static void insertRir(Rir rir)
	{
		String sql = "insert into t_rir (daterir,numero,nature,data,source) values (?,?,?,?,?)";
	
		InputStream fis = null;
		PreparedStatement st;
		
		try {
			
			// on force le autocommit à falsed pour avoir une opération atomique
			getConnection().setAutoCommit(false);
			
			
			if(rir.getPathFile() != null)
			{
				fis = new FileInputStream(rir.getPathFile());
			}
			else
				fis = null;
			
			st = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, rir.getDateRir());
			st.setString(2, rir.getNumero());
			st.setString(3, rir.getNature());
			
		
			if(fis!=null)
				st.setBinaryStream(4, fis,fis.available());
			else
				st.setBinaryStream(4, null);
			
			// source
			st.setString(5, rir.getSource());
			
			int key = st.executeUpdate();
			ResultSet  result = st.getGeneratedKeys();
			if(result.next())
			{
				// insert des quartiers
				String sqlQuartier = "insert into t_link_quartier (ref_rir,ref_quartier) values (?,?)";
				
	
				for(Quartier quartier : rir.getListQuartier())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlQuartier);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, quartier.getNom());
					ps.executeUpdate();
				}
				
				// insert des drogues
				String sqlDrogue = "insert into t_link_drogue (ref_rir,ref_drogue) values (?,?)";
				
				for(Drogue drogue : rir.getListDrogue())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlDrogue);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, drogue.getType());
					ps.executeUpdate();
				}
				
				// insert des methodes
				String sqlMethode = "insert into t_link_methode (ref_rir,ref_methode) values (?,?)";
				
				for(Methode methode : rir.getListMethode())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlMethode);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, methode.getMethode());
					ps.executeUpdate();
				}
				
				// insert des numéro de contact
				String sqlContact = "insert into t_contact (ref_rir,contact) values (?,?)";
				
				for(NumeroContact contact : rir.getListNumeroContact())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlContact);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, contact.getNumero());
					ps.executeUpdate();
				}
				
				// insert des personnes
				String sqlPersonne = "insert into t_personne (ref_rir,nom,prenom,datenaissance,surnom) values (?,?,?,?,?)";
			
				for(Personne personne : rir.getListPersonne())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlPersonne);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, personne.getNom());
					ps.setString(3, personne.getPrenom());
					String[] dateNaissance = personne.getDateNaissance().trim().split("/");
					
					Calendar cal = Calendar.getInstance();
					int year = Integer.valueOf(dateNaissance[2].trim());
					int month = Integer.valueOf(dateNaissance[1].trim());
					int day = Integer.valueOf(dateNaissance[0].trim());
					
					// création du calendar
					cal.set(year, month - 1, day);
					// création du date sql
					java.sql.Date dateSql = new java.sql.Date(cal.getTimeInMillis());
					// set
					ps.setDate(4, dateSql);
					// set du surnom
					ps.setString(5, personne.getSurnom());
					ps.executeUpdate();
					
				}
				
				// insert des moyens de transport
				
				String sqlMtp = "insert into t_mtp (ref_rir,marque,immatriculation,couleur) values (?,?,?,?)";
				
				for(Mtp mtp : rir.getListMtp())
				{
					PreparedStatement ps = getConnection().prepareStatement(sqlMtp);
					ps.setInt(1, result.getInt(1));
					ps.setString(2, mtp.getMarque());
					ps.setString(3, mtp.getImmatriculation());
					ps.setString(4, mtp.getCouleur());
					ps.executeUpdate();
				}
				
				// commit de l'ensemble de la séquence
				getConnection().commit();
			
			}
				
			// on replace l'auto commit à true
			getConnection().setAutoCommit(true);
			
			
			if(fis!=null)
				fis.close();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			getConnection().setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static ResultSet SelectAllQuartier() throws ClassNotFoundException, SQLException
	{
		String sql = "select quartier from t_quartier order by quartier DESC";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}
	
	public static ResultSet SelectAllDrogue() throws ClassNotFoundException, SQLException
	{
		String sql = "select drogue from t_drogue order by drogue DESC";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}
	
	public static ResultSet SelectAllMethode() throws ClassNotFoundException, SQLException
	{
		String sql = "select methode from t_methode";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}

	public static ResultSet SelectAllCouleur() throws ClassNotFoundException, SQLException
	{
		String sql = "select couleur from t_couleur";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}

	public static ResultSet SelectAllSource() throws ClassNotFoundException, SQLException
	{
		String sql = "select source from t_source";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}
	
	public static ResultSet SelectAllRir() throws ClassNotFoundException, SQLException
	{
		String sql = "select id,daterir,numero,nature,source from t_rir order by daterir desc";
		
		Statement st = getConnection().createStatement();
		
		return st.executeQuery(sql);
	}
	
	public static ResultSet SelectRirWidthDate(Date b,Date h) throws SQLException, ClassNotFoundException
	{
		String sql = "select id,daterir,numero,nature,source from t_rir WHERE daterir BETWEEN ? AND ? order by daterir desc";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setDate(1, b);
		ps.setDate(2, h);
		
		return ps.executeQuery();
		

	}
	
	
	public static ResultSet SelectQuartier(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_link_quartier where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	
	public static ResultSet SelectDrogues(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_link_drogue where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	public static ResultSet SelectMethodes(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_link_methode where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	
	public static ResultSet SelectPersonnes(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_personne where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	public static ResultSet SelectMtp(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_mtp where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	
	public static ResultSet SelectContact(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select * from t_contact where ref_rir = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
	}
	
	public static ResultSet SelectData(int idRir) throws ClassNotFoundException, SQLException
	{
		String sql = "select data from t_rir where id = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, idRir);
		
		return ps.executeQuery();
		
	}
	
	public static ResultSet SelectRirFromInfo(String info) throws ClassNotFoundException, SQLException
	{
		info = "%" + info + "%";
		
		String sql = "select id,daterir,numero,nature,source from t_rir where nature like ? ";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, info);
		
		
		return ps.executeQuery();
		
		
		
	}
	public static ResultSet SelectRirFromDrogue(String drogue) throws ClassNotFoundException, SQLException
	{
		String sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_link_drogue ON t_rir.id = t_link_drogue.ref_rir where ref_drogue = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, drogue);
		
		
		return ps.executeQuery();
		
		
		
	}
	
	public static ResultSet SelectRirFromQuartier(String quartier) throws ClassNotFoundException, SQLException
	{
		String sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_link_quartier ON t_rir.id = t_link_quartier.ref_rir where ref_quartier = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, quartier);
		
		
		return ps.executeQuery();
		
		
		
	}
	
	public static ResultSet SelectRirFromPersonne(String nom,String prenom,String surnom) throws ClassNotFoundException, SQLException
	{
		String sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_personne ON t_rir.id = t_personne.ref_rir where nom = ? OR prenom = ? OR surnom = ? AND nom <> '' AND prenom <> '' AND surnom <> ''";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setString(3, surnom);
		
		
		return ps.executeQuery();
		
		
		
	}
	
	public static ResultSet SelectRirFromMtp(String marque,String immatriculation,String couleur) throws ClassNotFoundException, SQLException
	{
		marque = "%" + marque + "%";
		
		String sql;
		if(immatriculation.length() > 0)
		{
			 sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_mtp ON t_rir.id = t_mtp.ref_rir where marque like ? OR immatriculation = ? OR couleur = ? AND marque <> '' AND immatriculation <> '' AND couleur <> ''";
			 	PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, marque);
				ps.setString(2, immatriculation);
				ps.setString(3, couleur);
				return ps.executeQuery();
		}
		else
		{
			sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_mtp ON t_rir.id = t_mtp.ref_rir where marque like ? OR couleur = ?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, marque);
				ps.setString(2, couleur);
				return ps.executeQuery();
		}
		
		
	}
	
	public static ResultSet SelectRirFromContact(String contact) throws ClassNotFoundException, SQLException
	{
		contact = "%" + contact + "%";
		
		String sql = "select t_rir.id,daterir,numero,nature,source from t_rir INNER JOIN t_contact ON t_rir.id = t_contact.ref_rir where contact like ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, contact);
		return ps.executeQuery();
	}
	
}
