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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.FragmentType;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.IntType;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.OutputList;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StringType;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.UndefinedType;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.andPred;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.forml.basePred;
import uw.cs.watform.forml.forml.boolExpr;
import uw.cs.watform.forml.forml.impPred;
import uw.cs.watform.forml.forml.intBase;
import uw.cs.watform.forml.forml.intExpr;
import uw.cs.watform.forml.forml.multExpr;
import uw.cs.watform.forml.forml.notPred;
import uw.cs.watform.forml.forml.orPred;
import uw.cs.watform.forml.forml.predExpr;
import uw.cs.watform.forml.forml.predExpr2;
import uw.cs.watform.forml.forml.predExpr3;
import uw.cs.watform.forml.forml.setExpr;
import uw.cs.watform.forml.forml.setExpr2;
import uw.cs.watform.forml.forml.setExpr3;
import uw.cs.watform.forml.forml.setExprBase;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;

@SuppressWarnings("unchecked")
public class ModelUtils2 extends ModelUtils {

	public static boolean checkGuardsForSoundNess(EObject elem, CustomVirtualResource vres,
			HashMap<EObject, String> map_GuardToText) {
		List<Guard> guards = getBehaviourModelObjectsByType(BEHAVIOUR_MODEL, Guard.class);

		List<EObject> problematic_guards = new ArrayList<EObject>();
		for (Guard g : guards) {
			if (!checkGuardTypes(g)) {
				problematic_guards.add(g);
			}
		}

		if (problematic_guards.size() > 0) {
			int result = JOptionPane.showConfirmDialog(null,
					"The change causes an inconsistency in a Guard expression in one or more of the state machines. "
							+ "The left-hand-side and the right-hand-side of the guard are not sound by type now. You should fix them before proceeding.",
					"Warning", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {

				for (EObject pg : problematic_guards) {

					Transition parentTrans = getTypedRootForObject((Guard) pg, Transition.class);

					Guard newG = ModelUtils2.CreateConditionalEqualGuard((ExprRef) elem, null, false);

					Guard oldGuard = parentTrans.getGuard();

					if (oldGuard != null) {
						oldGuard.setPredicate(newG.getPredicate());
					}

					// parentTrans.setGuard(newG);
				}

				try {
					JS_FeatureClassServices.FixGuardSoundnessWithReferenceBox(problematic_guards, elem, vres,
							map_GuardToText);
				} catch (Exception e) {
					vres.revertBack();
				}

			} else {
				vres.revertBack();
				return false;
			}
		}

//		if (problematic_guards.size() > 0) {
//			int result = JOptionPane.showConfirmDialog(null,
//					"The change causes an inconsistency in a Guard expression in one of the state machines. "
//							+ "The left-hand-side and the right-hand-side of the guard are not sound by type now. Do you want to fix it now?",
//					"Warning", JOptionPane.YES_NO_OPTION);
//			if (result == JOptionPane.YES_OPTION) {
//				for (Guard g : problematic_guards) {
//					FeatureModule fModule = ModelUtils.getTypedRootForObject(g, FeatureModule.class);
//					Roleable ref = fModule.getFeatureref();
//					Collection<DRepresentation> reps = RepresentationsUtils.getRepresentationForAnyObject(fModule,
//							true);
//					if (reps.iterator().hasNext())
//						RepresentationsUtils.openRepresentation(reps.iterator().next());
//
//				}
//			}		
//		}
		// returns true if there guards are sound
		return true;
	}

	public static <T extends EObject> HashMap<EObject, String> getGuardUsageText(EObject usageElement) {

		Collection<Setting> crossRefs = findReferencedObjects(usageElement, BEHAVIOUR_MODEL);
		Iterator<Setting> it = crossRefs.iterator();

		List<EObject> usages = new ArrayList<EObject>();

		while (it.hasNext()) {
			usages.add(it.next().getEObject());
		}

		HashMap<EObject, String> map_elementToText = new HashMap<EObject, String>();

		for (EObject eobj : usages) {
			Transition par = getTypedRootForObject(eobj, Transition.class);
			if (par != null) {
				List<Guard> actualObject = getObjectsByTypeInAnObjectElement(par, Guard.class);

				if (actualObject.size() > 0) {
					String text = getTextForModelObjects(actualObject.get(0));
					map_elementToText.put(par, text);
				}
			}

		}

		return map_elementToText;
	}

	public static boolean checkGuardTypes(final Guard g) {

		List<impPred> imppreds = getObjectsByTypeInAnObjectElement(g, impPred.class);

		for (impPred ip : imppreds) {
			boolean _isTypeSound = isTypeSound(ip);
			if (_isTypeSound == false) {
				return false;
			}
		}
		return true;

	}

	public static boolean isTypeSound(impPred ip) {
		List<atomic> atomics = EcoreUtil2.<atomic>getAllContentsOfType(ip, atomic.class);

		int _size = atomics.size();
		if (_size == 0) {
			return true;
		} else if (_size == 1) {
			atomic atom1 = atomics.get(0);
			ExprRef ref1 = atom1.getRef();
			AttributeType type1 = getTypeOf(ref1);
			if (type1 == null) {
				return true;
			} else {
				if ((type1 instanceof BoolType)) {
					List<boolExpr> boolexprs = EcoreUtil2.getAllContentsOfType(ip, boolExpr.class);
					if (boolexprs.isEmpty()) {
						return false;
					} else {
						return true;
					}
				} else if ((type1 instanceof IntType)) {
					List<intBase> intexprs = EcoreUtil2.getAllContentsOfType(ip, intBase.class);
					if (intexprs.size() < 2) {
						return false;
					} else {
						return true;
					}
				} else {
					List<atomic> atomic2 = EcoreUtil2.getAllContentsOfType(ip, atomic.class);
					if (atomic2.size() < 2) {
						return false;
					}
				}
				return true;
			}

		} else if (_size == 2) {
			int _size_1 = atomics.size();
			boolean _equals = (_size_1 == 2);
			if (_equals) {
				atomic atom1 = atomics.get(0);
				atomic atom2 = atomics.get(1);
				ExprRef ref1 = atom1.getRef();
				ExprRef ref2 = atom2.getRef();
				AttributeType type1 = null;
				AttributeType type2 = null;
				type1 = getTypeOf(ref1);
				type2 = getTypeOf(ref2);
				if (((type1 != null) && (type2 != null))) {
					if (((type1 instanceof IntType) && (type2 instanceof IntType))) {
						return true;
					}
					if (((type1 instanceof BoolType) && (type2 instanceof BoolType))) {
						return true;
					}
					if (((type1 instanceof StringType) && (type2 instanceof StringType))) {
						return true;
					}
					if (((type1 instanceof UndefinedType) && (type2 instanceof UndefinedType))) {
						return true;
					}
					if (((type1 instanceof Enumeration) && (type2 instanceof Enumeration))) {
						boolean _equalsIgnoreCase = Enumeration.class.cast(type1).getName()
								.equalsIgnoreCase(Enumeration.class.cast(type2).getName());
						if (_equalsIgnoreCase) {
							return true;
						}
					}
					if (((type1 instanceof ReferenceType) && (type2 instanceof ReferenceType))) {
						boolean _equalsIgnoreCase_1 = ReferenceType.class.cast(type1).getRef().getName()
								.equalsIgnoreCase(ReferenceType.class.cast(type2).getRef().getName());
						if (_equalsIgnoreCase_1) {
							return true;
						}
					}
				} else {
					if (((type1 == null) || (type2 == null))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static AttributeType getTypeOf(final ExprRef ref) {
		if ((ref instanceof Input)) {
			return Input.class.cast(ref).getType();
		} else if ((ref instanceof Output)) {
			return Output.class.cast(ref).getType();
		} else if ((ref instanceof Attribute)) {
			return Attribute.class.cast(ref).getType();
		} else if ((ref instanceof Function)) {
			return Function.class.cast(ref).getType();
		}
		return null;

	}

	public static String convertAttributeTypeToString(AttributeType type) {
		if (type != null) {
			if (type instanceof IntType)
				return "int";
			else if (type instanceof BoolType)
				return "bool";
			else if (type instanceof StringType)
				return "string";
			else if (type instanceof Enumeration)
				return ((Enumeration) type).getName();
			else if (type instanceof ReferenceType)
				return ((ReferenceType) type).getRef().getName();
			else if (type instanceof UndefinedType)
				return ((UndefinedType) type).getName();
		} else
			return "";

		return "";
	}

	public static AttributeType createAttributeType(String TypeName) {

		if (TypeName.trim().equals(""))
			return null;

		AttributeType attNewType = FormlFactory.eINSTANCE.createAttributeType();

		if (TypeName.equalsIgnoreCase("int") || TypeName.equalsIgnoreCase("Integer"))
			attNewType = FormlFactory.eINSTANCE.createIntType();
		else if (TypeName.equalsIgnoreCase("bool") || TypeName.equalsIgnoreCase("Boolean"))
			attNewType = FormlFactory.eINSTANCE.createBoolType();
		else if (TypeName.equalsIgnoreCase("string") || TypeName.equalsIgnoreCase("String"))
			attNewType = FormlFactory.eINSTANCE.createStringType();

		else {

			// if concept exists in the worldmodel, then create a referenced
			// type and refer to it
			boolean if_RT_AlreadyExisted = false;
			for (ExprRef ut : WORLD_MODEL.getConcepts()) {
				if (ut instanceof Concept) {

					if (((Concept) ut).getName().equalsIgnoreCase(TypeName)) {
						// ReferenceType newrefAtt = FormlFactory.eINSTANCE.createReferenceType();
						// newrefAtt.setRef((Concept) ut);
						ReferenceType newrefAtt = ModelUtils.getReferencedType((Concept) ut);
						attNewType = newrefAtt;

						if_RT_AlreadyExisted = true;

						break;
					}
				}
			}

			// if concept DOES NOT exists in the worldmodel, then create an
			// undefined type
			if (if_RT_AlreadyExisted == false) {
				ReferenceType newrefAtt = FormlFactory.eINSTANCE.createReferenceType();

				UndefinedType ut = FormlFactory.eINSTANCE.createUndefinedType();
				ut.setName(TypeName);

				WORLD_MODEL.getConcepts().add(ut);

				newrefAtt.setRef(ut);
				attNewType = newrefAtt;
			}
		}

		// ClearUndefinedTypesNotUsedAnyMore();

		return attNewType;
	}

	public static void clearUndefinedTypesNotUsedAnyMore(EObject modelObject) {

		for (UndefinedType ut : ModelUtils.getWorldModelObjectsByType(modelObject, UndefinedType.class)) {
			if (findReferencedObjects(ut, SYSTEM).size() == 0) {
				EcoreUtil.delete(ut);
			}
		}
	}

	public static Collection<Setting> findReferencedObjects(EObject object, EObject rootContainer) {

		if (rootContainer != null) {
			Collection<Setting> referrers = EcoreUtil.UsageCrossReferencer.find(object, rootContainer);
			return referrers;
		}

		return new ArrayList<Setting>();

	}

	public static Collection<Setting> getReferencesBySemanticType(EObject element) {
		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(element,
				ModelUtils.getSystem(element).getBehaviourmodel());

		if (element instanceof Feature) {
			referrers.addAll(getReferencesForFeature((Feature) element));
		} else if (element instanceof Entity) {
			referrers.addAll(getReferencesForEntity((Entity) element));
		} else if (element instanceof Message) {
			referrers.addAll(getReferencesForMessage((Message) element));
			//referrers.addAll(getReferencesForMessageAttributes((Message) element));
		} else if (element instanceof Attribute) {
			referrers.addAll(getReferencesForAttribute((Attribute) element));
		} else if (element instanceof Function) {
			referrers.addAll(getReferencesForFunction((Function) element));
		} else if (element instanceof RefMessage) {
			referrers.addAll(getReferencesForRefMessage((RefMessage) element));
		}

		return referrers;

	}

	public static List<Transition> getOutgoingTransitionsFromState(State srcState) {

		List<Transition> outgoingTransitions = new ArrayList<Transition>();

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(srcState,
				ModelUtils.getTypedRootForObject(srcState, FeatureModule.class));

		Iterator<Setting> iterator = referrers.iterator();
		while (iterator.hasNext()) {
			EObject ref = iterator.next().getEObject();
			if (ref instanceof Transition) {
				if (((Transition) ref).getSrc().equals(srcState))
					if (!outgoingTransitions.contains(ref))
						outgoingTransitions.add((Transition) ref);
			}
		}

		return outgoingTransitions;
	}

	public static Collection<Setting> getReferencesForEntity(Entity entity) {

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(entity, ModelUtils.getBehaviourModel(entity));

		// referrers.addAll(ModelUtils2.findReferencedObjects(entity,
		// ModelUtils.getWorldModel(entity)));

		for (ExprRef att : entity.getAttributes()) {
			referrers.addAll(getReferencesForAttribute((Attribute) att));
		}

		for (ExprRef func : entity.getFunctions()) {
			referrers.addAll(getReferencesForFunction((Function) func));
		}

		return referrers;
	}

	private static Collection<Setting> getReferencesForFeature(Feature feature) {

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(feature,
				ModelUtils.getBehaviourModel(feature));

		for (ExprRef att : feature.getAttributes()) {
			referrers.addAll(getReferencesForAttribute((Attribute) att));
		}

		if (feature.getInputlist() != null) {
			for (RefMessage inp : feature.getInputlist().getInputs()) {
				referrers.addAll(getReferencesForMessage(inp.getRefMsg()));
			}
		}

		if (feature.getOutputlist() != null) {
			for (RefMessage out : feature.getOutputlist().getOutputs()) {
				referrers.addAll(getReferencesForMessage(out.getRefMsg()));
			}
		}

		return referrers;
	}

	private static Collection<Setting> getReferencesForMessage(Message message) {

		// int noOfReferences = 0;

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(message,
				ModelUtils.getBehaviourModel(message));

		// noOfReferences += referrers.size();

		for (ExprRef att : message.getAttributes()) {
			referrers.addAll(getReferencesForAttribute((Attribute) att));

			// noOfReferences += referrers.size();
		}

		// return noOfReferences;
		return referrers;
	}

	private static Collection<Setting> getReferencesForRefMessage(RefMessage ref_Message) {

		Message msg = ((RefMessage) ref_Message).getRefMsg();

		Collection<Setting> referrers= getReferencesForMessage(msg);

		// noOfReferences += referrers.size();

		// for (ExprRef att : ref_Message.getAttributes()) {
		// referrers.addAll(getReferencesForAttribute((Attribute) att));

		// noOfReferences += referrers.size();
		// }

		// return noOfReferences;
		return referrers;
	}

	/*
	 * private static Collection<Setting> getReferencesForMessageAttributes(Message
	 * ref_Message) {
	 * 
	 * // int noOfReferences = 0;
	 * 
	 * Collection<Setting> referrers = new HashSet();
	 * 
	 * // noOfReferences += referrers.size();
	 * 
	 * for (ExprRef att : ref_Message.getAttributes()) {
	 * referrers.addAll(getReferencesForAttribute((Attribute) att));
	 * 
	 * // noOfReferences += referrers.size(); }
	 * 
	 * // return noOfReferences; return referrers; }
	 */
	private static Collection<Setting> getReferencesForAttribute(Attribute attribute) {

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(attribute,
				ModelUtils.getBehaviourModel(attribute));

		return referrers;
	}

	private static Collection<Setting> getReferencesForFunction(uw.cs.watform.forml.forml.Function function) {

		Collection<Setting> referrers = ModelUtils2.findReferencedObjects(function,
				ModelUtils.getBehaviourModel(function));

		return referrers;
	}

	public static List<Transition> findTransitionParentForReferrers(Collection<Setting> referrers) {

		List<Transition> parents = new ArrayList<Transition>();

		Iterator<Setting> iterator = referrers.iterator();
		while (iterator.hasNext()) {
			EObject ref = iterator.next().getEObject();

			parents.add(ModelUtils.getTypedRootForObject(ref, Transition.class));
		}

		return parents;
	}

	public static String[] convertMultiplicityToStrings(Multiplicity mul) {
		String[] returnBoundaries = new String[2];

		if (mul != null) {
			int oldLower = 0, oldUpper = 0;

			if (mul.getCardinality() != null) {
				oldLower = mul.getCardinality().getLower();
				if (mul.getCardinality().getMany() != null && mul.getCardinality().getMany().trim() != "")
					oldUpper = -1;
				else
					oldUpper = mul.getCardinality().getUpper();
			} else {
				if (mul.getMany() != null && mul.getMany().trim() != "") {
					oldLower = 0;
					oldUpper = -1;
				} else {
					oldLower = mul.getValue();
					oldUpper = mul.getValue();
				}
			}

			returnBoundaries[0] = String.valueOf(oldLower);

			if (oldUpper == -1)
				returnBoundaries[1] = "*";
			else
				returnBoundaries[1] = String.valueOf(oldUpper);
		} else {
			returnBoundaries[0] = "";
			returnBoundaries[1] = "";
		}
		return returnBoundaries;
	}

	public static List<List<ExprRef>> getListOfPossibleItemsForTrigerringEvent(EObject object) {

		WorldModel wm = getWorldModel(object);
		BehaviourModel bm = getBehaviourModel(object);

		List<List<ExprRef>> suggestableItems = new ArrayList<List<ExprRef>>();

		FeatureModule currentFM = getTypedRootForObject(object, FeatureModule.class);
		if (currentFM.getFeatureref() instanceof Feature) {

			InputList inputList = ((Feature) currentFM.getFeatureref()).getInputlist();

			if (inputList != null) {
				// add input messages
				for (RefMessage inp : inputList.getInputs()) {
					List<ExprRef> tempList = new ArrayList<ExprRef>();
					tempList.add(getTypedRootForObject(inp, Feature.class));
					tempList.add(inp.getRefMsg());
					suggestableItems.add(tempList);
				}
			}
			// add attributes
			for (ExprRef att : currentFM.getFeatureref().getAttributes()) {
				List<ExprRef> tempList = new ArrayList<ExprRef>();
				tempList.add(getTypedRootForObject(att, Feature.class));
				tempList.add(att);
				suggestableItems.add(tempList);
			}

			// add messages from parentFeatures that this is fragmented from
			for (Roleable f : getParentOriginalFeatureModules(currentFM)) {
				if (f instanceof Feature) {
					inputList = ((Feature) f).getInputlist();
					if (inputList != null) {
						for (RefMessage inp : inputList.getInputs()) {
							List<ExprRef> tempList = new ArrayList<ExprRef>();
							tempList.add(f);
							tempList.add(inp.getRefMsg());
							suggestableItems.add(tempList);
						}
					}
				}
			}
		}
		return suggestableItems;
	}

	public static List<List<ExprRef>> getListOfPossibleItemsForWCAAction(EObject object) {

		WorldModel wm = getWorldModel(object);
		BehaviourModel bm = getBehaviourModel(object);

		List<List<ExprRef>> suggestableItems = new ArrayList<List<ExprRef>>();

		FeatureModule currentFM = getTypedRootForObject(object, FeatureModule.class);

		if (currentFM.getFeatureref() instanceof Feature) {

			OutputList outputList = ((Feature) currentFM.getFeatureref()).getOutputlist();

			if (outputList != null) {
				// add input messages
				for (RefMessage inp : outputList.getOutputs()) {
					List<ExprRef> tempList = new ArrayList<ExprRef>();
					tempList.add(getTypedRootForObject(inp, Feature.class));
					tempList.add(inp.getRefMsg());
					suggestableItems.add(tempList);
				}
			}

			// add messages from parentFeatures that this is fragmented from
			for (Roleable f : getParentOriginalFeatureModules(currentFM)) {
				if (f instanceof Feature) {
					outputList = ((Feature) f).getOutputlist();
					if (outputList != null) {
						for (RefMessage inp : outputList.getOutputs()) {
							List<ExprRef> tempList = new ArrayList<ExprRef>();
							tempList.add(f);
							tempList.add(inp.getRefMsg());
							suggestableItems.add(tempList);
						}
					}
				}
			}
		}
		return suggestableItems;
	}

	public static List<Roleable> getParentOriginalFeatureModules(FeatureModule fm) {

		List<Roleable> result = new ArrayList<Roleable>();

		FeatureModule featuremodule = fm;
		while (featuremodule != null) {
			List<StateContext> allStateContexts = EcoreUtil2.getAllContentsOfType(featuremodule, StateContext.class);
			if (allStateContexts.size() == 0)
				featuremodule = null;

			for (StateContext sc : allStateContexts) {
				featuremodule = EcoreUtil2.getContainerOfType(sc.getRef(), FeatureModule.class);
				result.add(featuremodule.getFeatureref());
			}
		}

		return result;

	}

	public static void setType(Object element, Object type) {
		if (type instanceof AttributeType && element != null) {
			AttributeType attType = (AttributeType) type;
			if (element instanceof RefMessage) {
				((RefMessage) element).getRefMsg().setType(attType);
			} else if (element instanceof Message) {
				((Message) element).setType(attType);
			} else if (element instanceof Attribute) {
				((Attribute) element).setType(attType);
			} else if (element instanceof Function) {
				((Function) element).setType(attType);
			}
		}

	}

	public static Enumeration getEnumClass(EnumConst type) {
		Enumeration enumClass = getTypedRootForObject(type, Enumeration.class);
		return enumClass;
	}

	public static Guard CreateConditionalEqualGuard(ExprRef lhsValue, ExprRef rhsValue, boolean lookForConstants,
			Guard originalGuard) {

		Guard newguard = CreateConditionalEqualGuard(lhsValue, rhsValue, lookForConstants);
		if (originalGuard != null) {

			if (newguard != null) {

				List<impPred> impreds = ModelUtils2.getObjectsByTypeInAnObjectElement(originalGuard, impPred.class);

				List<andPred> andpreds = ModelUtils2.getObjectsByTypeInAnObjectElement(newguard, andPred.class);
				if (!andpreds.isEmpty()) {
					andpreds.get(0).getPreds().addAll(0, EcoreUtil.copyAll(impreds));
				}
			}
		}

		return newguard;
	}

	public static Guard CreateConditionalEqualGuard(ExprRef lhsValue, ExprRef rhsValue, boolean lookForConstants) {
		AttributeType LHSType = getTypeOf(lhsValue);
		if (LHSType instanceof IntType) {
			return CreateIntConditionalEqualGuard(lhsValue, rhsValue, lookForConstants);
		} else {
			return CreateGeneralConditionalEqualGuard(lhsValue, rhsValue, lookForConstants);
		}
	}

	public static Guard CreateIntConditionalEqualGuard(ExprRef lhsValue, ExprRef rhsValue, boolean lookForConstants) {
		Guard guard = FormlFactory.eINSTANCE.createGuard();
		try {
			Predicate pred = FormlFactory.eINSTANCE.createPredicate();
			notPred notpred = FormlFactory.eINSTANCE.createnotPred();
			andPred andpred = FormlFactory.eINSTANCE.createandPred();
			impPred imppred = FormlFactory.eINSTANCE.createimpPred();
			orPred orpred = FormlFactory.eINSTANCE.createorPred();
			basePred basepred = FormlFactory.eINSTANCE.createbasePred();
			if (lhsValue != null) {
				intExpr lhs_intexpr = FormlFactory.eINSTANCE.createintExpr();
				multExpr lhs_mulexpr = FormlFactory.eINSTANCE.createmultExpr();
				intBase lhs_intbase0 = FormlFactory.eINSTANCE.createintBase();
				atomic lhs_atom = FormlFactory.eINSTANCE.createatomic();
				lhs_atom.setRef(lhsValue);
				lhs_intbase0.setAtom(lhs_atom);
				lhs_mulexpr.setLhs(lhs_intbase0);
				lhs_intexpr.setLhs(lhs_mulexpr);
				basepred.setIntlhs(lhs_intexpr);

			}

			if (rhsValue != null) {

				intExpr rhs_intexpr = FormlFactory.eINSTANCE.createintExpr();
				multExpr rhs_mulexpr = FormlFactory.eINSTANCE.createmultExpr();
				intBase rhs_intbase0 = FormlFactory.eINSTANCE.createintBase();
				atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
				rhs_atom.setRef(lhsValue);
				rhs_intbase0.setAtom(rhs_atom);
				rhs_mulexpr.getRhs().add(rhs_intbase0);
				rhs_intexpr.getRhs().add(rhs_mulexpr);
				basepred.setIntrhs(rhs_intexpr);
			}

			basepred.setOp("=");
			orpred.getPreds().add(basepred);
			imppred.getPreds().add(orpred);
			andpred.getPreds().add(imppred);
			notpred.setPred(andpred);
			pred.setQuantPred(notpred);
			guard.setPredicate(pred);
		} catch (Exception e) {
			System.err.println("Guard could not be created. See CreateIntConditionalEqualGuard in ModelUtils2 class.");
		}
		return guard;
	}

	public static Guard CreateGeneralConditionalEqualGuard(ExprRef lhsValue, ExprRef rhsValue,
			boolean lookForConstants) {
		Guard guard = FormlFactory.eINSTANCE.createGuard();
		try {
			Predicate pred = FormlFactory.eINSTANCE.createPredicate();
			notPred notpred = FormlFactory.eINSTANCE.createnotPred();
			andPred andpred = FormlFactory.eINSTANCE.createandPred();
			impPred imppred = FormlFactory.eINSTANCE.createimpPred();
			orPred orpred = FormlFactory.eINSTANCE.createorPred();
			basePred basepred = FormlFactory.eINSTANCE.createbasePred();
			if (lhsValue != null) {
				predExpr lhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
				predExpr2 lhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
				predExpr3 lhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
				setExprBase lhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
				atomic lhs_atom = FormlFactory.eINSTANCE.createatomic();
				lhs_atom.setRef(lhsValue);
				lhs_exprbase.setAtom(lhs_atom);
				lhs_predexpr3.setBase(lhs_exprbase);
				lhs_predexpr2.getExpr().add(lhs_predexpr3);
				lhs_predexpr.getExpr().add(lhs_predexpr2);
				basepred.setSetlhs(lhs_predexpr);

			}

			if (rhsValue != null) {

				predExpr rhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
				predExpr2 rhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
				predExpr3 rhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
				setExprBase rhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
				atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
				rhs_atom.setRef(rhsValue);
				rhs_exprbase.setAtom(rhs_atom);
				rhs_predexpr3.setBase(rhs_exprbase);
				rhs_predexpr2.getExpr().add(rhs_predexpr3);
				rhs_predexpr.getExpr().add(rhs_predexpr2);
				basepred.setSetrhs(rhs_predexpr);
			} else {
				if (lookForConstants) {
					AttributeType LHSType = getTypeOf(lhsValue);
					if (LHSType instanceof BoolType) {
						boolExpr boolrhs = FormlFactory.eINSTANCE.createboolExpr();
						boolrhs.setIsTrue("true");
						basepred.setBoolrhs(boolrhs);
					} else if (LHSType instanceof IntType) {
						boolExpr boolrhs = FormlFactory.eINSTANCE.createboolExpr();
						boolrhs.setIsTrue("true");
						basepred.setBoolrhs(boolrhs);
					} else if (LHSType instanceof ReferenceType) {
						if ((ReferenceType.class.cast(LHSType)).getRef() instanceof Enumeration) {
							Enumeration enumClass = (Enumeration) ReferenceType.class.cast(LHSType).getRef();
							if (enumClass != null) {
								ExprRef eumconst = enumClass.getConstant().get(0);

								predExpr rhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
								predExpr2 rhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
								predExpr3 rhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
								setExprBase rhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
								atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
								rhs_atom.setRef(eumconst);
								rhs_exprbase.setAtom(rhs_atom);
								rhs_predexpr3.setBase(rhs_exprbase);
								rhs_predexpr2.getExpr().add(rhs_predexpr3);
								rhs_predexpr.getExpr().add(rhs_predexpr2);
								basepred.setSetrhs(rhs_predexpr);
							}
						}
					}
				}
			}

			basepred.setLogicop("=");
			orpred.getPreds().add(basepred);
			imppred.getPreds().add(orpred);
			andpred.getPreds().add(imppred);
			notpred.setPred(andpred);
			pred.setQuantPred(notpred);
			guard.setPredicate(pred);
		} catch (Exception e) {
			System.err.println(
					"Guard could not be created. See CreateGeneralConditionalEqualGuard in ModelUtils2 class.");
		}
		return guard;
	}

	public static void CreateAssignmentForAction(ExprRef lhsValue, ExprRef rhsValue, Transition transition,
			boolean replaceAllAction, boolean lookForEnumConst) {

		if (transition.getList() == null) {
			WCAList wcaList = FormlFactory.eINSTANCE.createWCAList();
			transition.setList(wcaList);
		}

		if (replaceAllAction == true) {
			transition.getList().getActions().clear();
		}

		Action action = FormlFactory.eINSTANCE.createAction();
		if (lhsValue != null) {
			setExpr lhs_setexpr = FormlFactory.eINSTANCE.createsetExpr();
			setExpr2 lhs_setexpr2 = FormlFactory.eINSTANCE.createsetExpr2();
			setExpr3 lhs_setexpr3 = FormlFactory.eINSTANCE.createsetExpr3();
			setExprBase lhs_setexprbase = FormlFactory.eINSTANCE.createsetExprBase();
			atomic lhs_atom = FormlFactory.eINSTANCE.createatomic();
			lhs_atom.setRef(lhsValue);
			lhs_setexprbase.setAtom(lhs_atom);
			lhs_setexpr3.setBase(lhs_setexprbase);
			lhs_setexpr2.getExpr().add(lhs_setexpr3);
			lhs_setexpr.getExpr().add(lhs_setexpr2);
			action.setLvalue(lhs_setexpr);
		}

		if (rhsValue != null) {
			setExpr rhs_setexpr = FormlFactory.eINSTANCE.createsetExpr();
			setExpr2 rhs_setexpr2 = FormlFactory.eINSTANCE.createsetExpr2();
			setExpr3 rhs_setexpr3 = FormlFactory.eINSTANCE.createsetExpr3();
			setExprBase rhs_setexprbase = FormlFactory.eINSTANCE.createsetExprBase();
			atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
			rhs_atom.setRef(rhsValue);
			rhs_setexprbase.setAtom(rhs_atom);
			rhs_setexpr3.setBase(rhs_setexprbase);
			rhs_setexpr2.getExpr().add(rhs_setexpr3);
			rhs_setexpr.getExpr().add(rhs_setexpr2);
			action.setRvalue(rhs_setexpr);
		} else {
			if (lookForEnumConst) {
				AttributeType LHSType = getTypeOf(lhsValue);
				if (LHSType instanceof ReferenceType) {
					if ((ReferenceType.class.cast(LHSType)).getRef() instanceof Enumeration) {
						Enumeration enumClass = (Enumeration) ReferenceType.class.cast(LHSType).getRef();
						if (enumClass != null) {
							ExprRef eumconst = enumClass.getConstant().get(0);

							setExpr rhs_setexpr = FormlFactory.eINSTANCE.createsetExpr();
							setExpr2 rhs_setexpr2 = FormlFactory.eINSTANCE.createsetExpr2();
							setExpr3 rhs_setexpr3 = FormlFactory.eINSTANCE.createsetExpr3();
							setExprBase rhs_setexprbase = FormlFactory.eINSTANCE.createsetExprBase();
							atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
							rhs_atom.setRef(eumconst);
							rhs_setexprbase.setAtom(rhs_atom);
							rhs_setexpr3.setBase(rhs_setexprbase);
							rhs_setexpr2.getExpr().add(rhs_setexpr3);
							rhs_setexpr.getExpr().add(rhs_setexpr2);
							action.setRvalue(rhs_setexpr);
						}
					}
				}
			}
		}

		WCA newWCA = FormlFactory.eINSTANCE.createWCA();
		newWCA.setAction(action);
		String aID = "a" + String.valueOf(transition.getList().getActions().size() + 1);
		newWCA.setName(aID);
		transition.getList().getActions().add(newWCA);

//		try {
//			
//			
//			
//			Predicate pred = FormlFactory.eINSTANCE.createPredicate();
//			notPred notpred = FormlFactory.eINSTANCE.createnotPred();
//			andPred andpred = FormlFactory.eINSTANCE.createandPred();
//			impPred imppred = FormlFactory.eINSTANCE.createimpPred();
//			orPred orpred = FormlFactory.eINSTANCE.createorPred();
//			basePred basepred = FormlFactory.eINSTANCE.createbasePred();
//			if (lhsValue != null) {
//				predExpr lhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
//				predExpr2 lhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
//				predExpr3 lhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
//				setExprBase lhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
//				atomic lhs_atom = FormlFactory.eINSTANCE.createatomic();
//				lhs_atom.setRef(lhsValue);
//				lhs_exprbase.setAtom(lhs_atom);
//				lhs_predexpr3.setBase(lhs_exprbase);
//				lhs_predexpr2.getExpr().add(lhs_predexpr3);
//				lhs_predexpr.getExpr().add(lhs_predexpr2);
//				basepred.setSetlhs(lhs_predexpr);
//
//			}
//
//			if (rhsValue != null) {
//
//				predExpr rhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
//				predExpr2 rhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
//				predExpr3 rhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
//				setExprBase rhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
//				atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
//				rhs_atom.setRef(rhsValue);
//				rhs_exprbase.setAtom(rhs_atom);
//				rhs_predexpr3.setBase(rhs_exprbase);
//				rhs_predexpr2.getExpr().add(rhs_predexpr3);
//				rhs_predexpr.getExpr().add(rhs_predexpr2);
//				basepred.setSetrhs(rhs_predexpr);
//			} else {
//				AttributeType LHSType = getTypeOf(lhsValue);
//				if (LHSType instanceof BoolType) {
//					boolExpr boolrhs = FormlFactory.eINSTANCE.createboolExpr();
//					boolrhs.setIsTrue("true");
//					basepred.setBoolrhs(boolrhs);
//				} else if (LHSType instanceof ReferenceType) {
//					if ((ReferenceType.class.cast(LHSType)).getRef() instanceof Enumeration) {
//						Enumeration enumClass = (Enumeration) ReferenceType.class.cast(LHSType).getRef();
//						if (enumClass != null) {
//							ExprRef eumconst = enumClass.getConstant().get(0);
//
//							predExpr rhs_predexpr = FormlFactory.eINSTANCE.createpredExpr();
//							predExpr2 rhs_predexpr2 = FormlFactory.eINSTANCE.createpredExpr2();
//							predExpr3 rhs_predexpr3 = FormlFactory.eINSTANCE.createpredExpr3();
//							setExprBase rhs_exprbase = FormlFactory.eINSTANCE.createsetExprBase();
//							atomic rhs_atom = FormlFactory.eINSTANCE.createatomic();
//							rhs_atom.setRef(eumconst);
//							rhs_exprbase.setAtom(rhs_atom);
//							rhs_predexpr3.setBase(rhs_exprbase);
//							rhs_predexpr2.getExpr().add(rhs_predexpr3);
//							rhs_predexpr.getExpr().add(rhs_predexpr2);
//							basepred.setSetrhs(rhs_predexpr);
//						}
//					}
//				}
//			}
//
//			basepred.setLogicop("=");
//			orpred.getPreds().add(basepred);
//			imppred.getPreds().add(orpred);
//			andpred.getPreds().add(imppred);
//			notpred.setPred(andpred);
//			pred.setQuantPred(notpred);
//			guard.setPredicate(pred);
//		} catch (Exception e) {
//			System.err.println("Guard could not be created. See ModelUtils2.");
//		}
		// return action;
	}

	// TODO: add other types of referrables
	public static void replaceAttributesInModel(EObject oldAtt, Attribute newAtt) {
		if (oldAtt != null && newAtt != null) {
			Collection<Setting> referres = ModelUtils2.getReferencesBySemanticType(oldAtt);

			if (!referres.isEmpty()) {

				Iterator<Setting> iter = referres.iterator();
				while (iter.hasNext()) {
					Setting it = iter.next();
					if (it.getEObject() instanceof atomic) {
						if (((atomic) it.getEObject()).getRef() == oldAtt) {
							((atomic) it.getEObject()).setRef(newAtt);
						}
					} else if (it.getEObject() instanceof WCE) {
						if (((WCE) it.getEObject()).getAttr() == oldAtt) {
							((WCE) it.getEObject()).setAttr(newAtt);

						}
					}
					// else if (it.getEObject() instanceof Action) {
					// if (((atomic) it.getEObject()).getRef() == oldAtt) {
					// ((atomic) it.getEObject()).setRef(newAtt);
					// }
					// }
				}
			}

		}

	}

	public static List<Roleable> getRoleablesReferredInStateMachine(EObject anElement) {

		java.util.List<Roleable> usedRoleables = new ArrayList<Roleable>();

		FeatureModule fm = null;
		if (anElement instanceof Transition) {
			fm = getTypedRootForObject(anElement, FeatureModule.class);
		} else if (anElement instanceof Roleable) {
			fm = getFeatureModuleForFeature((Roleable) anElement);
		}
		if (fm != null) {
			List<atomic> allAtomicContents = EcoreUtil2.getAllContentsOfType(fm, atomic.class);
			List<WCE> allWCEContents = EcoreUtil2.getAllContentsOfType(fm, WCE.class);
			List<Action> allActionContents = EcoreUtil2.getAllContentsOfType(fm, Action.class);

			for (atomic atom : allAtomicContents) {
				Roleable roleable = getTypedRootForObject(atom.getRef(), Roleable.class);
				if (roleable != null) {
					usedRoleables.add(roleable);
				}
			}

			for (WCE wce : allWCEContents) {
				if (wce.getAddobj() != null) {
					Roleable roleable = getTypedRootForObject(wce.getAddobj(), Roleable.class);
					if (roleable != null) {
						usedRoleables.add(roleable);
					}
				}
				if (wce.getRemobj() != null) {
					Roleable roleable = getTypedRootForObject(wce.getRemobj(), Roleable.class);
					if (roleable != null) {
						usedRoleables.add(roleable);
					}
				}

				if (wce.getAttr() != null) {
					Roleable roleable = getTypedRootForObject(wce.getAttr(), Roleable.class);
					if (roleable != null) {
						usedRoleables.add(roleable);
					}
				}
			}

			for (Action action : allActionContents) {
				if (action.getType() != null) {
					Roleable roleable = getTypedRootForObject(action.getType(), Roleable.class);
					if (roleable != null) {
						usedRoleables.add(roleable);
					}
				}

				if (action.getOut() != null) {
					Roleable roleable = getTypedRootForObject(action.getOut(), Roleable.class);
					if (roleable != null) {
						usedRoleables.add(roleable);
					}
				}
			}
		}

		return usedRoleables;
	}

	public static CustomVirtualResource createVirtualOriginalResource(EObject element) {
		return new CustomVirtualResource(element);

	}

	public static FeatureNode getCorrespondingFeatureNode(Feature roleable) {

		Collection<Setting> crossRefs = findReferencedObjects(roleable, WORLD_MODEL);
		Iterator<Setting> it = crossRefs.iterator();

		while (it.hasNext()) {
			EObject eobj = it.next().getEObject();
			if (eobj instanceof FeatureNode) {
				return (FeatureNode) eobj;
			}
		}
		return null;
	}

	public static FeatureModule getFragmentFeatureModule(State selectedState) {
		BehaviourModel behaviouralModel = getBehaviourModel(selectedState);

		for (FeatureModule fm : behaviouralModel.getFeaturemodules()) {
			for (Fragment frag : fm.getFragments()) {
				for (FragmentType ft : frag.getFragmentType()) {
					if (ft.getState().getRef() == selectedState) {
						return fm;
					}
				}
			}
		}

		return null;

	}

	public static Roleable getRoleableForFaetureModule(FeatureModule featureModule) {
		Roleable featureRef = featureModule.getFeatureref();
		return featureRef;
	}

	public static Roleable GetRoleable(EObject t) {
		if (t instanceof Roleable)
			return (Roleable) t;
		else if (t instanceof FeatureNode) {
			return (Roleable) ((FeatureNode) t).getFeature();
		} else if (t instanceof State) {
			FeatureModule refFeatureModule = getFragmentFeatureModule((State) t);
			if (refFeatureModule != null) {
				return (Roleable) refFeatureModule.getFeatureref();
			}

		}

		return null;
	}

	/**
	 * Returns a copy of the given eObject.
	 * 
	 * @param eObject the object to copy.
	 * @return the copy.
	 */
	public static EObject copy(EObject src, EObject copyEObject, List<String> attributeNamesToIgnore) {
		if (src == null) {
			return null;
		} else {

			// EObject copyEObject =
			// src.eClass().getEPackage().getEFactoryInstance().create(src.eClass());
			EClass eClass = src.eClass();
			for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
				EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);

				if (attributeNamesToIgnore.contains(eStructuralFeature.getName().toLowerCase().trim()))
					continue;

				if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {

					if (eStructuralFeature instanceof EAttribute) {
						copyAttribute((EAttribute) eStructuralFeature, src, copyEObject);
					} else {
						EReference eReference = (EReference) eStructuralFeature;

						if (eReference.isContainment()) {
							copyContainment(eReference, src, copyEObject);
						}
					}
				}
			}

			copyProxyURI(src, copyEObject);

			return copyEObject;
		}
	}

}
//getting used roleables for FeatureNode Focus+Context
//		if (isForRoleableFPC) {
//			if (anElement instanceof Roleable) {
//				java.util.List<Roleable> directRoleables = AssociationUtils.getAssociatedEntities((Roleable) anElement);
//				usedRoleables.addAll(directRoleables);
//			}
//
//		}
