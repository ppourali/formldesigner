package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.ide.ui.api.widgets.AbstractEEFWidgetLifecycleManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import uw.cs.watform.forml.extensions.TransitionEditorController;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.CustomCompositeTreeViewer;

public class FeatureTreePreviewerLifecycleManager extends AbstractEEFWidgetLifecycleManager {

	private EEFCustomWidgetDescription description;

	private ComposedAdapterFactory composedAdapterFactory;

	// private SelectionListener onClickListener;

	// private TransitionEditorController controller;

	// private Consumer<Object> newValueConsumer;

	private TransitionEditorController controller;

	private EObject modelElement;

	CustomEditorHelper_Trig editorhelper;
	private CustomCompositeTreeViewer treeViewHolder;

	public FeatureTreePreviewerLifecycleManager(EEFCustomWidgetDescription description,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(variableManager, interpreter, contextAdapter);
		// System.out.println(variableManager.getVariables().get("self"));
		Object elem = variableManager.getVariables().get("self");
		if (elem instanceof Feature) {
			this.modelElement = ((Feature) elem);
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

			if (this.modelElement instanceof Feature && this.modelElement != null) {

				this.treeViewHolder = new CustomCompositeTreeViewer(parent, SWT.BORDER, (Feature) this.modelElement);
				this.treeViewHolder.selectCorrespondingItemOnTreeViewer(this.modelElement);

				GridData gridData = new GridData();
				gridData.verticalAlignment = GridData.FILL;
				gridData.verticalSpan = 2;
				gridData.grabExcessVerticalSpace = true;
				gridData.horizontalAlignment = GridData.FILL;
				gridData.grabExcessHorizontalSpace = true;
				gridData.heightHint = 300;
				this.treeViewHolder.setLayoutData(gridData);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void creatButtons(Composite parent) {
//		GridLayout layout = new GridLayout();
//		layout.numColumns = 4;
//		parent.setLayout(layout);
//
//		GridData data_parent = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
//		parent.setLayoutData(data_parent);
//
//		Button btnRemoveTriggeringEvent = new Button(parent, SWT.TOP | SWT.PUSH);
//		btnRemoveTriggeringEvent.setText("Remove Triggering Event");
//		btnRemoveTriggeringEvent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
//		btnRemoveTriggeringEvent.setImage(SWTResourceManager.getImage(EventEditorLifecycleManager.class,
//				"/uw/cs/watform/forml/services/GUI/res/icon_delete.png"));
//		btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
//		btnRemoveTriggeringEvent.addSelectionListener(new SelectionListener() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				JS_TransitionWidgets.widgetDeleteTriggeringEvent(modelElement);
//				btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
//				editorhelper.Refresh(modelElement);
//			}
//
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//
//		Button btnSetTriggeringEvent = new Button(parent, SWT.TOP | SWT.NONE);
//		btnSetTriggeringEvent.setText("Set Triggering Event");
//		btnSetTriggeringEvent.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
//		btnSetTriggeringEvent.setImage(SWTResourceManager.getImage(EventEditorLifecycleManager.class,
//				"/uw/cs/watform/forml/services/GUI/res/icon_add.png"));
//		btnSetTriggeringEvent.addSelectionListener(new SelectionListener() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				JS_TransitionWidgets.widgetChangeTriggeringEvent(modelElement);
//				btnRemoveTriggeringEvent.setEnabled(checkTriggeringExists());
//				editorhelper.Refresh(modelElement);
//
//			}
//
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});

	}

	@Override
	protected void setEnabled(boolean isEnabled) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control getValidationControl() {
		// TODO Auto-generated method stub
		return this.treeViewHolder;// this.embeddedEditor.getViewer().getTextWidget();
	}

}
