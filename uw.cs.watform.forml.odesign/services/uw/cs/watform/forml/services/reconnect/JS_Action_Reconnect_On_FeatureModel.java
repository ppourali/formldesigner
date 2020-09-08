package uw.cs.watform.forml.services.reconnect;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.XORNode;

/**
 * This is a java service class used in Sirius to handle reconnecting entities
 * on Feature Models.
 * 
 * 
 * @author ppourali
 * 
 */
public class JS_Action_Reconnect_On_FeatureModel {

	public static void Reconnect_Nodes(EObject movedFetureNode, EObject oldParent, EObject newParent) {
		if (oldParent == newParent)
			return;

		if (newParent instanceof OrNode || newParent instanceof XORNode || newParent instanceof AndNode)
			if (movedFetureNode instanceof OrNode || movedFetureNode instanceof XORNode || movedFetureNode instanceof AndNode)
				return;

		if (EcoreUtil2.isAncestor(movedFetureNode, newParent))
			return;

		Reconnect_to_FeatureNode(movedFetureNode, oldParent, newParent);
	}

	public static void Reconnect_to_FeatureNode(EObject child, EObject source, EObject target) {

		if (target instanceof SPL) {
			setNewTarget(child, (SPL) target);
		} else if (target instanceof FeatureNode) {
			setNewTarget(child, (FeatureNode) target);
		} else if (target instanceof OrNode || target instanceof XORNode || target instanceof AndNode) {
			setNewTarget(child, (Node) target);
		}
		refineSource((Node)source);

	}

	private static void refineSource(Node source) {
		if (source instanceof OrNode || source instanceof XORNode || source instanceof AndNode) {
			
			if ( source.getFeatureNodes().size() < 2)
			{
				Node sourceParentNode=(Node) source.eContainer();
				sourceParentNode.getFeatureNodes().addAll(source.getFeatureNodes());
				EcoreUtil2.remove(source);
			}
				
		}

	}

	private static void setNewTarget(EObject child, Node target) {
		if (child instanceof FeatureNode) {
			EcoreUtil2.remove(child);
			target.getFeatureNodes().add((FeatureNode) child);
		}
	}

	private static void setNewTarget(EObject child, SPL target) {

		if (child instanceof OrNode) {
			EcoreUtil2.remove(child);
			target.getOrs().add((OrNode) child);

		} else if (child instanceof XORNode) {
			EcoreUtil2.remove(child);
			target.getXors().add((XORNode) child);

		} else if (child instanceof AndNode) {
			EcoreUtil2.remove(child);
			target.getAnds().add((AndNode) child);
		} else if (child instanceof FeatureNode) {
			EcoreUtil2.remove(child);
			target.getFeatureNodes().add((FeatureNode) child);
		}
	}

	private static void setNewTarget(EObject child, FeatureNode target) {
		if (child instanceof OrNode) {
			// EcoreUtil2.remove(child);
			// EcoreUtil2.
			target.getOrs().add((OrNode) child);

		} else if (child instanceof FeatureNode) {
			// EcoreUtil2.remove(child);
			target.getFeatureNodes().add((FeatureNode) child);
		}
	}

	public static void ReconnectLogicalNodes(EObject child, EObject target) {
		if (target instanceof SPL) {
			((SPL) target).getOrs().add((OrNode) child);
		} else if (target instanceof FeatureNode) {
			((FeatureNode) target).getOrs().add((OrNode) child);
		}
	}
}
