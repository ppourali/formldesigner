package uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.services.internal.CustomMessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences2;

public class CustomTreeNodeForConsistencyManagement extends org.eclipse.swt.widgets.Composite {

	private Tree tree;
	private List<EObject> crossReferences = new ArrayList<EObject>();
	HashMap<Transition, TreeItem> hash_alreaddyAddedTransitions = new HashMap<Transition, TreeItem>();
	HashMap<EObject, TreeItem> hash_alreaddyAddedEventGuardAction = new HashMap<EObject, TreeItem>();
	HashMap<Roleable, TreeItem> hash_alreaddyAddedFeatures = new HashMap<Roleable, TreeItem>();
	HashMap<TreeItem, CCombo> hash_TreeItemCombos = new HashMap<TreeItem, CCombo>();
	HashMap<TreeItem, Transition> deleteingParentTransitionsTreeItems = new HashMap<TreeItem, Transition>();
	List<ReferencedData> datas = new ArrayList<ReferencedData>();
	List<TreeItem> allLeafNodes = new ArrayList<TreeItem>();

	Font origFont;
	// private Frame frame;
	// DefaultTreeModel model;
	// DefaultMutableTreeNode root;

	private Composite composite_TextualEditor;
	private Composite composite_TreeAndEditorHolder;

	public CustomTreeNodeForConsistencyManagement(Composite parent, List<EObject> crossRefs, int style) {
		super(parent, style);
		this.crossReferences = crossRefs;
		ConstructTree();
	}

	public void setContorls(Composite inputComposite_TreeAndEditorHolder, Composite inputComposite_TextualEditor) {
		this.composite_TextualEditor = inputComposite_TextualEditor;
		this.composite_TreeAndEditorHolder = inputComposite_TreeAndEditorHolder;
	}

	private void createAndShowTree() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		tree = new Tree(this, SWT.FILL | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setHeaderVisible(true);
		TreeColumn elementColumn = new TreeColumn(tree, SWT.LEFT);
		elementColumn.setText("Element");
		// elementColumn.setWidth(200);

		CreateModel();

	}

