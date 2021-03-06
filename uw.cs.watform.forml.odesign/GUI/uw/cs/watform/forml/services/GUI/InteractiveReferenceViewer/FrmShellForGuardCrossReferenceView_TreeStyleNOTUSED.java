package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
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

import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmShellForGuardCrossReferenceView_TreeStyleNOTUSED extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Composite composite_TreeAndEditorHolder;

	final FrmShellForGuardCrossReferenceView_TreeStyleNOTUSED shellContainer = this;
	List<EObject> crossReferences=new ArrayList<EObject>();
	private Composite composite_TextualEditor;
	private Composite composite;
	private EObject changedAttType;
	private CLabel lblNote;

	private Button btnConfirmDelete;
	private Button btnCancel;
	private CustomTreeNodeForConsistencyManagement composite_TreeHolder;

	Shell shell;
	private Composite composite_3;
	private Button chkbkxViewGraphicalEditor;

	public FrmShellForGuardCrossReferenceView_TreeStyleNOTUSED(Display display, List<EObject> crossRefs, EObject elem) {

		this.crossReferences.addAll(crossRefs);
		this.changedAttType = elem;
		this.display = display;

		constructDesign();

		// used to view graphical editor in the interactive view
		Helper_InteractiveConsistencyManage.setEditors_Before();
		addListeners();
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
				boolean checkResult = composite_TreeHolder.checkForGuardConfirmation(changedAttType);
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

		shell.setSize(900, 320);

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
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, 100);

		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		composite_TreeAndEditorHolder = new Composite(shell, SWT.NONE);
		composite_TreeAndEditorHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_treeandeditor = new GridLayout(2, false);
		gl_treeandeditor.makeColumnsEqualWidth = true;
		composite_TreeAndEditorHolder.setLayout(gl_treeandeditor);

		formToolkit.adapt(composite_TreeAndEditorHolder);
		formToolkit.paintBordersFor(composite_TreeAndEditorHolder);

		Label lblInfoText = new Label(composite_TreeAndEditorHolder, SWT.NONE);
		lblInfoText.setText(getInfoText());
		lblInfoText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		// lblInfoText.setSize(20, 20);
		composite_TreeHolder = new CustomTreeNodeForConsistencyManagement(composite_TreeAndEditorHolder,
				crossReferences, SWT.BORDER);

		composite_TreeHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		composite_TextualEditor = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);
		composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

		formToolkit.adapt(composite_TextualEditor);
		formToolkit.paintBordersFor(composite_TextualEditor);

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
		chkbkxViewGraphicalEditor.setText("View Graphical Editor on Edit Action");

		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_composite.heightHint = 36;
		gd_composite.widthHint = 258;
		composite.setLayoutData(gd_composite);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setImage(SWTResourceManager.getImage(FrmShellForGuardCrossReferenceView_TreeStyleNOTUSED.class,
				"/uw/cs/watform/forml/services/GUI/res/window_close.png"));

		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

		btnConfirmDelete = new Button(composite, SWT.NONE);
		btnConfirmDelete.setImage(SWTResourceManager.getImage(FrmShellForGuardCrossReferenceView_TreeStyleNOTUSED.class,
				"/uw/cs/watform/forml/services/GUI/res/window_accept.png"));

		formToolkit.adapt(btnConfirmDelete, true, true);
		btnConfirmDelete.setText("Apply Changes");

		setTreeHolderControls();
		shell.open();
	}

	private String getInfoText() {
		String infoText = "Fix Type Isseue. ";
		return infoText;
	}

	private void setTreeHolderControls() {
		composite_TreeHolder.setContorls(composite_TreeAndEditorHolder, shell, shellContainer, composite_TextualEditor,
				chkbkxViewGraphicalEditor);

	}

	public void open() {

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
