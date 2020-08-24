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

package uw.cs.watform.forml.services.virtualresource;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.CommandStack;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

import com.google.inject.Injector;
import uw.cs.watform.forml.viewpoint.xtext.support.Activator;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CustomEmbeddedEditorResourceProvider;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.System;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class XtextEmbeddedEditorOperationsOnly {
	public EmbeddedEditorModelAccess partialEditorModelAccess;
	public Resource originalResource;
	public XtextResource xTextResource;
	public Injector injector;
	protected String semanticElementFragment;

	public XtextEmbeddedEditorOperationsOnly(Injector inj) {
		if (this.injector == null)
			this.injector = inj;

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

	public void updateWorldModelFromOutside(WorldModel wm) {

		if (xTextResource.getContents().get(0) instanceof System) {
			System system = (System) xTextResource.getContents().get(0);
			system.setWorldmodel(wm);

		}

	}

	public EObject getupdatedresource(String semanticElementFragment) {
		return xTextResource.getEObject(semanticElementFragment);
	}

	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public boolean updateResource(boolean isReconcile) {
		if (isReconcile) {
			try {
				updateXtextResource();
				return true;
			} catch (Exception exc) {
				Activator.logError(exc);
			}
		}

		return false;
	}

	protected void updateXtextResource() throws IOException, BadLocationException {
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

			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
			editingDomain.getCommandStack()
					.execute(new RecordingCommand(editingDomain, "update resource after direct text edit") {

						@Override
						protected void doExecute() {

							merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());

						//	resourceInSirius.getContents().set(0,
						//			EcoreUtil.copy(resourceInEmbeddedEditor.getContents().get(0)));

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

	public <T extends EObject> void createEditor(EObject semanticElement) throws CoreException {

		runForElement(semanticElement);

	}

	private void runForElement(EObject semanticElement) {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {
			public void run() {
				try {

					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticElement);

					final CommandStack commandStack = editingDomain.getCommandStack();
					commandStack.execute(new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {

							CustomEmbeddedEditorResourceProvider resourceProvider = injector
									.getInstance(CustomEmbeddedEditorResourceProvider.class);
							// editor.getViewer().getTextWidget().setLayoutData(data);

							originalResource = semanticElement.eResource();
							xTextResource = resourceProvider.createResource(semanticElement);

							ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

							semanticElementFragment = originalResource.getURIFragment(semanticElement);
							EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
