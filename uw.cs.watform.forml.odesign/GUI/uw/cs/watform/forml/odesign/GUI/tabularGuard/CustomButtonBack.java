package uw.cs.watform.forml.odesign.GUI.tabularGuard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;

public class CustomButtonBack extends Button {

	private CommonSpace commonspace;

	public CustomButtonBack(Composite parent, CommonSpace cs) {
		super(parent, SWT.NONE);
		this.setCommonspace(cs);
		initialize();

	}

	private void initialize() {
		setBounds(385, 0, 20, 20);
		setImage(SWTResourceManager.getImage(FrmShellForSetGuardGraphicallyDialog.class,
				"/uw/cs/watform/forml/services/GUI/res/back.png"));
		addSelectionListener(selectionListener());

	}

	private SelectionListener selectionListener() {

		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				commonspace.showPreviousTable();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	public CommonSpace getCommonspace() {
		return commonspace;
	}

	public void setCommonspace(CommonSpace commonspace) {
		this.commonspace = commonspace;
	}

	@Override
	protected void checkSubclass() {
		if (false)
			SWT.error(SWT.ERROR_INVALID_SUBCLASS);

	}
}
