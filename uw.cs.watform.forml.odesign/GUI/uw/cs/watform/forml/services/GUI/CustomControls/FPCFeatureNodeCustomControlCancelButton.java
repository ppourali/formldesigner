package uw.cs.watform.forml.services.GUI.CustomControls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.odesign.GUI.tabularGuard.CommonSpace;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class FPCFeatureNodeCustomControlCancelButton extends Composite {

	private Button canceltButton;

	public FPCFeatureNodeCustomControlCancelButton(Composite parent) {
		super(parent, SWT.NO_BACKGROUND);
		constructDesign();
	}

	private void constructDesign() {
		canceltButton = new Button(this, SWT.PUSH);

		canceltButton.setText("Cancel");
		canceltButton.setBounds(0, 0, 89, 26);

		canceltButton.setImage(SWTResourceManager.getImage(FrmShellForSetGuardGraphicallyDialog.class,
				"/uw/cs/watform/forml/services/GUI/res/window_close.png"));

		AddListeners();
	}

	private void AddListeners() {
		canceltButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// CommonSpaceForContextualUI.rollbackEveryThing();
				FPC_SingletonData.confirmFlag=false;
				FPC_SingletonData.getShell().disposeShell();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void setText(String string) {
		canceltButton.setText(string);
	}

}
