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
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class DodavanjeProfesoraNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7497258928266257853L;

	int index = -1;
	int red = -1;
	boolean postoji = false; 
	public DodavanjeProfesoraNaPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		
		setSize(sirina*1/3, visina*1/2);
		setLocationRelativeTo(parent);
		
		int row = TrakaSaAlatkama.getInstance().getSelektovanRedPredmeta();
		Predmet predmet = TrakaSaAlatkama.getInstance().getPredmet(row);
		
		
		JPanel panel = new JPanel();
		JPanel panelProfesori = new JPanel();
		Dimension dim1 = new Dimension(120,20);
		Vector<Profesor> nedodeljeni = new Vector<Profesor>();

		
		for(Profesor profesor: BazaProfesora.getInstance().getProfesori()) {
				nedodeljeni.add(profesor);
		}
		
		Vector<String> nedodeljeniProfesori = new Vector<String>();
		
		for(int i = 0; i < nedodeljeni.size(); i++) {
			nedodeljeniProfesori.add(nedodeljeni.get(i).getIme() + " " + nedodeljeni.get(i).getPrezime());
	
		}
		
		final JList<String> listBox = new JList<String>(nedodeljeniProfesori);
		listBox.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,16));

		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listBox.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		panelProfesori.add(listBox);

		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					
					
					index = listBox.getSelectedIndex();
				}

			}
		});
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(dim1);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor profesor = TrakaSaAlatkama.getInstance().getProfesor(index);
				predmet.setProfesor(profesor);
				profesor.getPredmeti().add(predmet);
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
		
		panDugme.add(btnPotvrdi);
		panDugme.add(btnOdustani);
		
		Box boxCentar = Box.createVerticalBox();
		
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelProfesori);
		boxCentar.add(panDugme);
		
		boxCentar.add(Box.createGlue ());
		panel.add(boxCentar, BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
	}
}
