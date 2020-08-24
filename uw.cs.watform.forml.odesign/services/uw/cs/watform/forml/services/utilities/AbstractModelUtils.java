package uw.cs.watform.forml.services.utilities;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.xtext.resource.SaveOptions;

import com.google.common.collect.Maps;
import com.google.inject.Injector;

import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.impl.SystemImpl;
import uw.cs.watform.forml.ui.internal.FormlActivator;

public abstract class AbstractModelUtils {
	public static WorldModel WORLD_MODEL;
	public static BehaviourModel BEHAVIOUR_MODEL;
	public static System SYSTEM;

	/**
	 * Return the Injector associated to you domain model plug-in.
	 * 
	 * @return
	 */
	public static Injector getInjector() {
		return FormlActivator.getInstance().getInjector(FormlActivator.UW_CS_WATFORM_FORML_FORML);
	}

	public static void setSystem(EObject modelObject) {
		try {
			SYSTEM = ((System) EcoreUtil.getRootContainer(modelObject));
			if (SYSTEM == null && modelObject !=null) {
				for (EObject eObj : modelObject.eCrossReferences()) {
					if (eObj.getClass() == SystemImpl.class) {
						SYSTEM = (System) eObj;
						
						return;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setWorldModel(EObject modelObject) {
		try {
			WORLD_MODEL = ((System) EcoreUtil.getRootContainer(modelObject)).getWorldmodel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setBehaviourModel(EObject modelObject) {
		try {
			BEHAVIOUR_MODEL = ((System) EcoreUtil.getRootContainer(modelObject)).getBehaviourmodel();

			// create Behaviour model if does not exists
			if (BEHAVIOUR_MODEL == null && ((System) EcoreUtil.getRootContainer(modelObject)) != null) {
				BehaviourModel newBehaviouralModel = FormlFactory.eINSTANCE.createBehaviourModel();
				((System) EcoreUtil.getRootContainer(modelObject)).setBehaviourmodel(newBehaviouralModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setSystemWorldBehaviour(EObject modelObject) {
		setSystem(modelObject);
		setWorldModel(modelObject);
		setBehaviourModel(modelObject);
	}

	public static System getSystem(EObject modelObject) {
		if (SYSTEM == null) {
			setSystem(modelObject);
		}

		return SYSTEM;
	}

	public static WorldModel getWorldModel(EObject modelObject) {
		if (WORLD_MODEL == null) {
			setWorldModel(modelObject);
		}
		return WORLD_MODEL;
	}

	public static BehaviourModel getBehaviourModel(EObject modelObject) {
		if (BEHAVIOUR_MODEL == null) {
			setBehaviourModel(modelObject);
		}
		return BEHAVIOUR_MODEL;
	}

	public static void CreateConstraints(EObject modelObject) {

		boolean isResourceChanged = false;

		if (WORLD_MODEL == null) {
			if (modelObject != null)
				setWorldModel(modelObject);
		}

		if (BEHAVIOUR_MODEL == null) {
			if (modelObject != null)
				setBehaviourModel(modelObject);
		}

		if (WORLD_MODEL != null) {
			if (WORLD_MODEL.getConstraints() == null) {
				Constraint newCons = FormlFactory.eINSTANCE.createConstraint();
				WORLD_MODEL.setConstraints(newCons);
				isResourceChanged = true;
			}
		}

		if (BEHAVIOUR_MODEL != null) {
			for (FeatureModule fm : BEHAVIOUR_MODEL.getFeaturemodules()) {
				if (fm.getConstraints() == null) {
					Constraint newCons = FormlFactory.eINSTANCE.createConstraint();
					fm.setConstraints(newCons);
					isResourceChanged = true;
				}
			}
		}

		if (isResourceChanged)
			saveResource();

	}

	public static void saveResource() {
		if (SYSTEM != null) {
			Map<Object, Object> newOptions = Maps.newHashMap();

			newOptions.putAll(SaveOptions.newBuilder().format().getOptions().toOptionsMap());

			try {
				SYSTEM.eResource().save(newOptions);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected static void copyProxyURI(EObject eObject, EObject copyEObject) {
		if (eObject.eIsProxy()) {
			((InternalEObject) copyEObject).eSetProxyURI(((InternalEObject) eObject).eProxyURI());
		}
	}

	/**
	 * Called to handle the copying of an attribute; this adds a list of values or
	 * sets a single value as appropriate for the multiplicity.
	 * 
	 * @param eAttribute  the attribute to copy.
	 * @param eObject     the object from which to copy.
	 * @param copyEObject the object to copy to.
	 */
	protected static void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eAttribute)) {
			if (FeatureMapUtil.isFeatureMap(eAttribute)) {
				FeatureMap featureMap = (FeatureMap) eObject.eGet(eAttribute);
				for (int i = 0, size = featureMap.size(); i < size; ++i) {
					EStructuralFeature feature = featureMap.getEStructuralFeature(i);
					if (feature instanceof EReference && ((EReference) feature).isContainment()) {
						Object value = featureMap.getValue(i);
						if (value != null) {
							copy((EObject) value);
						}
					}
				}
			} else if (eAttribute.isMany()) {
				List<?> source = (List<?>) eObject.eGet(eAttribute);
				@SuppressWarnings("unchecked")
				List<Object> target = (List<Object>) copyEObject.eGet(getTarget(eAttribute));
				if (source.isEmpty()) {
					target.clear();
				} else {
					target.addAll(source);
				}
			} else {
				copyEObject.eSet(getTarget(eAttribute), eObject.eGet(eAttribute));
			}
		}
	}

	/**
	 * Returns the target class used to create a copy instance for objects of the
	 * given source class.
	 * 
	 * @param eClass the source class.
	 * @return the target class used to create a copy instance.
	 * @see #getTarget(EStructuralFeature)
	 */
	protected static EClass getTarget(EClass eClass) {
		return eClass;
	}

	/**
	 * Returns the target feature used to populate a copy instance from the given
	 * source feature.
	 * 
	 * @param eStructuralFeature the source feature.
	 * @return the target feature used to populate a copy instance.
	 * @see #getTarget(EClass)
	 */
	protected static EStructuralFeature getTarget(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature;
	}

	/**
	 * Returns a self-contained copy of the eObject.
	 * 
	 * @param eObject the object to copy.
	 * @return the copy.
	 * @see Copier
	 */
	public static <T extends EObject> T copy(T eObject) {
		Copier copier = new Copier();
		EObject result = copier.copy(eObject);
		copier.copyReferences();

		@SuppressWarnings("unchecked")
		T t = (T) result;
		return t;
	}

	/**
	 * Returns a collection of the self-contained copies of each {@link EObject} in
	 * eObjects.
	 * 
	 * @param eObjects the collection of objects to copy.
	 * @return the collection of copies.
	 * @see Copier
	 */
	public static <T> Collection<T> copyAll(Collection<? extends T> eObjects) {
		Copier copier = new Copier();
		Collection<T> result = copier.copyAll(eObjects);
		copier.copyReferences();
		return result;
	}

	/**
	 * Called to handle the copying of a containment feature; this adds a list of
	 * copies or sets a single copy as appropriate for the multiplicity.
	 * 
	 * @param eReference  the feature to copy.
	 * @param eObject     the object from which to copy.
	 * @param copyEObject the object to copy to.
	 */
	protected static void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eReference)) {
			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> source = (List<EObject>) eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				List<EObject> target = (List<EObject>) copyEObject.eGet(getTarget(eReference));
				if (source.isEmpty()) {
					target.clear();
				} else {
					target.addAll(copyAll(source));
				}
			} else {
				EObject childEObject = (EObject) eObject.eGet(eReference);
				copyEObject.eSet(getTarget(eReference), childEObject == null ? null : copy(childEObject));
			}
		}
	}

}
