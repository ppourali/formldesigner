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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.UndefinedType;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.atomic;

@SuppressWarnings("unchecked")
public class ModelUtils extends AbstractModelUtils {

	public static <T extends EObject> T getTypedRootForObject(EObject childInstance, Class<T> type) {
		return (EcoreUtil2.getContainerOfType(childInstance, type));
	}

	public static <T extends EObject> List<T> getWorldModelObjectsByType(EObject modelObject, Class<T> type) {
		if (WORLD_MODEL == null) {
			setWorldModel(modelObject);
		}

		return EcoreUtil2.getAllContentsOfType(WORLD_MODEL, type);
	}

	public static <T extends EObject> List<T> getObjectsByTypeInAnObjectType(EObject child, Class parentType,
			Class<T> returnChildrenType) {
		EObject parent = EcoreUtil2.getContainerOfType(child, parentType);

		return EcoreUtil2.getAllContentsOfType(parent, returnChildrenType);
	}

	public static <T extends EObject> List<T> getObjectsByTypeInAnObjectElement(EObject parentObject,
			Class<T> returnChildrenType) {
		return EcoreUtil2.getAllContentsOfType(parentObject, returnChildrenType);
	}

	public static SPL getOrCreateSPLRoot(EObject modelObject) {
		if (WORLD_MODEL == null) {
			setWorldModel(modelObject);
		}
		List<SPL> spls = EcoreUtil2.getAllContentsOfType(WORLD_MODEL, SPL.class);
		SPL spl;
		if (spls.size() > 0)
			spl = spls.get(0);
		else {
			spl = FormlFactory.eINSTANCE.createSPL();
			spl.setName("spl");
			WORLD_MODEL.getConcepts().add(spl);
		}

		return spl;
	}

	public static SPL getSPLRoot(EObject modelObject) {
		if (WORLD_MODEL == null) {
			setWorldModel(modelObject);
		}
		List<SPL> spls = EcoreUtil2.getAllContentsOfType(WORLD_MODEL, SPL.class);
		SPL spl;
		if (spls.size() > 0)
			spl = spls.get(0);
		else {
			spl = FormlFactory.eINSTANCE.createSPL();
			spl.setName("spl");
			WORLD_MODEL.getConcepts().add(spl);
		}

		return spl;
	}

	public static <T extends EObject> List<T> getBehaviourModelObjectsByType(EObject modelObject, Class<T> type) {
		if (BEHAVIOUR_MODEL == null) {
			setBehaviourModel(modelObject);
		}
		return EcoreUtil2.getAllContentsOfType(BEHAVIOUR_MODEL, type);
	}

	public static List<EObject> getFeaturesWithoutFeatureModules(EObject modelObject) {
		if (WORLD_MODEL == null) {
			setWorldModel(modelObject);
		}

		if (BEHAVIOUR_MODEL == null) {
			setBehaviourModel(modelObject);
		}

		List<Feature> allFeatures = getWorldModelObjectsByType(WORLD_MODEL, Feature.class);
		List<FeatureModule> allFeatureModules = getBehaviourModelObjectsByType(BEHAVIOUR_MODEL, FeatureModule.class);

		List<EObject> featuresNoFeatureModule = new ArrayList<EObject>();
		featuresNoFeatureModule.addAll(allFeatures);

		for (EObject f : allFeatures) {
			for (EObject fm : allFeatureModules) {
				if (((FeatureModule) fm).getFeatureref().equals((Feature) f)) {
					featuresNoFeatureModule.remove(f);
					break;
				}
			}
		}

		return featuresNoFeatureModule;
	}

	public static FeatureModule getFeatureModuleForFeature(Roleable feature) {
		if (WORLD_MODEL == null) {
			setWorldModel(feature);
		}
		List<Roleable> allFeatures = getWorldModelObjectsByType(WORLD_MODEL, Roleable.class);
		List<FeatureModule> allFeatureModules = getBehaviourModelObjectsByType(WORLD_MODEL, FeatureModule.class);

		for (EObject fm : allFeatureModules) {
			if (((FeatureModule) fm).getFeatureref().equals(feature)) {
				return (FeatureModule) fm;
			}
		}
		return null;
	}

