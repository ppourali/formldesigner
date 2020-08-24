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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

import uw.cs.watform.forml.forml.Transition;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class XtextEmbeddedEditorForWCE extends AbstractXtextEmbeddedEditor {

	public XtextEmbeddedEditorForWCE(IGraphicalEditPart editPart, Injector xtextInjector) {
		super(editPart, xtextInjector);
	}

	@Override
	public void showEditor(EObject originalelem, DiagramEditPart diagramEditPart, Composite referenceCompsiteOnShell) {
		super.showEditor(originalelem, diagramEditPart, referenceCompsiteOnShell);
		xtextEditorComposite.update();
		xtextEditorComposite.pack();
		//System.out.println(shellContainer.bound_txtWCE);
		//xtextEditorComposite.setBounds(shellContainer.bound_txtWCE);

	};

	@SuppressWarnings("restriction")
	protected void createXtextEditorIfNull() throws Exception {

		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();

		EObject semanticElementInDocument = xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		// xtextEditorComposite=shellContainer.embeddedComposite;

		GridLayout gl = new GridLayout();
		xtextEditorComposite.setLayout(gl);

		// xtextEditorComposite=referenceCompsiteOnShell;
		// xtextEditorComposite.pack();

		CustomEmbeddedEditorFactory factory = new CustomEmbeddedEditorFactory();

		xtextInjector.injectMembers(factory);
		xTextEmbeddedEditor = factory.newEditor(new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				return xtextResource;
			}
		}).showErrorAndWarningAnnotations().withParent(xtextEditorComposite);

		xtextPartialEditor = xTextEmbeddedEditor.createPartialEditor(pre_editable_suff_Fixes[0],
				pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

		
		addTextModifyListener();
		addKeyVerifyListener();
		addKeyListener();
		addFocusListener();

		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.update();
		xtextEditorComposite.pack();
		//xtextEditorComposite.setSize(105, 57);

		xTextEmbeddedEditor.getViewer().getTextWidget()
				.setText(xTextEmbeddedEditor.getViewer().getTextWidget().getText().trim());
		// xtextEditorComposite.forceFocus();

		//
		// IXtextFakeContextResourcesProvider contextProvider=new
		// IXtextFakeContextResourcesProvider() {
		//
		// @Override
		// public void populateFakeResourceSet(ResourceSet fakeResourceSet,
		// XtextResource fakeResource) {
		// fakeResource=xtextResource;
		// fakeResourceSet=xtextResource.getResourceSet();
		// }
		// };
		//
		//
		// StyledTextXtextAdapter xTextAdaptor = new
		// StyledTextXtextAdapter(xtextInjector,contextProvider);
		// xTextAdaptor.getFakeResourceContext().getFakeResource().eAdapters().add(new
		// ContextElementAdapter(xtextResource.getResourceServiceProvider()));
		// xTextAdaptor.adapt(shellContainer.styledText);
		// xTextAdaptor.updateFakeResourceContext();
		// xTextAdaptor.setVisibleRegion(100, 20);

	}

	@Override
	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {

		String[] parts = new String[3];

		String allText = rootNode.getText();

		if (semanticElementInDocument instanceof Transition) {
			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor(((Transition) semanticElementInDocument));
			int index_FirstBracketAfterTanstion = allText.indexOf("{", elementNode.getOffset());
			String prefix = allText.substring(0, index_FirstBracketAfterTanstion + 1);

			String editablePart = allText.substring(index_FirstBracketAfterTanstion + 1,
					index_FirstBracketAfterTanstion + 2);
			;
			String suffix = allText.substring(index_FirstBracketAfterTanstion + 2);

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} else {
			return super.findPartsForNode(rootNode, semanticElementInDocument);
		}

		return parts;
	}

	public void showEditorIfNull(EObject originalelem, DiagramEditPart diagramEditPart,
			Composite referenceCompsiteOnShell) {

		try {
			this.xtextEditorComposite = referenceCompsiteOnShell;

			hostEditPart = diagramEditPart;

			EObject originalSemanticElement = originalelem;// resolveSemanticElement(hostEditPart);
			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			// Clone root EObject
			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
			if (this.xtextResource == null) {
				this.xtextResource = createVirtualXtextResource(originalResource.getURI(), semanticElement);
			}

			// TODO manage multi resource with Xtext Linking or Scoping service
			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			// IDiagramEditDomain diagramEditDomain = hostEditPart
			// .getDiagramEditDomain();
			// diagramEditor = ((DiagramEditDomain) diagramEditDomain)
			// .getEditorPart();
			createXtextEditorIfNull();
		} catch (Exception e) {
			Activator.logError(e);
		} finally {
			if (hostEditPart != null) {
				hostEditPart.refresh();
			}
		}

	}
}
