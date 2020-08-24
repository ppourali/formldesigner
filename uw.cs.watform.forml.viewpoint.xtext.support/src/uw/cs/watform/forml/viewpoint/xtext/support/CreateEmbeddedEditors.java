package uw.cs.watform.forml.viewpoint.xtext.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.ui.internal.FormlActivator;

public final class CreateEmbeddedEditors {

	public static boolean isOpen = false;

	private CreateEmbeddedEditors() {

	}

	// private static XtextResource createVirtualXtextResource(URI uri, EObject
	// semanticElement) throws IOException {
	// IResourceFactory resourceFactory =
	// FormlActivator.getInstance().getInjector("uw.cs.watform.forml.Forml").getInstance(IResourceFactory.class);
	// // TODO use the synthetic scheme.
	// XtextResourceSet rs =
	// FormlActivator.getInstance().getInjector("uw.cs.watform.forml.Forml").getInstance(XtextResourceSet.class);
	// rs.setClasspathURIContext(getClass());
	// // Create virtual resource
	// XtextResource xtextVirtualResource = (XtextResource) resourceFactory
	// .createResource(URI.createURI(uri.toString()));
	// rs.getResources().add(xtextVirtualResource);
	//
	// // Populate virtual resource with the given semantic element to edit
	// xtextVirtualResource.getContents().add(semanticElement);
	//
	// // Save and reparse in order to initialize virtual Xtext resource
	// ByteArrayOutputStream out = new ByteArrayOutputStream();
	// xtextVirtualResource.save(out,
	// SaveOptions.newBuilder().format().getOptions().toOptionsMap());
	// xtextVirtualResource.reparse(new String(out.toByteArray()));
	//
	// return xtextVirtualResource;
	// }

	public static void runFormViewTransitionEditor(DiagramEditPart diagramEditPart, Injector injector, EObject o) {
		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Transition trans = ((Transition) o);

				final frmShellForTransitionLabel shellContainer = new frmShellForTransitionLabel(trans, display);
				shellContainer.ConfirmFlag = false;

				String transitionName = trans.getName();
				shellContainer.txtEid.setText(transitionName);

				// Create Editor For the Whole Transition
				XtextEmbeddedEditorForTransition transition_embeddedEditor = new XtextEmbeddedEditorForTransition(
						diagramEditPart, injector);
				transition_embeddedEditor.shellContainer = shellContainer;
				transition_embeddedEditor.showEditor(trans, diagramEditPart, shellContainer.txtTransitionComposite);

				// Create Editor For WCE
				XtextEmbeddedEditorForWCE wce_embeddedEditor = new XtextEmbeddedEditorForWCE(diagramEditPart, injector);
				wce_embeddedEditor.shellContainer = shellContainer;
				if (trans.getTrig() == null) {
					wce_embeddedEditor.showEditorIfNull(trans, diagramEditPart, shellContainer.txtWCE);
				} else
					wce_embeddedEditor.showEditor(trans.getTrig(), diagramEditPart, shellContainer.txtWCE);

				// Create Editor For Guard
				XtextEmbeddedEditorForGuard guard_embeddedEditor = new XtextEmbeddedEditorForGuard(diagramEditPart,
						injector);
				guard_embeddedEditor.shellContainer = shellContainer;
				if (trans.getGuard() == null) {
					Guard newGuard = FormlFactory.eINSTANCE.createGuard();
					trans.setGuard(newGuard);
				}
				guard_embeddedEditor.showEditor(trans.getGuard(), diagramEditPart, shellContainer.txtGuard);

				// Create Editor For WCA
				XtextEmbeddedEditorForWCA wca_embeddedEditor = new XtextEmbeddedEditorForWCA(diagramEditPart, injector);
				wca_embeddedEditor.shellContainer = shellContainer;
				if (trans.getList() == null) {
					WCAList newWCAList = FormlFactory.eINSTANCE.createWCAList();
					trans.setList(newWCAList);
					wca_embeddedEditor.showEditor(trans.getList(), diagramEditPart, shellContainer.txtWCA, 1);
				} else {
					// for(Modifiable action:trans.getList().getActions()){
					wca_embeddedEditor.showEditor(trans.getList(), diagramEditPart, shellContainer.txtWCA, 1);
					// wca_embeddedEditor.showEditor(action,
					// diagramEditPart,shellContainer.txtWCA,trans.getList().getActions().size());
					// }
				}

				isOpen = true;
				shellContainer.editor_Transition = transition_embeddedEditor;
				shellContainer.editor_WCE = wce_embeddedEditor;
				shellContainer.editor_Guard = guard_embeddedEditor;
				shellContainer.editor_WCA = wca_embeddedEditor;
				shellContainer.open();
				isOpen = false;

				// System.out.println(trans.eResource().getURIFragment(trans));
				// System.out.println(trans.eResource().getURIFragment(trans));

				if (transition_embeddedEditor.confirmFlag) {
					if (transition_embeddedEditor.changedElement != null) {
						trans.setTrig((((Transition) transition_embeddedEditor.changedElement)).getTrig());
						trans.setGuard((((Transition) transition_embeddedEditor.changedElement)).getGuard());
						trans.setList((((Transition) transition_embeddedEditor.changedElement)).getList());
					} else if (transition_embeddedEditor.isChanged) {
						EcoreUtil.delete(trans);
					}
				} else if (shellContainer.ConfirmFlag || wce_embeddedEditor.confirmFlag
						|| guard_embeddedEditor.confirmFlag || wca_embeddedEditor.confirmFlag) {
					if (wce_embeddedEditor.changedElement != null) {
						if (wce_embeddedEditor.changedElement instanceof Trigger)
							trans.setTrig((Trigger) wce_embeddedEditor.changedElement);
						else if (wce_embeddedEditor.changedElement instanceof Transition)
							trans.setTrig(((Transition) wce_embeddedEditor.changedElement).getTrig());
					} else if (wce_embeddedEditor.isChanged) {
						EcoreUtil.delete(trans.getTrig());
					}

					if (guard_embeddedEditor.changedElement != null) {
						trans.setGuard((Guard) guard_embeddedEditor.changedElement);
					} else if (guard_embeddedEditor.isChanged) {
						EcoreUtil.delete(trans.getGuard());
					}
					if (trans.getGuard() != null && trans.getGuard().getPredicate() == null) {
						EcoreUtil.delete(trans.getGuard());
					}

					if (wca_embeddedEditor.changedElement != null) {
						try {
							if (!wca_embeddedEditor.xtextResource.getEObject(wca_embeddedEditor.semanticElementFragment)
									.equals(trans.getList()))
								trans.setList((WCAList) wca_embeddedEditor.changedElement);
						} catch (Exception e) {

						}
					} else if (wca_embeddedEditor.isChanged) {
						EcoreUtil.delete(trans.getList());
					}
				}

			}
		});
	}

	// When user single clicks on the transition label
	public static void runImmidiateTransitionEditor(Injector injector, EObject o) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Transition trans = ((Transition) o);

				final frmShellForTransitionLabel shellContainer = new frmShellForTransitionLabel(trans, display);

				String transitionName = trans.getName();
				shellContainer.txtEid.setText(transitionName);

				// Create Editor For the Whole Transition
				XtextEmbeddedEditorForTransition transition_embeddedEditor = new XtextEmbeddedEditorForTransition(null,
						injector);
				transition_embeddedEditor.shellContainer = shellContainer;
				transition_embeddedEditor.showEditor(trans, null, shellContainer.txtTransitionComposite);

				isOpen = true;
				shellContainer.open();
				isOpen = false;

			}
		});
	}

}