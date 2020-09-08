package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import org.eclipse.swt.widgets.List;

public class DNDOperationsForListItems extends AbstractDNDOperations {

	public static void setDragSource(List dragList) {
		// DNDOperationsForEvent.setDragSource(dragList);
		// DNDOperationsForGuard.setDragSource(dragList);
		// DNDOperationsForAction.setDragSource(dragList);
		setDragSourceAsList(dragList);
	}

}
