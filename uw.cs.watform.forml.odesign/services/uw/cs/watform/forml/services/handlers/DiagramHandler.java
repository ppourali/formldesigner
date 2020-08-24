package uw.cs.watform.forml.services.handlers;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.ui.tools.internal.actions.refresh.RefreshDiagramAction;
import org.eclipse.sirius.diagram.ui.tools.internal.part.SiriusDiagramGraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.DistanceBasedRanking.ClassDiagramRelationsMap;
import uw.cs.watform.forml.services.keyboard.DiagramKeyHandler;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

/**
 * This is a diagram handler that assigns key handler and resource set listener
 * to the diagram edit parts.
 * 
 * 
 * @author ppourali
 * 
 */
@SuppressWarnings("restriction")
public class DiagramHandler {

	public DiagramHandler() {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener2() {
				@Override
				public void partVisible(IWorkbenchPartReference partRef) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partOpened(IWorkbenchPartReference partRef) {
					IEditorPart editorPart = partRef.getPage().getActiveEditor();
					if (editorPart != null && editorPart instanceof DiagramEditor) {
						if (editorPart instanceof DiagramEditor) {
							DiagramEditPart diagramEditPart = ((DiagramEditor) editorPart).getDiagramEditPart();
							
							if (diagramEditPart==null)
								return;
										
							if (ModelUtils.WORLD_MODEL == null) {
								if (diagramEditPart.getModel() instanceof Diagram) {
									Diagram diagram = ((Diagram) diagramEditPart.getModel());
									if (diagram.getElement() instanceof DSemanticDiagramSpec) {
										DSemanticDiagramSpec element = (DSemanticDiagramSpec) diagram.getElement();

										ModelUtils.setWorldModel(element.getTarget());
									}
								}
							}
							AddResourceSetListener(editorPart);

							// AddEditPartListener(diagramEditPart);
						}
					}

				}

				@Override
				public void partInputChanged(IWorkbenchPartReference partRef) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partHidden(IWorkbenchPartReference partRef) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partDeactivated(IWorkbenchPartReference partRef) {
					IEditorPart editorPart = partRef.getPage().getActiveEditor();

					if (editorPart != null && editorPart.isDirty()) {
						editorPart.doSave(new NullProgressMonitor());
						// System.out.println("saved");
					}

				}

				@Override
				public void partClosed(IWorkbenchPartReference partRef) {

				}

				@Override
				public void partBroughtToTop(IWorkbenchPartReference partRef) {
					IEditorPart editorPart = partRef.getPage().getActiveEditor();
					if (editorPart != null && editorPart instanceof DiagramEditor) {
						if (editorPart instanceof DiagramEditor) {
							DiagramEditPart diagramEditPart = ((DiagramEditor) editorPart).getDiagramEditPart();
							diagramEditPart.refresh();
						}
					}
				}

				@Override
				public void partActivated(IWorkbenchPartReference partRef) {
					IEditorPart editorPart = partRef.getPage().getActiveEditor();
					if (editorPart != null && editorPart instanceof DiagramEditor) {
						if (editorPart instanceof DiagramEditor) {
							DiagramEditPart diagramEditPart = ((DiagramEditor) editorPart).getDiagramEditPart();

							SetSemanticModelRequirements(diagramEditPart);

							// AddEditPartListener(diagramEditPart);

							EditPartViewer viewer = diagramEditPart.getViewer();
							if (viewer instanceof SiriusDiagramGraphicalViewer) {
								DiagramKeyHandler keyHandler = new DiagramKeyHandler(partRef);
							}

						}

						if (ModelUtils.WORLD_MODEL != null) {

							AddResourceSetListener(editorPart);

						}

						if (editorPart != null) {
							RepresentationsUtils.RunVaidation(editorPart);
						}
					}

				}
			});
		}

		catch (Exception e) {

		}

	}

	// adds edit part listener to the diagram
	protected void AddEditPartListener(DiagramEditPart diagramEditPart) {
		diagramEditPart.addEditPartListener(new CustomEditPartListener());
	}

	// adds resource set listener to the diagram
	protected void AddResourceSetListener(IEditorPart editorPart) {
		try {
			TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(null))
					.addResourceSetListener(new CustomResourceSetChangeListener(editorPart));
		} catch (Exception e) {

		}
	}

	// make sure that the world and behavioral models always have one constraint
	// object
	private void SetSemanticModelRequirements(DiagramEditPart diagramEditPart) {

		try {
			if (((DSemanticDiagramSpec) (((View) diagramEditPart.getModel()).getElement()))
					.getTarget() instanceof WorldModel) {
				WorldModel wm = (WorldModel) (((DSemanticDiagramSpec) (((View) diagramEditPart.getModel())
						.getElement())).getTarget());

				if (wm != null) {
					ModelUtils.setSystemWorldBehaviour(wm);
				}
			} else if (((DSemanticDiagramSpec) (((View) diagramEditPart.getModel()).getElement()))
					.getTarget() instanceof FeatureModule) {
				FeatureModule fm = (FeatureModule) (((DSemanticDiagramSpec) (((View) diagramEditPart.getModel())
						.getElement())).getTarget());

				if (fm != null) {
					ModelUtils.setSystemWorldBehaviour(fm);
				}
			}

			CreateConstraints(diagramEditPart);
		} catch (Exception e) {
			java.lang.System.err.println("DiagramHandler Class:" + diagramEditPart);
		}
	}

	// create constraints the wm and bm if not already there
	private void CreateConstraints(DiagramEditPart diagramEditPart) {
		TransactionalEditingDomain editingDomain = diagramEditPart.getEditingDomain();
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				ModelUtils.CreateConstraints(null);
			}
		});

	}

}
