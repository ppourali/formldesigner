package uw.cs.watform.forml.extensions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractNotSelectableShapeNodeEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.IStyleEditPart;
import org.eclipse.sirius.ext.gmf.runtime.gef.ui.figures.AirStyleDefaultSizeNodeFigure;

import uw.cs.watform.forml.extensions.customStyles.PreferredSizeHandlerEditPolicy;

public class MyNodeEditPart extends AbstractNotSelectableShapeNodeEditPart implements IStyleEditPart {

	public MyNodeEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * the content pane.
	 */
	protected IFigure contentPane;

	/**
	 * the primary shape.
	 */
	protected ImageFigure primaryShape;

	public DragTracker getDragTracker(Request request) {
		return getParent().getDragTracker(request);
	}

	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new XYLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	private NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new AirStyleDefaultSizeNodeFigure(getMapMode().DPtoLP(40),
				getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Create the instance role figure.
	 *
	 * @return the created figure.
	 */
	protected ImageFigure createNodeShape() {
		if (primaryShape == null) {
			primaryShape = new ImageFigure();
		}
		return primaryShape;
	}

	/**
	 * Return the instance role figure.
	 *
	 * @return the instance role figure.
	 */
	public ImageFigure getPrimaryShape() {
		return primaryShape;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 *
	 * @param nodeShape
	 *            instance of generated figure class
	 * @return the figure
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	public IFigure getContentPane() {
		return super.getContentPane();
	}

	protected void refreshVisuals() {
		super.refreshVisuals();

	}

	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PreferredSizeHandlerEditPolicy());
	}
}