package uw.cs.watform.forml.services.keyboard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractDiagramContainerEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainer2EditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart;
import org.eclipse.sirius.diagram.ui.tools.api.util.EditPartTools;
import org.eclipse.swt.widgets.Display;

import uw.cs.watform.forml.forml.Component;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FrmFPC_FeatureNode;
import uw.cs.watform.forml.services.GUI.FragmentStateFocusContext.FrmFPC_FragmentState;
import uw.cs.watform.forml.services.general.JS_TransitionLabelServices;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;
import uw.cs.watform.forml.viewpoint.xtext.support.CreateEmbeddedEditors;

/**
 * 
 * Handles the actions for feature modules diagram keyboard hits.
 * 
 * @author ppourali
 */
@SuppressWarnings("restriction")
public final class SharedKeyBoardActionsOnFeatureModule {

	private static DiagramEditPart diagramEditPart;

	private static List<Component> findContainerRegions(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		List<Component> selectedContainers = new ArrayList<Component>();

		if (viewer.getSelectedEditParts() == null) {
			return selectedContainers;
		} else if (viewer.getSelectedEditParts() != null) {
			if (viewer.getSelectedEditParts().size() == 0) {
				return selectedContainers;
			}

			for (Object c : viewer.getSelectedEditParts()) {
				if (c != null && c instanceof DNodeContainer2EditPart) {
					// JOptionPane.showMessageDialog(null, c.getClass());
					Component f = findAssociatedRegion((DNodeContainer2EditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}
			}
		}

		return selectedContainers;
	}

	private static List<EObject> findContainerStates(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		List<EObject> selectedContainers = new ArrayList<EObject>();

		if (viewer.getSelectedEditParts() == null) {
			return selectedContainers;
		} else if (viewer.getSelectedEditParts() != null) {
			if (viewer.getSelectedEditParts().size() == 0) {
				return selectedContainers;
			}

			for (Object c : viewer.getSelectedEditParts()) {
				// an state or a region is selected
				if (c != null && c instanceof DNodeContainer2EditPart) {
					EObject f = findAssociatedState((DNodeContainer2EditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}
				// the very parent statemachine is selected
				else if (c != null && c instanceof DNodeContainerEditPart) {
					EObject f = findAssociatedState((DNodeContainerEditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}
			}
		}

		return selectedContainers;
	}

	private static Transition findSelectedTransition(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		Transition selectedContainers = null;

		if (viewer.getSelectedEditParts() == null) {
			return selectedContainers;
		} else if (viewer.getSelectedEditParts() != null) {
			if (viewer.getSelectedEditParts().size() == 0) {
				return selectedContainers;
			}

			Object c = viewer.getSelectedEditParts().get(0);

			// a transition is selected
			if (c != null && c instanceof DEdgeEditPart) {
				selectedContainers = findAssociatedTransition((DEdgeEditPart) c);
				return selectedContainers;
			}
		}

		return selectedContainers;
	}

	private static Transition findAssociatedTransition(DEdgeEditPart transitionEdge) {

		if (transitionEdge != null) {
			if (transitionEdge.getModel() instanceof View) {
				View v = (View) (transitionEdge.getModel());
				if (v.getElement().eCrossReferences().get(0) instanceof Transition)
					return (Transition) v.getElement().eCrossReferences().get(0);
			}
		}
		return null;
	}

	private static Component findAssociatedRegion(DNodeContainer2EditPart container) {
		// if feature selected or any of feature parts are selected
		if (container != null) {
			if (container.getModel() instanceof View) {
				View v = (View) (container.getModel());
				if (v.getElement().eCrossReferences().get(0) instanceof Component)
					return (Component) v.getElement().eCrossReferences().get(0);
			}
		}
		return null;
	}

	private static EObject findAssociatedState(EditPart container) {

		AbstractDiagramContainerEditPart parentStateContainer;

		if (container instanceof DNodeContainerEditPart)
			parentStateContainer = (DNodeContainerEditPart) container;
		else
			parentStateContainer = (EditPartTools.getParentOfType(container, AbstractDiagramContainerEditPart.class));

		if (parentStateContainer != null) {
			if (parentStateContainer.getModel() instanceof View) {
				View v = (View) (parentStateContainer.getModel());
				if (v.getElement().eCrossReferences().get(0) instanceof State)
					return (State) v.getElement().eCrossReferences().get(0);
				else if (v.getElement().eCrossReferences().get(0) instanceof Region) {
					if (((Region) v.getElement().eCrossReferences().get(0)).eContainer() instanceof State)
						return (State) ((Region) v.getElement().eCrossReferences().get(0)).eContainer();
					else if (((Region) v.getElement().eCrossReferences().get(0)).eContainer() instanceof StateMachine)
						return (StateMachine) ((Region) v.getElement().eCrossReferences().get(0)).eContainer();
				} else if (v.getElement().eCrossReferences().get(0) instanceof StateMachine)
					return (StateMachine) v.getElement().eCrossReferences().get(0);

			}
		}
		return null;
	}

	public static void createState(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		diagramEditPart = parentDiagramEditPart;

		for (Component parentComponent : findContainerRegions(viewer, parentDiagramEditPart)) {
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					ModelOperations2.CreateNewStateOnAnyObject(parentComponent);

				}
			});
		}
	}

	public static void createRegion(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		diagramEditPart = parentDiagramEditPart;

		for (EObject parentState : findContainerStates(viewer, parentDiagramEditPart)) {
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					ModelOperations.createNewRegion(parentState);
				}
			});
		}
	}

