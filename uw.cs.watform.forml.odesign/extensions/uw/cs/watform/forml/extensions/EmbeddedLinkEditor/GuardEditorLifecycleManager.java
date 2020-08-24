package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.ide.ui.api.widgets.AbstractEEFWidgetLifecycleManager;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.ui.wizards.datatransfer.PopulateRootOperation;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import uw.cs.watform.forml.extensions.TransitionEditorController;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.general.JS_TransitionLabelServices;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.widgets.JS_TransitionWidgets;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForGuard;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForTransition;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForWCA;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForWCE;
import uw.cs.watform.forml.viewpoint.xtext.support.frmShellForTransitionLabel;

public class GuardEditorLifecycleManager extends AbstractEEFWidgetLifecycleManager {

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

	CustomEditorHelper_Guard editorhelper;
	
	public GuardEditorLifecycleManager(EEFCustomWidgetDescription description, IVariableManager variableManager,
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

		// String resourcePath = "platform:/resource/FormlTest/model.forml";
		// File iFile = new File(resourcePath);

		// Injector injector = ModelUtils.getInjector();
		// XtextDocument iDocumentEditor = injector.getInstance(XtextDocument.class);

		// IXtextDocument xTextDoc = XtextDocumentUtil.get(iFile);

		// iDocumentEditor.modify(new IUnitOfWork.Void<XtextResource>() {

		// @Override
		// public void process(XtextResource state) throws Exception {
		try {
			createEditor_V0(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
		// });

		this.controller = new TransitionEditorController(description, variableManager, interpreter,
				editingContextAdapter);

	}

	private void creatButtons(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		parent.setLayout(layout);

		GridData data_parent = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
		parent.setLayoutData(data_parent);

		Button btnRemoveGuard = new Button(parent, SWT.TOP | SWT.PUSH);
		btnRemoveGuard.setText("Remove Guard");
		btnRemoveGuard.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		btnRemoveGuard.setImage(SWTResourceManager.getImage(EventEditorLifecycleManager.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_delete.png"));
		btnRemoveGuard.setEnabled(checkGuardExists());
		btnRemoveGuard.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JS_TransitionWidgets.widgetDeleteGuard(modelElement);
				btnRemoveGuard.setEnabled(checkGuardExists());
				editorhelper.Refresh(modelElement);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private boolean checkGuardExists() {

		if (this.modelElement.getGuard().getPredicate() == null)
			return false;
		else
			return true;
	}

	private void createEditor_V0(Composite parent) {

		try {
			editorhelper = new CustomEditorHelper_Guard();

			if (editorhelper.injector == null)
				editorhelper.injector = ModelUtils.getInjector();

			this.embeddedEditor = editorhelper.createEditor(parent, this.modelElement, Guard.class);
			creatButtons(parent);

			// editorComposite.pack();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// embeddedEditor.showEditor(parent);
	}

	private void createEditor_V1(Composite parent) {
		// this.embeddedEditor = new
		// CustomEmbeddedEditorForPropertiesView(ModelUtils.getInjector(),
		// this.modelElement);
		// embeddedEditor.showEditor(parent);
	}

	private void createEditor_V2(Composite parent) {
		// Create Editor For Guard
		AbstractXtextEmbeddedEditorForPropertiesViewer guard_embeddedEditor = new AbstractXtextEmbeddedEditorForPropertiesViewer(
				null, ModelUtils.getInjector());
		if (this.modelElement.getGuard() == null) {
			Guard newGuard = FormlFactory.eINSTANCE.createGuard();
			this.modelElement.setGuard(newGuard);
		}
		guard_embeddedEditor.showEditor(this.modelElement.getGuard(), null, parent);
		// this.embeddedEditor=guard_embeddedEditor;

		/*
		 * if (guard_embeddedEditor.changedElement != null) { trans.setGuard((Guard)
		 * guard_embeddedEditor.changedElement); } else if
		 * (guard_embeddedEditor.isChanged) { EcoreUtil.delete(trans.getGuard()); } if
		 * (trans.getGuard() != null && trans.getGuard().getPredicate() == null) {
		 * EcoreUtil.delete(trans.getGuard()); }
		 */
	}

	private void createEditor_V3(Composite parent) {
		parent.setLayout(new GridLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Section s1 = toolkit.createSection(parent,
		// Section.DESCRIPTION|Section.TITLE_BAR);
		// s1.setLayout(new GridLayout());
		// s1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// s1.setText("Arithmetic Details"); //$NON-NLS-1$
		// s1.setDescription("Arithmetic Details section desc"); //$NON-NLS-1$

		// Composite client = toolkit.createComposite(s1);
		// client.setLayout(new GridLayout());
		// client.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Injector injector = ModelUtils.getInjector();
		// Composite editorComposite = toolkit.createComposite(client);

		// editorComposite.setLayout(new GridLayout());

		// editor = new EmbeddedXtextEditorForPropertiesPage(parent, injector ,
		// SWT.BORDER);

		// editor.getViewer().getTextWidget().addModifyListener(new ModifyListener() {
		// public void modifyText(ModifyEvent e) {
		// if
		// (!editor.getViewer().getTextWidget().getText().equals(getEditedEObject().getAsString()))
		// {
		// getEditor().setDirty(true);

		// getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
		// } else {
		// getEditor().setDirty(false);
		// getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
		// }
		// }
		// });
		// editor.getDocument().addModelListener(new IXtextModelListener() {
		// public void modelChanged(XtextResource resource) {
		// reconcileChangedModel();
		// }
		// });

		// we must deactivate the Cut/Copy/Paste global actions contributed by the
		// EditingDomain action bar
		// editor.getViewer().getTextWidget().addFocusListener(new FocusListener() {
		// public void focusLost(FocusEvent e) {
		// ((ActionBarContributor)getEditor().getActionBarContributor()).activateCCPActions();
		// }

		// public void focusGained(FocusEvent e) {
		// ((ActionBarContributor)getEditor().getActionBarContributor()).deactivateCCPActions();
		// }
		// });
		//
		// editor.getViewer().getTextWidget().addVerifyKeyListener(new
		// VerifyKeyListener() {
		// public void verifyKey(VerifyEvent e) {
		// if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
		// e.doit = false;
		// }
		// }
		// });
		//
		// GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		// data.heightHint= convertHeightInCharsToPixels(1);
		// editorComposite.setLayoutData(data);

		// s1.setClient(client);
	}

	// protected EObject getEditedEObject() {
	// // TODO Auto-generated method stub
	// return this.modelElement;
	// }

	// private int convertHeightInCharsToPixels(int i) {
	// // Create a GC to calculate font's dimensions
	// GC gc = new GC(Display.getDefault());
	// gc.setFont(editor.getViewer().getTextWidget().getFont());
	//
	// // Determine string's dimensions
	// FontMetrics fontMetrics = gc.getFontMetrics();
	//
	// int ret = (fontMetrics.getHeight() + fontMetrics.getAscent() +
	// fontMetrics.getDescent() + fontMetrics.getLeading()) * i;
	//
	// // Dispose that gc
	// gc.dispose();
	//
	// return ret;
	// }

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
