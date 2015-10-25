package guiListRIR;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import model.Drogue;
import model.Methode;
import model.Mtp;
import model.NumeroContact;
import model.Personne;
import model.Quartier;
import model.Rir;
import model.SqlLiteInterface;
import java.awt.Font;
import javax.swing.UIManager;

public class CtrlListRir implements ActionListener,MouseListener
{
	private diaListRIR dia;
	
	private ModelTableRir modelRir;
	
	private Rir currentRir;
	
	public CtrlListRir()
	{
		dia = new diaListRIR(null,"List des RIR",true);
		dia.getTableListRir().setFont(UIManager.getFont("Table.font"));
		modelRir = new ModelTableRir();
		dia.getTableListRir().setModel(modelRir);
		dia.getTableListRir().addMouseListener(this);
		
		
		
		// bviewpdf
		dia.getbViewData().addActionListener(this);
		dia.getbViewData().setActionCommand("VIEWPDF");
		
		
		// affichage de la vue
		//dia.setVisible(true);
	}

	public void RechercheFromDrogue(String drogue)
	{
		modelRir.SelectFromDrogue(drogue);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	public void RechercheFromQuartier(String quartier)
	{
		modelRir.SelectFromQuartier(quartier);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	public void RechercheFromPersonne(String nom,String prenom,String surnom)
	{
		modelRir.SelectFromPersonne(nom, prenom, surnom);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	public void RechercheFromMtp(String marque,String immatriculation,String couleur)
	{
		modelRir.SelectFromMtp(marque, immatriculation, couleur);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	public void RechercheFromContact(String contact)
	{
		modelRir.SelectFromContact(contact);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	public void RechercheFromInfo(String info)
	{
		modelRir.SelectFromInfo(info);
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}
	
	
	public void RechercheAll()
	{
		dia.getTableListRir().updateUI();
		dia.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		

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
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		// on clic sur la liste, on va afficher les information
		
				int row = dia.getTableListRir().getSelectedRow();
				if(row != -1)
				{
					Rir rir = modelRir.SelectRir(row);
					currentRir = rir;
					
					if(rir != null)
					{
						// enable ou disable du bouton
						if(rir.getData() != null)
							dia.getbViewData().setEnabled(true);
						else
							dia.getbViewData().setEnabled(false);
						
						
						dia.gettNumero().setText(rir.getNumero());
						// 
						// création d'une date formaté
						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(rir.getDateRir().getTime());
						String formatString = "dd/MM/yyyy";
						SimpleDateFormat format = new SimpleDateFormat(formatString);
						dia.gettDate().setText(format.format(cal.getTime()));
						dia.gettEmission().setText(rir.getSource());
						StringBuilder builder = new StringBuilder();
						
						// quartier
						for(Quartier quartier : rir.getListQuartier())
						{
							builder.append(quartier.getNom() + System.lineSeparator());
						}
						dia.gettQuartier().setText(builder.toString());
						dia.gettQuartier().setCaretPosition(0);
						
						// drogue
						StringBuilder builder2 = new StringBuilder();
						for(Drogue drogue : rir.getListDrogue())
						{
							builder2.append(drogue.getType() + System.lineSeparator());
						}
						dia.gettDrogue().setText(builder2.toString());
						dia.gettDrogue().setCaretPosition(0); // pour forcer le composant a afficher le premier element
						
						// Methode
						StringBuilder builder3 = new StringBuilder();
						for(Methode	methode : rir.getListMethode())
						{
							builder3.append(methode.getMethode() + System.lineSeparator());
						}
						dia.gettMethode().setText(builder3.toString());
						dia.gettMethode().setCaretPosition(0);
						
						// Personne
						StringBuilder builder4 = new StringBuilder();
						for(Personne personne : rir.getListPersonne())
						{
							builder4.append(personne + System.lineSeparator());
						}
						dia.gettPersonne().setText(builder4.toString());
						dia.gettPersonne().setCaretPosition(0);
						// Mtp
						StringBuilder builder5 = new StringBuilder();
						for(Mtp mtp : rir.getListMtp())
						{
							builder5.append(mtp + System.lineSeparator());
						}
						dia.gettMtp().setText(builder5.toString());
						dia.gettMtp().setCaretPosition(0);
						// Contact
						StringBuilder builder6 = new StringBuilder();
						for(NumeroContact contact : rir.getListNumeroContact())
						{
							builder6.append(contact + System.lineSeparator());
						}
						dia.gettContact().setText(builder6.toString());
						dia.gettContact().setCaretPosition(0);
						
						// source
						dia.gettNatureInfo().setText(rir.getNature());
						dia.gettNatureInfo().setCaretPosition(0);
						
					}
				}
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "VIEWPDF":
				try {
					
					File f = File.createTempFile("RIR-" + currentRir.getDateRir().toString() + "-", ".pdf");
					f.deleteOnExit();
					FileOutputStream fos = new FileOutputStream(f);
					byte[] buffer = new byte[currentRir.getData().available()];
					currentRir.getData().read(buffer,0,currentRir.getData().available());
					fos.write(buffer, 0, buffer.length);
					fos.flush();
					fos.close();
					Desktop.getDesktop().open(f);
					break;
	
					
			} 
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
			
			
		}
	}


	


	/*@Override
	public void focusLost(FocusEvent arg0) 
	{
		// quand le focus est perdu sur la date haute ou basse, on refait une recherche
		//String dateBasse = dia.gettDateBasse().getText().trim();
		//String dateHaute = dia.gettDateHaute().getText().trim();
		
		if(dateBasse != null && dateHaute != null)
		{
			String[] chaineBasse = dateBasse.split("/");
			String[] chaineHaute = dateHaute.split("/");
			
			if(chaineBasse.length == 3 && chaineHaute.length == 3)
			{
				int dayB = Integer.parseInt(chaineBasse[0].trim());
				int monthB = Integer.parseInt(chaineBasse[1].trim());
				int yearB = Integer.parseInt(chaineBasse[2].trim());
				
				int dayH = Integer.parseInt(chaineHaute[0].trim());
				int monthH = Integer.parseInt(chaineHaute[1].trim());
				int yearH = Integer.parseInt(chaineHaute[2].trim());
				
				// création des calendar
				Calendar calB = Calendar.getInstance();
				Calendar calH = Calendar.getInstance();
				
				calB.set(yearB, monthB - 1, dayB);
				calH.set(yearH, monthH - 1, dayH);
				
				// creation des dates sql
				Date dateB = new Date(calB.getTimeInMillis());
				Date dateH = new Date(calH.getTimeInMillis());
				
				// refresh du model
				modelRir.SelectWidthDate(dateB, dateH);
				// refresh
				dia.getTableListRir().updateUI();
			}
		}
		
	}*/
}
