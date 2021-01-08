package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPolozenih;


public class AbstractTableModelPolozeni extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4351802600286733456L;

	public AbstractTableModelPolozeni () {
		
	}
	
	@Override
	public int getRowCount() {

		return BazaPolozenih.getInstance().getOcene().size();
		
	}

	@Override
	public int getColumnCount() {

		return BazaPolozenih.getInstance().getColumnNum();
		
	}
	
	public String getColumnName(int column) {
		
		return BazaPolozenih.getInstance().getColumnName(column);
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return BazaPolozenih.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

}
