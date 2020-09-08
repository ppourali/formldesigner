package uw.cs.watform.forml.services.delete;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.ModelDeleteOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * This is a java service class used in Sirius to handle deleting entities on
 * Feature Modules.
 * 
 * 
 * @author ppourali
 * 
 */
public class JS_Action_Delete_On_FeatureModule {

	// handles deletes states or regions on the feature module diagram
	// if a state is deleted, all the transitions connected to it must be also
	// deleted as well as all the inner regions and their inner states and their
	// connected transitions
	public static void Delete_StatesOrRegions(EObject t) {

		List<State> AllStates = ModelUtils.getObjectsByTypeInAnObjectElement(t, State.class);

		List<Region> AllRegions = ModelUtils.getObjectsByTypeInAnObjectElement(t, Region.class);

		if (t instanceof State)
			AllStates.add((State) t);
		else if (t instanceof Region)
			AllRegions.add((Region) t);

		List<Transition> allTransitions = ModelUtils.getObjectsByTypeInAnObjectType(t, StateMachine.class,
				Transition.class);

		// get all the states as the source and destinations of the transitions
		List<Transition> allToBeDeletedTransitions = new ArrayList<Transition>();

		for (Transition trans : allTransitions) {
			if (AllStates.contains((trans).getSrc()) || AllStates.contains((trans).getDst())) {
				allToBeDeletedTransitions.add(trans);
			}

			if (AllRegions.contains((trans).getSrc()) || AllRegions.contains((trans).getDst())) {
				allToBeDeletedTransitions.add(trans);
			}
		}

		// delete the transitions
		for (Transition deletingtrans : allToBeDeletedTransitions) {
			ModelDeleteOperations.deleteTransition(deletingtrans);
		}
	}
}
