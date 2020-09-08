package uw.cs.watform.forml.services.general;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.widgets.Display;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.GUI.FrmCustomFeatureNodeSelectionWizard;
import uw.cs.watform.forml.services.GUI.FrmCustomFeatureSelectionWizardForBaseStateMachine;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.FrmShellForCrossReferenceView_TreeStyle;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.FrmShellForTypedGuardCrossReferenceView_TreeStyle;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.rename.ServiceClass;
import uw.cs.watform.forml.services.utilities.ModelDeleteOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;

/**
 * All the services related to Feature/Entities Class Diagram.
 * 
 * 
 * @author ppourali
 */
public final class JS_FeatureClassServices extends ServiceClass {

	public JS_FeatureClassServices() {

	}

	public static Roleable GetRoleable(EObject t) {
		return ModelUtils2.GetRoleable(t);
	}

	public static void CreateFeatureClass(EObject t) {

		try {
			SPL spl_param = ModelUtils.getSPLRoot(t);
			FrmCustomFeatureNodeSelectionWizard featureSelection = new FrmCustomFeatureNodeSelectionWizard(spl_param);
			featureSelection.setModal(true);
			featureSelection.setAlwaysOnTop(true);
			featureSelection.setVisible(true);
			if (featureSelection.ConfirmFlag) {
				ModelOperations2.CreateNewFeature(featureSelection.selectedFeature);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Service to delete elements from features class diagram.
	 */
	public static void deleteReferencedElements(EObject any) {
		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(any);

		if (referrers.size() == 0) {
			ModelDeleteOperations.deleteElement(any);
		} else {
			DeleteElementWithReferenceBox(any, referrers);

			// }
			// else if(deletingElement instanceof Function) {
			// Entity parentEntity=ModelUtils.getTypedRootForObject(deletingElement,
			// Entity.class);
			// DeleteFunctionWithReferenceBox(parentEntity, ((Function)deletingElement),
			// referrers);
			// }
			// else if(deletingElement instanceof Attribute) {
			// Entity parentEntity=ModelUtils.getTypedRootForObject(deletingElement,
			// Entity.class);
			// DeleteFunctionWithReferenceBox(parentEntity, ((Function)deletingElement),
			// referrers);
			// }

		}
	}

	/**
	 * if a function has cross references in feature modules, it will show a dialog
	 * to manages the changes and references
	 * 
	 * @param Entity
	 * @param Function
	 * @param crossRefs
	 */
	public static void DeleteElementWithReferenceBox(EObject element, Collection<Setting> crossRefs) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					CustomVirtualResource vres = createVirtualOriginalResource(element);
					FrmShellForCrossReferenceView_TreeStyle interactiveConsistencyUI = new FrmShellForCrossReferenceView_TreeStyle(
							display, crossRefs, element);

					interactiveConsistencyUI.open();

					if (interactiveConsistencyUI.ConfirmFlag == true) {
						ModelDeleteOperations.deleteElement(element);
					}
					// ModelDeleteOperations.removeMessageFromFeature((Feature) F, (RefMessage)
					// refMsg);
					else if (interactiveConsistencyUI.ConfirmFlag == false) {
						vres.revertBack();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static CustomVirtualResource createVirtualOriginalResource(EObject element) {
		return new CustomVirtualResource(element);

	}

	/*
	 * Populates name label for Features.
	 */
	public static void populateFeatureName(EObject t) {
		int autoincrementForName = ModelUtils.getWorldModelObjectsByType(t, Feature.class).size();

		String newName = "F" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((Feature) t, newName, false)) {
			autoincrementForName++;
			newName = "F" + String.valueOf(autoincrementForName);
		}
		((Feature) t).setName(newName);

	}

	/*
	 * Populates name label for Entities.
	 */
	public static void populateEntityName(EObject t) {
		int autoincrementForName = ModelUtils.getWorldModelObjectsByType(t, Entity.class).size();

		String newName = "Entity" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((Entity) t, newName, false)) {
			autoincrementForName++;
			newName = "Entity" + String.valueOf(autoincrementForName);
		}
		((Entity) t).setName(newName);
	}

	/*
	 * Populates name label for Enumerations.
	 */
	public static void populateEnumName(EObject t) {
		int autoincrementForName = ModelUtils.getWorldModelObjectsByType(t, Enumeration.class).size();

		String newName = "Enum" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((Enumeration) t, newName, false)) {
			autoincrementForName++;
			newName = "Enum" + String.valueOf(autoincrementForName);
		}
		((Enumeration) t).setName(newName);
	}

	/*
	 * Find the corresponding Feature Module of a feature and navigates to its
	 * diagram.
	 */
	public static FeatureModule findFMtoNavigateFromFeatureClass(EObject t) {
		try {

			for (FeatureModule fm : ModelUtils.getSystem(t).getBehaviourmodel().getFeaturemodules()) {
				if (t instanceof Feature) {
					if (fm.getFeatureref().equals(((Feature) t)))
						return fm;
				} else if (t instanceof Entity) {
					if (fm.getFeatureref().equals(((Entity) t)))
						return fm;
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * Populates label for Attributes.
	 */
	public static String PopulateFunctionLabel(EObject t) {
		try {
			Function a = (Function) t;
			String returnLabel = "";

			returnLabel = a.getName();

			if (a.getType() != null) {

//				if (a.getType().getClass().equals(IntTypeImpl.class))
//					returnLabel += ":int";
//				else if (a.getType().getClass().equals(BoolTypeImpl.class))
//					returnLabel += ":bool";
//				else if (a.getType().getClass().equals(ReferenceTypeImpl.class))
//					returnLabel += ":" + ((ReferenceType) a.getType()).getRef().getName() + "";

				returnLabel += ":" + ModelUtils2.convertAttributeTypeToString(a.getType()) + "";
			}

			return returnLabel.trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Function Name";
		}
	}

	/*
	 * Populates label for Functions.
	 */
	public static String PopulateAttributeLabel(EObject t) {
		try {
			Attribute a = (Attribute) t;
			String returnLabel = "";

			if (a.isCtrl())
				returnLabel += "<<ctrl>>";

			returnLabel += " " + a.getName();

			if (a.getType() != null) {
				returnLabel += ":" + ModelUtils2.convertAttributeTypeToString(a.getType());
			}

			// if (a.getType() != null) {
			//
			// if (a.getType().getClass().equals(IntTypeImpl.class))
			// returnLabel += ":int";
			// else if (a.getType().getClass().equals(BoolTypeImpl.class))
			// returnLabel += ":bool";
			// else if (a.getType().getClass().equals(ReferenceTypeImpl.class))
			// returnLabel += ":" + ((ReferenceType)
			// a.getType()).getRef().getName() + "";
			// }

			if (a.getMultiplicity() != null) {
				if (a.getMultiplicity().getCardinality() != null) {
					if (a.getMultiplicity().getCardinality().getMany() != null
							&& a.getMultiplicity().getCardinality().getMany().trim() != "")
						returnLabel += " [" + a.getMultiplicity().getCardinality().getLower() + ".."
								+ a.getMultiplicity().getCardinality().getMany() + "]";
					else
						returnLabel += " [" + a.getMultiplicity().getCardinality().getLower() + ".."
								+ a.getMultiplicity().getCardinality().getUpper() + "]";
				} else {
					if (a.getMultiplicity().getMany() != null && a.getMultiplicity().getMany().trim() != "") {
						returnLabel += " [" + "*" + "]";
					} else {
						returnLabel += " [" + a.getMultiplicity().getValue() + "]";
					}
				}

			}

			return returnLabel.trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Attribute Name";
		}
	}

	/*
	 * Service to direct edit attributes.
	 */
	public static void EditTypeableLabels(EObject t, String newLabel) {
		CustomVirtualResource vres = createVirtualOriginalResource(t);

		if (t instanceof Attribute)
			EditAttributeLabel(t, newLabel, vres);
		else if (t instanceof Function)
			EditFunctionLabel(t, newLabel, vres);
		else if (t instanceof RefMessage)
			JS_MessageServices.EditFeatureMessageLabel(t, newLabel, vres);
	}

	/*
	 * Service to direct edit attributes.
	 */
	public static void EditAttributeLabel(EObject t, String newLabel, CustomVirtualResource vres) {

		HashMap<EObject, String> map_GuardToText = ModelUtils2.getGuardUsageText(t);

		Attribute oldAttribute = ((Attribute) t);

		Attribute tempNewAttribute = CreateAttributeByText(oldAttribute, newLabel);

		oldAttribute.setCtrl(tempNewAttribute.isCtrl());
		oldAttribute.setName(tempNewAttribute.getName());
		oldAttribute.setType(tempNewAttribute.getType());
		oldAttribute.setMultiplicity(tempNewAttribute.getMultiplicity());

		boolean isSound = ModelUtils2.checkGuardsForSoundNess(t, vres, map_GuardToText);
		if (isSound)
			ShowRenameConfirmation();
	}

	/*
	 * Service to direct edit attributes.
	 */
	public static void EditFunctionLabel(EObject t, String newLabel, CustomVirtualResource vres) {

		HashMap<EObject, String> map_GuardToText = ModelUtils2.getGuardUsageText(t);

		Function oldFunction = ((Function) t);

		Function tempNewFunction = CreateFunctionByText(oldFunction, newLabel);

		oldFunction.setName(tempNewFunction.getName());
		oldFunction.setType(tempNewFunction.getType());

		boolean isSound = ModelUtils2.checkGuardsForSoundNess(t, vres, map_GuardToText);

		if (isSound)
			ShowRenameConfirmation();
	}

	/**
	 * if an attribute type has cross references in feature modules, it will show a
	 * dialog to manages the type soundness
	 * 
	 * @param F
	 * @param refMsg
	 * @param msg
	 * @param crossRefs
	 * @param map_GuardToText
	 */
	public static void FixGuardSoundnessWithReferenceBox(List<EObject> crossRefs, EObject elem,
			CustomVirtualResource vres, HashMap<EObject, String> map_GuardToText) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					// FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new
					// FrmShellForCrossReferenceView_TreeStyle(
					// display, crossRefs, refMsg.getRefMsg());

					FrmShellForTypedGuardCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForTypedGuardCrossReferenceView_TreeStyle(
							display, crossRefs, elem, map_GuardToText);

					messageDeleteBox.open();

					if (messageDeleteBox.ConfirmFlag == true) {

					} else if (messageDeleteBox.ConfirmFlag == false) {
						vres.revertBack();
					}
				} catch (Exception e) {
					vres.revertBack();
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Creates a new attribute.
	 */
	private static Attribute CreateAttributeByText(Attribute oldAttribute, String newLabel) {

		try {
			Attribute newAttribute = FormlFactory.eINSTANCE.createAttribute();

			newAttribute.setCtrl(WorldModelCommonServices.isCtrl(newLabel));
			newAttribute.setName(WorldModelCommonServices.parseAttributeName(oldAttribute.getName(), newLabel));
			newAttribute.setType(WorldModelCommonServices.parseAttributeType(oldAttribute.getType(), newLabel,
					ModelUtils.getWorldModel(oldAttribute)));
			newAttribute.setMultiplicity(
					WorldModelCommonServices.parseMultiplicity(oldAttribute.getMultiplicity(), newLabel));

			return newAttribute;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Creates a new fucntion.
	 */
	private static Function CreateFunctionByText(Function oldFunction, String newLabel) {

		try {
			Function newfunction = FormlFactory.eINSTANCE.createFunction();

			newfunction.setName(WorldModelCommonServices.parseAttributeName(oldFunction.getName(), newLabel));
			newfunction.setType(WorldModelCommonServices.parseAttributeType(oldFunction.getType(), newLabel,
					ModelUtils.getWorldModel(oldFunction)));

			return newfunction;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Service to create a new function
	 */
	public static void CreateFunction(EObject t) {

		ModelOperations2.CreateFunctionForEntity(t, "");
	}

	/**
	 * Service to create a new attribute
	 */
	public static void CreateAttribute(EObject t) {

		ModelOperations2.CreateNewAttribute(t, "");
	}

	/**
	 * Service to copy/drop attribute
	 */
	public static void CopyAttribute(EObject newParent, EObject t) {

		ModelOperations2.CopyAttributes(newParent, (Attribute) t);
	}

	/**
	 * Service to create a new enum constant
	 */
	public static void createEnumConstant(EObject t) {

		ModelOperations2.CreateEnumerationConstant((Enumeration) t);

	}

	// private static void autoSize(EObject t) {
	// DiagramEditPart diagramEditPart = null;
	// IEditorPart editor =
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	//
	// if (editor instanceof DiagramEditor) {
	// DiagramEditor diagramEditor = (DiagramEditor) editor;
	// diagramEditPart = diagramEditor.getDiagramEditPart();
	// }
	//
	// if (diagramEditPart != null) {
	// ArrayList<EObject> result = new ArrayList<EObject>(
	// new
	// EObjectQuery(t).getInverseReferences(ViewpointPackage.Literals.DSEMANTIC_DECORATOR__TARGET));
	//
	// EditPart editpart = diagramEditPart.findEditPart(diagramEditPart, t);
	//
	// for (Iterator children = diagramEditPart.getChildren().iterator();
	// children.hasNext();) {
	// EditPart child = (EditPart) children.next();
	// if (child.getModel() instanceof Node) {
	// Node node = (Node) child.getModel();
	// if (node.getElement() instanceof DNodeContainerSpec) {
	// DNodeContainerSpec element = (DNodeContainerSpec) node.getElement();
	//
	// if (element.getTarget().equals(t)) {
	// element.setWidth(-1);
	// element.setHeight(-1);
	// if (node.getLayoutConstraint() instanceof Bounds) {
	// ((Bounds) node.getLayoutConstraint()).setWidth(-1);
	// ((Bounds) node.getLayoutConstraint()).setHeight(-1);
	// } else if (node.getLayoutConstraint() == null) {
	//
	// node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
	// ((Bounds) node.getLayoutConstraint()).setWidth(-1);
	// ((Bounds) node.getLayoutConstraint()).setHeight(-1);
	// }
	// }
	//
	// }
	// }
	// }
	//
	// }
	// }

	/**
	 * Service to get input messages of a feature
	 * 
	 * @return
	 */
	public static EList<RefMessage> getInputMessages(EObject t) {

		EList<RefMessage> list = null;
		if (t instanceof Feature) {
			try {
				list = ((Feature) t).getInputlist().getInputs();
			} catch (Exception e) {

			}
		}
		return list;
	}

	public static WCE getAllMessages(EObject t) {
		if (t instanceof Transition) {

			return ((Transition) t).getTrig().getWce();
		}
		return null;
	}

	/**
	 * Service to get output messages of a feature
	 * 
	 * @return
	 */
	public static EList<RefMessage> getOutputMessages(EObject t) {

		EList<RefMessage> list = null;
		if (t instanceof Feature) {
			try {
				list = ((Feature) t).getOutputlist().getOutputs();
			} catch (Exception e) {

			}
		}
		return list;
	}

	/**
	 * Service to get output messages of a feature
	 * 
	 * @return
	 */
	public static EList<ExprRef> getAttributes(EObject t) {

		EList<ExprRef> list = null;
		if (t instanceof Feature) {
			try {
				list = ((Feature) t).getAttributes();
			} catch (Exception e) {

			}
		}
		return list;
	}

	public static boolean canCreateEntityAttribute(EObject t) {

		if (t instanceof Entity || t instanceof Attribute || t instanceof Function || t instanceof Feature
				|| t instanceof RefMessage) {
			return true;
		}
		return false;
	}

	public static boolean canCreateEntityFunction(EObject t) {

		if (t instanceof Entity || t instanceof Attribute || t instanceof Function) {
			return true;
		}
		return false;
	}

	public static boolean canCreateMessage(EObject t) {

		if (t instanceof Attribute) {
			if (t.eContainer() instanceof Feature)
				return true;
		} else if (t instanceof RefMessage || t instanceof Feature) {
			return true;
		}
		return false;
	}

	public static boolean hasAttributes(EObject any) {
		if (any instanceof Roleable) {
			if (((Roleable) any).getAttributes().isEmpty()) {
				return false;

			}
		}
		return true;
	}

	public static boolean hasFunctions(EObject any) {
		if (any instanceof Entity) {
			if (((Entity) any).getFunctions().isEmpty())
				return false;

		}

		return true;
	}

	public static boolean hasInputs(EObject any) {
		if (any instanceof Feature) {
			if (((Feature) any).getInputlist() == null || ((Feature) any).getInputlist().getInputs().isEmpty()) {
				return false;

			}
		}
		return true;
	}

	public static boolean hasOutputs(EObject any) {
		if (any instanceof Feature) {
			if (((Feature) any).getOutputlist() == null || ((Feature) any).getOutputlist().getOutputs().isEmpty()) {
				return false;

			}
		}
		return true;
	}

	public static void CopyMoveAttribute(EObject any, EObject draggedAttribute, EObject oldContainer,
			EObject newContainer) {

		Entity newSemanticContainer = ModelUtils.getTypedRootForObject(newContainer, Entity.class);

		if (draggedAttribute instanceof Attribute && newSemanticContainer != null) {
			Attribute att = (Attribute) draggedAttribute;
			int returnAction = CustomMessageDialog.ShowQuestionDialog(
					"Please select whether the attribute should be copied or moved?", JOptionPane.OK_CANCEL_OPTION,
					new String[] { "Copy", "Move" }, 0);

			Attribute newAtt = ModelOperations2.CopyAttributes(newSemanticContainer, att);
			if (returnAction == 1) {
				ModelUtils2.replaceAttributesInModel(draggedAttribute, newAtt);

				Collection<Setting> referres = ModelUtils2.getReferencesBySemanticType(draggedAttribute);
				if (referres.isEmpty()) {
					EcoreUtil.delete(draggedAttribute, true);
				}
			}
		}
	}

	public static FeatureModule CreateStateMachineBasedOnAnotherStateMachine(EObject classToCreateFeatureModuleView) {

		EObject classToCreateFeatureModule = null;
		if (classToCreateFeatureModuleView instanceof DNodeContainer) {
			classToCreateFeatureModule = ((DNodeContainer) classToCreateFeatureModuleView).getTarget();
		}
		else if (classToCreateFeatureModuleView instanceof Roleable) {
			classToCreateFeatureModule = ((Roleable) classToCreateFeatureModuleView);
		}

		if (classToCreateFeatureModule == null)
			return null;

		DRepresentation selectedFeatureModule = selectFeatureModuleWizard(classToCreateFeatureModule);

		DSemanticDiagram selectedBaseFeatureModule = null;
		if (selectedFeatureModule instanceof DSemanticDiagram)
			selectedBaseFeatureModule = (DSemanticDiagram) selectedFeatureModule;

		if (selectedBaseFeatureModule != null) {
			return JS_FeatureModuleServices.createFeatureModuleWithBaseStructure(classToCreateFeatureModule,
					selectedBaseFeatureModule);
		}

		return null;
	}

	public static DRepresentation selectFeatureModuleWizard(EObject t) {
		try {

			if (!(t instanceof Roleable))
				return null;

			BehaviourModel bm = ModelUtils.getBehaviourModel(t);
			FrmCustomFeatureSelectionWizardForBaseStateMachine featureSelection = new FrmCustomFeatureSelectionWizardForBaseStateMachine(
					bm);
			featureSelection.open();
//			featureSelection.setModal(true);
//			featureSelection.setAlwaysOnTop(true);
//			featureSelection.setVisible(true);
			if (featureSelection.ConfirmFlag) {
				return featureSelection.selectedFeatureModule;
			} else {
				return null;
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
