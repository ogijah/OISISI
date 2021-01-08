package dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BazaNepolozenih;
import model.BazaPolozenih;
import model.Ocena;
import view.TabelaPolozenih;

public class PonistavanjeOcene extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7946612193381489776L;
	
	public PonistavanjeOcene(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		setSize(sirina*1/5, visina*1/5);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		Dimension dim = new Dimension(150, 70);
		Dimension dim1 = new Dimension(70, 20);
		
		JPanel panPoruka = new JPanel();
		JLabel label = new JLabel("<html>Da li ste sigurni da želite<br/> da poništite ocenu?<html>");	//da bi se sve ispisalo
		label.setPreferredSize(dim);
		panPoruka.add(label);
		
		int red = TabelaPolozenih.getInstance().getTabelaPolozenih().getSelectedRow();
		Ocena ocena = BazaPolozenih.getInstance().getRow(red);
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton btnDA = new JButton("DA");
		btnDA.setPreferredSize(dim1);
		btnDA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BazaPolozenih.getInstance().ponistiOcenu(ocena.getStudent(),ocena);
				BazaNepolozenih.getInstance().dodajPredmet(ocena.getStudent(), ocena.getPredmet());
				dispose();
			}
			
		});
		
		JButton btnNE = new JButton("NE");
		btnNE.setPreferredSize(dim1);
		btnNE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();	// samo se zatvori dijalog
				
			}
			
		});
		
		panDugme.add(btnDA);
		panDugme.add(btnNE);
		
		Box box = Box.createVerticalBox();
		
		box.add(Box.createVerticalStrut(10));
		box.add(panPoruka);
		box.add(panDugme);
		
		box.add(Box.createGlue());
		panel.add(box, BorderLayout.NORTH);
		
		add(panel, BorderLayout.CENTER);
		
	}
	

}
