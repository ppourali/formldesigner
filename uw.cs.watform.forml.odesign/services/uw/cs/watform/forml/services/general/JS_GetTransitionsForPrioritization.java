package uw.cs.watform.forml.services.general;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.FragmentType;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;

/**
 * All the services related to transitions prioritization.
 * 
 * 
 * @author ppourali
 */
public final class JS_GetTransitionsForPrioritization {

	public JS_GetTransitionsForPrioritization() {
	}

	/*
	 * In a Fragment diagram, gets all the transition that are prioritizable.
	 */
	public static EList<Transition> get_Available_TransitionsForFragments(EObject t) {
		EList<Transition> validTransitions = new BasicEList<Transition>();
		validTransitions.addAll(((FragmentType) t.eContainer()).getTransitions());

		validTransitions.remove(t);

		if (((Transition) t).getPriority() != null)
			validTransitions.removeAll(((Transition) t).getPriority().getTranslist().getTransitions());

		return validTransitions;
	}

	/*
	 * In a State Machine diagram, gets all the transition that are prioritizable.
	 */

	public static EList<Transition> get_Available_TransitionsForStateMachine(EObject t) {
		EList<Transition> validTransitions = new BasicEList<Transition>();
		validTransitions.addAll(((StateMachine) t.eContainer()).getTransitions());

		validTransitions.remove(t);

		if (((Transition) t).getPriority() != null)
			validTransitions.removeAll(((Transition) t).getPriority().getTranslist().getTransitions());

		return validTransitions;
	}

	/*
	 * Gets all the transitions that are already assigned/selected for priority.
	 */
	public static EList<Transition> get_AlreadySelected_Transitions(EObject t) {
		EList<Transition> validTransitions = new BasicEList<Transition>();

		if (((Transition) t).getPriority() != null)
			validTransitions.addAll(((Transition) t).getPriority().getTranslist().getTransitions());

		return validTransitions;
	}
}
