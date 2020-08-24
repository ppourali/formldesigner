package uw.cs.watform.forml.services.GUI.CustomControls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.GUI.CustomPopupMenuForWCE;
import uw.cs.watform.forml.services.GUI.FrmShellForTriggerOperationsView;
import uw.cs.watform.forml.services.GUI.PopupContainer;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class CustomSearchTextForWCE extends Composite {

	public StyledText txtFilter;

	private FormToolkit formToolkit;
	private List lstOperations;
	private Shell shell;
	FrmShellForTriggerOperationsView container;

	public Feature parentFeature;

	public CustomSearchTextForWCE(Shell parent, FrmShellForTriggerOperationsView parentForm,
			Feature containingFeature) {

		super(parent, SWT.BORDER);
		this.shell = parent;
		this.formToolkit = parentForm.formToolkit;
		this.container = parentForm;
		this.parentFeature = containingFeature;

		CreateTextField();

		AddListeners();

		CreatePopUpMenu();
	}

	public void setListObject(List lstOps) {
		this.lstOperations = lstOps;
	}

	private void AddListeners() {
		txtFilter.addKeyListener(TextKeyListener());

	}

	private KeyListener TextKeyListener() {
		KeyListener kl = new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.stateMask == SWT.CONTROL && e.keyCode == SWT.SPACE) {
					showPopUpMenu();
				}

				if (e.keyCode == SWT.ARROW_DOWN) {
					MoveBelowOnList();
					e.doit = false;
				} else if (e.keyCode == SWT.ARROW_UP) {
					MoveUpOnList();
					e.doit = false;
				} else if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {

					Object retItem = container.analyzeReturnItem();
					if (retItem != null) {

						if (retItem instanceof ExprRef) {
							container.returenItem = (ExprRef) retItem;
							container.ConfirmFlag = true;
						} else {
							container.ConfirmFlag = false;
						}
						shell.dispose();
					}

				} else if (e.keyCode == SWT.KEYPAD_ADD) {
					e.doit = false;
					txtFilter.getText().replace("+", "-");
					Object retItem = container.analyzeReturnItem();
					if (retItem != null) {

						if (retItem instanceof ExprRef) {
							container.returenItem = (ExprRef) retItem;
							container.setAddEvent();
						} else {
							container.setNoEvent();
						}
						shell.dispose();
					}

				} else if (e.keyCode == SWT.KEYPAD_SUBTRACT) {
					e.doit = false;
					txtFilter.getText().replace("+", "-");

					Object retItem = container.analyzeReturnItem();
					if (retItem != null) {

						if (retItem instanceof ExprRef) {
							container.returenItem = (ExprRef) retItem;
							container.setRemoveEvent();
						} else {
							container.setNoEvent();
						}
						shell.dispose();
					}

				} else if (e.keyCode == SWT.ESC) {
					container.setNoEvent();
					shell.dispose();
				} else {
					FilterLstOperationsByText();
				}

			}
		};

		return kl;

	}

	protected void showPopUpMenu() {
		int x = shell.getLocation().x + txtFilter.getLocation().x + 10;
		int y = shell.getLocation().y + txtFilter.getLocation().y + txtFilter.getSize().y;

		txtFilter.getMenu().setLocation(x, y);

		txtFilter.getMenu().setVisible(true);
	}

	protected void CreatePopUpMenu() {

		CustomPopupMenuForWCE popupMenu = new CustomPopupMenuForWCE(this.txtFilter, this.parentFeature, this);

	}

	public void FilterLstOperationsByText() {
		if (txtFilter.getText().equals("")) {

			txtFilter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
			container.populateOperationsList(txtFilter.getText());

		} else {
			txtFilter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			container.populateOperationsList(txtFilter.getText());
		}
	}

	protected void MoveUpOnList() {
		if (lstOperations.getItemCount() > 0) {
			lstOperations.select(MoveUp());
		}

	}

	private int MoveUp() {
		int newIndex = lstOperations.getItemCount() - 1;

		if (lstOperations.getSelectionIndex() > 0) {
			newIndex = lstOperations.getSelectionIndex() - 1;
		}

		return newIndex;
	}

	protected void MoveBelowOnList() {
		if (lstOperations.getItemCount() > 0) {
			lstOperations.select(MoveBelow());
		}
	}

	protected int MoveBelow() {
		int newIndex = 0;

		if (lstOperations.getSelectionIndex() < lstOperations.getItemCount() - 1) {
			newIndex = lstOperations.getSelectionIndex() + 1;
		}

		return newIndex;
	}

	private void CreateTextField() {
		txtFilter = new StyledText(this, SWT.BORDER | SWT.SINGLE);
		formToolkit.adapt(txtFilter, true, true);

		txtFilter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		txtFilter.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.ITALIC));

	}

}
