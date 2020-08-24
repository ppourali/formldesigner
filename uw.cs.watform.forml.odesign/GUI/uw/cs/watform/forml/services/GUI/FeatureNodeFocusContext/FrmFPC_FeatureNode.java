package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

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

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomControlAcceptButton;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomControlCancelButton;
import uw.cs.watform.forml.services.GUI.CustomControls.FPCFeatureNodeCustomControlAcceptButton;
import uw.cs.watform.forml.services.GUI.CustomControls.FPCFeatureNodeCustomControlCancelButton;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmFPC_FeatureNode extends AbstractShellContainer {
	public boolean ConfirmFlag = false;
	private Display display;

	public final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	final FrmFPC_FeatureNode shellContainer = this;
	// private Shell shell=new Shell();
	private CustomCompositeFeaturePreview composite_FeaturesPreviewHolder;

	private CustomCompositeTabularFeatureNodes composite_TabularFeatureNodes;
	private FPCFeatureNodeCustomControlAcceptButton btnSaveAndExit;
	private FPCFeatureNodeCustomControlCancelButton btnCancelAndExit;
	private Composite composite_CRUDButtonsBar;
	private Text textSearch;
	private CustomCompositeTreeViewer TreeViewHolder;
	private CustomCompositeFeatureModuleSnapShotHolder FeatureModuleHolder;

	public FrmFPC_FeatureNode(Display display) {
		FPC_SingletonData.setShell(this);
		constructDesign(display);
		getShell().setText("Contextual View for the Feature " + FPC_SingletonData.getCurrentRoleable().getName());
		
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

		getShell().setText("Transition Label");

		setShellLocation();

		createTreeViewFeatureNodeSection();
		createFeaturesListSection();

		boolean hasFeatureModule = createFeatureModulePreviewSection();

		createCRUDButtons(hasFeatureModule);
		getShell().pack();

		CustomSearchBarForFeatureNode composite_SearchBar = new CustomSearchBarForFeatureNode(getShell(), SWT.None);

		getShell().layout(true, true);
	}

	private void createCRUDButtons(boolean hasFM) {
		int x = 0;
		int y = 400;

		if (hasFM)
			y += 400;

		composite_CRUDButtonsBar = new Composite(getShell(), SWT.BORDER | SWT.FILL);
		composite_CRUDButtonsBar.setBounds(0, y, 760, 35);
		// composite_CRUDButtonsBar.setBackground(SWTResourceManager.getColor(240, 255,
		// 255));
		// formToolkit.adapt(composite_CRUDButtonsBar);
		// formToolkit.paintBordersFor(composite_CRUDButtonsBar);
		composite_CRUDButtonsBar.setLayout(null);
		btnCancelAndExit = new FPCFeatureNodeCustomControlCancelButton(composite_CRUDButtonsBar);
		btnCancelAndExit.setBackground(SWTResourceManager.getColor(240, 255, 255));
		btnCancelAndExit.setBounds(380, 2, 89, 26);

		btnSaveAndExit = new FPCFeatureNodeCustomControlAcceptButton(composite_CRUDButtonsBar);
		btnSaveAndExit.setBackground(SWTResourceManager.getColor(240, 255, 255));
		btnSaveAndExit.setBounds(280, 2, 89, 26);

	}

	private boolean createFeatureModulePreviewSection() {
		if (FPC_SingletonData.getCurrentRoleable() != null) {
			FeatureModule relatedFM = ModelUtils.getFeatureModuleForFeature(FPC_SingletonData.getCurrentRoleable());
			if (relatedFM != null) {
				this.FeatureModuleHolder = new CustomCompositeFeatureModuleSnapShotHolder(this.shell, SWT.BORDER,
						relatedFM);
				return true;
			}
		}
		return false;

	}

	private void createTreeViewFeatureNodeSection() {
		this.TreeViewHolder = new CustomCompositeTreeViewer(this.shell, SWT.BORDER,
				FPC_SingletonData.getCurrentRoleable());
		FPC_SingletonData.setFeaturesTreeViewer(this.TreeViewHolder);

	}

	private void createFeaturesListSection() {
		// shell.setLayout(null);
		composite_FeaturesPreviewHolder = new CustomCompositeFeaturePreview(getShell());
		composite_FeaturesPreviewHolder.setBounds(5, 50, 398, 350);
		composite_FeaturesPreviewHolder.setBackground(SWTResourceManager.getColor(240, 255, 255));
		FPC_SingletonData.setFeaturesListDialog(composite_FeaturesPreviewHolder);
		// composite_FeaturesPreviewHolder.setLayout(null);
	}

//	private void createTransitionPartSection() {
//		setComposite_TransitionPartsHolder(new CustomControlExpandBarForTransitionParts(getShell()));
//		// composite_TransitionPartsHolder.setLayout(null);
//	}

	public void disposeShell() {
		this.getShell().dispose();
	}

	public boolean open() {
		getShell().open();
		while (!getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return FPC_SingletonData.confirmFlag;
	}

//	public CustomControlExpandBarForTransitionParts getComposite_TransitionPartsHolder() {
//		return composite_TransitionPartsHolder;
//	}

//	public void setComposite_TransitionPartsHolder(
//			CustomControlExpandBarForTransitionParts composite_TransitionPartsHolder) {
//		this.composite_TransitionPartsHolder = composite_TransitionPartsHolder;
//		composite_TransitionPartsHolder.setLocation(409, 50);
//		composite_TransitionPartsHolder.setBackground(SWTResourceManager.getColor(240, 255, 255));
//	}

}