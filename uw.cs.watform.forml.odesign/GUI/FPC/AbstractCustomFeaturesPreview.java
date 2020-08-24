package FPC;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.List;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomControlFeaturePreview;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomListForClasses;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.DNDOperationsForListItems;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.MenuTypeHelper;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.CustomCompositeCreateNewElement;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.NewElementsCreationHelperClass;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.general.JS_MessageServices;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class AbstractCustomFeaturesPreview extends SashForm {

	protected CustomListForClasses lstSelfClassList;
	protected CustomListForClasses lstDirectClasses;
	protected CustomListForClasses lstIndirectClasses;
	protected CustomListForClasses lstNotRelatedClasses;
	protected java.util.List<Roleable> Self_Direct_Indirect_Roleables = new ArrayList<Roleable>();
	protected Composite composite_ExpandBarHolder;
	protected EObject elementUnderSearch;
	protected Roleable selectedRoleable;
	protected CustomListForClasses selectedList;
	protected java.util.List<Roleable> usedRoleables = new ArrayList<Roleable>();

	public Button chkShowUsedClasses;

	public AbstractCustomFeaturesPreview(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	protected void resetAll() {
		lstSelfClassList.removeAll();
		lstDirectClasses.removeAll();
		lstIndirectClasses.removeAll();
		lstNotRelatedClasses.removeAll();

		Self_Direct_Indirect_Roleables.clear();
		selectedRoleable = null;
		selectedList = null;

	}

	public void populate(CustomListForClasses selectedLst, int index) {

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

	public void createNewAttOrMsg(Class type, String newName) {
		NewElementsCreationHelperClass.createNewElement(type, composite_ExpandBarHolder, selectedRoleable, selectedList,
				(CustomControlFeaturePreview) this, newName);

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
			MenuTypeHelper.AssignRightClickMenu(lst, releventLeftSideList, this.selectedRoleable,
					(CustomControlFeaturePreview) this);
		}
		xpndItem.setHeight(parentComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		xpndItem.setControl(parentComposite);
		xpndItem.setExpanded(true);

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

	protected void createNewButton(Composite parentComposite, Class type) {
		CustomCompositeCreateNewElement createNewElementHolder = new CustomCompositeCreateNewElement(parentComposite,
				SWT.FILL, type, (CustomControlFeaturePreview) this);
		// GridData gd_btnHolder = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		// gd_btnHolder.heightHint = 17;
		// btnHolder.setLayoutData(gd_btnHolder);
		// btnHolder.setLayout(new RowLayout(SWT.HORIZONTAL));

	}

}
