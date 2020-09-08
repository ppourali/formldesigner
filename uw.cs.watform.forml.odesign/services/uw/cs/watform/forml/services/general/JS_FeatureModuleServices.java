package uw.cs.watform.forml.services.general;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.GUI.FrmCustomFeatureSelectionWizard;
import uw.cs.watform.forml.services.GUI.FrmShellForTransitionSelectInDragNDrop;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

/**
 * All the services related to FeatureModules.
 * 
 * 
 * @author ppourali
 */
public final class JS_FeatureModuleServices {

	public JS_FeatureModuleServices() {

	}
	//
	// public static void viewService(EObject t) {
	// try {
	// MyView view = (MyView)
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
	// .showView("com.uwaterloo.cs.forml.odesign.MyView");
	//
	// view.in(((DNodeContainerSpec)t).getTarget());
	// view.createPartControl(view.parentPart);
	//
	//
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	/*
	 * Gets the triggering event of a transition.
	 */
	public static List<Input> getTransitionTriggeringReferrer(EObject t) {
		try {

			Transition trans = ((Transition) t);

			return ModelUtils.getWorldModelObjectsByType(trans, Input.class);

			// return trans.getTrig().getWce().getAddobj();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Swaps transition's source and destination roles.
	 */
	public static void swapTransitionRoles(EObject t) {
		try {

			Transition trans = ((Transition) t);

			State src = trans.getSrc();
			State dst = trans.getDst();

			State temp = src;
			src = dst;
			dst = temp;

			trans.setSrc(src);
			trans.setDst(dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * creates inital state.
	 */
	public static void createInitState(EObject any) {
		Region parentRegion = ModelUtils.getTypedRootForObject(any, Region.class);

		if (parentRegion != null) {
			ModelOperations2.createNewInitialStateWithRefState(parentRegion);

		}
	}

	/*
	 * creates new state state.
	 */
	public static void createNewState(EObject any) {

		ModelOperations2.CreateNewStateOnAnyObject(any);

	}

	/*
	 * creates a new region.
	 */
	public static void createNewRegion(EObject any) {
		EObject parentState = ModelUtils.getTypedRootForObject(any, State.class);
		if (parentState != null) {
			ModelOperations.createNewRegion(parentState);
		} else {
			parentState = ModelUtils.getTypedRootForObject(any, StateMachine.class);
			if (parentState != null) {
				ModelOperations.createNewRegion(parentState);
			}
		}
	}

	/*
	 * Sets refState for an initial state.
	 */
	public static void setRefStateForInitState(EObject parentRegion, State refState) {
		((Region) parentRegion).getInit().setStateref(refState);
	}

	/*
	 * Create a new unique name for a state and sets it when a state is created.
	 */
	public static void populateStateName(EObject t) {
		ModelOperations.setUniqueStateName((State) t);
	}

	/*
	 * Finds Fragment Feature module corresponding to a state and navigates to its
	 * diagram.
	 */
	public static FeatureModule findFragmentFMtoNavigateFromState(EObject t) {
		try {

			t = t.eCrossReferences().get(0);
			BehaviourModel bm = ModelUtils.getSystem(t).getBehaviourmodel();

			for (StateContext sc : EcoreUtil2.getAllContentsOfType(bm, StateContext.class)) {
				if (sc.getRef().equals(t)) {
					return (FeatureModule) EcoreUtil2.getContainerOfType(sc, FeatureModule.class);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Shows a wizard to select a feature among, in order to create new fragment for
	 * it.
	 */
	public static Feature selectFeatureWizard(EObject t) {
		try {

			WorldModel wm = ModelUtils.getWorldModel(t.eCrossReferences().get(0));
			FrmCustomFeatureSelectionWizard featureSelection = new FrmCustomFeatureSelectionWizard(wm);
			featureSelection.setModal(true);
			featureSelection.setAlwaysOnTop(true);
			featureSelection.setVisible(true);
			if (featureSelection.ConfirmFlag) {
				if (featureSelection.createFlag) {
					if (ModelOperations.addNewFeatureToWorldModel(wm, featureSelection.selectedFeature, null))
						return featureSelection.selectedFeature;
					else
						return null;
				} else {
					return featureSelection.selectedFeature;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static FeatureModule createFeatureModule(EObject t) {

		Roleable featureref = null;
		if (t instanceof FeatureNode) {
			featureref = ((FeatureNode) t).getFeature();
		} else if (t instanceof Feature) {
			featureref = (Feature) t;
		} else if (t instanceof Entity) {
			featureref = (Entity) t;
		}
		if (featureref != null) {

			FeatureModule newFM = ModelUtils.getFeatureModuleForFeature(featureref);
			if (newFM == null)
				newFM = ModelOperations.createNewFeatureModel(featureref);

			return newFM;
		}

		return null;
	}

	public static FeatureModule createFeatureModuleWithBaseStructure(EObject t, Object SelectedFeatureModule) {

		if (SelectedFeatureModule instanceof DSemanticDiagram) {
			DSemanticDiagram baseFMRepresentation = ((DSemanticDiagram) SelectedFeatureModule);
			if (baseFMRepresentation.getTarget() instanceof FeatureModule) {
				FeatureModule baseFM = (FeatureModule) baseFMRepresentation.getTarget();
				FeatureModule newFM = createFeatureModule(t);
				if (newFM != null) {
					ModelOperations.CopyFMStructure(baseFM, newFM);
					return newFM;
				}
			}
		}
		return null;
	}

	public static boolean isFeatureModule(EObject t) {
		if (t instanceof FeatureModule) {
			if (!((FeatureModule) t).getStatemachine().isEmpty() && ((FeatureModule) t).getFragments().isEmpty())
				return true;
		}
		return false;
	}

	public static boolean isFragmentModule(EObject t) {
		if (t instanceof FeatureModule) {
			if (((FeatureModule) t).getStatemachine().isEmpty() && !((FeatureModule) t).getFragments().isEmpty())
				return true;
		}
		return false;
	}

	public static void DropFeatureObjectsToState(EObject t, EObject element) {
		State srcState = (State) t;

		List<Transition> transitions = ModelUtils2.getOutgoingTransitionsFromState(srcState);

		if (transitions.size() == 0)
			return;
		else if (transitions.size() == 1) {
			setTransition(transitions.get(0), element);
		} else if (transitions.size() > 1) {

			final Display display = Display.getDefault();
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					try {
						FrmShellForTransitionSelectInDragNDrop frmSelectTransition = new FrmShellForTransitionSelectInDragNDrop(
								display, transitions);
						frmSelectTransition.open();

						if (frmSelectTransition.ConfirmFlag && frmSelectTransition.transitionToReturn != null)
							setTransition(frmSelectTransition.transitionToReturn, element);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

	private static void setTransition(Transition refTrans, EObject element) {
		if (refTrans != null) {
			if (element instanceof Attribute) {
				ModelOperations2.setTransitionTrigger(refTrans, (Attribute) element, true);
			} else if (element instanceof RefMessage) {
				if (((RefMessage) element).getRefMsg() instanceof Input) {
					ModelOperations2.setTransitionTrigger(refTrans, ((RefMessage) element).getRefMsg(), true);
				} else if (((RefMessage) element).getRefMsg() instanceof Output) {
					ModelOperations2.setoraddTransitionAction(refTrans, "", ((RefMessage) element).getRefMsg(), true,
							false);
				}

			}
		}
	}
}
