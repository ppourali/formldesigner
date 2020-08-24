package uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.provider.FormlItemProviderAdapterFactory;
import uw.cs.watform.forml.services.general.JS_TransitionLabelServices;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences2;

public class CustomTreeViewerForCrossReferences extends org.eclipse.swt.widgets.Composite {
	private ComposedAdapterFactory composedAdapterFactory;
	private Composite composite_TextualEditor;
	private Composite composite_TreeAndEditorHolder;
	private EObject element;
	TreeViewer tv;
//	private List<EObject> crossReferences;

	public CustomTreeViewerForCrossReferences(Composite parent, int style, EObject ele) {
		super(parent, style);
		// this.crossReferences = crossRefs;
		this.element = ele;
		createAndShowTree();
	}

	private void createAndShowTree() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new FormlItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		Tree tree = new Tree(this, SWT.SINGLE);
		tv = new TreeViewer(tree);
		tv.setContentProvider(new AdapterFactoryContentProvider(composedAdapterFactory));
		tv.setLabelProvider(new AdapterFactoryLabelProvider(composedAdapterFactory));
		tv.setLabelProvider(new CustomFeatureNodeLabelProvider());

		// Object inputData = FPC_SingletonData.getCurrentRoleable().eResource();
		// tv.setInput(this.element.eResource());

		Collection<?> treeData = getCollectionFromIteralbe(this.element);
		tv.setInput(new ItemProvider(treeData));
		tv.addSelectionChangedListener(selectionListener());

		// ViewerFilter filters;
		// tv.setFilters(new FeatureNodeFilter());

	}

	private ISelectionChangedListener selectionListener() {
		// TODO Auto-generated method stub
		return new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof TreeSelection) {
					TreeSelection selection = (TreeSelection) event.getSelection();
					Object sel_element = selection.getFirstElement();
					Transition transition = ModelUtils2.getTypedRootForObject((EObject) sel_element, Transition.class);
					if (transition != null) {
						createTransitionEditor(transition, true);
					}

				}

			}
		};
	}

	public static Collection<?> getCollectionFromIteralbe(EObject eobj) {
		Collection<?> stuff = ModelUtils2.getReferencesBySemanticType(eobj);

		Collection typedStuff = new ArrayList<EObject>();
		ArrayList alreadyAddedTransitions = new ArrayList<Transition>();

		Iterator<Setting> iterator = (Iterator<Setting>) stuff.iterator();
		while (iterator.hasNext()) {
			EObject ref = iterator.next().getEObject();
			Transition transition = ModelUtils2.getTypedRootForObject(ref, Transition.class);
			if (transition != null) {
				if (!alreadyAddedTransitions.contains(transition)) {
					typedStuff.add(ref);
					alreadyAddedTransitions.add(transition);
				}
			}
		}

		// stuff.stream().filter(item -> item instanceof Multiplicity).map(item ->
		// (Multiplicity) item)
		// .forEach(specificItem -> specificItem.getClass());

		// stuff.removeIf(ele -> (ele instanceof Multiplicity));
		return typedStuff;
	}

	private void item_edit_style(TreeItem item) {
		org.eclipse.swt.graphics.Color editColor = SWTResourceManager.getColor(0, 255, 0);

		// FontDescriptor editDescriptor =
		// FontDescriptor.createFrom(origFont).setStyle(SWT.ITALIC);
		// Font editFont = editDescriptor.createFont(getDisplay());
		item.setImage(SWTResourceManager.getImage(CustomCompositeForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_edit.png"));

		item.setForeground(editColor);
		// item.setFont(editFont);

	}

	private void SelectAndViewEobject(TreeItem item) {
		setRedraw(false); // Stop redraw until operation complete
		try {

			if (item.getText().startsWith("Transition")) {
				Transition trans = ((ReferencedData) item.getData()).transition_model_element;
				if (trans != null)
					createTransitionEditor(trans, false);
			}

			else {
				ReferencedData data = ((ReferencedData) item.getData());
				Transition trans = data.transition_model_element;

				boolean isEdit = true;
				createEventGuardActionEditor(trans, isEdit, data);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setRedraw(true);
		this.layout();

	}

	private void createTransitionEditor(Transition trans, boolean isEdit) {

		try {
			// Create Editor For the Whole Transition
			XtextEmbeddedEditorForCrossReferences2 transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences2(
					ModelUtils.getInjector(), isEdit); //
			composite_TextualEditor.dispose();
			composite_TextualEditor = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);
			composite_TextualEditor.pack();

			composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
			composite_TextualEditor.layout(true, true);
			if (trans != null) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, Transition.class);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		composite_TextualEditor.layout(true, true);
		composite_TreeAndEditorHolder.layout(true, true);
		composite_TextualEditor.redraw();

	}

	private void createEventGuardActionEditor(Transition trans, boolean isEdit, ReferencedData data) {

		try {
			// Create Editor For the Whole Transition
			XtextEmbeddedEditorForCrossReferences2 transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences2(
					ModelUtils.getInjector(), isEdit); //
			composite_TextualEditor.dispose();
			composite_TextualEditor = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);
			composite_TextualEditor.pack();

			composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
			composite_TextualEditor.layout(true, true);
			if (data.event_Guard_Action.equals(data.type_eventType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, Trigger.class);
			} else if (data.event_Guard_Action.equals(data.type_guardType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, Guard.class);
			} else if (data.event_Guard_Action.equals(data.type_effectType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, WCAList.class);
			}
			transition_embeddedEditor.gainFocus();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		composite_TextualEditor.layout(true, true);
		composite_TreeAndEditorHolder.layout(true, true);
		composite_TextualEditor.redraw();

	}

	public void setContorls(Composite composite_TreeAndEditorHolder, Composite composite_TextualEditor) {
		this.composite_TextualEditor = composite_TextualEditor;
		this.composite_TreeAndEditorHolder = composite_TreeAndEditorHolder;
	}

}

class FeatureNodeFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}

}

class CustomFeatureNodeLabelProvider implements ILabelProvider {

	private Image defaultIcon = SWTResourceManager.getImage(this.getClass(),
			"/uw/cs/watform/forml/services/GUI/res/icon_SelectionWizardItems.png");

	@Override
	public void addListener(ILabelProviderListener listener) { // TODO

	}

	@Override
	public void dispose() { // TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) { //

	}

	@Override
	public Image getImage(Object element) {
		return defaultIcon;
	}

	@Override
	public String getText(Object element) {

		if (element instanceof EObject) {
			Transition t = ModelUtils2.getTypedRootForObject((EObject) element, Transition.class);

			if (t != null) {
				FeatureModule module = ModelUtils2.getTypedRootForObject(t, FeatureModule.class);

				StateMachine stateMachine = ModelUtils2.getTypedRootForObject(t, StateMachine.class);
				String itemText = "";
				if (stateMachine != null) {
					itemText = module.getFeatureref().getName() + "( " + stateMachine.getName() + " ) -> "
							+ JS_TransitionLabelServices.populateTransitionLabel(t);
				} else {
					Fragment fragment = ModelUtils2.getTypedRootForObject(t, Fragment.class);
					if (fragment != null) {
						itemText = module.getFeatureref().getName() + "( " + fragment.getName() + " ) -> "
								+ JS_TransitionLabelServices.populateTransitionLabel(t);
					}
				}

				return itemText;
			}
		}
		return null;
	}
}