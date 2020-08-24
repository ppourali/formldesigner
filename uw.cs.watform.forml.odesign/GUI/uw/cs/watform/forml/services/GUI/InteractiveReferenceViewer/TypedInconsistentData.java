package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TreeItem;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.services.utilities.ModelUtils;

class TypedInconsistentData {
	public final String type_eventType = "Event";
	public final String type_guardType = "Guard";
	public final String type_effectType = "Effect";

	public String featureModule;
	public String transition;
	public String event_Guard_Action;

	public Roleable feature_model_element;
	public Transition transition_model_element;
	public EObject ref_model_element;

	public CCombo combo;
	public TreeItem treeItem;

	public TypedInconsistentData(EObject ref, CCombo c, TreeItem item) {
		this.combo = c;
		this.treeItem = item;
		this.feature_model_element = ModelUtils.getTypedRootForObject(ref, FeatureModule.class).getFeatureref();
		this.featureModule = feature_model_element.getName();

		this.transition_model_element = ModelUtils.getTypedRootForObject(ref, Transition.class);
		this.transition = transition_model_element.getName();

		if (ref instanceof WCE) {
			this.ref_model_element = (WCE) ref;
			this.event_Guard_Action = type_eventType;
		} else if (ModelUtils.getTypedRootForObject(ref, Guard.class) != null) {
			this.ref_model_element = ModelUtils.getTypedRootForObject(ref, Guard.class);
			this.event_Guard_Action = type_guardType;
		} else if (ModelUtils.getTypedRootForObject(ref, Action.class) != null) {
			this.ref_model_element = ModelUtils.getTypedRootForObject(ref, Action.class);
			this.event_Guard_Action = type_effectType;
		}

	}

}