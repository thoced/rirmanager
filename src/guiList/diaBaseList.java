package guiList;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class diaBaseList extends JDialog 
{
	private JTable tableList;

	public diaBaseList(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setSize(629, 590);
		getContentPane().setLayout(null);
		
		tableList = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(32, 34, 536, 478);
		getContentPane().add(scrollPane);
		
	
	}
}
