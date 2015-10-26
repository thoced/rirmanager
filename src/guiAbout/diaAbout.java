package guiAbout;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.Font;

public class diaAbout extends JDialog
{

	public diaAbout(Frame arg0, String arg1, boolean arg2) 
	{
		super(arg0, arg1, arg2);
		
		this.setSize(800, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Au sujet de RirDrugsManager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 764, 340);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(626, 201, 128, 128);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(diaAbout.class.getResource("/Textures/logomin.png")));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEnabled(false);
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editorPane.setText("Rir Drugs Manager permet l'encodage, la gestion et l'analyse des informations contenues dans les Rapports d'informations."); 
		editorPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(10, 28, 591, 268);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Programm\u00E9 par THONON C\u00E9dric");
		lblNewLabel_1.setBounds(10, 307, 280, 14);
		panel.add(lblNewLabel_1);
		
	
		
		this.setLocationRelativeTo(this.getOwner());
	
	}
}
