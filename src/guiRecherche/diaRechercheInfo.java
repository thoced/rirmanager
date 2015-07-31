package guiRecherche;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class diaRechercheInfo extends diaBaseRecherche {
	private JLabel lblElmentRechercher;
	private JScrollPane scrollPane;
	private JTextArea tInfo;

	public diaRechercheInfo(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		lblElmentRechercher = new JLabel("El\u00E9ment \u00E0 rechercher:");
		lblElmentRechercher.setBounds(10, 25, 150, 14);
		getContentPane().add(lblElmentRechercher);
		
		tInfo = new JTextArea();
		scrollPane = new JScrollPane(tInfo);
		scrollPane.setBounds(176, 25, 367, 68);
		getContentPane().add(scrollPane);
		
	
	}

	public JTextArea gettInfo() {
		return tInfo;
	}
	
	
}
