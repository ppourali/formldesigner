package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.utilities.ModelOperations2;

public class DNDOperationsForEvent extends AbstractDNDOperations {

	public static void setDragDropTarget(Control targetControl) {
		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] types = new Transfer[] { textTransfer };

		DropTarget target = new DropTarget(targetControl, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType)) {
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;

				}
			}

			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {
					if (event.widget instanceof DropTarget) {
						if (((DropTarget) event.widget).getControl() instanceof StyledText) {
							Object element = dragSource.getData(((String) event.data));

							setTriggeringEventOnDrop(element);

							EmbeddedEditorGenerator.UpdateXtextModel(true, false, false, null);
						}
					}
					dragSource = null;
				}
			}

		});
	}

	public static void setTriggeringEventOnDrop(Object data) {

		if (CommonSpaceForContextualUI.getCurrentTransition() != null) {
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				if (refMsg.getRefMsg() instanceof Input) {
					ModelOperations2.setTransitionTrigger(CommonSpaceForContextualUI.getCurrentTransition(),
							refMsg.getRefMsg(), true);
				}
			} else if (data instanceof Attribute) {
				Attribute att = (Attribute) data;

				ModelOperations2.setTransitionTrigger(CommonSpaceForContextualUI.getCurrentTransition(), att, true);

			}
			else if (data instanceof Function) {
				Function func = (Function) data;

				ModelOperations2.setTransitionTrigger(CommonSpaceForContextualUI.getCurrentTransition(), func, true);

			}
		}
	}
}
