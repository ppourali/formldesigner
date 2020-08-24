package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.List;

public class DNDOperationsForListItems extends AbstractDNDOperations {

	public static void setDragSource(List dragList) {
		// DNDOperationsForEvent.setDragSource(dragList);
		// DNDOperationsForGuard.setDragSource(dragList);
		// DNDOperationsForAction.setDragSource(dragList);
		setDragSourceAsList(dragList);
	}

}
