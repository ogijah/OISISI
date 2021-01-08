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
import gui.TrakaSaAlatkama;
import model.BazaPredmeta;
import model.Predmet;


public class IzmenaPredmeta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5337092462346036775L;
	
	int[] popunjeno;
	int i;
	boolean prazan = false;
	int red = -1;
	public IzmenaPredmeta(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		setSize(sirina*1/2, visina*3/4);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		Dimension dim = new Dimension(320, 30);
		Dimension dim1 = new Dimension(120, 20);
		
		int red1 = TrakaSaAlatkama.getInstance().getSelektovanRedPredmeta();
		Predmet predmet = TrakaSaAlatkama.getInstance().getPredmet(red1);
		
		for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			if(predmet == BazaPredmeta.getInstance().getPredmeti().get(i)) {
				red = i;
				
			}
		}
		
		
		
		popunjeno = new int[3];
		for(int i = 0; i < 3; i++) {
			
			popunjeno[i] = 1;
			
		}
			
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labSifra = new JLabel("Šifra*: ");
		labSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setBackground(Color.WHITE);
		txtSifra.setName("txtSifra");
		txtSifra.setPreferredSize(dim);
		txtSifra.setText(BazaPredmeta.getInstance().getRow(red).getSifra());
		panSifra.add(labSifra);
		panSifra.add(txtSifra);
		txtSifra.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				
				JTextField txt = (JTextField) e.getComponent();
				txt.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				JTextField txt = (JTextField) e.getComponent();
				
				if(txt.getName().equals("txtSifra")) {
					
					i = 0;
					if(txt.getText().trim().equals("")) {
						
						popunjeno[i] = 0;;
				
					} else {
					
							txt.setForeground(Color.BLACK);
							popunjeno[i] = 1;
							
					}
					
				}

			}
			
		});
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labNaziv = new JLabel("Naziv*: ");
		labNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setBackground(Color.WHITE);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setText(BazaPredmeta.getInstance().getRow(red).getNaziv());
		panNaziv.add(labNaziv);
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
				
				if(txt.getName().equals("txtNaziv")) {
					
						i = 1;
						if(txt.getText().trim().equals("")) {
						
						popunjeno[i] = 0;
				
						} else {
					
							txt.setForeground(Color.BLACK);
							popunjeno[i] = 1;
							
						}
					
				}

				
			}
			
			
			
		});
		
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labSemestar = new JLabel("Semestar*: ");
		labSemestar.setPreferredSize(dim);
		String semestar[] = {"zimski", "letnji"};
		final JComboBox<String> comboSemestar = new JComboBox<String>(semestar);
		comboSemestar.setName("comboSemestar");
		comboSemestar.setPreferredSize(dim);
		
		if((String.valueOf(BazaPredmeta.getInstance().getRow(red).getSemestar())).equals("zimski")) {
			
			comboSemestar.setSelectedItem(semestar[0]);
			
		} else {
			
			comboSemestar.setSelectedItem(semestar[1]);
			
		}
		
		panSemestar.add(labSemestar);
		panSemestar.add(comboSemestar);
		
		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labGodinaStudija = new JLabel("Godina studija*: ");
		labGodinaStudija.setPreferredSize(dim);
		String godina[] = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		final JComboBox<String> comboGodinaStudija = new JComboBox<String>(godina);
		comboGodinaStudija.setName("comboGodianStudija");
		comboGodinaStudija.setPreferredSize(dim);
		comboGodinaStudija.setSelectedItem(godina[BazaPredmeta.getInstance().getRow(red).getGodina_studija()-1]);
		panGodinaStudija.add(labGodinaStudija);
		panGodinaStudija.add(comboGodinaStudija);
		
		JPanel panESPB = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labESPB = new JLabel("ESPB*: ");
		labESPB.setPreferredSize(dim);
		JTextField txtESPB = new JTextField();
		txtESPB.setName("txtESPB");
		txtESPB.setPreferredSize(dim);
		txtESPB.setText(Integer.toString(BazaPredmeta.getInstance().getRow(red).getESPB()));
		panESPB.add(labESPB);
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
					if(txt.getText().trim().equals("")) {
						
						popunjeno[i] = 0;
						
					} else {
						
						txt.setForeground(Color.BLACK);
						popunjeno[i] = 1;
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
				
				for(int i = 0; i < 3; i++) {
					
					if(popunjeno[i] == 0) {
						prazan = true;
					}
					
				}
				if(!prazan) {
					
					Predmet predmet;
	
					int espb = Integer.parseInt(txtESPB.getText());
					
					//godina studija = comboBox
					int godinaStudija = 1;
					
					if(String.valueOf(comboGodinaStudija.getSelectedItem()) == "I (prva)") {
						
						godinaStudija = 1;
						
					} else if(String.valueOf(comboGodinaStudija.getSelectedItem()) == "II (druga)") {
						
						godinaStudija = 2;
						
					} else if (String.valueOf(comboGodinaStudija.getSelectedItem()) == "III (treća)") {
						
						godinaStudija = 3;
						
					} else if (String.valueOf(comboGodinaStudija.getSelectedItem()) == "IV (četvrta)") {
						
						godinaStudija = 4;
						
					}
					
					predmet = new Predmet(txtSifra.getText(), txtNaziv.getText(), godinaStudija, espb);
					
					//semestar
					if (String.valueOf(comboSemestar.getSelectedItem()) == "zimski") {
						
						predmet.setSemestar(predmet.getSemestarZimski());
						
					} else if (String.valueOf(comboSemestar.getSelectedItem()) == "letnji") {
						
						predmet.setSemestar(predmet.getSemestarLetnji());
						
					}
					
					PredmetiController.getInstance().izmeniPredmet(red, predmet);
					dispose();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Unesite sva polja!");
					
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
		
		Box boxCenter = Box.createVerticalBox();
		
		boxCenter.add(Box.createVerticalStrut(20));
		boxCenter.add(panSifra);
		boxCenter.add(panNaziv);
		boxCenter.add(panGodinaStudija);
		boxCenter.add(panSemestar);
		boxCenter.add(panESPB);
		boxCenter.add(panDugme);
		
		boxCenter.add(Box.createGlue());
		panel.add(boxCenter, BorderLayout.NORTH);
		
		add(panel, BorderLayout.CENTER);
		
	}

}
