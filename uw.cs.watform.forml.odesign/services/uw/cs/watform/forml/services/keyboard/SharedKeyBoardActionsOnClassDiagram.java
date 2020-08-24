package uw.cs.watform.forml.services.keyboard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeList2EditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListElementEditPart;
import org.eclipse.sirius.diagram.ui.tools.api.util.EditPartTools;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * 
 * Handles the actions for class diagram keyboard hits.
 * 
 * @author ppourali
 */
@SuppressWarnings("restriction")
public final class SharedKeyBoardActionsOnClassDiagram {

	public static void createInputMessage(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		for (EObject selectedFeature : findSemanticContainers(viewer, parentDiagramEditPart)) {
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					if (selectedFeature instanceof Feature) {
						Feature f = (Feature) selectedFeature;
						// TODO: this might need to be the same message for all
						// the selected features
						Input newMessage = FormlFactory.eINSTANCE.createInput();
						ModelOperations.addNewInputMessageToFeature(f, newMessage, "");
					}
				}
			});

		}
	}

	private static List<EObject> findSemanticContainers(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		List<EObject> selectedContainers = new ArrayList<EObject>();

		if (viewer.getSelectedEditParts() != null) {
			if (viewer.getSelectedEditParts().size() == 0)
				return selectedContainers; // return empty list

			for (Object c : viewer.getSelectedEditParts()) {
				if (c != null && c instanceof DNodeContainerEditPart) {
					EObject f = findAssociatedSemanticContainer((DNodeContainerEditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}

				else if (c != null && c instanceof DNodeList2EditPart) {
					EObject f = findAssociatedSemanticContainer((DNodeList2EditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				} else if (c != null && c instanceof DNodeListElementEditPart) {
					EObject f = findAssociatedSemanticContainer((DNodeListElementEditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				} else if (c != null && c instanceof DNodeListEditPart) {
					EObject f = findAssociatedSemanticContainer((DNodeListEditPart) c);
					if (f != null) {
						if (!selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}
			}
		}

		return selectedContainers;
	}

	private static EObject findAssociatedSemanticContainer(EditPart c) {
		DNodeContainerEditPart parentFeatureContainer = (EditPartTools.getParentOfType(c,
				DNodeContainerEditPart.class));
		// if feature selected or any of feature parts are selected
		if (parentFeatureContainer != null) {
			if (parentFeatureContainer.getModel() instanceof View) {
				View v = (View) (parentFeatureContainer.getModel());
				if (v.getElement().eCrossReferences().get(0) instanceof Feature)
					return (Feature) v.getElement().eCrossReferences().get(0);
				else if (v.getElement().eCrossReferences().get(0) instanceof Entity)
					return (Entity) v.getElement().eCrossReferences().get(0);
			}
		} else {
			// if entity container selected
			if (c instanceof DNodeListEditPart) {
				if (c.getModel() instanceof View) {
					View v = (View) (c.getModel());

					if (v.getElement().eCrossReferences().get(0) instanceof Entity)
						return (Entity) v.getElement().eCrossReferences().get(0);
				}
			}
			// if entity container's attribute selected
			else if (c instanceof DNodeListElementEditPart) {
				DNodeListEditPart parentEntityContainer = (EditPartTools.getParentOfType(c, DNodeListEditPart.class));
				if (parentEntityContainer != null) {
					if (parentEntityContainer.getModel() instanceof View) {
						View v = (View) (parentEntityContainer.getModel());
						if (v.getElement().eCrossReferences().get(0) instanceof Entity)
							return (Entity) v.getElement().eCrossReferences().get(0);
					}
				}

			}
		}
		return null;
	}

	public static void createFeature(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {

		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				// WorldModel wm=(WorldModel)
				// (((DSemanticDiagramSpec)(((View)parentDiagramEditPart.getModel()).getElement())).getTarget());
				//
				// //if(wm!=null)
				// //ModelUtils.setWorldModel(wm);
				//
				// Feature newFeature=FormlFactory.eINSTANCE.createFeature();
				//
				// int autoincrementForName=
				// ModelUtils.getWorldModelObjectsByType(newFeature,
				// Feature.class).size();
				//
				// String newName="F"+String.valueOf(autoincrementForName);
				//
				// while(! NameUniquenessVerifier.verify(newFeature, newName,
				// false))
				// {
				// autoincrementForName++;
				// newName="F"+String.valueOf(autoincrementForName);
				// }
				// newFeature.setName(newName);
				//
				// ModelOperations.addNewFeatureToWorldModel(wm, newFeature);

				ModelOperations.CreateNewFeature(null);

			}
		});

	}

	public static void createOutputMessage(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		for (EObject selectedFeature : findSemanticContainers(viewer, parentDiagramEditPart)) {
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					if (selectedFeature instanceof Feature) {
						Feature f = (Feature) selectedFeature;
						// TODO: this might need to be the same message for all
						// the selected features
						Output newMessage = FormlFactory.eINSTANCE.createOutput();
						ModelOperations.addNewOutputMessageToFeature(f, newMessage, "");
					}
				}
			});

		}
	}

	public static void createAttribute(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		for (EObject selectedContainer : findSemanticContainers(viewer, parentDiagramEditPart)) {
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();// TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					if (selectedContainer instanceof Feature) {
						Feature f = (Feature) selectedContainer;
						// TODO: this might need to be the same message for all
						// the selected features
						// Attribute
						// newAttribute=FormlFactory.eINSTANCE.createAttribute();
						// ModelOperations.addNewAttributeToFeature(f,
						// newAttribute);
						ModelOperations2.CreateNewAttribute(f, "");
					} else if (selectedContainer instanceof Entity) {
						Entity e = (Entity) selectedContainer;
						// TODO: this might need to be the same message for all
						// the selected features
						// Attribute
						// newAttribute=FormlFactory.eINSTANCE.createAttribute();
						// ModelOperations.addNewAttributeToEntity(e,
						// newAttribute);
						ModelOperations2.CreateNewAttribute(e, "");
					}
				}
			});
		}
	}

	public static void createEntity(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				// WorldModel wm = (WorldModel) (((DSemanticDiagramSpec) (((View)
				// parentDiagramEditPart.getModel())
				// .getElement())).getTarget());

				EObject refEObj = (((DSemanticDiagramSpec) (((View) parentDiagramEditPart.getModel()).getElement()))
						.getTarget());
				// if(wm!=null)
				// ModelUtils.setWorldModel(wm);
				if (refEObj != null)
					ModelOperations.CreateNewEntity(refEObj, null);
			}
		});

	}

}
