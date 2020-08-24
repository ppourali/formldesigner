package uw.cs.watform.forml.services.rename;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.FeatureNode;

/**
 * This is a java service class used in Sirius to handle renaming entities on
 * Feature Model.
 * 
 * 
 * @author ppourali
 * 
 */

public class JS_Action_Rename_On_FeatureModel {

	public static boolean Rename_FeatureNode(EObject t, String newName)
	{
		newName=newName.replace(" ", "");

		if(NameUniquenessVerifier.verify(((FeatureNode)t).getFeature(), newName, true))
		{
			((FeatureNode)t).getFeature().setName(newName);
			return true;
		}
		
		return false;
	}	
	
}
