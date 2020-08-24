package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomListForClasses;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.DNDOperationsForListItems;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.MenuTypeHelper;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.general.JS_MessageServices;
import uw.cs.watform.forml.services.utilities.AssociationUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;

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
