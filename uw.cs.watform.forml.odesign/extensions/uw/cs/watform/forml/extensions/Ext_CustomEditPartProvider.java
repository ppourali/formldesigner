package uw.cs.watform.forml.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ArrangeConstraint;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.WorkspaceImage;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;
import org.eclipse.sirius.diagram.ui.tools.api.util.EditPartTools;
import org.eclipse.sirius.diagram.ui.tools.internal.util.EditPartQuery;

import uw.cs.watform.forml.extensions.customStyles.PreferredSizeHandlerEditPolicy;
import uw.cs.watform.forml.extensions.customStyles.TransitionEditPart;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class Ext_CustomEditPartProvider extends AbstractEditPartProvider {
	@SuppressWarnings({ "restriction", "rawtypes", "unused" })

	@Override
	protected Class getEdgeEditPartClass(View view) {
//		if (view.getElement() instanceof DEdgeSpec) {
//			if (((DEdgeSpec) view.getElement()).getTarget() instanceof Transition) {
//				Transition t = (Transition) (((DEdge) view.getElement()).getTarget());
//				String toolTrig = ModelUtils.getTextForModelObjects(t.getTrig());
//				String toolGuard = ModelUtils.getTextForModelObjects(t.getTrig());
//				String toolAction = ModelUtils.getTextForModelObjects(t.getTrig());
//				((DEdgeSpec) view.getElement()).setTooltipText(toolTip);
//			}
//		}
		return super.getEdgeEditPartClass(view);
	};

	@Override
	protected Class getNodeEditPartClass(View view) {

		// if (view.getElement() instanceof CustomStyle) {
		// CustomStyle customStyle = (CustomStyle) view.getElement();
		// if
		// (customStyle.getId().equals(DiagSeqConstants.INSTANCE_ROLE_STYLE_ID))
		// {
		// return FeatureNodeCustomStyle.class;
		// }
		// }
		if (view.getElement() instanceof DNodeContainerSpec) {
			if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof State) {

				// EditPart editPart = createGraphicEditPart(view);
				// editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
				// PreferredSizeHandlerEditPolicy());

				// ((NodeEditPart)
				// view).installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				// new HighLightEditPolicy());
				// return MyNodeEditPart.class;
			}
			if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof Region) {

//				super.getNodeEditPartClass(view).in;				 installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
//				 PreferredSizeHandlerEditPolicy());
				
				// EditPart editPart = createGraphicEditPart(view);
				// editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
				// PreferredSizeHandlerEditPolicy());

				// ((NodeEditPart)
				// view).installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				// new HighLightEditPolicy());
				// return MyNodeEditPart.class;
			}
		}
		

		

		// EditPart editPart = createGraphicEditPart(view);
		// editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// PreferredSizeHandlerEditPolicy());

		// ((NodeEditPart)
		// view).installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new
		// HighLightEditPolicy());
		// return MyNodeEditPart.class;

		// WorkspaceImage customStyle = (WorkspaceImage) view.getElement();
		// return FeatureNodeCustomStyle.class;

		// }

		// if (view.getElement() instanceof WorkspaceImage) {
		// WorkspaceImage customStyle = (WorkspaceImage) view.getElement();
		//
		// System.err.println(customStyle.eContainer());
		// }
		//
		// if (view.getElement() instanceof DNodeSpec) {
		// if (((DNodeSpec) view.getElement()).getTarget() instanceof
		// FeatureNode) {
		// DNode nodeSpec=(DNode) view.getElement();
		// getDiagramEditPartClass(view).get
		// nodeSpec.
		// System.out.println(((DNodeSpec) view.getElement()).getTarget());
		// }
		// }
		return super.getNodeEditPartClass(view);
	}
}
/*
 * if (view.getElement() instanceof CustomStyle) { CustomStyle customStyle =
 * (CustomStyle) view.getElement(); if (customStyle.getId().equals("mycs")) {
 * return MyNodeEditPart.class; } }
 */

/*
 * if (view.getElement() instanceof WorkspaceImage) { WorkspaceImage customStyle
 * = (WorkspaceImage) view.getElement(); RGBValues value=RGBValues.create(50,
 * 50, 255); customStyle.setLabelColor(value);//.setLabelSize(50); return
 * MyNodeEditPart.class;
 */

// if (view instanceof org.eclipse.sirius.diagram.DEdge) {
// DNode customStyle = (DNode) view.getElement();
//
// if(customStyle.getIncomingEdges().size()>0)
// JOptionPane.showMessageDialog(null,
// customStyle.getIncomingEdges().get(0).getSize());
// //return CustomStyleEditPart2.class;
//
// }

// return super.getNodeEditPartClass(view);
// }
//
// }