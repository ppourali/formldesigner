package uw.cs.watform.forml.services.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.XORNode;

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
