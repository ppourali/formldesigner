package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.ide.ui.api.widgets.AbstractEEFWidgetLifecycleManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.extensions.TransitionEditorController;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.CustomCompositeFeatureModuleSnapShotHolder;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer.CustomCompositeForCrossReferenceView_TreeStyle;
import uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer.CustomTreeViewerForCrossReferences;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.widgets.JS_TransitionWidgets;

public class StateMachinePreviewerLifecycleManager extends AbstractEEFWidgetLifecycleManager {

	private EEFCustomWidgetDescription description;
	CustomCompositeFeatureModuleSnapShotHolder stateMachinePreviewer;
	// private TextViewer textViewer;

	private ComposedAdapterFactory composedAdapterFactory;

	// private SelectionListener onClickListener;

	// private TransitionEditorController controller;

	// private Consumer<Object> newValueConsumer;

	private TransitionEditorController controller;

	private EObject modelElement;
	private SourceViewer sourceViewer;
	private final String TOOLTIP_TEXT = "<Press key \"Ctrl+Space\" and type name for Content Assist>";
	// private EmbeddedXtextEditorForPropertiesPage editor;
	// CustomCompositeForCrossReferenceView_TreeStyle composite_cfp;
	// private Composite helper_Parent;;
	private EmbeddedEditor embeddedEditor;
	// private AbstractXtextEmbeddedEditorForPropertiesViewer embeddedEditor;

	// private LinkedTextDocument.Input _input;
	// private LinkedTextDocument _document;
	// private Color defaultTextColor;
	CustomEditorHelper_Trig editorhelper;

	public StateMachinePreviewerLifecycleManager(EEFCustomWidgetDescription description,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(variableManager, interpreter, contextAdapter);
		// System.out.println(variableManager.getVariables().get("self"));
		Object elem = variableManager.getVariables().get("self");
		if (elem instanceof Roleable) {
			this.modelElement = ((Roleable) elem);
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
			// parent.setSize(parent.getSize().x,500);
	//		FillLayout fillLayout = new FillLayout();
//			fillLayout.type = SWT.HORIZONTAL;
		//	parent.setLayout(fillLayout);

			if (this.modelElement instanceof Roleable && this.modelElement != null) {
				FeatureModule relatedFM = ModelUtils.getFeatureModuleForFeature((Roleable) this.modelElement);
				if (relatedFM != null) {
					this.stateMachinePreviewer = new CustomCompositeFeatureModuleSnapShotHolder(parent, SWT.BORDER,
							relatedFM);
					
					
					GridData gridData = new GridData();
					gridData.verticalAlignment = GridData.FILL;
					gridData.verticalSpan = 2;
					gridData.grabExcessVerticalSpace = true;
					gridData.horizontalAlignment = GridData.FILL;
					gridData.grabExcessHorizontalSpace = true;
					gridData.heightHint=400;
					this.stateMachinePreviewer.setLayoutData(gridData);
					
					
		//			Object ld = this.stateMachinePreviewer.getLayoutData();
	//				if(ld instanceof org.eclipse.swt.layout.FillData)
	//				{
					
//					}
				}
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
		return this.stateMachinePreviewer;// this.embeddedEditor.getViewer().getTextWidget();
	}

}
