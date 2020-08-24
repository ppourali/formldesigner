package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.List;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

public class AbstractDNDOperations {

	protected static List dragSource;

	protected static void setFocusForContentAssistant(XtextSourceViewer xtextSourceViewer) {
		try {
			((ContentAssistant) xtextSourceViewer.getContentAssistant()).setFocus(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setDragSourceAsList(List dragList) {

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
}
