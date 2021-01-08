package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaPolozenih extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3092138869921548320L;

	private static TabelaPolozenih instance = null;
	
	public static TabelaPolozenih getInstance() {
		
		if(instance == null) {
			
			instance = new TabelaPolozenih();
			
		}
		
		return instance;
		
	}
	
	private JTable tabelaPolozenih;
	
	public JTable getTabelaPolozenih() {
		
		return tabelaPolozenih;
		
	}
	
	public TabelaPolozenih() {
		
		prikaziTabeluPolozenih();
		
	}
	
	public void prikaziTabeluPolozenih() {
		
		tabelaPolozenih = new PolozeniJTable();
		
		JScrollPane scrollPane = new JScrollPane(tabelaPolozenih);
		add(scrollPane, BorderLayout.CENTER);
		
		this.azurirajPrikaz(null, -1);
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		
		AbstractTableModelPolozeni model = (AbstractTableModelPolozeni) tabelaPolozenih.getModel();
		
		model.fireTableDataChanged();
		validate();
		
	}
	
}
