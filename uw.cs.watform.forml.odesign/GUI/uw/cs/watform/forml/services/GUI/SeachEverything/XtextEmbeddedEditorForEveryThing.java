/******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo  - initial API and implementation
 ****************************************************************************/

package uw.cs.watform.forml.services.GUI.SeachEverything;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import com.google.inject.Injector;

import uw.cs.watform.forml.viewpoint.xtext.support.AbstractXtextEmbeddedEditor;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class XtextEmbeddedEditorForEveryThing extends AbstractXtextEmbeddedEditor {

	public XtextEmbeddedEditorForEveryThing(IGraphicalEditPart editPart, Injector xtextInjector) {
		super(editPart, xtextInjector);

	}

//	@Override
//	public void showEditor(EObject originalelem, DiagramEditPart diagramEditPart, Composite referenceCompsiteOnShell) {
//		try {
//			this.xtextEditorComposite = referenceCompsiteOnShell;
//
//			hostEditPart = diagramEditPart;
//
//			EObject originalSemanticElement = originalelem;// resolveSemanticElement(hostEditPart);
//			if (originalSemanticElement == null) {
//				return;
//			}
//			this.originalResource = originalSemanticElement.eResource();
//			// Clone root EObject
//			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
//			if (this.xtextResource == null) {
//				this.xtextResource = createVirtualXtextResource(originalResource.getURI(), semanticElement);
//			}
//
//			// TODO manage multi resource with Xtext Linking or Scoping service
//			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
//			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
//				return;
//			}
//
//			createXtextEditor();
//		} catch (Exception e) {
//			Activator.logError(e);
//		} finally {
//			if (hostEditPart != null) {
//				hostEditPart.refresh();
//			}
//		}
//	}
	
//	@Override
//	protected void showEditor(EObject originalelem, Composite referenceCompsiteOnShell) {
//		super.showEditor(originalelem, diagramEditPart, referenceCompsiteOnShell);
//		xtextEditorComposite.update();
//		xtextEditorComposite.pack();
//		xtextEditorComposite.setSize(95, 57);
//	};

}
