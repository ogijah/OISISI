package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorovihPredmeta;

public class AbstractTableModelProfesoroviPredmeti extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 311130071292365822L;

	public AbstractTableModelProfesoroviPredmeti () {
		
	}
	
	@Override
	public int getRowCount() {

		return BazaProfesorovihPredmeta.getInstance().getPredmeti().size();
		
	}

	@Override
	public int getColumnCount() {

		return BazaProfesorovihPredmeta.getInstance().getColumnNum();
		
	}
	
	public String getColumnName(int column) {
		
		return BazaProfesorovihPredmeta.getInstance().getColumnName(column);
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return BazaProfesorovihPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		
	}
}
