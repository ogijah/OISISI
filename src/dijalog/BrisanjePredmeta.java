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

import controller.PredmetiController;
import gui.TrakaSaAlatkama;
import model.BazaNepolozenih;
import model.BazaPolozenih;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;



public class BrisanjePredmeta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493686879773066106L;
	int red = -1;
	
	public BrisanjePredmeta(Frame parent, String title, boolean modal) {
		
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
		JLabel label = new JLabel("<html>Da li ste sigurni da želite<br/> da obrišete predmet?<html>");
		label.setPreferredSize(dim);
		panPoruka.add(label);
		
		int red1 = TrakaSaAlatkama.getInstance().getSelektovanRedPredmeta();
		Predmet predmet = TrakaSaAlatkama.getInstance().getPredmet(red1);
		
		for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			if(predmet == BazaPredmeta.getInstance().getPredmeti().get(i)) {
				red = i;
				
			}
		}
		
		JPanel panDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton btnDA = new JButton("DA");
		btnDA.setPreferredSize(dim1);
		btnDA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet predmet = BazaPredmeta.getInstance().getRow(red);
				for(int j = 0; j < BazaStudenata.getInstance().getStudenti().size(); j++) {
					for(int i = 0; i < BazaPolozenih.getInstance().getOcene().size(); i++) {
						if(predmet == BazaPolozenih.getInstance().getRow(i).getPredmet() ) {
							BazaPolozenih.getInstance().ponistiOcenu(BazaStudenata.getInstance().getRow(j), BazaPolozenih.getInstance().getRow(i));
						}
					}
				}
				for(int i = 0;i < BazaNepolozenih.getInstance().getPredmeti().size(); i++) {
					if(predmet == BazaNepolozenih.getInstance().getRow(i)) {
						BazaNepolozenih.getInstance().obrisiPredmet(predmet);
						break;
					}
				}
				
				PredmetiController.getInstance().obrisiPredmet(red);
				
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
