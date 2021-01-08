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
import model.BazaNepolozenih;
import model.BazaPolozenih;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;



public class DodavanjePredmetaStudentu extends JDialog{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1365392856680742105L;
	int index = -1;
	boolean postoji = false; 
	public DodavanjePredmetaStudentu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		
		setSize(sirina*1/3, visina*1/2);
		setLocationRelativeTo(parent);
		
		int row = TrakaSaAlatkama.getInstance().getSelectovanRed();
		Student student = BazaStudenata.getInstance().getRow(row);
		System.out.println("RED STUDENTA:" + row);
		JPanel panel = new JPanel();
		JPanel panelPredmeti = new JPanel();
		Dimension dim1 = new Dimension(120,20);
		Vector<Predmet> nepolozeni = new Vector<Predmet>();

		
		for(Predmet predmet: BazaPredmeta.getInstance().getPredmeti()) {
			for(Predmet predmet1: BazaNepolozenih.getInstance().getPredmeti()) {
				if(predmet == predmet1) {
					postoji = true;
				}
			}
			for(Ocena ocena: BazaPolozenih.getInstance().getOcene()) {
				if(predmet == ocena.getPredmet()) {
					postoji = true;
				}
			}
			
			if(student.getTrenutnaGodinaStudija() < predmet.getGodina_studija()) {
				postoji = true;
			}
			
			if(!postoji) {
				nepolozeni.add(predmet);
				
			}
			else {
				postoji = false;
			}
		}
		
		Vector<String> nepolozeniPredmeti = new Vector<String>();
		
		for(int i = 0; i < nepolozeni.size(); i++) {
			nepolozeniPredmeti.add(nepolozeni.get(i).getSifra() + "-" + nepolozeni.get(i).getNaziv());
	
		}
		
		final JList<String> listBox = new JList<String>(nepolozeniPredmeti);
		listBox.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,16));

		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listBox.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		panelPredmeti.add(listBox);

		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					
					
					// TODO Auto-generated method stub
					
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
				Predmet predmet = nepolozeni.get(index);
				BazaNepolozenih.getInstance().dodajPredmet(student, predmet);
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
