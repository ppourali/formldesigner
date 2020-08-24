package uw.cs.watform.forml.services.general;

import java.util.Collection;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.sirius.business.internal.extender.EcoreIntrinsicMetamodelDescriptorProvider;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;

import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class JS_CrossReferenceServices {

	public static boolean hasCrossReferences(EObject t) {
		
		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(t);
		if (referrers == null || referrers.isEmpty())
			return false;

		return true;
	}
}
