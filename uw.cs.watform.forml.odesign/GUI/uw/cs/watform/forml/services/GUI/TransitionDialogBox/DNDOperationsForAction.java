package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;

import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CustomEmbeddedEditorResourceProvider;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class DNDOperationsForAction extends AbstractDNDOperations {

	static ToolTip tip;

	public static void setDragDropTarget(Control targetControl) {
		Shell shell = targetControl.getShell();

		tip = new ToolTip(shell, SWT.BALLOON);
		tip.setText("hold down SHIFT to extend Action");

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

					Point loc = targetControl.toDisplay(targetControl.getLocation());
					tip.setLocation(loc.x - targetControl.getBorderWidth(), loc.y + targetControl.getSize().y);
					tip.setVisible(true);

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
				tip.setVisible(false);
			}

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {

				// detail=1 => replace All
				// detail=2 (SHIFT KEY HOLD DOWN) => Add to action

				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {

					Object element = dragSource.getData(((String) event.data));

					boolean shouldReplaceAll = CommonSpaceForContextualUI.replaceAllAction;
					if (event.detail == 2)
						shouldReplaceAll = false;

					boolean showContentAssist = setActionOnDrop(element, shouldReplaceAll);

					EmbeddedEditorGenerator.UpdateXtextModel(false, false, true, null);

					if (showContentAssist) {
						openContentAssist();
					}

					dragSource = null;

				}
			}

		});
	}

	private static void openContentAssist() {
		try {

			String actiontext = EmbeddedEditorGenerator.editor_Action.getViewer().getTextWidget().getText();

			// int assignmentop_index = actiontext.indexOf(":=");
			int assignmentop_last_index = actiontext.lastIndexOf(":=");
			// if (assignmentop_index == assignmentop_last_index) {
			if (assignmentop_last_index > -1) {

				EmbeddedEditorGenerator.editor_Action.getViewer().getTextWidget()
						.setSelection(assignmentop_last_index + 2);

				EmbeddedEditorGenerator.editor_Action.getViewer().getContentAssistant().showPossibleCompletions();

				setFocusForContentAssistant(EmbeddedEditorGenerator.editor_Action.getViewer());

			}
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean setActionOnDrop(Object data, boolean shouldReplaceAll) {
		if (CommonSpaceForContextualUI.getCurrentTransition() != null) {
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				if (refMsg.getRefMsg() instanceof Output) {
					ModelOperations2.setoraddTransitionAction(CommonSpaceForContextualUI.getCurrentTransition(), "",
							refMsg.getRefMsg(), true, shouldReplaceAll);
				}
			} else if (data instanceof Function) {
				Function func = (Function) data;

				ModelOperations2.setoraddTransitionAction(CommonSpaceForContextualUI.getCurrentTransition(), "", func,
						true, shouldReplaceAll);

			} else if (data instanceof Attribute) {
				Attribute att = (Attribute) data;

				ModelUtils2.CreateAssignmentForAction(att, null, CommonSpaceForContextualUI.getCurrentTransition(),
						shouldReplaceAll, false);

				return true;

			}
		}
		return false;

	}
}
