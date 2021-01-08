package view;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozenih;

public class AbstractTableModelNepolozeni extends AbstractTableModel {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6093746039338571525L;

	public AbstractTableModelNepolozeni () {
		
	}
	
	@Override
	public int getRowCount() {

		return BazaNepolozenih.getInstance().getPredmeti().size();
		
	}

	@Override
	public int getColumnCount() {

		return BazaNepolozenih.getInstance().getColumnNum();
		
	}
	
	public String getColumnName(int column) {
		
		return BazaNepolozenih.getInstance().getColumnName(column);
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return BazaNepolozenih.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

}
