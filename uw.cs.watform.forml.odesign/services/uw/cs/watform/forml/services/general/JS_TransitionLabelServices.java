package uw.cs.watform.forml.services.general;

import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.FrmShellForSetGuardDialog;
import uw.cs.watform.forml.services.GUI.FrmShellForTriggerOperationsView;
import uw.cs.watform.forml.services.GUI.FrmShellForWCAActionView;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;
import uw.cs.watform.forml.services.internal.MessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.services.utilities.SimilarityCalculation;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;

/**
 * All the services related to Transition Labels.
 * 
 * 
 * @author ppourali
 */
public final class JS_TransitionLabelServices {

	private static String tid, event, guard, aid, condition, action;

	public static void populateTransitionName(EObject t) {

		ModelOperations.setUniqueTransitionName((Transition) t);
	}

	public void openTransitionEditorShell(EObject t) {
		// java.lang.System.out.println(t);
		// if(CreateEmbeddedEditors.isOpen==false)
		// CreateEmbeddedEditors.runImmidiateTransitionEditor(getInjector(), t);
	}

	public static String getTid() {
		return tid;
	}

	public static void setTid(String tid) {
		JS_TransitionLabelServices.tid = tid;
	}

	public static String getEvent() {
		return event;
	}

	public static void setEvent(String event) {
		JS_TransitionLabelServices.event = event;
	}

	public static String getGuard() {
		return guard;
	}

	public static void setGuard(String guard) {
		JS_TransitionLabelServices.guard = guard;
	}

	public static String getAid() {
		return aid;
	}

	public static void setAid(String aid) {
		JS_TransitionLabelServices.aid = aid;
	}

	public static String getCondition() {
		return condition;
	}

	public static void setCondition(String condition) {
		JS_TransitionLabelServices.condition = condition;
	}

	public static String getAction() {
		return action;
	}

	public static void setAction(String action) {
		JS_TransitionLabelServices.action = action;
	}

