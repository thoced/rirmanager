package guiRecherche;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class diaBaseRecherche extends JDialog {
	private JButton bRecherche;
	private JButton bAnnuler;

	public diaBaseRecherche(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setSize(800, 256);
		getContentPane().setLayout(null);
		bRecherche = new JButton("Rechercher");
		bRecherche.setBackground(SystemColor.activeCaption);
		bRecherche.setBounds(661, 184, 113, 23);
		getContentPane().add(bRecherche);
		
		bAnnuler = new JButton("Annuler");
		bAnnuler.setBackground(Color.PINK);
		bAnnuler.setBounds(536, 184, 115, 23);
		getContentPane().add(bAnnuler);
		
		this.setLocationRelativeTo(owner);
		
	}
	
	

	public JButton getbRecherche() {
		return bRecherche;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}
	
	

}
