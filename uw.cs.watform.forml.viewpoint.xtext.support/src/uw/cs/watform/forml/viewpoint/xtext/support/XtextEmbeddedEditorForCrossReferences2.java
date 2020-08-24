/******************************************************************************
 * Copyright (c) 2011 Obeo  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo  - initial API and implementation
 ****************************************************************************/

package uw.cs.watform.forml.viewpoint.xtext.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.InconsistentData;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CustomEmbeddedEditorResourceProvider;
import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class XtextEmbeddedEditorForCrossReferences2 {
	public EmbeddedEditor editor;
	public EmbeddedEditorModelAccess partialEditorModelAccess;
	public Resource originalResource;
	public XtextResource xTextResource;
	// public CLabel lblUserShiftEnter;
	// public CLabel lblSavedOrStillErroneous;
	public Injector injector;

	private boolean isEditable;

	private TreeItem currentTreeItem;
	private List<TreeItem> allTreaItems;
	private Tree InconsistencyTree;

	public XtextEmbeddedEditorForCrossReferences2(Injector inj, boolean isEdit) {
		if (this.injector == null)
			this.injector = inj;

		this.isEditable = isEdit;
	}

	public XtextEmbeddedEditorForCrossReferences2(Injector inj, boolean isEdit, TreeItem treeItem,
			List<TreeItem> allLeafNodes, Tree tree) {
		if (this.injector == null)
			this.injector = inj;

		this.isEditable = isEdit;
		this.currentTreeItem = treeItem;
		this.allTreaItems = allLeafNodes;
		this.InconsistencyTree = tree;
	}

	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		try {
			String allText = rootNode.getText();

			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

			String prefix = allText.substring(0, elementNode.getOffset() - 1);
			String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

			String suffix = allText.substring(elementNode.getEndOffset());

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} catch (Exception e) {
			parts[0] = "";
			parts[1] = "[]";
			parts[2] = "";
		}
		return parts;
	}

	public void addKeyVerifyListener() {
		final StyledText xtextTextWidget = editor.getViewer().getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				int keyCode = e.keyCode;
				// if ((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode
				// == SWT.CR))) {
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = false;
					saveEditor(true);
					//moveToNextNode();
					
				}
				// if (keyCode == SWT.ESC) {
				else if ((e.stateMask & SWT.SHIFT) != 0 && keyCode == SWT.ESC) {
					e.doit = false;
					saveEditor(false);
				}
				
