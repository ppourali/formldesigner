package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForContextualUI;

public class oldCommonSpaceForContextualUI {
	/*
	private Roleable currentClass;
	private Transition currentTransition;
	private System originalSystem;

	private Shell shell;
	private FrmShellForSetGuardGraphicallyDialog container;
	public Composite composite_ActionHolder;
	public Composite composite_GuardHolder;
	public Composite composite_EventHolder;
	protected boolean replaceAllAction;
	

	public oldCommonSpaceForContextualUI(FrmShellForSetGuardGraphicallyDialog frmShellForSetGuardGraphicallyDialog) {
		setContainer(frmShellForSetGuardGraphicallyDialog);
	}

	public void setTriggeringEventOnDrop(Object data) {

		if (getCurrentTransition() != null) {
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				if (refMsg.getRefMsg() instanceof Input) {
					ModelOperations2.setTransitionTrigger(getCurrentTransition(), refMsg.getRefMsg(), true);
				}
			} else if (data instanceof Attribute) {
				Attribute att = (Attribute) data;

				ModelOperations2.setTransitionTrigger(getCurrentTransition(), att, true);

			}
		}
	}

	public Roleable getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(Roleable currentClass) {
		this.currentClass = currentClass;
	}

	public Transition getCurrentTransition() {
		return currentTransition;
	}

	public void setCurrentTransition(Transition currentTransition) {
		this.currentTransition = currentTransition;
	}

	public FrmShellForSetGuardGraphicallyDialog getContainer() {
		return container;
	}

	public void setContainer(FrmShellForSetGuardGraphicallyDialog container) {
		this.container = container;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public System getOriginalSystem() {
		return originalSystem;
	}

	public void setOriginalSystem(System originalSys) {
		this.originalSystem = FormlFactory.eINSTANCE.createSystem();
		this.originalSystem = EcoreUtil.copy(originalSys);

	}
//
//	public void rollbackCurrentTransition() {
//		
//		this.currentTransition.setTrig(getOriginalTransition().getTrig());
//		this.currentTransition.setGuard(getOriginalTransition().getGuard());
//		this.currentTransition.setList(getOriginalTransition().getList());
//
//	}

	public void rollbackEveryThing() {
//		ModelUtils.getTypedRootForObject(currentTransition, System.class).setWorldmodel(originalSystem.getWorldmodel());
//		;
//		ModelUtils.getTypedRootForObject(currentTransition, System.class)
//				.setBehaviourmodel(originalSystem.getBehaviourmodel());
//		;
	}

	public String setGuardOnDrop(Object data, EmbeddedEditor editor_Guard) {
		StyledText textWidget = editor_Guard.getViewer().getTextWidget();
		if (getCurrentTransition() != null) {
			String text = "";
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				text = refMsg.getRefMsg().getName();

				if (refMsg.getRefMsg().getType() instanceof BoolType) {
					text = refMsg.getRefMsg().getName() + " = true";
				}

			} else if (data instanceof Attribute) {
				Attribute att = (Attribute) data;
				text = att.getName();

				if (att.getType() instanceof BoolType) {
					text = att.getName() + " = true";
				}
			}

			if (text.trim() == "")
				textWidget.setText("[]");
			else if (textWidget.getText().replace(" ", "").trim().equals("[]")) {
				textWidget.setText("[" + text + "]");
			} else if (!(textWidget.getText().trim().startsWith("[") && textWidget.getText().trim().endsWith("]"))) {
				textWidget.setText("[" + text + "]");
			} else {
				textWidget.insert(text);
			}
		}

		return textWidget.getText();

	}

	public void setActionOnDrop(Object data) {
		if (getCurrentTransition() != null) {
			if (data instanceof RefMessage) {
				RefMessage refMsg = (RefMessage) data;
				if (refMsg.getRefMsg() instanceof Output) {
					ModelOperations2.setoraddTransitionAction(getCurrentTransition(), "", refMsg.getRefMsg(), true,
							replaceAllAction);
				}
			}
		}

	}

	public void clearTransitionEvent() {
		getCurrentTransition().setTrig(null);
		DNDOperationsForListItems.createTransitionEditor(getCurrentTransition(), true, Trigger.class, true);
	}

	public void clearTransitionGuard() {
//		Guard guard = FormlFactory.eINSTANCE.createGuard();
//		getCurrentTransition().setGuard(guard);
//		DNDOperationsForListItems.createTransitionEditor(getCurrentTransition(), true, Guard.class, true);

		DNDOperationsForListItems.editor_Guard.getViewer().getTextWidget().setText("[ ]");
		embeddedEditor_Guard.saveEditor(true);

	}
*/
}
