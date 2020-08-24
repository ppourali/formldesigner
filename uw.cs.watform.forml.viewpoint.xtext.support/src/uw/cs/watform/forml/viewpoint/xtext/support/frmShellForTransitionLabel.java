package uw.cs.watform.forml.viewpoint.xtext.support;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.impl.FeatureModuleImpl;
import uw.cs.watform.forml.forml.impl.SystemImpl;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class frmShellForTransitionLabel extends AbstractShellContainer {
	public Composite txtTransitionComposite;
	public Text txtEid;
	public Composite txtWCE;
	public Composite txtGuard;
	public Composite txtWCA;
	public Composite composite;
	private java.awt.event.KeyListener suggestKeyListener;
	private int currRow;
	private System root;
	private Feature curFeature;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private TabFolder tabFolder;

	public String old_transitionName;
	private Button btnCancel;
	private Button btnConfirm;

	private TabItem tbtmTextual;
	private TabItem tbtmTabular;

	 private Shell shell ;
	public frmShellForTransitionLabel(Transition trans, Display display) {

		old_transitionName = trans.getName();

		this.display = display;

		constructDesign(trans);

		setKeyListeners();

		tabFolder.forceFocus();
		composite.forceFocus();

		txtEid.selectAll();
	}

	private void setKeyListeners() {
		this.txtEid.addKeyListener(addKeyListener());
		this.btnCancel.addKeyListener(addKeyListener());
		this.btnConfirm.addKeyListener(addKeyListener());
		this.composite.addKeyListener(addKeyListener());
		this.shell.addKeyListener(addKeyListener());
		this.tabFolder.addKeyListener(addKeyListener());
	}

	private void constructDesign(Transition trans) {
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

		shell = new Shell(display);
		//addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(536, 327);

		shell.setMinimumSize(new Point(0, 0));

		shell.setText("Transition Label");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, dim.height / 2 - shell.getSize().y / 2);
		shell.setLayout(new GridLayout(1, false));

		tabFolder = new TabFolder(shell, SWT.NONE);
		GridData gd_tabFolder = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_tabFolder.widthHint = 506;
		gd_tabFolder.heightHint = 177;
		tabFolder.setLayoutData(gd_tabFolder);
		tabFolder.setBounds(10, 10, 267, 449);

		tbtmTabular = new TabItem(tabFolder, SWT.NONE);
		tbtmTabular.setText("Tabular");

		composite = new Composite(tabFolder, SWT.NONE);
		tbtmTabular.setControl(composite);

		tbtmTextual = new TabItem(tabFolder, SWT.NONE);
		tbtmTextual.setText("Textual Label");

		txtTransitionComposite = new Composite(tabFolder, SWT.BORDER | SWT.EMBEDDED | SWT.WRAP);
		txtTransitionComposite.setVisible(true);
		tbtmTextual.setControl(txtTransitionComposite);
		txtTransitionComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.verticalSpacing = 4;
		gl_composite.marginTop = 2;
		gl_composite.marginBottom = 2;
		gl_composite.marginHeight = 2;
		gl_composite.marginWidth = 2;
		composite.setLayout(gl_composite);
		// txtWCA.setLayout(null);
		// composite.setTabList(new Control[] { txtEid, txtWCE, txtGuard, txtWCA
		// });

		Label lblId = new Label(composite, SWT.BORDER);
		GridData gd_lblId = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblId.widthHint = 54;
		gd_lblId.heightHint = 25;
		lblId.setLayoutData(gd_lblId);
		lblId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblId.setText("ID");

		txtEid = new Text(composite, SWT.BORDER);
		GridData gd_txtEid = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtEid.widthHint = 430;
		gd_txtEid.heightHint = 21;
		txtEid.setLayoutData(gd_txtEid);
		txtEid.setTabs(0);

		Label lblWcEvent = new Label(composite, SWT.BORDER);
		GridData gd_lblWcEvent = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblWcEvent.widthHint = 54;
		gd_lblWcEvent.heightHint = 36;
		lblWcEvent.setLayoutData(gd_lblWcEvent);
		lblWcEvent.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblWcEvent.setText("Event");

		txtWCE = new Composite(composite, SWT.BORDER);
		GridData gd_txtWCE = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtWCE.heightHint = 35;
		gd_txtWCE.widthHint = 418;
		txtWCE.setLayoutData(gd_txtWCE);

		txtWCE.setVisible(true);
		// txtWCE.addKeyListener(suggestKeyListener);

		Label lblGaurd = new Label(composite, SWT.BORDER);
		GridData gd_lblGaurd = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblGaurd.widthHint = 54;
		gd_lblGaurd.heightHint = 36;
		lblGaurd.setLayoutData(gd_lblGaurd);
		lblGaurd.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblGaurd.setText("Gaurd");
		// tbtm.setControl(txtWCE);
		// txtWCE.setLayout(new FillLayout());

		txtGuard = new Composite(composite, SWT.BORDER);
		GridData gd_txtGuard = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtGuard.heightHint = 37;
		txtGuard.setLayoutData(gd_txtGuard);
		// txtGuard.addMouseListener(doublClickListener(curFeature.getAttributes()));

		Label lblActionId = new Label(composite, SWT.BORDER);
		GridData gd_lblActionId = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblActionId.widthHint = 54;
		gd_lblActionId.heightHint = 39;
		lblActionId.setLayoutData(gd_lblActionId);
		lblActionId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblActionId.setText("Actions");

		txtWCA = new Composite(composite, SWT.BORDER | SWT.NO_BACKGROUND);
		GridData gd_txtWCA = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtWCA.heightHint = 41;
		gd_txtWCA.widthHint = 364;
		txtWCA.setLayoutData(gd_txtWCA);

		Composite composite_1 = new Composite(shell, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite_1.heightHint = 94;
		composite_1.setLayoutData(gd_composite_1);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);

		CLabel lblNote = new CLabel(composite_1, SWT.NONE);
		// lblNote.setLayoutData(gd_lblNote);
		lblNote.setBounds(10, 5, 355, 36);
		lblNote.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNote.setText("Please use Shift+Enter to save the modifications and Shift+Esc to exit without save.");
		lblNote.pack();

		btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor_WCE.confirmFlag = false;
				editor_WCE.closeEditor(false);
				shell.dispose();
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setBounds(186, 32, 75, 25);
		formToolkit.adapt(btnCancel, true, true);

		btnConfirm = new Button(composite_1, SWT.NONE);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tabFolder.getSelection()[0].equals(tbtmTabular)) {
					editor_WCE.confirmFlag = true;
					editor_WCE.closeEditor(true);
					shell.dispose();
				} else if (tabFolder.getSelection()[0].equals(tbtmTextual)) {
					editor_Transition.confirmFlag = true;
					editor_Transition.closeEditor(true);
					shell.dispose();
				}
			}
		});
		btnConfirm.setText("Confirm");
		btnConfirm.setBounds(268, 32, 75, 25);
		formToolkit.adapt(btnConfirm, true, true);
		shell.setTabList(new Control[] { tabFolder });

		shell.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (!old_transitionName.trim().equalsIgnoreCase(txtEid.getText().trim().replace(" ", "")))
					trans.setName(txtEid.getText().trim().replace(" ", ""));

			}
		});

		composite.setTabList(new Control[] { txtEid, txtWCE, txtGuard, txtWCA });
	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private KeyListener addKeyListener() {

		return new KeyListener() {

			@Override
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = true;
					ConfirmFlag = true;
				}

				if ((e.stateMask & SWT.SHIFT) != 0 && e.keyCode == SWT.ESC) {
					ConfirmFlag = false;

					if (!shell.isDisposed())
						shell.close();
				}

				if (e.keyCode == SWT.ESC) {
					ConfirmFlag = false;
					if (!shell.isDisposed())
						shell.close();
				}

			}

			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

}
