package uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomControlFeaturePreview;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.FrmShellForSetGuardGraphicallyDialog;

public class CustomCompositeCreateNewElement extends Composite {

	String hint = "please enter a new name here";
	private Text txtElementName;

	public CustomCompositeCreateNewElement(Composite parent, int style, Class type,
			CustomControlFeaturePreview customControlFeaturePreview) {
		super(parent, style);
		constructDesign(type, customControlFeaturePreview);

	}

	private void constructDesign(Class type, CustomControlFeaturePreview customControlFeaturePreview) {
		setLayout(new GridLayout(2, false));

		// txtElementName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1,
		// 1));

		String buttonText = "";
		if (type.equals(Attribute.class)) {
			buttonText = "New Attribute";
		} else if (type.equals(Input.class)) {
			buttonText = "New Input Message";
		} else if (type.equals(Output.class)) {
			buttonText = "New Output Message";
		} else if (type.equals(Function.class)) {
			buttonText = "New Function";
		} else {
			return;
		}
		txtElementName = new Text(this, SWT.BORDER);
		Button btnNew = new Button(this, SWT.CENTER);
		GridData gd_btnNew = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_btnNew.heightHint = 22;
		btnNew.setLayoutData(gd_btnNew);
		btnNew.setImage(SWTResourceManager.getImage(FrmShellForSetGuardGraphicallyDialog.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_addButton16.png"));
		GridData gd_btnNewAttribute = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_btnNewAttribute.heightHint = 15;
		// btnNew.setLayoutData(gd_btnNewAttribute);
		btnNew.setText("Create");
		btnNew.setEnabled(false);
		btnNew.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				createNewElement(type, customControlFeaturePreview);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtElementName.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txtElementName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txtElementName.setVisible(true);
		txtElementName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (txtElementName.getText().trim().equals("") || txtElementName.getText().trim().contains(" ")) {
					txtElementName.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.ITALIC));
					txtElementName.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));

					btnNew.setEnabled(false);
				} else {
					txtElementName.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
					txtElementName.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

					btnNew.setEnabled(true);
				}
			}
		});
		txtElementName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtElementName.getText().trim().equals("")) {
					txtElementName.setText(hint);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtElementName.getText().trim().equals(hint)) {
					txtElementName.setText("");
				}
			}
		});
		txtElementName.setText(hint);

		txtElementName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR) {
					createNewElement(type, customControlFeaturePreview);
				}

			}
		});
		this.layout(true, true);

	}

	protected void createNewElement(Class type, CustomControlFeaturePreview customControlFeaturePreview) {
		customControlFeaturePreview.createNewAttOrMsg(type, txtElementName.getText().replace(" ", ""));

	}

}
