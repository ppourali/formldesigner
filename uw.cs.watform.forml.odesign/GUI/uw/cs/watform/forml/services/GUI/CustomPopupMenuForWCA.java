package uw.cs.watform.forml.services.GUI;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomSearchTextForWCA;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class CustomPopupMenuForWCA {

	private Feature curFeature;
	private SelectionListener itemSelectionListener;
	private Menu popupMenu;
	private StyledText txtContainer;
	private CustomSearchTextForWCA CustomSearchCompositeContainer;

	public CustomPopupMenuForWCA(StyledText txtFilter, Feature currentFeature, CustomSearchTextForWCA customSearchText) {

		this.curFeature = currentFeature;
		this.itemSelectionListener = createSelectionListener();
		this.txtContainer = txtFilter;
		this.CustomSearchCompositeContainer = customSearchText;

		popupMenu = new Menu(txtFilter);
		populateList();

		txtContainer.setMenu(popupMenu);
	}

	private SelectionListener createSelectionListener() {
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof MenuItem) {
					txtContainer.setText(((MenuItem) e.getSource()).getText() + ".");
					txtContainer.setCaretOffset(txtContainer.getText().length());
					CustomSearchCompositeContainer.FilterLstOperationsByText();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	private void populateList() {

		FeatureModule fm = ModelUtils2.getFeatureModuleForFeature(this.curFeature);

		for (Roleable feature : ModelUtils2.getParentOriginalFeatureModules(fm)) {
			createMenuItem(feature);
		}

		// for (EObject p : ModelUtils.getWorldModel(curFeature).getConcepts())
		// {
		// if (!p.equals(curFeature)) {
		// if (p instanceof Feature || p instanceof Entity) {
		// createMenuItem(p);
		// }
		// // if (p instanceof Feature) {
		// for (RefMessage msg : ((Feature)
		// p).getInputlist().getInputs()) {
		// createMenuItem(msg.getRefMsg());
		// }
		// for (ExprRef att : ((Feature) p).getAttributes()) {
		// createMenuItem((Attribute) att);
		// }
		// } else if (p instanceof Entity) {
		//
		// for (ExprRef att : ((Entity) p).getAttributes()) {
		// createMenuItem((Attribute) att);
		// }
		// }
		// }
		// }
	}

	private void createMenuItem(EObject object) {
		MenuItem menuItem = new MenuItem(popupMenu, SWT.NONE);
		menuItem.addSelectionListener(itemSelectionListener);
		if (object instanceof Feature) {
			menuItem.setText(((Feature) object).getName());
		} else if (object instanceof Entity) {
			menuItem.setText(((Entity) object).getName());
		}
	}

	// private void createMenuItem(EObject object, String parentName) {
	// MenuItem menuItem = new MenuItem(this, SWT.NONE);
	// menuItem.addSelectionListener(itemSelectionListener);
	// if (object instanceof Message)
	// menuItem.setText(((Message) object).getName()+ " () : " + parentName);
	// else if (object instanceof Attribute)
	// menuItem.setText(((Attribute) object).getName() + " : " + parentName);
	// }
}
