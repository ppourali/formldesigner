package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.NewElementsCreationHelperClass;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class MenuTypeHelper {

	static CustomControlFeaturePreview customControlFeaturePreview;

	public static void AssignRightClickMenu(List lst, CustomListForClasses releventLeftSideList,
			Roleable selectedRoleable, CustomControlFeaturePreview parentForm) {

		customControlFeaturePreview = parentForm;

		Menu popupMenu = new Menu(lst);

		// CONSTANT TYPES MENU ITEMS
		MenuItem intTypeItem = new MenuItem(popupMenu, SWT.NONE);
		intTypeItem.setText("int");
		intTypeItem.setData(CreateDataType("int"));
		intTypeItem.addSelectionListener(menuItemListener(intTypeItem, lst, releventLeftSideList));

		MenuItem boolTypeItem = new MenuItem(popupMenu, SWT.NONE);
		boolTypeItem.setText("bool");
		boolTypeItem.setData(CreateDataType("bool"));
		boolTypeItem.addSelectionListener(menuItemListener(boolTypeItem, lst, releventLeftSideList));

		MenuItem stringTypeItem = new MenuItem(popupMenu, SWT.NONE);
		stringTypeItem.setText("string");
		stringTypeItem.setData(CreateDataType("string"));
		stringTypeItem.addSelectionListener(menuItemListener(stringTypeItem, lst, releventLeftSideList));

		MenuItem undefinedTypeItem = new MenuItem(popupMenu, SWT.NONE);
		undefinedTypeItem.setText("void");
		undefinedTypeItem.setData(CreateDataType("void"));
		undefinedTypeItem.addSelectionListener(menuItemListener(undefinedTypeItem, lst, releventLeftSideList));

		// CUSTOM TYPES MENU ITEMS
		MenuItem newItem = new MenuItem(popupMenu, SWT.CASCADE);
		newItem.setText("custom types");
		Menu newMenu = new Menu(popupMenu);
		newItem.setMenu(newMenu);

		java.util.List<Concept> cons = ModelUtils.getWorldModelObjectsByType(selectedRoleable, Concept.class);
		for (Concept c : cons) {

			MenuItem customTypeItem = new MenuItem(newMenu, SWT.NONE);
			customTypeItem.setText(c.getName().trim());
			customTypeItem.setData(CreateDataType(c.getName()));
			customTypeItem.addSelectionListener(menuItemListener(customTypeItem, lst, releventLeftSideList));
		}

		lst.setMenu(popupMenu);

	}

	private static SelectionListener menuItemListener(MenuItem menuItem, List list,
			CustomListForClasses releventLeftSideList) {
		// TODO Auto-generated method stub
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (list.getSelectionCount() > 0) {
					String itemName = list.getSelection()[0];

					Object data = list.getData(itemName);
					NewElementsCreationHelperClass.setType(data, menuItem.getData(), releventLeftSideList,
							customControlFeaturePreview);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	private static Object CreateDataType(String typeName) {

		return ModelUtils2.createAttributeType(typeName);
	}

	// private static Object CreateBoolDataType() {
	// BoolType type = FormlFactory.eINSTANCE.createBoolType();
	// return type;
	// }

	// private static Object CreateStringDataType() {
	// StringType type = FormlFactory.eINSTANCE.createStringType();
	// return type;
	// }
//
//	private static Object CreateRefDataType(Concept value) {
//		return ModelUtils.getReferencedType(value);
//	}

//	private static Object CreateUndefDataType(EObject elem) {
//		return ModelUtils.getUndefinedTypeInWorldModel(elem);
//	}

}
