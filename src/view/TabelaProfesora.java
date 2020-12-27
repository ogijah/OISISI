package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaProfesora extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2352990995340891700L;
	private static TabelaProfesora instance = null;

	public static TabelaProfesora getInstance() {
		if (instance == null) {
			instance = new TabelaProfesora();
		}
		return instance;
	}

	private JTable tabelaProfesora;

	public JTable getTabelaProfesora() {
		return tabelaProfesora;
	}

	public TabelaProfesora() {

		prikaziTabeluProfesora();
	}

	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}

	public void prikaziTabeluProfesora() {
		tabelaProfesora = new ProfesoriJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
		add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz(null, -1);
	}
}
