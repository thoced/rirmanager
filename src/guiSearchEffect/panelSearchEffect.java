package guiSearchEffect;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;

public class panelSearchEffect extends JPanel 
{
	private JTable tableContact;
	private JTable tablePersonne;
	private JScrollPane scrollPane_2;
	private JTable tableMtp;
	

	public panelSearchEffect()
	{
		super();
		setBackground(Color.GRAY);
		this.setSize(800,187);
		
		tableContact = new JTable();
		tableContact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContact.setBackground(UIManager.getColor("inactiveCaption"));
		JScrollPane scrollPane = new JScrollPane(tableContact);
		
		tablePersonne = new JTable();
		tablePersonne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane_1 = new JScrollPane(tablePersonne);
		
		tableMtp = new JTable();
		tableMtp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2 = new JScrollPane(tableMtp);
		
		setLayout(new MigLayout("", "[256px][256px][262.00px]", "[128px]"));
		add(scrollPane, "cell 0 0,grow");
		add(scrollPane_1, "cell 1 0,grow");
		add(scrollPane_2, "cell 2 0,grow");
	
		
	
	}

	public JTable getTableContact() {
		return tableContact;
	}

	public JTable getTablePersonne() {
		return tablePersonne;
	}

	public JTable getTableMtp() {
		return tableMtp;
	}

}
