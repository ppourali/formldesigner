/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.services.general;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.extensions.Ext_UMLEditPartProvider;
import uw.cs.watform.forml.extensions.services.LabelServices;
import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Decl;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Role;
import uw.cs.watform.forml.services.GUI.FrmSetCardinalityForAssociations;
import uw.cs.watform.forml.services.GUI.FrmSetCardinalityForCompositionAggregation;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;

/**
 * All the services related to Associations, Aggregations and Associations.
 * 
 * 
 * @author ppourali
 */
public class JS_AssociationServices {

	// Direct Edit service for edge labels
	public EObject editAssociationLabel(EObject context, String editedLabelContent) {
		return LabelServices.INSTANCE.editLabel(context, editedLabelContent);
	}

	/**
	 * Sets the feature node multiplicity based on the edge text (multiplicity)
	 * edited by the user. This is called by {@link Ext_UMLEditPartProvider}
	 * 
	 * @param target
	 *            feature node
	 * @param labelPosition
	 *            center label, begin label or end label
	 * @param newLabel
	 *            new label
	 */
	public void updateFeatureModelEdges(FeatureNode target, String labelPosition, String newLabel) {
		target.setMultiplicity(WorldModelCommonServices.parseMultiplicity(target.getMultiplicity(), "," + newLabel));
	}

