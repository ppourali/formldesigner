package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.viewpoint.xtext.support.CustomEmbeddedEditorFactory;

public final class CustomEditorHelper_Guard extends AbstractEditorHelper{

	public CustomEditorHelper_Guard() {
	}


	public  <T extends EObject> EmbeddedEditor createEditor(Composite parent, EObject semanticElement,
			Class<T> type) throws CoreException {

		if (type.equals(Guard.class))
			runForGuard(parent, semanticElement);

		return editor;
	}

	private  void runForGuard(Composite parent, EObject semanticElement) {
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

							GridData data_parent = new GridData(GridData.FILL_BOTH);
							// data_parent.heightHint = 100;
							data_parent.grabExcessVerticalSpace = false;
							// //data_parent.widthHint = 500;
							parent.setLayoutData(data_parent);
							// parent.setBackground(SWTResourceManager.getColor(64, 20, 64));
							// parent.setLayout(new RowLayout());
							parent.pack();
							parent.getParent().pack();

							if (trans.getGuard() == null) {
								Guard guard = FormlFactory.eINSTANCE.createGuard();
								trans.setGuard(guard);
							}

							originalResource = trans.getGuard().eResource();

							Composite top = new Composite(parent, SWT.NONE);
							top.setLayout(new GridLayout());

							GridData data = new GridData(GridData.FILL_BOTH);
							data.heightHint = editorheight;
							data.grabExcessVerticalSpace = true;
							top.setLayoutData(data);

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							// EmbeddedEditorFactory factory =
							// injector.getInstance(EmbeddedEditorFactory.class);
							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(top);
							// editor.getViewer().getTextWidget().setLayoutData(data);

							xTextResource = resourceProvider.createResource(trans.getGuard());
							// System.out.println(xTextResource.getParseResult().getRootNode().getText());

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans.getGuard());
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
									pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

							
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

	public  void Refresh(EObject semanticElement) {
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

							if (trans.getGuard() == null) {
								Guard guard = FormlFactory.eINSTANCE.createGuard();
								trans.setGuard(guard);
							} else {
								CustomEmbeddedEditorResourceProvider resourceProvider = injector
										.getInstance(CustomEmbeddedEditorResourceProvider.class);

								originalResource = trans.getGuard().eResource();
								xTextResource = resourceProvider.createResource(trans.getGuard());

								ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

								String semanticElementFragment = originalResource.getURIFragment(trans.getGuard());
								EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

								String[] pre_editable_suff_Fixes = findPartsForNode(rootNode,
										semanticElementInDocument);

								partialEditorModelAccess.updateModel(pre_editable_suff_Fixes[0],
										pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2]);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	
}