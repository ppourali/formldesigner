package uw.cs.watform.forml.services.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.CustomControls.CommonListeners;
import uw.cs.watform.forml.services.internal.CustomMessageDialogs;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.Styled_Text_NotUsed3_frmShellForTransitionLabel;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public class FrmShellForMessageEdit extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	private int Value = -1;
	private String Many = "";
	private int cardLower = -1;
	private int cardUpper = -1;

	public boolean ConfirmFlag = false;
	private Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private Table table_references;
	private Composite composite_1;

	final FrmShellForMessageEdit shellContainer = this;
	private Message ref_Message;
	private Composite composite_2;
	private Composite composite;

	private List<List<Attribute>> ToBeEdited_Atts;
	private List<List<Attribute>> ToBeAdded_Atts;
	private List<List<Attribute>> ToBeDeleted_Atts;

	private List<itemClassData> TableModel = new ArrayList<FrmShellForMessageEdit.itemClassData>();
	private Composite composite_3;
	private Text txtMessageName;
	private CLabel lblNote;

	private Button btnConfirm;
	private Button btnCancel;

	private int lastSelectedIndex = 0;

	public FrmShellForMessageEdit(Display display, Message msg, List<List<Attribute>> toBeEdited_Atts,
			List<List<Attribute>> toBeAdded_Atts, List<List<Attribute>> toBeDeleted_Atts) {

		setGlobalAttributes(display, msg, toBeEdited_Atts, toBeAdded_Atts, toBeDeleted_Atts);

		constructDesign();

		AddListeners();

		createTableModel();

	}

	private void saveResultAndExit() {
		if (verifyTableModel()) {

			String msgNewName = txtMessageName.getText().replace(" ", "").trim();

			if (!NameUniquenessVerifier.verify((Message) ref_Message, msgNewName, true)) {
				return;
			} else {
				for (TableItem ti1 : table_references.getItems()) {

					itemClassData data1 = (itemClassData) ti1.getData();
					String data1_currname = ((CCombo) data1.Curr_Name.getEditor()).getText().trim();
					int data1_action = ((CCombo) data1.Action.getEditor()).getSelectionIndex();
					String data1_newname = ((Text) data1.New_Name.getEditor()).getText().trim();
					boolean data1_ctrl = ((Button) data1.isCtrl.getEditor()).getSelection();
					String data1_type = ((CCombo) data1.Type.getEditor()).getText().trim();
					String data1_lower = ((Text) data1.Mul_Lower.getEditor()).getText().trim();
					String data1_upper = ((Text) data1.Mul_Upper.getEditor()).getText().trim();

					if (data1_action == 0) {
						Attribute old_Attribute = WorldModelCommonServices.getAttributeByName(data1_currname,
								ref_Message);
						if (old_Attribute != null) {
							old_Attribute.setName(data1_newname);
							old_Attribute.setType(ModelUtils2.createAttributeType(data1_type));
							old_Attribute.setCtrl(data1_ctrl);
							old_Attribute.setMultiplicity(parseMultiplicity(data1_lower, data1_upper));
						}
					} else if (data1_action == 1) {
						Attribute new_Attribute = FormlFactory.eINSTANCE.createAttribute();
						if (data1_newname != "") {
							new_Attribute.setName(data1_newname);
							new_Attribute.setType(ModelUtils2.createAttributeType(data1_type));
							new_Attribute.setCtrl(data1_ctrl);
							new_Attribute.setMultiplicity(parseMultiplicity(data1_lower, data1_upper));
							ref_Message.getAttributes().add(new_Attribute);
						}
					} else if (data1_action == 2) {
						Attribute old_Attribute = WorldModelCommonServices.getAttributeByName(data1_currname,
								ref_Message);
						if (old_Attribute != null) {
							EcoreUtil2.delete(old_Attribute);
						}
					}
				}

				ref_Message.setName(msgNewName);
				ConfirmFlag = true;
				shell.dispose();
			}
		}

	}

	private boolean getCardinalities(String Lower, String Upper) {

		try {

			boolean cardLowerSetTocardUpperFlag = false;

			if (Lower.trim().equals("") && Upper.trim().equals("")) {
				return false;
			} else {

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
						CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
								"Upper Bound cannot be less that the Lower Bound.");
						return false;
					}

					if (cardLowerSetTocardUpperFlag)
						cardLower = cardUpper;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error", "Please check the inputs.");
			return false;
		}
		return true;
	}

	private Multiplicity parseMultiplicity(String lower, String upper) {

		Multiplicity newMultiplicity = FormlFactory.eINSTANCE.createMultiplicity();

		if (getCardinalities(lower, upper) == false) {
			return null;
		} else {

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
		}
		return newMultiplicity;

	}

	private void constructDesign() {
		// TODO Auto-generated method stub

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

		constructShell();

		composite_3 = new Composite(shell, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(176, 224, 230));
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_3.heightHint = 32;
		composite_3.setLayoutData(gd_composite_3);
		formToolkit.adapt(composite_3);
		formToolkit.paintBordersFor(composite_3);

		txtMessageName = new Text(composite_3, SWT.BORDER);
		txtMessageName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		txtMessageName.setText(this.ref_Message.getName());
		txtMessageName.setBounds(200, 5, 107, 21);
		formToolkit.adapt(txtMessageName, true, true);

		Label lblMessageName = new Label(composite_3, SWT.NONE);
		lblMessageName.setBounds(104, 8, 84, 21);
		formToolkit.adapt(lblMessageName, true, true);
		lblMessageName.setText("Message Name:");

		table_references = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd_table_references = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_table_references.heightHint = 100;
		gd_table_references.widthHint = 395;
		table_references.setLayoutData(gd_table_references);

		formToolkit.adapt(table_references);
		formToolkit.paintBordersFor(table_references);
		table_references.setHeaderVisible(true);
		table_references.setLinesVisible(true);

		composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_1.heightHint = 60;
		gd_composite_1.widthHint = 495;
		composite_1.setLayoutData(gd_composite_1);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);

		composite_2 = new Composite(composite_1, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.widthHint = 474;
		gd_composite_2.heightHint = 32;
		composite_2.setLayoutData(gd_composite_2);
		formToolkit.adapt(composite_2);
		formToolkit.paintBordersFor(composite_2);

		lblNote = new CLabel(composite_1, SWT.NONE);
		GridData gd_lblNote = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblNote.heightHint = 16;
		lblNote.setLayoutData(gd_lblNote);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		formToolkit.adapt(lblNote);
		formToolkit.paintBordersFor(lblNote);
		lblNote.setText("Please use Shift+Enter to save the modifications in the embedder.");

		composite = new Composite(shell, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 40;
		gd_composite.widthHint = 474;
		composite.setLayoutData(gd_composite);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		btnConfirm = new Button(composite, SWT.PUSH);
		btnConfirm.setBounds(382, 5, 92, 30);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveResultAndExit();
			}
		});
		formToolkit.adapt(btnConfirm, true, true);
		btnConfirm.setText("Confirm");

		btnCancel = new Button(composite, SWT.PUSH);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfirmFlag = false;
				shell.dispose();
			}
		});
		btnCancel.setBounds(292, 5, 84, 30);
		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

	}

	private void setGlobalAttributes(Display display, Message msg, List<List<Attribute>> toBeEdited_Atts,
			List<List<Attribute>> toBeAdded_Atts, List<List<Attribute>> toBeDeleted_Atts) {

		this.ref_Message = msg;
		this.ToBeEdited_Atts = toBeEdited_Atts;
		this.ToBeAdded_Atts = toBeAdded_Atts;
		this.ToBeDeleted_Atts = toBeDeleted_Atts;

		this.display = display;
	}

	private void AddListeners() {
		table_references.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				itemClassData data1 = (itemClassData) e.item.getData();
				int data1_action = ((CCombo) data1.Action.getEditor()).getSelectionIndex();
				if (data1_action == 2) {

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		table_references.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				try {
					itemClassData data1 = (itemClassData) event.item.getData();
					int data1_action = ((CCombo) data1.Action.getEditor()).getSelectionIndex();
					if (data1_action == 2) {

					}
				} catch (Exception e) {

				}
			}

		});

		txtMessageName.addTraverseListener(createTraverseHandler());
		table_references.addTraverseListener(createTraverseHandler());
	}

	private TraverseListener createTraverseHandler() {
		return new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {

				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					btnConfirm.setFocus();

				} else if (e.detail == SWT.TRAVERSE_ESCAPE) {
					e.doit = false;
					ConfirmFlag = false;
					shell.dispose();
				}
			}
		};
	}

	private void createTableModel() {
		String[] titles = { "Curr. Name", "Action to do", "New Name", "is Ctrl", "Type", "Lower", "Upper" };
		int[] widths = { 80, 80, 80, 50, 70, 50, 50 };

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(table_references, SWT.NONE);
			column.setText(titles[loopIndex]);
		}

		setTableForAtts(ToBeEdited_Atts, "Change to", widths);
		setTableForAtts(ToBeAdded_Atts, "Add", widths);
		setTableForAtts(ToBeDeleted_Atts, "Delete", widths);

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			table_references.getColumn(loopIndex).pack();

			table_references.getColumn(loopIndex).setWidth(widths[loopIndex]);
		}

		table_references.pack();
	}

	private SelectionListener setSelectionListener(TableEditor editor) {
		SelectionListener listener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				table_references.setSelection(editor.getItem());

				itemClassData data = (itemClassData) editor.getItem().getData();
				String data_currname = ((CCombo) data.Curr_Name.getEditor()).getText().trim();
				int data_currname_index = ((CCombo) data.Curr_Name.getEditor()).getSelectionIndex();
				int data_action = ((CCombo) data.Action.getEditor()).getSelectionIndex();
				String data_newname = ((Text) data.New_Name.getEditor()).getText().trim();
				boolean data_ctrl = ((Button) data.isCtrl.getEditor()).getSelection();
				String data_type = ((CCombo) data.Type.getEditor()).getText().trim();

				if (e.getSource().equals(((CCombo) data.Curr_Name.getEditor()))) {
					// populate old values for the attribute and show in the
					// table cells
					if (data_currname_index != lastSelectedIndex) {
						lastSelectedIndex = data_currname_index;

						if (!data_currname.trim().equals("")) {
							getOldValuesForAttribute(data_currname, data);
						}
					}
				}

				if (e.getSource().equals(((CCombo) data.Action.getEditor()))) {
					// if action is change to, enable all cells
					if (data_action == 0) {
						data.setItemReadyForChangeAction();
					}
					// if action is add, disable current name cell and empty
					if (data_action == 1) {
						data.setItemReadyForAddAction();
					}
					// if action is delete, disable all cells except currname
					// and empty
					if (data_action == 2) {
						data.setItemReadyForDeleteAction();
					}
				}

				if (data_action == 2) {
					findTransitionForFirstTransition(data_currname);
				} else
					composite_2.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};

		return listener;
	}

	public void getOldValuesForAttribute(String data1_currname, itemClassData data1) {
		Attribute attribute = WorldModelCommonServices.getAttributeByName(data1_currname, ref_Message);

		((Button) data1.isCtrl.getEditor()).setSelection(attribute.isCtrl());
		((CCombo) data1.Type.getEditor()).setText(ModelUtils2.convertAttributeTypeToString(attribute.getType()));

		String[] mul = ModelUtils2.convertMultiplicityToStrings(attribute.getMultiplicity());
		((Text) data1.Mul_Lower.getEditor()).setText(mul[0]);
		((Text) data1.Mul_Upper.getEditor()).setText(mul[1]);
	}

	protected void findTransitionForFirstTransition(String attributeName) {

		Attribute att = WorldModelCommonServices.getAttributeByName(attributeName, ref_Message);

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(att,
				ModelUtils.getBehaviourModel(ref_Message));
		Iterator<Setting> it = referrers.iterator();

		if (it.hasNext()) {
			Setting referrer = (Setting) it.next();
			EObject refObject = referrer.getEObject();

			Transition trans = ModelUtils.getTypedRootForObject(refObject, Transition.class);

			createTransitionEditor(trans, true);

		}
	}

	private void setTableForAtts(List<List<Attribute>> atts, String operation, int[] widths) {

		if (atts == null)
			return;

		for (List<Attribute> att : atts) {

			TableItem item = new TableItem(table_references, SWT.BORDER);

			// attribute action to do : adding, deleting or editing
			TableEditor editor_CurrName = new TableEditor(table_references);
			CCombo combo_CurrName = new CCombo(table_references, SWT.READ_ONLY);
			combo_CurrName.add("");
			for (ExprRef cur_atts : getMessageAttributes()) {
				combo_CurrName.add(((Attribute) cur_atts).getName());
			}

			combo_CurrName.addSelectionListener(setSelectionListener(editor_CurrName));

			combo_CurrName.setEditable(false);
			combo_CurrName.pack();
			editor_CurrName.minimumWidth = widths[0];
			editor_CurrName.grabHorizontal = true;
			editor_CurrName.setEditor(combo_CurrName, item, 0);

			// attribute action to do : adding, deleting or editing
			TableEditor editor_action = new TableEditor(table_references);
			CCombo combo_action = new CCombo(table_references, SWT.BORDER);
			combo_action.setEditable(false);
			combo_action.add("Change");
			combo_action.add("Add");
			combo_action.add("Delete");

			if (operation.equalsIgnoreCase("Change to"))
				combo_action.select(0);
			else if (operation.equalsIgnoreCase("Add"))
				combo_action.select(1);
			else if (operation.equalsIgnoreCase("Delete"))
				combo_action.select(2);

			editor_action.grabHorizontal = true;
			editor_action.setEditor(combo_action, item, 1);
			combo_action.pack();
			editor_action.minimumWidth = widths[1];

			combo_action.addSelectionListener(setSelectionListener(editor_action));

			// attribute new name
			TableEditor editor_newName = new TableEditor(table_references);
			Text text_newName = new Text(table_references, SWT.BORDER);
			text_newName.pack();
			editor_newName.minimumWidth = widths[2];
			editor_newName.horizontalAlignment = SWT.LEFT;
			editor_newName.setEditor(text_newName, item, 2);
			if (att.get(1) != null) {
				text_newName.setText(att.get(1).getName());
			} else
				text_newName.setText("");

			text_newName.addSelectionListener(setSelectionListener(editor_newName));

			// attribute is Ctrl
			TableEditor editor_isCtrl = new TableEditor(table_references);
			Button chkbox_Ctrl = new Button(table_references, SWT.CHECK);
			chkbox_Ctrl.pack();
			editor_isCtrl.minimumWidth = chkbox_Ctrl.getSize().x;
			editor_isCtrl.horizontalAlignment = SWT.CENTER;
			editor_isCtrl.setEditor(chkbox_Ctrl, item, 3);
			if (att.get(1) != null) {
				chkbox_Ctrl.setSelection(att.get(1).isCtrl());
			} else
				chkbox_Ctrl.setSelection(false);

			chkbox_Ctrl.addSelectionListener(setSelectionListener(editor_isCtrl));

			// attribute type
			TableEditor editor_type = new TableEditor(table_references);
			CCombo text_type = new CCombo(table_references, SWT.NONE);
			text_type.add("int");
			text_type.add("bool");
			text_type.add("string");

			List<Concept> AllConcepts = ModelUtils.getWorldModelObjectsByType(ref_Message, Concept.class);
			for (Concept con : AllConcepts) {
				String conceptName = con.getName();
				text_type.add(conceptName);

			}
			text_type.setEditable(true);
			text_type.setVisibleItemCount(10);
			text_type.addSelectionListener(setSelectionListener(editor_type));

			text_type.pack();
			editor_type.minimumWidth = widths[4];
			editor_type.grabHorizontal = true;
			editor_type.setEditor(text_type, item, 4);
			text_type.addSelectionListener(setSelectionListener(editor_type));
			// TableEditor editor_type = new TableEditor(table_references);
			// Text text_type = new Text(table_references, SWT.BORDER);
			// text_type.pack();
			// editor_type.minimumWidth = widths[4];
			// editor_type.horizontalAlignment = SWT.LEFT;
			// editor_type.setEditor(text_type, item, 4);
			//
			// if (att.get(1) != null) {
			// text_type.setText(ModelUtils2.convertAttributeTypeToString(att.get(1).getType()));
			// } else
			// text_type.setText("");
			//
			// text_type.addSelectionListener(setSelectionListener(editor_type));

			// attribute multiplicity: lower
			TableEditor editor_lower = new TableEditor(table_references);
			Text text_lower = new Text(table_references, SWT.BORDER);
			text_lower.pack();
			editor_lower.minimumWidth = widths[5];
			editor_lower.horizontalAlignment = SWT.LEFT;
			editor_lower.setEditor(text_lower, item, 5);
			text_lower.addSelectionListener(setSelectionListener(editor_lower));
			text_lower.addKeyListener(CommonListeners.NumericalKeyListener(text_lower, false));

			// attribute multiplicity: upper
			TableEditor editor_upper = new TableEditor(table_references);
			Text text_upper = new Text(table_references, SWT.BORDER);
			editor_upper.minimumWidth = widths[6];
			editor_upper.horizontalAlignment = SWT.LEFT;
			editor_upper.setEditor(text_upper, item, 6);
			text_upper.addSelectionListener(setSelectionListener(editor_upper));
			text_upper.addKeyListener(CommonListeners.NumericalKeyListener(text_upper, true));
			text_upper.pack();

			itemClassData data = new itemClassData(editor_CurrName, editor_action, editor_newName, editor_isCtrl,
					editor_type, editor_lower, editor_upper);
			item.setData(data);

			populateInitialCellValues(att, data);

		}

	}

	private void populateInitialCellValues(List<Attribute> att, itemClassData data) {

		try {
			if (((CCombo) data.Action.getEditor()).getSelectionIndex() == 0) {
				((CCombo) data.Curr_Name.getEditor())
						.select(getComboIndexByText(((CCombo) data.Curr_Name.getEditor()), att.get(0).getName()));
				((Text) data.New_Name.getEditor()).setText(att.get(1).getName());
				((Button) data.isCtrl.getEditor()).setSelection(att.get(1).isCtrl());
				((CCombo) data.Type.getEditor())
						.setText(ModelUtils2.convertAttributeTypeToString(att.get(1).getType()));

				String[] mul = ModelUtils2.convertMultiplicityToStrings(att.get(0).getMultiplicity());
				((Text) data.Mul_Lower.getEditor()).setText(mul[0]);
				((Text) data.Mul_Upper.getEditor()).setText(mul[1]);

			} else if (((CCombo) data.Action.getEditor()).getSelectionIndex() == 1) {
				((CCombo) data.Curr_Name.getEditor()).select(0);
				((Text) data.New_Name.getEditor()).setText(att.get(1).getName());
				((Button) data.isCtrl.getEditor()).setSelection(att.get(1).isCtrl());
				((CCombo) data.Type.getEditor())
						.setText(ModelUtils2.convertAttributeTypeToString(att.get(1).getType()));

				String[] mul = ModelUtils2.convertMultiplicityToStrings(att.get(1).getMultiplicity());
				((Text) data.Mul_Lower.getEditor()).setText(mul[0]);
				((Text) data.Mul_Upper.getEditor()).setText(mul[1]);

			} else if (((CCombo) data.Action.getEditor()).getSelectionIndex() == 2) {
				((CCombo) data.Curr_Name.getEditor())
						.select(getComboIndexByText(((CCombo) data.Curr_Name.getEditor()), att.get(0).getName()));
				((Text) data.New_Name.getEditor()).setText("");
				((Button) data.isCtrl.getEditor()).setSelection(att.get(0).isCtrl());
				((CCombo) data.Type.getEditor())
						.setText(ModelUtils2.convertAttributeTypeToString(att.get(0).getType()));

				String[] mul = ModelUtils2.convertMultiplicityToStrings(att.get(0).getMultiplicity());
				((Text) data.Mul_Lower.getEditor()).setText(mul[0]);
				((Text) data.Mul_Upper.getEditor()).setText(mul[1]);
			}
		} catch (Exception e) {

		}

	}

	private boolean verifyTableModel() {

		// there are two curr_atts with the same attribute name
		for (TableItem ti1 : table_references.getItems()) {

			itemClassData data1 = (itemClassData) ti1.getData();
			String data1_curname = ((CCombo) data1.Curr_Name.getEditor()).getText().trim();

			for (TableItem ti2 : table_references.getItems()) {

				if (ti1.equals(ti2))
					continue;

				itemClassData data2 = (itemClassData) ti2.getData();
				String data2_curname = ((CCombo) data2.Curr_Name.getEditor()).getText().trim();

				if (data1_curname.equalsIgnoreCase(data2_curname)) {
					if (data1_curname != "" && data2_curname != "") {
						CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
								"There are multiple actions applying on the same attribute. Please double check.");
						return false;
					}
				}
			}
		}

		// there are two new_atts with the same attribute name
		for (TableItem ti1 : table_references.getItems()) {

			itemClassData data1 = (itemClassData) ti1.getData();
			String data1_newname = ((Text) data1.New_Name.getEditor()).getText().trim();

			for (TableItem ti2 : table_references.getItems()) {

				if (ti1.equals(ti2))
					continue;

				itemClassData data2 = (itemClassData) ti2.getData();
				String data2_newname = ((Text) data2.New_Name.getEditor()).getText().trim();

				if (data1_newname.equalsIgnoreCase(data2_newname)) {
					if (data1_newname != "" && data2_newname != "") {
						CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
								"There are multiple attributes being added with the same name. Please double check.");
						return false;
					}
				}
			}

		}

		// there are new_atts to be added which currently exist, unless one is
		// add and one is delete
		for (TableItem ti1 : table_references.getItems()) {

			itemClassData data1 = (itemClassData) ti1.getData();
			String data1_newname = ((Text) data1.New_Name.getEditor()).getText().trim();
			int data1_action = ((CCombo) data1.Action.getEditor()).getSelectionIndex();
			// if is add
			if (data1_action == 1) {
				for (TableItem ti2 : table_references.getItems()) {

					itemClassData data2 = (itemClassData) ti2.getData();
					String data2_curName = ((CCombo) data2.Curr_Name.getEditor()).getText().trim();
					int data2_action = ((CCombo) data2.Action.getEditor()).getSelectionIndex();
					// if is not delete
					if (data2_action != 2) {
						if (data1_newname.equalsIgnoreCase(data2_curName)) {
							if (data1_newname != "" && data2_curName != "") {
								CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
										"There are attributes being added which already exist in the message. Please double check.");
								return false;
							}
						}
					}
				}
			}
		}

		// if it is a change action , both currname and new name must be filled
		for (TableItem ti1 : table_references.getItems()) {

			itemClassData data1 = (itemClassData) ti1.getData();
			String data1_curname = ((CCombo) data1.Curr_Name.getEditor()).getText().trim();
			int data1_action = ((CCombo) data1.Action.getEditor()).getSelectionIndex();
			String data1_newname = ((Text) data1.New_Name.getEditor()).getText().trim();

			// if is change actions
			if (data1_action == 0) {
				if (data1_curname.trim().equals("") && !data1_newname.trim().equals("")) {
					CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
							"Current Name cell value is empty for a change action.Please double check.");
					return false;
				}
				if (!data1_curname.trim().equals("") && data1_newname.trim().equals("")) {
					CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
							"New Name cell value is empty for a change action.Please double check.");
					return false;
				}
			}
		}

		// if multiplicity values are not valid
		for (TableItem ti : table_references.getItems()) {

			itemClassData data = (itemClassData) ti.getData();
			String data_lower = ((Text) data.Mul_Lower.getEditor()).getText().trim();
			String data_upper = ((Text) data.Mul_Upper.getEditor()).getText().trim();
			int data_action = ((CCombo) data.Action.getEditor()).getSelectionIndex();

			if (data_action == 0 || data_action == 1) {
				if (!data_lower.equals("")) {
					try {
						Integer.parseInt(data_lower);
					} catch (Exception e) {
						CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
								"Multiplicity Lower values is not valid.Please double check.");
						return false;
					}
				}

				if (!data_upper.equals("") && !data_upper.equals("*")) {
					try {
						Integer.parseInt(data_upper);
					} catch (Exception e) {
						CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
								"Multiplicity Upper values is not valid.Please double check.");
						return false;
					}
				}
			}
		}

		// deleting referenced attributes
		for (TableItem ti : table_references.getItems()) {

			itemClassData data = (itemClassData) ti.getData();
			String data_currname = ((CCombo) data.Curr_Name.getEditor()).getText().trim();
			int data_action = ((CCombo) data.Action.getEditor()).getSelectionIndex();

			if (data_action == 2) {

				Attribute attToBeDeleted = WorldModelCommonServices.getAttributeByName(data_currname, ref_Message);
				Collection<Setting> referrers = ModelUtils2.findReferencedObjects(attToBeDeleted,
						ModelUtils.getBehaviourModel(ref_Message));

				if (referrers.size() > 0) {
					CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
							"There are attrributes to be deleted which have " + referrers.size()
									+ " reference in the behavioural model. Please fix them before deleting the attributes.");
					return false;
				}
			}
		}

		return true;
	}

	private int getComboIndexByText(CCombo combo, String itemText) {
		for (int i = 0; i < combo.getItems().length; i++) {
			if (combo.getItem(i).trim().equalsIgnoreCase(itemText.trim()))
				return i;
		}
		return 0;
	}

	private EList<ExprRef> getMessageAttributes() {
		return ref_Message.getAttributes();
	}

	private void createTransitionEditor(Transition trans, boolean isEdit) {

		// Create Editor For the Whole Transition
		XtextEmbeddedEditorForCrossReferences transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences(
				ModelUtils.getInjector(), isEdit);

		transition_embeddedEditor.shellContainer = shellContainer;

		composite_2.dispose();
		composite_2 = new Composite(composite_1, SWT.NONE);

		transition_embeddedEditor.showEditor(trans, composite_2);
		composite_2.update();
		composite_2.pack();
		composite_2.setSize(composite_1.getSize());

	}

	private void constructShell() {

		shell = new Shell(display, SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		//addShellListenerForAutoDisposeOnDeactive();

		
		shell.setSize(510, 310);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		// Image small = new Image(display,"yourFile.gif");
		// shell.setImage(small);

		shell.setText("Message Edit Dialog");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, dim.height / 2 - shell.getSize().y / 2);

	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private class itemClassData {
		public TableEditor Curr_Name;
		public TableEditor Action;
		public TableEditor New_Name;
		public TableEditor isCtrl;
		public TableEditor Type;
		public TableEditor Mul_Lower;
		public TableEditor Mul_Upper;

		public itemClassData(TableEditor currname, TableEditor acion, TableEditor newname, TableEditor isctrl,
				TableEditor type, TableEditor lower, TableEditor upper) {

			this.Curr_Name = currname;
			this.Action = acion;
			this.New_Name = newname;
			this.isCtrl = isctrl;
			this.Type = type;
			this.Mul_Lower = lower;
			this.Mul_Upper = upper;
		}

		public void setItemReadyForChangeAction() {
			activateCell(this.Curr_Name.getEditor());
			activateCell(this.New_Name.getEditor());
			activateCell(this.isCtrl.getEditor());
			activateCell(this.Type.getEditor());
			activateCell(this.Mul_Lower.getEditor());
			activateCell(this.Mul_Upper.getEditor());
		}

		public void setItemReadyForAddAction() {
			deactivateCell(this.Curr_Name.getEditor());

			activateCell(this.New_Name.getEditor());
			activateCell(this.isCtrl.getEditor());
			activateCell(this.Type.getEditor());
			activateCell(this.Mul_Lower.getEditor());
			activateCell(this.Mul_Upper.getEditor());
		}

		public void setItemReadyForDeleteAction() {
			activateCell(this.Curr_Name.getEditor());

			deactivateCell(this.New_Name.getEditor());
			deactivateCell(this.isCtrl.getEditor());
			deactivateCell(this.Type.getEditor());
			deactivateCell(this.Mul_Lower.getEditor());
			deactivateCell(this.Mul_Upper.getEditor());
		}

		private void deactivateCell(Control control) {
			control.setEnabled(false);

			if (control instanceof CCombo)
				((CCombo) control).select(0);
			else if (control instanceof Text)
				((Text) control).setText("");
		}

		private void activateCell(Control control) {
			control.setEnabled(true);
		}
	}
}