package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.services.GUI.CustomControls.CustomControlAcceptButton;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomControlCancelButton;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmShellForSetGuardGraphicallyDialog extends AbstractShellContainer {
	public boolean ConfirmFlag = false;
	private Display display;

	public final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	final FrmShellForSetGuardGraphicallyDialog shellContainer = this;
	//private Shell shell;
	private CustomControlExpandBarForTransitionParts composite_TransitionPartsHolder;
	private CustomControlFeaturePreview composite_FeaturesPreviewHolder;
	private CustomControlAcceptButton btnSaveAndExit;
	private CustomControlCancelButton btnCancelAndExit;
	private Composite composite_CRUDButtonsBar;
	private Text textSearch;

	public FrmShellForSetGuardGraphicallyDialog(Display display) {
		CommonSpaceForContextualUI.setShell(this);
		constructDesign(display);
		getShell().setText("Set Transition Elements for " + CommonSpaceForContextualUI.getCurrentTransition().getName());

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

		getShell().setSize(790, 456);

		getShell().setText("Transition Label");

		setShellLocation();

		createFeaturesListSection();
		createTransitionPartSection();

		composite_CRUDButtonsBar = new Composite(getShell(), SWT.BORDER);
		composite_CRUDButtonsBar.setBounds(409, 400, 356, 35);
		// composite_CRUDButtonsBar.setBackground(SWTResourceManager.getColor(240, 255,
		// 255));
		// formToolkit.adapt(composite_CRUDButtonsBar);
		// formToolkit.paintBordersFor(composite_CRUDButtonsBar);
		composite_CRUDButtonsBar.setLayout(null);
		btnCancelAndExit = new CustomControlCancelButton(composite_CRUDButtonsBar);
		btnCancelAndExit.setBackground(SWTResourceManager.getColor(240, 255, 255));
		btnCancelAndExit.setBounds(183, 2, 89, 26);

		btnSaveAndExit = new CustomControlAcceptButton(composite_CRUDButtonsBar);
		btnSaveAndExit.setBackground(SWTResourceManager.getColor(240, 255, 255));
		btnSaveAndExit.setBounds(88, 2, 89, 26);

		 getShell().pack();

		CustomSearchBar composite_SearchBar = new CustomSearchBar(getShell(), SWT.None);

		getShell().layout(true, true);
	}

	private void createFeaturesListSection() {
		// shell.setLayout(null);
		composite_FeaturesPreviewHolder = new CustomControlFeaturePreview(getShell());
		composite_FeaturesPreviewHolder.setBounds(5, 50, 398, 384);
		composite_FeaturesPreviewHolder.setBackground(SWTResourceManager.getColor(240, 255, 255));
		CommonSpaceForContextualUI.setFeaturesListDialog(composite_FeaturesPreviewHolder);
		// composite_FeaturesPreviewHolder.setLayout(null);
	}

	private void createTransitionPartSection() {
		setComposite_TransitionPartsHolder(new CustomControlExpandBarForTransitionParts(getShell()));
		// composite_TransitionPartsHolder.setLayout(null);
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

		return CommonSpaceForContextualUI.confirmFlag;
	}

	public CustomControlExpandBarForTransitionParts getComposite_TransitionPartsHolder() {
		return composite_TransitionPartsHolder;
	}

	public void setComposite_TransitionPartsHolder(
			CustomControlExpandBarForTransitionParts composite_TransitionPartsHolder) {
		this.composite_TransitionPartsHolder = composite_TransitionPartsHolder;
		composite_TransitionPartsHolder.setLocation(409, 50);
		composite_TransitionPartsHolder.setBackground(SWTResourceManager.getColor(240, 255, 255));
	}


}
