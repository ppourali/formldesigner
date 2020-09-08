package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;

import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.utilities.ModelOperations2;

public class DNDOperationsForNotRelatedList {

	protected static List dragSource;

	public static void setDragSource(List dragList) {
		// DNDOperationsForEvent.setDragSource(dragList);
		// DNDOperationsForGuard.setDragSource(dragList);
		// DNDOperationsForAction.setDragSource(dragList);
		setDragSourceAsList(dragList);
	}

	protected static void setDragSourceAsList(List dragList) {

		// Allow data to be copied from the drag source
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		DragSource source = new DragSource(dragList, operations);

		// Provide data in Text format
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {
			public void dragStart(DragSourceEvent event) {
				// Only start the drag if there is actually text in the
				// label - this text will be what is dropped on the target.
				if (dragList.getSelectionCount() == 0) {
					event.doit = false;
				}
			}

			public void dragSetData(DragSourceEvent event) {
				// Provide the data of the requested type.
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = dragList.getSelection()[0];
					dragSource = dragList;
					// getCommonspace().setDraggedDataForGuard((ExprRef) dragLabel.getData());

					// if (((ExprRef) dragLabel.getData()) instanceof Message)
					// getCommonspace().setDraggedDataForAction((Concept) dragLabel.getData());
				}
			}

			public void dragFinished(DragSourceEvent event) {
			}
		});
	}

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
						if (((DropTarget) event.widget).getControl() instanceof List) {
							Object srcElement = dragSource.getData(((String) event.data));
							// System.out.println(event.item);
							if (srcElement instanceof Roleable)
								ModelOperations2.createAssociations(
										CommonSpaceForContextualUI.getCurrentFeatureOrEntityClass(),
										(Roleable) srcElement);
							// CREATE ASSOCIATION TO SELF

						}
					}
					dragSource = null;
				}
			}

		});
	}
}