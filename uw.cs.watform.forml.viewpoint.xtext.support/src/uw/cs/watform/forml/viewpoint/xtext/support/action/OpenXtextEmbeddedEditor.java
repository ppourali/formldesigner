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

package uw.cs.watform.forml.viewpoint.xtext.support.action;

import java.util.Collection;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListSpec;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Injector;

import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.impl.TransitionImpl;
import uw.cs.watform.forml.viewpoint.xtext.support.CreateEmbeddedEditors;
import uw.cs.watform.forml.viewpoint.xtext.support.LabelViewXtextEmbeddedEditorForTransition;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditor;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForConstraints;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForTransition;

public abstract class OpenXtextEmbeddedEditor implements IExternalJavaAction {

	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	public void execute(Collection<? extends EObject> context, Map<String, Object> parameters) {

		DiagramEditPart diagramEditPart = ((DiagramEditor) getActiveEditor()).getDiagramEditPart();

		// System.out.println(diagramEditPart);

		for (EObject o : context) {

			// System.out.println(o.eCrossReferences().get(0));

			// o=((Transition)(o.eCrossReferences().get(0))).getDst();

			EditPart editPart = diagramEditPart.findEditPart(diagramEditPart, o);
			////////////////////////// System.out.println(diagramEditPart.getChildren());

			// if(o.eCrossReferences().get(0) instanceof Transition)
			// editPart=((EditPart)((DiagramEditor)
			// getActiveEditor()).getDiagramGraphicalViewer().getSelectedEditParts().get(0));

			if (editPart != null && (editPart instanceof IGraphicalEditPart)) {

				if (o instanceof DNodeListSpec) {

					openEmbeddedEditor((IGraphicalEditPart) editPart, ((DNodeListSpec) o).getTarget());
					break;
				} else {
					openEmbeddedEditor((IGraphicalEditPart) editPart, null);
					break;
				}

			}

			if (o.eCrossReferences().get(0) instanceof Transition) {
				// LabelViewXtextEmbeddedEditorForTransition embeddedEditor =
				// new
				// LabelViewXtextEmbeddedEditorForTransition(diagramEditPart,
				// getInjector());
				// embeddedEditor.showEditor(o.eCrossReferences().get(0),
				// diagramEditPart,false);

				CreateEmbeddedEditors.runFormViewTransitionEditor(diagramEditPart, getInjector(),
						(o.eCrossReferences().get(0)));
			}
		}

	}

	protected void openEmbeddedEditor(IGraphicalEditPart graphicalEditPart, EObject object) {

		if (object instanceof Constraint) {
			XtextEmbeddedEditorForConstraints embeddedEditor = new XtextEmbeddedEditorForConstraints(graphicalEditPart,
					getInjector());

			embeddedEditor.showEditor(NotHaveMacrosAndPredicates((Constraint) object));

		} else {
			XtextEmbeddedEditor embeddedEditor = new XtextEmbeddedEditor(graphicalEditPart, getInjector());
			embeddedEditor.showEditor();
		}
	}

	private boolean NotHaveMacrosAndPredicates(Constraint object) {
		if ((object.getMacro() == null && object.getPredicates() == null) ||
				object.eContents().isEmpty())
			return true;
		
		return false;			
	}

	/**
	 * Return the injector associated to you domain model plug-in.
	 * 
	 * @return
	 */
	protected abstract Injector getInjector();

	protected IEditorPart getActiveEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		return page.getActiveEditor();
	}

}
