package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

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
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.internal.CustomMessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences2;

public class CustomTreeNodeForConsistencyManagement extends org.eclipse.swt.widgets.Composite {

	private final int comboList_NotSelected_0 = 0;
	private final int comboList_Edit_1 = 1;
	private final int comboList_Delete_2 = 2;
	private final int comboList_DeleteParentTransition_3 = 3;

	private Tree tree;
	private List<EObject> crossReferences = new ArrayList<EObject>();
	HashMap<Transition, TreeItem> hash_alreaddyAddedTransitions = new HashMap<Transition, TreeItem>();
	HashMap<EObject, TreeItem> hash_alreaddyAddedEventGuardAction = new HashMap<EObject, TreeItem>();
	HashMap<Roleable, TreeItem> hash_alreaddyAddedFeatures = new HashMap<Roleable, TreeItem>();
	HashMap<TreeItem, CCombo> hash_TreeItemCombos = new HashMap<TreeItem, CCombo>();
	HashMap<TreeItem, Transition> deleteingParentTransitionsTreeItems = new HashMap<TreeItem, Transition>();
	List<InconsistentData> datas = new ArrayList<InconsistentData>();
	List<TreeItem> allLeafNodes = new ArrayList<TreeItem>();
	//HashMap<TreeItem, List<TreeItem>> map_SimilarTreeItems = new HashMap<TreeItem, List<TreeItem>>();

	Font origFont;
	// private Frame frame;
	// DefaultTreeModel model;
	// DefaultMutableTreeNode root;
	private Shell shell;
	AbstractShellContainer shellContainer;
	private Composite composite_TextualEditor;
	private Composite composite_TreeAndEditorHolder;
	private Button chkbkxViewGraphicalEditor;
	//private TreeItem selectedTreeItem;

	public CustomTreeNodeForConsistencyManagement(Composite parent, List<EObject> crossRefs, int style) {
		super(parent, style);
		this.crossReferences = crossRefs;
		ConstructTree();
	}

	public void setContorls(Composite inputComposite_TreeAndEditorHolder, Shell inputShell,
			AbstractShellContainer inputShellContainer, Composite inputComposite_TextualEditor,
			Button inputChkbkxViewGraphicalEditor) {
		this.shell = inputShell;
		this.shellContainer = inputShellContainer;
		this.composite_TextualEditor = inputComposite_TextualEditor;
		this.composite_TreeAndEditorHolder = inputComposite_TreeAndEditorHolder;
		this.chkbkxViewGraphicalEditor = inputChkbkxViewGraphicalEditor;

	}

