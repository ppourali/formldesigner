package uw.cs.watform.forml.services.general;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.impl.*;
import uw.cs.watform.forml.services.GUI.*;

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
