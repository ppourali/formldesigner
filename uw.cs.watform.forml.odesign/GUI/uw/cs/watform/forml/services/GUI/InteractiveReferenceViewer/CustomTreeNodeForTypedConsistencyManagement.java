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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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

public class CustomTreeNodeForTypedConsistencyManagement extends org.eclipse.swt.widgets.Composite {

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
	List<TypedInconsistentData> datas = new ArrayList<TypedInconsistentData>();

	Font origFont;
	// private Frame frame;
	// DefaultTreeModel model;
	// DefaultMutableTreeNode root;
	private Shell shell;
	AbstractShellContainer shellContainer;
	private Composite composite_TextualEditor;
	private Composite composite_TreeAndEditorHolder;
	private Button chkbkxViewGraphicalEditor;
	private Text txt_OriginalGuardText;
	private HashMap<EObject, String> mapForGuardToText;
	private EObject DeletingElement;

	public CustomTreeNodeForTypedConsistencyManagement(Composite parent, List<EObject> crossRefs,
			EObject inputDeletingElement, HashMap<EObject, String> map_TransitionToText, int style) {
		super(parent, style);
		this.crossReferences = crossRefs;
		this.mapForGuardToText = map_TransitionToText;
		this.DeletingElement = inputDeletingElement;
		ConstructTree();
	}

	public void setContorls(Composite inputComposite_TreeAndEditorHolder, Shell inputShell,
			AbstractShellContainer inputShellContainer, Composite inputComposite_TextualEditor,
			Button inputChkbkxViewGraphicalEditor, Text inputTextOriginalGuardText) {
		this.shell = inputShell;
		this.shellContainer = inputShellContainer;
		this.composite_TextualEditor = inputComposite_TextualEditor;
		this.composite_TreeAndEditorHolder = inputComposite_TreeAndEditorHolder;
		this.chkbkxViewGraphicalEditor = inputChkbkxViewGraphicalEditor;
		this.txt_OriginalGuardText = inputTextOriginalGuardText;

	}

	private void createAndShowTree() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		tree = new Tree(this, SWT.FILL | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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

		TypedInconsistentData data = new TypedInconsistentData(ref, null, null);

		// FeatureModule Tree Item
		TreeItem feature_item = getTreeItemForFeatureModule(data);

		// Tranisition Tree Item
		TreeItem transitions_SubItem = getTreeItemForTransition(data, feature_item);

		// ega Tree Item, ega.col=0

		TreeItem subsubItem = getTreeItemForEventGuardAction(data, transitions_SubItem);

	}

	private TreeItem getTreeItemForEventGuardAction(TypedInconsistentData data, TreeItem transitions_SubItem) {
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
					item.setText(1, combo.getText());
					tree.setSelection(item);
					setTree();
					SelectAndViewEobject(item);
					//combo.select(comboList_Edit_1);
				}
			});
			editor.setEditor(combo, item, 1);
			hash_TreeItemCombos.put(item, combo);
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

	private CCombo getComboForTreeItem(TreeItem item) {
		return hash_TreeItemCombos.get(item);

	}

	// FeatureModule Tree Item
	private TreeItem getTreeItemForFeatureModule(TypedInconsistentData data) {

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
	private TreeItem getTreeItemForTransition(TypedInconsistentData data, TreeItem feature_item) {

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
			if (item.getData() instanceof TypedInconsistentData) {
				deleteingParentTransitionsTreeItems.put(item.getParentItem(),
						((TypedInconsistentData) item.getData()).transition_model_element);
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
		CCombo combo = hash_TreeItemCombos.get(item);
		if (combo == null)
			return;

		try {
			TypedInconsistentData data = ((TypedInconsistentData) item.getData());
			Transition trans = data.transition_model_element;
			boolean isEdit = (combo.getSelectionIndex() == comboList_Edit_1);

			createTransitionEditor(trans, isEdit, data);

			if (chkbkxViewGraphicalEditor.getSelection() && isEdit)
				viewDiagramEditor(trans);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createTransitionEditor(Transition trans, boolean isEdit, TypedInconsistentData data) {
		/*
		 * try { composite_TextualEditor.dispose(); composite_TextualEditor = new
		 * Composite(composite_TreeAndEditorHolder,SWT.FILL| SWT.BORDER);
		 * 
		 * if (data.event_Guard_Action.equals(data.type_eventType)) {
		 * CustomEditorHelper_Trig editorhelper = new CustomEditorHelper_Trig(); if
		 * (editorhelper.injector == null) editorhelper.injector =
		 * ModelUtils.getInjector();
		 * editorhelper.createEditor(this.composite_TextualEditor, trans,
		 * Trigger.class); } else if
		 * (data.event_Guard_Action.equals(data.type_guardType)) {
		 * CustomEditorHelper_Guard editorhelper = new CustomEditorHelper_Guard();
		 * 
		 * if (editorhelper.injector == null) editorhelper.injector =
		 * ModelUtils.getInjector();
		 * 
		 * editorhelper.createEditor(this.composite_TextualEditor, trans, Guard.class);
		 * 
		 * } else if (data.event_Guard_Action.equals(data.type_effectType)) {
		 * CustomEditorHelper_Action editorhelper;
		 * 
		 * editorhelper = new CustomEditorHelper_Action();
		 * 
		 * if (editorhelper.injector == null) editorhelper.injector =
		 * ModelUtils.getInjector();
		 * 
		 * editorhelper.createEditor(this.composite_TextualEditor, trans,
		 * WCAList.class); } } catch (CoreException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } finally { composite_TextualEditor.layout(true,
		 * true); composite_TreeAndEditorHolder.layout(true, true); }
		 */

		try {

			String origText = mapForGuardToText.get(trans);
			if (origText != null)
				txt_OriginalGuardText.setText(origText);

//			composite_1.setLayout(new GridLayout(1, false));
//			composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));
//			formToolkit.adapt(composite_1);
//			formToolkit.paintBordersFor(composite_1);

			composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

			// Create Editor For the Whole Transition
			XtextEmbeddedEditorForCrossReferences2 transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferences2(
					ModelUtils.getInjector(), isEdit); //
			composite_TextualEditor.dispose();
			composite_TextualEditor = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);
			composite_TextualEditor.pack();

			composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			// composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
			// true, 1, 2));
			composite_TextualEditor.layout(true, true);
			if (data.event_Guard_Action.equals(data.type_eventType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, Trigger.class);
			} else if (data.event_Guard_Action.equals(data.type_guardType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, Guard.class);
			} else if (data.event_Guard_Action.equals(data.type_effectType)) {
				transition_embeddedEditor.createEditor(composite_TextualEditor, trans, WCAList.class);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		composite_TextualEditor.layout(true, true);
		composite_TreeAndEditorHolder.layout(true, true);
		composite_TextualEditor.redraw();

	}

	private void viewDiagramEditor(Transition trans) {
		Helper_InteractiveConsistencyManage.transition = trans;
		FeatureModule fm = ModelUtils.getTypedRootForObject(trans, FeatureModule.class);
		RepresentationsUtils.openRepresentationInAParentShell(this.shell,
				ModelUtils.getTypedRootForObject(trans, FeatureModule.class),0, this.shell.getSize().y);
	}

	private void deleteElement(TypedInconsistentData d) {
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
				for (TypedInconsistentData d : datas) {
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
				for (TypedInconsistentData d : datas) {
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

}