	/**
	 * Sets the Association based on user edited text on Association Edge.
	 * 
	 * @param target
	 *            feature node
	 * @param labelPosition
	 *            center label, begin label or end label
	 * @param newLabel
	 *            new label
	 */
	public void updateAssociation(Association target, String labelPosition, String newLabel) {
		Role editableRole = FormlFactory.eINSTANCE.createRole();

		if (labelPosition.equalsIgnoreCase("Begin"))
			editableRole = target.getSrcRole();
		else if (labelPosition.equalsIgnoreCase("End"))
			editableRole = target.getDesRole();
		else if (labelPosition.equalsIgnoreCase("Center")) {
			target.setName(newLabel.replace(" ", "").trim());
			return;
		}

		try {
			editableRole.setName(WorldModelCommonServices.parseAssociationName(target.getName(), newLabel));
			editableRole.setMultiplicity(
					WorldModelCommonServices.parseMultiplicity(editableRole.getMultiplicity(), newLabel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the Composition based on user edited text on Composition Edge.
	 * 
	 * @param target
	 *            feature node
	 * @param labelPosition
	 *            center label, begin label or end label
	 * @param newLabel
	 *            new label
	 */
	public void updateComposition(Composition target, String labelPosition, String newLabel) {

		Decl editableRole = FormlFactory.eINSTANCE.createDecl();

		if (labelPosition.equalsIgnoreCase("Begin"))
			editableRole = target.getWhole();
		else if (labelPosition.equalsIgnoreCase("End"))
			editableRole = target.getPart();
		else if (labelPosition.equalsIgnoreCase("Center")) {
			target.setName(newLabel.replace(" ", "").trim());
			return;
		}

		try {
			editableRole.setName(WorldModelCommonServices.parseAssociationName(target.getName(), newLabel));
			editableRole.setMultiplicity(
					WorldModelCommonServices.parseMultiplicity(editableRole.getMultiplicity(), newLabel));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sets the Aggregation based on user edited text on Aggreagation Edge.
	 * 
	 * @param target
	 *            feature node
	 * @param labelPosition
	 *            center label, begin label or end label
	 * @param newLabel
	 *            new label
	 */
	public void updateAggregation(Aggregation target, String labelPosition, String newLabel) {
		Decl editableRole = FormlFactory.eINSTANCE.createDecl();

		if (labelPosition.equalsIgnoreCase("Begin"))
			editableRole = target.getWhole();
		else if (labelPosition.equalsIgnoreCase("End"))
			editableRole = target.getPart();
		else if (labelPosition.equalsIgnoreCase("Center")) {
			target.setName(newLabel.replace(" ", "").trim());
			return;
		}

		try {
			editableRole.setName(WorldModelCommonServices.parseAssociationName(target.getName(), newLabel));
			editableRole.setMultiplicity(
					WorldModelCommonServices.parseMultiplicity(editableRole.getMultiplicity(), newLabel));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Swaps roles of Aggregations and Compositions.
	 */
	public static void swapRoles(EObject t) {
		if (t instanceof Aggregation) {
			Decl tempWholeRole = FormlFactory.eINSTANCE.createDecl();
			tempWholeRole = ((Aggregation) t).getWhole();
			((Aggregation) t).setWhole(((Aggregation) t).getPart());
			((Aggregation) t).setPart(tempWholeRole);
		} else if (t instanceof Composition) {
			Decl tempWholeRole = FormlFactory.eINSTANCE.createDecl();
			tempWholeRole = ((Composition) t).getWhole();
			((Composition) t).setWhole(((Composition) t).getPart());
			((Composition) t).setPart(tempWholeRole);
		}

	}

	/*
	 * Populates the label for associations source/whole role.
	 */
	public static String srcRole_WholeGetLabel(EObject t) {
		String returnLabel = "";
		Multiplicity mul = FormlFactory.eINSTANCE.createMultiplicity();

		if (t instanceof Association) {
			mul = ((Association) t).getSrcRole().getMultiplicity();
			returnLabel = ((Association) t).getSrcRole().getName();
		} else if (t instanceof Aggregation) {
			mul = ((Aggregation) t).getWhole().getMultiplicity();
			returnLabel = ((Aggregation) t).getWhole().getName();
		}
		if (t instanceof Composition) {
			mul = ((Composition) t).getWhole().getMultiplicity();
			returnLabel = ((Composition) t).getWhole().getName();
		}

		if (mul != null) {
			if (mul.getCardinality() != null) {
				if (mul.getCardinality().getMany() != null && mul.getCardinality().getMany().trim() != "")
					returnLabel += " [" + mul.getCardinality().getLower() + ".." + mul.getCardinality().getMany() + "]";
				else
					returnLabel += " [" + mul.getCardinality().getLower() + ".." + mul.getCardinality().getUpper() + "]";
			} else {
				if (mul.getMany() != null && mul.getMany().trim() != "") {
					returnLabel += " [" + mul.getValue() + "..*" + "]";
				} else {
					returnLabel += " [" + mul.getValue() + "]";
				}
			}
		}

		return returnLabel.trim();
	}

	/*
	 * Populates the label for associations destination/part role.
	 */
	public static String desRole_PartGetLabel(EObject t) {
		String returnLabel = "";
		Multiplicity mul = FormlFactory.eINSTANCE.createMultiplicity();

		if (t instanceof Association) {
			mul = ((Association) t).getDesRole().getMultiplicity();
			returnLabel = ((Association) t).getDesRole().getName();
		} else if (t instanceof Aggregation) {
			mul = ((Aggregation) t).getPart().getMultiplicity();
			returnLabel = ((Aggregation) t).getPart().getName();
		}
		if (t instanceof Composition) {
			mul = ((Composition) t).getPart().getMultiplicity();
			returnLabel = ((Composition) t).getPart().getName();
		}

		if (mul != null) {
			if (mul.getCardinality() != null) {
				if (mul.getCardinality().getMany() != null && mul.getCardinality().getMany().trim() != "")
					returnLabel += " [" + mul.getCardinality().getLower() + ".." + mul.getCardinality().getMany()+"]";
				else
					returnLabel += " [" + mul.getCardinality().getLower() + ".." + mul.getCardinality().getUpper()+"]";
			} else {
				if (mul.getMany() != null && mul.getMany().trim() != "") {
					returnLabel += " [" + mul.getValue() + "..*"+"]";
				} else {
					returnLabel += " [" + mul.getValue()+"]";
				}
			}
		}

		return returnLabel.trim();
	}

	/*
	 * Open dialog form to edit Association.
	 */
	public static void openEditAssociationForm(EObject t) {
		try {

			FrmSetCardinalityForAssociations frmSetCard = new FrmSetCardinalityForAssociations((Association) t);
			frmSetCard.setVisible(true);

			if (frmSetCard.ConfirmFlag) {
				((Association) t).setName(frmSetCard.AssociationName);

				((Association) t).getSrcRole().setName(frmSetCard.SourceRoleName);
				((Association) t).getSrcRole().setMultiplicity(frmSetCard.sourceMultiplicity);

				((Association) t).getDesRole().setName(frmSetCard.DestinationRoleName);
				((Association) t).getDesRole().setMultiplicity(frmSetCard.destinationMultiplicity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Open dialog form to edit Composition and Aggregation.
	 */
	public static void openEditCompositionAggregationForm(EObject t) {
		try {

			FrmSetCardinalityForCompositionAggregation frmSetCard = null;
			if (t instanceof Composition) {
				frmSetCard = new FrmSetCardinalityForCompositionAggregation((Composition) t);
			}
			if (t instanceof Aggregation) {
				frmSetCard = new FrmSetCardinalityForCompositionAggregation((Aggregation) t);
			}

			frmSetCard.setVisible(true);

			if (frmSetCard.ConfirmFlag) {
				if (t instanceof Composition) {
					((Composition) t).setName(frmSetCard.AssociationName);

					((Composition) t).getWhole().setName(frmSetCard.WholeRoleName);
					((Composition) t).getWhole().setMultiplicity(frmSetCard.wholeMultiplicity);

					((Composition) t).getPart().setName(frmSetCard.PartRoleName);
					((Composition) t).getPart().setMultiplicity(frmSetCard.partMultiplicity);
				} else if (t instanceof Aggregation) {
					((Aggregation) t).setName(frmSetCard.AssociationName);

					((Aggregation) t).getWhole().setName(frmSetCard.WholeRoleName);
					((Aggregation) t).getWhole().setMultiplicity(frmSetCard.wholeMultiplicity);

					((Aggregation) t).getPart().setName(frmSetCard.PartRoleName);
					((Aggregation) t).getPart().setMultiplicity(frmSetCard.partMultiplicity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
