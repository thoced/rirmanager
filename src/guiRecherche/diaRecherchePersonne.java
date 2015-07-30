package guiRecherche;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class diaRecherchePersonne extends diaBaseRecherche {
	private JTextField tNom;
	private JTextField tPrenom;
	private JTextField tSurnom;

	public diaRecherchePersonne(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setBounds(10, 60, 100, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom:");
		lblNewLabel_1.setBounds(10, 87, 100, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surnom:");
		lblNewLabel_2.setBounds(10, 112, 100, 14);
		getContentPane().add(lblNewLabel_2);
		
		tNom = new JTextField();
		tNom.setBounds(110, 57, 200, 20);
		getContentPane().add(tNom);
		tNom.setColumns(10);
		
		tPrenom = new JTextField();
		tPrenom.setColumns(10);
		tPrenom.setBounds(110, 81, 200, 20);
		getContentPane().add(tPrenom);
		
		tSurnom = new JTextField();
		tSurnom.setColumns(10);
		tSurnom.setBounds(110, 107, 200, 20);
		getContentPane().add(tSurnom);
		// TODO Auto-generated constructor stub
	}

	public JTextField gettNom() {
		return tNom;
	}

	public JTextField gettPrenom() {
		return tPrenom;
	}

	public JTextField gettSurnom() {
		return tSurnom;
	}
	
	
}
