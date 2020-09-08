package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import uw.cs.watform.forml.forml.Roleable;

public abstract class AbstractCustomCompositeForClassViewer extends Composite {

	private Roleable focusElemenet;
	private Composite composite_ClassList;
	private CCombo comboList;
	private CustomCompositeClassPropertiesViewer composite_PropertiesHolder;
	private Combo combo;

	private EObject elementUnderSearch;

	public AbstractCustomCompositeForClassViewer(Composite parent, int style) {
		super(parent, style);

	}

	protected boolean findItem(EObject element) {
		return false;
	}

}
