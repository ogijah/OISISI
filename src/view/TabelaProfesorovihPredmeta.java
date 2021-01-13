package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaProfesorovihPredmeta extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1764659074709425384L;
	private static TabelaProfesorovihPredmeta instance = null;

	public static TabelaProfesorovihPredmeta getInstance() {
		if (instance == null) {
			instance = new TabelaProfesorovihPredmeta();
		}
		return instance;
	}

	private JTable TabelaProfesorovihPredmeta;

	public JTable getTabelaPredmeta() {
		return TabelaProfesorovihPredmeta;
	}

	public TabelaProfesorovihPredmeta() {

		prikaziTabeluPredmeta();
	}

	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelProfesoroviPredmeti model = (AbstractTableModelProfesoroviPredmeti) TabelaProfesorovihPredmeta.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}

	public void prikaziTabeluPredmeta() {
		TabelaProfesorovihPredmeta = new ProfesoroviPredmetiJTable();

		JScrollPane scrollPane = new JScrollPane(TabelaProfesorovihPredmeta);
		add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz(null, -1);
	}
}
