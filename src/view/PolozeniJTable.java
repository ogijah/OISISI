package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PolozeniJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8145465648054595453L;

	public PolozeniJTable () {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPolozeni());
		
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component c = super.prepareRenderer(renderer, row, column);
		
		if(isRowSelected(row)) {
			
			c.setBackground(Color.LIGHT_GRAY);
			
		} else {
			
			c.setBackground(Color.WHITE);
			
		}
		
		return c;
		
	}
	
}
