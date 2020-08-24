package uw.cs.watform.forml.extensions;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.business.api.refresh.IRefreshExtension;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusLayoutDataManager;
import org.eclipse.sirius.diagram.ui.business.internal.view.RootLayoutData;

import uw.cs.watform.forml.forml.InitState;
import uw.cs.watform.forml.forml.StateMachine;

public class FORMLDiagramRefreshExtension implements IRefreshExtension {

	@Override
	public void beforeRefresh(DDiagram dDiagram) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postRefresh(DDiagram dDiagram) {
		for (DDiagramElement d : dDiagram.getDiagramElements()) {
			if (d.getTarget() instanceof InitState) {
				SiriusLayoutDataManager.INSTANCE
						.addData(new RootLayoutData(d, new Point(10, 15), new Dimension(-1, -1)));
			}
			if (d.getTarget() instanceof StateMachine) {
				SiriusLayoutDataManager.INSTANCE
						.addData(new RootLayoutData(d, new Point(10, 15), new Dimension(-1, -1)));

			}
		}
	}

}
