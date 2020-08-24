package uw.cs.watform.forml.services.GUI;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.impl.*;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.event.KeyAdapter;
import java.awt.Cursor;;

public class FrmEditFeatureMessage extends JDialog {

	public int Value = -1;
	public String Many = "";
	public int cardLower = -1;
	public int cardUpper = -1;
	private JTextField txtMsgName;
	private JTable tblAttributes;
	private JButton btnConfirm;

	private DefaultTableModel tableModel;

	public Message newMessage = FormlFactory.eINSTANCE.createMessage();

	Message msg = FormlFactory.eINSTANCE.createMessage();
	public boolean confirmFlag = false;

	public FrmEditFeatureMessage(Message inMsg) {
		setTitle("Edit Message");

		this.msg = inMsg;

		constructDesign();

		setValues();

		// JOptionPane.showMessageDialog(null, inMsg);

	}

	private void setValues() {

		try {
			txtMsgName.setText(this.msg.getName());

			for (ExprRef att : msg.getAttributes()) {
				Attribute a = ((Attribute) att);

				String[] lowerUpper = { "0", "0" };

				if (a.getMultiplicity() != null)
					lowerUpper = setCurrentValues(a.getMultiplicity());

				tableModel.addRow(
						new Object[] { a.isCtrl(), a.getName(), parseType(a.getType()), lowerUpper[0], lowerUpper[1] });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String parseType(AttributeType attributeType) {

		if (attributeType.getClass().equals(IntTypeImpl.class))
			return "int";
		else if (attributeType.getClass().equals(BoolTypeImpl.class))
			return "bool";
		else if (attributeType.getClass().equals(StringTypeImpl.class))
			return "string";
		else if (attributeType.getClass().equals(ReferenceTypeImpl.class))
			return ((ReferenceType) attributeType).getRef().getName();

		return "";

	}

	private String[] setCurrentValues(Multiplicity mul) {

		int oldLower = 0, oldUpper = 0;

		if (mul.getCardinality() != null) {
			oldLower = mul.getCardinality().getLower();
			if (mul.getCardinality().getMany() != null && mul.getCardinality().getMany().trim() != "")
				oldUpper = -1;
			else
				oldUpper = mul.getCardinality().getUpper();
		} else {
			if (mul.getMany() != null && mul.getMany().trim() != "") {
				oldLower = 0;
				oldUpper = -1;
			} else {
				oldLower = mul.getValue();
				oldUpper = mul.getValue();
			}
		}

		String[] returnBoundaries = new String[2];

		returnBoundaries[0] = String.valueOf(oldLower);

		if (oldUpper == -1)
			returnBoundaries[1] = "*";
		else
			returnBoundaries[1] = String.valueOf(oldUpper);

		return returnBoundaries;
	}

	private void constructDesign() {
		// TODO Auto-generated method stub
		setType(Type.UTILITY);
		getContentPane().setBackground(new Color(255, 239, 213));
		setModal(true);
		setBackground(new Color(173, 216, 230));
		getContentPane().setForeground(new Color(173, 216, 230));

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getContentPane().setLayout(null);
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setResultsAndExit();
			}
		});
		btnConfirm.setBounds(175, 184, 75, 23);
		getContentPane().add(btnConfirm);

		JButton btnCanel = new JButton("Cancel");
		btnCanel.setBounds(90, 184, 75, 23);
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmFlag = false;
				dispose();
			}
		});
		getContentPane().add(btnCanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 316, 128);
		getContentPane().add(scrollPane);

		tblAttributes = new JTable() {
			@java.lang.Override // Always selectAll()
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();
				if (editor == null || !(editor instanceof JTextComponent)) {
					return result;
				}
				if (e instanceof MouseEvent) {
					EventQueue.invokeLater(new Runnable() {

						@java.lang.Override
						public void run() {
							((JTextComponent) editor).selectAll();
						}
					});
				} else {
					((JTextComponent) editor).selectAll();
				}
				return result;
			}
		};
		scrollPane.setViewportView(tblAttributes);
		tblAttributes.setBackground(new Color(176, 224, 230));
		tblAttributes.setName("tblAtts");
		tblAttributes.setPreferredSize(new Dimension(100, 100));
		tblAttributes.setRowSelectionAllowed(false);
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "isCtrl", "Att. Name", "Type", "Lower", "Upper" }) {
			Class[] columnTypes = new Class[] { Boolean.class, String.class, String.class, Integer.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		tableModel.addTableModelListener(new TableModelListener() {
			@java.lang.Override
			public void tableChanged(TableModelEvent e) {
				// JOptionPane.showMessageDialog(null, tableModel);
				boolean isEmptyCell = false;
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						if (tableModel.getValueAt(i, j) == null
								|| tableModel.getValueAt(i, j).toString().trim().equals("")) {
							isEmptyCell = true;
							break;
						}
					}
				}

				if (isEmptyCell || txtMsgName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else {
					if (txtMsgName.getText().trim().equals(""))
						btnConfirm.setEnabled(false);
					else
						btnConfirm.setEnabled(true);
				}

			}
		});

		tblAttributes.setModel(tableModel);

		JLabel lblMessageName = new JLabel("Message Name:");
		lblMessageName.setBounds(10, 11, 95, 23);
		getContentPane().add(lblMessageName);
		lblMessageName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessageName.setHorizontalAlignment(SwingConstants.TRAILING);

		txtMsgName = new JTextField();
		txtMsgName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent arg0) {
				if (txtMsgName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}

			@java.lang.Override
			public void keyPressed(KeyEvent arg0) {

			}
		});

		txtMsgName.setBounds(115, 11, 121, 23);
		getContentPane().add(txtMsgName);
		txtMsgName.setToolTipText("enter -1 or * for Many");
		txtMsgName.setName("txtUpper");
		txtMsgName.setColumns(10);

		JButton btnRemoveRow = new JButton("");
		btnRemoveRow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveRow.setIcon(new ImageIcon(FrmEditFeatureMessage.class.getResource("res/icon_removeButton16.png")));

		btnRemoveRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tblAttributes.getSelectedRow() >= 0)
					tableModel.removeRow(tblAttributes.getSelectedRow());
			}
		});
		btnRemoveRow.setPreferredSize(new Dimension(16, 16));
		btnRemoveRow.setBounds(294, 26, 16, 16);
		getContentPane().add(btnRemoveRow);

		JButton btnAddRow = new JButton("");
		btnAddRow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddRow.setIcon(new ImageIcon(FrmEditFeatureMessage.class.getResource("res/icon_addButton16.png")));
		btnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.addRow(new Object[] { false, "", "", 0, "" });
			}
		});
		btnAddRow.setPreferredSize(new Dimension(16, 16));
		btnAddRow.setBounds(310, 26, 16, 16);
		getContentPane().add(btnAddRow);
		tblAttributes.getColumnModel().getColumn(0).setResizable(false);
		tblAttributes.getColumnModel().getColumn(0).setPreferredWidth(45);
		tblAttributes.getColumnModel().getColumn(1).setResizable(false);
		tblAttributes.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblAttributes.getColumnModel().getColumn(2).setResizable(false);
		tblAttributes.getColumnModel().getColumn(3).setResizable(false);
		tblAttributes.getColumnModel().getColumn(3).setPreferredWidth(50);
		tblAttributes.getColumnModel().getColumn(4).setResizable(false);
		tblAttributes.getColumnModel().getColumn(4).setPreferredWidth(50);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(342, 242));

		// this.setLocation(MouseInfo.getPointerInfo().getLocation());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				"Cancel"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
			public void actionPerformed(ActionEvent e) {
				closeForm();

			}
		});

		AddKeyboardDefaultsListeners();
		createComboOfAttributeTypes();
	}

	private void createComboOfAttributeTypes() {
		TableColumn typeColumn = tblAttributes.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("int");
		comboBox.addItem("bool");
		comboBox.addItem("string");

		List<Concept> AllConcepts = ModelUtils.getWorldModelObjectsByType(msg, Concept.class);
		for (Concept att : AllConcepts) {
			String conceptName = att.getName();
			comboBox.addItem(conceptName);

		}
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(10);
		typeColumn.setCellEditor(new DefaultCellEditor(comboBox));

	}

	private void AddKeyboardDefaultsListeners() {

		// ESCAPE BUTTON REGISTER FOR THE FORM
		getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Escape", new AbstractAction() { //$NON-NLS-1$
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}
		});

		// ACCEPT BUTTON REGISTER FOR THE MESSAGE NAME TEXT BOX
		InputMap im_msgName = txtMsgName.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap am_msgName = txtMsgName.getActionMap();

		im_msgName.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "entered");
		am_msgName.put("entered", new AbstractAction() {
			@java.lang.Override
			public void actionPerformed(ActionEvent e) {
				setResultsAndExit();
			}

		});

		// ACCEPT BUTTON REGISTER FOR THE TABLE
		InputMap im_tableAttributes = tblAttributes.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap am_tableAttributes = tblAttributes.getActionMap();

		im_tableAttributes.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "entered");
		am_tableAttributes.put("entered", new AbstractAction() {
			@java.lang.Override
			public void actionPerformed(ActionEvent e) {
				setResultsAndExit();
			}

		});

		// ESCAPE BUTTON REGISTER FOR THE TABLE
		im_tableAttributes.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape");
		am_tableAttributes.put("Escape", new AbstractAction() {
			@java.lang.Override
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}

		});

	}

	private void closeForm() {

		if (tblAttributes.isEditing()) {
			tblAttributes.getCellEditor().cancelCellEditing();
		} else {
			confirmFlag = false;
			dispose();
		}
	}

	private void setResultsAndExit() {

		if (tblAttributes.isEditing()) {
			tblAttributes.getCellEditor().stopCellEditing();
		} else if (btnConfirm.isEnabled()) {

			try {

				if (!NameUniquenessVerifier.verify((Message) msg, txtMsgName.getText().replace(" ", ""), true)) {
					return;
				} else {
					newMessage.setName(txtMsgName.getText().trim());

					List<Attribute> newAttList = new ArrayList<Attribute>();

					for (int i = 0; i < tableModel.getRowCount(); i++) {
						Attribute newAtt = FormlFactory.eINSTANCE.createAttribute();

						if (tableModel.getValueAt(i, 0).equals(true)) {
							newAtt.setCtrl(true);
						} else
							newAtt.setCtrl(false);

						newAtt.setName(tableModel.getValueAt(i, 1).toString());
						newAtt.setType(ModelUtils2.createAttributeType(tableModel.getValueAt(i, 2).toString()));
						newAtt.setMultiplicity(parseMultiplicity(tableModel.getValueAt(i, 3).toString(),
								tableModel.getValueAt(i, 4).toString()));

						newAttList.add(newAtt);
					}

					newMessage.getAttributes().clear();
					newMessage.getAttributes().addAll(newAttList);

					confirmFlag = true;
					hide();
				}
			} catch (Exception e) {
				confirmFlag = false;
				e.printStackTrace();
			}

		}
	}

	private Multiplicity parseMultiplicity(String lower, String upper) {

		Multiplicity newMultiplicity = FormlFactory.eINSTANCE.createMultiplicity();

		getCardinalities(lower, upper);

		if (this.Many.equals("*") && cardLower == -1) {
			newMultiplicity.setMany("*");
		} else {
			if (this.cardLower == this.cardUpper) {
				newMultiplicity.setValue(this.cardLower);
			} else {
				Cardinality cardinality = FormlFactory.eINSTANCE.createCardinality();
				cardinality.setLower(this.cardLower);
				if (this.cardUpper == -1)
					cardinality.setMany("*");
				else
					cardinality.setUpper(this.cardUpper);

				newMultiplicity.setCardinality(cardinality);
			}
		}
		return newMultiplicity;

	}

	// private AttributeType parseAttributeType(String NewAttributeTypeName,
	// WorldModel wm) {
	//
	// AttributeType attNewType = FormlFactory.eINSTANCE.createAttributeType();
	//
	// if (NewAttributeTypeName.toLowerCase().equals("int"))
	// attNewType = FormlFactory.eINSTANCE.createIntType();
	// else if (NewAttributeTypeName.toLowerCase().equals("bool"))
	// attNewType = FormlFactory.eINSTANCE.createBoolType();
	// else {
	// // WorldModel
	// // wm=ModelUtils.RootFinderForWorldModel(oldAttributeType);
	// // JOptionPane.showMessageDialog(null, wm);
	//
	// boolean if_UT_AlreadyExisted = false;
	// for (ExprRef ut : wm.getConcepts()) {
	// if (ut.getClass().equals(UndefinedTypeImpl.class)) {
	// if (((UndefinedType)
	// ut).getName().equalsIgnoreCase(NewAttributeTypeName)) {
	// ReferenceType newrefAtt = FormlFactory.eINSTANCE.createReferenceType();
	// newrefAtt.setRef((UndefinedType) ut);
	// attNewType = newrefAtt;
	//
	// if_UT_AlreadyExisted = true;
	//
	// break;
	// }
	// }
	// }
	//
	// if (if_UT_AlreadyExisted == false) {
	// UndefinedType ut = FormlFactory.eINSTANCE.createUndefinedType();
	// ut.setName(NewAttributeTypeName);
	//
	// wm.eSetDeliver(false);
	// wm.getConcepts().add(ut);
	// wm.eSetDeliver(true);
	//
	// ReferenceType newrefAtt = FormlFactory.eINSTANCE.createReferenceType();
	// newrefAtt.setRef((UndefinedType) ut);
	// attNewType = newrefAtt;
	// }
	//
	// }
	//
	// return attNewType;
	// }

	private void getCardinalities(String Lower, String Upper) {

		try {

			boolean cardLowerSetTocardUpperFlag = false;

			if (Lower.trim().equals("")) {
				if (!Upper.trim().equals("")) {
					cardLowerSetTocardUpperFlag = true;
				} else
					cardLower = 0;
			} else {
				cardLower = (Integer.parseInt(Lower));
			}

			if (Upper.trim().equals("")) {
				if (cardLower >= 0) {
					cardUpper = cardLower;
				} else
					cardUpper = 0;
			} else if (Upper.trim().equals("*")) {
				Many = "*";
			} else if (Upper.trim().equals("-1")) {
				Many = "*";
			} else {
				cardUpper = (Integer.parseInt(Upper));

				if (cardUpper < cardLower) {
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}

				if (cardLowerSetTocardUpperFlag)
					cardLower = cardUpper;
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please check the inputs.");
		}
	}
}
