package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import FPC.AbstractCustomFeaturesPreview;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.CustomCompositeCreateNewElement;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.NewElementsCreationHelperClass;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.general.JS_MessageServices;
import uw.cs.watform.forml.services.utilities.AssociationUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class CustomControlFeaturePreview extends AbstractCustomFeaturesPreview {

	// controls
	private CustomListForClasses lstSelfClassList;
	private CustomListForClasses lstDirectClasses;
	private CustomListForClasses lstIndirectClasses;
	private CustomListForClasses lstNotRelatedClasses;
	private Composite composite_ExpandBarHolder;
	private java.util.List<Roleable> Self_Direct_Indirect_Roleables = new ArrayList<Roleable>();
	private Roleable selectedRoleable;
	private CustomListForClasses selectedList;
	private EObject elementUnderSearch;
	private Button btnCreateNewClass;
	private Composite composite;
	private Text txtNewClassName;
	public Button chkShowUsedClasses;
	java.util.List<Roleable> usedRoleables = new ArrayList<Roleable>();

	public CustomControlFeaturePreview(Shell parent) {

		super(parent, SWT.BORDER);
		constructDesgin();

		populateList();
		installDNDpolicies();

	}

	private void installDNDpolicies() {
		DNDOperationsForDirectList.setDragSource(lstIndirectClasses.getList());
		DNDOperationsForDirectList.setDragSource(lstNotRelatedClasses.getList());
		DNDOperationsForDirectList.setDragDropTarget(lstDirectClasses.getList());
	}

	private void constructDesgin() {
		setLayout(new GridLayout(1, false));

		Composite compositeClasses = new Composite(this, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginTop = 3;
		gridLayout.verticalSpacing = 1;
		gridLayout.marginHeight = 0;
		compositeClasses.setLayout(gridLayout);

		chkShowUsedClasses = new Button(compositeClasses, SWT.CHECK);
		chkShowUsedClasses.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		chkShowUsedClasses.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		chkShowUsedClasses.setText("Show Only Used Classes");
		chkShowUsedClasses.setSelection(true);

		CLabel lblSelfClasses = new CLabel(compositeClasses, SWT.NONE);
		lblSelfClasses.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblSelfClasses.setText("Current Class");

		lstSelfClassList = new CustomListForClasses(compositeClasses, SWT.NONE, 23);
		lstSelfClassList.setBackground(SWTResourceManager.getColor(255, 250, 205));

		CLabel lblDirectRelationship = new CLabel(compositeClasses, SWT.NONE);
		lblDirectRelationship.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDirectRelationship.setText("Direct Relationship");

		lstDirectClasses = new CustomListForClasses(compositeClasses, SWT.NONE, 60);
		lstDirectClasses.setBackground(SWTResourceManager.getColor(255, 250, 205));
//		GridData gd_lstDirectClasses = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
//		gd_lstDirectClasses.heightHint = 40;
//		lstDirectClasses.setLayoutData(gd_lstDirectClasses);

		CLabel lblIndirectClasses = new CLabel(compositeClasses, SWT.NONE);
		lblIndirectClasses.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblIndirectClasses.setText("Indirect Relationship");

		lstIndirectClasses = new CustomListForClasses(compositeClasses, SWT.NONE, 60);
		lstIndirectClasses.setBackground(SWTResourceManager.getColor(255, 250, 205));
//		GridData gd_lstIndirectClasses = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
//		gd_lstIndirectClasses.heightHint = 50;
//		lstIndirectClasses.setLayoutData(gd_lstIndirectClasses);

		CLabel lblNotRelatedClasses = new CLabel(compositeClasses, SWT.NONE);
		lblNotRelatedClasses.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblNotRelatedClasses.setText("No Relationship");
		lstNotRelatedClasses = new CustomListForClasses(compositeClasses, SWT.NONE, 60);
		lstNotRelatedClasses.setBackground(SWTResourceManager.getColor(255, 250, 205));
//		GridData gd_lstNotRelatedClasses = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
//		gd_lstNotRelatedClasses.heightHint = 50;
//		lstNotRelatedClasses.setLayoutData(gd_lstNotRelatedClasses);

		composite = new Composite(compositeClasses, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		composite.setVisible(true);
		GridLayout gl_composite_3 = new GridLayout(1, false);
		gl_composite_3.verticalSpacing = 0;
		gl_composite_3.marginWidth = 2;
		gl_composite_3.marginHeight = 0;
		composite.setLayout(gl_composite_3);

		CLabel lblEnterAName = new CLabel(composite, SWT.NONE);
		lblEnterAName.setVisible(true);
		lblEnterAName.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblEnterAName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblEnterAName.setText("New class name:");
		lblEnterAName.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.BOLD | SWT.ITALIC));

		txtNewClassName = new Text(composite, SWT.BORDER);
		txtNewClassName.setVisible(true);
		txtNewClassName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (txtNewClassName.getText().trim().equals(""))
					btnCreateNewClass.setEnabled(false);
				else
					btnCreateNewClass.setEnabled(true);
			}
		});
		txtNewClassName.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		txtNewClassName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtNewClassName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.keyCode == SWT.CR) {
					CreateNewClass();
				}
			}
		});

		btnCreateNewClass = new Button(composite, SWT.NONE);
		btnCreateNewClass.setEnabled(false);
		btnCreateNewClass.setVisible(true);
		btnCreateNewClass.setImage(SWTResourceManager.getImage(CustomControlFeaturePreview.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_add.png"));
		btnCreateNewClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CreateNewClass();

			}
		});
		btnCreateNewClass.setText("Create New Class");

		composite_ExpandBarHolder = new Composite(this, SWT.NONE);
		composite_ExpandBarHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		setWeights(new int[] { 123, 219 });
		// pack();
		// layout();

		chkShowUsedClasses.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				populateList();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	protected void CreateNewClass() {
		NewElementsCreationHelperClass.createNewEntity(Entity.class, composite_ExpandBarHolder, selectedRoleable,
				this.lstNotRelatedClasses, this, txtNewClassName.getText().replace(" ", ""));

		txtNewClassName.setText("");
	}

	public void populateList() {

		populate(lstSelfClassList, 0);

	}

	public void getUsedClassesList() {
		usedRoleables = ModelUtils2
				.getRoleablesReferredInStateMachine(CommonSpaceForContextualUI.getCurrentTransition());
	}

	public void populate(CustomListForClasses selectedLst, int index) {

		if (CommonSpaceForContextualUI.getCurrentTransition() != null) {
			resetAll();

			getUsedClassesList();

			findSelfRoleableAndSetList(CommonSpaceForContextualUI.getCurrentTransition());

			findDirectRoleablesAndSetList(CommonSpaceForContextualUI.getCurrentTransition());

			findIndirectRoleablesAndSetList(CommonSpaceForContextualUI.getCurrentTransition());

			findNotRelatedRoleablesAndSetList(CommonSpaceForContextualUI.getCurrentTransition());

			selectedLst.select(index);
			doOnSelect(selectedLst);
		}
	}

	public void populateList(CustomListForClasses selectedLst, String selectionText) {

		populate(selectedLst, 0);

		int index = 0;
		if (selectionText != null && !selectionText.trim().equals("")) {
			for (String item : selectedLst.getItems()) {
				if (item.equalsIgnoreCase(selectionText)) {
					break;
				}
				index++;
			}
		}

		// selectedLst.select(index);
		selectedLst.setSelection(index);
	}

	public void populateList(CustomListForClasses selectedLst, boolean selectFirst, boolean selectCurrent,
			boolean selectLast) {
		int index = 0;
		int selected = selectedLst.getSelectionIndex();

		if (selectCurrent) {

			if (selected >= 0)
				index = selected;
			else
				index = 0;
			// populate(selectedLst, index);
		} else if (selectLast) {
			index = selectedLst.getItemCount();
			// populate(selectedLst, index);
		} else if (selectFirst) {
			index = 0;

		}
		populate(selectedLst, index);
	}

	public void resetAll() {
		lstSelfClassList.removeAll();
		lstDirectClasses.removeAll();
		lstIndirectClasses.removeAll();
		lstNotRelatedClasses.removeAll();

		Self_Direct_Indirect_Roleables.clear();
		selectedRoleable = null;
		selectedList = null;

	}

	private void findSelfRoleableAndSetList(Transition tranistion) {
		lstSelfClassList.setRedraw(false);
		String CurrentRoleable = "";
		java.util.List<Roleable> selfRoleables = new ArrayList<Roleable>();
		selfRoleables.add(CommonSpaceForContextualUI.getCurrentFeatureOrEntityClass());
		// populate self class list
		for (Roleable f : selfRoleables) {
			lstSelfClassList.add(f.getName(), null, null);
			lstSelfClassList.setData(f.getName(), f);

			if (f.equals(ModelUtils2
					.getTypedRootForObject(CommonSpaceForContextualUI.getCurrentTransition(), FeatureModule.class)
					.getFeatureref()))
				CurrentRoleable = f.getName();
		}

		lstSelfClassList.addSelectionListener(listSelectionListener(lstSelfClassList));

		Self_Direct_Indirect_Roleables.addAll(selfRoleables);
		lstSelfClassList.setRedraw(true);

	}

	private void findDirectRoleablesAndSetList(Transition tranistion) {
		lstDirectClasses.setRedraw(false);
		Roleable selfRoleable = ModelUtils2
				.getTypedRootForObject(CommonSpaceForContextualUI.getCurrentTransition(), FeatureModule.class)
				.getFeatureref();

		java.util.List<Roleable> directRoleables = AssociationUtils.getAssociatedEntities(selfRoleable);

		for (Roleable f : directRoleables) {
			if (!f.equals(selfRoleable)) {
				if (chkShowUsedClasses.getSelection()) {
					if (!usedRoleables.contains(f)) {
						continue;
					}
				}

				lstDirectClasses.add(f.getName(), f, selfRoleable);
				lstDirectClasses.setData(f.getName(), f);

			}
		}

		lstDirectClasses.addSelectionListener(listSelectionListener(lstDirectClasses));

		Self_Direct_Indirect_Roleables.addAll(directRoleables);
		// refineListSize(lstDirectClasses);
		lstDirectClasses.setRedraw(true);
	}

	private void refineListSize(CustomListForClasses list) {
		Object layoutdata = list.getLayoutData();
		if (layoutdata instanceof GridData) {
			if (list.getItemCount() <= 3) {
				((GridData) layoutdata).heightHint = -1;
				list.pack();
			} else {
				((GridData) layoutdata).heightHint = 40;
			}
		}

	}

	private void findIndirectRoleablesAndSetList(Transition tranistion) {
		lstIndirectClasses.setRedraw(false);

		Roleable selfRoleable = ModelUtils2
				.getTypedRootForObject(CommonSpaceForContextualUI.getCurrentTransition(), FeatureModule.class)
				.getFeatureref();

		java.util.List<Roleable> indirectRoleables = AssociationUtils.getIndirectAssociations(selfRoleable);

		for (Roleable f : indirectRoleables) {
			if (!f.equals(selfRoleable)) {
				if (chkShowUsedClasses.getSelection()) {
					if (!usedRoleables.contains(f)) {
						continue;
					}
				}
				lstIndirectClasses.add(f.getName(), null, null);
				lstIndirectClasses.setData(f.getName(), f);
			}

			Self_Direct_Indirect_Roleables.addAll(indirectRoleables);
		}

		lstIndirectClasses.addSelectionListener(listSelectionListener(lstIndirectClasses));

		lstIndirectClasses.setRedraw(true);

	}

	private void findNotRelatedRoleablesAndSetList(Transition tranistion) {
		lstNotRelatedClasses.setRedraw(false);

		Roleable selfRoleable = ModelUtils2
				.getTypedRootForObject(CommonSpaceForContextualUI.getCurrentTransition(), FeatureModule.class)
				.getFeatureref();

		java.util.List<Roleable> allRoleables = ModelUtils.getWorldModelObjectsByType(selfRoleable, Roleable.class);

		allRoleables.removeAll(Self_Direct_Indirect_Roleables);

		java.util.List<Roleable> NotRelatedRoleables = new ArrayList<Roleable>();
		NotRelatedRoleables.addAll(allRoleables);

		for (Roleable f : NotRelatedRoleables) {
			if (!f.equals(selfRoleable)) {
				if (chkShowUsedClasses.getSelection()) {
					if (!usedRoleables.contains(f)) {
						continue;
					}
				}
				lstNotRelatedClasses.add(f.getName(), null, null);
				lstNotRelatedClasses.setData(f.getName(), f);
			}
		}

		lstNotRelatedClasses.addSelectionListener(listSelectionListener(lstNotRelatedClasses));

		lstNotRelatedClasses.setRedraw(true);

	}

	private SelectionListener listSelectionListener(CustomListForClasses lstList) {
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				doOnSelect(lstList);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	public boolean findItem(EObject element) {
		Roleable roleable = ModelUtils.getTypedRootForObject(element, Roleable.class);

		if (roleable == null)
			return false;
		else {
			elementUnderSearch = element;
			CustomListForClasses lst = findListForRoleable(roleable);

			doOnSelect(lst);
			if (element instanceof Roleable) {
				return true;
			}

			elementUnderSearch = null;
			if (lst == null)
				return false;
			else
				return true;
		}
	}

	private CustomListForClasses findListForRoleable(Roleable roleable) {
		java.util.List<CustomListForClasses> allLists = new ArrayList<CustomListForClasses>();
		allLists.add(lstSelfClassList);
		allLists.add(lstDirectClasses);
		allLists.add(lstIndirectClasses);
		allLists.add(lstNotRelatedClasses);
		String name = roleable.getName();
		for (CustomListForClasses lst : allLists) {
			for (String item : lst.getItems()) {
				if (item.equalsIgnoreCase(name)) {
					Object itemdata = lst.getData(name);

					if (itemdata != null) {
						lst.setSelection(new String[] { item });

						return lst;
					}
				}
			}

		}

		// if it could not find the list, it means that the class is hidden because it
		// was not used in the statemachine, thus we uncheck the hide check box and
		// re-find
		chkShowUsedClasses.setSelection(false);
		populateList();

		allLists.add(lstSelfClassList);
		allLists.add(lstDirectClasses);
		allLists.add(lstIndirectClasses);
		allLists.add(lstNotRelatedClasses);
		name = roleable.getName();
		for (CustomListForClasses lst : allLists) {
			for (String item : lst.getItems()) {
				if (item.equalsIgnoreCase(name)) {
					Object itemdata = lst.getData(name);

					if (itemdata != null) {
						lst.setSelection(new String[] { item });

						return lst;
					}
				}
			}

		}

		return null;
	}

	public void doOnSelect() {
		if (selectedList != null) {
			doOnSelect(selectedList);
		}
	}

	public void doOnSelect(CustomListForClasses lstList) {
		this.setRedraw(false);
		int selection = lstList.getSelectionIndex();
		lstSelfClassList.deselectAll();
		lstDirectClasses.deselectAll();
		lstIndirectClasses.deselectAll();
		lstNotRelatedClasses.deselectAll();
		lstList.setFocus();
		lstList.setSelection(selection);

		Object roleable = lstList.getData(lstList.getSelection()[0]);
		if (roleable != null) {
			populateExpandBar((Roleable) roleable, lstList);
			selectedRoleable = (Roleable) roleable;
			selectedList = lstList;
		}
		this.setRedraw(true);
	}

	// TODO: Selection might be an Entity and not a Roleable
	private void populateExpandBar(Roleable roleable, CustomListForClasses lstList) {

		GridLayout gl_composite = new GridLayout(1, true);
		gl_composite.verticalSpacing = 2;

		for (Control control : composite_ExpandBarHolder.getChildren()) {
			control.dispose();
		}

		ExpandBar expandBar = new ExpandBar(composite_ExpandBarHolder, SWT.FILL | SWT.V_SCROLL);

		ExpandItem xpndtmAttributes = new ExpandItem(expandBar, SWT.NONE);
		xpndtmAttributes.setExpanded(false);
		xpndtmAttributes.setText("Attributes");
		Composite xpndAttCompos = new Composite(expandBar, SWT.NONE);
		xpndtmAttributes.setControl(xpndAttCompos);
		xpndAttCompos.setLayout(gl_composite);
		if (roleable.getAttributes().size() > 0) {
			createObjectLabelsForAttsInpsOuts(xpndtmAttributes, xpndAttCompos, roleable.getAttributes(),
					Attribute.class, lstList);
		} else {
			EList voidList = new BasicEList();
			createObjectLabelsForAttsInpsOuts(xpndtmAttributes, xpndAttCompos, voidList, Attribute.class, lstList);
		}

		if (roleable instanceof Feature) {
			ExpandItem xpndtmInputmessages = new ExpandItem(expandBar, SWT.NONE);
			xpndtmInputmessages.setExpanded(false);
			xpndtmInputmessages.setText("Input Messages");
			Composite xpndInCompos = new Composite(expandBar, SWT.NONE);
			if (((Feature) roleable).getInputlist() != null
					&& ((Feature) roleable).getInputlist().getInputs().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmInputmessages, xpndInCompos,
						((Feature) roleable).getInputlist().getInputs(), Input.class, lstList);
			} else {
				EList voidList = new BasicEList();
				createObjectLabelsForAttsInpsOuts(xpndtmInputmessages, xpndInCompos, voidList, Input.class, lstList);
			}

			ExpandItem xpndtmOutputMessages = new ExpandItem(expandBar, SWT.NONE);
			xpndtmOutputMessages.setExpanded(false);
			xpndtmOutputMessages.setText("Output Messages");
			Composite xpndOutCompos = new Composite(expandBar, SWT.NONE);
			if (((Feature) roleable).getOutputlist() != null
					&& ((Feature) roleable).getOutputlist().getOutputs().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmOutputMessages, xpndOutCompos,
						((Feature) roleable).getOutputlist().getOutputs(), Output.class, lstList);
			} else {
				EList voidList = new BasicEList();
				createObjectLabelsForAttsInpsOuts(xpndtmOutputMessages, xpndOutCompos, voidList, Output.class, lstList);
			}

			expandBar.setSpacing(5);
			composite_ExpandBarHolder.pack();
			// composite_ExpandBarHolder.setSize(350, lstList.getSize().y - 30);
			composite_ExpandBarHolder.redraw();
			composite_ExpandBarHolder.update();

			xpndAttCompos.layout(true, true);
			xpndAttCompos.redraw();

			xpndInCompos.layout(true, true);
			xpndInCompos.redraw();

			xpndOutCompos.layout(true, true);
			xpndOutCompos.redraw();
		}

		else if (roleable instanceof Entity) {
			ExpandItem xpndtmFunctionmessages = new ExpandItem(expandBar, SWT.NONE);
			xpndtmFunctionmessages.setExpanded(false);
			xpndtmFunctionmessages.setText("Functions");
			Composite xpndFuncCompos = new Composite(expandBar, SWT.NONE);
			if (((Entity) roleable).getFunctions() != null && ((Entity) roleable).getFunctions().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmFunctionmessages, xpndFuncCompos,
						((Entity) roleable).getFunctions(), Function.class, lstList);
			} else {
				EList voidList = new BasicEList();
				createObjectLabelsForAttsInpsOuts(xpndtmFunctionmessages, xpndFuncCompos, voidList, Function.class,
						lstList);
			}

			expandBar.setSpacing(5);
			composite_ExpandBarHolder.pack();
			// composite_ExpandBarHolder.setSize(350, lstList.getSize().y - 30);
			composite_ExpandBarHolder.redraw();
			composite_ExpandBarHolder.update();

			xpndAttCompos.layout(true, true);
			xpndAttCompos.redraw();

			xpndFuncCompos.layout(true, true);
			xpndFuncCompos.redraw();
		}

		composite_ExpandBarHolder.layout(true, true);
		composite_ExpandBarHolder.redraw();

		composite_ExpandBarHolder.getParent().layout(true, true);
		composite_ExpandBarHolder.getParent().redraw();
	}

	private <T extends EObject> void createObjectLabelsForAttsInpsOuts(ExpandItem xpndItem, Composite parentComposite,
			EList<T> items, Class type, CustomListForClasses releventLeftSideList) {

		createNewButton(parentComposite, type);

		GridLayout gl_composite = new GridLayout(1, true);
		gl_composite.verticalSpacing = 2;
		parentComposite.setLayout(gl_composite);

		if (items.size() > 0) {
			List lst = new List(parentComposite, SWT.NONE | SWT.V_SCROLL);
			lst.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

			for (T el : items) {
				String itemText = "";
				if (el instanceof RefMessage) {
					itemText = JS_MessageServices.PopulateMessageSignature(el);
				} else if (el instanceof Function) {
					itemText = JS_FeatureClassServices.PopulateFunctionLabel(el);
				} else if (el instanceof Attribute) {
					itemText = ((Attribute) el).getName();
					if (((Attribute) el).getType() != null) {
						String attType = ModelUtils2.convertAttributeTypeToString(((Attribute) el).getType());
						itemText += " : " + attType.trim();
					}
				}

				lst.add(itemText);
				lst.setData(itemText, el);

				if (el.equals(elementUnderSearch)) {
					int foundIndex = lst.getItemCount() - 1;
					lst.select(foundIndex);
				}
			}
			lst.addSelectionListener(modelElementSelectionListener());

			lst.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					lst.deselectAll();

				}

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub

				}
			});

			DNDOperationsForListItems.setDragSource(lst);
			MenuTypeHelper.AssignRightClickMenu(lst, releventLeftSideList, this.selectedRoleable, this);
		}
		xpndItem.setHeight(parentComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		xpndItem.setControl(parentComposite);
		xpndItem.setExpanded(true);

	}

	public void createNewButton(Composite parentComposite, Class type) {
		CustomCompositeCreateNewElement createNewElementHolder = new CustomCompositeCreateNewElement(parentComposite,
				SWT.FILL, type, this);
		// GridData gd_btnHolder = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		// gd_btnHolder.heightHint = 17;
		// btnHolder.setLayoutData(gd_btnHolder);
		// btnHolder.setLayout(new RowLayout(SWT.HORIZONTAL));

	}

	public void createNewAttOrMsg(Class type, String newName) {
		NewElementsCreationHelperClass.createNewElement(type, composite_ExpandBarHolder, selectedRoleable, selectedList,
				this, newName);

	}

	private SelectionListener modelElementSelectionListener() {
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof List) {
					List lst = (List) e.getSource();
					Object data = lst.getData(lst.getSelection()[0]);

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}
}
