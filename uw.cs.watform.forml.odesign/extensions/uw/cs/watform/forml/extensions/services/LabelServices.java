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

import java.util.List;

import javax.swing.event.ChangeEvent;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;


import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import uw.cs.watform.forml.forml.*;

/**
 * Manage the diagram elements' labels.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class LabelServices {
	/**
	 * A singleton instance to be accessed by other java services.
	 */
	public static final LabelServices INSTANCE = new LabelServices();

	/**
	 * Space constant.
	 */
	private static final String SPACE = " "; //$NON-NLS-1$

	/**
	 * Sequence diagram element name suffix.
	 */
	private static final String SEQUENCE_DIAGRAM_SUFFIX = "sequence diagram"; //$NON-NLS-1$

	/**
	 * Hidden constructor.
	 */
	private LabelServices() {

	}

	
	
	/**
	 * {@link String} to {@link Integer} bound conversion.
	 *
	 * @param bound
	 *            string description
	 * @return converted integer or <code>null</code> in case of {@link NumberFormatException}.
	 */
	public int convertBound(String bound) {
		if ("*".equals(bound)) { //$NON-NLS-1$
			return -1;
		}
		try {
			return new Integer(bound).intValue();
		} catch (final NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * Parse the edited label string and update the underlying context {@link Element}.
	 *
	 * @param context
	 *            the context object on which to execute this service.
	 * @param editedLabelContent
	 *            the content entered by the user.
	 * @return the context {@link Element}
	 */
	public EObject editLabel(EObject context, String editedLabelContent) {
		final EditLabelSwitch editLabel = new EditLabelSwitch();
		editLabel.setEditedLabelContent(editedLabelContent);
		return context;
		//return editLabel.doSwitch(context);
	}

	
	private boolean startWithVowel(String str) {
		boolean result = false;
		if (str != null && str.length() > 0) {
			final char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
			for (final char vowel : vowels) {
				if (str.startsWith(Character.toString(vowel))
						|| str.startsWith(Character.toString(vowel).toUpperCase())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
