package uw.cs.watform.forml.services.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Collections;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.forml.provider.FormlItemProviderAdapterFactory;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.CustomCompositeFeatureModuleSnapShotHolder;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class FrmCustomFeatureSelectionWizardForBaseStateMachine extends AbstractShellContainer {

	private Display display = Display.getDefault();
	private BehaviourModel bm;
	public boolean ConfirmFlag = false;

	private Shell shell = new Shell();

	public DRepresentation selectedFeatureModule;

	private ComposedAdapterFactory composedAdapterFactory;
	private Tree tree;
	private TreeViewer tv;

	Composite FeatureModuleHolder;

	public FrmCustomFeatureSelectionWizardForBaseStateMachine(BehaviourModel behmodel) {

		this.bm = behmodel;
		ConstructDesign();

	}

	public void disposeShell() {
		this.getShell().dispose();
	}

	public boolean open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return false;

	}
	
	private void setShellLocation() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, 100);
	}

	private void ConstructDesign() {

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

		this.display = display;
		// setShell(new Shell(display, SWT.TITLE));
		shell.setBackground(SWTResourceManager.getColor(240, 255, 255));

		setShell(shell);
		shell.setSize(800, 600);
		// setBackground(SWTResourceManager.getColor(240, 255, 255));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);

		// Set Layout for component
		shell.setLayout(fillLayout);
		// Tree tree = new Tree(this, SWT.SINGLE);

		// TreeViewer viewer = new TreeViewer(this);
		// viewerFactory.initialize(viewer, );
		// viewerFactory.initialize(viewer,
		// FPC_SingletonData.getCurrentRoleable().eContainer().eResource().getURI());

		// TreeViewer viewer = TreeViewerSWTFactory.createTreeViewer(this,
		// FPC_SingletonData.getCurrentRoleable().);

		Composite rootComposite = new Composite(shell, SWT.None);

		composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new FormlItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		rootComposite.setLayout(new GridLayout(1, false));

		Label lblSelectAStatemachine = new Label(rootComposite, SWT.NONE);
		lblSelectAStatemachine.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSelectAStatemachine.setText("Select a State-Machine");

		tree = new Tree(rootComposite, SWT.SINGLE);
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_tree.heightHint = 116;
		tree.setLayoutData(gd_tree);
		tv = new TreeViewer(tree);
		tv.setContentProvider(new AdapterFactoryContentProvider(composedAdapterFactory));
		// tv.setLabelProvider(new AdapterFactoryLabelProvider(composedAdapterFactory));
		tv.setLabelProvider(new CustomFeatureModuleLabelProvider(null));

		// Object inputData = FPC_SingletonData.getCurrentRoleable().eResource();
		// tv.setInput(FPC_SingletonData.getCurrentRoleable().eResource());

		Collection<FeatureModule> treeData = getCollectionFromIteralbe(this.bm);
		tv.setInput(new ItemProvider(treeData));
		// ViewerFilter filters;
		tv.setFilters(new FeatureNodeFilter());

		Composite composite = new Composite(rootComposite, SWT.NONE);
		composite.setLayout(new GridLayout(10, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite.heightHint = 31;
		composite.setLayoutData(gd_composite);

		Button btnSelect = new Button(composite, SWT.NONE);
		btnSelect.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 7, 1));
		btnSelect.setBounds(0, 0, 75, 25);
		btnSelect.setText("Select");
		btnSelect.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				ConfirmFlag = true;
				disposeShell();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		btnCancel.setBounds(0, 0, 75, 25);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				ConfirmFlag = false;
				disposeShell();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		FeatureModuleHolder = new Composite(rootComposite, SWT.NONE);
		FeatureModuleHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		FeatureModuleHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = tree.getSelection()[0];
				if (ti != null) {
					Object data = ti.getData();
					if (data instanceof FeatureModule) {
						FeatureModule selectedFM = (FeatureModule) data;

						Collection<DRepresentation> drep = RepresentationsUtils
								.getRepresentationForAnyObject(selectedFM, true);

						if (drep.iterator().hasNext()) {
							selectedFeatureModule = drep.iterator().next();

							for (Control c : FeatureModuleHolder.getChildren()) {
								c.dispose();
							}
							Composite snapShotHolder = new CustomCompositeFeatureModuleSnapShotHolder(
									FeatureModuleHolder, SWT.BORDER, selectedFM);
							FeatureModuleHolder.update();
							FeatureModuleHolder.layout();
							shell.redraw();
							shell.update();
							// return true;
						}
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	class FeatureNodeFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			// TODO Auto-generated method stub
			return (element instanceof FeatureModule);
		}

	}

	public static Collection<FeatureModule> getCollectionFromIteralbe(EObject eobj) {
		Collection<FeatureModule> stuff = ModelUtils.getBehaviourModelObjectsByType(eobj, FeatureModule.class);

		return stuff;
	}
}

class CustomFeatureModuleLabelProvider implements ILabelProvider {
	FeatureModule currentFM;

	public CustomFeatureModuleLabelProvider(FeatureModule fm) {
		this.currentFM = fm;
	}

	private Image defaultIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_FeatureModule.gif");

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {

		return defaultIcon;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof FeatureModule) {
			return "State-Machine: " + ((FeatureModule) element).getFeatureref().getName();
		}

		return null;
	}

}
