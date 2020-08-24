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

public class JS_GeneralServices {

	public static boolean isNull(EObject t)
	{
		return (t==null);
	}
	
	public static boolean notNull(EObject t)
	{
		return !(t==null);
	}
}
