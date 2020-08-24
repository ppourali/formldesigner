package uw.cs.watform.forml.extensions;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.tools.SelectConnectionEditPartTracker;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import uw.cs.watform.forml.extensions.customStyles.TransitionEditPart;
import uw.cs.watform.forml.extensions.customStyles.TransitionFigure;

/**
 * Connection Node EditPart, a specialized Connection EditPart that installs 
 * a <code>ditPolicy.GRAPHICAL_NODE_ROLE</code> on this edit part. it also implements
 * INodeEditPart which defines the connectable edit parts
 * @author mmostafa
 */

public class CustomEdgeEditPart extends ConnectionEditPart {

	public CustomEdgeEditPart(View view) {
		super(view);
	}

	@Override
	protected Connection createConnectionFigure() {
		return new TransitionFigure(getMapMode());
	}

}