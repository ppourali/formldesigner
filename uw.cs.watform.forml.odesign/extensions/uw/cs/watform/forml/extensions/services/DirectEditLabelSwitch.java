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

import uw.cs.watform.forml.forml.Entity;

/**
 * A switch that handle the label computation for each UML types for direct edit operation.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class DirectEditLabelSwitch  {

	/**
	 * Qualifier separator used for direct edit.
	 */
	public static final String QUALIFIER_SEPARATOR = ","; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public String caseEntity(Entity object) {
		return object.getName();
	}


}
