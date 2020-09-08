package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.IntType;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class DNDOperationsForGuard extends AbstractDNDOperations {
	static ToolTip tip;

	public static void setDragDropTarget(Control targetControl) {
		Shell shell = targetControl.getShell();

		tip = new ToolTip(shell, SWT.BALLOON);
		tip.setText("hold down SHIFT to extend Guard");

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
				// detail=2 (SHIFT KEY HOLD DOWN) => Add to guard

				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {

					Object element = dragSource.getData(((String) event.data));

//					String guardtext = setGuardOnDrop(element, EmbeddedEditorGenerator.editor_Guard);
//
//					EmbeddedEditorGenerator.UpdateXtextModel(false, true, false, guardtext);
//
//					EmbeddedEditorGenerator.UpdateXtextModel(false, true, false, "");

					boolean showContentAssistOnDrop = setGuardOnDrop(element, event.detail);

					boolean showContentAssistIfAssociationExists = EmbeddedEditorGenerator.UpdateXtextModel(false, true,
							false, "");

					if (showContentAssistOnDrop && showContentAssistIfAssociationExists) {
						openContentAssist();
					}
					dragSource = null;

				}
			}

		});
	}

	protected static boolean setGuardOnDrop(Object element, int detail) {
		try {
			// detail=1 => replace All
			// detail=2 (SHIFT KEY HOLD DOWN) => Add to guard

			if (element instanceof ExprRef) {

				Guard newGuard = null;
				if (detail == 1)// replaceAll
				{
					newGuard = ModelUtils2.CreateConditionalEqualGuard((ExprRef) element, null, false);
				} else if (detail == 2) {
					newGuard = ModelUtils2.CreateConditionalEqualGuard((ExprRef) element, null, false,
							CommonSpaceForContextualUI.getCurrentTransition().getGuard());
				}
				ModelOperations2.setTransitionGuard(CommonSpaceForContextualUI.getCurrentTransition(), newGuard);
				return true;
			} else if (element instanceof RefMessage) {
				Message msg = ((RefMessage) element).getRefMsg();
				return setGuardOnDrop(msg, detail);

			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void openContentAssist() {
		try {
			String guardtext = EmbeddedEditorGenerator.editor_Guard.getViewer().getTextWidget().getText();

			int logicop_index = guardtext.lastIndexOf("=");
			if (logicop_index > -1) {

				EmbeddedEditorGenerator.editor_Guard.getViewer().getTextWidget().setSelection(logicop_index + 1);

				EmbeddedEditorGenerator.editor_Guard.getViewer().getContentAssistant().showPossibleCompletions();
				setFocusForContentAssistant(EmbeddedEditorGenerator.editor_Guard.getViewer());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String setGuardOnDrop(Object data, EmbeddedEditor editor_Guard) {
		StyledText textWidget = editor_Guard.getViewer().getTextWidget();
		boolean isBool = false;
		String text = "";

		if (CommonSpaceForContextualUI.getCurrentTransition() != null) {
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				text = refMsg.getRefMsg().getName();

				if (refMsg.getRefMsg().getType() instanceof BoolType) {
					text = refMsg.getRefMsg().getName() + " = true";
					isBool = true;
				} else if (refMsg.getRefMsg().getType() instanceof IntType) {
					text = "#" + refMsg.getRefMsg().getName() + " = ";
					isBool = false;
				}

			} else if (data instanceof Attribute) {
				Attribute att = (Attribute) data;

				Concept parentClass = ModelUtils.getTypedRootForObject(att, Concept.class);

				if (att.getType() instanceof BoolType) {
					text = parentClass.getName() + "." + att.getName() + " = true";
					isBool = true;
				} else if (att.getType() instanceof IntType) {
					text = "#" + parentClass.getName() + "." + att.getName() + " = ";
					isBool = false;
				} else {
					text = parentClass.getName() + "." + att.getName();
				}

			} else if (data instanceof Function) {
				Function func = (Function) data;

				Concept parentClass = ModelUtils.getTypedRootForObject(func, Concept.class);

				if (func.getType() instanceof BoolType) {
					text = parentClass.getName() + "." + func.getName() + " = true";
					isBool = true;
				} else {
					text = parentClass.getName() + "." + func.getName();
				}
			}

			if (isBool) {
				text = "[" + text + "]";
				// textWidget.setText(text);
			} else {
				if (text.trim() == "") {
					// textWidget.setText("[]");
					text = "[ ]";
				} else {

					if (textWidget.getText().replace(" ", "").trim().equals("[]")) {
						text = "[ " + text + " ]";
						// textWidget.setText("[ " + text + " ]");
					} else if (!(textWidget.getText().trim().startsWith("[")
							&& textWidget.getText().trim().endsWith("]"))) {
						text = "[ " + text + " ]";
						// textWidget.setText("[" + text + "]");
					} else {
						// System.out.println(textWidget.getText());
						// textWidget.replaceTextRange(textWidget.getCaretOffset(), 0, text);
						int inserPoint = textWidget.getCaretOffset();
						String oldText = textWidget.getText();
						// textWidget.insert(text);
						// System.out.println(textWidget.getText());
						text = oldText.substring(0, inserPoint) + text + oldText.substring(inserPoint);
						// System.out.println(text);
					}
				}
			}
		}

		// due to grammar , a guard cannot be just like [msg]; it should be like
		// "[msg=]" at least
		if (!text.contains("=") && !text.contains("<>") && !text.contains(">") && !text.contains("<")
				&& !text.contains(">=") && !text.contains("=>") && !text.contains("<=") && !text.contains("=<"))
			text = text.replace("]", "= ]");

		return text;

	}
}
