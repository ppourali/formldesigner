package uw.cs.watform.forml.services.rename;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * This is a java service class used in Sirius to make sure the entities name
 * remain unique.
 * 
 * 
 * @author ppourali
 * 
 */
public class NameUniquenessVerifier {

	public static boolean verify(FeatureNode t, String newName) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Feature.class)) {

			if (((Feature) o).getName() == null)
				continue;

			if (((Feature) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Feature) o).equals(((FeatureNode) t).getFeature())) {
					JOptionPane.showMessageDialog(null,
							"A Feature with the name: " + newName.trim()
									+ " already exists. Please make sure the names are unique.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Entity t, String newName, boolean ShowErrorDialog) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Entity.class)) {
			if (((Entity) o).getName() == null)
				continue;

			if (((Entity) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Entity) o).equals((Entity) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"An Entity with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Feature t, String newName, boolean ShowErrorDialog) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Feature.class)) {
			if (((Feature) o).getName() == null)
				continue;

			if (((Feature) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Feature) o).equals((Feature) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null, "A Feature with the name: " + newName.trim()
								+ " already exists. Please make sure the names are unique.");

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(WorldModel wm, String newName, boolean ShowErrorDialog) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(wm, Feature.class)) {
			if (((Feature) o).getName() == null)
				continue;

			if (((Feature) o).getName().equalsIgnoreCase(newName.trim())) {
				if (ShowErrorDialog)
					JOptionPane.showMessageDialog(null, "A Feature with the name: " + newName.trim()
							+ " already exists. Please make sure the names are unique.");

				return false;
			}
		}
		return true;
	}

	public static boolean verify(Message t, String newName, boolean ShowErrorDialog) {

		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Message.class)) {
			if (((Message) o).getName() == null)
				continue;

			if (((Message) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Message) o).equals((Message) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"A Message with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static Message verifyAndReturnMessage(Message t, String newName, boolean ShowErrorDialog) {

		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Message.class)) {
			if (((Message) o).getName() == null)
				continue;

			if (((Message) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Message) o).equals((Message) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"A Message with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return (Message) o;
				}
			}
		}
		return null;
	}

	public static boolean verify(Association t, String newName) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Association.class)) {
			if (((Association) o).getName() == null)
				continue;

			if (((Association) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Association) o).equals((Association) t)) {
					JOptionPane.showMessageDialog(null,
							"An Association with the name: " + newName.trim()
									+ " already exists. Please make sure the names are unique.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Composition t, String newName) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Composition.class)) {
			if (((Composition) o).getName() == null)
				continue;

			if (((Composition) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Composition) o).equals((Composition) t)) {
					JOptionPane.showMessageDialog(null,
							"A Composition with the name: " + newName.trim()
									+ " already exists. Please make sure the names are unique.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Aggregation t, String newName) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Aggregation.class)) {
			if (((Aggregation) o).getName().equalsIgnoreCase(newName.trim())) {
				if (((Aggregation) o).getName() == null)
					continue;

				if (!((Aggregation) o).equals((Aggregation) t)) {
					JOptionPane.showMessageDialog(null,
							"An Aggregation with the name: " + newName.trim()
									+ " already exists. Please make sure the names are unique.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Transition t, String newName, boolean ShowErrorDialog) {

		List<Transition> transList = new ArrayList<Transition>();

		if (t.eContainer() instanceof StateMachine) {
			transList = ModelUtils.getObjectsByTypeInAnObjectType(t, StateMachine.class, Transition.class);
		} else {
			transList = ModelUtils.getObjectsByTypeInAnObjectType(t, FragmentType.class, Transition.class);
		}

		for (Transition o : transList) {
			if (o.getName() == null)
				continue;

			if (o.getName().equalsIgnoreCase(newName.trim())) {
				if (!o.equals(((Transition) t))) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"A Transition with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(State t, String newName, boolean ShowErrorDialog) {

		List<State> statesList = ModelUtils.getObjectsByTypeInAnObjectType(t, Region.class, State.class);

		for (State o : statesList) {
			if (o.getName() == null)
				continue;

			if (o.getName().equalsIgnoreCase(newName.trim())) {
				if (!o.equals(t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"A State with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Region t, String newName, boolean ShowErrorDialog) {

		List<EObject> regionsList = new ArrayList<EObject>();

		if (t.eContainer() instanceof State)
			regionsList.addAll(((State) t.eContainer()).getRegions());
		else if (t.eContainer() instanceof StateMachine)
			regionsList.addAll(((StateMachine) t.eContainer()).getRegions());

		for (EObject o : regionsList) {
			if (((Region) o).getName() == null)
				continue;

			if (((Region) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!o.equals(t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"A Region with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Attribute t, Feature parentFeature, String newName, boolean ShowErrorDialog) {
		for (ExprRef o : parentFeature.getAttributes()) {
			if (((Attribute) o).getName() == null)
				continue;

			if (((Attribute) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Attribute) o).equals((Attribute) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"An attribute with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Attribute t, Entity parentEntity, String newName, boolean ShowErrorDialog) {
		for (ExprRef o : parentEntity.getAttributes()) {
			if (((Attribute) o).getName() == null)
				continue;

			if (((Attribute) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Attribute) o).equals((Attribute) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"An attribute with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Function t, Entity parentEntity, String newName, boolean ShowErrorDialog) {
		for (EObject o : parentEntity.getFunctions()) {
			if (((Function) o).getName() == null)
				continue;

			if (((Function) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Function) o).equals((Function) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null, "A Function with the name: " + newName.trim()
								+ " already exists. Please make sure the names are unique.");

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Attribute newAttribute, EObject attributeParent, String newName,
			boolean ShowErrorDialog) {

		List<ExprRef> currentAttribute = new ArrayList<ExprRef>();

		if (attributeParent instanceof Entity) {
			currentAttribute.addAll(((Entity) attributeParent).getAttributes());
		} else if (attributeParent instanceof Feature) {
			currentAttribute.addAll(((Feature) attributeParent).getAttributes());
		}

		for (ExprRef o : currentAttribute) {
			if (((Attribute) o).getName() == null)
				continue;

			if (((Attribute) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Attribute) o).equals((Attribute) newAttribute)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null, "An Attribute with the name: " + newName.trim()
								+ " already exists. Please make sure the names are unique.");

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Function newFunction, EObject functionParent, String newName,
			boolean ShowErrorDialog) {

		List<ExprRef> currentAttribute = new ArrayList<ExprRef>();

		if (functionParent instanceof Entity) {
			currentAttribute.addAll(((Entity) functionParent).getAttributes());
		}

		for (ExprRef o : currentAttribute) {
			if (((Attribute) o).getName() == null)
				continue;

			if (((Attribute) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Attribute) o).equals((Attribute) newFunction)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null, "An Attribute with the name: " + newName.trim()
								+ " already exists. Please make sure the names are unique.");

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(Enumeration t, String newName, boolean ShowErrorDialog) {
		for (EObject o : ModelUtils.getWorldModelObjectsByType(t, Enumeration.class)) {
			if (((Enumeration) o).getName() == null)
				continue;

			if (((Enumeration) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((Enumeration) o).equals((Enumeration) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null,
								"An Enumeration type with the name: " + newName.trim()
										+ " already exists. Please make sure the names are unique.",
								"Error", JOptionPane.ERROR_MESSAGE);

					return false;
				}
			}
		}
		return true;
	}

	public static boolean verify(EnumConst t, Enumeration parentEnum, String newName, boolean ShowErrorDialog) {
		for (EObject o : parentEnum.getConstant()) {
			if (((EnumConst) o).getName() == null)
				continue;

			if (((EnumConst) o).getName().equalsIgnoreCase(newName.trim())) {
				if (!((EnumConst) o).equals((EnumConst) t)) {
					if (ShowErrorDialog)
						JOptionPane.showMessageDialog(null, "A Constant with the name: " + newName.trim()
								+ " already exists. Please make sure the names are unique.");

					return false;
				}
			}
		}
		return true;
	}
}