	public static void creatTransition(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		diagramEditPart = parentDiagramEditPart;

		List<EObject> states = findSelectedState(viewer, parentDiagramEditPart);

		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (states != null && states.size() == 2) {
					if (states.get(0) instanceof State && states.get(1) instanceof State) {
						State src = (State) states.get(0);
						State dst = (State) states.get(1);

						ModelOperations.createTransition(src, dst);
					}
				}
			}
		});

	}

	private static List<EObject> findSelectedState(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		List<EObject> selectedContainers = new ArrayList<EObject>();

		if (viewer.getSelectedEditParts() == null) {
			return selectedContainers;
		} else if (viewer.getSelectedEditParts() != null) {
			if (viewer.getSelectedEditParts().size() == 0) {
				return selectedContainers;
			} else if (viewer.getSelectedEditParts().size() > 0) {

				for (Object c : viewer.getSelectedEditParts()) {
					// an state or a region is selected
					if (c != null && c instanceof DNodeContainer2EditPart) {
						EObject f = findAssociatedState((DNodeContainer2EditPart) c);
						if (f != null) {
							if (!selectedContainers.contains(f))
								selectedContainers.add(f);
						}
					}
				}
			}
		}

		return selectedContainers;
	}

	public static void editTransition(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		diagramEditPart = parentDiagramEditPart;

		Transition trans = findSelectedTransition(viewer, parentDiagramEditPart);

		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (trans != null)
					// CreateEmbeddedEditors.runFormViewTransitionEditor(diagramEditPart,
					// ModelUtils.getInjector(), trans);
					JS_TransitionLabelServices.ShowSetTransitionDialog(trans);
			}
		});
	}

	public static void handleCtrlKeyPressInFeatureModule(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		Transition trans = findSelectedTransition(viewer, parentDiagramEditPart);

		if (trans != null) {
			openTrigerringEventAssistant(viewer, parentDiagramEditPart, trans);
		} else {
			List<EObject> states = findSelectedState(viewer, parentDiagramEditPart);
			if (states.size() == 1) {
				EObject selectedState = states.get(0);
				if (selectedState instanceof State) {
					FeatureModule refFeatureModule = ModelUtils2.getFragmentFeatureModule((State) selectedState);
					if (refFeatureModule != null) {
						viewFragmentedFeatureModule(refFeatureModule);
					}

				}
			}
		}

	}

	private static void viewFragmentedFeatureModule(FeatureModule refFeatureModule) {

		try {
			if (refFeatureModule == null)
				return;

			FrmFPC_FragmentState fmc = new FrmFPC_FragmentState(Display.getDefault(), refFeatureModule);
			fmc.open();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private static void openTrigerringEventAssistant(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart,
			Transition trans) {

		diagramEditPart = parentDiagramEditPart;

		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (trans != null)
					JS_TransitionLabelServices.ShowTriggeringEventOperations(trans);
			}
		});

	}

	public static void openWCAActionAssistant(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		diagramEditPart = parentDiagramEditPart;

		Transition trans = findSelectedTransition(viewer, parentDiagramEditPart);

		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (trans != null)
					JS_TransitionLabelServices.ShowWCAActionOperations(trans);
			}
		});

	}
}
