package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaNepolozenih extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3092138869921548320L;

	private static TabelaNepolozenih instance = null;
	
	public static TabelaNepolozenih getInstance() {
		
		if(instance == null) {
			
			instance = new TabelaNepolozenih();
			
		}
		
		return instance;
		
	}
	
	private JTable tabelaNepolozenih;
	
	public JTable getTabelaNepolozenih() {
		
		return tabelaNepolozenih;
		
	}
	
	public TabelaNepolozenih() {
		
		prikaziTabeluNepolozenih();
		
	}
	
	public void prikaziTabeluNepolozenih() {
		
		tabelaNepolozenih = new NepolozeniJTable();
		
		JScrollPane scrollPane = new JScrollPane(tabelaNepolozenih);
		add(scrollPane, BorderLayout.CENTER);
		
		this.azurirajPrikaz(null, -1);
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) tabelaNepolozenih.getModel();
		
		model.fireTableDataChanged();
		validate();
		
	}
	
}
