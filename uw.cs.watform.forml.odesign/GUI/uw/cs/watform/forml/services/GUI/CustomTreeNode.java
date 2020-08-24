package uw.cs.watform.forml.services.GUI;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class CustomTreeNode extends JTree {

	JTable attTable;
	public CustomTreeNode(Vector rootVector, JTable table) 
	{
		super(rootVector);		

		this.attTable=table;

		constructTree();
	}



	private void constructTree() {
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); //Single Selection Mode
		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

		setCellRenderer(renderer);

		setCellEditor(new CheckBoxNodeEditor(this, attTable));
		setEditable(true);

	}

}	

class CheckBoxNodeRenderer implements TreeCellRenderer {
	private JCheckBox leafRenderer = new JCheckBox();



	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

	Color selectionBorderColor, selectionForeground, selectionBackground,
	textForeground, textBackground;

	protected JCheckBox getLeafRenderer() {
		return leafRenderer;
	}

	public CheckBoxNodeRenderer() {
		Font fontValue;
		fontValue = UIManager.getFont("Tree.font");
		if (fontValue != null) {
			leafRenderer.setFont(fontValue);
		}
		Boolean booleanValue = (Boolean) UIManager
				.get("Tree.drawsFocusBorderAroundIcon");
		leafRenderer.setFocusPainted((booleanValue != null)
				&& (booleanValue.booleanValue()));

		selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
		selectionForeground = UIManager.getColor("Tree.selectionForeground");
		selectionBackground = UIManager.getColor("Tree.selectionBackground");
		textForeground = UIManager.getColor("Tree.textForeground");
		textBackground = UIManager.getColor("Tree.textBackground");
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		Component returnValue;
		if (leaf) {



			String stringValue = tree.convertValueToText(value, selected,
					expanded, leaf, row, false);
			leafRenderer.setText(stringValue);
			leafRenderer.setSelected(false);

			leafRenderer.setEnabled(tree.isEnabled());

			if (selected) {
				leafRenderer.setForeground(selectionForeground);
				leafRenderer.setBackground(selectionBackground);
			} else {
				leafRenderer.setForeground(textForeground);
				leafRenderer.setBackground(textBackground);
			}

			if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
				Object userObject = ((DefaultMutableTreeNode) value)
						.getUserObject();
				if (userObject instanceof CheckBoxNode) {
					CheckBoxNode node = (CheckBoxNode) userObject;
					leafRenderer.setText(node.getText());
					leafRenderer.setSelected(node.isSelected());

				}
			}
			returnValue = leafRenderer;
		} else {
			returnValue = nonLeafRenderer.getTreeCellRendererComponent(tree,
					value, selected, expanded, leaf, row, hasFocus);
		}
		return returnValue;
	}
}

class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor {

	CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

	ChangeEvent changeEvent = null;

	JTree tree;

	private JTable attsTable;
	public CheckBoxNodeEditor(JTree tree, JTable table) {
		this.tree = tree;
		this.attsTable=table;
	}

	public Object getCellEditorValue() {
		JCheckBox checkbox = renderer.getLeafRenderer();
		CheckBoxNode checkBoxNode = new CheckBoxNode(checkbox.getText(),checkbox.isSelected());

		//System.out.println (checkBoxNode.getText()+":"+checkBoxNode.isSelected());
		// Add column to the table once checked
		if(checkBoxNode.isSelected())
		{
			TableModelForTransLabel tm= (TableModelForTransLabel) attsTable.getModel();
			tm.addColumn("Op.");
			tm.tableClass.add(String.class);
			
			tm.addColumn(checkBoxNode.getText());
			tm.tableClass.add(String.class);
		}
		// remove column to the table once unchecked
		else if(!checkBoxNode.isSelected())
		{
			TableModelForTransLabel tm= (TableModelForTransLabel) attsTable.getModel();
			int columnIndexToBeRemoved=tm.findColumn(checkBoxNode.getText());
			tm.removeColumn(columnIndexToBeRemoved);
			tm.removeColumn(columnIndexToBeRemoved-1);
			
		}
		return checkBoxNode;

	}

	public boolean isCellEditable(EventObject event) {
		boolean returnValue = false;
		if (event instanceof MouseEvent) {
			MouseEvent mouseEvent = (MouseEvent) event;
			TreePath path = tree.getPathForLocation(mouseEvent.getX(),
					mouseEvent.getY());
			if (path != null) {
				Object node = path.getLastPathComponent();
				if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
					DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
					Object userObject = treeNode.getUserObject();
					returnValue = ((treeNode.isLeaf()) && (userObject instanceof CheckBoxNode));
				}
			}
		}
		return returnValue;
	}

	public Component getTreeCellEditorComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row) {

		Component editor = renderer.getTreeCellRendererComponent(tree, value,
				true, expanded, leaf, row, true);

		// editor always selected / focused
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				if (stopCellEditing()) {
					fireEditingStopped();
				}

			}
		};
		if (editor instanceof JCheckBox) {
			((JCheckBox) editor).addItemListener(itemListener);
			((JCheckBox) editor).addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					//System.out.println(((JCheckBox) editor).getText());

				}
			});
		}

		return editor;
	}
}

class CheckBoxNode {
	String text;

	boolean selected;

	public CheckBoxNode(String text, boolean selected) {
		this.text = text;
		this.selected = selected;
	}

	public boolean isSelected() {

		return selected;
	}

	public void setSelected(boolean newValue) {
		selected = newValue;
	}

	public String getText() {
		return text;
	}

	public void setText(String newValue) {
		text = newValue;
	}

	public String toString() {
		return getClass().getName() + "[" + text + "/" + selected + "]";
	}
}

class NamedVector extends Vector {
	String name;

	public NamedVector(String name) {
		this.name = name;
	}

	public NamedVector(String name, Object elements[]) {
		this.name = name;
		for (int i = 0, n = elements.length; i < n; i++) {
			add(elements[i]);
		}
	}

	public String toString() {
		return "[" + name + "]";
	}


}



//import java.awt.Component;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.JTable;
//import javax.swing.JTree;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.MutableTreeNode;
//import javax.swing.tree.TreeModel;
//import javax.swing.tree.TreeSelectionModel;
//


//	private void setActionlistener() {
//		// TODO Auto-generated method stub
//		addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				System.out.println(e.getSource().getClass());
//				
//				if(e.getClickCount() == 2)
//				{
//					String item = getSelectionModel().getSelectionPath().toString();
//					System.out.println(item);
//
//					DefaultTableModel tm= (DefaultTableModel) attTable.getModel();
//					tm.addColumn(item);
//				}
//			}
//
//
//		});
//	}
//
//}
