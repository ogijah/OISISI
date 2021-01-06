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

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesoriController;

import model.Profesor;


public class DodavanjeProfesora extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3978453336369063755L;
	
	boolean popunjeno = true;
	public DodavanjeProfesora(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		//dimenzije ektrana
		int visina = ekran.height;
		int sirina = ekran.width;
		
		
		setSize(sirina*1/2, visina*3/4);
		setLocationRelativeTo(parent);
		
		
		JPanel panel = new JPanel();
		Dimension dim = new Dimension(320, 30);
		Dimension dim1 = new Dimension(120,20);
		

		
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
			public void focusGained(FocusEvent arg0) {

				JTextField txt = (JTextField) arg0.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField txt = (JTextField) arg0.getComponent();
				
				if (txt.getName().equals("txtIme")) {

					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					}
					else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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

				
				if (txt.getName().equals("txtPrezime")) {

					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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
					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} 
					else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;
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
					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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
					if (txt.getText().trim().equals("")) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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
					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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
					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

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
					if (txt.getText().trim().equals("") ) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

					}
				}
			}
			
		});
		
		
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*:");
		lblTitula.setPreferredSize(dim);
		JTextField txtTitula = new JTextField();
		txtTitula.setName("txtGodina");
		txtTitula.setPreferredSize(dim);
		panTitula.add(lblTitula);
		panTitula.add(txtTitula);
		txtTitula.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtTitula")) {
					if (txt.getText().trim().equals("")) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

					}
				}
			}
			
		});
		
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*:");
		lblZvanje.setPreferredSize(dim);
		JTextField txtZvanje = new JTextField();
		txtZvanje.setName("txtZvanje");
		txtZvanje.setPreferredSize(dim);
		panZvanje.add(lblZvanje);
		panZvanje.add(txtZvanje);
		txtZvanje.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtZvanje")) {
					if (txt.getText().trim().equals("")) {
						popunjeno = false;
					} else {
						txt.setForeground(Color.BLACK);
						popunjeno = true;

					}
				}
			}
			
		});
		
		
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(dim1);
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(popunjeno) {
					Profesor profesor;
					
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd.mm.yyyy").parse(txtDatum.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int licnaKarta = Integer.parseInt(txtLicna.getText());
					profesor = new Profesor(txtPrezime.getText(),txtIme.getText(),date1,txtAdresa.getText(),txtBroj.getText(),txtMail.getText(),
		 					   txtKancelarija.getText(),licnaKarta,txtTitula.getText(),txtZvanje.getText());
					ProfesoriController.getInstance().dodajProfesora(profesor);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!");
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
				txtKancelarija.setText("");
				txtMail.setText("");
				txtTitula.setText("");
				txtZvanje.setText("");
				txtLicna.setText("");
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
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);

	}
}
