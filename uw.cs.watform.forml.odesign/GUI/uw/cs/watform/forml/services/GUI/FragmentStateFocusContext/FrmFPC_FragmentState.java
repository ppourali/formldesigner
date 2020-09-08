package uw.cs.watform.forml.services.GUI.FragmentStateFocusContext;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmFPC_FragmentState extends AbstractShellContainer {
	public boolean ConfirmFlag = false;
	private Display display;

	public final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private CustomCompositeFeatureModuleSnapShotHolderForFragment FeatureModuleHolder;
	private FeatureModule relatedFeatureModule;

	public FrmFPC_FragmentState(Display display, FeatureModule rel_fm) {
		this.relatedFeatureModule = rel_fm;
		constructDesign(display);
	}

	private void setShellLocation() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		getShell().setLocation(dim.width / 2 - getShell().getSize().x / 2, 100);
	}

	private void constructDesign(Display disp) {
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

		this.display = disp;
		setShell(new Shell(display, SWT.CLOSE | SWT.MIN | SWT.TITLE));
		getShell().setBackground(SWTResourceManager.getColor(240, 255, 255));

		// addShellListenerForAutoDisposeOnDeactive();

		getShell().setSize(900, 600);

		setShellLocation();

		createFeatureModulePreviewSection();
		getShell().pack();

		getShell().layout(true, true);
		try {
			this.FeatureModuleHolder.imageComosite.imageCanvas.fitCanvas();

		} catch (Exception e) {
			e.printStackTrace();
		}

		getShell().addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				switch (event.detail) {
				case SWT.TRAVERSE_ESCAPE:
					shell.close();
					event.detail = SWT.TRAVERSE_NONE;
					event.doit = false;
					shell.dispose();
					break;
				}
			}
		});
	}

	private boolean createFeatureModulePreviewSection() {
		if (this.relatedFeatureModule != null) {
			FeatureModule relatedFM = this.relatedFeatureModule;
			if (relatedFM != null) {
				this.FeatureModuleHolder = new CustomCompositeFeatureModuleSnapShotHolderForFragment(this.shell,
						SWT.BORDER, relatedFM);
				return true;
			}
		}
		return false;

	}

	public void disposeShell() {
		this.getShell().dispose();
	}

	public boolean open() {
		getShell().open();
		while (!getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return true;
	}

}