package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import dijalog.DodavanjeStudenta;





public class TrakaSaMenijima extends JMenuBar{

	private static final long serialVersionUID = -3937220710178528520L;
	
	public TrakaSaMenijima() {
		
		//padajuci meni File
		JMenu mFile = new JMenu("File");
		mFile.setMnemonic(KeyEvent.VK_F);
		
		//stavke u padajucem manage File
		JMenuItem sNew = new JMenuItem("New", new ImageIcon("new_22x22.png"));
		sNew.setMnemonic(KeyEvent.VK_W);
		sNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		sNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						DodavanjeStudenta dialog0 = new DodavanjeStudenta(GlavniProzor.getInstance(), "Dodavanje studenta", true);
						dialog0.setVisible(true);
					}
					
				}
				
			});
		
		JMenuItem sClose = new JMenuItem("Close", new ImageIcon("close_22x22.png"));
		sClose.setMnemonic(KeyEvent.VK_C);
		sClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		//dodavanje u padajuci meni File
		mFile.add(sNew);
		mFile.addSeparator();
		mFile.add(sClose);
		
		
		//padajuci meni Edit
		JMenu mEdit = new JMenu("Edit");
		mEdit.setMnemonic(KeyEvent.VK_E);
		//stavke u padajucem meniju Edit
		JMenuItem sEdit = new JMenuItem("Edit", new ImageIcon("edit_22x22.png"));
		sEdit.setMnemonic(KeyEvent.VK_T);
		sEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem sDelete = new JMenuItem("Delete", new ImageIcon("delete_22x22.png"));
		sDelete.setMnemonic(KeyEvent.VK_D);
		sDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		//dodavanje u padajuci meni Edit
		mEdit.add(sEdit);
		mEdit.addSeparator();
		mEdit.add(sDelete);
		
		
		//padajuci meni Help
		JMenu mHelp = new JMenu("Help");
		mHelp.setMnemonic(KeyEvent.VK_H);
		//stavke u padajucem meniju Help
		JMenuItem sHelp = new JMenuItem("Help", new ImageIcon("help_22x22.png"));
		sHelp.setMnemonic(KeyEvent.VK_P);
		sHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		sHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
			
		});
		
		JMenuItem sAbout = new JMenuItem("About", new ImageIcon("about_22x22.png"));
		sAbout.setMnemonic(KeyEvent.VK_A);
		sAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		sAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
							
			}
			
		});
		
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
