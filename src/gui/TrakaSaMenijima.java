package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class TrakaSaMenijima extends JMenuBar{

	private static final long serialVersionUID = -3937220710178528520L;
	
	public TrakaSaMenijima() {
		
		//padajuci meni File
		JMenu mFile = new JMenu("File");
		
		//stavke u padajucem meniju File
		JMenuItem sNew = new JMenuItem("New", new ImageIcon("new_22x22.png"));
		sNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem sClose = new JMenuItem("Close", new ImageIcon("close_22x22.png"));
		sClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		//dodavanje u padajuci meni File
		mFile.add(sNew);
		mFile.addSeparator();
		mFile.add(sClose);
		
		
		//padajuci meni Edit
		JMenu mEdit = new JMenu("Edit");
		
		//stavke u padajucem meniju Edit
		JMenuItem sEdit = new JMenuItem("Edit", new ImageIcon("edit_22x22.png"));
		sEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem sDelete = new JMenuItem("Delete", new ImageIcon("delete_22x22.png"));
		sDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		//dodavanje u padajuci meni Edit
		mEdit.add(sEdit);
		mEdit.addSeparator();
		mEdit.add(sDelete);
		
		
		//padajuci meni Help
		JMenu mHelp = new JMenu("Help");
		
		//stavke u padajucem meniju Help
		JMenuItem sHelp = new JMenuItem("Help", new ImageIcon("help_22x22.png"));
		sHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem sAbout = new JMenuItem("About", new ImageIcon("about_22x22.png"));
		sAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		//dodavanje u padajuci meni Help
		mHelp.add(sHelp);
		mHelp.addSeparator();
		mHelp.add(sAbout);
		
		
		//dodavanje svih padajucih menija
		add(mFile);
		add(mEdit);
		add(mHelp);
		
	}

}
