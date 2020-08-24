/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.services.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.internal.dialect.DialectUIManagerImpl;
import org.eclipse.sirius.ui.tools.internal.wizards.pages.NewModelingProjectCreationWizardPage;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.Model;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.Injector;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.impl.*;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.ui.internal.FormlActivator;
import sun.java2d.cmm.Profile;
import sun.security.acl.WorldGroupImpl;

public class ModelOperations extends ModelUtils2 {

	public static boolean addNewEntityToWorldModel(EObject modelObject, Entity newEntity) {
		try {
			WorldModel wm = getWorldModel(modelObject);

			wm.getConcepts().add(newEntity);

			Multiplicity multiplicity = FormlFactory.eINSTANCE.createMultiplicity();

			multiplicity.setValue(1);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void CreateNewFeatureNode(Node parentNode, Class createdNodeType) {

		if (createdNodeType.equals(FeatureNode.class)) {
			Feature newFeature = CreateNewFeature(parentNode);

		} else if (createdNodeType.equals(OrNode.class)) {
			OrNode fn = FormlFactory.eINSTANCE.createOrNode();
			CreateNewFeature(fn);
			CreateNewFeature(fn);
			if (parentNode instanceof FeatureNode) {
				((FeatureNode) parentNode).getOrs().add(fn);
			} else if (parentNode instanceof SPL) {
				((SPL) parentNode).getOrs().add(fn);
			}

		} else if (createdNodeType.equals(AndNode.class)) {
			AndNode fn = FormlFactory.eINSTANCE.createAndNode();
			CreateNewFeature(fn);
			CreateNewFeature(fn);
			if (parentNode instanceof FeatureNode) {
				((FeatureNode) parentNode).getAnds().add(fn);
			} else if (parentNode instanceof SPL) {
				((SPL) parentNode).getAnds().add(fn);
			}

		} else if (createdNodeType.equals(XORNode.class)) {
			XORNode fn = FormlFactory.eINSTANCE.createXORNode();
			CreateNewFeature(fn);
			CreateNewFeature(fn);
			if (parentNode instanceof FeatureNode) {
				((FeatureNode) parentNode).getXors().add(fn);
			} else if (parentNode instanceof SPL) {
				((SPL) parentNode).getXors().add(fn);
			}

		}
	}

	public static Feature CreateNewFeature(Node parentNode) {
		if (parentNode == null)
			return null;

		Feature newFeature = FormlFactory.eINSTANCE.createFeature();

		int autoincrementForName = ModelUtils.getWorldModelObjectsByType(newFeature, Feature.class).size();
		String newName = "F" + String.valueOf(autoincrementForName);
		while (!NameUniquenessVerifier.verify(newFeature, newName, false)) {
			autoincrementForName++;
			newName = "F" + String.valueOf(autoincrementForName);
		}
		newFeature.setName(newName);

		addNewFeatureToWorldModel(ModelUtils.getWorldModel(null), newFeature, parentNode);

		return newFeature;
	}

	public static boolean addNewFeatureToWorldModel(EObject modelObject, Feature newFeature, Node parentNode) {
		try {
			WorldModel wm = getWorldModel(modelObject);

			wm.getConcepts().add(newFeature);

			FeatureNode newFeatureNode = FormlFactory.eINSTANCE.createFeatureNode();
			newFeatureNode.setFeature(newFeature);

			Multiplicity multiplicity = FormlFactory.eINSTANCE.createMultiplicity();

			multiplicity.setMany("*");

			newFeatureNode.setMultiplicity(multiplicity);

			if (parentNode == null)
				ModelUtils.getSPLRoot(wm).getFeatureNodes().add(newFeatureNode);
			else
				parentNode.getFeatureNodes().add(newFeatureNode);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addNewFeatureToWorldModel(EObject modelObject, Feature newFeature, String newName,
			Node parentNode) {
		try {
			WorldModel wm = getWorldModel(modelObject);

			wm.getConcepts().add(newFeature);

			FeatureNode newFeatureNode = FormlFactory.eINSTANCE.createFeatureNode();
			newFeatureNode.setFeature(newFeature);

			Multiplicity multiplicity = FormlFactory.eINSTANCE.createMultiplicity();

			multiplicity.setValue(1);

			newFeatureNode.setMultiplicity(multiplicity);

			if (parentNode == null)
				ModelUtils.getSPLRoot(wm).getFeatureNodes().add(newFeatureNode);
			else
				parentNode.getFeatureNodes().add(newFeatureNode);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void addNewInputMessageToFeature(Feature parentFeature, Input newMessage, String newName) {

		if (newName.trim().equals("")) {
			int autoincrementForName = 1;
			String newMessageName = "inMsg"
					+ (ModelUtils.getNumberOfInputMessage(parentFeature) + autoincrementForName);

			if (newMessageName.trim().length() > 0) {
				while (!NameUniquenessVerifier.verify(newMessage, newMessageName, false)) {
					autoincrementForName++;
					newMessageName = "inMsg"
							+ (ModelUtils.getNumberOfInputMessage(parentFeature) + autoincrementForName);
				}
				newMessage.setName(newMessageName);
			}
		} else {
			if (NameUniquenessVerifier.verify(newMessage, newName, true)) {
				newMessage.setName(newName.replace(" ", "").trim());
			} else {
				return;
			}

		}

		ModelUtils.getWorldModel(parentFeature).getConcepts().add(newMessage);
		newMessage.getTos().add(parentFeature);

		InputList inputlist = FormlFactory.eINSTANCE.createInputList();
		RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
		newRefMsg.setRefMsg(newMessage);
		inputlist.getInputs().add(newRefMsg);
		if (parentFeature.getInputlist() == null || parentFeature.getInputlist().getInputs().isEmpty())
			parentFeature.setInputlist(inputlist);
		else
			parentFeature.getInputlist().getInputs().add(newRefMsg);

	}

	public static void addNewOutputMessageToFeature(Feature parentFeature, Output newMessage, String newName) {
		if (newName.trim().equals("")) {
			int autoincrementForName = 1;
			String newMessageName = "outMsg"
					+ (ModelUtils.getNumberOfOutputMessage(parentFeature) + autoincrementForName);

			if (newMessageName.trim().length() > 0) {
				while (!NameUniquenessVerifier.verify(newMessage, newMessageName, false)) {
					autoincrementForName++;
					newMessageName = "outMsg"
							+ (ModelUtils.getNumberOfOutputMessage(parentFeature) + autoincrementForName);
				}
				newMessage.setName(newMessageName);
			}
		} else {
			if (NameUniquenessVerifier.verify(newMessage, newName, true)) {
				newMessage.setName(newName.replace(" ", "").trim());
			} else {
				return;
			}

		}
		ModelUtils.getWorldModel(parentFeature).getConcepts().add(newMessage);
		newMessage.getFroms().add(parentFeature);

		OutputList outputlist = FormlFactory.eINSTANCE.createOutputList();
		RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
		newRefMsg.setRefMsg(newMessage);
		outputlist.getOutputs().add(newRefMsg);
		if (parentFeature.getOutputlist() == null || parentFeature.getOutputlist().getOutputs().isEmpty())
			parentFeature.setOutputlist(outputlist);
		else
			parentFeature.getOutputlist().getOutputs().add(newRefMsg);
	}

	public static void addNewAttributeToFeature(Feature parentFeature, Attribute newAttribute, String newName) {

		if (newName.trim().equals("")) {
			int autoincrementForName = 1;
			String newAttName = "att"
					+ (ModelUtils.getNumberOfAttributesForFeature(parentFeature) + autoincrementForName);

			if (newAttName.trim().length() > 0) {
				while (!NameUniquenessVerifier.verify(newAttribute, parentFeature, newAttName, false)) {
					autoincrementForName++;
					newAttName = "att"
							+ (ModelUtils.getNumberOfAttributesForFeature(parentFeature) + autoincrementForName);
				}
				newAttribute.setName(newAttName);
			}
		} else

		{
			if (NameUniquenessVerifier.verify(newAttribute, parentFeature, newName, true)) {
				newAttribute.setName(newName.replace(" ", "").trim());
			} else {
				return;
			}

		}

		AttributeType intType = FormlFactory.eINSTANCE.createIntType();
		newAttribute.setType(intType);

		parentFeature.getAttributes().add(newAttribute);
	}

	public static void addNewAttributeToEntity(Entity parentEntity, Attribute newAttribute, String newAttName) {

		if (newAttName.trim().equals("")) {
			int autoincrementForName = 1;
			newAttName = "att" + (ModelUtils.getNumberOfAttributesForEntity(parentEntity) + autoincrementForName);

			if (newAttName.trim().length() > 0) {
				while (!NameUniquenessVerifier.verify(newAttribute, parentEntity, newAttName, false)) {
					autoincrementForName++;
					newAttName = "att"
							+ (ModelUtils.getNumberOfAttributesForEntity(parentEntity) + autoincrementForName);
				}

			}
		}
		newAttribute.setName(newAttName);

		if (newAttribute.getType() == null) {
			AttributeType intType = FormlFactory.eINSTANCE.createIntType();
			newAttribute.setType(intType);
		}

		parentEntity.getAttributes().add(newAttribute);
	}

	public static void importMessageToFeature(Feature parentFeature, Message newMessage) {
		if (newMessage instanceof Input) {
			InputList inputlist = FormlFactory.eINSTANCE.createInputList();
			RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
			newRefMsg.setRefMsg(newMessage);
			inputlist.getInputs().add(newRefMsg);
			if (parentFeature.getInputlist() == null || parentFeature.getInputlist().getInputs().isEmpty())
				parentFeature.setInputlist(inputlist);
			else {
				for (RefMessage inMsg : parentFeature.getInputlist().getInputs()) {
					if (inMsg.getRefMsg().equals(newMessage)) {
						JOptionPane.showMessageDialog(null, "The feature: " + parentFeature.getName()
								+ " already has message: " + newMessage.getName());
						return;
					}
				}
				parentFeature.getInputlist().getInputs().add(newRefMsg);
			}

			((Input) newMessage).getTos().add(parentFeature);
		} else if (newMessage instanceof Output) {
			OutputList outputlist = FormlFactory.eINSTANCE.createOutputList();
			RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
			newRefMsg.setRefMsg(newMessage);
			outputlist.getOutputs().add(newRefMsg);
			if (parentFeature.getOutputlist() == null || parentFeature.getOutputlist().getOutputs().isEmpty())
				parentFeature.setOutputlist(outputlist);
			else {
				for (RefMessage outMsg : parentFeature.getOutputlist().getOutputs()) {
					if (outMsg.getRefMsg().equals(newMessage)) {
						JOptionPane.showMessageDialog(null, "The feature: " + parentFeature.getName()
								+ " already has message: " + newMessage.getName());
						return;
					}
				}
				parentFeature.getOutputlist().getOutputs().add(newRefMsg);
			}
			((Output) newMessage).getFroms().add(parentFeature);

		}
	}

	public static void createNewInitialState(Region parentRegion) {
		State s0 = CreateNewState(parentRegion);

		InitState initState = FormlFactory.eINSTANCE.createInitState();
		initState.setStateref(s0);

		parentRegion.setInit(initState);
	}

	public static State CreateNewState(Region parentRegion) {

		State newState = FormlFactory.eINSTANCE.createState();

		parentRegion.getStates().add(newState);

		setUniqueStateName(newState);
		return newState;

	}

	public static void setUniqueStateName(State state) {
		int autoincrementForName = EcoreUtil2.getContainerOfType(state, Region.class).getStates().size() - 1;

		String newName = "S" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((State) state, newName, false)) {
			autoincrementForName++;
			newName = "S" + String.valueOf(autoincrementForName);
		}
		((State) state).setName(newName);
	}

	public static void setUniqueRegionName(Region region) {
		int autoincrementForName = 0;
		if (region.eContainer() instanceof State)
			autoincrementForName = EcoreUtil2.getContainerOfType(region, State.class).getRegions().size() - 1;
		else if (region.eContainer() instanceof StateMachine)
			autoincrementForName = EcoreUtil2.getContainerOfType(region, StateMachine.class).getRegions().size() - 1;

		String newName = "R" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((Region) region, newName, false)) {
			autoincrementForName++;
			newName = "R" + String.valueOf(autoincrementForName);
		}
		((Region) region).setName(newName);
	}

	public static Region createNewRegion(EObject parentState) {
		Region newRegion = FormlFactory.eINSTANCE.createRegion();

		if (parentState instanceof State)
			((State) parentState).getRegions().add(newRegion);
		else if (parentState instanceof StateMachine)
			((StateMachine) parentState).getRegions().add(newRegion);
		else
			return null;

		setUniqueRegionName(newRegion);

		createNewInitialState(newRegion);

		return newRegion;
	}

	public static Transition createTransition(State src, State dst) {

		Transition newTransition = FormlFactory.eINSTANCE.createTransition();

		newTransition.setSrc(src);
		newTransition.setDst(dst);

		StateMachine sm = (StateMachine) ModelUtils.getTypedRootForObject(src, StateMachine.class);
		if (sm != null)
			sm.getTransitions().add(newTransition);
		else {
			FragmentType ft = ModelUtils.getTypedRootForObject(src, FragmentType.class);
			ft.getTransitions().add(newTransition);
		}

		setUniqueTransitionName(newTransition);

		return newTransition;
	}

	public static void setUniqueTransitionName(Transition t) {
		int autoincrementForName = 0;

		if (EcoreUtil2.getContainerOfType(t, StateMachine.class) != null)
			autoincrementForName = EcoreUtil2.getContainerOfType(t, StateMachine.class).getTransitions().size();
		else {
			autoincrementForName = EcoreUtil2.getContainerOfType(t, FragmentType.class).getTransitions().size();
		}

		String newName = "t" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify((Transition) t, newName, false)) {
			autoincrementForName++;
			newName = "t" + String.valueOf(autoincrementForName);
		}
		((Transition) t).setName(newName);
	}

	public static void EditMessage(String newName, AttributeType newType, Message oldMessage,
			List<Attribute> newAttrList) {

		oldMessage.setName(newName);
		oldMessage.setType(newType);
		oldMessage.getAttributes().clear();
		oldMessage.getAttributes().addAll(newAttrList);

	}

	public static FeatureModule createNewFeatureModel(Roleable featureref) {

		FeatureModule newFM = FormlFactory.eINSTANCE.createFeatureModule();
		Constraint newConstraint = FormlFactory.eINSTANCE.createConstraint();
		newFM.setConstraints(newConstraint);
		newFM.setFeatureref(featureref);

		createNewStateMachine(newFM);

		ModelUtils.getBehaviourModel(featureref).getFeaturemodules().add(newFM);

		return newFM;

	}

	private static void createNewStateMachine(FeatureModule newFM) {
		StateMachine newStateMachine = FormlFactory.eINSTANCE.createStateMachine();
		setUniqueStateMachineName(newStateMachine, newFM);
		createNewRegion(newStateMachine);
		newFM.getStatemachine().add(newStateMachine);
	}

	public static void setUniqueStateMachineName(StateMachine t, FeatureModule FM) {

		String newName = "SM_" + FM.getFeatureref().getName().trim();
		t.setName(newName);
	}

	public static void CreateNewEntity(EObject any, String newEntityName) {
		String entityName = "";
		Entity newEntity = FormlFactory.eINSTANCE.createEntity();

		if (newEntityName != null && !newEntityName.trim().equals("")) {
			entityName = newEntityName;
		} else {

			int autoincrementForName = ModelUtils.getWorldModelObjectsByType(newEntity, Entity.class).size();

			String newName = "Entity" + String.valueOf(autoincrementForName);

			while (!NameUniquenessVerifier.verify(newEntity, newName, false)) {
				autoincrementForName++;
				newName = "Entity" + String.valueOf(autoincrementForName);
			}

			entityName = newName;
		}
		newEntity.setName(entityName);

		EObject wm = ModelUtils.getWorldModel(any);
		ModelOperations.addNewEntityToWorldModel(wm, newEntity);

	}

	public static boolean checkIfNotDuplicateInWorldModel(Class type, String newName, EObject currentClass,
			boolean showErrorMessage) {
		List<EObject> typesObjects = ModelUtils.getWorldModelObjectsByType(currentClass, type);
		boolean result = false;
		for (EObject eobj : typesObjects) {
			if (eobj instanceof Entity) {
				result = NameUniquenessVerifier.verify((Entity) eobj, newName, showErrorMessage);
				return result;
			} else if (eobj instanceof Feature) {
				result = NameUniquenessVerifier.verify((Feature) eobj, newName, showErrorMessage);
				return result;
			} else if (eobj instanceof Message) {
				result = NameUniquenessVerifier.verify((Message) eobj, newName, showErrorMessage);
				return result;
			} else if (eobj instanceof Function) {
				if (currentClass instanceof Entity) {
					result = NameUniquenessVerifier.verify((Function) eobj, (Entity) currentClass, newName,
							showErrorMessage);
					return result;
				}
			} else if (eobj instanceof Attribute) {
				result = NameUniquenessVerifier.verify((Attribute) eobj, currentClass, newName, showErrorMessage);
				return result;
			}
		}

		if (typesObjects.isEmpty())
			return true;

		return result;
	}

	public static State createNewInitialStateWithRefState(Region parentRegion) {
		State s0 = CreateNewState(parentRegion);

		InitState initState = FormlFactory.eINSTANCE.createInitState();
		initState.setStateref(s0);

		parentRegion.setInit(initState);

		return s0;

	}

	public static void CopyFMStructure(FeatureModule baseFM, FeatureModule newFM) {

		StateMachine copiedContents = EcoreUtil.copy(baseFM.getStatemachine().get(0));
		newFM.getStatemachine().clear();
		copiedContents.setName("SM_" + newFM.getFeatureref().getName());
		EList<Transition> transitions = copiedContents.getTransitions();

//		for (Transition trans : transitions) {
//			// trans.setPriority(null);
//
//			Trigger trig = FormlFactory.eINSTANCE.createTrigger();
//			Guard guard = FormlFactory.eINSTANCE.createGuard();
//			WCAList wca = FormlFactory.eINSTANCE.createWCAList();
//			
//			//trans.setTrig(trig);
//			//trans.setGuard(guard);
//			//trans.setList(wca);
//		}

		newFM.getStatemachine().add(copiedContents);

	}
}
