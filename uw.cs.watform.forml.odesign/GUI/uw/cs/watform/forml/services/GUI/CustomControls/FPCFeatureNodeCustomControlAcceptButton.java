package uw.cs.watform.forml.services.GUI.CustomControls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;

public class FPCFeatureNodeCustomControlAcceptButton extends Composite {

	private Button acceptButton;

	public FPCFeatureNodeCustomControlAcceptButton(Composite parent) {
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
				FPC_SingletonData.confirmFlag = true;
				FPC_SingletonData.getShell().disposeShell();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void setText(String string) {
		acceptButton.setText(string);
	}

}
