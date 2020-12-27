package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TabelaStudenata extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6987726289554087958L;
	private static TabelaStudenata instance = null;

	public static TabelaStudenata getInstance() {
		if (instance == null) {
			instance = new TabelaStudenata();
		}
		return instance;
	}

	private JTable tabelaStudenata;

	public JTable getTabelaStudenata() {
		return tabelaStudenata;
	}

	public TabelaStudenata() {
		
		prikaziTabeluStudenata();
	}

	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}

	public void prikaziTabeluStudenata() {
		tabelaStudenata = new StudentiJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz(null, -1);
	}
}
