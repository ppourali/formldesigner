package uw.cs.watform.forml.extensions.customStyles;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Extends {@link ChangeBoundsRequest} to calculate the preferred size delta.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SetPreferredSizeRequest extends ChangeBoundsRequest {

	public SetPreferredSizeRequest(IGraphicalEditPart host) {
		super(RequestConstants.REQ_RESIZE);
		setEditParts(host);
		IFigure figure = host.getFigure();
		Dimension prefSize = null;
		Dimension currentSize = figure.getSize();

		try {
			prefSize = figure.getLayoutManager().getPreferredSize(figure, -1, -1);
		} catch (Exception e) {
			prefSize = figure.getPreferredSize(-1, -1);
//			int left = 0;
//			for (Object child : host.getChildren()) {
//				if (child instanceof EditPart) {
//					((GraphicalEditPart)child).getFigure().ge
//				}
//			}
		}
		setSizeDelta(new Dimension(prefSize.width - currentSize.width, prefSize.height - currentSize.height));
	}

}