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

import gui.TrakaSaAlatkama;
import model.BazaNepolozenih;
import model.BazaPolozenih;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import model.Ocena;
import view.TabelaNepolozenih;




public class UpisOcene extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8880462081462404892L;

	boolean popunjeno = false;
	boolean tacan_datum = true;
	public UpisOcene(Frame parent, String title, boolean modal) {
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
		
		int red1 = TrakaSaAlatkama.getInstance().getSelectovanRed();
		int red2 = TabelaNepolozenih.getInstance().getTabelaNepolozenih().getSelectedRow();	
		Student student = BazaStudenata.getInstance().getRow(red1);
		Predmet predmet = BazaNepolozenih.getInstance().getRow(red2);
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Sifra*:");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setBackground(Color.WHITE);
		txtSifra.setName("txtIme");
		txtSifra.setPreferredSize(dim);
		txtSifra.setText(BazaNepolozenih.getInstance().getRow(red2).getSifra());
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		txtSifra.setEditable(false);
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNaziv = new JLabel("Naziv*:");
		lblNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setBackground(Color.WHITE);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setText(BazaNepolozenih.getInstance().getRow(red2).getNaziv());
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		txtNaziv.setEditable(false);
		
		JPanel panOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOcena = new JLabel("Ocena*:");
		lblOcena.setPreferredSize(dim);
		Integer[] vrednostOcene = {6,7,8,9,10};
		final JComboBox<Integer> comboOcena = new JComboBox<Integer>(vrednostOcene);
		comboOcena.setName("comboOcena");
		comboOcena.setPreferredSize(dim);
		panOcena.add(lblOcena);
		panOcena.add(comboOcena);
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatum = new JLabel("Datum*:");
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
					if(!Pattern.matches("(0[1-9]|[12][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(19[4-9][0-9]|200[0-2])\\.",txt.getText())) {
						tacan_datum = true;
					}	
					else {
						tacan_datum = false;
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
					Ocena ocena;
					
					
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd.mm.yyyy.").parse(txtDatum.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
			
					int ocenaVrednost = 6;
					if(comboOcena.getSelectedItem().equals(6)) {
						 ocenaVrednost = 6;
					}
					else if(comboOcena.getSelectedItem().equals(7)) {
						 ocenaVrednost = 7;
					}
					else if(comboOcena.getSelectedItem().equals(8)) {
						 ocenaVrednost = 8;
					}
					else if(comboOcena.getSelectedItem().equals(9)) {
						 ocenaVrednost = 9;
					}
					else if(comboOcena.getSelectedItem().equals(10)) {
						ocenaVrednost = 10;
					}
					
					ocena = new Ocena(student,predmet,ocenaVrednost,date1);
				
					
					if(tacan_datum) {
						BazaPolozenih.getInstance().dodajOcenu(student,predmet,ocena);
						BazaNepolozenih.getInstance().obrisiPredmet(predmet);
						
						dispose();
						
					}
					else if(!tacan_datum){
						JOptionPane.showMessageDialog(null, "Pogrešan format datuma!");
					}
					
				}
				else {
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
		
		
		
		Box boxCentar = Box.createVerticalBox();
		
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifra);
		boxCentar.add(panNaziv);
		boxCentar.add(panOcena);
		boxCentar.add(panDatum);
		boxCentar.add(panDugme);
		boxCentar.add(Box.createGlue());
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
		
		
	}
}
