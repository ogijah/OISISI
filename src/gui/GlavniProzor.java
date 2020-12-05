package gui;



import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GlavniProzor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502172470744971352L;

	public GlavniProzor() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		//dimenzije ektrana
		int visina = ekran.height;
		int sirina = ekran.width;
		
		//postavljanje dimenzija prozora
		setSize(sirina*3/4, visina*3/4);
		
		//naslov
		setTitle("Studentska sluzba");
		
		//zatvaranje prozora
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//centriranje
		setLocationRelativeTo(null);
		
		//dodajemo meni
		TrakaSaMenijima menu = new TrakaSaMenijima();
		this.setJMenuBar(menu);
	}
}