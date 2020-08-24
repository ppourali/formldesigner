package uw.cs.watform.forml.extensions.customStyles;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.handles.SquareHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.SimpleDragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * Adds a square selection handle that set the bounds to the preferred size
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("all")
public class PreferredSizeHandlerEditPolicy extends PreferredSizeCompartmentEditPolicy {

	public class PreferredSizeDragTracker extends SimpleDragTracker {
		@Override
		protected Request createSourceRequest() {
			return new SetPreferredSizeRequest(getHost());
		}

		@Override
		protected ChangeBoundsRequest getSourceRequest() {
			return (ChangeBoundsRequest) super.getSourceRequest();
		}

		@Override
		protected Command getCommand() {
			return getHost().getCommand(getSourceRequest());
		}

		@Override
		protected boolean handleButtonDown(int button) {
			setCurrentCommand(getCommand());
			executeCurrentCommand();
			getHost().refresh();
			return true;
		}

		@Override
		protected String getCommandName() {
			return "set preferred size";
		}
	}

	public class PreferredSizeSquareHandle extends SquareHandle {

		public PreferredSizeSquareHandle(GraphicalEditPart editpart) {
			super(editpart, new RelativeLocator(getHostFigure(), 0.75, 1) {
				protected Rectangle getReferenceBox() {
					IFigure f = getReferenceFigure();
					if (f instanceof HandleBounds)
						return ((HandleBounds) f).getHandleBounds();
					return super.getReferenceBox();
				}
			});
		}

		@Override
		protected DragTracker createDragTracker() {
			return new PreferredSizeDragTracker();
		}

		@Override
		protected void init() {
			setPreferredSize(9, 9);
		}

		@Override
		protected boolean isPrimary() {
			// Paint inverse colors
			return false;
		}

	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected List createSelectionHandles() {
		List result = super.createSelectionHandles();
		SquareHandle squareHandle = new PreferredSizeSquareHandle(getHost());
		squareHandle.setToolTip(new Label("set preferred size"));
		result.add(squareHandle);
		return result;
	}

}