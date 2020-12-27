package gui;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import dijalog.DodavanjeProfesora;
import dijalog.DodavanjeStudenta;

public class TrakaSaAlatkama extends JToolBar {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

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

			JButton btnOpen = new JButton();
			btnOpen.setToolTipText("Edit");
			btnOpen.setIcon(new ImageIcon("pencil1_22x22.png"));
			add(btnOpen);

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

	

