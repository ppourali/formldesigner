package uw.cs.watform.forml.services.utilities;

import java.util.ArrayList;
import java.util.List;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.UndefinedType;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.impl.UndefinedTypeImpl;

public final class WorldModelCommonServices {

	private WorldModelCommonServices() {

	}

	public static Multiplicity parseMultiplicity(Multiplicity oldMultiplicity, String newLabel) {

		Multiplicity newMultiplicity = FormlFactory.eINSTANCE.createMultiplicity();

		// if no multiplicity types at all
		int startIndexOfMultiPlicity = newLabel.indexOf('[');
		int endIndexOfMultiPlicity = newLabel.indexOf(']');
		if (startIndexOfMultiPlicity == -1) {
			if (endIndexOfMultiPlicity == -1)
				return null;
			else
				return oldMultiplicity;
		}

		else {
			if (endIndexOfMultiPlicity == -1)
				endIndexOfMultiPlicity = newLabel.length();
			String MultiplicityLabel = newLabel.substring(startIndexOfMultiPlicity + 1, endIndexOfMultiPlicity);

			try {
				String[] LowerUpper = MultiplicityLabel.split("\\.\\.");

				for (int i = 0; i < LowerUpper.length; i++)
					LowerUpper[i] = LowerUpper[i].trim();

				// if can't be multiplicity corrected format
				if (LowerUpper.length == 0)
					return oldMultiplicity;

				// if no cardinality at all
				else if (LowerUpper.length == 1) {
					try {
						// if it is a single value
						newMultiplicity.setValue(Integer.parseInt(LowerUpper[0]));
					} catch (Exception e) {
						// if it is many
						if (LowerUpper[0].equals("*")) {
							newMultiplicity.setMany("*");
						} else
							return oldMultiplicity;
					}

					// if it is only a single value
				}

				else if (LowerUpper.length == 2) {
					// if it is a value..*
					if (LowerUpper[1].contains("*")) {
						Cardinality cardinality = FormlFactory.eINSTANCE.createCardinality();
						cardinality.setLower(Integer.parseInt(LowerUpper[0]));
						cardinality.setMany("*");

						newMultiplicity.setCardinality(cardinality);
					}
					// if it has a cardinality
					else {
						int lowerBound = Integer.parseInt(LowerUpper[0].trim());
						int upperBound = Integer.parseInt(LowerUpper[1].trim());

						// Multiplicity lower bound cannot be greater than upper
						// bound
						if (lowerBound > upperBound) {
							int temp = lowerBound;
							lowerBound = upperBound;
							upperBound = temp;
						}

						Cardinality newCardinality = FormlFactory.eINSTANCE.createCardinality();
						newCardinality.setLower(lowerBound);
						newCardinality.setUpper(upperBound);

						newMultiplicity.setCardinality(newCardinality);
					}
				} else
					return oldMultiplicity;

			} catch (Exception e) {
				e.printStackTrace();
				return oldMultiplicity;
			}
		}

		return newMultiplicity;
	}

	public static AttributeType parseAttributeType(AttributeType oldAttributeType, String newLabel, WorldModel wm) {

		AttributeType attNewType = oldAttributeType;

		int startAttributeTextIndex = newLabel.indexOf(':');

		if (startAttributeTextIndex > -1) {
			int endAttributeTextIndex = newLabel.indexOf('[');
			if (endAttributeTextIndex == -1)
				endAttributeTextIndex = newLabel.length();

			String NewAttributeTypeName = newLabel.substring(startAttributeTextIndex + 1, endAttributeTextIndex).trim();

			attNewType = ModelUtils2.createAttributeType(NewAttributeTypeName);

			// if(NewAttributeTypeName.toLowerCase().equals("int"))
			// attNewType=FormlFactory.eINSTANCE.createIntType();
			// else if(NewAttributeTypeName.toLowerCase().equals("bool"))
			// attNewType=FormlFactory.eINSTANCE.createBoolType();
			// else
			// {
			//
			// // if concept/att type name exists
			// boolean if_RT_AlreadyExisted=false;
			// for (ExprRef ut:wm.getConcepts())
			// {
			// if(ut instanceof Concept)
			// {
			// System.out.println(((Concept) ut).getName());
			//
			// if(((Concept)ut).getName().equalsIgnoreCase(NewAttributeTypeName))
			// {
			// ReferenceType
			// newrefAtt=FormlFactory.eINSTANCE.createReferenceType();
			// newrefAtt.setRef((Concept)ut);
			// attNewType=newrefAtt;
			//
			// if_RT_AlreadyExisted = true;
			//
			// break;
			// }
			// }
			// }
			//
			// if (if_RT_AlreadyExisted==false)
			// {
			// ReferenceType
			// newrefAtt=FormlFactory.eINSTANCE.createReferenceType();
			// newrefAtt.setRef(ModelUtils.getUndefinedTypeInWorldModel(wm));
			// attNewType=newrefAtt;
			// }
			// }

		} else {

			// ReferenceType
			// newrefAtt=FormlFactory.eINSTANCE.createReferenceType();
			// newrefAtt.setRef(ModelUtils.getUndefinedTypeInWorldModel(wm));
			// attNewType=newrefAtt;

			return null;
		}

		return attNewType;
	}