	public static int getNumberOfUsesForMessage(Message msg) {

		if (msg instanceof Input)
			return ((Input) msg).getTos().size();
		else if (msg instanceof Output)
			return ((Output) msg).getFroms().size();

		return 0;
	}

	public static String getTextForModelObjects(EObject any) {
		// System.out.println(any.eResource() instanceof XtextResource);

		// XtextSourceViewer viewer = xTextEmbeddedEditor.getViewer();
		// if (viewer.canDoOperation(ISourceViewer.FORMAT)) {
		// viewer.doOperation(ISourceViewer.FORMAT);
		// }

		if (any != null && any.eResource() instanceof XtextResource && any.eResource().getURI() != null) {
			//
			// IResourceFactory resourceFactory = getInjector()
			// .getInstance(IResourceFactory.class);
			// // Create virtual resource
			// XtextResource xtextVirtualResource = (XtextResource)
			// resourceFactory
			// .createResource(URI.createURI(any.eResource().getURI().toString()));
			//

			// try {
			//
			// // Populate virtual resource with the given semantic element to
			// edit
			// xtextVirtualResource.getContents().add(ModelUtils.rootFinderForSystem(any));
			//
			// // Save and reparse in order to initialize virtual Xtext resource
			// ByteArrayOutputStream out = new ByteArrayOutputStream();
			// xtextVirtualResource.save(out,
			// SaveOptions.newBuilder().format().getOptions().toOptionsMap());
			// xtextVirtualResource.reparse(new String(out.toByteArray()));
			//
			// xtextVirtualResource.relink();
			//
			//
			// ICompositeNode node = //
			// NodeModelUtils.getNode(any.eContainer());
			// if (node != null) {
			//
			// return NodeModelUtils.getTokenText(node);//node.getText();
			//
			// }
			//
			//
			// //((XtextResource)any.eResource()).reparse(new
			// String(out.toByteArray()));
			// } catch (IOException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			// String fileURI = any.eResource().getURI().toPlatformString(true);
			// IFile workspaceFile = ResourcesPlugin.getWorkspace().getRoot()
			// .getFile(new Path(fileURI));
			// if (workspaceFile != null) {

			try {
				Serializer ser = getInjector().getInstance(Serializer.class);
				String s = ser.serialize(any);
				return s.trim();
				// ICompositeNode rootNode =
				// ((XtextResource)any.eResource()).getParseResult().getRootNode();
				// String allText = rootNode.getText();
				// ICompositeNode elementNode = NodeModelUtils
				// .findActualNodeFor((any));
				// String editablePart =
				// allText.substring(elementNode.getOffset(),
				// elementNode.getEndOffset());
				// return editablePart;

				// ICompositeNode node = //
				// NodeModelUtils.findActualNodeFor(any);
				// if (node != null) {
				//
				// return NodeModelUtils.getTokenText(node);//node.getText();
				//
				// }
			} catch (Exception e) {
				e.printStackTrace();
			}
			// }
		}

		return "";
	}

	public static int getNumberOfInputMessage(EObject modelElement) {

		int size = 0;

		try {
			size = getInputMessages(modelElement).size();
		} catch (Exception e) {
			size = 0;
		}
		return size;
	}

	public static List<Input> getInputMessages(EObject modelElement) {

		try {
			return getWorldModelObjectsByType(modelElement, Input.class);
		} catch (Exception e) {
			return null;
		}
	}

	public static int getNumberOfAttributesForFeature(Feature feature) {

		int size = 0;

		try {
			size = feature.getAttributes().size();
		} catch (Exception e) {
			size = 0;
		}
		return size;
	}

	public static int getNumberOfAttributesForEntity(Entity entity) {

		int size = 0;

		try {
			size = entity.getAttributes().size();
		} catch (Exception e) {
			size = 0;
		}
		return size;
	}

