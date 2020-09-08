package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class CustomMultiCompositeForClassViewer extends AbstractCustomCompositeForClassViewer {

	private HashSet<Roleable> focusElemenets = new HashSet<Roleable>();
	private Composite composite_ClassList;
	private HashSet<CustomCompositeClassPropertiesViewer> composite_PropertiesHolders = new HashSet<CustomCompositeClassPropertiesViewer>();

	CustomCompositeClassPropertiesViewer compositeSearched_PropertiesHolder;

	private EObject elementUnderSearch;

	public CustomMultiCompositeForClassViewer(Composite parent, int style, List<Roleable> elem) {

		super(parent, style);

		if (elem == null)
			return;

		this.focusElemenets.addAll(elem);

		constructDesign(parent);

	}

	private void constructDesign(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		setLayout(gridLayout);

		Composite compositeSearchBarHolder = new Composite(this, SWT.FILL);
		compositeSearchBarHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		compositeSearchBarHolder.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		CustomSearchBarForFeatureModuleClassPreviewer searchBar = new CustomSearchBarForFeatureModuleClassPreviewer(
				compositeSearchBarHolder, SWT.NONE, this.focusElemenets.iterator().next(), this);

		composite_ClassList = new Composite(this, SWT.NONE);
		composite_ClassList.setLayout(new RowLayout(SWT.HORIZONTAL));
		GridData gd_composite_ClassList = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 3);
		gd_composite_ClassList.heightHint = 44;
		//gd_composite_ClassList.widthHint = 144;
		composite_ClassList.setLayoutData(gd_composite_ClassList);

		for (Roleable fe : focusElemenets) {
			CustomCompositeClassPropertiesViewer propertiesHolder = new CustomCompositeClassPropertiesViewer(
					composite_ClassList, SWT.NONE, fe, this.elementUnderSearch);

			this.composite_PropertiesHolders.add(propertiesHolder);
		}
		this.layout();

		setRedraw(true);
	}

	@Override
	public boolean findItem(EObject element) {
		Roleable roleable = ModelUtils.getTypedRootForObject(element, Roleable.class);

		if (roleable == null)
			return false;
		else {

			if (compositeSearched_PropertiesHolder == null) {
				compositeSearched_PropertiesHolder = new CustomCompositeClassPropertiesViewer(composite_ClassList,
						SWT.NONE, roleable, this.elementUnderSearch);
			} else {
				compositeSearched_PropertiesHolder.reset();
			}
			elementUnderSearch = element;
			compositeSearched_PropertiesHolder.populateClassProperties(roleable, this.elementUnderSearch);

			elementUnderSearch = null;
			compositeSearched_PropertiesHolder.layout();
			composite_ClassList.layout();
			this.layout();
			return true;

		}
//			composite_PropertiesHolder.reset();
//
//			elementUnderSearch = element;
//			composite_PropertiesHolder.populateClassProperties(roleable, this.elementUnderSearch);
//
//			elementUnderSearch = null;
//
//			return true;
//		}
	}

}
