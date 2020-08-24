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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import com.sun.webkit.graphics.Ref;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.SeachEverything.CustomCompositeSearchForEveryThing;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.wb.swt.ResourceManager;

public class FrmShellForCrossReferenceView_TreeStyle extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Composite composite_TreeAndEditorHolder;

	final FrmShellForCrossReferenceView_TreeStyle shellContainer = this;
	List<EObject> crossReferences = new ArrayList<EObject>();
	private Composite composite_TextualEditor;
	private Composite composite;
	private EObject deletingElemenet;
	private CLabel lblNote;

	private Button btnConfirmDelete;
	private Button btnCancel;
	private CustomTreeNodeForConsistencyManagement composite_TreeHolder;

	//Shell shell;
	private Button chkbkxViewGraphicalEditor;
	private Button btnNewButton;
	private Composite composite_SearchHolder;
	CustomCompositeSearchForEveryThing copositeSearchForEveryThing;
	
	private Composite composite_TextualRepresentation;

	public FrmShellForCrossReferenceView_TreeStyle(Display display, Collection<Setting> crossRefs, EObject elem) {

		generateCrossRefsFromCollection(crossRefs);
		this.deletingElemenet = elem;
		this.display = display;

		constructDesign();

		// used to view graphical editor in the interactive view
		Helper_InteractiveConsistencyManage.setEditors_Before();
		addListeners();
	}

	private void generateCrossRefsFromCollection(Collection<Setting> crossRefs) {
		Iterator<Setting> iter = crossRefs.iterator();
//
		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();
			//
			// Transition parentTransition = ModelUtils.getTypedRootForObject(ref,
			// Transition.class);
//
			// if (parentTransition != null) {
			// if (!alreaddyAdded.contains(parentTransition)) {
			this.crossReferences.add(ref);
			// alreaddyAdded.add(parentTransition);
			// }
			// }
		}

	}

	private void addListeners() {

		shell.addListener(SWT.Close, new Listener() {

			@Override
			public void handleEvent(Event event) {
				event.doit = false;
				CancelAndCloseForm();
			}
		});
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
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
				CancelAndCloseForm();
			}
		});

		createTraverseHandler();
	}

	protected void CancelAndCloseForm() {
		ConfirmFlag = false;
		shell.dispose();

	}

	private SelectionListener ConfirmAndAcceptChanges() {
		return new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// find all the referres, if it is in the edit mode, it should be fixed, and the
				// message should be shown. But if in delete mode, just delete. First check the
				// edits and the the deletes.
				boolean checkResult = composite_TreeHolder.checkForConfirmation(deletingElemenet);
				if (checkResult) {
					ConfirmFlag = true;
					shell.dispose();
				} else {
					ConfirmFlag = false;
				}
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
		shell = new Shell(display, SWT.DIALOG_TRIM | SWT.TOOL | SWT.ON_TOP);
		// addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(900, 353);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");
		//shell.setBackground(SWT.INHERIT_FORCE);
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		shell.setText(getInfoText());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, 100);

		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		composite_TreeAndEditorHolder = new Composite(shell, SWT.NONE);
		composite_TreeAndEditorHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		GridLayout gl_treeandeditor = new GridLayout(2, false);
		gl_treeandeditor.makeColumnsEqualWidth = true;
		composite_TreeAndEditorHolder.setLayout(gl_treeandeditor);

		formToolkit.adapt(composite_TreeAndEditorHolder);
		formToolkit.paintBordersFor(composite_TreeAndEditorHolder);
		// lblInfoText.setSize(20, 20);
		composite_TreeHolder = new CustomTreeNodeForConsistencyManagement(composite_TreeAndEditorHolder,
				crossReferences, SWT.BORDER);
		composite_TreeHolder.setLayout(new GridLayout(1, false));

		composite_TreeHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));

		chkbkxViewGraphicalEditor = new Button(composite_TreeHolder, SWT.CHECK);
		chkbkxViewGraphicalEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(chkbkxViewGraphicalEditor, true, true);
		chkbkxViewGraphicalEditor.setText("View Graphical Editor on Edit Action");

		composite_TextualRepresentation = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);
		composite_TextualRepresentation.setLayout(new GridLayout(1, false));
		composite_TextualRepresentation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 3));
		formToolkit.adapt(composite_TextualRepresentation);
		formToolkit.paintBordersFor(composite_TextualRepresentation);

		lblNote = new CLabel(composite_TextualRepresentation, SWT.NONE);
		lblNote.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblNote.setRightMargin(10);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		formToolkit.adapt(lblNote);
		formToolkit.paintBordersFor(lblNote);
		lblNote.setText("Please use Shift+Enter to save the modifications in the textual editor.");

		composite_TextualEditor = new Composite(composite_TextualRepresentation, SWT.BORDER);
		composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		formToolkit.adapt(composite_TextualEditor);
		formToolkit.paintBordersFor(composite_TextualEditor);

		

		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_composite.heightHint = 36;
		gd_composite.widthHint = 258;
		composite.setLayoutData(gd_composite);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/window_close.png"));

		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

		btnConfirmDelete = new Button(composite, SWT.NONE);
		btnConfirmDelete.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/window_accept.png"));

		formToolkit.adapt(btnConfirmDelete, true, true);
		btnConfirmDelete.setText("Apply Changes");

		btnNewButton = new Button(shell, SWT.TOGGLE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openSearchForEveryThingDialogue();
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/searchIcon.png"));
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Look For Elemenets");

		composite_SearchHolder = new Composite(shell, SWT.NONE);
		composite_SearchHolder.setLayout(new FillLayout(SWT.HORIZONTAL));

		GridData compositeData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		compositeData.heightHint = 100;
		compositeData.exclude = true;
		composite_SearchHolder.setVisible(false);
		composite_SearchHolder.setLayoutData(compositeData);
		formToolkit.adapt(composite_SearchHolder);
		formToolkit.paintBordersFor(composite_SearchHolder);

		copositeSearchForEveryThing = new CustomCompositeSearchForEveryThing(composite_SearchHolder, SWT.NONE,
				this.deletingElemenet);

		setTreeHolderControls();
		shell.open();
	}

	

	protected void openSearchForEveryThingDialogue() {

		final GridData data = (GridData) composite_SearchHolder.getLayoutData();

		data.exclude = !data.exclude;
		composite_SearchHolder.setVisible(!data.exclude);
		if (data.exclude == true) {
			// composite_SearchHolder.getParent().pack();
			if (this.getShell() != null)
				this.getShell().setSize(900, 353);

		} else {
			if (this.getShell() != null)
				this.getShell().setSize(900, 453);
		}

		// this.getShell().pack();
		// frmSearchForEveryThing frmSearchForEveryThing = new
		// frmSearchForEveryThing(this.display, this.deletingElemenet);

		// frmSearchForEveryThing.open();

	}

	private String getInfoText() {
		String infoText = "Deleting Element: ";
		if (this.deletingElemenet instanceof Attribute) {
			infoText += ((Attribute) this.deletingElemenet).getName();
			infoText += " in the " + ModelUtils2.getTypedRootForObject(deletingElemenet, Roleable.class).getName()
					+ " class.";
		} else if (this.deletingElemenet instanceof Function) {
			infoText += ((Function) this.deletingElemenet).getName();
			infoText += " in the " + ModelUtils2.getTypedRootForObject(deletingElemenet, Roleable.class).getName()
					+ " class.";
		} else if (this.deletingElemenet instanceof Input) {
			infoText += ((Input) this.deletingElemenet).getName();

		}
		return infoText;
	}

	private void setTreeHolderControls() {
		composite_TreeHolder.setContorls(composite_TextualRepresentation, shell, shellContainer,
				composite_TextualEditor, chkbkxViewGraphicalEditor);

	}

	public void open() {

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}