	public static int getNumberOfOutputMessage(EObject modelElement) {

		int size = 0;

		try {
			size = getOutputMessages(modelElement).size();
		} catch (Exception e) {
			size = 0;
		}
		return size;
	}

	public static List<Output> getOutputMessages(EObject modelElement) {

		try {
			return getWorldModelObjectsByType(modelElement, Output.class);
		} catch (Exception e) {
			return null;
		}
	}

	public static UndefinedType getUndefinedTypeInWorldModel(EObject modelElement) {

		List<UndefinedType> uTypes = getWorldModelObjectsByType(modelElement, UndefinedType.class);

		if (uTypes.isEmpty()) {
			UndefinedType ut = FormlFactory.eINSTANCE.createUndefinedType();
			ut.setName("void");

			WORLD_MODEL.getConcepts().add(ut);

			return ut;
		} else {
			return uTypes.get(0);
		}

//		WorldModel wm = getWorldModel(modelElement);
//
//		for (ExprRef con : wm.getConcepts()) {
//			if (con instanceof UndefinedType) {
//				return (UndefinedType) con;
//			}
//		}
//
//		UndefinedType ut = FormlFactory.eINSTANCE.createUndefinedType();
//		ut.setName("void");
//
//		WORLD_MODEL.getConcepts().add(ut);
//
//		return ut;

	}

	public static ReferenceType getReferencedType(Concept modelElement) {

		ReferenceType reft = FormlFactory.eINSTANCE.createReferenceType();
		reft.setRef(modelElement);

		return reft;

	}

	public static List<Roleable> GetRelatedIncomingOutGoingRoleables(State modelElement) {

		List<Roleable> allRelatedRoleables = new ArrayList<Roleable>();

		FeatureModule parentFeatureModule = getTypedRootForObject(modelElement, FeatureModule.class);
		Roleable currentRoleable = parentFeatureModule.getFeatureref();

		List<Transition> transitions = ModelUtils2.getObjectsByTypeInAnObjectElement(parentFeatureModule,
				Transition.class);

		List<Transition> connectedTransitions = new ArrayList<Transition>();

		for (Transition tr : transitions) {
			if (tr.getDst().equals(modelElement) || tr.getSrc().equals(modelElement))
				connectedTransitions.add(tr);
		}

		for (Transition con_tr : connectedTransitions) {
			List<Roleable> relatedRoleables = GetRelatedRoleables(con_tr);
			allRelatedRoleables.addAll(relatedRoleables);
		}

		allRelatedRoleables.add(currentRoleable);

		return allRelatedRoleables;
	}

	public static List<Roleable> GetRelatedRoleables(Transition modelElement) {
		List<Roleable> allRelatedRoleables = new ArrayList<Roleable>();

		FeatureModule parentFeatureModule = getTypedRootForObject(modelElement, FeatureModule.class);
		Roleable currentRoleable = parentFeatureModule.getFeatureref();

		List<Roleable> relatedRoleables = GetRoleablesInTransitionSegments(modelElement);

		allRelatedRoleables.addAll(relatedRoleables);
		allRelatedRoleables.add(currentRoleable);

		return allRelatedRoleables;
	}

	private static List<Roleable> GetRoleablesInTransitionSegments(Transition transition) {
		List<atomic> allAtomicContents = EcoreUtil2.getAllContentsOfType(transition, atomic.class);
		List<WCE> allWCEContents = EcoreUtil2.getAllContentsOfType(transition, WCE.class);
		List<Action> allActionContents = EcoreUtil2.getAllContentsOfType(transition, Action.class);

		List<Roleable> usedRoleables = new ArrayList<Roleable>();
		for (atomic atom : allAtomicContents) {
			Roleable roleable = getTypedRootForObject(atom.getRef(), Roleable.class);
			if (roleable != null) {
				usedRoleables.add(roleable);
			}
		}
		
		

		for (WCE wce : allWCEContents) {
			//ReferenceType a = getReferencedType((Concept) wce.getAddobj());
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
		return usedRoleables;
	}

}
