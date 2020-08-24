package uw.cs.watform.forml.services.delete;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.services.internal.MessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelDeleteOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * This is a java service class used in Sirius to handle deleting entities on
 * Feature Models.
 * 
 * 
 * @author ppourali
 * 
 */
public class JS_Action_Delete_On_FeatureModel {

	// Confirm if the user wants to delete a feature node and its children
	// feature node
	public static boolean confirmFeatureDelete(EObject t) {
		Feature feature_to_be_deleted = null;
		if (t instanceof FeatureNode)
			feature_to_be_deleted = ((FeatureNode) t).getFeature();

		if (ModelUtils.getFeatureModuleForFeature(feature_to_be_deleted) != null || t instanceof OrNode
				|| t instanceof XORNode || t instanceof AndNode) {
			int dialogResult = MessageDialogs.ConfirmDeleteAllContainingFeatureNodes();
			if (dialogResult == 0)
				return true;
			else
				return false;
		}

		return true;

	}

	// Delete feature node
	public static void Delete_FeatureNode(EObject t) {
		Feature feature_to_be_deleted = ((Feature) t);

		// removing feature out of the tos list of any message pointing to it
		for (RefMessage refmsg : feature_to_be_deleted.getInputlist().getInputs()) {
			Input im = (Input) refmsg.getRefMsg();

			(im).getTos().remove(feature_to_be_deleted);

			if (im.getTos().isEmpty())
				ModelUtils.getWorldModel(feature_to_be_deleted).getConcepts().remove(im);
		}

		// removing feature out of the froms list of any message pointing to it
		for (RefMessage refmsg : feature_to_be_deleted.getOutputlist().getOutputs()) {
			Output om = (Output) refmsg.getRefMsg();

			(om).getFroms().remove(feature_to_be_deleted);

			if (om.getFroms().isEmpty())
				ModelUtils.getWorldModel(feature_to_be_deleted).getConcepts().remove(om);

		}

		ModelDeleteOperations.removeFeatureModuleFromBehaviouralModel(feature_to_be_deleted);

		EcoreUtil2.remove(feature_to_be_deleted);

	}

}
