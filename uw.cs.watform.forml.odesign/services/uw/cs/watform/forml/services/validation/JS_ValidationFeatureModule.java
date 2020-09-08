package uw.cs.watform.forml.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.InitState;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class JS_ValidationFeatureModule {

	/*
	 * validate if all the states have at least one transition connected
	 */
	public static boolean validate_StatesWithoutTransitions(EObject t) {
		// get all the transitions in the feature module
		List<Transition> allTransitions = ModelUtils.getObjectsByTypeInAnObjectType(t, FeatureModule.class,
				Transition.class);

		// get all the states as the source and destinations of the transitions
		List<State> allStateAsSrcAndDes = new ArrayList<State>();

		for (EObject src_des : allTransitions) {
			if (((Transition) src_des).getSrc() instanceof State)
				allStateAsSrcAndDes.add(((Transition) src_des).getSrc());

			if (((Transition) src_des).getDst() instanceof State)
				allStateAsSrcAndDes.add(((Transition) src_des).getDst());
		}

		if (!allStateAsSrcAndDes.contains(t))
			return false;
		else
			return true;
	}

	/*
	 * validate if all the initial states have a node as reference
	 */
	public static boolean validate_AllInitStatesHaveRefNode(EObject t) {
		return (((InitState) t).getStateref() != null);
	}

	/*
	 * validate if all the regions have initial state
	 */
	public static boolean validate_AllRegionsHaveInitialState(EObject t) {
		return (((Region) t).getInit() != null);
	}

	/*
	 * validate if all the states WCE Guard and WCAs have messages and
	 * attributes in the corresponding classes
	 */

	/*
	 * Transitions without events
	 */
	public static boolean validate_TransitionsWithoutTrigerringEvents(EObject t) {
		return (((Transition) t).getTrig() != null || ((Transition) t).getGuard() != null);
	}

}
