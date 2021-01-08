package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;



public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261024513031285602L;
	
	public AbstractTableModelPredmeti() {
		
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
