package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Inject;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.forml.provider.FormlItemProviderAdapterFactory;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class CustomCompositeTreeViewer extends Composite {

	private ComposedAdapterFactory composedAdapterFactory;
	private Tree tree;
	private TreeViewer tv;
	private Roleable CurrentRoleable;

	public CustomCompositeTreeViewer(Composite parent, int style, Roleable roleable) {
		super(parent, style);
		this.CurrentRoleable = roleable;
		ConstructDesign();
	}

	private void ConstructDesign() {
		setLocation(409, 50);
		setSize(345, 350);
		setBackground(SWTResourceManager.getColor(240, 255, 255));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);

		// Set Layout for component
		setLayout(fillLayout);
		// Tree tree = new Tree(this, SWT.SINGLE);

		// TreeViewer viewer = new TreeViewer(this);
		// viewerFactory.initialize(viewer, );
		// viewerFactory.initialize(viewer,
		// FPC_SingletonData.getCurrentRoleable().eContainer().eResource().getURI());

		// TreeViewer viewer = TreeViewerSWTFactory.createTreeViewer(this,
		// FPC_SingletonData.getCurrentRoleable().);

		composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new FormlItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		tree = new Tree(this, SWT.SINGLE);
		tv = new TreeViewer(tree);
		tv.setContentProvider(new AdapterFactoryContentProvider(composedAdapterFactory));
		// tv.setLabelProvider(new AdapterFactoryLabelProvider(composedAdapterFactory));
		tv.setLabelProvider(new CustomFeatureNodeLabelProvider(this.CurrentRoleable));

		// Object inputData = FPC_SingletonData.getCurrentRoleable().eResource();
		// tv.setInput(FPC_SingletonData.getCurrentRoleable().eResource());

		Collection<?> treeData = getCollectionFromIteralbe(this.CurrentRoleable);
		tv.setInput(new ItemProvider(treeData));
		// ViewerFilter filters;
		tv.setFilters(new FeatureNodeFilter());

		createContextMenu(tv);

		setDNDListeners();
	}

	protected void createContextMenu(Viewer viewer) {
		MenuManager contextMenu = new MenuManager("#ViewerMenu"); //$NON-NLS-1$
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr, viewer);
			}
		});

		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
	}

	/**
	 * Fill dynamic context menu
	 *
	 * @param contextMenu
	 */
	protected void fillContextMenu(IMenuManager contextMenu, Viewer viewer) {

		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		Object selected_item = selection.getFirstElement();

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getSystem((Node)selected_item));
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				boolean isANDItem = false;
				boolean isORItem = false;
				boolean isXORItem = false;
			
				if (selected_item instanceof AndNode) {
					isANDItem = true;
				} else if (selected_item instanceof OrNode) {
					isORItem = true;
				} else if (selected_item instanceof XORNode) {
					isXORItem = true;
				} else {
					return;
				}

				contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

				if (!isORItem) {
					contextMenu.add(new Action("Change to OR node") {
						@Override
						public void run() {
							try {
								EObject parentFeatureNode = ((Node) selected_item).eContainer();
								OrNode newOrNode = FormlFactory.eINSTANCE.createOrNode();
								newOrNode.getFeatureNodes().addAll(((Node) selected_item).getFeatureNodes());

								if (parentFeatureNode instanceof FeatureNode) {
									((FeatureNode) parentFeatureNode).getOrs().add(newOrNode);
									EcoreUtil2.remove((Node) selected_item);

								} else if (parentFeatureNode instanceof SPL) {
									((SPL) parentFeatureNode).getOrs().add(newOrNode);
									EcoreUtil2.remove((Node) selected_item);
								}

							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					});
				}

				if (!isANDItem)

				{
					contextMenu.add(new Action("Change to AND node") {
						@Override
						public void run() {
							try {
								EObject parentFeatureNode = ((Node) selected_item).eContainer();
								AndNode newAndNode = FormlFactory.eINSTANCE.createAndNode();
								newAndNode.getFeatureNodes().addAll(((Node) selected_item).getFeatureNodes());

								if (parentFeatureNode instanceof FeatureNode) {
									((FeatureNode) parentFeatureNode).getAnds().add(newAndNode);
									EcoreUtil2.remove((Node) selected_item);
								} else if (parentFeatureNode instanceof SPL) {
									((SPL) parentFeatureNode).getAnds().add(newAndNode);
									EcoreUtil2.remove((Node) selected_item);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}

				if (!isXORItem) {
					contextMenu.add(new Action("Change to XOR node") {
						@Override
						public void run() {
							try {
								EObject parentFeatureNode = ((Node) selected_item).eContainer();
								XORNode newXorNode = FormlFactory.eINSTANCE.createXORNode();
								newXorNode.getFeatureNodes().addAll(((Node) selected_item).getFeatureNodes());

								if (parentFeatureNode instanceof FeatureNode) {
									((FeatureNode) parentFeatureNode).getXors().add(newXorNode);
									EcoreUtil2.remove((Node) selected_item);
								} else if (parentFeatureNode instanceof SPL) {
									((SPL) parentFeatureNode).getXors().add(newXorNode);
									EcoreUtil2.remove((Node) selected_item);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
	}

	public void setDNDListeners() {
		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		tv.addDropSupport(operations, transferTypes, new DropListenerForFeatureNodeTreeViewer(tv));
		tv.addDragSupport(operations, transferTypes, new DragListenerForFeatureNodeTreeViewer(tv));

		// tv.setContentProvider(new TreeContentProvider());
		// tv.setLabelProvider(new TreeLabelProvider());
		// tv.setInput(ContentProviderTree.INSTANCE.getModel());
	}

	public void selectOnTreeViewer(FeatureNode referringFeatureNode) {
		try {
			// getFeaturesTreeViewer().expandToLevel(referringFeatureNode, 0,false);
			this.tv.setSelection(new StructuredSelection(referringFeatureNode));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectCorrespondingItemOnTreeViewer(Object roleable) {
		if (roleable instanceof Feature) {
			if (tv != null) {
				FeatureNode referringFeatureNode = ModelUtils2.getCorrespondingFeatureNode((Feature) roleable);
				if (referringFeatureNode != null) {
					selectOnTreeViewer(referringFeatureNode);
				}

			}
		}
	}

	public static Collection<?> getCollectionFromIteralbe(EObject eobj) {
		Collection<?> stuff = Collections.singleton(ModelUtils2.getSPLRoot(eobj));

		// stuff.stream().filter(item -> item instanceof Multiplicity).map(item ->
		// (Multiplicity) item)
		// .forEach(specificItem -> specificItem.getClass());

		// stuff.removeIf(ele -> (ele instanceof Multiplicity));
		return stuff;
	}

}

class FeatureNodeFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		return !(element instanceof Multiplicity);
	}

}

class CustomFeatureNodeLabelProvider implements ILabelProvider {
	Roleable currentRoleable;

	public CustomFeatureNodeLabelProvider(Roleable roleable) {
		this.currentRoleable = roleable;
	}

	private Image defaultIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_SelectionWizardItems.png");

	private Image currentFeatureIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_edit.png");

	private Image featureIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_FeatureNode.png");

	private Image orFeatureIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_orFeatureNode.png");

	private Image xorFeatureIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_xorFeatureNode.png");

	private Image andFeatureIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_andFeatureNode.png");

	private Image splIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_SPLNode.png");

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

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
		if (element instanceof Node) {
			if (element instanceof FeatureNode) {
				FeatureNode featureNode = ((FeatureNode) element);
				if (this.currentRoleable == featureNode.getFeature()) {
					return currentFeatureIcon;
				} else {
					return featureIcon;
				}
			} else if (element instanceof SPL) {
				return splIcon;
			} else if (element instanceof OrNode)
				return orFeatureIcon;
			else if (element instanceof XORNode)
				return xorFeatureIcon;
			else if (element instanceof AndNode)
				return andFeatureIcon;

		}
		return defaultIcon;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Node) {
			if (element instanceof FeatureNode) {
				return "Feature: " + ((FeatureNode) element).getFeature().getName();
			} else if (element instanceof SPL) {
				return "SPL " + ((SPL) element).getName();
			} else if (element instanceof OrNode || element instanceof XORNode || element instanceof AndNode) {
				return populateOtherNodesNames((Node) element);
			}
		}

		return null;
	}

	public String populateOtherNodesNames(Node element) {
		String returnLabel = "";
		if (element instanceof OrNode || element instanceof XORNode || element instanceof AndNode) {
			if (element instanceof OrNode)
				returnLabel = returnLabel.concat("OR (,");
			else if (element instanceof XORNode)
				returnLabel = returnLabel.concat("XOR (,");
			else if (element instanceof AndNode)
				returnLabel = returnLabel.concat("AND (,");

			for (Node f : ((Node) element).getFeatureNodes()) {
				if (f instanceof FeatureNode) {
					returnLabel = returnLabel.concat(" " + ((FeatureNode) f).getFeature().getName() + " ,");
				}
			}

			returnLabel = returnLabel.concat(")");
			returnLabel = returnLabel.replace(",)", ")");
			returnLabel = returnLabel.replace("(,", "(");
		}

		return returnLabel;
	}

}

//	private static Set<EObject> filterByType(Set<EObject> collection)
//	{
////		Set<EObject> filtereSet=new HashSet();
////		
////		while(collection.iterator().hasNext())
////		{
////			EObject n = collection.iterator().next();
////			if(n)
////		}
////		
//		return 0;
//		
//	}
