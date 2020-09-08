package uw.cs.watform.forml.odesign.GUI.tabularGuard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;
import uw.cs.watform.forml.services.utilities.ModelOperations2;

public class CommonSpace {
	private Shell shell;
	private FrmShellForSetGuardGraphicallyDialog container;
	private Transition tranistion;
	private ExprRef draggedDataForGuard;
	private Concept draggedDataForAction;
	private Button btnTriggeringEventAdding;
	private ExprRef triggeringEObject;
	private int isAddingtriggeringEObject; // 0=add+ 1=remove-
											// 2=attribute
	
	public HashMap<Color, Boolean> colors = new HashMap<Color, Boolean>();

	private List<ExprRef> actionEObject = new ArrayList<ExprRef>();
	private Text txtLivePreview;

	public CommonSpace(FrmShellForSetGuardGraphicallyDialog frmShellForSetGuardGraphicallyDialog) {
		setContainer(frmShellForSetGuardGraphicallyDialog);
		initColors();
	}

	public void setShell(Shell shellInput) {
		this.shell = shellInput;
	}

	public Shell getShell() {
		return shell;
	}

	public FrmShellForSetGuardGraphicallyDialog getContainer() {
		return container;
	}

	public void setContainer(FrmShellForSetGuardGraphicallyDialog container) {
		this.container = container;
	}

	public Transition getTranistion() {
		return tranistion;
	}

	public void setTranistion(Transition tranistion) {
		this.tranistion = tranistion;
	}

	public ExprRef getDraggedDataForGuard() {
		ExprRef temp = this.draggedDataForGuard;
		// this.setDraggedData(null);
		return temp;
	}

	public void setDraggedDataForGuard(ExprRef draggedData) {
		this.draggedDataForGuard = draggedData;
	}

	public ExprRef getTriggeringEObject() {
		return triggeringEObject;
	}

	public void setTriggeringEObject(ExprRef triggeringEObject) {
		this.triggeringEObject = triggeringEObject;
	}

	public void setTransitionParts() {

		
		if (this.getTriggeringEObject() != null) {
			// System.out.println("event changed");
			if (getIsAddingtriggeringEObject() != 1) {
				ModelOperations2.setTransitionTrigger(this.getTranistion(), this.getTriggeringEObject(), true);
			} else if (getIsAddingtriggeringEObject() == 1) {
				ModelOperations2.setTransitionTrigger(this.getTranistion(), this.getTriggeringEObject(), false);
			}
		}
		if (!actionEObject.isEmpty()) {
			// System.out.println("action changed");

			tranistion.getList().getActions().clear();
			for (ExprRef action : actionEObject) {
				ModelOperations2.setoraddTransitionAction(tranistion, "", action, true,true);
			}
		}
		this.getShell().dispose();
	}

	public int getIsAddingtriggeringEObject() {
		return isAddingtriggeringEObject;
	}

	public void setIsAddingtriggeringEObject(int isAddingtriggeringEObject) {
		this.isAddingtriggeringEObject = isAddingtriggeringEObject;
	}

	public List<ExprRef> getActionEObject() {
		return actionEObject;
	}

	public void setActionEObject(List<ExprRef> actionEObject) {
		this.actionEObject = actionEObject;
	}

	public Concept getDraggedDataForAction() {
		return draggedDataForAction;
	}

	public void setDraggedDataForAction(Concept draggedDataForAction) {
		this.draggedDataForAction = draggedDataForAction;
	}

	

	public Button getBtnTriggeringEventAdding() {
		return btnTriggeringEventAdding;
	}

	public void setBtnTriggeringEventAdding(Button btnTriggeringEventAdding) {
		this.btnTriggeringEventAdding = btnTriggeringEventAdding;
	}

	public void showPreviousTable() {

		//btnBackHandler();

		// show home table
		// tables.get(0).show();

		// hide all other tables
		// for(int i=1; i<tables.size(); i++)
		// {
		// tables.get(i).hide();
		// }

	}

//	public void btnBackHandler() {
//		if (getOpenTables().size() <= 1)
//			container.getComposite_TransitionPartsHolder().getBtnBack().setEnabled(false);
//		else
//			container.getComposite_TransitionPartsHolder().getBtnBack().setEnabled(true);
//	}



	public Color getColor() {

		for (Color c : colors.keySet()) {
			if (colors.get(c))
				continue;
			else {
				colors.put(c, true);
				return c;
			}
		}

		initColors();
		
		Color c = colors.keySet().iterator().next();
		colors.put(c, true);
		return c;

	}

	private void initColors() {

		Display display = Display.getCurrent();
		Color[] cols = { display.getSystemColor(SWT.COLOR_GRAY), display.getSystemColor(SWT.COLOR_GREEN),
				display.getSystemColor(SWT.COLOR_BLUE), display.getSystemColor(SWT.COLOR_YELLOW),
				display.getSystemColor(SWT.COLOR_RED), display.getSystemColor(SWT.COLOR_MAGENTA) };

		for (Color c : cols) {
			colors.put(c, false);
		}
	}

	public Text getTxtLivePreview() {
		return txtLivePreview;
	}

	public void setTxtLivePreview(Text txtLivePreview) {
		this.txtLivePreview = txtLivePreview;
	}

}
