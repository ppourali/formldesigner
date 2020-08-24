package uw.cs.watform.forml.services.GUI.CustomControls;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;

public class CustomControlAcceptButton extends Composite {

	private Button acceptButton;

	public CustomControlAcceptButton(Composite parent) {
		super(parent, SWT.NO_BACKGROUND);

		constructDesign();
	}

	private void constructDesign() {
		acceptButton = new Button(this, SWT.PUSH);
		acceptButton.setText("Save");
		acceptButton.setBounds(0, 0, 89, 26);
		acceptButton.setImage(SWTResourceManager.getImage(FrmShellForSetGuardGraphicallyDialog.class,
				"/uw/cs/watform/forml/services/GUI/res/window_accept.png"));

		AddListeners();
	}

	private void AddListeners() {
		acceptButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// CommonSpaceForContextualUI.rollbackEveryThing();
				CommonSpaceForContextualUI.confirmFlag = true;
				CommonSpaceForContextualUI.getShell().disposeShell();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		/*
		 * acceptButton.addSelectionListener(new SelectionListener() {
		 * 
		 * @Override public void widgetSelected(SelectionEvent e) {
		 * 
		 * if (CommonSpaceForContextualUI.getCurrentTransition() != null) { //
		 * commonspace.setTransitionParts();
		 * 
		 * boolean eventOK =
		 * CommonSpaceForContextualUI.embeddedEditor_Event.finalSaveEditor(true);
		 * boolean guardOK =
		 * CommonSpaceForContextualUI.embeddedEditor_Guard.finalSaveEditor(true);
		 * boolean actionOK =
		 * CommonSpaceForContextualUI.embeddedEditor_Action.finalSaveEditor(true);
		 * 
		 * if (eventOK && guardOK && actionOK) { EObject ev =
		 * CommonSpaceForContextualUI.embeddedEditor_Event
		 * .getupdatedresource(CommonSpaceForContextualUI.embeddedEditor_Event.
		 * eventSemanticElementFragment); EObject g =
		 * CommonSpaceForContextualUI.embeddedEditor_Guard
		 * .getupdatedresource(CommonSpaceForContextualUI.embeddedEditor_Guard.
		 * guardSemanticElementFragment); EObject a =
		 * CommonSpaceForContextualUI.embeddedEditor_Action
		 * .getupdatedresource(CommonSpaceForContextualUI.embeddedEditor_Action.
		 * actionSemanticElementFragment);
		 * 
		 * final TransactionalEditingDomain editingDomain = TransactionUtil
		 * .getEditingDomain(CommonSpaceForContextualUI.getCurrentTransition());
		 * editingDomain.getCommandStack() .execute(new RecordingCommand(editingDomain,
		 * "update resource transition change.") {
		 * 
		 * @Override protected void doExecute() {
		 * 
		 * if (ev instanceof Trigger)
		 * CommonSpaceForContextualUI.getCurrentTransition().setTrig((Trigger) ev); else
		 * if (ev instanceof Transition)
		 * CommonSpaceForContextualUI.getCurrentTransition().setTrig(((Transition)
		 * ev).getTrig()); else if (ev == null)
		 * CommonSpaceForContextualUI.getCurrentTransition().setTrig(null);
		 * 
		 * CommonSpaceForContextualUI.getCurrentTransition().setGuard((Guard) g);
		 * CommonSpaceForContextualUI.getCurrentTransition().setList((WCAList) a);
		 * 
		 * } });
		 * 
		 * CommonSpaceForContextualUI.getShell().dispose(); } else {
		 * JOptionPane.showMessageDialog(null,
		 * "The recent changes on contain errors. Please fix before saving the changes."
		 * ); } }
		 * 
		 * }
		 * 
		 * @Override public void widgetDefaultSelected(SelectionEvent e) { // TODO
		 * Auto-generated method stub
		 * 
		 * } });
		 */

	}

	public void setText(String string) {
		acceptButton.setText(string);
	}

}
