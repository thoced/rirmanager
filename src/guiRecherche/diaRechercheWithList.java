package guiRecherche;

import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class diaRechercheWithList extends diaBaseRecherche {
	private JList list;

	public diaRechercheWithList(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(25, 11, 300, 100);
		getContentPane().add(scrollPane);
	}

	public JList getList() {
		return list;
	}


	
}
