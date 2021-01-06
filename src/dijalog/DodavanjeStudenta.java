package dijalog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentiController;
import model.Student;

public class DodavanjeStudenta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3978453336369063755L;
	

	int[] popunjeno;
	int i;
	boolean prazan = false;
	boolean tacan_datum = true;
	boolean tacna_godina = true;
	public DodavanjeStudenta(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		
		setSize(sirina*1/2, visina*3/4);
		setLocationRelativeTo(parent);
		
		
		JPanel panel = new JPanel();
		Dimension dim = new Dimension(320, 30);
		Dimension dim1 = new Dimension(120,20);
		
		popunjeno = new int[8];
		for(int i = 0; i < 8; i++) {
			popunjeno[i] = 0;
		}
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setBackground(Color.WHITE);
		txtIme.setName("txtIme");
		txtIme.setPreferredSize(dim);
		panIme.add(lblIme);
		panIme.add(txtIme);
		txtIme.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if (txt.getName().equals("txtIme")) {
					i = 0;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;

					}
				}	
				
			}
			
			
		});
		
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.setBackground(Color.WHITE);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		txtPrezime.addFocusListener(new FocusListener() {


			@Override
			public void focusGained(FocusEvent e) {

				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				// polje prezime je obavezno za unos:
				if (txt.getName().equals("txtPrezime")) {
					i = 1;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;

					}
				}
			}
			
		});
		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatum = new JLabel("Datum rođenja*:");
		lblDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField();
		txtDatum.setName("txtDatum");
		txtDatum.setPreferredSize(dim);
		panDatum.add(lblDatum);
		panDatum.add(txtDatum);
		txtDatum.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				if(txt.getName().equals("txtDatum")) {
					i = 2;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;
					}
					if(!Pattern.matches("(0[1-9]|[12][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(19[4-9][0-9]|200[0-2])\\.",txt.getText())) {
						tacan_datum = false;
					}	
					else {
						tacan_datum = true;
					}
					
				
				}				
			}
			
		});
		
		
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresa = new JLabel("Adresa stanovanja*:");
		lblAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField();
		txtAdresa.setName("txtAdresa");
		txtAdresa.setPreferredSize(dim);
		panAdresa.add(lblAdresa);
		panAdresa.add(txtAdresa);
		txtAdresa.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
					
				if(txt.getName().equals("txtAdresa")) {
					
					i = 3;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;
					}				
								
				}
			}
			
		});
		
		
		
		JPanel panBroj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBroj = new JLabel("Broj telefona*:");
		lblBroj.setPreferredSize(dim);
		JTextField txtBroj = new JTextField();
		txtBroj.setName("txtBroj");
		txtBroj.setPreferredSize(dim);
		panBroj.add(lblBroj);
		panBroj.add(txtBroj);
		txtBroj.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtBroj")) {
					i = 4;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;
					}				
				
				}
			}
			
		});
		
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMail = new JLabel("E-mail adresa*:");
		lblMail.setPreferredSize(dim);
		JTextField txtMail = new JTextField();
		txtMail.setName("txtMail");
		txtMail.setPreferredSize(dim);
		panMail.add(lblMail);
		panMail.add(txtMail);
		txtMail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtMail")) {
					i = 6;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;

					}
							
				}
			}
			
		});
		
		
		JPanel panIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIndeks = new JLabel("Broj indeksa*:");
		lblIndeks.setPreferredSize(dim);
		JTextField txtIndeks = new JTextField();
		txtIndeks.setName("txtIndeks");
		txtIndeks.setPreferredSize(dim);
		panIndeks.add(lblIndeks);
		panIndeks.add(txtIndeks);
		txtIndeks.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtIndeks")) {
					i = 5;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;

					}
				
				}
			}
			
		});
		
		
		JPanel panUpis = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblUpis = new JLabel("Godina upisa*:");
		lblUpis.setPreferredSize(dim);
		JTextField txtUpis = new JTextField();
		txtUpis.setName("txtGodina");
		txtUpis.setPreferredSize(dim);
		panUpis.add(lblUpis);
		panUpis.add(txtUpis);
		txtUpis.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtGodina")) {
					i = 7;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;
					}
					if(!Pattern.matches("(19[6-9][0-9]|20[0-2][0-9])", txt.getText()) || Integer.parseInt(txt.getText()) > 2021) {
						tacna_godina = false;
					}
					else {
						tacna_godina = true;
					}
				}
			}
			
		});
		

		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodina = new JLabel("Trenutna godina studija*:");
		lblGodina.setPreferredSize(dim);
		String[] godina = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		final JComboBox<String> comboGodina = new JComboBox<String>(godina);
		comboGodina.setName("comboGodina");
		comboGodina.setPreferredSize(dim);
		panGodina.add(lblGodina);
		panGodina.add(comboGodina);
		
		
		JPanel panStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblStatus = new JLabel("Način finansiranja*:");
		lblStatus.setPreferredSize(dim);
		String[] status = {"Budžet", "Samofinansiranje"};
		final JComboBox<String> comboStatus = new JComboBox<String>(status);
		comboStatus.setName("comboStatus");
		comboStatus.setPreferredSize(dim);
		panStatus.add(lblStatus);
		panStatus.add(comboStatus);
		
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(dim1);
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 8; i++) {
					if(popunjeno[i] == 0){
						prazan = true;
					}
					
				}
				if(!prazan) {
					Student student;
				
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd.mm.yyyy.").parse(txtDatum.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
					int upis = Integer.parseInt(txtUpis.getText());
					int TrenutnaGodinaStudija = 1;
					if(String.valueOf(comboGodina.getSelectedItem()) == "I (prva)") {
						 TrenutnaGodinaStudija = 1;
					}
					else if(String.valueOf(comboGodina.getSelectedItem()) == "II (druga)") {
						 TrenutnaGodinaStudija = 2;
					}
					else if(String.valueOf(comboGodina.getSelectedItem()) == "III (treća)") {
						 TrenutnaGodinaStudija = 3;
					}
					else if(String.valueOf(comboGodina.getSelectedItem()) == "IV (četvrta)") {
						 TrenutnaGodinaStudija = 4;
					}
					student = new Student(txtPrezime.getText(),txtIme.getText(),date1,txtAdresa.getText(),txtBroj.getText(),txtMail.getText(),
		 					   txtIndeks.getText(),upis,TrenutnaGodinaStudija);
					if(String.valueOf(comboStatus.getSelectedItem()) == "Budžet") {
						  student.setStatus(student.getStatusB());
					}
					else if(String.valueOf(comboStatus.getSelectedItem()) == "Samofinansiranje"){
						  student.setStatus(student.getStatusS());
					}
				

					if((tacan_datum) && (tacna_godina)) {
						StudentiController.getInstance().dodajStudenta(student);
						dispose();
					}
					else if(!tacan_datum){
						JOptionPane.showMessageDialog(null, "Pogrešan format datuma!");
					}
					else if(!tacna_godina) {
						JOptionPane.showMessageDialog(null, "Pogrešna godina");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Unesite sva polja!");
					prazan = false;
				}
			}
			
			
			
		});
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(dim1);
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtIme.setText("");
				txtPrezime.setText("");
				txtAdresa.setText("");
				txtBroj.setText("");
				txtDatum.setText("");
				txtIndeks.setText("");
				txtMail.setText("");
				txtUpis.setText("");
				for(int i = 0; i < 8; i++) {
					popunjeno[i] = 0;
				}
			}
			
		});
		
		panDugme.add(btnPotvrdi);
		panDugme.add(btnOdustani);
		
		
		
		Box boxCentar = Box.createVerticalBox();
		
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panIme);
		boxCentar.add(panPrezime);
		boxCentar.add(panDatum);
		boxCentar.add(panAdresa);
		boxCentar.add(panBroj);
		boxCentar.add(panIndeks);
		boxCentar.add(panMail);
		boxCentar.add(panUpis);
		boxCentar.add(panGodina);
		boxCentar.add(panStatus);
		boxCentar.add(panDugme);
		
		boxCentar.add(Box.createGlue());
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
		
		
	}
	
	
}