//				else if ((e.stateMask & SWT.SHIFT) != 0 && keyCode == SWT.TAB) {
//					e.doit = false;
//					moveToNextNode();
//				}

			}
		});
	}

	public void gainFocus() {
		try {
			editor.getViewer().getTextWidget().setFocus();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void moveToNextNode() {
		try {
			int currentIndex = 0;
			for (TreeItem ti : allTreaItems) {
				if (ti.equals(this.currentTreeItem)) {
					break;
				}
				currentIndex++;
			}

			int nextIndex = currentIndex + 1;
			if (nextIndex >= allTreaItems.size())
				nextIndex = 0;

			TreeItem nextTreeItem = allTreaItems.get(nextIndex);

			// InconsistencyTree.select(nextTreeItem);

			CCombo itemCombo = ((InconsistentData) nextTreeItem.getData()).combo;
			itemCombo.select(1);
			itemCombo.notifyListeners(SWT.Selection, new Event());
			
			InconsistencyTree.setSelection(nextTreeItem);
			InconsistencyTree.notifyListeners(SWT.Selection, new Event());

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public boolean saveEditor(boolean isReconcile) {
		if (partialEditorModelAccess != null) {
			if (isReconcile) {
				try {
					updateXtextResource();
					return true;
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
		}
		return false;
	}

	protected void updateXtextResource() throws IOException, BadLocationException {
		String newText = partialEditorModelAccess.getSerializedModel();
		xTextResource.reparse(newText);
		EcoreUtil.resolveAll(xTextResource);
		final IParseResult parseResult = xTextResource.getParseResult();
		if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xTextResource)) {
			reconcile(originalResource, xTextResource);
		}
	}

	private boolean hasDanglingRefs(XtextResource xtextResource2) {
		return EcoreUtil.UnresolvedProxyCrossReferencer.find(xtextResource2).size() > 0;
	}

	private boolean reconcile(Resource resourceInSirius, XtextResource resourceInEmbeddedEditor) {
		try {

			IComparisonScope scope = new DefaultComparisonScope(resourceInSirius, resourceInEmbeddedEditor, null);
			final Comparison comparison = EMFCompare.builder().build().compare(scope);

			IMerger.Registry mergerRegistry = EMFCompareRCPPlugin.getDefault().getMergerRegistry();
			final IBatchMerger merger = new BatchMerger(mergerRegistry);

			// IXtextDocument xTextDoc = editor.getDocument();
			//
			// xTextDoc.modify(new IUnitOfWork.Void<XtextResource>() {
			//
			// @Override
			// public void process(XtextResource state) throws Exception {
			// merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());
			// System.out.println("wnet");
			// }
			// });

			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
			editingDomain.getCommandStack()
					.execute(new RecordingCommand(editingDomain, "update resource after direct text edit") {

						@Override
						protected void doExecute() {

							merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());

							// resourceInSirius.getContents().set(0,
							// EcoreUtil.copy(resourceInEmbeddedEditor.getContents().get(0)));

							// merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());

						}
					});

			// resourceInSirius.save(SaveOptions.defaultOptions().toOptionsMap());

		} catch (Exception e) {
			Activator.logError(e);
			return false;
		}

		return true;
	}

	public <T extends EObject> void createEditor(Composite parent, EObject semanticElement, Class<T> type)
			throws CoreException {

		if (type.equals(Trigger.class))
			runForEvent(parent, semanticElement);
		else if (type.equals(Guard.class))
			runForGuard(parent, semanticElement);
		else if (type.equals(WCAList.class))
			runForAction(parent, semanticElement);
		else if (type.equals(Transition.class))
			runForTransition(parent, semanticElement);

		changeEditorColor();

	}

	private void runForTransition(Composite parent, EObject semanticElement) {
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

							originalResource = trans.eResource();

							GridLayout gl = new GridLayout();
							parent.setLayout(gl);

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(parent);

							xTextResource = resourceProvider.createResource(trans);

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans);
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
									pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

							// editor.getViewer().getTextWidget()
							// .setBackground(SWTResourceManager.getColor(228, 246, 253));

							addKeyVerifyListener();
							// editor.getViewer().getTextWidget().setMargins(0, 0, 0, 0);
							parent.layout(true, true);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void runForGuard(Composite parent, EObject semanticElement) {
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
							}

							originalResource = trans.getGuard().eResource();

							GridLayout gl = new GridLayout();
							parent.setLayout(gl);

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(parent);

							xTextResource = resourceProvider.createResource(trans.getGuard());

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans.getGuard());
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
									pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

							// editor.getViewer().getTextWidget()
							// .setBackground(SWTResourceManager.getColor(228, 246, 253));

							addKeyVerifyListener();
							// editor.getViewer().getTextWidget().setMargins(0, 0, 0, 0);
							parent.layout(true, true);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void runForAction(Composite parent, EObject semanticElement) {
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

							GridLayout gl = new GridLayout();
							parent.setLayout(gl);

							if (trans.getList() == null) {
								WCAList wcaList = FormlFactory.eINSTANCE.createWCAList();
								trans.setList(wcaList);
							}

							originalResource = trans.getList().eResource();

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);

							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(parent);

							xTextResource = resourceProvider.createResource(trans.getList());
							// System.out.println(xTextResource.getParseResult().getRootNode().getText());

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							String semanticElementFragment = originalResource.getURIFragment(trans.getList());
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

							String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

							partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
									pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

							// editor.getViewer().getTextWidget()
							// .setBackground(SWTResourceManager.getColor(228, 246, 253));

							addKeyVerifyListener();
							// editor.getViewer().getTextWidget().setMargins(0, 0, 0, 0);
							parent.layout(true, true);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void runForEvent(Composite parent, EObject semanticElement) {
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
							GridLayout gl = new GridLayout();
							parent.setLayout(gl);

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							CustomEmbeddedEditorFactory factory = injector
									.getInstance(CustomEmbeddedEditorFactory.class);

							editor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
									.withParent(parent);
							// editor.getViewer().getTextWidget().setLayoutData(data);

							if (trans.getTrig() == null) {

								originalResource = trans.eResource();
								xTextResource = resourceProvider.createResource(trans);

								ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

								String semanticElementFragment = originalResource.getURIFragment(trans);
								EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

								String[] pre_editable_suff_Fixes = findPartsForNode(rootNode,
										semanticElementInDocument);

								partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0] + "",
										"'Drag objects from the attributes or messages list to set the event.'", "",
										true);

								editor.getViewer().getTextWidget().setEnabled(false);

							} else {
								originalResource = trans.getTrig().eResource();
								xTextResource = resourceProvider.createResource(trans.getTrig());

								ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

								String semanticElementFragment = originalResource.getURIFragment(trans.getTrig());
								EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

								String[] pre_editable_suff_Fixes = findPartsForNode(rootNode,
										semanticElementInDocument);

								partialEditorModelAccess = editor.createPartialEditor(pre_editable_suff_Fixes[0],
										pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);
								editor.getViewer().getTextWidget().setEnabled(true);

							}

							// editor.getViewer().getTextWidget()
							// .setBackground(SWTResourceManager.getColor(228, 246, 253));

							addKeyVerifyListener();
							// editor.getViewer().getTextWidget().setMargins(0, 0, 0, 0);
							parent.layout(true, true);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void changeEditorColor() {
		editor.getViewer().getTextWidget().setEnabled(isEditable);

		if (isEditable)
			editor.getViewer().getTextWidget().setBackground(SWTResourceManager.getColor(213, 246, 204));
		else
			editor.getViewer().getTextWidget().setBackground(SWTResourceManager.getColor(253, 198, 198));

	}
}
