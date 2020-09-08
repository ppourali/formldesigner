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
package uw.cs.watform.forml.extensions.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;

import com.google.common.collect.Lists;

import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Role;
import uw.cs.watform.forml.forml.Roleable;

/**
 * Services to handle typed Association concerns.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class AssociationServices {
	/**
	 * A singleton instance to be accessed by other java services.
	 */
	public static final AssociationServices INSTANCE = new AssociationServices();

	/**
	 * Hidden constructor.
	 */
	private AssociationServices() {

	}

	/**
	 * Return the source of an association.
	 *
	 * @param association
	 *            the {@link Association} context
	 * @return first end of the association
	 */
	public Roleable getSource(Role association) {
		if (association != null ) {
			return association.getType();
		}
		return null;
	}

	/**
	 * Get the source of an n-ary association.
	 * @param association the association
	 * @param view the edge to retrieve the source end
	 * @return end
	 */
	public Roleable getSourceEndAssociation(Role association, DDiagramElement view) {

		if (view instanceof DEdge) {
			final DEdge edge = (DEdge)view;
			final List<Role> members = new ArrayList<Role>();
			members.add(association);
			
			final EdgeTarget edgeSource = edge.getSourceNode();
			List<EObject> sourceSemanticElements = new ArrayList<EObject>();

			if (edgeSource instanceof DNodeListSpec) {
				// edge source is a classifier
				final DNodeListSpec source = (DNodeListSpec)edgeSource;
				sourceSemanticElements = source.getSemanticElements();
				for (final EObject sourceEObject : sourceSemanticElements) {
					for (final Role member : members) {
						if (sourceEObject.equals(member.getType())) {
							return member.getType();
						}
					}
				}
			} else if (edgeSource instanceof DNodeSpec) {
				// edge source is a qualifier
				sourceSemanticElements = ((DNodeSpec)edgeSource).getSemanticElements();
				for (final EObject sourceEObject : sourceSemanticElements) {
					for (final Role member : members) {
						if (sourceEObject.equals(member)) {
							return member.getType();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get the type of the association source end.
	 *
	 * @param association
	 *            Association
	 * @return Type of the source
	 */
	public Roleable getSourceType(Role association) {
		final Roleable source = getSource(association);
		if (source != null) {
			return source;
		}
		return null;
	}

	/**
	 * Return the target of an association.
	 *
	 * @param association
	 *            the {@link Association} context
	 * @return second end of the association
	 */
	public Roleable getTarget(Role association) {
		if (association != null ) {
			return association.getType();
		}
		return null;
	}

	/**
	 * Get the type of the association target end.
	 *
	 * @param association
	 *            Association
	 * @return Type of the target
	 */
	public Roleable getTargetType(Role association) {
		final Roleable target = getTarget(association);
		if (target != null) {
			return target;
		}
		return null;
	}

	/**
	 * Get types.
	 *
	 * @param association
	 *            Association
	 * @return List of types
	 */
	public List<Roleable> getTypes(Role association) {
		final List<Roleable> types = Lists.newArrayList();
		types.add(getSourceType(association));
		types.add(getTargetType(association));
		return types;
	}
}
