package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;


public class AbstractTableModelProfesori extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261024513031285602L;
	
	public AbstractTableModelProfesori() {
		
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