	private void ConstructTree() {
		createAndShowTree();
		expandAll(tree.getItems());
		tree.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (tree.getSelection()[0].getItemCount() == 0)
					SelectAndViewEobject(tree.getSelection()[0]);
				else {
					if (tree.getSelection()[0].getText().startsWith("Transition"))
						SelectAndViewEobject(tree.getSelection()[0]);

				}
			}
		});
		
	

		// TreeNode root = (TreeNode) tree.getModel().getRoot();
		// expandAll(tree, new TreePath(root));

		/*
		 * setLayout(new FillLayout(SWT.HORIZONTAL)); tree = new JTree();
		 * 
		 * JScrollPane scrollPane = new JScrollPane(tree);
		 * scrollPane.setAutoscrolls(true); frame.add(scrollPane, BorderLayout.CENTER);
		 * // frame.setSize(300, 300); frame.setVisible(true);
		 * 
		 * tree.setRowHeight(25);
		 * 
		 * root = new DefaultMutableTreeNode("Behavioural Model"); model = new
		 * DefaultTreeModel(root); tree.setModel(model); tree.setRootVisible(true);
		 * tree.setShowsRootHandles(true);
		 * 
		 * frame.add(tree); CreateModel(crossReferences);
		 * 
		 * TreeCellRenderer renderer = new EventCellRenderer();
		 * tree.setCellRenderer(renderer);
		 * 
		 * expandAll(tree, new TreePath((TreeNode) model.getRoot()));
		 */
	}

	private void expandAll(TreeItem[] items) {
		tree.setRedraw(false); // Stop redraw until operation complete

		for (TreeItem item : items) {
			item.setExpanded(true);
			expandAll(item.getItems());
		}

		tree.setRedraw(true);
		this.layout();
		// TreeNode node = (TreeNode) parent.getLastPathComponent();
		// if (node.getChildCount() >= 0) {
		// for (Enumeration e = node.children(); e.hasMoreElements();) {
		// TreeNode n = (TreeNode) e.nextElement();
		// TreePath path = parent.pathByAddingChild(n);
		// expandAll(tree, path);
		// }
		// }
		// tree.expandPath(parent);
	}

	private void CreateModel() {
		allLeafNodes.clear();

		for (EObject ref : this.crossReferences) {
			CreateEditor(ref);
		}
//		Iterator<Setting> iter = crossReferences.iterator();
//
//		while (iter.hasNext()) {
//			EObject ref = iter.next().getEObject();
//
//			// Transition parentTransition = ModelUtils.getTypedRootForObject(ref,
//			// Transition.class);
//
//			// if (parentTransition != null) {
//			// if (!alreaddyAdded.contains(parentTransition)) {
//			CreateEditor(ref);
//			// alreaddyAdded.add(parentTransition);
//			// }
//			// }
//		}
	}

	private void CreateEditor(EObject ref) {

		ReferencedData data = new ReferencedData(ref, null, null);

		// FeatureModule Tree Item
		TreeItem feature_item = getTreeItemForFeatureModule(data);

		// Tranisition Tree Item
		TreeItem transitions_SubItem = getTreeItemForTransition(data, feature_item);

		// ega Tree Item, ega.col=0

		TreeItem subsubItem = getTreeItemForEventGuardAction(data, transitions_SubItem);

		allLeafNodes.add(subsubItem);

	}

	private TreeItem getTreeItemForEventGuardAction(ReferencedData data, TreeItem transitions_SubItem) {
		TreeItem EventGuardAction = hash_alreaddyAddedEventGuardAction.get(data.ref_model_element);
		if (EventGuardAction == null) {
			TreeItem item = new TreeItem(transitions_SubItem, SWT.NONE);
			item.setText(0, data.event_Guard_Action);

			final TreeEditor editor = new TreeEditor(tree);
			// Action Tree Item, ega.col=1

			data.treeItem = item;

			item.setData(data);
			datas.add(data);
			origFont = transitions_SubItem.getFont(0);

			item.setData(data);
			hash_alreaddyAddedEventGuardAction.put(data.ref_model_element, item);

			return item;
		} else {
			return EventGuardAction;
		}
	}

	// FeatureModule Tree Item
	private TreeItem getTreeItemForFeatureModule(ReferencedData data) {

		TreeItem feature = hash_alreaddyAddedFeatures.get(data.feature_model_element);
		if (feature == null) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("Feature Module: " + data.featureModule);
			item.setData(data);
			hash_alreaddyAddedFeatures.put(data.feature_model_element, item);
			return item;
		} else {
			return feature;
		}
	}

	// Transition Tree Item
	private TreeItem getTreeItemForTransition(ReferencedData data, TreeItem feature_item) {

		TreeItem transition = hash_alreaddyAddedTransitions.get(data.transition_model_element);
		if (transition == null) {
			TreeItem item = new TreeItem(feature_item, SWT.NONE);
			item.setText(new String[] { "Transition: " + data.transition });
			item.setData(data);
			hash_alreaddyAddedTransitions.put(data.transition_model_element, item);
			return item;
		} else {
			return transition;
		}
	}

	protected void setTree() {
		resetTree();
	}

	private void item_edit_style(TreeItem item) {
		org.eclipse.swt.graphics.Color editColor = SWTResourceManager.getColor(0, 255, 0);

		FontDescriptor editDescriptor = FontDescriptor.createFrom(origFont).setStyle(SWT.ITALIC);
		Font editFont = editDescriptor.createFont(getDisplay());
		item.setImage(SWTResourceManager.getImage(CustomCompositeForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_edit.png"));

		item.setForeground(editColor);
		item.setFont(editFont);

	}

	private void resetTree() {
		deleteingParentTransitionsTreeItems.clear();

		tree.setRedraw(false);

		for (TreeItem i0 : tree.getItems()) {
			resetTreeItem(i0);
		}
		tree.setRedraw(true);

		tree.layout();

	}

	// if there is a parent item that is set to delete, then the sibling items
	// should be ignored.
	private void resetTreeItem(TreeItem item) {

		item.setFont(origFont);
		item.setForeground(SWTResourceManager.getColor(0, 0, 0));
		Image img = null;
		item.setImage(img);
		deleteingParentTransitionsTreeItems.remove(item.getParentItem());

		item_edit_style(item);
		deleteingParentTransitionsTreeItems.remove(item.getParentItem());

	}

	private TreeItem[] getSiblings(TreeItem item) {
		return item.getParentItem().getItems();

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
					ModelUtils.getInjector(), isEdit, data.treeItem, allLeafNodes, tree); //
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

	private boolean hasItem(Collection<Setting> referrers, EObject ref_model_element) {
		Iterator<Setting> iter = referrers.iterator();
		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();
			Class<? extends EObject> parentclass = ref_model_element.getClass();
			EObject parentContainer = ModelUtils.getTypedRootForObject(ref, parentclass);
			if (ref.equals(ref_model_element) || parentContainer == ref_model_element)
				return true;
		}
		return false;
	}

}
