package dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1842043324881060890L;

	public Help(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		//https://stackoverflow.com/questions/1090098/newline-in-jlabel -- novi red u labeli
		setSize(sirina*5/8, visina*1/2);
		setLocationRelativeTo(parent);
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		label1.setText("<html>Uputstvo za korišćenje (trenutno) implementiranih funkcionalnosti aplikacije."
				+ "<br/><br/>DODAVANJE STUDENTA: Odabirom taba Studenti, klikom na File-> New iskočiće dijalog za dodavanje studenta."
				+ "<br/>                    Takođe, klikom na plus (New) u toolbaru iskočiće dijalog za dodavanje studenta."
				+ "<br/>					U dijalogu neophodno je popuniti sva polja, poštujući unos za datum rođenja (dd.mm.gggg.)."
				+ "<br/>					Ukoliko ne postoji student sa istim brojem indeksa, telefona ili e-maila, klikom na Potvrdi student će se prikazati u tabeli."
				+ "<br/><br/>DODAVANJE PROFESORA: Odabirom taba Profesori uz klik na File -> New, ili klikom na plus u toolbaru iskočiće dijalog za dodavanje profesora."
				+ "<br/>					Neophodno je popuniti sva polja, poštujući unos za datum rođenja, i klikom na Potvrdi profesor će se prikazati u tabeli."
				+ "<br/><br/>AKCELERATORI/MNEMONICI:"
				+ "<br/>Za dodavanje studenta/profesora: ALT+F -> ALT+W  ili CTRL+N"
				+ "<br/>Za zatvaranje aplikacije: ALT+F -> ALT+C  ili CTRL+C"
				+ "<br/>Za edit: ALT+E -> ALT+T ili CTRL+E"
				+ "<br/>Za brisanje: ALT+E -> ALT+D ili CTRL+D"
				+ "<br/>Prikaz help dijaloga: ALT+H -> ALT+P ili CTRL+H"
				+ "<br/>Prikaz about dijaloga: ALT+H -> ALT+A ili CTRL+A<html>");
		panel.add(label1);
		add(panel,BorderLayout.WEST);
	}
}
