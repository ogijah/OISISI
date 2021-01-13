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
import java.text.DateFormat;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ProfesoriController;
import gui.GlavniProzor;
import gui.TrakaSaAlatkama;
import model.BazaProfesora;
import model.Profesor;
import view.TabelaProfesorovihPredmeta;





public class IzmenaProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015334746780734974L;
	
	int[] popunjeno;
	int i;
	boolean prazan = false;
	boolean tacan_datum = true;
	int red = -1;
	
	public IzmenaProfesora(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		setSize(sirina*1/2, visina*3/4);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		Dimension dim = new Dimension(320, 30);	//za unos teksta
		Dimension dim1 = new Dimension(120, 20);	//za dugme
	
		
		int red1 = TrakaSaAlatkama.getInstance().getSelectovanRedProfesori();
		Profesor profesor = TrakaSaAlatkama.getInstance().getProfesor(red1);
		
		for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
			if(profesor == BazaProfesora.getInstance().getProfesori().get(i)) {
				red = i;
				
			}
		}
		
		popunjeno = new int[8];
		for(int i = 0; i < 8; i++) {
			
			popunjeno[i] = 1;
			
		}
		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setBackground(Color.WHITE);
		txtIme.setName("txtIme");
		txtIme.setPreferredSize(dim);
		txtIme.setText(BazaProfesora.getInstance().getRow(red).getIme());
		panIme.add(lblIme);
		panIme.add(txtIme);
		txtIme.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {

				JTextField txt = (JTextField) arg0.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField txt = (JTextField) arg0.getComponent();
				
				
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
		txtPrezime.setText(BazaProfesora.getInstance().getRow(red).getPrezime());
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

				
				if (txt.getName().equals("txtPrezime")) {
					i = 1;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;
					} else {
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
		DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy.");  
		txtDatum.setText(dateFormat.format(BazaProfesora.getInstance().getRow(0).getDatum_rodjenja()));
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
		txtAdresa.setText(BazaProfesora.getInstance().getRow(red).getAdresa());
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
					} else {
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
		txtBroj.setText(BazaProfesora.getInstance().getRow(red).getTelefon());
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
					if (txt.getText().trim().equals("")) {
						popunjeno[i] = 0;
					} else {
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
		txtMail.setText(BazaProfesora.getInstance().getRow(red).getEmail());
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
					i = 5;
					if (txt.getText().trim().equals("") ) {
						popunjeno[i] = 0;;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;

					}
				}
			}
			
		});
		
		JPanel panKancelarija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKancelarija = new JLabel("Adresa kancelarije*:");
		lblKancelarija.setPreferredSize(dim);
		JTextField txtKancelarija = new JTextField();
		txtKancelarija.setName("txtKancelarija");
		txtKancelarija.setPreferredSize(dim);
		txtKancelarija.setText(BazaProfesora.getInstance().getRow(red).getKancelarija());
		panKancelarija.add(lblKancelarija);
		panKancelarija.add(txtKancelarija);
		txtKancelarija.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtKancelarija")) {
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

		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKarta = new JLabel("Broj licne karte*:");
		lblKarta.setPreferredSize(dim);
		JTextField txtLicna = new JTextField();
		txtLicna.setName("txtLicna");
		txtLicna.setPreferredSize(dim);
		txtLicna.setText(String.valueOf(BazaProfesora.getInstance().getRow(red).getLicna_karta()));
		panLicna.add(lblKarta);
		panLicna.add(txtLicna);
		txtLicna.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtLicna")) {
					i = 7;
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
		
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*:");
		lblTitula.setPreferredSize(dim);
		String[] titula = {"BSc", "MSc", "dr", "mr", "prof. dr"};
		final JComboBox<String> comboTitula = new JComboBox<String>(titula);
		comboTitula.setName("comboTitula");
		comboTitula.setPreferredSize(dim);
		if((String.valueOf(BazaProfesora.getInstance().getRow(red).getTitula())).equals("BSc")){
			comboTitula.setSelectedItem(titula[0]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getTitula())).equals("MSc")){
			comboTitula.setSelectedItem(titula[1]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getTitula())).equals("dr")){
			comboTitula.setSelectedItem(titula[2]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getTitula())).equals("mr")){
			comboTitula.setSelectedItem(titula[3]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getTitula())).equals("prof. dr")){
			comboTitula.setSelectedItem(titula[4]);
		}
		
		panTitula.add(lblTitula);
		panTitula.add(comboTitula);
		
		
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*:");
		lblZvanje.setPreferredSize(dim);
		String[] zvanje = {"Saradnik", "Asistent", "Docent", "Vanredni profesor", "Redovni profesor", "Profesor emeritus"};
		final JComboBox<String> comboZvanje = new JComboBox<String>(zvanje);
		comboZvanje.setName("comboZvanje");
		comboZvanje.setPreferredSize(dim);
		if((String.valueOf(BazaProfesora.getInstance().getRow(red).getZvanje())).equals("Saradnik")){
			comboZvanje.setSelectedItem(zvanje[0]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getZvanje())).equals("Asistent")){
			comboZvanje.setSelectedItem(zvanje[1]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getZvanje())).equals("Vanredni profesor")){
			comboZvanje.setSelectedItem(zvanje[2]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getZvanje())).equals("Redovni profesor")){
			comboZvanje.setSelectedItem(zvanje[3]);
		}
		else if((String.valueOf(BazaProfesora.getInstance().getRow(red).getZvanje())).equals("Profesor emeritus")){
			comboZvanje.setSelectedItem(zvanje[4]);
		}
		panZvanje.add(lblZvanje);
		panZvanje.add(comboZvanje);
		
		
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(dim1);
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i  = 0; i < 8; i++) {
					
					if(popunjeno[i] == 0) {
						prazan = true;
					}
				
					
				}
				if(!prazan) {
					Profesor profesor;
						
					
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd.mm.yyyy.").parse(txtDatum.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					int licnaKarta = Integer.parseInt(txtLicna.getText());
					profesor = new Profesor(txtPrezime.getText(),txtIme.getText(),date1,txtAdresa.getText(),txtBroj.getText(),txtMail.getText(),
		 					   txtKancelarija.getText(),licnaKarta);
					
					if(String.valueOf(comboTitula.getSelectedItem()) == "BSc") {
						profesor.setTitula(profesor.getTitulaBSc());
					}
					else if(String.valueOf(comboTitula.getSelectedItem()) == "MSc"){
						profesor.setTitula(profesor.getTitulaBSc());
					}
					else if(String.valueOf(comboTitula.getSelectedItem()) == "dr"){
						profesor.setTitula(profesor.getTitulaDr());
					}
					else if(String.valueOf(comboTitula.getSelectedItem()) == "mr"){
						profesor.setTitula(profesor.getTitulaMr());
					}
					else if(String.valueOf(comboTitula.getSelectedItem()) == "prof. dr"){
						profesor.setTitula(profesor.getTitulaProfDr());
					}
					
					if(String.valueOf(comboZvanje.getSelectedItem()) == "Asistent") {
						profesor.setZvanje(profesor.getZvanjeAsistent());
					}
					else if(String.valueOf(comboZvanje.getSelectedItem()) == "Saradnik") {
						profesor.setZvanje(profesor.getZvanjeSaradnik());
					}
					else if(String.valueOf(comboZvanje.getSelectedItem()) == "Docent") {
						profesor.setZvanje(profesor.getZvanjeDocent());
					}
					else if(String.valueOf(comboZvanje.getSelectedItem()) == "Vanredni profesor") {
						profesor.setZvanje(profesor.getZvanjeVanredniProf());
					}
					else if(String.valueOf(comboZvanje.getSelectedItem()) == "Redovni profesor") {
						profesor.setZvanje(profesor.getZvanjeRedovniProf());
					}
					else if(String.valueOf(comboZvanje.getSelectedItem()) == "Profesor emeritus") {
						profesor.setZvanje(profesor.getZvanjeProfEmeritus());
					}
					if(tacan_datum) {
						ProfesoriController.getInstance().izmeniProfesora(red, profesor);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Pogrešan unos datuma!");
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
				dispose();
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
		boxCentar.add(panMail);
		boxCentar.add(panKancelarija);
		boxCentar.add(panLicna);
		boxCentar.add(panTitula);
		boxCentar.add(panZvanje);
		boxCentar.add(panDugme);
		
		boxCentar.add(Box.createGlue());
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnDodaj = new JButton("Dodaj predmet");
		btnDodaj.setPreferredSize(dim1);
		
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaProfesoru dialog0 = new DodavanjePredmetaProfesoru(GlavniProzor.getInstance(), "Dodaj predmet", true);
				dialog0.setVisible(true);	
			}
		});
		
		JButton btnUkloni = new JButton("Ukloni predmet");
		btnUkloni.setPreferredSize(dim1);
		btnUkloni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		
		panDugmad.add(btnDodaj);
		panDugmad.add(btnUkloni);
		
		
		Box boxPredmeti = Box.createVerticalBox();
		boxPredmeti.add(Box.createVerticalStrut(10));
		boxPredmeti.add(panDugmad);
		boxPredmeti.add(TabelaProfesorovihPredmeta.getInstance());
		
		JTabbedPane tabovi = new JTabbedPane();
		tabovi.add("Informacije", boxCentar);
		tabovi.add("Predmeti", boxPredmeti);
		
		panel.add(tabovi);
		
		add(panel,BorderLayout.CENTER);
	}

}
