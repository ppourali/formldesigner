package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.general.JS_TransitionLabelServices;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CustomControlExpandBarForTransitionParts extends Composite {
	private int[] table_Actions_widths = { 75, 150 };
	private Composite composite_AllHolder;
	private Composite grpTriggeringEvent;
	private Composite grpGuardHolder;
	private Composite grpActionHolder;
	private Composite composite_EventHolder;
	private Composite composite_GuardHolder;
	private Composite composite_ActionHolder;
	private Composite composite;
	private Label lblAction;
	private Button chkReplaceAll;
	private Composite composite_1;
	private Label lblGuard;
	private Button chkClearGuard;
	private Composite composite_2;
	private Label lblEvent;
	private Button chkClearEvent;
	private Composite composite_ExistingTransitionsHolder;
	private Composite composite_ExistingEvent;
	private CLabel lblEvent_1;
	private Composite composite_ExistingGuard;
	private CLabel lblGuard_1;
	private Composite composite_ExistingAction;
	private CLabel lblAction_1;
	private Text text_ExistingEventText;
	private Text text_ExistingGuardText;
	private Text text_ExistingActionText;
	private Button btnImportEvent;
	private Button btnImportGuard;
	private Button btnImportAction;
	Combo combo_StateMachinesList;
	private Composite composite_NewTransitionHolder;
	private Text text;
	private CLabel lblsearchImportedTransition;
	private HashMap<Transition, String> transitionListAsString = new HashMap<Transition, String>();

	CustomControlExpandBarForTransitionParts(Shell parent) {
		super(parent, SWT.BORDER);
		constructDesign(parent);

		retrieveTransitionList();
		populateImportStateMachinesCombo(null);

	}

	private void retrieveTransitionList() {
		List<Transition> listOfAllTransitions = ModelUtils
				.getBehaviourModelObjectsByType(CommonSpaceForContextualUI.getCurrentTransition(), Transition.class);

		for (Transition t : listOfAllTransitions) {
			if (!t.equals(CommonSpaceForContextualUI.getCurrentTransition())) {
				FeatureModule module = ModelUtils2.getTypedRootForObject(t, FeatureModule.class);

				StateMachine stateMachine = ModelUtils2.getTypedRootForObject(t, StateMachine.class);
				String itemText ="";
				if (stateMachine != null) {
					itemText = module.getFeatureref().getName() + "( " + stateMachine.getName() + " ) -> "
							+ JS_TransitionLabelServices.populateTransitionLabel(t);
				}else
				{
					Fragment fragment = ModelUtils2.getTypedRootForObject(t, Fragment.class);
					if (fragment != null) {
						itemText = module.getFeatureref().getName() + "( " + fragment.getName() + " ) -> "
								+ JS_TransitionLabelServices.populateTransitionLabel(t);
					}
				}
				
				transitionListAsString.put(t, itemText);
			}
		}

	}

	private void populateImportStateMachinesCombo(String filterText) {

		combo_StateMachinesList.removeAll();

		for (Transition tran : transitionListAsString.keySet()) {
			String text = transitionListAsString.get(tran);

			if (filterText != null) {
				if (text.toLowerCase().contains(filterText.toLowerCase())) {
					combo_StateMachinesList.add(text);
					combo_StateMachinesList.setData(text, tran);
					if (combo_StateMachinesList.getItemCount() > 0)
						combo_StateMachinesList.select(0);
				}
			} else {
				combo_StateMachinesList.add(text);
				combo_StateMachinesList.setData(text, tran);
			}
		}

		combo_StateMachinesList.addSelectionListener(doOnSelect());
		combo_StateMachinesList.addModifyListener(doOnModify());
		// if (combo_StateMachinesList.getItemCount() > 0)
		// combo_StateMachinesList.select(0);

	}

	private ModifyListener doOnModify() {
		return new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (combo_StateMachinesList.getItemCount() == 0)
					return;

				String itemText = combo_StateMachinesList.getItem(combo_StateMachinesList.getSelectionIndex());
				if (combo_StateMachinesList.getData(itemText) instanceof Transition) {
					Transition t = (Transition) combo_StateMachinesList.getData(itemText);

					text_ExistingEventText.setText(JS_TransitionLabelServices.getEventText(t));
					text_ExistingEventText.setData(JS_TransitionLabelServices.getEventText(t), t);

					text_ExistingGuardText.setText(JS_TransitionLabelServices.getGuardText(t));
					text_ExistingGuardText.setData(JS_TransitionLabelServices.getGuardText(t), t);

					text_ExistingActionText.setText(JS_TransitionLabelServices.getActionText(t));
					text_ExistingActionText.setData(JS_TransitionLabelServices.getActionText(t), t);
				}

			}
		};
	}

	private SelectionListener doOnSelect() {
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				String itemText = combo_StateMachinesList.getItem(combo_StateMachinesList.getSelectionIndex());
				if (combo_StateMachinesList.getData(itemText) instanceof Transition) {
					Transition t = (Transition) combo_StateMachinesList.getData(itemText);

					text_ExistingEventText.setText(JS_TransitionLabelServices.getEventText(t));
					text_ExistingEventText.setData(JS_TransitionLabelServices.getEventText(t), t);

					text_ExistingGuardText.setText(JS_TransitionLabelServices.getGuardText(t));
					text_ExistingGuardText.setData(JS_TransitionLabelServices.getGuardText(t), t);

					text_ExistingActionText.setText(JS_TransitionLabelServices.getActionText(t));
					text_ExistingActionText.setData(JS_TransitionLabelServices.getActionText(t), t);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	private void constructDesign(Shell parentShell) {
		composite_AllHolder = this;
		composite_AllHolder.setBackground(SWTResourceManager.getColor(176, 224, 230));
		setLayout(new FillLayout(SWT.VERTICAL));

		composite_NewTransitionHolder = new Composite(this, SWT.BORDER);
		composite_NewTransitionHolder.setLayout(new FillLayout(SWT.VERTICAL));

		grpTriggeringEvent = new Composite(composite_NewTransitionHolder, SWT.NONE);
		grpTriggeringEvent.setBackground(SWTResourceManager.getColor(240, 240, 240));
		grpTriggeringEvent.setLayout(new GridLayout(2, false));

		composite_2 = new Composite(grpTriggeringEvent, SWT.NONE);
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		RowLayout rl_composite_2 = new RowLayout(SWT.VERTICAL);
		rl_composite_2.justify = true;
		rl_composite_2.fill = true;
		composite_2.setLayout(rl_composite_2);

		lblEvent = new Label(composite_2, SWT.RIGHT);
		lblEvent.setLayoutData(new RowData(77, SWT.DEFAULT));
		lblEvent.setText("Event:  ");
		lblEvent.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblEvent.setAlignment(SWT.RIGHT);

		chkClearEvent = new Button(composite_2, SWT.BORDER | SWT.FLAT);
		chkClearEvent.setLayoutData(new RowData(SWT.DEFAULT, 16));
		chkClearEvent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EmbeddedEditorGenerator.clearOrImportTransitionEvent(null);
			}
		});
		chkClearEvent.setText("Clear Event");
		chkClearEvent.setSelection(true);
		chkClearEvent.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));

		composite_EventHolder = new Composite(grpTriggeringEvent, SWT.NONE);
		composite_EventHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_EventHolder.setLayout(new FillLayout(SWT.HORIZONTAL));

		// CommonSpaceForContextualUI.composite_EventHolder =
		// this.composite_EventHolder;

		grpGuardHolder = new Composite(composite_NewTransitionHolder, SWT.NONE);
		grpGuardHolder.setBackground(SWTResourceManager.getColor(240, 240, 240));
		grpGuardHolder.setLayout(new GridLayout(2, false));

		composite_1 = new Composite(grpGuardHolder, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		RowLayout rl_composite_1 = new RowLayout(SWT.VERTICAL);
		rl_composite_1.justify = true;
		rl_composite_1.fill = true;
		composite_1.setLayout(rl_composite_1);

		lblGuard = new Label(composite_1, SWT.RIGHT);
		lblGuard.setLayoutData(new RowData(67, SWT.DEFAULT));
		lblGuard.setText("Guard:  ");
		lblGuard.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblGuard.setAlignment(SWT.RIGHT);

		chkClearGuard = new Button(composite_1, SWT.BORDER | SWT.FLAT);
		chkClearGuard.setLayoutData(new RowData(SWT.DEFAULT, 16));
		chkClearGuard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EmbeddedEditorGenerator.clearOrImportTransitionGuard(null);
			}
		});
		chkClearGuard.setText("Clear Guard");
		chkClearGuard.setSelection(true);
		chkClearGuard.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));

		composite_GuardHolder = new Composite(grpGuardHolder, SWT.NONE);
		composite_GuardHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_GuardHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		// CommonSpaceForContextualUI.composite_GuardHolder =
		// this.composite_GuardHolder;

		grpActionHolder = new Composite(composite_NewTransitionHolder, SWT.NONE);
		grpActionHolder.setBackground(SWTResourceManager.getColor(240, 240, 240));
		grpActionHolder.setLayout(new GridLayout(3, false));

		composite = new Composite(grpActionHolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		RowLayout rl_composite = new RowLayout(SWT.VERTICAL);
		rl_composite.fill = true;
		rl_composite.justify = true;
		composite.setLayout(rl_composite);

		lblAction = new Label(composite, SWT.RIGHT);
		lblAction.setText("Action:  ");
		lblAction.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblAction.setAlignment(SWT.RIGHT);

		chkReplaceAll = new Button(composite, SWT.CHECK);
		chkReplaceAll.setText("Replace All");
		chkReplaceAll.setSelection(true);
		chkReplaceAll.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		chkReplaceAll.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CommonSpaceForContextualUI.replaceAllAction = chkReplaceAll.getSelection();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		chkReplaceAll.setSelection(true);

		composite_ActionHolder = new Composite(grpActionHolder, SWT.NONE);
		composite_ActionHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
		composite_ActionHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		// CommonSpaceForContextualUI.composite_ActionHolder =
		// this.composite_ActionHolder;
		CommonSpaceForContextualUI.replaceAllAction = true;

		createEmbeddedEditors();

		/*
		 * DNDOperationsForListItems.createTransitionEditor(CommonSpaceForContextualUI.
		 * getCurrentTransition(), true, Trigger.class, false);
		 * DNDOperationsForListItems.createTransitionEditor(CommonSpaceForContextualUI.
		 * getCurrentTransition(), true, Guard.class, false);
		 * DNDOperationsForListItems.createTransitionEditor(CommonSpaceForContextualUI.
		 * getCurrentTransition(), true, WCAList.class, false);
		 */
		setSize(356, 350);

		composite_ExistingTransitionsHolder = new Composite(this, SWT.BORDER);
		composite_ExistingTransitionsHolder.setLayout(new GridLayout(1, false));

		Composite composite_SelectStateMachine = new Composite(composite_ExistingTransitionsHolder, SWT.NONE);
		composite_SelectStateMachine.setLayout(new GridLayout(2, false));
		GridData gd_composite_SelectStateMachine = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_SelectStateMachine.widthHint = 271;
		composite_SelectStateMachine.setLayoutData(gd_composite_SelectStateMachine);

		lblsearchImportedTransition = new CLabel(composite_SelectStateMachine, SWT.NONE);
		lblsearchImportedTransition.setText("Search in Transitions:");

		text = new Text(composite_SelectStateMachine, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				searchInComboBox();
			}
		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		CLabel lblSelectStateMachine = new CLabel(composite_SelectStateMachine, SWT.NONE);
		lblSelectStateMachine.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSelectStateMachine.setText("Select a Transition:");

		combo_StateMachinesList = new Combo(composite_SelectStateMachine, SWT.READ_ONLY);
		combo_StateMachinesList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		composite_ExistingEvent = new Composite(composite_ExistingTransitionsHolder, SWT.NONE);
		composite_ExistingEvent.setLayout(new GridLayout(3, false));
		composite_ExistingEvent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblEvent_1 = new CLabel(composite_ExistingEvent, SWT.NONE);
		lblEvent_1.setText("Event:");

		text_ExistingEventText = new Text(composite_ExistingEvent, SWT.BORDER);
		text_ExistingEventText.setEditable(false);
		text_ExistingEventText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnImportEvent = new Button(composite_ExistingEvent, SWT.NONE);
		btnImportEvent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!text_ExistingEventText.getText().trim().equals("")) {
					Object importedTransition = text_ExistingEventText.getData(text_ExistingEventText.getText());
					if (importedTransition instanceof Transition) {
						EmbeddedEditorGenerator
								.clearOrImportTransitionEvent(((Transition) importedTransition).getTrig());
					}
					// .setText(text_ExistingEventText.getText());
				}
			}
		});
		GridData gd_btnImportEvent = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImportEvent.heightHint = 21;
		btnImportEvent.setLayoutData(gd_btnImportEvent);
		btnImportEvent.setText("Use");
		btnImportEvent.setImage(SWTResourceManager.getImage(CustomControlExpandBarForTransitionParts.class,
				"/uw/cs/watform/forml/services/GUI/res/move_up.png"));

		composite_ExistingGuard = new Composite(composite_ExistingTransitionsHolder, SWT.NONE);
		composite_ExistingGuard.setLayout(new GridLayout(3, false));
		composite_ExistingGuard.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblGuard_1 = new CLabel(composite_ExistingGuard, SWT.NONE);
		lblGuard_1.setText("Guard:");

		text_ExistingGuardText = new Text(composite_ExistingGuard, SWT.BORDER);
		text_ExistingGuardText.setEditable(false);
		text_ExistingGuardText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnImportGuard = new Button(composite_ExistingGuard, SWT.NONE);
		btnImportGuard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!text_ExistingGuardText.getText().trim().equals("")) {

					Object importedTransition = text_ExistingGuardText.getData(text_ExistingGuardText.getText());
					if (importedTransition instanceof Transition) {
						EmbeddedEditorGenerator
								.clearOrImportTransitionGuard(((Transition) importedTransition).getGuard());
					}

				}
			}
		});
		GridData gd_btnImportGuard = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImportGuard.heightHint = 21;
		btnImportGuard.setLayoutData(gd_btnImportGuard);
		btnImportGuard.setText("Use");
		btnImportGuard.setImage(SWTResourceManager.getImage(CustomControlExpandBarForTransitionParts.class,
				"/uw/cs/watform/forml/services/GUI/res/move_up.png"));

		composite_ExistingAction = new Composite(composite_ExistingTransitionsHolder, SWT.NONE);
		composite_ExistingAction.setLayout(new GridLayout(3, false));
		composite_ExistingAction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblAction_1 = new CLabel(composite_ExistingAction, SWT.NONE);
		lblAction_1.setText("Action");

		text_ExistingActionText = new Text(composite_ExistingAction, SWT.BORDER);
		text_ExistingActionText.setEditable(false);
		text_ExistingActionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnImportAction = new Button(composite_ExistingAction, SWT.NONE);
		btnImportAction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!text_ExistingActionText.getText().trim().equals("")) {
					Object importedTransition = text_ExistingActionText.getData(text_ExistingActionText.getText());
					if (importedTransition instanceof Transition) {
						EmbeddedEditorGenerator
								.clearOrImportTransitionAction(((Transition) importedTransition).getList());
					}
				}
			}
		});
		GridData gd_btnImportAction = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnImportAction.heightHint = 21;
		btnImportAction.setLayoutData(gd_btnImportAction);
		btnImportAction.setText("Use");
		btnImportAction.setImage(SWTResourceManager.getImage(CustomControlExpandBarForTransitionParts.class,
				"/uw/cs/watform/forml/services/GUI/res/move_up.png"));

	}

	protected void searchInComboBox() {
		if (!text.getText().trim().equals(""))
			populateImportStateMachinesCombo(text.getText().trim());
		else
			populateImportStateMachinesCombo(null);
	}

	private void createEmbeddedEditors() {
		// create event
		EmbeddedEditorGenerator.createTransitionEditor(CommonSpaceForContextualUI.getCurrentTransition(), true,
				Trigger.class, this.composite_EventHolder, false);

		// create guard
		EmbeddedEditorGenerator.createTransitionEditor(CommonSpaceForContextualUI.getCurrentTransition(), true,
				Guard.class, this.composite_GuardHolder, false);

		// create action
		EmbeddedEditorGenerator.createTransitionEditor(CommonSpaceForContextualUI.getCurrentTransition(), true,
				WCAList.class, this.composite_ActionHolder, false);

	}
}
