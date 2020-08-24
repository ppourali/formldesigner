package uw.cs.watform.forml.services.keyboard;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;

import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

/**
 * An Action Class to handle the key strokes on the diagrams.
 * 
 * @author ppourali
 *
 */
public class ActionKey_Class implements IAction {

	EditPartViewer viewer;
	DiagramEditPart parentDiagramEditPart;
	String Represention_ID;
	String keyCode;

	public ActionKey_Class(EditPartViewer v, DiagramEditPart diagramEditPart, String kcode, String DiagramId) {
		this.viewer = v;
		this.parentDiagramEditPart = diagramEditPart;
		this.Represention_ID = DiagramId;
		this.keyCode = kcode;
	}

	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAccelerator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getActionDefinitionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelpListener getHelpListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getHoverImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMenuCreator getMenuCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChecked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			if (Represention_ID.equals(RepresentationsUtils.CLASS_DIAGRAM_Id)) {
				// Class Diagram Actions
				if (this.keyCode.equals("CTRL_ALT_F")) {
					// TODO: fix position of the feature on diagram
					SharedKeyBoardActionsOnClassDiagram.createFeature(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_I")) {
					SharedKeyBoardActionsOnClassDiagram.createInputMessage(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_O")) {
					SharedKeyBoardActionsOnClassDiagram.createOutputMessage(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_A")) {
					SharedKeyBoardActionsOnClassDiagram.createAttribute(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_E")) {
					SharedKeyBoardActionsOnClassDiagram.createEntity(this.viewer, this.parentDiagramEditPart);
				}
			}
			// FeatureModel Actions
			else if (Represention_ID.equals(RepresentationsUtils.FeatureModel_DIAGRAM_Id)) {
				if (this.keyCode.equals("CTRL_ALT_F")) {
					SharedKeyBoardActionsOnFeatureModel.createFeatureNode(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_A")) {
					SharedKeyBoardActionsOnFeatureModel.createAndNode(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_O")) {
					SharedKeyBoardActionsOnFeatureModel.createOrNode(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_X")) {
					SharedKeyBoardActionsOnFeatureModel.createXorNode(this.viewer, this.parentDiagramEditPart);
				}
			}
			// FeatureModule Actions
			else if (Represention_ID.equals(RepresentationsUtils.FeatureModule_DIAGRAM_Id)
					|| Represention_ID.equals(RepresentationsUtils.FRAGMENT_DIAGRAM_Id)) {
				if (this.keyCode.equals("CTRL_ALT_S")) {
					SharedKeyBoardActionsOnFeatureModule.createState(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_R")) {
					SharedKeyBoardActionsOnFeatureModule.createRegion(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_T")) {
					SharedKeyBoardActionsOnFeatureModule.creatTransition(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("ENTER")) {
					SharedKeyBoardActionsOnFeatureModule.editTransition(this.viewer, this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_SPACE")) {
					SharedKeyBoardActionsOnFeatureModule.handleCtrlKeyPressInFeatureModule(this.viewer,
							this.parentDiagramEditPart);
				} else if (this.keyCode.equals("CTRL_ALT_SPACE")) {
					SharedKeyBoardActionsOnFeatureModule.openWCAActionAssistant(this.viewer,
							this.parentDiagramEditPart);
				}
			}
		} catch (Exception e) {
			System.err.println("Keyboard shortcut failed");
		}
	}

	@Override
	public void runWithEvent(Event event) {
	}

	@Override
	public void setActionDefinitionId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChecked(boolean checked) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDescription(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDisabledImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHelpListener(HelpListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHoverImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMenuCreator(IMenuCreator creator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolTipText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAccelerator(int keycode) {
		// TODO Auto-generated method stub

	}

}
