package uw.cs.watform.forml.services.general;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;

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
