package guiRecherche;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class diaRechercheMtp extends diaBaseRecherche {
	private JTextField tMarque;
	private JTextField tImmatriculation;
	private JComboBox cCouleur;

	public diaRechercheMtp(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		JLabel lblNewLabel = new JLabel("Marque:");
		lblNewLabel.setBounds(10, 30, 100, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Immatriculation:");
		lblNewLabel_1.setBounds(10, 55, 100, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Couleur:");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		tMarque = new JTextField();
		tMarque.setBounds(120, 27, 200, 20);
		getContentPane().add(tMarque);
		tMarque.setColumns(10);
		
		tImmatriculation = new JTextField();
		tImmatriculation.setColumns(10);
		tImmatriculation.setBounds(120, 52, 200, 20);
		getContentPane().add(tImmatriculation);
		
		cCouleur = new JComboBox();
		cCouleur.setBounds(120, 77, 200, 20);
		getContentPane().add(cCouleur);
		// TODO Auto-generated constructor stub
	}

	public JTextField gettMarque() {
		return tMarque;
	}

	public JTextField gettImmatriculation() {
		return tImmatriculation;
	}

	public JComboBox getcCouleur() {
		return cCouleur;
	}
	
	
}
