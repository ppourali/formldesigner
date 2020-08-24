package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.services.internal.CustomMessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences;

public class FrmShellForCrossReferenceView_TabularNOTUSED extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private Table table_references;
	private Composite composite_1;

	final FrmShellForCrossReferenceView_TabularNOTUSED shellContainer = this;
	Collection<Setting> crossReferences;
	private Composite composite_2;
	private Composite composite;
	private Message ref_Message;
	private CLabel lblNote;

	private Button btnConfirmDelete;
	private Button btnCancel;

	 Shell shell;
	private Composite composite_3;
	private Button chkbkxViewGraphicalEditor;

	public FrmShellForCrossReferenceView_TabularNOTUSED(Display display, Collection<Setting> crossRefs, Message concept) {

		this.crossReferences = crossRefs;
		this.ref_Message = concept;
		this.display = display;

		constructDesign();

		// shell.pack();
		Helper_InteractiveConsistencyManage.setEditors_Before();
		createTableModel();
		addListeners();
	}

	private String getDiagramName(FeatureModule fm) {
		return RepresentationsUtils.getRepresentationForAnyObject(fm, true).iterator().next().getName();
	}

	private void viewDiagramEditor(Transition trans) {
		Helper_InteractiveConsistencyManage.transition = trans;
		FeatureModule fm = ModelUtils.getTypedRootForObject(trans, FeatureModule.class);
		RepresentationsUtils.openRepresentationInAParentShell(this.shell,
				ModelUtils.getTypedRootForObject(trans, FeatureModule.class), 0, this.shell.getSize().y);
	}

	private void createTableModel() {
		// table_references.clearAll();
		// table_references.removeAll();

		String[] titles = { "Status", "Containing Diagram", "Transition Name", "Action to do", "Deleting Element" };

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(table_references, SWT.NULL);
			column.setText(titles[loopIndex]);
		}

		List<Transition> alreaddyAdded = new ArrayList<Transition>();
		Iterator<Setting> iter = crossReferences.iterator();

		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();

			Transition parentTransition = ModelUtils.getTypedRootForObject(ref, Transition.class);

			if (parentTransition != null) {
				if (!alreaddyAdded.contains(parentTransition)) {
					FeatureModule fm = ModelUtils.getTypedRootForObject(parentTransition, FeatureModule.class);
					String text = ModelUtils.getTextForModelObjects(parentTransition);

					TableItem item = new TableItem(table_references, SWT.NULL);

					item.setText(0, "Unresolved");

					item.setText(1, getDiagramName(fm));

					item.setBackground(SWTResourceManager.getColor(213, 246, 204));

					item.setText(2, parentTransition.getName());
					item.setBackground(SWTResourceManager.getColor(213, 246, 204));

					TableEditor editor = new TableEditor(table_references);
					CCombo comboAction = new CCombo(table_references, SWT.NONE);
					comboAction.setEditable(false);
					comboAction.add("Edit");
					comboAction.add("Delete");
					comboAction.select(0);
					editor.grabHorizontal = true;
					editor.setEditor(comboAction, item, 3);

					comboAction.addSelectionListener(new SelectionListener() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Edit")) {
								editor.getItem().setBackground(SWTResourceManager.getColor(213, 246, 204));
								((itemClassData) editor.getItem().getData()).edit = true;
							} else if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Delete")) {
								editor.getItem().setBackground(SWTResourceManager.getColor(253, 198, 198));
								((itemClassData) editor.getItem().getData()).edit = false;
							}

							if (table_references.getSelection() != null && table_references.getSelection().length > 0) {
								if (table_references.getSelection()[0].equals(editor.getItem())) {

									Transition trans = ((itemClassData) editor.getItem().getData()).transition;
									boolean isEdit = ((itemClassData) editor.getItem().getData()).edit;

									createTransitionEditor(trans, isEdit);
								}
							}
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent e) {
							if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Edit")) {
								editor.getItem().setBackground(SWTResourceManager.getColor(213, 246, 204));
								((itemClassData) editor.getItem().getData()).edit = true;
							} else if (((CCombo) e.widget).getText().trim().equalsIgnoreCase("Delete")) {
								editor.getItem().setBackground(SWTResourceManager.getColor(253, 198, 198));
								((itemClassData) editor.getItem().getData()).edit = false;
							}

							if (table_references.getSelection() != null && table_references.getSelection().length > 0) {
								if (table_references.getSelection()[0].equals(editor.getItem())) {
									Transition trans = ((itemClassData) editor.getItem().getData()).transition;
									boolean isEdit = ((itemClassData) editor.getItem().getData()).edit;

									createTransitionEditor(trans, isEdit);
								}
							}
						}
					});

					TableEditor editorForDeletingElement = new TableEditor(table_references);
					CCombo comboDeleteElement = new CCombo(table_references, SWT.NONE);
					comboDeleteElement.setEditable(false);
					String firstItemText = "Unknown";
					if (ref instanceof WCE)
						firstItemText = "Event";
					else if (ModelUtils.getTypedRootForObject(ref, Guard.class) != null)
						firstItemText = "Guard";
					else if (ref instanceof Action)
						firstItemText = "Effect";

					if (!firstItemText.equalsIgnoreCase("Unknown"))
						comboDeleteElement.add(firstItemText);

					comboDeleteElement.add("Transition");
					comboDeleteElement.select(0);
					editorForDeletingElement.grabHorizontal = true;
					editorForDeletingElement.setEditor(comboDeleteElement, item, 4);

					comboDeleteElement.addSelectionListener(new SelectionListener() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							if (((CCombo) e.widget).getSelectionIndex() == 0) {
								((itemClassData) editor.getItem().getData()).setDeletingElement(false);
							} else if (((CCombo) e.widget).getSelectionIndex() == 1) {
								((itemClassData) editor.getItem().getData()).setDeletingElement(true);
							}
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent e) {
							if (((CCombo) e.widget).getSelectionIndex() == 0) {
								((itemClassData) editor.getItem().getData()).setDeletingElement(false);
							} else if (((CCombo) e.widget).getSelectionIndex() == 1) {
								((itemClassData) editor.getItem().getData()).setDeletingElement(true);
							}
						}
					});

					itemClassData data = new itemClassData(parentTransition, ref, true);
					item.setData(data);

					alreaddyAdded.add(parentTransition);

					// viewDiagram(fm);
				}
			}

		}

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			table_references.getColumn(loopIndex).pack();
		}

	}

	private void RefreshTableModel() {

		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(ref_Message);
		List<Transition> parentTransitions = ModelUtils2.findTransitionParentForReferrers(referrers);

		for (TableItem item : table_references.getItems()) {
			if (item.getData() instanceof itemClassData) {
				itemClassData data = ((itemClassData) item.getData());

				if (! parentTransitions.contains(data.transition)) {
					item.setText(0, "Resolved");
					item.setBackground(SWTResourceManager.getColor(66, 191, 244));
				}

			}
		}
	}

	private void createTransitionEditor(Transition trans, boolean isEdit) {

		// Create Editor For the Whole Transition
		XtextEmbeddedEditorForCrossReferences transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences(
				ModelUtils.getInjector(), isEdit);
		//
		transition_embeddedEditor.shellContainer = shellContainer;
		//
		composite_2.dispose();
		composite_2 = new Composite(composite_1, SWT.NONE);
		//
		transition_embeddedEditor.showEditor(trans, composite_2);
		composite_2.update();
		composite_2.pack();
		composite_2.setSize(composite_1.getSize());

		if (chkbkxViewGraphicalEditor.getSelection())
			viewDiagramEditor(trans);

	}

	private void addListeners() {
		table_references.addTraverseListener(createTraverseHandler());

		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				RefreshTableModel();
			}
		});

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				Helper_InteractiveConsistencyManage.CloseJustOpenedEditors();
				Helper_InteractiveConsistencyManage.ReactivateEditorAndResetEditors();
			}
		});

		btnConfirmDelete.addSelectionListener(ConfirmAndAcceptChanges());

		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfirmFlag = false;
				shell.dispose();
			}
		});

		// Retrieve the actual object from the Model and Opens the TextualEditor For it.
		table_references.addListener(SWT.Selection, SelectAndViewEobject());
	}

	private Listener SelectAndViewEobject() {
		return new Listener() {

			public void handleEvent(Event event) {

				try {

					Transition trans = ((itemClassData) event.item.getData()).transition;
					boolean isEdit = ((itemClassData) event.item.getData()).edit;

					createTransitionEditor(trans, isEdit);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};
	}

	private SelectionListener ConfirmAndAcceptChanges() {
		return new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(ref_Message);
				List<Transition> parentTransitions = ModelUtils2.findTransitionParentForReferrers(referrers);

				if (referrers.size() > 0) {

					for (TableItem ti : table_references.getItems()) {
						itemClassData data = (itemClassData) ti.getData();
						if (data.edit) {

							if (parentTransitions.contains(data.transition)) {
								CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
										"There are still references in the behavioural model. Please fix them before going further.");
								return;
							}
						}
					}
				}

				for (TableItem ti : table_references.getItems()) {
					itemClassData data = (itemClassData) ti.getData();
					// if it is meant to be deleted
					if (data.edit == false) {

						EcoreUtil.delete(data.getDeletingElement());
					}
				}

				ConfirmFlag = true;
				shell.dispose();

			}
		};
	}

	private TraverseListener createTraverseHandler() {
		return new TraverseListener() {
			@Override
			public void keyTraversed(TraverseEvent e) {

				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					btnConfirmDelete.setFocus();
				} else if (e.detail == SWT.TRAVERSE_ESCAPE) {
					e.doit = false;
					ConfirmFlag = false;
					shell.dispose();
				}
			}
		};
	}

	private void constructDesign() {
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		// addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(900, 274);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, dim.height / 2 - shell.getSize().y / 2);

		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		table_references = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd_table_references = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_table_references.heightHint = 142;
		gd_table_references.widthHint = 470;
		table_references.setLayoutData(gd_table_references);

		formToolkit.adapt(table_references);
		formToolkit.paintBordersFor(table_references);
		table_references.setHeaderVisible(true);
		table_references.setLinesVisible(true);

		composite_1 = new Composite(shell, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_1.widthHint = 323;
		composite_1.setLayoutData(gd_composite_1);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		composite_2 = new Composite(composite_1, SWT.NONE);
		formToolkit.adapt(composite_2);
		formToolkit.paintBordersFor(composite_2);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

		composite_3 = new Composite(shell, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_composite_3.heightHint = 19;
		gd_composite_3.widthHint = 394;
		composite_3.setLayoutData(gd_composite_3);
		formToolkit.adapt(composite_3);
		formToolkit.paintBordersFor(composite_3);

		lblNote = new CLabel(composite_3, SWT.NONE);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		formToolkit.adapt(lblNote);
		formToolkit.paintBordersFor(lblNote);
		lblNote.setText("Please use Shift+Enter to save the modifications in the textual editor.");

		chkbkxViewGraphicalEditor = new Button(composite_3, SWT.CHECK);
		formToolkit.adapt(chkbkxViewGraphicalEditor, true, true);
		chkbkxViewGraphicalEditor.setText("View Graphical Editor");

		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_composite.heightHint = 36;
		gd_composite.widthHint = 258;
		composite.setLayoutData(gd_composite);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TabularNOTUSED.class,
				"/uw/cs/watform/forml/services/GUI/res/window_close.png"));

		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

		btnConfirmDelete = new Button(composite, SWT.NONE);
		btnConfirmDelete.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TabularNOTUSED.class,
				"/uw/cs/watform/forml/services/GUI/res/window_accept.png"));

		formToolkit.adapt(btnConfirmDelete, true, true);
		btnConfirmDelete.setText("Apply Changes");

		table_references.pack();
		
		shell.open();
	}

	public void open() {
		
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}

	}

	private class itemClassData {
		public Transition transition;
		public boolean edit;
		public EObject actualObject;
		private EObject deletingElement;
		private boolean deleteParent;

		public itemClassData(Transition parentTransition, EObject ref, boolean b) {
			this.transition = parentTransition;

			setActualObject(ref);

			this.edit = b;
			setDeletingElement(false);
		}

		private void setActualObject(EObject ref) {
			if (ModelUtils.getTypedRootForObject(ref, Trigger.class) != null)
				this.actualObject = ModelUtils.getTypedRootForObject(ref, Trigger.class);
			else if (ModelUtils.getTypedRootForObject(ref, Guard.class) != null)
				this.actualObject = ModelUtils.getTypedRootForObject(ref, Guard.class);
			else if (ModelUtils.getTypedRootForObject(ref, WCA.class) != null)
				this.actualObject = ModelUtils.getTypedRootForObject(ref, WCA.class);
			else
				this.actualObject = ref;
		}

		public EObject getDeletingElement() {
			return deletingElement;
		}

		public void setDeletingElement(boolean withParent) {
			this.deleteParent = withParent;

			if (deleteParent) {
				this.deletingElement = this.transition;
			} else {
				this.deletingElement = this.actualObject;
			}

		}

	}
}
