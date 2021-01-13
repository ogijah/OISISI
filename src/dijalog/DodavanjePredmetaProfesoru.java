package dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.TrakaSaAlatkama;
import model.BazaPredmeta;
import model.BazaProfesorovihPredmeta;
import model.Predmet;
import model.Profesor;


public class DodavanjePredmetaProfesoru extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3602169241688917612L;
	int index = -1;
	int red = -1;
	boolean postoji = false; 
	public DodavanjePredmetaProfesoru(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		
		setSize(sirina*1/3, visina*1/2);
		setLocationRelativeTo(parent);
		
		int row = TrakaSaAlatkama.getInstance().getSelectovanRedProfesori();
		Profesor profesor = TrakaSaAlatkama.getInstance().getProfesor(row);
		
		
		JPanel panel = new JPanel();
		JPanel panelPredmeti = new JPanel();
		Dimension dim1 = new Dimension(120,20);
		Vector<Predmet> nedodeljeni = new Vector<Predmet>();

		
		for(Predmet predmet: BazaPredmeta.getInstance().getPredmeti()) {
			for(Predmet predmet1: BazaProfesorovihPredmeta.getInstance().getPredmeti()) {
				if(predmet == predmet1) {
					postoji = true;
				}
			}
			if(predmet.getProfesor() != null) {
					postoji = true;
			}
			if(!postoji) {
				nedodeljeni.add(predmet);
				
			}
			else {
				postoji = false;
			}
		}
		
		Vector<String> nedodeljeniPredmeti = new Vector<String>();
		
		for(int i = 0; i < nedodeljeni.size(); i++) {
			nedodeljeniPredmeti.add(nedodeljeni.get(i).getSifra() + "-" + nedodeljeni.get(i).getNaziv());
	
		}
		
		final JList<String> listBox = new JList<String>(nedodeljeniPredmeti);
		listBox.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,16));

		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listBox.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		panelPredmeti.add(listBox);

		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					
					
					index = listBox.getSelectedIndex();
				}

			}
		});
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(dim1);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet predmet = nedodeljeni.get(index);
				predmet.setProfesor(profesor);
				BazaProfesorovihPredmeta.getInstance().dodajPredmet(profesor, predmet);
				dispose();
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
		
		panDugme.add(btnDodaj);
		panDugme.add(btnOdustani);
		
		Box boxCentar = Box.createVerticalBox();
		
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelPredmeti);
		boxCentar.add(panDugme);
		
		boxCentar.add(Box.createGlue ());
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
	}
}