	protected static IEditorPart getActiveEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		return page.getActiveEditor();
	}

	public static void CreateNewTransition(EObject t, EObject source, EObject target) {

		// StateMachine stateMachine = ModelUtils.getTypedRootForObject(t,
		// StateMachine.class);

		State sourceState;
		if (source instanceof Region)
			sourceState = (State) source.eContainer();
		else
			sourceState = (State) source;

		State targetState;
		if (target instanceof Region) {
			if (target.eContainer() instanceof StateMachine || target.eContainer() instanceof StateContext) {
				if (target.equals(sourceState.eContainer())) {
					targetState = ModelOperations.CreateNewState((Region) target);
				} else
					return;
			} else {
				if (target.equals(sourceState.eContainer())) {

					// Create New State
					targetState = ModelOperations.CreateNewState((Region) target);
				} else {
					targetState = (State) target.eContainer();
				}
			}
		} else
			targetState = (State) target;

		Transition trans = ModelOperations.createTransition(sourceState, targetState);

		get_TransitionLabel(trans);

		// AutoSetTriggeringEvent(trans, targetState);

	}

	private static void AutoSetTriggeringEvent(Transition trans, State targetState) {
		List<List<ExprRef>> suggestableItems = ModelUtils2.getListOfPossibleItemsForTrigerringEvent(trans);

		double max = 0;
		Message r = null;
		for (List<ExprRef> i : suggestableItems)
			if (i.get(1) instanceof Message) {
				// java.lang.System.out.println(((Message) i.get(1)).getName());
				SimilarityCalculation sc = new SimilarityCalculation();
				double dis = sc.printDistance(((Message) i.get(1)).getName(), targetState.getName());
				if (dis > 0.7) {
					if (dis > max) {
						max = dis;
						r = (Message) i.get(1);
					}
				}
			}

		if (r != null) {
			int dialogResult = MessageDialogs.ConfirmAutoSetTrigEvent(r.getName());
			if (dialogResult == JOptionPane.YES_OPTION) {
				ModelOperations2.setTransitionTrigger(trans, r, true);
			}
		}
	}

	public static void get_TransitionLabel(EObject t) {
		populateTransitionName(t);

		// DiagramEditPart diagramEditPart = ((DiagramEditor) getActiveEditor())
		// .getDiagramEditPart();

		// LabelViewXtextEmbeddedEditorForTransition embeddedEditor = new
		// LabelViewXtextEmbeddedEditorForTransition(diagramEditPart,
		// ModelUtils.getInjector());
		// embeddedEditor.showEditor(t, diagramEditPart, true);

	}
	/*
	 * private static WCE parseWCE(EObject t, Feature fm) {
	 * 
	 * String eventText = getEvent(); if (eventText.contains("~")) { String attname
	 * = eventText.substring(0, eventText.indexOf("~"));
	 * 
	 * String[] LowerUpper = attname.split("\\.");
	 * 
	 * for (int i = 0; i < LowerUpper.length; i++) LowerUpper[i] =
	 * LowerUpper[i].trim();
	 * 
	 * if (LowerUpper.length == 0) return null;
	 * 
	 * else if (LowerUpper.length == 1) { for (ExprRef att : fm.getAttributes()) {
	 * if (((Attribute) att).getName().equals(LowerUpper[0])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setAttr((Attribute) att);
	 * return wce_value; } } } else if (LowerUpper.length == 2) { for (ExprRef f :
	 * ModelUtils.getWorldModel(t).getConcepts()) { if (f instanceof FeatureImpl) {
	 * if (((Feature) f).getName().equals(LowerUpper[0])) { for (ExprRef att :
	 * ((Feature) f).getAttributes()) { if (((Attribute)
	 * att).getName().equals(LowerUpper[1])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setAttr((Attribute) att);
	 * return wce_value; }
	 * 
	 * } } } else if (f instanceof EntityImpl) { if (((Entity)
	 * f).getName().equals(LowerUpper[0])) { for (ExprRef att : ((Entity)
	 * f).getAttributes()) { if (((Attribute) att).getName().equals(LowerUpper[1]))
	 * { WCE wce_value = FormlFactory.eINSTANCE.createWCE();
	 * wce_value.setAttr((Attribute) att); return wce_value; } } } } }
	 * 
	 * }
	 * 
	 * } else if (eventText.contains("+")) { String msgname = eventText.substring(0,
	 * eventText.indexOf("+")); String[] LowerUpper = msgname.split("\\.");
	 * 
	 * for (int i = 0; i < LowerUpper.length; i++) LowerUpper[i] =
	 * LowerUpper[i].trim();
	 * 
	 * if (LowerUpper.length == 0) return null;
	 * 
	 * else if (LowerUpper.length == 1) { for (RefMessage refmsg :
	 * fm.getInputlist().getInputs()) { Message msg = refmsg.getRefMsg();
	 * 
	 * if (msg.getName().equals(LowerUpper[0])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setAddobj(msg); return
	 * wce_value; } } } else if (LowerUpper.length == 2) { for (ExprRef f :
	 * ModelUtils.getWorldModel(t).getConcepts()) { if (f instanceof FeatureImpl) {
	 * if (((Feature) f).getName().equals(LowerUpper[0])) { for (RefMessage refmsg :
	 * ((Feature) f).getInputlist().getInputs()) { Message msg = refmsg.getRefMsg();
	 * 
	 * if (msg.getName().equals(LowerUpper[1])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setAddobj(msg); return
	 * wce_value; } } } } } } } else if (eventText.contains("-")) { String msgname =
	 * eventText.substring(0, eventText.indexOf("-")); String[] LowerUpper =
	 * msgname.split("\\.");
	 * 
	 * for (int i = 0; i < LowerUpper.length; i++) LowerUpper[i] =
	 * LowerUpper[i].trim();
	 * 
	 * if (LowerUpper.length == 0) return null;
	 * 
	 * else if (LowerUpper.length == 1) { for (RefMessage refmsg :
	 * fm.getInputlist().getInputs()) { Message msg = refmsg.getRefMsg(); if
	 * (msg.getName().equals(LowerUpper[0])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setRemobj(msg); return
	 * wce_value; } } } else if (LowerUpper.length == 2) { for (ExprRef f :
	 * ModelUtils.getWorldModel(t).getConcepts()) { if (f instanceof FeatureImpl) {
	 * if (((Feature) f).getName().equals(LowerUpper[0])) { for (RefMessage refmsg :
	 * ((Feature) f).getInputlist().getInputs()) { Message msg = refmsg.getRefMsg();
	 * 
	 * if (msg.getName().equals(LowerUpper[1])) { WCE wce_value =
	 * FormlFactory.eINSTANCE.createWCE(); wce_value.setRemobj(msg); return
	 * wce_value; } } } } } } }
	 * 
	 * return null; }
	 */

	// public static String populateTransitionLabel(EObject t) {
	//
	// Transition transition = ((Transition) t);
	//
	// String lineSeparator = java.lang.System.lineSeparator();
	//
	// String returnLabel = "";
	//
	// returnLabel += transition.getName();
	// if (transition.getPriority() != null) {
	// if (transition.getPriority().getTranslist() != null) {
	// returnLabel += ">";
	// for (Transition p :
	// transition.getPriority().getTranslist().getTransitions()) {
	// returnLabel += p.getName();
	// returnLabel += ",";
	// }
	// returnLabel = returnLabel.substring(0, returnLabel.length() - 1);
	// }
	// }
	//
	// if (transition.getTrig() != null) {
	// returnLabel += ": " +
	// ModelUtils.getTextForModelObjects(transition.getTrig()).trim()
	// .replace(lineSeparator, " ").replace(" ", " ");
	// }
	//
	// if (transition.getGuard() != null) {
	// String guardText =
	// ModelUtils.getTextForModelObjects(transition.getGuard()).trim()
	// .replace(lineSeparator, " ").replace(" ", " ");
	// if (guardText.length() > 20)
	// returnLabel += " [...] ";
	// else if (!guardText.trim().replace(" ", "").equalsIgnoreCase("[]"))
	// returnLabel += " " + guardText.trim();
	// }
	//
	// if (transition.getList() != null) {
	// if (transition.getList().getActions() != null &&
	// transition.getList().getActions().size() > 0) {
	// returnLabel += "/...";
	// }
	//
	// }
	//
	// return returnLabel.replace(lineSeparator, "").replace("\n",
	// "").replace("\r", "").replace(" ", " ");
	//
	// }

	public static String populateTransitionLabel(EObject t) {

		Transition transition = ((Transition) t);

		String lineSeparator = java.lang.System.lineSeparator();

		String returnLabel = "";

		// this is to make sure that the transition label will have ':' after the
		// transition name always
		boolean allReadyGotcColon = false;

		returnLabel += transition.getName();
		if (transition.getPriority() != null) {
			if (transition.getPriority().getTranslist() != null) {
				returnLabel += ">";
				for (Transition p : transition.getPriority().getTranslist().getTransitions()) {
					returnLabel += p.getName();
					returnLabel += ",";
				}
				returnLabel = returnLabel.substring(0, returnLabel.length() - 1);
			}
		}

		if (transition.getTrig() != null) {
			returnLabel += ": " + getEventText(transition);

			allReadyGotcColon = true;
		}

		if (transition.getGuard() != null && transition.getGuard().getPredicate() != null) {

			String guardText = getGuardText(transition);

			if (allReadyGotcColon == false) {
				returnLabel += ": " + guardText.trim();
				allReadyGotcColon = true;

			} else {
				returnLabel += " " + guardText.trim();
			}
		}

		if (transition.getList() != null) {
			if (transition.getList().getActions() != null && transition.getList().getActions().size() > 0) {
				String actionText = getActionText(transition);

				if (allReadyGotcColon == false) {
					returnLabel += ": " + actionText.trim();
					allReadyGotcColon = true;
				} else {
					returnLabel += " " + actionText.trim();
				}
			}
		}

		return returnLabel.replace(lineSeparator, "").replace("\n", "").replace("\r", "").replace("\t", "")
				.replace("  ", " ");

	}

	public static String getEventText(Transition transition) {
		String lineSeparator = java.lang.System.lineSeparator();

		if (transition.getTrig() != null) {
			return ModelUtils.getTextForModelObjects(transition.getTrig()).replace("event:", "").trim()
					.replace(lineSeparator, " ").replace("  ", " ").replace("\t", "");
		}

		return "";
	}

	public static String getGuardText(Transition transition) {
		String lineSeparator = java.lang.System.lineSeparator();

		if (transition.getGuard() != null && transition.getGuard().getPredicate() != null) {
			return ModelUtils.getTextForModelObjects(transition.getGuard()).trim().replace(lineSeparator, " ")
					.replace("  ", " ").replace("\t", "");
		}

		return "";
	}

	public static String getActionText(Transition transition) {
		String lineSeparator = java.lang.System.lineSeparator();

		if (transition.getList() != null) {
			if (transition.getList().getActions() != null && transition.getList().getActions().size() > 0) {
				return ModelUtils.getTextForModelObjects(transition.getList()).trim().replace(lineSeparator, " ")
						.replace("  ", " ").replace("\t", "");
			}
		}

		return "";
	}

	public static void ShowTriggeringEventOperations(EObject t) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					List<List<ExprRef>> suggestableItems = ModelUtils2.getListOfPossibleItemsForTrigerringEvent(t);

					DEdgeEditPart ep = RepresentationsUtils.findEditPart(t);

					Roleable parentFeature = ModelUtils2.getTypedRootForObject(t, FeatureModule.class).getFeatureref();
					if (!(parentFeature instanceof Feature))
						return;

					FrmShellForTriggerOperationsView trigerringOperationsContentAssist = new FrmShellForTriggerOperationsView(
							display, (Feature) parentFeature, suggestableItems, ep);

					trigerringOperationsContentAssist.open();

					if (trigerringOperationsContentAssist.ConfirmFlag
							&& trigerringOperationsContentAssist.returenItem != null) {
						if (trigerringOperationsContentAssist.plusFalg == true
								&& trigerringOperationsContentAssist.minusFalg == false) {
							ModelOperations2.setTransitionTrigger((Transition) t,
									trigerringOperationsContentAssist.returenItem, true);
						} else if (trigerringOperationsContentAssist.plusFalg == false
								&& trigerringOperationsContentAssist.minusFalg == true) {
							ModelOperations2.setTransitionTrigger((Transition) t,
									trigerringOperationsContentAssist.returenItem, false);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ShowSetGuardDialog(EObject t) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					Transition trans;
					if (t instanceof Transition)
						trans = (Transition) t;
					else
						return;

					DEdgeEditPart ep = RepresentationsUtils.findEditPart(trans);

					FrmShellForSetGuardDialog trigerringOperationsContentAssist = new FrmShellForSetGuardDialog(display,
							trans, ep);

					trigerringOperationsContentAssist.open();

					if (trigerringOperationsContentAssist.ConfirmFlag
							|| trigerringOperationsContentAssist.guard_embeddedEditor.confirmFlag) {
						if (trigerringOperationsContentAssist.guard_embeddedEditor.changedElement != null) {
							trans.setGuard(
									(Guard) trigerringOperationsContentAssist.guard_embeddedEditor.changedElement);
						} else if (trigerringOperationsContentAssist.guard_embeddedEditor.isChanged) {
							EcoreUtil.delete(trans.getGuard());
						}
						if (trans.getGuard() != null && trans.getGuard().getPredicate() == null) {
							EcoreUtil.delete(trans.getGuard());
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ShowSetTransitionDialog(EObject t) {
		try {
			Transition trans;
			if (t instanceof Transition) {
				trans = (Transition) t;
			} else if (t instanceof DEdgeSpec) {
				EObject targetEObject = ((DEdgeSpec) t).getTarget();
				if (targetEObject instanceof Transition)
					trans = (Transition) targetEObject;
				else
					return;
			} else
				return;

//		final Copier copier = new Copier();
//		Resource originalResource = trans.eResource();
//		final Collection<EObject> copiedContents = copier.copyAll(originalResource.getContents());
//		copier.copyReferences();
//
//		String transFrag = trans.eResource().getURIFragment(trans);
//		final XMIResourceImpl newXMIResource = new XMIResourceImpl();
//		newXMIResource.getContents().addAll(copiedContents);
//		EObject copiedtrans = newXMIResource.getEObject(transFrag);

			// if there is no other transition editor open
			if (CommonSpaceForContextualUI.getShell() == null) {
				CustomVirtualResource vres = ModelUtils2.createVirtualOriginalResource(trans);

				CommonSpaceForContextualUI.setCurrentTransition(trans);
				CommonSpaceForContextualUI.setCurrentFeatureOrEntityClass(ModelUtils2
						.getTypedRootForObject(CommonSpaceForContextualUI.getCurrentTransition(), FeatureModule.class)
						.getFeatureref());

				FrmShellForSetGuardGraphicallyDialog trigerringOperationsContentAssist = new FrmShellForSetGuardGraphicallyDialog(
						Display.getDefault());

				trigerringOperationsContentAssist.open();

				if (CommonSpaceForContextualUI.confirmFlag == false) {
					vres.revertBack();
				}

				CommonSpaceForContextualUI.setShell(null);
			} else {
				CommonSpaceForContextualUI.getShell().getShell().setActive();
			}

//		final Copier copierback = new Copier();
//
//		final Collection<EObject> copiedContentsBack = copierback.copyAll(copiedContents);
//		copierback.copyReferences();
//		originalResource.getContents().set(0, newXMIResource.getContents().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	

	public static void ShowWCAActionOperations(EObject t) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					List<List<ExprRef>> suggestableItems = ModelUtils2.getListOfPossibleItemsForWCAAction(t);

					DEdgeEditPart ep = RepresentationsUtils.findEditPart(t);

					Roleable parentFeature = ModelUtils2.getTypedRootForObject(t, FeatureModule.class).getFeatureref();
					if (!(parentFeature instanceof Feature))
						return;

					FrmShellForWCAActionView trigerringOperationsContentAssist = new FrmShellForWCAActionView(display,
							(Feature) parentFeature, suggestableItems, ep);

					trigerringOperationsContentAssist.open();

					if (trigerringOperationsContentAssist.ConfirmFlag
							&& trigerringOperationsContentAssist.returenItem != null) {
						if (trigerringOperationsContentAssist.plusFalg == true
								&& trigerringOperationsContentAssist.minusFalg == false) {
							ModelOperations2.setoraddTransitionAction((Transition) t, "",
									trigerringOperationsContentAssist.returenItem, true, false);
						} else if (trigerringOperationsContentAssist.plusFalg == false
								&& trigerringOperationsContentAssist.minusFalg == true) {
							ModelOperations2.setoraddTransitionAction((Transition) t, "",
									trigerringOperationsContentAssist.returenItem, false, false);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
