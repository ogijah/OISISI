package gui;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


import dijalog.IzmenaProfesora;
import dijalog.DodavanjeProfesora;
import dijalog.DodavanjeStudenta;
import dijalog.IzmenaStudenta;

import view.TabelaProfesora;
import view.TabelaStudenata;

public class TrakaSaAlatkama extends JToolBar {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;
	int red;
	
	
	private static TrakaSaAlatkama instance = null;

	public static TrakaSaAlatkama getInstance() {
		if (instance == null) {
			instance = new TrakaSaAlatkama();
		}
		return instance;
	}
	
	
	
	public int getRed() {
		return red;
	}
	
	public int getSelectovanRed() {
		
		return red = TabelaStudenata.getInstance().getTabelaStudenata().getSelectedRow();
			
	}
	
	public int getSelectovanRedProfesori() {
		
		return red = TabelaProfesora.getInstance().getTabelaProfesora().getSelectedRow();
			
	}

	public void setRed(int red) {
		this.red = red;
	}


		public TrakaSaAlatkama() {
			// u konstruktor nadklase, tj klase JToolbar prosledjuje
			// se orijentacija toolbar-a, moguca i sa konstantom: SwingConstants.VERTICAL
			
			super(SwingConstants.HORIZONTAL);
			
			JButton btnNew = new JButton();
			btnNew.setToolTipText("New");
			btnNew.setIcon(new ImageIcon("new_22x22.png"));
			btnNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						DodavanjeStudenta dialog = new DodavanjeStudenta(GlavniProzor.getInstance(), "Dodavanje studenta", true);
						dialog.setVisible(true);
					}
					else if(GlavniProzor.getInstance().getIndeks() == 1) {
						DodavanjeProfesora dialog1 = new DodavanjeProfesora(GlavniProzor.getInstance(), "Dodavanje profesora", true);
						dialog1.setVisible(true);
					}
				}
			});
			
			add(btnNew);

			addSeparator();

			JButton btnEdit = new JButton();
			btnEdit.setToolTipText("Edit");
			btnEdit.setIcon(new ImageIcon("pencil1_22x22.png"));
			btnEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						
						red = TabelaStudenata.getInstance().getTabelaStudenata().getSelectedRow();
						setRed(red);
						if(red != -1) {
							IzmenaStudenta dialog0 = new IzmenaStudenta(GlavniProzor.getInstance(), "Izmena studenta", true);
							dialog0.setVisible(true);
						}
					} else if (GlavniProzor.getInstance().getIndeks() == 1) {
						red = TabelaProfesora.getInstance().getTabelaProfesora().getSelectedRow();
						setRed(red);
						if(red != -1) {
							
							IzmenaProfesora dialog1 = new IzmenaProfesora(GlavniProzor.getInstance(), "Izmena profesora", true);
							dialog1.setVisible(true);
							
						}
					}
					
				}
				
			});
			add(btnEdit);

			addSeparator();

			JButton btnDelete = new JButton();
			btnDelete.setToolTipText("Delete");
			btnDelete.setIcon(new ImageIcon("delete_22x22.png"));
			add(btnDelete);
			
			addSeparator();
			
			add(Box.createHorizontalStrut(800));
			JTextField textBox = new JTextField();
			add(textBox);
			addSeparator();
			
			JButton btnSearch = new JButton();
			btnSearch.setToolTipText("Search");
			btnSearch.setIcon(new ImageIcon("loop_22x22.png"));
			add(btnSearch);
			addSeparator();
			

			// toolbar je pokretljiv, probati i sa staticnim toolbarom
			setFloatable(false);
			

		}

	}

	

