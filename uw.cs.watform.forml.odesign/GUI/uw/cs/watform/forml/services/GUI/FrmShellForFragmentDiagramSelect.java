package uw.cs.watform.forml.services.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmShellForFragmentDiagramSelect extends AbstractShellContainer {

	public boolean ConfirmFlag = false;
	private Display display;
	private final FormToolkit formToolkit;// = new
											// FormToolkit(Display.getDefault());
	private Tree tree;
	final FrmShellForFragmentDiagramSelect shellContainer = this;
	private Composite composite;

	private Collection<FeatureModule> allReferringFrags;

	public Collection<FeatureModule> FragmentsToReturn = new ArrayList<FeatureModule>();

	private Composite composite_3;

	private Button btnConfirm;
	private Button btnCancel;

	public FrmShellForFragmentDiagramSelect(Display disp, Collection<FeatureModule> allFrags) {
		this.allReferringFrags = allFrags;
		this.display = disp;
		formToolkit = new FormToolkit(display);

		constructDesign();

		createFragmentsTree();
	}

	private void createFragmentsTree() {
		for (FeatureModule frag : allReferringFrags) {
			Collection<DRepresentation> diags = RepresentationsUtils.getRepresentationForAnyObject(frag, false);
			for (DRepresentation rep : diags) {
				TreeItem treeItem = new TreeItem(tree, 0);
				treeItem.setData(frag);
				treeItem.setText(rep.getName());
				treeItem.setImage(SWTResourceManager.getImage(FrmShellForFragmentDiagramSelect.class,
						"/uw/cs/watform/forml/services/GUI/res/icon_FeatureModule.gif"));
			}
		}
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

		Label lblSelectText = new Label(composite_3, SWT.NONE);
		lblSelectText.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSelectText.setBounds(10, 10, 334, 21);
		formToolkit.adapt(lblSelectText, true, true);
		lblSelectText.setText("Select the Fragment diagram:");

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_scrolledComposite.heightHint = 89;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		formToolkit.adapt(scrolledComposite);
		formToolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		tree = new Tree(scrolledComposite, SWT.MULTI | SWT.BORDER);
		formToolkit.adapt(tree);
		formToolkit.paintBordersFor(tree);
		scrolledComposite.setContent(tree);
		scrolledComposite.setMinSize(tree.computeSize(SWT.DEFAULT, SWT.DEFAULT));

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
				for (TreeItem ti : tree.getSelection()) {
					FragmentsToReturn.add((FeatureModule) ti.getData());
				}
				ConfirmFlag = true;
				shell.dispose();
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

	private void constructShell() {

		shell = new Shell(display.getCurrent(), SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		//addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(510, 239);

		shell.setMinimumSize(new Point(0, 0));

		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		// Image small = new Image(display,"yourFile.gif");
		// shell.setImage(small);

		shell.setText("Select Fragment Wizard");
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
}