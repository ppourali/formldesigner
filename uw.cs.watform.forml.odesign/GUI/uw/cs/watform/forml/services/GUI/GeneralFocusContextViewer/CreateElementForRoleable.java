package uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;

public class CreateElementForRoleable extends Dialog {

	private Text text;
	private Combo comboType;
	private Text txtRoleableName;
	private Shell dialog;

	private boolean successfullyCreated = false;
	private Roleable currentRoleable;

	public CreateElementForRoleable(Shell parent, Roleable roleable) {
		super(parent);
		this.currentRoleable = roleable;
	}

	private void setLocation() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation(dim.width / 2 - dialog.getSize().x / 2, 100);
	}

	public boolean open(String defaultElementName, String type) {
		Shell parent = getParent();
		dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setSize(514, 108);
		dialog.setText("Create Element");
		setLocation();

		text = new Text(dialog, SWT.BORDER);
		text.setBounds(48, 10, 103, 21);
		text.addKeyListener(EnterKeyListener());
		text.setText(defaultElementName);

		Label lblName = new Label(dialog, SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		lblName.setBounds(10, 13, 32, 15);
		lblName.setText("Name");

		Label lblClass = new Label(dialog, SWT.NONE);
		lblClass.setAlignment(SWT.RIGHT);
		lblClass.setText("Container Class");
		lblClass.setBounds(157, 13, 91, 15);

		txtRoleableName = new Text(dialog, SWT.READ_ONLY);
		txtRoleableName.setBounds(254, 10, 91, 23);

		Label lblType = new Label(dialog, SWT.NONE);
		lblType.setAlignment(SWT.RIGHT);
		lblType.setText("Type");
		lblType.setBounds(376, 13, 25, 15);

		comboType = new Combo(dialog, SWT.READ_ONLY);
		comboType.setBounds(407, 10, 91, 23);
		comboType.select(0);
		comboType.addKeyListener(EnterKeyListener());

		Button btnCreate = new Button(dialog, SWT.NONE);
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createElement();

			}
		});
		btnCreate.setBounds(238, 44, 75, 25);
		btnCreate.setText("Create");

		Button btnCancel = new Button(dialog, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				successfullyCreated = false;
				dialog.dispose();
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setBounds(157, 44, 75, 25);

		txtRoleableName.setText(this.currentRoleable.getName());
		// combo_Class.setData(this.currentRoleable);

		fillComboType(comboType, type);// comboType.setItems(new String[] { "Attribute","Function", "Input Message",
									// "Output Message" });

		dialog.open();
		Display display = Display.getDefault();
		while (!dialog.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return successfullyCreated;
	}

	private void fillComboType(Combo comboType2, String type) {
		String selectedclass = txtRoleableName.getText();
		Object roleable = this.currentRoleable;// combo_Class.getData(selectedclass);
		if (roleable instanceof Feature) {
			comboType2.setItems(new String[] { "Attribute", "Input Message", "Output Message" });

		} else if (roleable instanceof Entity) {
			comboType2.setItems(new String[] { "Attribute", "Function" });
		}
		comboType2.setText(type);

	}

	private KeyListener EnterKeyListener() {
		return new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					createElement();

			}
		};
	}



	protected void createElement() {
		try {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(this.currentRoleable);
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@java.lang.Override
				protected void doExecute() {

					String newElementText = text.getText().replace(" ", "").trim();
					String selectedclass = txtRoleableName.getText();
					Object roleable = currentRoleable;
					if (roleable instanceof Feature || roleable instanceof Entity) {

						if (comboType.getText().equals("Attribute")) {
							ModelOperations2.CreateNewAttribute(currentRoleable, newElementText);
						} else {
							if (roleable instanceof Feature) {
								if (comboType.getText().equals("Input Message")) {
									ModelOperations.addNewInputMessageToFeature((Feature) roleable,
											FormlFactory.eINSTANCE.createInput(), newElementText);

								} else if (comboType.getText().equals("Output Message")) {
									ModelOperations.addNewOutputMessageToFeature((Feature) roleable,
											FormlFactory.eINSTANCE.createOutput(), newElementText);

								}
							} else if (roleable instanceof Entity) {
								if (comboType.getText().equals("Function")) {
									ModelOperations2.CreateFunctionForEntity((Entity) roleable, newElementText);
								}
							}
						}
						successfullyCreated = true;
						dialog.close();

					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			successfullyCreated = false;
		}
	}
}
