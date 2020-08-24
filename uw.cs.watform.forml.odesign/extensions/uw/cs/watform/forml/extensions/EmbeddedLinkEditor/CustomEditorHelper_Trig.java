package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IBatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.util.ResourceUtil;
import org.eclipse.sirius.diagram.business.api.helper.SiriusDiagramUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.wizards.datatransfer.PopulateRootOperation;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import uw.cs.watform.forml.AbstractFormlRuntimeModule;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.general.JS_FeatureModuleServices;
import uw.cs.watform.forml.services.general.JS_MessageServices;
import uw.cs.watform.forml.services.general.JS_TransitionLabelServices;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.ui.internal.FormlActivator;
import uw.cs.watform.forml.viewpoint.xtext.support.Activator;
import uw.cs.watform.forml.viewpoint.xtext.support.CustomEmbeddedEditorFactory;

public final class CustomEditorHelper_Trig extends AbstractEditorHelper {

	public CustomEditorHelper_Trig() {

	}

	public <T extends EObject> EmbeddedEditor createEditor(Composite parent, EObject semanticElement, Class<T> type)
			throws CoreException {

		if (type.equals(Trigger.class))
			runForEvent(parent, semanticElement);

		return editor;
	}

	private void runForEvent(Composite parent, EObject semanticElement) {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {
			public void run() {
				try {

					// if (!(semanticElement instanceof Transition))
					// return null;

					Transition trans = (Transition) semanticElement;
					// System.out.println(JS_TransitionLabelServices.populateTransitionLabel(trans));

					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticElement);

					final CommandStack commandStack = editingDomain.getCommandStack();
					commandStack.execute(new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							Composite top = new Composite(parent, SWT.NONE);
							top.setLayout(new GridLayout());

							GridData data = new GridData(GridData.FILL_BOTH);
							data.heightHint = editorheight;
							data.grabExcessVerticalSpace = true;
							top.setLayoutData(data);

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(top);
							editor.getViewer().getTextWidget().setLayoutData(data);

							if (trans.getTrig() == null) {
								Trigger trig = FormlFactory.eINSTANCE.createTrigger();
								trans.setTrig(trig);
							}
							originalResource = trans.getTrig().eResource();
							xTextResource = resourceProvider.createResource(trans.getTrig());

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans.getTrig());
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
									pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);
							editor.getViewer().getTextWidget().setEnabled(true);

							editor.getViewer().getTextWidget()
									.setBackground(SWTResourceManager.getColor(228, 246, 253));

							addKeyVerifyListener();
							addGetFocusListener(semanticElement);

							editor.getViewer().getTextWidget().setMargins(0, 0, 0, 0);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void addGetFocusListener(EObject semanticElement) {
		final StyledText xtextTextWidget = editor.getViewer().getTextWidget();
		xtextTextWidget.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				Refresh(semanticElement);

			}
		});
	}

	public void Refresh(EObject semanticElement) {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {
			public void run() {
				try {

					Transition trans = (Transition) semanticElement;
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticElement);

					final CommandStack commandStack = editingDomain.getCommandStack();
					commandStack.execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);

							if (trans.getTrig() == null) {
								Trigger trig = FormlFactory.eINSTANCE.createTrigger();
								trans.setTrig(trig);
							}

							originalResource = trans.getTrig().eResource();
							xTextResource = resourceProvider.createResource(trans.getTrig());

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans.getTrig());
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
									pre_editable_suff_Fixes[2]);
							editor.getViewer().getTextWidget().setEnabled(true);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}