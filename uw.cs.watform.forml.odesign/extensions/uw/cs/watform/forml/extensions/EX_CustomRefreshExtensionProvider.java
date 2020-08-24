package uw.cs.watform.forml.extensions;

import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.api.refresh.IRefreshExtension;
import org.eclipse.sirius.diagram.business.api.refresh.IRefreshExtensionProvider;

import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class EX_CustomRefreshExtensionProvider implements IRefreshExtensionProvider {

	private static final FORMLDiagramRefreshExtension REFRESH_EXTENSION = new FORMLDiagramRefreshExtension();

	public EX_CustomRefreshExtensionProvider() {

	}

	@Override
	public boolean provides(DDiagram viewPoint) {
		// TODO Auto-generated method stub

		return RepresentationsUtils.FeatureModule_DIAGRAM_Id.equals(viewPoint.getDescription().getName());

	}

	@Override
	public IRefreshExtension getRefreshExtension(DDiagram viewPoint) {
		// TODO Auto-generated method stub
		return REFRESH_EXTENSION;
	}

}
