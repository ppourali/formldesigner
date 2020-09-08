package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomElementEditorFromCrossReferenceViewer;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmShellForCrossReferenceView_NEWBUTNOTUSED extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	// private Composite composite_1;

	final FrmShellForCrossReferenceView_NEWBUTNOTUSED shellContainer = this;
	Collection<Setting> crossReferences;
	// private Composite composite_2;
	private Composite composite;
	private Message ref_Message;
	private CLabel lblNote;

	private List<CustomElementEditorFromCrossReferenceViewer> ElementEditorsList = new ArrayList<CustomElementEditorFromCrossReferenceViewer>();
	// Shell shell;

	public FrmShellForCrossReferenceView_NEWBUTNOTUSED(Display display, Collection<Setting> crossRefs, Message msg) {

		formToolkit.setBackground(null);

		this.crossReferences = crossRefs;
		this.ref_Message = msg;

		this.display = display;
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		shell.setBackground(SWTResourceManager.getColor(176, 224, 230));
		// addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(356, 69);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

		// createTableModel();
		RowLayout rl_shell = new RowLayout(SWT.VERTICAL);
		rl_shell.fill = true;
		shell.setLayout(rl_shell);

		// Composite composite_3 = new Composite(sashForm, SWT.NONE);
		// formToolkit.adapt(composite_3);
		// formToolkit.paintBordersFor(composite_3);
		// RowLayout rl_composite_3 = new RowLayout(SWT.VERTICAL);
		// rl_composite_3.marginTop = 5;
		// rl_composite_3.fill = true;
		// composite_3.setLayout(rl_composite_3);

		// CLabel lblElement = new CLabel(composite_3, SWT.NONE);
		// formToolkit.adapt(lblElement);
		// formToolkit.paintBordersFor(lblElement);
		// lblElement.setText("Element");

		// CLabel lblAction = new CLabel(composite_3, SWT.NONE);
		// lblAction.setText("Action");
		// formToolkit.adapt(lblAction);
		// formToolkit.paintBordersFor(lblAction);

		// StyledText txtElementName = new StyledText(composite_3, SWT.BORDER);
		// formToolkit.adapt(txtElementName);
		// formToolkit.paintBordersFor(txtElementName);

		// Combo comboAction = new Combo(composite_3, SWT.NONE);
		// comboAction.setLayoutData(new RowData(91, SWT.DEFAULT));
		// comboAction.setItems(new String[] {"Edit", "Delete"});
		// formToolkit.adapt(comboAction);
		// formToolkit.paintBordersFor(comboAction);

		// composite_1 = new Composite(sashForm, SWT.NONE);
		// formToolkit.adapt(composite_1);
		// formToolkit.paintBordersFor(composite_1);
		// composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		//
		// composite_2 = new Composite(composite_1, SWT.NONE);
		// formToolkit.adapt(composite_2);
		// formToolkit.paintBordersFor(composite_2);
		// sashForm.setWeights(new int[] {1, 2});

		lblNote = new CLabel(shell, SWT.NONE);
		lblNote.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblNote.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		// formToolkit.adapt(lblNote);
		// formToolkit.paintBordersFor(lblNote);
		lblNote.setText("Inconsistencies are found.");

		// composite = new Composite(shell, SWT.NONE);
		// formToolkit.adapt(composite);
		// formToolkit.paintBordersFor(composite);
		// composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {

			}
		});

		addKeyListener();

		PopulateInconsistentElementInForm();

		shell.pack();


}

	private void CreateElementEditor(Transition trans) {
		CustomElementEditorFromCrossReferenceViewer sashForm = new CustomElementEditorFromCrossReferenceViewer(shell,
				SWT.NONE, shellContainer, this.formToolkit);

		// sashForm.setLayoutData(new RowData(551, 58));
		// formToolkit.adapt(sashForm);
		// formToolkit.paintBordersFor(sashForm);

		sashForm.initialize(trans);

		ElementEditorsList.add(sashForm);
	}

	private TraverseListener createTraverseHandler() {
		return new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {

				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					// btnConfirmDelete.setFocus();
				} else if (e.detail == SWT.TRAVERSE_ESCAPE) {
					e.doit = false;
					ConfirmFlag = false;
					shell.dispose();
				}
			}
		};
	}

	private void PopulateInconsistentElementInForm() {
		int count_Inonsistencies = 0;

		List<Transition> alreaddyAdded = new ArrayList<Transition>();
		Iterator<Setting> iter = crossReferences.iterator();
		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();

			Transition parentTransition = ModelUtils.getTypedRootForObject(ref, Transition.class);

			if (parentTransition != null) {
				if (!alreaddyAdded.contains(parentTransition)) {
					FeatureModule fm = ModelUtils.getTypedRootForObject(parentTransition, FeatureModule.class);
					String text = ModelUtils.getTextForModelObjects(parentTransition);

					CreateElementEditor(parentTransition);
					alreaddyAdded.add(parentTransition);
					count_Inonsistencies++;
				}
			}
		}
		if (count_Inonsistencies > 0) {
			lblNote.setText("Total Number of Inconsistencies: " + count_Inonsistencies);
		}
	}

	// private void createTableModel() {
	// String[] titles = { "Feature", "Action to do" };
	//
	// for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	// TableColumn column = new TableColumn(table_references, SWT.NULL);
	// column.setText(titles[loopIndex]);
	// }
	//
	// List<Transition> alreaddyAdded = new ArrayList<Transition>();
	// Iterator<Setting> iter = crossReferences.iterator();
	// while (iter.hasNext()) {
	// EObject ref = iter.next().getEObject();
	//
	//
	//
	// Transition parentTransition = ModelUtils.getTypedRootForObject(ref,
	// Transition.class);
	//
	// if (parentTransition != null) {
	// if (!alreaddyAdded.contains(parentTransition)) {
	// FeatureModule fm = ModelUtils.getTypedRootForObject(parentTransition,
	// FeatureModule.class);
	// String text = ModelUtils.getTextForModelObjects(parentTransition);
	//
	// CreateElementEditor();
	//
	//
	// TableItem item = new TableItem(table_references, SWT.NULL);
	//
	// TableEditor editor = new TableEditor(table_references);
	// CCombo combo = new CCombo(table_references, SWT.NONE);
	// combo.setEditable(false);
	// combo.add("Edit");
	// combo.add("Delete");
	// combo.select(0);
	// editor.grabHorizontal = true;
	// editor.setEditor(combo, item, 1);
	//
	//
	//
	// if (table_references.getSelection() != null &&
	// table_references.getSelection().length > 0) {
	// if (table_references.getSelection()[0].equals(editor.getItem())) {
	//
	// Transition trans = ((itemClassData) editor.getItem().getData()).transition;
	// boolean isEdit = ((itemClassData) editor.getItem().getData()).edit;
	//
	// createTransitionEditor(trans, isEdit);
	// }
	// }
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent e) {
	// if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Edit")) {
	// editor.getItem().setBackground(SWTResourceManager.getColor(213, 246, 204));
	// ((itemClassData) editor.getItem().getData()).edit = true;
	// } else if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Delete")) {
	// editor.getItem().setBackground(SWTResourceManager.getColor(253, 198, 198));
	// ((itemClassData) editor.getItem().getData()).edit = false;
	// }
	//
	// if (table_references.getSelection() != null &&
	// table_references.getSelection().length > 0) {
	// if (table_references.getSelection()[0].equals(editor.getItem())) {
	// Transition trans = ((itemClassData) editor.getItem().getData()).transition;
	// boolean isEdit = ((itemClassData) editor.getItem().getData()).edit;
	//
	// createTransitionEditor(trans, isEdit);
	// }
	// }
	// }
	// });
	//
	// item.setText(0, fm.getFeatureref().getName());
	// item.setBackground(SWTResourceManager.getColor(213, 246, 204));
	//
	// itemClassData data = new itemClassData(parentTransition, true);
	// item.setData(data);
	//
	// alreaddyAdded.add(parentTransition);
	// }
	// }
	// }
	//
	// for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	// table_references.getColumn(loopIndex).pack();
	// }
	//
	// }
	//

	private void constructDesign(Shell shell) {
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

		shell.setText("Interactive Consistency Manager");
		// shell.setLocation((int)
		// MouseInfo.getPointerInfo().getLocation().getX(),
		// (int) MouseInfo.getPointerInfo().getLocation().getY());
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

	private void addKeyListener() {

		// table_references.getItem(0).addKeyListener(new KeyListener() {
		//
		// @Override
		// public void keyReleased(KeyEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void keyPressed(KeyEvent e) {
		// switch (e.keyCode) {
		// case SWT.CR:
		// JOptionPane.showMessageDialog(null, e);
		// case SWT.ESC:
		// JOptionPane.showMessageDialog(null, "ESC");
		// break;
		// }
		//
		// }
		// });
	}

}