	public static String parseAttributeName(String oldName, String newLabel) {

		int endOfNameIndex = newLabel.indexOf(':');

		if (endOfNameIndex == -1) {
			// if there is no type for the att then there is no ':'
			endOfNameIndex = newLabel.indexOf('[');
			if (endOfNameIndex == -1) {
				endOfNameIndex = newLabel.length();
			}
		}

		String AttributeNewName = oldName;

		if (isCtrl(newLabel))
			AttributeNewName = newLabel.substring(8, endOfNameIndex);
		else
			AttributeNewName = newLabel.substring(0, endOfNameIndex);

		return AttributeNewName.trim().replace(" ", "").replace(".", "");
	}

	/**
	 * 
	 * @param newMessageName
	 * @return message name based on the index of '('
	 */
	public static String parseMessageName(String newMessageName) {

		int endOfNameIndex = newMessageName.indexOf('(');

		if (endOfNameIndex == -1)
			endOfNameIndex = newMessageName.length();

		return newMessageName.substring(0, endOfNameIndex).trim().replace(" ", "").replace(".", "");
	}

	/**
	 * 
	 * @param messageName
	 * @return message type based on the index of ')'
	 */
	public static String parseMessageType(String messageName) {

		int startOfTypeIndex = messageName.indexOf(')');

		if (startOfTypeIndex == -1)
			return "";

		String unProcessedType = messageName.substring(startOfTypeIndex + 1);
		String processedType = "";
		if (unProcessedType.contains(":")) {
			processedType = unProcessedType.replace(":", "").replace(" ", "");
		}
		return processedType;

	}

	/**
	 * 
	 * @param wm
	 * @param newMessageName
	 * @return message parameters based on the indexes of '(' and ')'
	 */
	public static List<Attribute> parseMessageParams(WorldModel wm, String newMessageName) {
		List<Attribute> attributesList = new ArrayList<Attribute>();

		int startIndexOfParameters = newMessageName.indexOf('(') + 1;

		int endIndexOfParameters = newMessageName.indexOf(')');

		if (startIndexOfParameters == -1 || endIndexOfParameters == -1)
			return attributesList;
		else {
			String ParamsList = newMessageName.substring(startIndexOfParameters, endIndexOfParameters);

			if (ParamsList.trim().equals("")) {
				return attributesList;
			}

			String[] attributes = ParamsList.split(",");

			for (String att : attributes) {

				Attribute newParam = FormlFactory.eINSTANCE.createAttribute();

				newParam.setName(WorldModelCommonServices.parseAttributeName(att, att));
				newParam.setType(WorldModelCommonServices
						.parseAttributeType(FormlFactory.eINSTANCE.createAttributeType(), att, wm));

				attributesList.add(newParam);
			}

			return attributesList;
		}
	}

	public static String parseAssociationName(String oldName, String newLabel) {

		int endOfNameIndex = newLabel.indexOf('[');

		if (endOfNameIndex == -1) {
			endOfNameIndex = newLabel.length();
		}

		String AttributeNewName = oldName;

		if (isCtrl(newLabel))
			AttributeNewName = newLabel.substring(8, endOfNameIndex);
		else
			AttributeNewName = newLabel.substring(0, endOfNameIndex);

		return AttributeNewName.trim().replace(" ", "").replace(".", "");
	}

	public static boolean isCtrl(String newLabel) {

		if (newLabel.replace(" ", "").startsWith("<<ctrl>>"))
			return true;
		return false;
	}

	public static Attribute getAttributeByName(String name, Message parentMessage) {

		if (name.trim().equals(""))
			return null;
		else
			for (ExprRef att : parentMessage.getAttributes()) {
				if (((Attribute) att).getName().trim().equalsIgnoreCase(name))
					return (Attribute) att;
			}

		return null;
	}

	public static Feature getFeatureByName(String name) {

		if (name.trim().equals(""))
			return null;
		else
			for (ExprRef feature : ModelUtils2.getWorldModel(null).getConcepts()) {
				if (feature instanceof Feature) {
					if (((Feature) feature).getName().trim().equalsIgnoreCase(name))
						return (Feature) feature;
				}
			}
		return null;
	}
}
