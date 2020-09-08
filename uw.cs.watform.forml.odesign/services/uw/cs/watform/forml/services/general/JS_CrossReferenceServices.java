package uw.cs.watform.forml.services.general;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;

import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class JS_CrossReferenceServices {

	public static boolean hasCrossReferences(EObject t) {
		
		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(t);
		if (referrers == null || referrers.isEmpty())
			return false;

		return true;
	}
}
