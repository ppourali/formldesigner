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
import org.eclipse.sirius.viewpoint.DRepresentation;
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
import org.eclipse.swt.graphics.ImageData;
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
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.CustomControls.CommonListeners;
import uw.cs.watform.forml.services.internal.CustomMessageDialogs;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.Styled_Text_NotUsed3_frmShellForTransitionLabel;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.ScrolledComposite;

public class FrmShellForTransitionSelectInDragNDrop extends AbstractShellContainer {

	public boolean ConfirmFlag = false;
	private Display display;
	private final FormToolkit formToolkit;// = new
											// FormToolkit(Display.getDefault());
	private Tree tree;
	final FrmShellForTransitionSelectInDragNDrop shellContainer = this;
	private Composite composite;

	private Collection<FeatureModule> allReferringFrags;

	public Transition transitionToReturn = null;

	private Composite composite_3;

	private Button btnConfirm;
	private Button btnCancel;
	//private Shell shlSelectTransitionWizard;

	List<Transition> outgoingTransitions = new ArrayList<Transition>();

	public FrmShellForTransitionSelectInDragNDrop(Display disp, List<Transition> trans) {
		this.outgoingTransitions = trans;
		this.display = disp;
		formToolkit = new FormToolkit(display);

		constructDesign();

		createTransitionsTree();
	}

	private void createTransitionsTree() {
		for (Transition trans : outgoingTransitions) {

			TreeItem treeItem = new TreeItem(tree, 0);
			treeItem.setData(trans);
			treeItem.setText("Transition "+trans.getName()+":"+trans.getSrc().getName()+"->"+trans.getDst().getName());
			treeItem.setImage(SWTResourceManager.getImage(FrmShellForTransitionSelectInDragNDrop.class,
					"/uw/cs/watform/forml/services/GUI/res/icon_SelectionWizardItems.png"));
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
		lblSelectText.setText("Select the transition");

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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
		btnConfirm.setBounds(310, 5, 92, 30);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (TreeItem ti : tree.getSelection()) {
					transitionToReturn = ((Transition) ti.getData());
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
		btnCancel.setBounds(220, 5, 84, 30);
		formToolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");

	}

	private void constructShell() {

		shell = new Shell(display.getCurrent(), SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		//addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(441, 239);

		shell.setMinimumSize(new Point(0, 0));

		GridLayout gl_shlSelectTransitionWizard = new GridLayout(1, false);
		gl_shlSelectTransitionWizard.horizontalSpacing = 1;
		shell.setLayout(gl_shlSelectTransitionWizard);

		// Image small = new Image(display,"yourFile.gif");
		// shell.setImage(small);

		shell.setText("Select Transition Wizard");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2,
				dim.height / 2 - shell.getSize().y / 2);

	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}
}