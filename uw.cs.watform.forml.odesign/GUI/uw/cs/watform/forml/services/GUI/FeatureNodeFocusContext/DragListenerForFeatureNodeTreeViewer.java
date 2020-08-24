package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

public class DragListenerForFeatureNodeTreeViewer implements DragSourceListener {

	private final TreeViewer viewer;

	public DragListenerForFeatureNodeTreeViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// System.out.println("Finshed Drag");
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// Here you do the convertion to the type which is expected.
		IStructuredSelection selection = viewer.getStructuredSelection();
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof EObject) {
			EObject selectedEObject = ((EObject) selectedElement);

			if (TextTransfer.getInstance().isSupportedType(event.dataType) && selectedEObject != null) {
				String key = viewer.getStructuredSelection().getFirstElement().toString();
				event.data = key;
				AbstractDNDForFeatureNodeVeiwer.addDragedEObjects(key, selectedEObject);

			}

		}

	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// System.out.println("Start Drag");
	}

}
