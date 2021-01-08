
package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaPredmeta extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2352990995340891700L;
	private static TabelaPredmeta instance = null;

	public static TabelaPredmeta getInstance() {
		if (instance == null) {
			instance = new TabelaPredmeta();
		}
		return instance;
	}

	private JTable tabelaPredmeta;

	public JTable getTabelaPredmeta() {
		return tabelaPredmeta;
	}

	public TabelaPredmeta() {

		prikaziTabeluPredmeta();
	}

	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}

	public void prikaziTabeluPredmeta() {
		tabelaPredmeta = new PredmetiJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaPredmeta);
		add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz(null, -1);
	}
}
