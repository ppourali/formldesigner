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
package uw.cs.watform.forml.extensions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeBeginNameEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEndNameEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeNameEditPart;
import org.eclipse.sirius.diagram.ui.part.SiriusVisualIDRegistry;
import org.eclipse.sirius.diagram.ui.tools.api.command.GMFCommandWrapper;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.general.JS_AssociationServices;

/**
 * UML edit part provider.
 *
 * @author Melanie Bats
 *         <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
@SuppressWarnings("restriction")
public class Ext_UMLEditPartProvider extends AbstractEditPartProvider {

	// Begin Role Editor
	class UMLDirectEditForBeginRole extends LabelDirectEditPolicy {

		@Override
		protected org.eclipse.gef.commands.Command getDirectEditCommand(
				org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) getHost())
					.resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String) edit.getCellEditor().getValue();
			final RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						final EObject target = ((DSemanticDecorator) element).getTarget();

						// Runs the editing code
						seeCaseAndEdit(target, "Begin", labelText);
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		}

	}

	// End Role Editor
	class UMLDirectEditForEndRole extends LabelDirectEditPolicy {

		@Override
		protected org.eclipse.gef.commands.Command getDirectEditCommand(
				org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) getHost())
					.resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String) edit.getCellEditor().getValue();
			final RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						final EObject target = ((DSemanticDecorator) element).getTarget();

						// Runs the editing code
						seeCaseAndEdit(target, "End", labelText);
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		}

	}

	// Center Role Editor
	class UMLDirectEditForLabel extends LabelDirectEditPolicy {

		@Override
		protected org.eclipse.gef.commands.Command getDirectEditCommand(
				org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) getHost())
					.resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String) edit.getCellEditor().getValue();
			final RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						final EObject target = ((DSemanticDecorator) element).getTarget();
					}
					if (element instanceof DSemanticDecorator) {
						final EObject target = ((DSemanticDecorator) element).getTarget();

						// Runs the editing code
						seeCaseAndEdit(target, "Center", labelText);
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		}
	}

	private void seeCaseAndEdit(EObject target, String LabelPosition, String newLabel) {
		if (target instanceof Association) {
			JS_AssociationServices services = new JS_AssociationServices();
			services.updateAssociation((Association) target, LabelPosition, newLabel);
		}

		else if (target instanceof Composition) {
			JS_AssociationServices services = new JS_AssociationServices();
			services.updateComposition((Composition) target, LabelPosition, newLabel);
		}

		else if (target instanceof Aggregation) {
			JS_AssociationServices services = new JS_AssociationServices();
			services.updateAggregation((Aggregation) target, LabelPosition, newLabel);
		}

		else if (target instanceof FeatureNode) {
			JS_AssociationServices services = new JS_AssociationServices();
			services.updateFeatureModelEdges((FeatureNode) target, LabelPosition, newLabel);
		}

	}

	/**
	 * @generated
	 */
	@Override
	public synchronized IGraphicalEditPart createGraphicEditPart(View view) {
		switch (SiriusVisualIDRegistry.getVisualID(view)) {

		case DEdgeBeginNameEditPart.VISUAL_ID:
			final DEdgeBeginNameEditPart dEdgeBeginPart = new DEdgeBeginNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgeBeginPart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT,
					new UMLDirectEditForBeginRole());
			return dEdgeBeginPart;

		case DEdgeEndNameEditPart.VISUAL_ID:
			final DEdgeEndNameEditPart dEdgeEndPart = new DEdgeEndNameEditPart(view) {
				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgeEndPart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT,
					new UMLDirectEditForEndRole());
			return dEdgeEndPart;

		case DEdgeNameEditPart.VISUAL_ID:
			final DEdgeNameEditPart dEdgePart = new DEdgeNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					// disables direct edit on Transition edges
					if (((DEdgeSpec) view.getElement()).getTarget() instanceof Transition)
						return false;
					else
						return true;
				}

				// probably here to create a styled text figure
				@Override
				public void setLabel(IFigure figure) {
					// TODO Auto-generated method stub

					super.setLabel(figure);

				}

			};

			dEdgePart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT, new UMLDirectEditForLabel());
			return dEdgePart;
		default:
			break;
		}
		return null;
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			final View view = ((IEditPartOperation) operation).getView();
			if (view.getElement() instanceof DSemanticDecorator) {
				if (((DSemanticDecorator) view.getElement()).getTarget() instanceof EObject) {
					switch (SiriusVisualIDRegistry.getVisualID(view)) {

					case DEdgeBeginNameEditPart.VISUAL_ID:
						return true;

					case DEdgeEndNameEditPart.VISUAL_ID:
						return true;

					case DEdgeNameEditPart.VISUAL_ID:
						return true;
					default:
						break;
					}
				}
			}

		}
		return false;
	}

}