	private void createAndShowTree() {
		setLayout(new GridLayout(1, false));

		tree = new Tree(this, SWT.FILL | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tree.setHeaderVisible(true);
		TreeColumn elementColumn = new TreeColumn(tree, SWT.LEFT);
		elementColumn.setText("Element");
		elementColumn.setWidth(200);
		TreeColumn ActionColumn = new TreeColumn(tree, SWT.CENTER);
		ActionColumn.setText("Action");

		ActionColumn.setWidth(170);

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

		//populateSimilarTreeItems();
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

//	private void populateSimilarTreeItems() {
//		for (TreeItem t_i : allLeafNodes) {
//			try {
//				InconsistentData data_i = (InconsistentData) t_i.getData();
//
//				List<TreeItem> ltree = new ArrayList<TreeItem>();
//				for (TreeItem t_j : allLeafNodes) {
//					if (t_i != t_j) {
//						InconsistentData data_j = (InconsistentData) t_j.getData();
//
//						if (EcoreUtil.equals(data_i.ref_model_element, data_j.ref_model_element)) {
//							ltree.add(t_j);
//						}
//					}
//				}
//				map_SimilarTreeItems.put(t_i, ltree);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

	private void CreateEditor(EObject ref) {

		InconsistentData data = new InconsistentData(ref, null, null);

		// FeatureModule Tree Item
		TreeItem feature_item = getTreeItemForFeatureModule(data);

		// Tranisition Tree Item
		TreeItem transitions_SubItem = getTreeItemForTransition(data, feature_item);

		// ega Tree Item, ega.col=0
		TreeItem subsubItem = getTreeItemForEventGuardAction(data, transitions_SubItem);

		allLeafNodes.add(subsubItem);

	}

	private TreeItem getTreeItemForEventGuardAction(InconsistentData data, TreeItem transitions_SubItem) {
		TreeItem EventGuardAction = hash_alreaddyAddedEventGuardAction.get(data.ref_model_element);
		if (EventGuardAction == null) {
			TreeItem item = new TreeItem(transitions_SubItem, SWT.NONE);
			item.setText(0, data.event_Guard_Action);

			final TreeEditor editor = new TreeEditor(tree);
			// Action Tree Item, ega.col=1
			final CCombo combo = new CCombo(tree, SWT.READ_ONLY);
			combo.setItems(new String[] { "Select an Action", "Edit", "Delete", "Delete Parent Element" });
			combo.select(this.comboList_NotSelected_0);
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			combo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// item.setText(1, combo.getText());
					tree.setSelection(item);
					setTree();
					SelectAndViewEobject(item);
				}
			});
			editor.setEditor(combo, item, 1);
			hash_TreeItemCombos.put(item, combo);
			data.treeItem = item;
			data.combo = combo;
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

	private CCombo getComboForTreeItem(TreeItem item) {
		return hash_TreeItemCombos.get(item);

	}

	// FeatureModule Tree Item
	private TreeItem getTreeItemForFeatureModule(InconsistentData data) {

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
	private TreeItem getTreeItemForTransition(InconsistentData data, TreeItem feature_item) {

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
		item.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_edit.png"));

		item.setForeground(editColor);
		item.setFont(editFont);

	}

	private void item_delete_style(TreeItem item, boolean children) {
		org.eclipse.swt.graphics.Color deleteColor = SWTResourceManager.getColor(255, 0, 0);
		FontDescriptor deleteDescriptor = FontDescriptor.createFrom(origFont)
				.setStyle(SWT.ITALIC | SWT.UNDERLINE_SINGLE);
		Font deleteFont = deleteDescriptor.createFont(getDisplay());
		item.setForeground(deleteColor);
		item.setFont(deleteFont);
		item.setImage(SWTResourceManager.getImage(FrmShellForCrossReferenceView_TreeStyle.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_delete.png"));

		if (children) {
			for (TreeItem i0 : item.getItems()) {
				item_delete_style(i0, false);
				hash_TreeItemCombos.get(i0).select(2);
			}
		}
	}

	private void resetTree() {
		deleteingParentTransitionsTreeItems.clear();

		tree.setRedraw(false);

		for (TreeItem i0 : tree.getItems()) {
			resetTreeItem(i0);
		}
		tree.setRedraw(true);

		for (TreeItem deleteParent : deleteingParentTransitionsTreeItems.keySet())
			item_delete_style(deleteParent, true);

		tree.layout();

	}

	// if there is a parent item that is set to delete, then the sibling items
	// should be ignored.
	private void resetTreeItem(TreeItem item) {

		CCombo combo = getComboForTreeItem(item);

		if (combo == null || combo.getSelectionIndex() == comboList_NotSelected_0) {
			item.setFont(origFont);
			item.setForeground(SWTResourceManager.getColor(0, 0, 0));
			Image img = null;
			item.setImage(img);
			deleteingParentTransitionsTreeItems.remove(item.getParentItem());
		} else if (combo.getSelectionIndex() == comboList_Edit_1) {
			item_edit_style(item);
			deleteingParentTransitionsTreeItems.remove(item.getParentItem());
		} else if (combo.getSelectionIndex() == comboList_Delete_2) {
			item_delete_style(item, false);
		} else if (combo.getSelectionIndex() == comboList_DeleteParentTransition_3) {
			// item_delete_style(item, false);
			setAllSiblingsDelete(item);
			if (item.getData() instanceof InconsistentData) {
				deleteingParentTransitionsTreeItems.put(item.getParentItem(),
						((InconsistentData) item.getData()).transition_model_element);
			}
		}

		for (TreeItem i0 : item.getItems()) {
			resetTreeItem(i0);
		}

	}

	private void setAllSiblingsDelete(TreeItem item) {
		for (TreeItem ti : getSiblings(item)) {
			hash_TreeItemCombos.get(ti).select(this.comboList_Delete_2);
		}

	}

	private TreeItem[] getSiblings(TreeItem item) {
		return item.getParentItem().getItems();

	}

	private void SelectAndViewEobject(TreeItem item) {
		setRedraw(false); // Stop redraw until operation complete
		try {
			CCombo combo = hash_TreeItemCombos.get(item);
			if (combo == null) {
				if (item.getText().startsWith("Transition")) {
					Transition trans = ((InconsistentData) item.getData()).transition_model_element;
					if (trans != null)
						createTransitionEditor(trans, false);
				}

			} else {
				InconsistentData data = ((InconsistentData) item.getData());
				Transition trans = data.transition_model_element;
				boolean isEdit = (combo.getSelectionIndex() == comboList_Edit_1);

				createEventGuardActionEditor(trans, isEdit, data);
				//this.selectedTreeItem = item;

				if (chkbkxViewGraphicalEditor.getSelection() && isEdit)
					viewDiagramEditor(trans);
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
			// composite_TextualEditor.dispose();
			// composite_TextualEditor = new Composite(composite_TreeAndEditorHolder,
			// SWT.BORDER);
			renewTextualEditor();

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
		// composite_TextualEditor.getParent().layout(true,true);
		composite_TreeAndEditorHolder.layout(true, true);
		composite_TextualEditor.redraw();

	}

	private void createEventGuardActionEditor(Transition trans, boolean isEdit, InconsistentData data) {

		try {
			// Create Editor For the Whole Transition
			XtextEmbeddedEditorForCrossReferences2 transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences2(
					ModelUtils.getInjector(), isEdit, data.treeItem, allLeafNodes, tree); //

			renewTextualEditor();

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

	private void renewTextualEditor() {
		// composite_TextualEditor.dispose();
		// composite_TextualEditor = new Composite(composite_TreeAndEditorHolder,
		// SWT.BORDER);
		for (Control control : this.composite_TextualEditor.getChildren())
			control.dispose();

	}

	private void viewDiagramEditor(Transition trans) {
		Helper_InteractiveConsistencyManage.transition = trans;
		FeatureModule fm = ModelUtils.getTypedRootForObject(trans, FeatureModule.class);
		RepresentationsUtils.openRepresentationInAParentShell(this.shell,
				ModelUtils.getTypedRootForObject(trans, FeatureModule.class), 0, this.shell.getSize().y);
	}

	private void deleteElement(InconsistentData d) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(d.transition_model_element);

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (d.event_Guard_Action.equals(d.type_eventType)) {
					// Trigger trig = FormlFactory.eINSTANCE.createTrigger();
					// trig.setWce(value);
					EcoreUtil.remove(d.transition_model_element.getTrig());
					// d.transition_model_element.setTrig(null);
				} else if (d.event_Guard_Action.equals(d.type_guardType)) {
					Guard guard = FormlFactory.eINSTANCE.createGuard();
					d.transition_model_element.setGuard(guard);
				} else if (d.event_Guard_Action.equals(d.type_effectType)) {
					WCAList wca = FormlFactory.eINSTANCE.createWCAList();
					d.transition_model_element.setList(wca);
				}

				// EcoreUtil.delete(d);
			}
		});
	}

	private void deleteElement(Transition t) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(t);

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				EcoreUtil.delete(t);
			}
		});
	}

