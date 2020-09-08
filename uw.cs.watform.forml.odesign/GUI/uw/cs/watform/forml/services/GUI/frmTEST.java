package uw.cs.watform.forml.services.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class frmTEST extends AbstractShellContainer {
	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	final frmTEST shellContainer = this;
	Collection<Setting> crossReferences;
	private Message ref_Message;

	Shell shell;

	public frmTEST(Display display, Collection<Setting> crossRefs, Message msg) {

		this.crossReferences = crossRefs;
		this.ref_Message = msg;

		this.display = display;
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		// addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(898, 580);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

		constructDesign(shell);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {

			}
		});

		viewDiagramEditor();
	}

	private String getDiagramName(FeatureModule fm) {
		return RepresentationsUtils.getRepresentationForAnyObject(fm, true).iterator().next().getName();
		// return
		// RepresentationsUtils.getRepresentationsForFeatureModulesSortedbyName(fm).iterator().next().getName();
	}

	private void viewDiagramEditor() {

		Iterator<Setting> iter = crossReferences.iterator();

		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();

			Transition parentTransition = ModelUtils.getTypedRootForObject(ref, Transition.class);

			if (parentTransition != null) {
				FeatureModule fm = ModelUtils.getTypedRootForObject(parentTransition, FeatureModule.class);

				RepresentationsUtils.openRepresentationInAParentShell(this.shell, fm, 0, this.shell.getSize().y);
			}
		}
	}

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
