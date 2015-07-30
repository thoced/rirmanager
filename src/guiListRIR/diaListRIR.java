package guiListRIR;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class diaListRIR extends JDialog 
{
	private JTable tableListRir;
	private JTextField tNumero;
	private JTextField tDate;
	private JTextField tEmission;
	private JLabel lblNewLabel_2;
	private JTextArea tQuartier;
	private JTextArea tDrogue;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_3;
	private JTextArea tMethode;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane_4;
	private JTextArea tPersonne;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane_5;
	private JTextArea tMtp;
	private JLabel lblNewLabel_7;
	private JScrollPane scrollPane_6;
	private JTextArea tContact;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_7;
	private JTextArea tNatureInfo;
	private JButton bViewData;
	public diaListRIR(Frame frame,String title,boolean modal)
	{
		super(frame,title,modal);
		this.setSize(1000, 800);
		getContentPane().setLayout(null);
		
		tableListRir = new JTable();
		tableListRir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableListRir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(tableListRir);
		scrollPane.setBounds(35, 11, 400, 740);
		getContentPane().add(scrollPane);
		
		MaskFormatter dateBasseFormatter;
		try {
			dateBasseFormatter = new MaskFormatter(" ## / ## / #### ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			MaskFormatter dateHauteFormatter = new MaskFormatter(" ## / ## / #### ");
			
			JPanel panelInfo = new JPanel();
			panelInfo.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfo.setBounds(445, 11, 481, 740);
			getContentPane().add(panelInfo);
			panelInfo.setLayout(null);
			
			JLabel lblNumero = new JLabel("Numero:");
			lblNumero.setBounds(10, 25, 100, 14);
			panelInfo.add(lblNumero);
			
			JLabel lblNewLabel = new JLabel("Date:");
			lblNewLabel.setBounds(10, 50, 100, 14);
			panelInfo.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Emission:");
			lblNewLabel_1.setBounds(10, 75, 100, 14);
			panelInfo.add(lblNewLabel_1);
			
			tNumero = new JTextField();
			tNumero.setEditable(false);
			tNumero.setBounds(120, 22, 200, 20);
			panelInfo.add(tNumero);
			tNumero.setColumns(10);
			
			tDate = new JTextField();
			tDate.setEditable(false);
			tDate.setBounds(120, 47, 200, 20);
			panelInfo.add(tDate);
			tDate.setColumns(10);
			
			tEmission = new JTextField();
			tEmission.setEditable(false);
			tEmission.setBounds(120, 72, 200, 20);
			panelInfo.add(tEmission);
			tEmission.setColumns(10);
			
			lblNewLabel_2 = new JLabel("Quartier(s):");
			lblNewLabel_2.setBounds(10, 100, 100, 14);
			panelInfo.add(lblNewLabel_2);
			
			tQuartier = new JTextArea();
			tQuartier.setEditable(false);
			JScrollPane scrollPane_1 = new JScrollPane(tQuartier);
			scrollPane_1.setBounds(120, 103, 200, 60);
			panelInfo.add(scrollPane_1);
			
			JLabel lblNewLabel_3 = new JLabel("Drogue(s):");
			lblNewLabel_3.setBounds(10, 177, 100, 14);
			panelInfo.add(lblNewLabel_3);
			
			tDrogue = new JTextArea();
			tDrogue.setEditable(false);
			JScrollPane scrollPane_2 = new JScrollPane(tDrogue);
			scrollPane_2.setBounds(120, 174, 200, 60);
			panelInfo.add(scrollPane_2);
			
			lblNewLabel_4 = new JLabel("Methode(s):");
			lblNewLabel_4.setBounds(10, 246, 100, 14);
			panelInfo.add(lblNewLabel_4);
			
			tMethode = new JTextArea();
			scrollPane_3 = new JScrollPane(tMethode);
			scrollPane_3.setBounds(120, 245, 200, 60);
			panelInfo.add(scrollPane_3);
			
			lblNewLabel_5 = new JLabel("Personne(s):");
			lblNewLabel_5.setBounds(10, 315, 100, 14);
			panelInfo.add(lblNewLabel_5);
			
			tPersonne = new JTextArea();
			tPersonne.setEditable(false);
			scrollPane_4 = new JScrollPane(tPersonne);
			scrollPane_4.setBounds(120, 315, 351, 60);
			panelInfo.add(scrollPane_4);
			
			lblNewLabel_6 = new JLabel("Mtp:");
			lblNewLabel_6.setBounds(10, 385, 100, 14);
			panelInfo.add(lblNewLabel_6);
			
			tMtp = new JTextArea();
			scrollPane_5 = new JScrollPane(tMtp);
			scrollPane_5.setBounds(120, 386, 351, 60);
			panelInfo.add(scrollPane_5);
			
			lblNewLabel_7 = new JLabel("Num contact:");
			lblNewLabel_7.setBounds(10, 459, 100, 14);
			panelInfo.add(lblNewLabel_7);
			
			tContact = new JTextArea();
			scrollPane_6 = new JScrollPane(tContact);
			scrollPane_6.setBounds(119, 457, 201, 60);
			panelInfo.add(scrollPane_6);
			
			lblNewLabel_8 = new JLabel("Info:");
			lblNewLabel_8.setBounds(10, 539, 100, 14);
			panelInfo.add(lblNewLabel_8);
			
			tNatureInfo = new JTextArea();
			tNatureInfo.setLineWrap(true);
			tNatureInfo.setColumns(25);
			scrollPane_7 = new JScrollPane(tNatureInfo);
			scrollPane_7.setBounds(120, 539, 351, 190);
			panelInfo.add(scrollPane_7);
			
			bViewData = new JButton("View PDF");
			bViewData.setEnabled(false);
			bViewData.setBackground(SystemColor.activeCaption);
			bViewData.setFont(new Font("Tahoma", Font.PLAIN, 12));
			bViewData.setBounds(10, 615, 89, 60);
			panelInfo.add(bViewData);
					
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ;
		
		
		
		
		this.setLocationRelativeTo(null);
		
		
	}
	
	



	public JButton getbViewData() {
		return bViewData;
	}


	public JTextArea gettNatureInfo() {
		return tNatureInfo;
	}


	public JTextArea gettContact() {
		return tContact;
	}


	public JTextArea gettMtp() {
		return tMtp;
	}


	public JTextArea gettPersonne() {
		return tPersonne;
	}

	public JTextArea gettMethode() {
		return tMethode;
	}

	public JTable getTableListRir() {
		return tableListRir;
	}
	
	public JTextField gettNumero() {
		return tNumero;
	}
	public JTextField gettDate() {
		return tDate;
	}
	public JTextField gettEmission() {
		return tEmission;
	}
	public JTextArea gettQuartier() {
		return tQuartier;
	}
	public JTextArea gettDrogue() {
		return tDrogue;
	}
}
