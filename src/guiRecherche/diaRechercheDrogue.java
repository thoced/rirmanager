package guiRecherche;

import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class diaRechercheDrogue extends diaBaseRecherche {
	private JRadioButton rCannabis;
	private JRadioButton rSynthese;
	private JRadioButton rCocaine;
	private JRadioButton rHeroine;
	private JRadioButton rIndetermine;
	private ButtonGroup group;

	public diaRechercheDrogue(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		rCocaine = new JRadioButton("Coca\u00EFne");
		rCocaine.setActionCommand("COCAINE");
		rCocaine.setBounds(6, 25, 156, 23);
		getContentPane().add(rCocaine);
		
		rHeroine = new JRadioButton("Hero\u00EFne");
		rHeroine.setActionCommand("HEROINE");
		rHeroine.setBounds(6, 51, 156, 23);
		getContentPane().add(rHeroine);
		
		rCannabis = new JRadioButton("Cannabis");
		rCannabis.setActionCommand("CANNABIS");
		rCannabis.setBounds(6, 77, 156, 23);
		getContentPane().add(rCannabis);
		
		rSynthese = new JRadioButton("Drogue de Synth\u00E8se");
		rSynthese.setActionCommand("SYNTHESE");
		rSynthese.setBounds(6, 103, 156, 23);
		getContentPane().add(rSynthese);
		
				
		rIndetermine = new JRadioButton("Ind\u00E9terminer");
		rIndetermine.setActionCommand("INDETERMINER");
		rIndetermine.setBounds(6, 129, 109, 23);
		getContentPane().add(rIndetermine);
		// TODO Auto-generated constructor stub
		
		group = new ButtonGroup();
		group.add(rCocaine);
		group.add(rHeroine);
		group.add(rCannabis);
		group.add(rSynthese);
		group.add(rIndetermine);
	}


	public ButtonGroup getGroup() {
		return group;
	}
	

	
}
