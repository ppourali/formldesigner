package uw.cs.watform.forml.services.general;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * All the services related to Constraints in WorldModel and FeatureModules.
 * 
 * 
 * @author ppourali
 */
public class JS_ConstraintServices {

	/**
	 *  
	 * @param constraint
	 * Model object to be returned as text.
	 * 
	 * @return 
	 * Constraint text in the XText file.
	 */
	public String getConstraintsText(EObject constraint) {
		return ModelUtils.getTextForModelObjects(constraint);
	}
}
