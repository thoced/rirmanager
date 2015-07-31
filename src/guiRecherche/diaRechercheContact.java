package guiRecherche;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class diaRechercheContact extends diaBaseRecherche {
	private JTextField tContact;

	public diaRechercheContact(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		JLabel lblNewLabel = new JLabel("Num\u00E9ro de contact:");
		lblNewLabel.setBounds(10, 25, 140, 14);
		getContentPane().add(lblNewLabel);
		
		tContact = new JTextField();
		tContact.setBounds(160, 22, 160, 20);
		getContentPane().add(tContact);
		tContact.setColumns(10);
		
	}

	public JTextField gettContact() {
		return tContact;
	}
	
	
}
