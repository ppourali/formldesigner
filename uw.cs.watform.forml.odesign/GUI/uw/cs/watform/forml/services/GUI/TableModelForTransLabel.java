package uw.cs.watform.forml.services.GUI;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class TableModelForTransLabel extends DefaultTableModel {

	public List<Class> tableClass=new ArrayList<Class>();

	
	@Override
	public Class getColumnClass(int columnIndex) {
		return  tableClass.get(columnIndex);	
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(row==0 && column==0)
			return false;
		else 
			return true;

	}

	public void removeColumn(int column) {

		try{
			columnIdentifiers.remove(column);
			for (Object row: dataVector) {
				((Vector) row).remove(column);
			}
			fireTableStructureChanged();
		}
		catch(Exception e)
		{

		}
	}
}
