/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.extensions.services;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Decl;

/**
 * A switch that handle the label edition for each UML types.
 *
 * @author Gonzague Reydet <a href="mailto:gonzague.reydet@obeo.fr">gonzague.reydet@obeo.fr</a>
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 * @author Hugo Marchadour <a href="mailto:hugo.marchadour@obeo.fr">hugo.marchadour@obeo.fr</a>
 */
public class EditLabelSwitch implements ILabelConstants {
	
	/**
	 * The raw label content edited by the user.
	 */
	private String editedLabelContent;

	

	/**
	 * {@inheritDoc}
	 */
	public EObject caseAssociation(Association object) {
		/**
		 * Nothing to do the label direct edit is done by the edit part provider {@see #UMLEditPartProvider}
		 */
		return object;
	}

	

	/**
	 * Case Role.
	 *
	 * @param property
	 *            Property
	 */
	public void caseRole(Decl property) {
		/*
		 * We need to find roles names, end user might type: "aRoleName" "aRoleName - aRoleName "
		 * aRoleName[cardinality]
		 */
//		String escapedLabel = editedLabelContent;
//		if (editedLabelContent.indexOf('/') > -1) {
//			// should be derived
//			escapedLabel.replace('/', ' ');
//			property.setIsDerived(true);
//		} else {
//			property.setIsDerived(false);
//		}
//		escapedLabel = escapedLabel.trim();
//		// multiplicity
//		if (escapedLabel.indexOf('[') > -1) {
//			final String endOfMul = escapedLabel.substring(escapedLabel.indexOf('[') + 1);
//			escapedLabel = escapedLabel.substring(0, escapedLabel.indexOf('['));
//			escapedLabel = escapedLabel.trim();
//			// lower bound
//			int lowerBound = property.getLower();
//			int upperBound = property.getUpper();
//			if (endOfMul.indexOf(']') > -1) {
//				final String mulInter = endOfMul.substring(0, endOfMul.indexOf(']')).trim();
//				if ("*".equals(mulInter)) { //$NON-NLS-1$
//					lowerBound = 0;
//					upperBound = -1;
//				} else {
//					if (mulInter.length() > 0) {
//						if (mulInter.indexOf("..") > -1) { //$NON-NLS-1$
//							final String low = mulInter.substring(0, mulInter.indexOf("..")).trim(); //$NON-NLS-1$
//							if (low.length() > 0) {
//								lowerBound = Integer.valueOf(low).intValue();
//							}
//							final String up = mulInter.substring(mulInter.indexOf("..") + 2).trim(); //$NON-NLS-1$
//							if (up.length() > 0) {
//								if ("*".equals(up)) { //$NON-NLS-1$
//									upperBound = -1;
//								} else {
//									upperBound = Integer.valueOf(up).intValue();
//								}
//							}
//						} else {
//							final int singleBound = Integer.valueOf(mulInter).intValue();
//							lowerBound = singleBound;
//							upperBound = singleBound;
//						}
//
//					}
//				}
//			}
//			property.setLower(lowerBound);
//			property.setUpper(upperBound);
//		}
		property.setName("hi");
	}

	

	/**
	 * Set edited label content.
	 *
	 * @param editedLabelContent
	 *            Label content
	 */
	public void setEditedLabelContent(String editedLabelContent) {
		this.editedLabelContent = editedLabelContent;
	}
}
