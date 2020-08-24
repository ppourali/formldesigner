package uw.cs.watform.forml.services.general;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.sirius.business.internal.extender.EcoreIntrinsicMetamodelDescriptorProvider;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;

public class JS_AnnotationServices {

	public static void createDAnnotation(EObject t)
	{
		JOptionPane.showMessageDialog(null, t);
//		AnnotationEntry annot = DescriptionFactory.eINSTANCE.createAnnotationEntry();
//		annot.setSource("AssociationClass");
//		
//		EAttribute value = EcoreFactory.eINSTANCE.createEAttribute();
//		value.setEType(EcorePackage.Literals.EBOOLEAN);
//		value.setDefaultValue(false);
//		annot.setData(value);
//		
		
		
		//DSemanticDiagram.class.getAnnotations()
		//annot.setSource("My Very Special Source");
		//annot..put("ShowAssociationClasses", Boolean.TRUE.toString());
		//DSemanticDiagram.getDAnnotations().add(annot);
	}
}
