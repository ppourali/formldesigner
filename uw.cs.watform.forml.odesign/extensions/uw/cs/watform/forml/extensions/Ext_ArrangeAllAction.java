package uw.cs.watform.forml.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class Ext_ArrangeAllAction implements IExternalJavaAction {
	public Ext_ArrangeAllAction() {
		JOptionPane.showMessageDialog(null, "hi");
	}
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		try {
			// trigger 'arrange all' on the whole diagram
			DiagramEditPart diagramEditPart = null;
			IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editor instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor) editor;
				diagramEditPart = diagramEditor.getDiagramEditPart();
			}

			ArrangeRequest arrangeRequest = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
			List<Object> partsToarrange = new ArrayList<Object>(1);
			partsToarrange.add(diagramEditPart);
			arrangeRequest.setPartsToArrange(partsToarrange);
			diagramEditPart.performRequest(arrangeRequest);

		} catch (Exception e) {
			SiriusPlugin.getDefault().error("Error while arrange elements", e);
		}

	}


	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}