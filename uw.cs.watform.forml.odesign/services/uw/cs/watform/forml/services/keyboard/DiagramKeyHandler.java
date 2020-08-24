package uw.cs.watform.forml.services.keyboard;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.tools.internal.part.SiriusDiagramGraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPartReference;

import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

/**
 * Set KeyHandler for Diagrams
 * @author ppourali
 *
 */

@SuppressWarnings("restriction")

public class DiagramKeyHandler {

	public DiagramKeyHandler(IWorkbenchPartReference partRef) {
		setKeyHandler(partRef);
	}

	private void setKeyHandler(IWorkbenchPartReference partRef) {

		IEditorPart editorPart = partRef.getPage().getActiveEditor();
		if (editorPart != null && editorPart instanceof DiagramEditor) {
			if (editorPart instanceof DiagramEditor) {
				DiagramEditPart diagramEditPart = ((DiagramEditor) editorPart).getDiagramEditPart();

				EditPartViewer viewer = diagramEditPart.getViewer();
				if (viewer instanceof SiriusDiagramGraphicalViewer) {
					try {
						Diagram diagramModel = (Diagram) diagramEditPart.getModel();
						final DSemanticDiagram diagram = (DSemanticDiagram) diagramModel.getElement();
						if (RepresentationsUtils.CLASS_DIAGRAM_Id.equals(diagram.getDescription().getName())) {
							KeyHandler keyHandler = viewer.getKeyHandler();
							if (keyHandler == null) {
								keyHandler = new KeyHandler();
							}

							keyHandler.put(KeyStroke.getPressed((char) 0x6, 0x66, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_F", RepresentationsUtils.CLASS_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x9, 0x69, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_I", RepresentationsUtils.CLASS_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xf, 0x6f, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_O", RepresentationsUtils.CLASS_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x1, 0x61, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_A", RepresentationsUtils.CLASS_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x5, 0x65, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_E", RepresentationsUtils.CLASS_DIAGRAM_Id));
							viewer.setKeyHandler(keyHandler);

						} else if (RepresentationsUtils.FeatureModel_DIAGRAM_Id
								.equals(diagram.getDescription().getName())) {
							KeyHandler keyHandler = viewer.getKeyHandler();
							if (keyHandler == null) {
								keyHandler = new KeyHandler();
							}

							keyHandler.put(KeyStroke.getPressed((char) 0x6, 0x66, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_F", RepresentationsUtils.FeatureModel_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xf, 0x6f, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_O", RepresentationsUtils.FeatureModel_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x1, 0x61, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_A", RepresentationsUtils.FeatureModel_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x18, 0x78, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_X", RepresentationsUtils.FeatureModel_DIAGRAM_Id));
							viewer.setKeyHandler(keyHandler);

						} else if (RepresentationsUtils.FeatureModule_DIAGRAM_Id
								.equals(diagram.getDescription().getName())) {
							KeyHandler keyHandler = viewer.getKeyHandler();
							if (keyHandler == null) {
								keyHandler = new KeyHandler();
							}

							keyHandler.put(KeyStroke.getPressed((char) 0x13, 0x73, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_S", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x12, 0x72, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_R", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x14, 0x74, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_T", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xd, 0xd, 0x0), new ActionKey_Class(viewer,
									diagramEditPart, "ENTER", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xd, 0x1000050, 0x0), new ActionKey_Class(viewer,
									diagramEditPart, "ENTER", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x20, 0x20, 0x40000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_SPACE", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x20, 0x20, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_SPACE", RepresentationsUtils.FeatureModule_DIAGRAM_Id));
							
							viewer.setKeyHandler(keyHandler);

						}
						else if (RepresentationsUtils.FRAGMENT_DIAGRAM_Id
								.equals(diagram.getDescription().getName())) {
							KeyHandler keyHandler = viewer.getKeyHandler();
							if (keyHandler == null) {
								keyHandler = new KeyHandler();
							}

							keyHandler.put(KeyStroke.getPressed((char) 0x13, 0x73, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_S", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x12, 0x72, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_R", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x14, 0x74, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_T", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xd, 0xd, 0x0), new ActionKey_Class(viewer,
									diagramEditPart, "ENTER", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0xd, 0x1000050, 0x0), new ActionKey_Class(viewer,
									diagramEditPart, "ENTER", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x20, 0x20, 0x40000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_SPACE", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							keyHandler.put(KeyStroke.getPressed((char) 0x20, 0x20, 0x50000), new ActionKey_Class(viewer,
									diagramEditPart, "CTRL_ALT_SPACE", RepresentationsUtils.FRAGMENT_DIAGRAM_Id));
							viewer.setKeyHandler(keyHandler);

						}
					} catch (Exception excep) {
						java.lang.System.err.println("Key Handler could not be associated with the diagram");
					}
				}
			}
		}
	}

}
