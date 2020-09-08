package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class CustomCompositeForClassViewer extends AbstractCustomCompositeForClassViewer {

	private Roleable focusElemenet;
	private Composite composite_ClassList;
	private CCombo comboList;
	private CustomCompositeClassPropertiesViewer composite_PropertiesHolder;
	private Combo combo;

	private EObject elementUnderSearch;

	public CustomCompositeForClassViewer(Composite parent, int style, Roleable elem) {

		super(parent, style);

		if (elem == null)
			return;

		this.focusElemenet = elem;

		constructDesign(parent);

	}

	private void constructDesign(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		setLayout(gridLayout);

		composite_ClassList = new Composite(this, SWT.NONE);
		composite_ClassList.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_ClassList = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
		gd_composite_ClassList.heightHint = 44;
		composite_ClassList.setLayoutData(gd_composite_ClassList);

		CustomSearchBarForFeatureModuleClassPreviewer searchBar = new CustomSearchBarForFeatureModuleClassPreviewer(
				composite_ClassList, SWT.NONE, this.focusElemenet, this);

		composite_PropertiesHolder = new CustomCompositeClassPropertiesViewer(this, SWT.NONE, this.focusElemenet,
				this.elementUnderSearch);
		// composite_PropertiesHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
		// true, true, 1, 4));
		// RowLayout rl_composite_PropertiesHolder = new RowLayout(SWT.VERTICAL);
		// rl_composite_PropertiesHolder.fill = true;
		// composite_PropertiesHolder.setLayout(rl_composite_PropertiesHolder);

		// populateClassProperties(this.focusElemenet);

		this.layout();

		setRedraw(true);
	}

	@Override
	public boolean findItem(EObject element) {
		Roleable roleable = ModelUtils.getTypedRootForObject(element, Roleable.class);

		if (roleable == null)
			return false;
		else {

			composite_PropertiesHolder.reset();

			elementUnderSearch = element;
			composite_PropertiesHolder.populateClassProperties(roleable, this.elementUnderSearch);

			elementUnderSearch = null;

			return true;
		}
	}

}
