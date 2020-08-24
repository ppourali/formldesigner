package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.texteditor.IUpdate;

class TextViewerAction extends Action implements IUpdate {

	private int fOperationCode= -1;
	private ITextOperationTarget fOperationTarget;

	/**
	 * Creates a new action.
	 *
	 * @param viewer the viewer
	 * @param operationCode the opcode
	 */
	public TextViewerAction(ITextViewer viewer, int operationCode) {
		fOperationCode = operationCode;
		fOperationTarget = viewer.getTextOperationTarget();
		update();
	}

	/**
	 * Updates the enabled state of the action.
	 * Fires a property change if the enabled state changes.
	 *
	 * @see Action#firePropertyChange(String, Object, Object)
	 */
	public void update() {
		boolean wasEnabled = isEnabled();
		boolean isEnabled = (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
		setEnabled(isEnabled);

		if (wasEnabled != isEnabled) {
			firePropertyChange(ENABLED, wasEnabled ? Boolean.TRUE : Boolean.FALSE, isEnabled ? Boolean.TRUE : Boolean.FALSE);
		}
	}

	/**
	 * @see Action#run()
	 */
	@Override
	public void run() {
		if (fOperationCode != -1 && fOperationTarget != null) {
			fOperationTarget.doOperation(fOperationCode);
		}
	}
}