	public boolean checkForConfirmation(EObject deletingElemenet) {

		try {
			Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(deletingElemenet);

			if (referrers.size() > 0) {
				for (InconsistentData d : datas) {
					CCombo combo = hash_TreeItemCombos.get(d.treeItem);
					// if there exists an element in the referrers which also exist in the dialogue
					// box and either not selected or edit is selected for it
					if (combo.getSelectionIndex() == this.comboList_Edit_1
							|| combo.getSelectionIndex() == this.comboList_NotSelected_0) {

						if (hasItem(referrers, d.ref_model_element)) {
							CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
									"There are still references in the model. Please fix them before going further.");
							return false;
						}
					}
				}

				// delete those elements that "delete" is selected for them
				for (InconsistentData d : datas) {
					CCombo combo = hash_TreeItemCombos.get(d.treeItem);
					if (combo.getSelectionIndex() >= this.comboList_Delete_2) {
						deleteElement(d);
					}
				}

				// delete those elements that the user selected to be deleted as a parent item
				for (TreeItem item : deleteingParentTransitionsTreeItems.keySet()) {
					deleteElement(deleteingParentTransitionsTreeItems.get(item));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// check one last time before exit
		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(deletingElemenet);
		if (referrers.size() > 0) {
			CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
					"There are still references in the model. Please fix them before going further.");
			return false;
		}

		return true;

	}

	public boolean checkForGuardConfirmation(EObject deletingElemenet) {

		try {
			List<Guard> guards = ModelUtils2.getBehaviourModelObjectsByType(deletingElemenet, Guard.class);

			List<EObject> problematic_guards = new ArrayList<EObject>();
			for (Guard g : guards) {
				if (!ModelUtils2.checkGuardTypes(g)) {
					problematic_guards.add(g);
				}
			}

			if (problematic_guards.size() > 0) {
				CustomMessageDialogs.dlgErrorMessageEdit(shell, "Error",
						"There are still types that are not sound. Please fix all of them.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

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

//	public void copyToSimilarItems() {
//	if (this.selectedTreeItem == null)
//			return;
//
//		Object org_data = this.selectedTreeItem.getData();
//		InconsistentData inc_data = null;
//		if (org_data instanceof InconsistentData)
//			inc_data = ((InconsistentData) org_data);
//
//		if (inc_data == null) {
//			return;
//		}
//		List<TreeItem> similars = map_SimilarTreeItems.get(this.selectedTreeItem);
//
//		for (TreeItem ts : similars) {
//			Object data = ts.getData();
//			InconsistentData inc_ts_data = null;
//			if (data instanceof InconsistentData)
//				inc_ts_data = ((InconsistentData) data);
//
//			List<String> attNames = new ArrayList<String>();
//			attNames.add("name".toLowerCase());
//			ModelUtils2.copy(inc_data.ref_model_element, inc_ts_data.ref_model_element, attNames);
//
//		}
//	}

}