package uw.cs.watform.forml.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class JS_ValidationFeatureModel {

	/*
	 * validate if all the or nodes have at least two children
	 */
	public static boolean validate_OrNodesWithLessThanTwoChildren(EObject t) {

		OrNode f = (OrNode) (t);

		List<Node> featureNodes = f.getFeatureNodes();

		if (featureNodes.size()<2)
			return false;

		return true;
	}
	
	/*
	 * validate if all the or nodes have at least two children
	 */
	public static boolean validate_XOrNodesWithLessThanTwoChildren(EObject t) {

		XORNode f = (XORNode) (t);

		List<Node> featureNodes = f.getFeatureNodes();

		if (featureNodes.size()<2)
			return false;

		return true;
	}
	
	/*
	 * validate if all the and nodes have at least two children
	 */
	public static boolean validate_AndNodesWithLessThanTwoChildren(EObject t) {

		AndNode f = (AndNode) (t);

		List<Node> featureNodes = f.getFeatureNodes();

		if (featureNodes.size()<2)
			return false;

		return true;
	}

}
