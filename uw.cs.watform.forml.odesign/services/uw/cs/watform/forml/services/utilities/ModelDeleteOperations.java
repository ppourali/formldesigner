package uw.cs.watform.forml.services.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.Relationship;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WorldModel;

public class ModelDeleteOperations extends ModelOperations2 {

	public static void removeMessageFromFeature(Feature parentFeature, RefMessage refMessage) {

		Message Msg = refMessage.getRefMsg();

		if (Msg instanceof Input) {
			parentFeature.getInputlist().getInputs().remove(refMessage);
			((Input) Msg).getTos().remove(parentFeature);

			if (((Input) Msg).getTos().size() == 0)
				getWorldModel(parentFeature).getConcepts().remove(Msg);
		}

		else if (Msg instanceof Output) {
			parentFeature.getOutputlist().getOutputs().remove(refMessage);
			((Output) Msg).getFroms().remove(parentFeature);

			if (((Output) Msg).getFroms().size() == 0)
				getWorldModel(parentFeature).getConcepts().remove(Msg);
		}
	}

	public static void removeMessageFromFeature(Feature parentFeature, Message Msg, RefMessage refMsg) {
		List<EObject> deletingList = new ArrayList<EObject>();
		if (Msg instanceof Input) {
			for (RefMessage rm : parentFeature.getInputlist().getInputs()) {
				if (rm.getRefMsg() == Msg) {
					deletingList.add(rm);
				}
			}

			((Input) Msg).getTos().remove(parentFeature);

			if (((Input) Msg).getTos().size() == 0)
				getWorldModel(parentFeature).getConcepts().remove(Msg);
		}

		else if (Msg instanceof Output) {
			for (RefMessage rm : parentFeature.getOutputlist().getOutputs()) {
				if (rm.getRefMsg() == Msg) {
					deletingList.add(rm);
				}
			}
			((Output) Msg).getFroms().remove(parentFeature);

			if (((Output) Msg).getFroms().size() == 0)
				getWorldModel(parentFeature).getConcepts().remove(Msg);
		}
		for (EObject de : deletingList) {
			EcoreUtil2.remove(de);
		}

	}

	public static void removeMessageFromWorldModel(Message message) {
		try {
			EcoreUtil2.remove(message);
			// getWorldModel(message).getConcepts().remove(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeFeatureModuleFromBehaviouralModel(Feature feature_to_be_deleted) {
		ModelUtils.getBehaviourModel(feature_to_be_deleted).getFeaturemodules()
				.remove(ModelUtils.getFeatureModuleForFeature(feature_to_be_deleted));

	}

	public static void removeConstraints(EObject container) {
		if (container instanceof FeatureModule)
			EcoreUtil2.remove(((FeatureModule) container).getConstraints());
		else if (container instanceof WorldModel)
			EcoreUtil2.remove(((WorldModel) container).getConstraints());

	}

	public static void deleteTransition(Transition deletingTrans) {
		EcoreUtil.remove(deletingTrans);
	}

	public static void deleteState(State deletingState) {
		EcoreUtil.remove(deletingState);
	}

	public static void deleteRegion(Region deletingRegion) {
		EcoreUtil.remove(deletingRegion);
	}

	public static void deleteElement(EObject deletingElement) {
		if (deletingElement instanceof RefMessage) {
			Feature parentFeature = ModelUtils.getTypedRootForObject(deletingElement, Feature.class);
			removeMessageFromFeature(parentFeature, (RefMessage) deletingElement);
		} else if (deletingElement instanceof Roleable) {
			List<Relationship> associations = AssociationUtils.getBiDirectedAssociations((Roleable) deletingElement);
			for (Relationship rel : associations) {
				EcoreUtil2.remove(rel);
			}
			EcoreUtil2.remove(deletingElement);
		} else {
			EcoreUtil2.remove(deletingElement);
		}

	}

}
