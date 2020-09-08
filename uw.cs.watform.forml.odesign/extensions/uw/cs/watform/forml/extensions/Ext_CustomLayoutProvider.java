package uw.cs.watform.forml.extensions;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutEditPartProvider;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractDDiagramEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.sirius.diagram.ui.tools.api.layout.provider.AbstractLayoutProvider;
import org.eclipse.sirius.diagram.ui.tools.api.layout.provider.LayoutProvider;

import com.google.common.collect.Iterables;

import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class Ext_CustomLayoutProvider implements LayoutProvider {

	/** The GMF layout provider. */
	private AbstractLayoutEditPartProvider layoutProvider;

	@Override
	public AbstractLayoutEditPartProvider getLayoutNodeProvider(IGraphicalEditPart container) {
		if (isFeatureModelDiagram(container)) {
			if (this.layoutProvider == null) {
				 
				// this.layoutProvider = new CustomLayout();
			}
		}

		return this.layoutProvider;
	}

	@Override
	public boolean isDiagramLayoutProvider() {
		return false;
	}

	@Override
	public boolean provides(IGraphicalEditPart container) {
		return false;// isProcessDiagram(container);
	}

	private boolean isFeatureModelDiagram(IGraphicalEditPart container) {

		if (container instanceof AbstractDDiagramEditPart) {
			AbstractDDiagramEditPart editPart = (AbstractDDiagramEditPart) container;
			if (editPart.resolveSemanticElement() instanceof DDiagram) {
				DDiagram diagram = (DDiagram) editPart.resolveSemanticElement();
				if (diagram.getDescription() != null) {
					DiagramDescription diagramDescription = diagram.getDescription();
					String name = diagramDescription.getName();
					if (RepresentationsUtils.FeatureModel_DIAGRAM_Id.equals(name)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	class CustomLayout extends AbstractLayoutProvider {
		@Override
		public Command layoutEditParts(List selectedObjects, IAdaptable layoutHint) {

//			if (selectedObjects.isEmpty()) {
//
//				return UnexecutableCommand.INSTANCE;
//			}

			int index = 0;
			for (IGraphicalEditPart graphicalEditPart : Iterables.filter(selectedObjects, IGraphicalEditPart.class)) {

				EObject semanticElement = graphicalEditPart.resolveSemanticElement();

				if (semanticElement instanceof DDiagramElement
						&& ((DDiagramElement) semanticElement).getTarget() instanceof OrNode) {

					View notationView = graphicalEditPart.getNotationView();

					if (notationView instanceof Node) {
						final Node node = (Node) notationView;
						final LayoutConstraint layoutConstraint = node.getLayoutConstraint();

						if (layoutConstraint instanceof Bounds) {
							final Bounds bounds = (Bounds) layoutConstraint;

							final LayoutConstraint parentlayoutConstraint = ((Node) ((DEdgeEditPart) graphicalEditPart
									.getSourceConnections().get(0)).getTarget().getModel()).getLayoutConstraint();

							int parenty = ((Bounds) parentlayoutConstraint).getY();
							int parenth = ((Bounds) parentlayoutConstraint).getHeight();
							int parentx = ((Bounds) parentlayoutConstraint).getX();
							int parentw = ((Bounds) parentlayoutConstraint).getWidth();

							// bounds.setHeight(50);
							// bounds.setWidth(130);
							bounds.setX(parentx + (parentw / 2));
							bounds.setY(parenty + parenth + 20);
						}
					}
				}
				index++;
				// refresh for size of nodes
				graphicalEditPart.refresh();
			}

			return new CompoundCommand();
		}
	}

}
