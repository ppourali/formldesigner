package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.ide.ui.api.widgets.AbstractEEFWidgetLifecycleManager;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.extensions.TransitionEditorController;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.widgets.JS_TransitionWidgets;

public class EventEditorLifecycleManager extends AbstractEEFWidgetLifecycleManager {

	private EEFCustomWidgetDescription description;

	// private TextViewer textViewer;

	private ComposedAdapterFactory composedAdapterFactory;

	// private SelectionListener onClickListener;

	// private TransitionEditorController controller;

	// private Consumer<Object> newValueConsumer;

	private TransitionEditorController controller;

	private Transition modelElement;
	private SourceViewer sourceViewer;
	private final String TOOLTIP_TEXT = "<Press key \"Ctrl+Space\" and type name for Content Assist>";
	// private EmbeddedXtextEditorForPropertiesPage editor;

	// private Composite helper_Parent;;
	private EmbeddedEditor embeddedEditor;
	// private AbstractXtextEmbeddedEditorForPropertiesViewer embeddedEditor;

	// private LinkedTextDocument.Input _input;
	// private LinkedTextDocument _document;
	// private Color defaultTextColor;
	CustomEditorHelper_Trig editorhelper;
	
	public EventEditorLifecycleManager(EEFCustomWidgetDescription description, IVariableManager variableManager,
			IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(variableManager, interpreter, contextAdapter);
		// System.out.println(variableManager.getVariables().get("self"));
		Object elem = variableManager.getVariables().get("self");
		if (elem instanceof Transition) {
			this.modelElement = ((Transition) elem);
		}
		this.description = description;
	}

	// public void initialize(IManagedForm form) {
	// this.managedForm = form;
	// toolkit = managedForm.getToolkit();
	// }

	@Override
	protected IEEFWidgetController getController() {
		return this.controller;
	}

	@Override
	protected EEFWidgetDescription getWidgetDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public void dispose() {
		super.dispose();
		// this.embeddedEditor.getViewer().getTextWidget().dispose();
		this.composedAdapterFactory.dispose();
	}

	@Override
	public void aboutToBeHidden() {
		// TODO Auto-generated method stub
		super.aboutToBeHidden();
		// this.embeddedEditor.getViewer().getTextWidget().dispose();
		// this.embeddedEditor=null;
	}

	@Override
	protected void createMainControl(Composite parent, IEEFFormContainer formContainer) {

		this.composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		try {
			createEditor_V0(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.controller = new TransitionEditorController(description, variableManager, interpreter,
				editingContextAdapter);

	}

	private void createEditor_V0(Composite parent) {

		try {

			editorhelper=new CustomEditorHelper_Trig();
			if (editorhelper.injector == null)
				editorhelper.injector = ModelUtils.getInjector();

			this.embeddedEditor = editorhelper.createEditor(parent, this.modelElement, Trigger.class);
			creatButtons(parent);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// embeddedEditor.showEditor(parent);
	}

	private void creatButtons(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		parent.setLayout(layout);

		GridData data_parent = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
		parent.setLayoutData(data_parent);

		Button btnRemoveTriggeringEvent = new Button(parent, SWT.TOP | SWT.PUSH);
		btnRemoveTriggeringEvent.setText("Remove Triggering Event");
		btnRemoveTriggeringEvent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		btnRemoveTriggeringEvent.setImage(SWTResourceManager.getImage(EventEditorLifecycleManager.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_delete.png"));
		btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
		btnRemoveTriggeringEvent.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JS_TransitionWidgets.widgetDeleteTriggeringEvent(modelElement);
				btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
				editorhelper.Refresh(modelElement);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Button btnSetTriggeringEvent = new Button(parent, SWT.TOP | SWT.NONE);
		btnSetTriggeringEvent.setText("Set Triggering Event");
		btnSetTriggeringEvent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		btnSetTriggeringEvent.setImage(SWTResourceManager.getImage(EventEditorLifecycleManager.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_add.png"));
		btnSetTriggeringEvent.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JS_TransitionWidgets.widgetChangeTriggeringEvent(modelElement);
				btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
				editorhelper.Refresh(modelElement);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private boolean checkTriggeringExists() {
		if (this.modelElement.getTrig() == null)
			return false;
		else
			return true;

	}

	@Override
	protected void setEnabled(boolean isEnabled) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control getValidationControl() {
		// TODO Auto-generated method stub
		return this.embeddedEditor.getViewer().getTextWidget();
	}

}
