package uw.cs.watform.forml.services.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.DNodeListElement;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class JS_ValidationClassDiagram {

	// /*
	// * validate if all the Entities have at least one association connection
	// */
	// public static boolean validate_EntitiesWithoutReferrers(EObject t) {
	// List<Role> AllRoles = ModelUtils.getObjectsByTypeInAnObjectType(t,
	// WorldModel.class, Role.class);
	// List<Decl> AllDecls = ModelUtils.getObjectsByTypeInAnObjectType(t,
	// WorldModel.class, Decl.class);
	//
	// for (Role r : AllRoles) {
	// if (r.getType() != null) {
	// if (r.getType().equals(t))
	// return true;
	// }
	// }
	//
	// for (Decl d : AllDecls) {
	// if (d.getType() != null) {
	// if (d.getType().equals(t))
	// return true;
	// }
	// }
	//
	// return false;
	// }

	/*
	 * validate if all the Features have at least one referrer
	 */
	public static boolean validate_FeaturesWithoutReferrers(EObject t) {
		Roleable roleable = null;

		if (t instanceof DNodeContainerSpec) {
			if (((DNodeContainerSpec) t).getTarget() instanceof Roleable) {
				roleable = (Roleable) ((DNodeContainerSpec) t).getTarget();
			}

		} else if (t instanceof Roleable) {
			roleable = (Roleable) t;
		}

		if (roleable != null) {
			Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(roleable);

			if (referrers.size() == 0)
				return false;
			else
				return true;
		}

		return false;
	}

	/*
	 * validate if all the Entities have at least one referrer
	 */
	public static boolean validate_EntitiesWithoutReferrers(EObject t) {

		Entity entity = (Entity) ((DNodeContainerSpec) t).getTarget();

		Collection<Setting> referrers = ModelUtils2.getReferencesForEntity(entity);

		// Feature f=(Feature) ((DNodeContainerSpec)t).getTarget();

		if (referrers.size() == 0)
			return false;
		else
			return true;

	}

	public static boolean validate_FeaturesWithoutFeatureModules(EObject t) {

		Feature feature = (Feature) ((DNodeContainerSpec) t).getTarget();

		if (RepresentationsUtils.isFeatureModuleExists(feature))
			return false;
		else
			return true;

	}

	public static boolean validate_MessagesWithoutReferrers(EObject t) {

		RefMessage message = (RefMessage) ((DNodeListElement) t).getTarget();

		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(message.getRefMsg());

		// Feature f=(Feature) ((DNodeContainerSpec)t).getTarget();

		if (referrers.size() == 0)
			return false;
		else
			return true;

	}

	public static boolean validate_AttributesWithoutReferrers(EObject t) {

		Attribute att = (Attribute) ((DNodeListElement) t).getTarget();

		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(att);

		// Feature f=(Feature) ((DNodeContainerSpec)t).getTarget();

		if (referrers.size() == 0)
			return false;
		else
			return true;

	}

}
