package dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5277572896881104321L;
	
	public About(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		int visina = ekran.height;
		int sirina = ekran.width;
		
		//https://stackoverflow.com/questions/1090098/newline-in-jlabel -- novi red u labeli
		setSize(sirina*3/8, visina*1/2);
		setLocationRelativeTo(parent);
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		label1.setText("<html>Aplikacija Studentska služba, za Fakultet tehničkih nauka u Novom Sadu."
				+ "<br/><br/> Koristi se za prikaz i upravljanje studenata, profesora, predmeta kao i za evidenciju ispita."
				+ "<br/><br/>U ovoj verziji aplikacije korišćen je jdk1.8 kompajler."
				+ "<br/><br/><br/> AUTORI:"
				+ "<br/><br/>Student 1: Sara Poparić, RA-60/2018"
				+ "<br/><br/>Student 2: Ognjen Bogdanović, RA-101/2018<html>");
		panel.add(label1);
		add(panel,BorderLayout.WEST);
	}
}
