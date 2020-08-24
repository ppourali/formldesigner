package uw.cs.watform.forml.extensions.customStyles;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * 
 * Do not allow resizing smaller than the preferred size of the compartment
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PreferredSizeCompartmentEditPolicy extends ResizableEditPolicyEx {

	@Override
	public void showSourceFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_RESIZE)) {
			adjustRequest((ChangeBoundsRequest) request);
		}
		super.showSourceFeedback(request);
	}

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		if (request.getType().equals(RequestConstants.REQ_RESIZE)) {
			adjustRequest((ChangeBoundsRequest) request);
		}
		return super.getResizeCommand(request);
	}

	protected void adjustRequest(ChangeBoundsRequest request) {
		final IFigure figure = getHostFigure();
		final Dimension prefSize = figure.getPreferredSize().getCopy();
		figure.translateToAbsolute(prefSize);
		Rectangle bounds = figure.getBounds().getCopy();
		figure.translateToAbsolute(bounds);
		bounds = request.getTransformedRectangle(bounds);
		if (bounds.width < prefSize.width) {
			request.getSizeDelta().width = request.getSizeDelta().width + (prefSize.width - bounds.width);
		}
		if (bounds.height < prefSize.height) {
			request.getSizeDelta().height = request.getSizeDelta().height + (prefSize.height - bounds.height);
		}
		request.setSizeDelta(request.getSizeDelta());
	}

}