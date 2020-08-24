package uw.cs.watform.forml.extensions.customStyles;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionFigure extends PolylineConnectionEx {

	private final IMapMode mapMode;

	public TransitionFigure(IMapMode mapMode) {
		this(mapMode, false);
	}

	public TransitionFigure(IMapMode mapMode, boolean reversed) {
		this.mapMode = mapMode;
		setLineWidth(mapMode.DPtoLP(1));
		if (reversed)
			setSourceDecoration(createTargetDecoration());
		else
			setTargetDecoration(createTargetDecoration());
	}

	protected IMapMode getMapMode() {
		return mapMode;
	}

	private RotatableDecoration createTargetDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setLineWidth(getMapMode().DPtoLP(1));
		df.setTemplate(PolygonDecoration.TRIANGLE_TIP);
		return df;
	}
}
