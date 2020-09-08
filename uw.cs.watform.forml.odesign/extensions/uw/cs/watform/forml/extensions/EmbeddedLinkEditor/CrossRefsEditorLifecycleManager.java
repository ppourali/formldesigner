package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.extensions.TransitionEditorController;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer.CustomCompositeForCrossReferenceView_TreeStyle;

public class CrossRefsEditorLifecycleManager extends AbstractEEFWidgetLifecycleManager {

	private EEFCustomWidgetDescription description;
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
	CustomCompositeForCrossReferenceView_TreeStyle composite_cfp;
	//CustomTreeViewerForCrossReferences cfp;

	// private Composite helper_Parent;;
	private EmbeddedEditor embeddedEditor;
	// private AbstractXtextEmbeddedEditorForPropertiesViewer embeddedEditor;

	// private LinkedTextDocument.Input _input;
	// private LinkedTextDocument _document;
	// private Color defaultTextColor;
	CustomEditorHelper_Trig editorhelper;

	public CrossRefsEditorLifecycleManager(EEFCustomWidgetDescription description, IVariableManager variableManager,
			IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(variableManager, interpreter, contextAdapter);
		// System.out.println(variableManager.getVariables().get("self"));
		Object elem = variableManager.getVariables().get("self");
		if (elem instanceof ExprRef) {
			this.modelElement = ((ExprRef) elem);
		}
		else if (elem instanceof RefMessage) {
			this.modelElement = ((RefMessage) elem).getRefMsg();
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

			FillLayout fillLayout = new FillLayout();
			fillLayout.type = SWT.HORIZONTAL;
			parent.setLayout(fillLayout);
			
			composite_cfp = new CustomCompositeForCrossReferenceView_TreeStyle(parent, SWT.BORDER, this.modelElement);
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			parent.setLayout(layout);
			//

			// editorhelper = new CustomEditorHelper_Trig();
			// if (editorhelper.injector == null)
			// editorhelper.injector = ModelUtils.getInjector();

			// this.embeddedEditor = editorhelper.createEditor(parent, this.modelElement,
			// Trigger.class);
			// creatButtons(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// embeddedEditor.showEditor(parent);
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
		return this.composite_cfp;// this.embeddedEditor.getViewer().getTextWidget();
	}

}
