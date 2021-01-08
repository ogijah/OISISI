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


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetiController;
import model.Predmet;


public class DodavanjePredmeta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3978453336369063755L;
	
	int[] popunjeno;
	int i;
	boolean prazan = false;
	
	public DodavanjePredmeta(Frame parent, String title, boolean modal) {
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
		
		popunjeno = new int[3];
		for(int i = 0; i < 3; i++) {
			popunjeno[i] = 0;
		}
		
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Šifra*:");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setBackground(Color.WHITE);
		txtSifra.setName("txtSifra");
		txtSifra.setPreferredSize(dim);
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		txtSifra.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {

				JTextField txt = (JTextField) arg0.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField txt = (JTextField) arg0.getComponent();
				
				
				if (txt.getName().equals("txtSifra")) {
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
		
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNaziv = new JLabel("Naziv*:");
		lblNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setBackground(Color.WHITE);
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		txtNaziv.addFocusListener(new FocusListener() {


			@Override
			public void focusGained(FocusEvent e) {

				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);

			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();

				
				if (txt.getName().equals("txtNaziv")) {
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
		
		JPanel panESPB = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblESPB = new JLabel("ESPB bodovi*:");
		lblESPB.setPreferredSize(dim);
		JTextField txtESPB = new JTextField();
		txtESPB.setName("txtESPB");
		txtESPB.setPreferredSize(dim);
		panESPB.add(lblESPB);
		panESPB.add(txtESPB);
		txtESPB.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);				
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField txt = (JTextField) e.getComponent();
					
				if(txt.getName().equals("txtESPB")) {
					
						i = 2;
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

		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodina = new JLabel("Godina studija*:");
		lblGodina.setPreferredSize(dim);
		String[] godina = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		final JComboBox<String> comboGodina = new JComboBox<String>(godina);
		comboGodina.setName("comboGodina");
		comboGodina.setPreferredSize(dim);
		panGodina.add(lblGodina);
		panGodina.add(comboGodina);
		
		
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSemestar = new JLabel("Semestar*:");
		lblSemestar.setPreferredSize(dim);
		String[] status = {"Letnji", "Zimski"};
		final JComboBox<String> comboSemestar = new JComboBox<String>(status);
		comboSemestar.setName("comboSemestar");
		comboSemestar.setPreferredSize(dim);
		panSemestar.add(lblSemestar);
		panSemestar.add(comboSemestar);
		
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(dim1);
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 3; i++) {
					if(popunjeno[i] == 0){
						prazan = true;
					}
					
				}
				if(!prazan) {
					Predmet predmet;
					
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
					
					int espb = Integer.parseInt(txtESPB.getText());
					predmet = new Predmet(txtSifra.getText(),txtNaziv.getText(),TrenutnaGodinaStudija,espb);
					if(String.valueOf(comboSemestar.getSelectedItem()) == "Letnji") {
						 predmet.setSemestar(predmet.getSemestarLetnji());
					}
					else if(String.valueOf(comboSemestar.getSelectedItem()) == "Zimski"){
						 predmet.setSemestar(predmet.getSemestarZimski());
					}
					PredmetiController.getInstance().dodajPredmet(predmet);
					dispose();
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
				txtSifra.setText("");
				txtNaziv.setText("");
				txtESPB.setText("");
				
				for(int i = 0; i < 3; i++) {
					popunjeno[i] = 0;
				}
				dispose();
				
			}
			
		});
		
		panDugme.add(btnPotvrdi);
		panDugme.add(btnOdustani);
		
		
		
		Box boxCentar = Box.createVerticalBox();
		
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifra);
		boxCentar.add(panNaziv);
		boxCentar.add(panESPB);
		boxCentar.add(panGodina);
		boxCentar.add(panSemestar);
		boxCentar.add(panDugme);
		
		boxCentar.add(Box.createGlue());
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
		
		
	}
	
	
}
